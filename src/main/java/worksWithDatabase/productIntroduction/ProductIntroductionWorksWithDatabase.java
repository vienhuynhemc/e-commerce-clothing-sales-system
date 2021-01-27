package worksWithDatabase.productIntroduction;

import beans.productAdmin.ProductAdmin;
import connectionDatabase.DataSource;
import model.productInformation.ProductInformationModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductIntroductionWorksWithDatabase {

    public ProductIntroductionWorksWithDatabase(){

    }

    public void fillProductIntroduction(List<ProductAdmin> products){
        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT gioi_thieu FROM gioi_thieu_sp WHERE ma_sp = ?");

            for (ProductAdmin productAdmin : products) {
                preparedStatement.setString(1, productAdmin.getMa_sp());
                ResultSet resultSet = preparedStatement.executeQuery();
                List<String> information = new ArrayList<String>();
                while (resultSet.next()) {
                    information.add(resultSet.getString("gioi_thieu"));
                }
                resultSet.close();
                productAdmin.setGioi_thieu_sp(information);
            }

            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
    }

    //  Phương thức nhận vô list giới thiệu và masp, cho vô csdl
    public void addIntroductToDabase(String ma_sp,List<String> gioiThieus){

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO gioi_thieu_sp VALUES(?,?)");
            for(String s : gioiThieus){
                preparedStatement.setString(1,ma_sp);
                preparedStatement.setString(2,s);
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

}
