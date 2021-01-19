package worksWithDatabase.importProduct;

import connectionDatabase.DataSource;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImportProductWorksWithDatabase {

    public ImportProductWorksWithDatabase(){
    }

    // phương thứuc nhận vào mã admin, kiểm tra xem admin này nhập mấy đơn hàng rồi
    public int getNumberOfImportProductByIdAmin(String ma_nv){

        Connection connection = DataSource.getInstance().getConnection();
        int result = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(ma_phieu_nhap) AS so_luong FROM nhap_hang WHERE ma_nv = ?");
            preparedStatement.setString(1,ma_nv);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            result = resultSet.getInt("so_luong");
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return result;
    }

    //  Phuowng thúc nhập  vào mã admin, trả về list mã nhập hàng của id này
    public List<String> getAllImportProductByIdAdmin(String ma_nv){

        Connection connection = DataSource.getInstance().getConnection();
        List<String> result = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ma_phieu_nhap FROM nhap_hang WHERE ma_nv = ?");
            preparedStatement.setString(1,ma_nv);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                result.add(resultSet.getString("ma_phieu_nhap"));
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
