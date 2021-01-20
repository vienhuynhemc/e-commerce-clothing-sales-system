package worksWithDatabase.provincial;

import beans.address.Provincial;
import connectionDatabase.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProvincialWorksWithDatabase {

    //  Constructor rỗng không có gì hết
    public ProvincialWorksWithDatabase() {
    }

    //  Phương thức trả về list
    public List<Provincial> getListProvincial() {

        List<Provincial> provincials = new ArrayList<Provincial>();

        Connection connection = DataSource.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT  * FROM tinh_thanh");
            while (resultSet.next()) {
                provincials.add(new Provincial(resultSet.getString("ma_tinh_thanh"), resultSet.getString("ten_tinh_thanh")));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);

        return provincials;

    }

    //  Phuơng thức nhận vô một Provincial điền tên cho nó
    public void fillNameById(Provincial provincial) {

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ten_tinh_thanh FROM tinh_thanh WHERE ma_tinh_thanh = ?");
            preparedStatement.setString(1, provincial.getProvincialId());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            provincial.setProvincialName(resultSet.getString("ten_tinh_thanh"));
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    //  Phương thứuc nhận vô một mã tỉnh, trả về tỉnh đó
    public Provincial getProvincialById(String ma_tinh_thanh) {

        Connection connection = DataSource.getInstance().getConnection();
        Provincial provincial = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tinh_thanh WHERE ma_tinh_thanh = ?");
            preparedStatement.setString(1, ma_tinh_thanh);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            provincial = new Provincial();
            provincial.setProvincialId(resultSet.getString("ma_tinh_thanh"));
            provincial.setProvincialName(resultSet.getString("ten_tinh_thanh"));
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return provincial;
    }


}
