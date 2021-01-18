package model.detailedRingerNotification;

import model.loginAdmin.LoginAdminModel;

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

}
