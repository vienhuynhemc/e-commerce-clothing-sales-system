package model.ringNotification;

import model.personalNotice.PersonalNoticeModel;

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

}
