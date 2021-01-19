package model.personalNotice;

import beans.personalNotice.PersonalNotice;
import worksWithDatabase.personalNotice.PersonalNoticeDataSource;
import worksWithDatabase.personalNotice.PersonalNoticeWorksWithDatabase;

import java.util.List;

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

    //  Phương thức nhận vô mã nhân viên, trả về list đối tượng thông báo cá nhân
    public List<PersonalNotice> getAllPersonalNoticeFromId(String ma_nv) {
        PersonalNoticeWorksWithDatabase personalNoticeWorksWithDatabase = PersonalNoticeDataSource.getInstance().getPersonalNoticeWorksWithDatabase();
        List<PersonalNotice> result = personalNoticeWorksWithDatabase.getAllPersonalNoticeFromId(ma_nv);
        PersonalNoticeDataSource.getInstance().releasePersonalNoticeWorksWithDatabase(personalNoticeWorksWithDatabase);
        return result;
    }

}
