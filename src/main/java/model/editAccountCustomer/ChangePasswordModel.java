package model.editAccountCustomer;

import worksWithDatabase.editAccountCustomer.ChangePassSource;
import worksWithDatabase.editAccountCustomer.ChangePassWordDAO;

public class ChangePasswordModel {

    private static ChangePasswordModel editAccountNVKModel;

    public static ChangePasswordModel getInstance(){

        if(editAccountNVKModel == null){
            editAccountNVKModel = new ChangePasswordModel();
        }
        return editAccountNVKModel;

    }

    public boolean checkOldPassWord(String userName,String passWord ){
        ChangePassWordDAO passWordDAO = ChangePassSource.getInstance().getEditAccount();

        boolean result = passWordDAO.checkOldPassWord(userName,passWord);

        ChangePassSource.getInstance().releaseEditAccount(passWordDAO);

        return result;
    }
    public boolean changePassWord(String user,String newPass){

        ChangePassWordDAO passWordDAO = ChangePassSource.getInstance().getEditAccount();

        boolean result = passWordDAO.changePassWord(user, newPass);

        ChangePassSource.getInstance().releaseEditAccount(passWordDAO);

        return result;

    }

}
