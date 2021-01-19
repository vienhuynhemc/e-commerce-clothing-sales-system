package worksWithDatabase.detailedRingerNotification;

import connectionDatabase.DataSource;
import model.staff.StaffModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetailedRingerNotificationWorksWithDatabase {

    public DetailedRingerNotificationWorksWithDatabase() {
    }

    //  Phương thức nhận vào mã thông báo chuông, chuyển nó cho tất cả các tài khoản admin
    public void addDetailedRingerNotificationToDbase(String ma_thong_bao_chuong,String ma_nguoi_gui){

        //  Lay danh sach cac nhan vien admin tu staffModel
        List<String> maNvs = StaffModel.getInstance().getAllAdmin();

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO thong_bao_chuong VALUES(?,?)");

            for(String ma_nv:maNvs){
                if(!ma_nv.equals(ma_nguoi_gui)){
                    preparedStatement.setString(1,ma_thong_bao_chuong);
                    preparedStatement.setString(2,ma_nv);
                    preparedStatement.executeUpdate();
                }
            }

            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    //  Phương thức nhận vào mã nhân viên, trả về danh sách mã thông báo chuông của nhân viên này, sắp xếp theo thứ tự giảm giần ngày tạo
    //  À quên vì là thông báo nên chỉ lấy 100 thông báo gần đây nhất
    public List<String> getAllRingNotificationIdFromStaffId(String ma_nv_nhan){

        List<String> result = new ArrayList<String>();

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT tb.ma_thong_bao_chuong FROM thong_bao_chuong tb JOIN chi_tiet_thong_bao_chuong ct ON tb.ma_thong_bao_chuong = ct.ma_thong_bao_chuong WHERE tb.ma_nv_nhan = ? ORDER BY ct.ngay_tao DESC LIMIT 0,100 ");
            preparedStatement.setString(1,ma_nv_nhan);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                result.add(resultSet.getString("ma_thong_bao_chuong"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return result;
    }

}
