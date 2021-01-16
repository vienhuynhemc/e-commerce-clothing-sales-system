package worksWithDatabase.staff;

import beans.loginAdmin.AccountStaffAdmin;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffWorksWithDatabase {

    //  Constructor rỗng không có gì hết
    public StaffWorksWithDatabase() {
    }

    //  Phương thức nhận vào một mã tài khoản, kiểm tra xem thử nó có còn đang hoạt động trong bảng nhan_vien
    public boolean isExistsAccount(String ma_tai_khoan) {

        Connection connection = DataSource.getInstance().getConnection();

        boolean result = false;

        try {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ton_tai FROM nhan_vien WHERE ma_nv = ? AND ton_tai = ?");
            preparedStatement.setString(1, ma_tai_khoan);
            preparedStatement.setInt(2, 0);

            ResultSet resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                result = true;
            } else {
                result = false;
            }

            resultset.close();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

        return result;

    }

    //  Phương thức nhận vào 1 accountStaffAdmin và một mã tài khoản và điền những thông tin của bảng nay vô nó
    public void fillInformationAccountStaffAdmin(AccountStaffAdmin accountStaffAdmin, String ma_tai_khoan) {

        Connection connection = DataSource.getInstance().getConnection();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM nhan_vien WHERE ma_nv = ?");
            preparedStatement.setString(1, ma_tai_khoan);

            ResultSet resultset = preparedStatement.executeQuery();
            resultset.next();

            accountStaffAdmin.setSalary(resultset.getInt("luong"));
            accountStaffAdmin.setIntroduce(resultset.getString("gioi_thieu"));
            accountStaffAdmin.setLevel(resultset.getInt("cap_do"));
            accountStaffAdmin.setExists(resultset.getInt("ton_tai"));

            resultset.close();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

}
