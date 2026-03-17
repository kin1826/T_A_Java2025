package DBCON;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    private static Connection connection;

    // Hàm lấy connection (Singleton)
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver"); // Load driver

                connection = DriverManager.getConnection(URL, USER, PASSWORD);

                System.out.println("✔ Kết nối MySQL thành công");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("✖ Không tìm thấy MySQL Driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("✖ Kết nối MySQL thất bại");
            e.printStackTrace();
        }
        return connection;
    }

    // Hàm đóng kết nối
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("✔ Đã đóng kết nối MySQL");
            }
        } catch (SQLException e) {
            System.out.println("✖ Lỗi khi đóng kết nối");
            e.printStackTrace();
        }
    }
}

 class TestConnect {
    public static void main(String[] args) {
        Connection conn = DBConnect.getConnection();

        if (conn != null) {
            System.out.println(">> Kết nối hoạt động tốt!");
        }

        DBConnect.closeConnection();
    }
}