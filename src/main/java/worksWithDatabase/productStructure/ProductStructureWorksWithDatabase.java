package worksWithDatabase.productStructure;

import beans.productAdmin.ProductAdmin;
import connectionDatabase.DataSource;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductStructureWorksWithDatabase {

    public ProductStructureWorksWithDatabase() {

    }

    //  Phương thức nhận vào list product admin điền cho nó list cấu tạo sp
    public void fillStructureProdcut(List<ProductAdmin> products) {

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT cau_tao FROM cau_tao_sp WHERE ma_sp = ?");

            for (ProductAdmin productAdmin : products) {
                preparedStatement.setString(1, productAdmin.getMa_sp());
                ResultSet resultSet = preparedStatement.executeQuery();
                List<String> structure = new ArrayList<String>();
                while (resultSet.next()) {
                    structure.add(resultSet.getString("cau_tao"));
                }
                resultSet.close();
                productAdmin.setCau_tao_sp(structure);
            }

            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    public void addToDatabase(String ma_sp, List<String> cau_tao){

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cau_tao_sp VALUES(?,?)");
            for(String s : cau_tao){
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

    public void editToDatabase(String ma_sp, List<String> cau_tao){

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cau_tao_sp WHERE ma_sp = ?");
            preparedStatement.setString(1,ma_sp);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("INSERT INTO cau_tao_sp VALUES(?,?)");
            for(String s : cau_tao){
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

    public  List<String> getListById(String ma_sp){

        List<String> result = new ArrayList<String>();

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT cau_tao FROM cau_tao_sp WHERE ma_sp = ?");
            preparedStatement.setString(1,ma_sp);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                result.add(resultSet.getString("cau_tao"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

        return result;
    }

}
