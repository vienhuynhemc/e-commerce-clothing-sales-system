package worksWithDatabase.commune;

import beans.address.Commune;
import beans.address.District;
import beans.address.Provincial;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CommuneWorksWithDatabase {

    public CommuneWorksWithDatabase() {
    }

    //  Phuơng thức nhận vô một Commune điền tên cho nó
    public void fillNameById(Commune commune) {

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ten_phuong_xa FROM phuong_xa WHERE ma_phuong_xa = ?");
            preparedStatement.setString(1, commune.getCommuneId());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            commune.setCommuneName(resultSet.getString("ten_phuong_xa"));
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }



}
