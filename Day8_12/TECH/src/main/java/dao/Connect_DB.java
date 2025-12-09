package dao;

import java.sql.*;

public class Connect_DB {
    Connection con;
    Statement stmt = null;

    public Connect_DB() {
        try {
            String url = "jdbc:mysql://localhost:3306/demo_java";
            String user = "root";
            String password = "1234";

            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //UPDATE INSERT DELETE
    public int executeDB(String query) {
        int result = 0;

        try {
            stmt = con.createStatement();
            result = stmt.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }

    //SELECT
    public ResultSet getDB(String query) {
        ResultSet rs = null;

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rs;
    }
}
