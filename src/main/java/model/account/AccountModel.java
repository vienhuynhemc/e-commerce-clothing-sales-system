package model.account;

import worksWithDatabase.account.AccountDataSource;
import worksWithDatabase.account.AccountWorksWithDatabase;

public class AccountModel {

    private static AccountModel accountModel;

    public static AccountModel getInstance(){
        if(accountModel == null){
            accountModel = new AccountModel();
        }
        return accountModel;
    }

    //  Phương thức dùng ở thông tin tài khoản admin , nhận vô mã nhân viên và link avatar mới, cập nhật lại
    public void updateAvatarLinkById(String ma_tai_khoan,String link_hinh_dai_dien){
        AccountWorksWithDatabase accountWorksWithDatabase = AccountDataSource.getInstance().getAccountWorksWithDatabase();
        accountWorksWithDatabase.updateAvatarLinkById(ma_tai_khoan,link_hinh_dai_dien);
        AccountDataSource.getInstance().releaseAccountWorksWithDatabase(accountWorksWithDatabase);
    }

    //  Phương thức nhận vô mã tài khoản, mật khẩu cập nhật lại
    public void updatePassword(String ma_tai_khoan,String mat_khau){
        AccountWorksWithDatabase accountWorksWithDatabase = AccountDataSource.getInstance().getAccountWorksWithDatabase();
        accountWorksWithDatabase.updatePassword(ma_tai_khoan,mat_khau);
        AccountDataSource.getInstance().releaseAccountWorksWithDatabase(accountWorksWithDatabase);
    }

    //  Phương thức nhận vô mã tài khoản. số điện thoại cập nhật lại
    public void updatePhoneNumber(String ma_tai_khoan,String so_dien_thoai){
        AccountWorksWithDatabase accountWorksWithDatabase = AccountDataSource.getInstance().getAccountWorksWithDatabase();
        accountWorksWithDatabase.updatePhoneNumber(ma_tai_khoan,so_dien_thoai);
        AccountDataSource.getInstance().releaseAccountWorksWithDatabase(accountWorksWithDatabase);
    }

    // Phương thức nhậ nvoo mã tài khoản và tên đầy đủ, cập nhật lại
    public void updateFullName(String ma_tai_khoan,String ten_day_du){
        AccountWorksWithDatabase accountWorksWithDatabase = AccountDataSource.getInstance().getAccountWorksWithDatabase();
        accountWorksWithDatabase.updateFullName(ma_tai_khoan,ten_day_du);
        AccountDataSource.getInstance().releaseAccountWorksWithDatabase(accountWorksWithDatabase);
    }

    // Phương thức nhậ nvoo mã tài khoản và tên hiển thị, cập nhật lại
    public void updateDisplayName(String ma_tai_khoan,String ten_hien_thi){
        AccountWorksWithDatabase accountWorksWithDatabase = AccountDataSource.getInstance().getAccountWorksWithDatabase();
        accountWorksWithDatabase.updateDisplayName(ma_tai_khoan,ten_hien_thi);
        AccountDataSource.getInstance().releaseAccountWorksWithDatabase(accountWorksWithDatabase);
    }

}
