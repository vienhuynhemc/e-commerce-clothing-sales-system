package worksWithDatabase.size;

import beans.productAdmin.ProductAdmin;
import beans.productAdmin.ProductAdminColor;
import beans.productAdmin.ProductAdminSize;
import beans.productAdmin.ProductAdminSizeAdd;
import connectionDatabase.DataSource;

import javax.xml.crypto.Data;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SizeWorksWithDatabase {

    public SizeWorksWithDatabase() {

    }

    public void fillNameSize(List<ProductAdmin> products) {

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ten_size FROM size WHERE ma_size = ?");

            for (ProductAdmin productAdmin : products) {
                for (ProductAdminColor productAdminColor : productAdmin.getDanh_sach_mau()) {
                    for(ProductAdminSize productAdminSize : productAdminColor.getDanh_sach_size()){
                        preparedStatement.setString(1,productAdminSize.getId());
                        ResultSet resultSet = preparedStatement.executeQuery();
                        resultSet.next();
                        productAdminSize.setName(resultSet.getString("ten_size"));
                        resultSet.close();
                    }
                }
            }
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);

    }

    public List<ProductAdminSizeAdd> getAllSize(){

        List<ProductAdminSizeAdd> result = new ArrayList<ProductAdminSizeAdd>();

        Connection connection = DataSource.getInstance().getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM size");

            while(resultSet.next()){
                ProductAdminSizeAdd productAdminSizeAdd = new ProductAdminSizeAdd();
                productAdminSizeAdd.setId(resultSet.getString("ma_size"));
                productAdminSizeAdd.setName(resultSet.getString("ten_size"));
                result.add(productAdminSizeAdd);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

        return result;

    }


}
