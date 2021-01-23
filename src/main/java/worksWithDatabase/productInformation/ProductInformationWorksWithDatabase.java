package worksWithDatabase.productInformation;

import beans.productAdmin.ProductAdmin;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductInformationWorksWithDatabase {

    public ProductInformationWorksWithDatabase() {
    }

    public void fillInformationProduct(List<ProductAdmin> products) {
        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT thong_tin FROM thong_tin_sp WHERE ma_sp = ?");

            for (ProductAdmin productAdmin : products) {
                preparedStatement.setString(1, productAdmin.getMa_sp());
                ResultSet resultSet = preparedStatement.executeQuery();
                List<String> information = new ArrayList<String>();
                while (resultSet.next()) {
                    information.add(resultSet.getString("thong_tin"));
                }
                resultSet.close();
                productAdmin.setThong_tin_sp(information);
            }

            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
    }

    //  Phương thức nhận vô ma_sp, ma_mau,ma_size  chuyển trạng thái tồn tại 1->0
    public boolean removeInformationProduct(String ma_sp, String ma_mau, String ma_size) {
        Connection connection = DataSource.getInstance().getConnection();

        boolean result = false;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE thong_tin_chi_tiet_sp SET ton_tai = ? WHERE ma_sp = ? AND ma_mau = ? AND ma_size = ? AND ton_tai = 1");
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, ma_sp);
            preparedStatement.setString(3, ma_mau);
            preparedStatement.setString(4, ma_size);
            int row = preparedStatement.executeUpdate();

            if (row == 1) result = true;
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return result;
    }

    //  Phương thức nhận vô ma_sp, ma_mau,ma_size dang list  chuyển trạng thái tồn tại 1->0
    public int removeInformationProduct(String[] danh_sach) {
        Connection connection = DataSource.getInstance().getConnection();

        int result = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE thong_tin_chi_tiet_sp SET ton_tai = ? WHERE ma_sp = ? AND ma_mau = ? AND ma_size = ? AND ton_tai = 1");
            for (String s : danh_sach) {
                String[] array = s.split(":");
                String ma_sp = array[0];
                String ma_mau = array[1];
                String ma_size = array[2];
                preparedStatement.setInt(1, 0);
                preparedStatement.setString(2, ma_sp);
                preparedStatement.setString(3, ma_mau);
                preparedStatement.setString(4, ma_size);
                int row = preparedStatement.executeUpdate();
                result += row;
            }
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return result;
    }

}
