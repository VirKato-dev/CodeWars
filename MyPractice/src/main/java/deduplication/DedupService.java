package deduplication;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Сервис хранения исторической информации о связанных mdm-id.
 */
public class DedupService {

    private static class MdmRelation {
        Long mdm_id;
        Long actual_mdm_id;
        LocalDate start_date;
        LocalDate end_date;

        MdmRelation(Long mdm_id, Long actual_mdid, LocalDate start_date, LocalDate end_date) {
            this.mdm_id = mdm_id;
            this.actual_mdm_id = actual_mdid;
            this.start_date = start_date;
            this.end_date = end_date;
        }
    }


    private static final String DB = "deduplication";
    private static final String TABLE = "mdm_relations";


    public static void main(String[] args) {
        try (var conn = DriverManager.getConnection("jdbc:h2:mem:" + DB, null, null)) {
            conn.setAutoCommit(true);

            createTable(conn);

            // Дедублицированные
            insertData(conn, new MdmRelation(0L, null, LocalDate.now().minusMonths(3), null));
            insertData(conn, new MdmRelation(1L, 2L, LocalDate.now().minusMonths(3), LocalDate.now().minusMonths(2)));
            insertData(conn, new MdmRelation(2L, null, LocalDate.now().minusMonths(1), null));

            System.out.println("\nInitialization");
            findAll(conn);

            System.out.println("\nAfter deduplication 2 -> 3");
            // Дедубликация новая
            dedup(conn, 2L, 3L);
            findAll(conn);

            System.out.println("\nBy MDM");
            findByMdm(conn, 0L);
            findByMdm(conn, 2L);

            System.out.println("\nMDM:3 On actual date: " + LocalDate.now());
            findByMdmOnDate(conn, 3L, LocalDate.now());

            System.out.println("\nMDM:2 On actual date: " + LocalDate.now());
            findByMdmOnDate(conn, 2L, LocalDate.now());

            System.out.println("\nMDM:0 On actual date: " + LocalDate.now());
            findByMdmOnDate(conn, 0L, LocalDate.now());

            System.out.println("\nMDM:2 On date in past: " + LocalDate.now().minusMonths(1));
            findByMdmOnDate(conn, 2L, LocalDate.now().minusMonths(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param conn
     * @param mdm_id      в прошлом
     * @param actual_mdid новый
     * @throws SQLException
     */
    private static void dedup(Connection conn, Long mdm_id, Long actual_mdid) throws SQLException {
        conn.setAutoCommit(false);

        // новый актуальный MDM
        insertData(conn, new MdmRelation(actual_mdid, null, LocalDate.now(), null));

        // обновить отношение
        var sql1 = "UPDATE " + TABLE + " SET actual_mdm_id = ? " +
                "WHERE actual_mdm_id = ? OR mdm_id = ?;";
        var stmt1 = conn.prepareStatement(sql1);
        stmt1.setLong(1, actual_mdid);
        stmt1.setLong(2, mdm_id);
        stmt1.setLong(3, mdm_id);
        var result = stmt1.executeUpdate();
        System.out.println("Обновлены отношения: " + result);

        // обновить дату ранее актуального MDM
        var sql2 = "UPDATE " + TABLE + " SET end_date = now() " +
                "WHERE actual_mdm_id = ? AND end_date IS NULL;";
        var stmt2 = conn.prepareStatement(sql2);
        stmt2.setLong(1, actual_mdid);
        result = stmt2.executeUpdate();
        System.out.println("Обновлена дата: " + result);

        conn.commit();
        conn.setAutoCommit(true);
    }


    private static void createTable(Connection conn) throws SQLException {
        var sql = "CREATE TABLE " + TABLE + " (" +
                "mdm_id BIGINT PRIMARY KEY, " +
                "actual_mdm_id BIGINT, " +
                "start_date DATE, " +
                "end_date DATE" +
                ");";
        conn.createStatement().execute(sql);
    }


    private static void insertData(Connection conn, MdmRelation data) throws SQLException {
        var sql = "INSERT INTO " + TABLE + " (mdm_id, actual_mdm_id, start_date, end_date) VALUES (?,?,?,?)";
        var stmt = conn.prepareStatement(sql);
        stmt.setLong(1, data.mdm_id); // required
        stmt.setObject(2, data.actual_mdm_id, JDBCType.BIGINT); // nullable
        stmt.setDate(3, Date.valueOf(data.start_date)); // required
        Date date = null;
        if (data.end_date != null) {
            date = Date.valueOf(data.end_date);
        }
        stmt.setObject(4, date, JDBCType.DATE); // nullable

        stmt.executeUpdate();
    }


    private static void findAll(Connection conn) throws SQLException {
        var sql = "SELECT * FROM " + TABLE;
        var stmt = conn.prepareStatement(sql);
        var result = stmt.executeQuery();
        showHeader();
        while (result.next()) {
            showResult(result);
        }
    }

    private static void findByMdm(Connection conn, Long mdm) throws SQLException {
        var sql = "SELECT * FROM " + TABLE + " WHERE mdm_id = ?;";
        var stmt = conn.prepareStatement(sql);
        stmt.setLong(1, mdm);

        var result = stmt.executeQuery();
        showHeader();
        while (result.next()) {
            showResult(result);
        }
    }


    private static void findByMdmOnDate(Connection conn, Long mdm, LocalDate onDate) throws SQLException {
        var sql = "SELECT * FROM " + TABLE +
                " WHERE (? IN (mdm_id, actual_mdm_id) " +
                "OR (SELECT actual_mdm_id FROM " + TABLE + " WHERE mdm_id = ? AND actual_mdm_id IS NOT NULL) IN (actual_mdm_id,mdm_id)" +
                ") AND start_date <= ?;";
        var stmt = conn.prepareStatement(sql);
        stmt.setLong(1, mdm);
        stmt.setLong(2, mdm);
        stmt.setObject(3, Date.valueOf(onDate), JDBCType.DATE);

        var result = stmt.executeQuery();
        showHeader();
        while (result.next()) {
            showResult(result);
        }
    }


    private static void showHeader() {
        System.out.printf("%5s\t%5s\t%s\t%s\n", "mdm", "actual", "start_date", "end_date");
    }

    private static void showResult(ResultSet rs) throws SQLException {
        System.out.printf("%5d\t%5d\t%s\t%s\n",
                rs.getLong("mdm_id"),
                rs.getObject("actual_mdm_id", Long.class),
                rs.getObject("start_date", Date.class),
                rs.getObject("end_date", Date.class)
        );
    }

}
