package model.loginAdmin;

import beans.DateTimeConfiguration;
import mail.MailConfiguration;
import mail.MailModel;
import worksWithDatabase.account.AccountDataSource;
import worksWithDatabase.account.AccountWorksWithDatabase;
import worksWithDatabase.staff.StaffDataSource;
import worksWithDatabase.staff.StaffWorksWithDatabase;

import java.util.Date;
import java.util.Random;

public class ForgotPasswordAdminModel {

    //  Tạo thể hiện cho lớp
    private static ForgotPasswordAdminModel forgotPasswordModel;
    private Random rd;

    private ForgotPasswordAdminModel() {
        rd = new Random();
    }

    //  Phương thức lấy thể hiện
    public static ForgotPasswordAdminModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (forgotPasswordModel == null) {
            forgotPasswordModel = new ForgotPasswordAdminModel();
        }

        //  Trả về thể hiện
        return forgotPasswordModel;

    }

    //  Phương thức nhận vào thời hạn của mã , trả về số giây còn hiệu lực, hết hiệu lực trả về 0
    public int getTimeOut(Date timeExists) {

        Date now = new Date();
        long timeOut = timeExists.getTime() - now.getTime();
        if (timeOut <= 0) return 0;
        else return (int) (timeOut / DateTimeConfiguration.ONE_SECOND_IN_MILIS);

    }

    //  Phương thức nhận vô 1 email, kiểm tra xem thứ email đó có tồn tài không
    public String isValidEmail(String email) {

        //  Mượn account works withdataabase
        AccountWorksWithDatabase accountWorksWithDatabase = AccountDataSource.getInstance().getAccountWorksWithDatabase();

        //  Lấy kết quả môn muốn
        String ma_tai_khoan = accountWorksWithDatabase.isValidEmail(email);

        //  Có mượn có trả
        AccountDataSource.getInstance().releaseAccountWorksWithDatabase(accountWorksWithDatabase);

        //  Trả về kết quả
        return ma_tai_khoan;

    }

    //  Phương thức nhận vào một mã tài khoản, kiểm tra xem thử tài khoản tayuf trong bảng nhân viên còn hoạt động ko
    public boolean isExistsAccount(String ma_tai_khoan) {

        //  Mượn staff works with database
        StaffWorksWithDatabase staffWorksWithDatabase = StaffDataSource.getInstance().getStaffWorksWithDatabase();

        //  Lấy kết quả mong muốn
        boolean result = staffWorksWithDatabase.isExistsAccount(ma_tai_khoan);

        //  Có mượn có trả
        StaffDataSource.getInstance().releaseStaffWorksWithDatabase(staffWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

    //  Phương thức tạo một mã 6 số
    public String getVerifyCode() {

        String result = "";

        for (int i = 0; i < 6; i++) {
            result += rd.nextInt(10) + "";
        }

        return result;

    }

    //  Phương thức nhận vào mã tài khoản, mã verify và hạn sử dụng của nó, đưa vào csdl
    public void updateVerifyCodeAndTimeOut(String ma_tai_khoan, String ma_quen_mat_khau, String han_su_dung_ma_qmk) {

        //  Mượn account works withdataabase
        AccountWorksWithDatabase accountWorksWithDatabase = AccountDataSource.getInstance().getAccountWorksWithDatabase();

        //  update
        accountWorksWithDatabase.updateVerifyCodeAndTimeOut(ma_tai_khoan, ma_quen_mat_khau, han_su_dung_ma_qmk);

        //  Có mượn có trả
        AccountDataSource.getInstance().releaseAccountWorksWithDatabase(accountWorksWithDatabase);

    }

    //  Phương thức nhận vào mã verify quên mật khẩu và email, gửi mã này tới email này
    public void sendMailForgotPasswordVerifyCode(String email, String verifyCode){

        String text = "<p style=\"padding: 0;font-size: 17px;color: #707070;font-family:sans-serif\">Tài khoản TVTSHOP ADMIN</p><h1 style=\"padding: 0;font-size: 41px;color: #2672ec;font-family:sans-serif\">Xác nhận tài khoản</h1><p style=\"padding: 0;font-size: 14px;color: #2a2a2a;font-family:sans-serif\">Để hoàn tất việc quên mật khẩu tài khoản TVTSHOP ADMIN, chúng tôi chỉ cần đảm bảo địa chỉ email này là của bạn.</p><p style=\"padding: 0;font-size: 14px;color: #2a2a2a;font-family:sans-serif\">Để xác minh tài khoản của bạn, hãy sử dụng mã bảo mật này: <strong>"+verifyCode+"</strong>, thời hạn sử dụng mã này là <strong>180</strong> giây</p><p style=\"padding: 0;font-size: 14px;color: #2a2a2a;font-family:sans-serif\">Nếu bạn không yêu cầu mã này thì bạn có thể an toàn bỏ qua email này. Có thể ai đó đã nhập nhầm địa chỉ email của bạn.</p><p style=\"padding: 0;font-size: 14px;color: #2a2a2a;font-family:sans-serif\">Cảm ơn bạn,</p><p style=\"padding: 0;font-size: 14px;color: #2a2a2a;font-family:sans-serif\">TVTSHOP</p>";
        String subject = "Lấy lại mật khẩu TVTSHOP";

        MailModel.getInstance().initializedSesstion(MailConfiguration.USERNAME_TVTSHOP, MailConfiguration.PASSWORD_TVTSHOP);
        MailModel.getInstance().sendMail("TVTSHOP",email,subject,text,MailConfiguration.MAIL_HTML);

    }

    //  Phương thứuc nhận vào 1 email và 1 mật khẩu, cập nhập lại mật khẩu của tài khoản có email này
    public void updatePasswordFromEmail(String mat_khau,String email){

        //  Mượn account works withdataabase
        AccountWorksWithDatabase accountWorksWithDatabase = AccountDataSource.getInstance().getAccountWorksWithDatabase();

        //  update
        accountWorksWithDatabase.updatePasswordFromEmail(mat_khau,email);

        //  Có mượn có trả
        AccountDataSource.getInstance().releaseAccountWorksWithDatabase(accountWorksWithDatabase);

    }

}