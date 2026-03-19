package string;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.StringJoiner;

public class FormattingString {
    public static final String PATTERN_DATE = "yyyy-MM-dd";
    public static final DateTimeFormatter MYSQL_DATE_FORMATTER = DateTimeFormatter.ofPattern(PATTERN_DATE);

    public static void main(String[] args) {
        formatString(Set.of(111L,222L), LocalDate.now().minusDays(1), LocalDate.now());
    }

    private static void formatString(
            Set<Long> distributionIds,
            LocalDate startDate,
            LocalDate finishDate
    ) {
        final String sql = "SELECT " +
                "a.sender, " +
                "a.abonent, " +
                "a.transport_alias, " +
                "a.traffic_type, " +
                "a.direction, " +
                "a.delivery_channel_type_id, " +
                "SUM(a.pending_count + a.rejected_count + a.delivered_count + a.accepted_count) " +
                "FROM (%s) " + // подзапросы
                "GROUP BY a.sender, a.abonent, a.transport_alias, a.traffic_type, a.direction, a.delivery_channel_type_id;";

        // -- вложенные запросы
        final String sqlFrom = "%nSELECT * FROM %s dm %s%n"; // название таблицы и WHERE
        final String sqlWhere = String.format("WHERE dm.`delivery_channel_type_id` <> -1 " +
                        "AND (dm.add_date >= '%s' and dm.add_date < '%s') ",
                MYSQL_DATE_FORMATTER.format(startDate), MYSQL_DATE_FORMATTER.format(finishDate)
        );
        final StringJoiner innerSelect = new StringJoiner(" UNION ALL ");
        distributionIds.forEach(id -> innerSelect.add(String.format(sqlFrom, generateTableName(id), sqlWhere)));

        // -- выполнить

        System.out.printf(sql, innerSelect);
    }

    public static String generateTableName(long distributionId) {
        return String.format("distribution_messages_%d", distributionId);
    }

}
