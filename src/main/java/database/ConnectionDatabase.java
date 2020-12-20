package database;

import java.sql.*;

public class ConnectionDatabase {

    /* Class này áp dụng mẫu singleton, viết 1 lần - sử dụng mãi mãi */

    // Khai báo connection để sử dụng cho toàn bộ dự án
    private static Connection connection;

    // Phương thức trả về 1 statement được tạo từ connection
    public static Statement createStatement() throws SQLException, ClassNotFoundException {

        // Nếu connection đang ở trạng thái null -> connection chưa được tạo thì
        if (connection == null || connection.isClosed()) {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://b2mp0eqcjjmuc0pzg4rh-mysql.services.clever-cloud.com/b2mp0eqcjjmuc0pzg4rh", "ucgmnuzffqk244q9", "AqvCI2PQ96P77uHtMN2N");
        }

        return connection.createStatement();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Statement s = ConnectionDatabase.createStatement();
        ResultSet res = s.executeQuery("SELECT * FROM sanpham");
        while (res.next()) {
            System.out.println(res.getString(1));
        }

    }


}
