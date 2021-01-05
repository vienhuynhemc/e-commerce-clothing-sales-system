package model.loginAdmin;

import beans.DateTimeConfiguration;
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
    public static int getTimeOut(Date timeExists) {

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


}
