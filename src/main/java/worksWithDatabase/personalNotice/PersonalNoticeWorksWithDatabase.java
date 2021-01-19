package worksWithDatabase.personalNotice;

import beans.DateTime;
import beans.personalNotice.PersonalNotice;
import connectionDatabase.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonalNoticeWorksWithDatabase {

    public PersonalNoticeWorksWithDatabase() {
    }

    //  Phương thức lấy id tiếp theo
    public String nextId() {

        Connection connection = DataSource.getInstance().getConnection();

        Statement statement = null;
        String result = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(ma_thong_bao_ca_nhan) AS so_luong FROM thong_bao_ca_nhan");
            resultSet.next();
            int soLuong = resultSet.getInt("so_luong");
            result = "tbcn_" + (soLuong + 1);
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return result;
    }

    //  Phương thức thêm 1 thông báo cá nhân vô csdl
    public void addNewPersonalNoticeToDatabase(String ma_nv, String nd1, String nd2, String nd3, String nd4, String nd5) {

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO thong_bao_ca_nhan VALUES (?,?,?,?,?,?,?,?)");

            String nextId = nextId();
            preparedStatement.setString(1, nextId);
            //  Tạo ngày tạo là ngày hôm nay
            Date date = new Date();
            DateTime nowDate = new DateTime(date.getYear() + 1900, date.getMonth() + 1, date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds());
            preparedStatement.setString(2, nowDate.toString());
            preparedStatement.setString(3, ma_nv);
            preparedStatement.setString(4, nd1);
            preparedStatement.setString(5, nd2);
            preparedStatement.setString(6, nd3);
            preparedStatement.setString(7, nd4);
            preparedStatement.setString(8, nd5);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    //  Phương thức nhận vô mã nhân viên, trả về list đối tượng thông báo cá nhân
    public List<PersonalNotice> getAllPersonalNoticeFromId(String ma_nv) {

        List<PersonalNotice> personalNotices = new ArrayList<PersonalNotice>();
        Connection connection = DataSource.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ngay_tao,noi_dung_1,noi_dung_2,noi_dung_3,noi_dung_4,noi_dung_5 FROM thong_bao_ca_nhan WHERE ma_nv = ? ORDER BY ngay_tao DESC");
            preparedStatement.setString(1,ma_nv);
            ResultSet reusltSet = preparedStatement.executeQuery();
            while (reusltSet.next()) {
                PersonalNotice personalNotice = new PersonalNotice();
                personalNotice.setContent_1(reusltSet.getString("noi_dung_1"));
                personalNotice.setContent_2(reusltSet.getString("noi_dung_2"));
                personalNotice.setContent_3(reusltSet.getString("noi_dung_3"));
                personalNotice.setContent_4(reusltSet.getString("noi_dung_4"));
                personalNotice.setContent_5(reusltSet.getString("noi_dung_5"));
                personalNotice.setOverTime(reusltSet.getString("ngay_tao"));
                personalNotices.add(personalNotice);
            }
            reusltSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);

        return personalNotices;
    }

}
