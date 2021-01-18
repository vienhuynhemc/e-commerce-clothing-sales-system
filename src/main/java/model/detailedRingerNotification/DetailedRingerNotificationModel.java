package model.detailedRingerNotification;

import model.loginAdmin.LoginAdminModel;
import worksWithDatabase.detailedRingerNotification.DetailedRingerNotificationDataSource;
import worksWithDatabase.detailedRingerNotification.DetailedRingerNotificationWorksWithDatabase;

public class DetailedRingerNotificationModel {

    //  Tạo thể hiện cho lớp
    private static DetailedRingerNotificationModel detailedRingerNotificationModel;

    //  Phương thức lấy thể hiện
    public static DetailedRingerNotificationModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (detailedRingerNotificationModel == null) {
           detailedRingerNotificationModel = new DetailedRingerNotificationModel();
        }

        //  Trả về thể hiện
        return detailedRingerNotificationModel;

    }

    //  Phương thức nhận vào mã thông báo chuông, chuyển nó cho tất cả các tài khoản admin
    public void addDetailedRingerNotificationToDbase(String ma_thong_bao_chuong,String ma_nguoi_gui){
        DetailedRingerNotificationWorksWithDatabase detailedRingerNotificationWorksWithDatabase = DetailedRingerNotificationDataSource.getInstance().getDetailedRingerNotificationWorksWithDatabase();
        detailedRingerNotificationWorksWithDatabase.addDetailedRingerNotificationToDbase(ma_thong_bao_chuong,ma_nguoi_gui);
        DetailedRingerNotificationDataSource.getInstance().releaseDetailedRingerNotificationWorksWithDatabase(detailedRingerNotificationWorksWithDatabase);
    }

}
