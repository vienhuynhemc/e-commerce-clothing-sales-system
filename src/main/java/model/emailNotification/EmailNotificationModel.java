package model.emailNotification;

import beans.BeansConfiguration;
import beans.emailNotification.EmailNotification;
import worksWithDatabase.emailNotification.EmailNotificationDataSource;
import worksWithDatabase.emailNotification.EmailNotificationWorksWithDatabase;

import java.util.List;

public class EmailNotificationModel {

    //  Tạo thể hiện cho lớp
    private static EmailNotificationModel emailNotificationModel;

    //  Phương thức lấy thể hiện
    public static EmailNotificationModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (emailNotificationModel == null) {
            emailNotificationModel = new EmailNotificationModel();
        }

        //  Trả về thể hiện
        return emailNotificationModel;
    }

    //  Phương thức lấy danh sách email thông báo đầu tiên
    public List<EmailNotification> getListEmailNotifictaionsFirst(int line) {
        EmailNotificationWorksWithDatabase emailNotificationWorksWithDatabase = EmailNotificationDataSource.getInstance().getEmailNotificationWorksWithDatabase();
        List<EmailNotification> emailNotificationList = emailNotificationWorksWithDatabase.getListEmailNotificationFirst(line);
        EmailNotificationDataSource.getInstance().releaseEmailNotificationWorksWithDatabase(emailNotificationWorksWithDatabase);
        return emailNotificationList;
    }

    //  Phuơng thức lấy số email thông báo tối đa
    public int getMaximumEmailNotification() {
        EmailNotificationWorksWithDatabase emailNotificationWorksWithDatabase = EmailNotificationDataSource.getInstance().getEmailNotificationWorksWithDatabase();
        int result = emailNotificationWorksWithDatabase.getMaximumEmailNotification();
        EmailNotificationDataSource.getInstance().releaseEmailNotificationWorksWithDatabase(emailNotificationWorksWithDatabase);
        return result;
    }

    //  Phương thức nhận vô số emailnotification tối đa, trả về số trang tối đa
    public int getMaximunNumberOfPage(int maximumEmailNotification) {

        return maximumEmailNotification % BeansConfiguration.LINE_OF_ON_PAGE_GUI_EMAIL_THONG_BAO > 0 ? maximumEmailNotification / BeansConfiguration.LINE_OF_ON_PAGE_GUI_EMAIL_THONG_BAO + 1 : maximumEmailNotification / BeansConfiguration.LINE_OF_ON_PAGE_GUI_EMAIL_THONG_BAO;

    }

    //  Phương thức trả về next Id email notification
    public String getNextIdEmailNotification() {
        EmailNotificationWorksWithDatabase emailNotificationWorksWithDatabase = EmailNotificationDataSource.getInstance().getEmailNotificationWorksWithDatabase();
        String result = emailNotificationWorksWithDatabase.getNextIdEmailNotification();
        EmailNotificationDataSource.getInstance().releaseEmailNotificationWorksWithDatabase(emailNotificationWorksWithDatabase);
        return result;
    }

    //  Phương thức lấy list emailNotification từ tất cả điều kiện
    public List<EmailNotification> getListEmailNotificationFromAll(String selectSearchAndSort, String sort, String search, int linesPerPage, int nowPage) {
        EmailNotificationWorksWithDatabase emailNotificationWorksWithDatabase = EmailNotificationDataSource.getInstance().getEmailNotificationWorksWithDatabase();
        List<EmailNotification> result = emailNotificationWorksWithDatabase.getListEmailNotificationFromAll(selectSearchAndSort, sort, search, linesPerPage, nowPage);
        EmailNotificationDataSource.getInstance().releaseEmailNotificationWorksWithDatabase(emailNotificationWorksWithDatabase);
        return result;
    }

    //  Phương thức lấy số emailNotification tối  từ tất cả điều kiện
    public int getMaximumNotificationFromAll(String selectSearchAndSort, String search) {
        EmailNotificationWorksWithDatabase emailNotificationWorksWithDatabase = EmailNotificationDataSource.getInstance().getEmailNotificationWorksWithDatabase();
        int result = emailNotificationWorksWithDatabase.getMaximumNotificationFromAll(selectSearchAndSort, search);
        EmailNotificationDataSource.getInstance().releaseEmailNotificationWorksWithDatabase(emailNotificationWorksWithDatabase);
        return result;
    }

    //  Phương thức nhận vào mã thông báo, xóa nó trong cơ sở dữ liệu
    public boolean removeOneEmailNotificationInDatabase(String id) {
        EmailNotificationWorksWithDatabase emailNotificationWorksWithDatabase = EmailNotificationDataSource.getInstance().getEmailNotificationWorksWithDatabase();
        boolean result = emailNotificationWorksWithDatabase.removeOneEmailNotificationInDatabase(id);
        EmailNotificationDataSource.getInstance().releaseEmailNotificationWorksWithDatabase(emailNotificationWorksWithDatabase);
        return result;
    }

    //  Phương thức thêm một thông báo mới vô csdl
    public void addEmailNotificationToDatabase(String ma_email,String noi_dung,String ma_nv,String tieu_de){
        EmailNotificationWorksWithDatabase emailNotificationWorksWithDatabase = EmailNotificationDataSource.getInstance().getEmailNotificationWorksWithDatabase();
        emailNotificationWorksWithDatabase.addEmailNotificationToDatabase(ma_email,noi_dung,ma_nv,tieu_de);
        EmailNotificationDataSource.getInstance().releaseEmailNotificationWorksWithDatabase(emailNotificationWorksWithDatabase);
    }



}
