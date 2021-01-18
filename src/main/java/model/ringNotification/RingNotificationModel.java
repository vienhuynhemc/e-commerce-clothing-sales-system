package model.ringNotification;

import model.personalNotice.PersonalNoticeModel;
import worksWithDatabase.ringNotification.RingNotificationDataSource;
import worksWithDatabase.ringNotification.RingNotificationWorksWithDatabase;

public class RingNotificationModel {

    //  Tạo thể hiện cho lớp
    private static RingNotificationModel ringNotificationModel;

    //  Phương thức lấy thể hiện
    public static  RingNotificationModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if ( ringNotificationModel == null) {
            ringNotificationModel = new RingNotificationModel();
        }

        //  Trả về thể hiện
        return  ringNotificationModel;

    }

    //  Phương thức thêm một thông báo chuông vào cơ sở dữ liệu
    public void addNewRingNotificationToDatabase(String noi_dung, String ma_nguoi_gui, int kieu_nguoi_gui) {
        RingNotificationWorksWithDatabase ringNotificationWorksWithDatabase = RingNotificationDataSource.getInstance().getRingNotificationWorksWithDatabase();
        ringNotificationWorksWithDatabase.addNewRingNotificationToDatabase(noi_dung,ma_nguoi_gui,kieu_nguoi_gui);
        RingNotificationDataSource.getInstance().releaseRingNotificationWorksWithDatabase(ringNotificationWorksWithDatabase);
    }

}
