package conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection con;

    private Database() {
    }
    public static Connection getConnection() {
        return Database.con;
    }

    public static void connect(String host, int port, String user, String password, String dbName) {
        Database.con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
            Database.con = DriverManager.getConnection(dbURL, user, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void close() throws SQLException {
        if (Database.con != null){
            Database.con.close();
        }
    }


}
