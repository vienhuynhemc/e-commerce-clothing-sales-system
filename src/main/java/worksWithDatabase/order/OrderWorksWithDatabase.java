package worksWithDatabase.order;

import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderWorksWithDatabase {

    public OrderWorksWithDatabase(){
    }

    //  Phương thứcn nhân vô mã admin kiểm tra số đơn hàng đã được admin này duyệt
    public int getOrderApprovalByIdAdmin(String ma_admin){

        Connection connection = DataSource.getInstance().getConnection();
        int result = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(ma_admin) AS so_luong FROM don_hang WHERE ma_admin = ?");
            preparedStatement.setString(1,ma_admin);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            result = resultSet.getInt("so_luong");
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return result;
    }

}
