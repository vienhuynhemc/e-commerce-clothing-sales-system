package model.account;

import worksWithDatabase.account.AddAccountKHDAO;
import worksWithDatabase.account.AddAccountKHSource;

public class AddAccountKHModel {
    private static AddAccountKHModel addAccountModel;

    public static AddAccountKHModel getInstance(){
        if (addAccountModel == null){
            addAccountModel = new AddAccountKHModel();
        }
        return addAccountModel;
    }

    public String addAccount(String userName,String passWord,String rePassWord,String email,String avatar,String phone,String displayName,String fullName,String ttdg,String ttkh){

        AddAccountKHDAO addAccountKHDAO = AddAccountKHSource.getInstance().getAddAccount();
        if(passWord.equals(rePassWord)){
            AddAccountKHSource.getInstance().releaseAddAccount(addAccountKHDAO);
            return "error1";
        }
        if(addAccountKHDAO.isEmailInDatabase(email)){
            AddAccountKHSource.getInstance().releaseAddAccount(addAccountKHDAO);
            return "error2";
        }else if (!addAccountKHDAO.isEmail(email)){
            AddAccountKHSource.getInstance().releaseAddAccount(addAccountKHDAO);
            return "error3";
        }
        if(addAccountKHDAO.isAccountInDatabase(userName)){
            AddAccountKHSource.getInstance().releaseAddAccount(addAccountKHDAO);
            return "error4";
        }
        addAccountKHDAO.addAccount( userName, passWord, email, avatar, phone, displayName, fullName, ttdg, ttkh);
        AddAccountKHSource.getInstance().releaseAddAccount(addAccountKHDAO);
        return "OK";
    }
}
