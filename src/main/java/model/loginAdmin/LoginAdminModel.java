package model.loginAdmin;

import beans.loginAdmin.AccountStaffAdmin;
import worksWithDatabase.account.AccountDataSource;
import worksWithDatabase.account.AccountWorksWithDatabase;
import worksWithDatabase.role.RoleDataSource;
import worksWithDatabase.role.RoleWorksWithDatabase;
import worksWithDatabase.staff.StaffDataSource;
import worksWithDatabase.staff.StaffWorksWithDatabase;

import java.util.List;

public class LoginAdminModel {

    //  Tạo thể hiện cho lớp
    private static LoginAdminModel loginAdminModel;

    //  Phương thức lấy thể hiện
    public static LoginAdminModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (loginAdminModel == null) {
            loginAdminModel = new LoginAdminModel();
        }

        //  Trả về thể hiện
        return loginAdminModel;

    }

    //  Phương thức nhận vào một tài khoản, kiểm tra tài khoản có đúng hay chưa
    public String isValidAccount(String tai_khoan) {

        //  Mượn AccountWorksWithDatabase
        AccountWorksWithDatabase accountWorksWithDatabase = AccountDataSource.getInstance().getAccountWorksWithDatabase();

        //  Lấy kết quả mong muốn
        String ma_tai_khoan = accountWorksWithDatabase.isValidAccount(tai_khoan);

        //  Có mượn có trả
        AccountDataSource.getInstance().releaseAccountWorksWithDatabase(accountWorksWithDatabase);

        //  Trả về kết quả
        return ma_tai_khoan;

    }

    //  Phương thức nhận vào mã tài khoản nhân viên, xem thử nó còn hoạt động hay không
    public boolean isExistsAccount(String ma_tai_khoan) {

        //  Mượn StaffWorksWithDatabase
        StaffWorksWithDatabase staffWorksWithDatabase = StaffDataSource.getInstance().getStaffWorksWithDatabase();

        //  Lấy kết quả mong muốn
        boolean result = staffWorksWithDatabase.isExistsAccount(ma_tai_khoan);

        //  Có mượn có trả
        StaffDataSource.getInstance().releaseStaffWorksWithDatabase(staffWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

    //   Phương thức nhận vô tai_khoan và mật_khâu , kiểm tra có đúng mật khẩu hay chưa
    public boolean isValidPassword(String tai_khoan, String mat_khau) {

        //  Mượn AccountWorksWithDatabase
        AccountWorksWithDatabase accountWorksWithDatabase = AccountDataSource.getInstance().getAccountWorksWithDatabase();

        //  Lấy kết quả mong muốn
        boolean result = accountWorksWithDatabase.isValidPassword(tai_khoan, mat_khau);

        //  Có mượn có trả
        AccountDataSource.getInstance().releaseAccountWorksWithDatabase(accountWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

    //  Phương thức nhận vào một mã tài khoản, trả về 1 AccountStaffAdmin
    public AccountStaffAdmin getAccountStaffAdmin(String ma_tai_khoan) {

        //  Mượn AccountWorksWithDatabase
        AccountWorksWithDatabase accountWorksWithDatabase = AccountDataSource.getInstance().getAccountWorksWithDatabase();

        //  Lấy kết quả mong muốn
        AccountStaffAdmin accountStaffAdmin = accountWorksWithDatabase.getAccountStaffAdmin(ma_tai_khoan);

        //  Có mượn có trả
        AccountDataSource.getInstance().releaseAccountWorksWithDatabase(accountWorksWithDatabase);

        //  Trả về kết quả
        return accountStaffAdmin;

    }

    //  Phương thức nhận vào một mã tài khoản, trả về list vai trò của nó
    public List<String> getListRole(String ma_tai_khoan){

        //  Mượn role works with database
        RoleWorksWithDatabase roleWorksWithDatabase = RoleDataSource.getInstance().getRoleWorksWithDatabase();

        //  Lấy kết quả
        List<String> result = roleWorksWithDatabase.getListRole(ma_tai_khoan);

        //  Có mượn có trả
        RoleDataSource.getInstance().releaseRoleWorksWithDatabase(roleWorksWithDatabase);

        //  Trả về kết quả
        return result ;

    }

}
