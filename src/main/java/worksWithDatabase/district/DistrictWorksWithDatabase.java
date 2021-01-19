package worksWithDatabase.district;

import beans.address.Commune;
import beans.address.District;
import beans.address.Provincial;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DistrictWorksWithDatabase {

    public DistrictWorksWithDatabase() {
    }

    //  Phuơng thức nhận vô một District điền tên cho nó
    public void fillNameById(District district) {

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ten_quan_huyen FROM quan_huyen WHERE ma_quan_huyen = ?");
            preparedStatement.setString(1,district.getDistrictId());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            district.setDistrictName(resultSet.getString("ten_quan_huyen"));
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    //  Phương thức nhận vô mã tỉnh, trả về list huyện của nó
    public List<District> getDistrictByProvincialId(String ma_tinh_thanh){
        List<District> districts = new ArrayList<District>();

        Connection connection = DataSource.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ma_quan_huyen,ten_quan_huyen FROM quan_huyen WHERE ma_tinh_thanh = ?");
            preparedStatement.setString(1,ma_tinh_thanh);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                District district = new District();
                district.setDistrictName(resultSet.getString("ten_quan_huyen"));
                district.setDistrictId(resultSet.getString("ma_quan_huyen"));
                districts.add(district);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return districts;
    }



}
