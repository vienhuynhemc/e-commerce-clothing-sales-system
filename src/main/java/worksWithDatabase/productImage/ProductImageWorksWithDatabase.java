package worksWithDatabase.productImage;

import beans.productAdmin.ProductAdmin;
import beans.productAdmin.ProductAdminColor;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductImageWorksWithDatabase {

    public ProductImageWorksWithDatabase(){

    }

    public void fileLinkHinhAnhListProduct(List<ProductAdmin> products){

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT link_hinh_anh FROM hinh_anh_sp WHERE ma_sp = ? AND ma_mau = ?");

            for(ProductAdmin productAdmin : products) {
                for (ProductAdminColor productAdminColor : productAdmin.getDanh_sach_mau()) {
                    preparedStatement.setString(1,productAdmin.getMa_sp());
                    preparedStatement.setString(2,productAdminColor.getMa_mau());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    List<String> link = new ArrayList<String>();
                    while(resultSet.next()){
                        link.add(resultSet.getString("link_hinh_anh"));
                    }
                    productAdminColor.setLink_hinh_anh(link);
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
