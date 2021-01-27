package worksWithDatabase.promotionalPrice;

import beans.DateTime;
import beans.productAdmin.ProductAdmin;
import beans.productAdmin.ProductAdminAdd;
import connectionDatabase.DataSource;
import worksWithDatabase.productPrice.ProductPriceWorksWithDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PromotionalPriceWorksWithDatabase {

        public PromotionalPriceWorksWithDatabase(){

    }

    //  Phương thức nhận vô list product điền giá sp cho bó
    public void fillPriceListProductAdmin(List<ProductAdmin> products){

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT gia_km FROM gia_sp_khuyen_mai WHERE ma_sp = ? ORDER BY ngay_cap_nhat DESC LIMIT 0,1");
            for(ProductAdmin productAdmin : products){
                preparedStatement.setString(1,productAdmin.getMa_sp());
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                productAdmin.setGia_khuyen_mai(resultSet.getInt("gia_km"));
                resultSet.close();
            }
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    public void addToDatabse(String ma_sp, int gia_sp, DateTime ngay_cap_nhat){

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO gia_sp_khuyen_mai VALUES(?,?,?)");
            preparedStatement.setString(1,ma_sp);
            preparedStatement.setInt(2,gia_sp);
            preparedStatement.setString(3,ngay_cap_nhat.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    public void fillDataProductAdminEditGroup(ProductAdminAdd productAdminEditGroup){
        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT gia_km FROM gia_sp_khuyen_mai WHERE ma_sp = ? ORDER BY ngay_cap_nhat DESC LIMIT 0,1");
            preparedStatement.setString(1,productAdminEditGroup.getMa_sp());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            productAdminEditGroup.setGia_khuyen_mai(resultSet.getInt("gia_km")+"");
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
    }


}
