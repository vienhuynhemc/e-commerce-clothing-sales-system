package model.personalNotice;

import worksWithDatabase.personalNotice.PersonalNoticeDataSource;
import worksWithDatabase.personalNotice.PersonalNoticeWorksWithDatabase;

public class PersonalNoticeModel {

    //  Tạo thể hiện cho lớp
    private static PersonalNoticeModel personalNoticeModel;

    //  Phương thức lấy thể hiện
    public static PersonalNoticeModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (personalNoticeModel == null) {
            personalNoticeModel = new PersonalNoticeModel();
        }

        //  Trả về thể hiện
        return personalNoticeModel;

    }

    //  Phương thức thêm 1 thông báo cá nhân vô csdl
    public void addNewPersonalNoticeToDatabase(String ma_nv, String nd1, String nd2, String nd3, String nd4, String nd5) {
        PersonalNoticeWorksWithDatabase personalNoticeWorksWithDatabase = PersonalNoticeDataSource.getInstance().getPersonalNoticeWorksWithDatabase();
        personalNoticeWorksWithDatabase.addNewPersonalNoticeToDatabase(ma_nv, nd1, nd2, nd3, nd4, nd5);
        PersonalNoticeDataSource.getInstance().releasePersonalNoticeWorksWithDatabase(personalNoticeWorksWithDatabase);
    }

}
