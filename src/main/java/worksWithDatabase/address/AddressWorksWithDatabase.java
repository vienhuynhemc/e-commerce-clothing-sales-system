package worksWithDatabase.address;

import beans.address.Commune;
import beans.address.District;
import beans.address.Provincial;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressWorksWithDatabase {

    public AddressWorksWithDatabase(){
    }

    //  Phương thúc nhận vào mã nhân viên và 3 đối tượgn tỉnh huyện xã, cập nhập mã cho chúng
    public void fillIdToAddressFromId(String ma_nv, Provincial provincial, District district, Commune commune){

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ma_tinh,ma_huyen,ma_xa FROM dia_chi WHERE ma_nv = ?");
            preparedStatement.setString(1,ma_nv);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            provincial.setProvincialId(resultSet.getString("ma_tinh"));
            district.setDistrictId(resultSet.getString("ma_huyen"));
            commune.setCommuneId(resultSet.getString("ma_xa"));
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

}
