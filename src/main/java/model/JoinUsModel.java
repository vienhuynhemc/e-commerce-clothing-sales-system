package model;

import mail.MailModel;
import worksWithDatabase.EmailWorksWithDatabase;
import worksWithDatabase.MailDataSource;

public class JoinUsModel {

    //  Hàm này áp dụng singleton, nhận vào 1 email và hành động
    private static JoinUsModel joinUsController;

    //  Trả về thể hiện của class
    public static JoinUsModel getInstance() {

        //  Xem thử thể hiện có null ko, null thì tạo mới thể hiện
        if (joinUsController == null) {
            joinUsController = new JoinUsModel();
        }

        //  Xong trả về thể hiện
        return joinUsController;

    }

    //  Hàm xử lý của model, nhận vô một email
    public String action(String email) {

        //  Lấy người gác cổng database
        EmailWorksWithDatabase emailWorksWithDatabase = MailDataSource.getInstance().getEmailWorksWithDatabase();

        //  Kiểm tra nếu email tồn tại trong database rồi thì
        if (emailWorksWithDatabase.isEmailInDatabase(email)) {

            //  Trả lại người gác cổng
            MailDataSource.getInstance().releaseMailModel(emailWorksWithDatabase);

            //  Trả về link trang thông báo tương ứng
            return "popupMailNotice/indexMailNoticeExist.jsp";

        }

        //  Nếu email không tồn tại trong database thì kiểm tra email có thật hay không bằng cách gửi thư
        if (!MailModel.getInstance().checkEmail(email, MailModel.CONTACT_INDEX)) {

            //  Email không tồn tại thì trả lại người gác cổng email
            MailDataSource.getInstance().releaseMailModel(emailWorksWithDatabase);

            //  Trả về link trang thông báo tương ứng
            return "popupMailNotice/indexMailNoticeFailure.jsp";

        }

        //  Tới đây nghĩa là thõa mãn , thêm email vào database
        emailWorksWithDatabase.addEmailToEmailTable(email);

        //  Trả lại người gác cổng email
        MailDataSource.getInstance().releaseMailModel(emailWorksWithDatabase);

        //  Trả về link trang thông báo tương ứng
        return "popupMailNotice/indexMailNoticeSuccess.jsp";

    }

}
