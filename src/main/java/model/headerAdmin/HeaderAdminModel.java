package model.headerAdmin;

import beans.ringNotification.RingNotification;
import model.detailedRingerNotification.DetailedRingerNotificationModel;
import model.ringNotification.RingNotificationModel;
import worksWithDatabase.account.AccountDataSource;
import worksWithDatabase.account.AccountWorksWithDatabase;

import java.util.List;

public class HeaderAdminModel {

    //  Tạo thể hiện cho lớp
    private static HeaderAdminModel headerAdminModel;

    //  Phương thức lấy thể hiện
    public static HeaderAdminModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (headerAdminModel == null) {
            headerAdminModel = new HeaderAdminModel();
        }

        //  Trả về thể hiện
        return headerAdminModel;

    }

    //  Phuơng thức nhận vào mã nhân viên trả về list thông báo chuông
    public List<RingNotification> getListRingNotificationFromId(String ma_nv_nhan) {

        //  Lấy list id thông báo chuông của nhân viên này
        List<String> ringNotificationId = DetailedRingerNotificationModel.getInstance().getAllRingNotificationIdFromStaffId(ma_nv_nhan);

        //  Lấy list ringNotification còn thiếu thông tin
        List<RingNotification> ringNotifications = RingNotificationModel.getInstance().getListRingNotificationFromListId(ringNotificationId);

        // fill ảnh đại điện và tên
        AccountWorksWithDatabase accountWorksWithDatabase = AccountDataSource.getInstance().getAccountWorksWithDatabase();
        accountWorksWithDatabase.fillNameAndLinkAvatarForListRingNotification(ringNotifications);
        AccountDataSource.getInstance().releaseAccountWorksWithDatabase(accountWorksWithDatabase);

        return ringNotifications;
    }

}
