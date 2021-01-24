package worksWithDatabase.color;

import beans.productAdmin.ProductAdmin;
import beans.productAdmin.ProductAdminColor;
import beans.productAdmin.ProductAdminColorAdd;
import connectionDatabase.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ColorWorksWithDatabase {

    public ColorWorksWithDatabase() {

    }

    public void fillNameAndImgColorListProductAdmin(List<ProductAdmin> products) {

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM mau WHERE ma_mau = ?");
            for (ProductAdmin productAdmin : products) {
                for (ProductAdminColor productAdminColor : productAdmin.getDanh_sach_mau()) {
                    preparedStatement.setString(1, productAdminColor.getMa_mau());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    resultSet.next();
                    productAdminColor.setTen_mau(resultSet.getString("ten_mau"));
                    productAdminColor.setHinh_anh_mau(resultSet.getString("link_hinh_anh"));
                    resultSet.close();
                }
            }
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    public List<ProductAdminColorAdd> getAllColor() {

        List<ProductAdminColorAdd> result = new ArrayList<ProductAdminColorAdd>();

        Connection connection = DataSource.getInstance().getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mau");
            while (resultSet.next()) {
                ProductAdminColorAdd productAdminColorAdd = new ProductAdminColorAdd();
                productAdminColorAdd.setHinh_anh_mau(resultSet.getString("link_hinh_anh"));
                productAdminColorAdd.setMa_mau(resultSet.getString("ma_mau"));
                productAdminColorAdd.setTen_mau(resultSet.getString("ten_mau"));
                result.add(productAdminColorAdd);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return result;
    }

    //  Phương thức lấy mã màu tiéptheo
    public String getNextId() {

        String result = "";
        Connection connection = DataSource.getInstance().getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(ma_mau) AS so_luong FROM mau");
            resultSet.next();
            result = "mau_" + (resultSet.getInt("so_luong") + 1);
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return result;

    }

    //   phuong thuc them vo csdl
    public boolean addToDatabase(String ma_mau, String ten_mau, String link_hinh_anh) {

        boolean result = false;
        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mau VALUES (?,?,?)");
            preparedStatement.setString(1, ma_mau);
            preparedStatement.setString(2, ten_mau);
            preparedStatement.setString(3, link_hinh_anh);
            int row = preparedStatement.executeUpdate();
            if (row == 1) result = true;
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return result;
    }

}
