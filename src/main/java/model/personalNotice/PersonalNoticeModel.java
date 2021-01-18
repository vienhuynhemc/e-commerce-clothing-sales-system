package model.personalNotice;

import model.detailedRingerNotification.DetailedRingerNotificationModel;

public class PersonalNoticeModel {

    //  Tạo thể hiện cho lớp
    private static PersonalNoticeModel personalNoticeModel;

    //  Phương thức lấy thể hiện
    public static  PersonalNoticeModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if ( personalNoticeModel == null) {
            personalNoticeModel= new  PersonalNoticeModel();
        }

        //  Trả về thể hiện
        return  personalNoticeModel;

    }

}
