package a.database.inmemoty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <dependency>
 * <groupId>com.h2database</groupId>
 * <artifactId>h2</artifactId>
 * <version>2.1.214</version>
 * </dependency>
 * <a href="https://h2database.com/html/features.html#products_work_with">Как использовать H2</a>
 */
public class H2Database {
    public static void main(String[] args) {
        UtilDB.createTable();
    }
}

final class UtilDB {
    private static Connection connect;

    public static Connection getConnection(String db) {
        if (connect != null) return connect;
        try {
            connect = DriverManager.getConnection("jdbc:h2:mem:test_mem" + db, null, null);
            return connect;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * H2 база данных работает в памяти и таблицы нужно создавать каждый раз заново
     */
    public static void createTable() {

    }
}
