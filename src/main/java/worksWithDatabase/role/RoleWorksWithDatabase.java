package worksWithDatabase.role;

import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleWorksWithDatabase {

    //  Constructor rỗng không có gì hết
    public RoleWorksWithDatabase() {
    }

    //  Phương thức nhận vào một mã nhân viên, trả về list vai trò của nó
    public List<String> getListRole(String ma_nv) {

        //  Mượn connection
        Connection connection = DataSource.getInstance().getConnection();

        //  Khai báo list kết quả
        List<String> result = new ArrayList<String>();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT vai_tro FROM vai_tro WHERE ma_nv = ?");
            preparedStatement.setString(1, ma_nv);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(resultSet.getString("vai_tro"));
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //  Trả connection
        DataSource.getInstance().releaseConnection(connection);

        //  Trả về kết quả
        return result;

    }

}
