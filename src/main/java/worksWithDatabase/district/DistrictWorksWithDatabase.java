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



}
