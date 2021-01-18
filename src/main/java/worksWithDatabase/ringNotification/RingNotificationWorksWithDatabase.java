package worksWithDatabase.ringNotification;

import beans.DateTime;
import beans.ringNotification.RingNotification;
import connectionDatabase.DataSource;
import model.detailedRingerNotification.DetailedRingerNotificationModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RingNotificationWorksWithDatabase {

    public RingNotificationWorksWithDatabase() {
    }

    //  Phương thức lấy id tiếp theo
    public String nextId() {
        Connection connection = DataSource.getInstance().getConnection();

        Statement statement = null;
        String result = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(ma_thong_bao_chuong) AS so_luong FROM chi_tiet_thong_bao_chuong");
            resultSet.next();
            int soLuong = resultSet.getInt("so_luong");
            result = "tbc_" + (soLuong + 1);
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return result;
    }

    //  Phương thức thêm một thông báo chuông vào cơ sở dữ liệu
    public void addNewRingNotificationToDatabase(String noi_dung, String ma_nguoi_gui, int kieu_nguoi_gui,String link) {
        Connection connection = DataSource.getInstance().getConnection();

        String nextId = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO chi_tiet_thong_bao_chuong VALUES(?,?,?,?,?,?)");
             nextId = nextId();
            preparedStatement.setString(1, nextId);
            //  Tạo ngày tạo là ngày hôm nay
            Date date = new Date();
            DateTime nowDate = new DateTime(date.getYear() + 1900, date.getMonth() + 1, date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds());
            preparedStatement.setString(2, nowDate.toString());
            preparedStatement.setString(3, noi_dung);
            preparedStatement.setString(4, ma_nguoi_gui);
            preparedStatement.setInt(5,kieu_nguoi_gui);
            preparedStatement.setString(6,link);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //  ĐIền dữ liệu vào bảng thông báo chuông
        DetailedRingerNotificationModel.getInstance().addDetailedRingerNotificationToDbase(nextId,ma_nguoi_gui);

        DataSource.getInstance().releaseConnection(connection);
    }

    //  Phương thức nhận vào list id thông báo chuông, trả về list thông báo chuông nhưng còn thiếu tên và hình người gửi
    public List<RingNotification> getListRingNotificationFromListId(List<String> ringNotificationId){

        List<RingNotification> result = new ArrayList<RingNotification>();

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ngay_tao,noi_dung,ma_nguoi_gui,kieu_nguoi_gui,link FROM chi_tiet_thong_bao_chuong WHERE ma_thong_bao_chuong = ?");
            for(String id : ringNotificationId){
                preparedStatement.setString(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                RingNotification ringNotification = new RingNotification();
                ringNotification.setContent(resultSet.getString("noi_dung"));
                ringNotification.setDateCreated(new DateTime(resultSet.getString("ngay_tao")));
                ringNotification.setTypeSender(resultSet.getInt("kieu_nguoi_gui"));
                ringNotification.setIdSender(resultSet.getString("ma_nguoi_gui"));
                ringNotification.setLink(resultSet.getString("link"));
                result.add(ringNotification);
                resultSet.close();
            }
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

        return result;
    }

}
