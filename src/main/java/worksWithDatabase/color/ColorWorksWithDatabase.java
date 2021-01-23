package worksWithDatabase.color;

import beans.productAdmin.ProductAdmin;
import beans.productAdmin.ProductAdminColor;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ColorWorksWithDatabase {

    public ColorWorksWithDatabase(){

    }

    public void fillNameAndImgColorListProductAdmin(List<ProductAdmin> products){

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM mau WHERE ma_mau = ?");
            for(ProductAdmin productAdmin : products){
                for(ProductAdminColor productAdminColor : productAdmin.getDanh_sach_mau()){
                preparedStatement.setString(1,productAdminColor.getMa_mau());
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



}
