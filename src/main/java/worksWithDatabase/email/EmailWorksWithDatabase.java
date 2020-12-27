package worksWithDatabase.email;

import connectionDatabase.DataSource;

import java.sql.*;

public class EmailWorksWithDatabase {


    //  Constructor rỗng không có gì hết
    public EmailWorksWithDatabase() {
    }

    //  Phương thức kiểm tra xem thử email có tồn tại trong cơ sở dữ liệu hay chưa
    public boolean isEmailInDatabase(String email) {

        //  Trước tiền lấy 1 connection ra
        Connection connection = DataSource.getInstance().getConnection();

        try {

            //  Tạo 1 prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT email FROM email WHERE email = ?");

            //  Trả connection
            DataSource.getInstance().releaseConnection(connection);

            //  Gán email truyèn vào cho nó
            preparedStatement.setString(1, email);

            //  excute để lấy ra resyltset
            ResultSet resultSet = preparedStatement.executeQuery();

            //  Nếu tồn tại kết quả thì
            if (resultSet.next()) {

                //  Không null thì đóng resultset
                resultSet.close();

                //  Đóng prepared statement
                preparedStatement.close();

                //  return true
                return true;

            }

            //  Không tồn tại kết quả thì vẫn đóng
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException throwables) {

            throwables.printStackTrace();

            //  Trả connection
            DataSource.getInstance().releaseConnection(connection);

        }

        //  trả về false
        return false;

    }

    //  Phương thức thêm 1 email vào bảng email trong cơ sở dữ liệu
    public boolean addEmailToEmailTable(String email) {

        //  Lấy 1 connection ra
        Connection conection = DataSource.getInstance().getConnection();

        try {

            //  Bởi vị không có where ở đây nên tạo statement mà sử dụng
            Statement statement = conection.createStatement();

            //  Trả conncetion
            DataSource.getInstance().releaseConnection(conection);

            //  insert dũ liệu nào
            int numberOfRowsAdded = statement.executeUpdate("INSERT INTO email VALUES('" + email + "')");

            //  Nếu như có một hàng thêm vào thì thành công
            if (numberOfRowsAdded == 1) {

                //  Đóng statement
                statement.close();

                //  Return true
                return true;

            }

            //  Không thành công thì vẫn phải đóng statement
            statement.close();

        } catch (SQLException throwables) {

            throwables.printStackTrace();
            //  Trả conncetion
            DataSource.getInstance().releaseConnection(conection);

        }

        //  Return false
        return false;

    }

}
