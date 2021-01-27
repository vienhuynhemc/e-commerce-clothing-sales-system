package worksWithDatabase.size;

import beans.productAdmin.*;
import connectionDatabase.DataSource;
import model.size.SizeModel;

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
                    for (ProductAdminSize productAdminSize : productAdminColor.getDanh_sach_size()) {
                        preparedStatement.setString(1, productAdminSize.getId());
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

    public List<ProductAdminSizeAdd> getAllSize() {

        List<ProductAdminSizeAdd> result = new ArrayList<ProductAdminSizeAdd>();

        Connection connection = DataSource.getInstance().getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM size");

            while (resultSet.next()) {
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

    public ProductAdminSizeAdd getProductAdminSizeAddById(String id) {

        ProductAdminSizeAdd productAdminSizeAdd = new ProductAdminSizeAdd();
        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM size WHERE ma_size = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            productAdminSizeAdd.setName(resultSet.getString("ten_size"));
            productAdminSizeAdd.setId(resultSet.getString("ma_size"));
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return productAdminSizeAdd;

    }

    public void fillNameSizeToProductAdminEditSingle(ProductAdminEditSingle productAdminEditSingle) {

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ten_size FROM size WHERE ma_size = ?");
            for (ProductAdminSizeAdd productAdminSizeAdd : productAdminEditSingle.getList_size()) {
                preparedStatement.setString(1, productAdminSizeAdd.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                productAdminSizeAdd.setName(resultSet.getString("ten_size"));
                resultSet.close();
            }
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    public void fillDataProductAdminEditGroup(ProductAdminAdd productAdminEditGroup) {

        Connection connection = DataSource.getInstance().getConnection();

        List<ProductAdminSizeAdd> list = new ArrayList<ProductAdminSizeAdd>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ma_size FROM thong_tin_chi_tiet_sp WHERE ton_tai = ? AND ma_sp = ? GROUP BY ma_size");
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, productAdminEditGroup.getMa_sp());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                ProductAdminSizeAdd productAdminSizeAdd = new ProductAdminSizeAdd();
                productAdminSizeAdd.setId(resultSet.getString("ma_size"));
                PreparedStatement p = connection.prepareStatement("SELECT ten_size FROM size WHERE ma_size = ?");
                p.setString(1,productAdminSizeAdd.getId());
                ResultSet resultSet1 = p.executeQuery();
                resultSet1.next();
                productAdminSizeAdd.setName(resultSet1.getString("ten_size"));
                resultSet1.close();
                p.close();
                list.add(productAdminSizeAdd);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        productAdminEditGroup.setList_size(list);
        DataSource.getInstance().releaseConnection(connection);

    }


}
