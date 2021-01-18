package worksWithDatabase.detailedRingerNotification;

import connectionDatabase.DataSource;
import model.staff.StaffModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

}
