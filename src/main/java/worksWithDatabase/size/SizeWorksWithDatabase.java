package worksWithDatabase.size;

import beans.productAdmin.ProductAdmin;
import beans.productAdmin.ProductAdminColor;
import beans.productAdmin.ProductAdminSize;
import connectionDatabase.DataSource;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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


}
