package worksWithDatabase.provincial;

import beans.address.District;
import beans.address.Provincial;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProvincialWorksWithDatabase {

    //  Constructor rỗng không có gì hết
    public ProvincialWorksWithDatabase() {
    }

    //  Phương thức trả về list
    public List<Provincial> getListProvincial () {

        List<Provincial> provincials = new ArrayList<Provincial>();

        Connection connection = DataSource.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT  * FROM tinh_thanh");
            while(resultSet.next()){
                provincials.add(new Provincial(resultSet.getString("ma_tinh_thanh"),resultSet.getString("ten_tinh_thanh")));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);

        return provincials;

    }

}
