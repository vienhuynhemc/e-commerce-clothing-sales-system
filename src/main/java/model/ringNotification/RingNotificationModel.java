package model.ringNotification;

import beans.ringNotification.RingNotification;
import worksWithDatabase.ringNotification.RingNotificationDataSource;
import worksWithDatabase.ringNotification.RingNotificationWorksWithDatabase;

import java.util.List;

public class RingNotificationModel {

    //  Tạo thể hiện cho lớp
    private static RingNotificationModel ringNotificationModel;

    //  Phương thức lấy thể hiện
    public static RingNotificationModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (ringNotificationModel == null) {
            ringNotificationModel = new RingNotificationModel();
        }

        //  Trả về thể hiện
        return ringNotificationModel;

    }

    //  Phương thức thêm một thông báo chuông vào cơ sở dữ liệu
    public void addNewRingNotificationToDatabase(String noi_dung, String ma_nguoi_gui, int kieu_nguoi_gui,String link) {
        RingNotificationWorksWithDatabase ringNotificationWorksWithDatabase = RingNotificationDataSource.getInstance().getRingNotificationWorksWithDatabase();
        ringNotificationWorksWithDatabase.addNewRingNotificationToDatabase(noi_dung, ma_nguoi_gui, kieu_nguoi_gui,link);
        RingNotificationDataSource.getInstance().releaseRingNotificationWorksWithDatabase(ringNotificationWorksWithDatabase);
    }

    //  Phương thức nhận vào list id thông báo chuông, trả về list thông báo chuông nhưng còn thiếu tên và hình người gửi
    public List<RingNotification> getListRingNotificationFromListId(List<String> ringNotificationId) {
        RingNotificationWorksWithDatabase ringNotificationWorksWithDatabase = RingNotificationDataSource.getInstance().getRingNotificationWorksWithDatabase();
        List<RingNotification> result = ringNotificationWorksWithDatabase.getListRingNotificationFromListId(ringNotificationId);
        RingNotificationDataSource.getInstance().releaseRingNotificationWorksWithDatabase(ringNotificationWorksWithDatabase);
        return result;
    }

}
