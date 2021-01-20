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

}
