package worksWithDatabase.productImage;

import beans.productAdmin.*;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductImageWorksWithDatabase {

    public ProductImageWorksWithDatabase() {

    }

    public void fileLinkHinhAnhListProduct(List<ProductAdmin> products) {

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT link_hinh_anh FROM hinh_anh_sp WHERE ma_sp = ? AND ma_mau = ?");

            for (ProductAdmin productAdmin : products) {
                for (ProductAdminColor productAdminColor : productAdmin.getDanh_sach_mau()) {
                    preparedStatement.setString(1, productAdmin.getMa_sp());
                    preparedStatement.setString(2, productAdminColor.getMa_mau());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    List<String> link = new ArrayList<String>();
                    while (resultSet.next()) {
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

    public void addToDatbase(String ma_sp, List<ProductAdminColorAddProduct> list) {

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO hinh_anh_sp VALUES(?,?,?,?)");
            for (ProductAdminColorAddProduct productAdminColorAddProduct : list) {
                for (String s : productAdminColorAddProduct.getList_hinh_anh_sp()) {
                    preparedStatement.setString(1, ma_sp);
                    preparedStatement.setString(2, productAdminColorAddProduct.getMa_mau());
                    preparedStatement.setString(3, s);
                    preparedStatement.setInt(4, 0);
                    preparedStatement.executeUpdate();
                }
            }
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    public void editToDatbase(String ma_sp, List<ProductAdminColorAddProduct> list) {

        Connection connection = DataSource.getInstance().getConnection();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO hinh_anh_sp VALUES(?,?,?,?)");
            for (ProductAdminColorAddProduct productAdminColorAddProduct : list) {

                String ma_mau = productAdminColorAddProduct.getMa_mau();
                PreparedStatement preparedStatementt = connection.prepareStatement("DELETE FROM hinh_anh_sp WHERE ma_sp = ? AND ma_mau = ?");
                preparedStatementt.setString(1, ma_sp);
                preparedStatementt.setString(2, ma_mau);
                preparedStatementt.executeUpdate();
                preparedStatementt.close();

                for (String s : productAdminColorAddProduct.getList_hinh_anh_sp()) {
                    preparedStatement.setString(1, ma_sp);
                    preparedStatement.setString(2, productAdminColorAddProduct.getMa_mau());
                    preparedStatement.setString(3, s);
                    preparedStatement.setInt(4, 0);
                    preparedStatement.executeUpdate();
                }
            }
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    public void fillImageByProductAdminEditSingle(ProductAdminEditSingle productAdminEditSingle) {

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT link_hinh_anh FROM hinh_anh_sp WHERE ma_sp = ? AND ma_mau = ?");
            preparedStatement.setString(1, productAdminEditSingle.getMa_sp());
            preparedStatement.setString(2, productAdminEditSingle.getMa_mau());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productAdminEditSingle.getList_hinh_anh_sp().add(resultSet.getString("link_hinh_anh"));
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    public void updateImgProductSingleEdit(String ma_sp, String ma_mau, List<String> list_hinh_anh) {

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM hinh_anh_sp WHERE ma_sp = ? AND ma_mau = ?");
            preparedStatement.setString(1, ma_sp);
            preparedStatement.setString(2, ma_mau);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("INSERT INTO hinh_anh_sp VALUES(?,?,?,?)");
            for (String s : list_hinh_anh) {
                preparedStatement.setString(1, ma_sp);
                preparedStatement.setString(2, ma_mau);
                preparedStatement.setString(3, s);
                preparedStatement.setInt(4, 0);
                preparedStatement.executeUpdate();
            }

            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    public void fillDataProductAdminEditGroup(ProductAdminAdd productAdminAdd) {

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT link_hinh_anh FROM hinh_anh_sp WHERE ma_sp = ? AND ma_mau = ?");
            for (ProductAdminColorAddProduct productAdminColorAddProduct : productAdminAdd.getList_mau_kem_hinh_anh()) {
                List<String> list = new ArrayList<String>();
                preparedStatement.setString(1, productAdminAdd.getMa_sp());
                preparedStatement.setString(2, productAdminColorAddProduct.getMa_mau());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    list.add(resultSet.getString("link_hinh_anh"));
                }
                resultSet.close();
                productAdminColorAddProduct.setList_hinh_anh_sp(list);
            }
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    public void productAdminColorProductAdd(ProductAdminColorAddProduct productAdminColorAddProduct, String ma_sp, List<ProductAdminSizeAdd> listSize){

        Connection connection =  DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT link_hinh_anh FROM hinh_anh_sp WHERE ma_mau = ? AND ma_sp = ?");
            preparedStatement.setString(1,productAdminColorAddProduct.getMa_mau());
            preparedStatement.setString(2,ma_sp);
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean check = false;
            while(resultSet.next()){
                productAdminColorAddProduct.getList_hinh_anh_sp().add(resultSet.getString("link_hinh_anh"));
                check = true;
            }
            resultSet.close();
            if(check){
                preparedStatement = connection.prepareStatement("UPDATE thong_tin_chi_tiet_sp SET ton_tai = 1 WHERE ma_sp = ? AND ma_mau = ? AND ma_size = ?");
                for(ProductAdminSizeAdd size : listSize){
                preparedStatement.setString(1,ma_sp);
                preparedStatement.setString(2, productAdminColorAddProduct.getMa_mau());
                preparedStatement.setString(3,size.getId());
                preparedStatement.executeUpdate();
                }
            }
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

}