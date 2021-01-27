package model.addAccount;

import worksWithDatabase.addAccount.AddAccountKHDAO;
import worksWithDatabase.addAccount.AddAccountKHSource;

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
      // chess coi email có tồn tại trong databasae hay k??
        if(addAccountKHDAO.isEmailInDatabase(email)){
            AddAccountKHSource.getInstance().releaseAddAccount(addAccountKHDAO);
            return "error1";
        }// chess username có tôn tại hay k
        if(addAccountKHDAO.isAccountInDatabase(userName)){
            AddAccountKHSource.getInstance().releaseAddAccount(addAccountKHDAO);
            return "error2";
        } // nếu k thì chess có tồn tại thực hay k??
        if (!addAccountKHDAO.isEmail(email)){
            AddAccountKHSource.getInstance().releaseAddAccount(addAccountKHDAO);
            return "error3";
        }else if (addAccountKHDAO.addAccount( userName, passWord, email, avatar, phone, displayName, fullName, ttdg, ttkh)){
            AddAccountKHSource.getInstance().releaseAddAccount(addAccountKHDAO);
            return "OK";
        }else{
            AddAccountKHSource.getInstance().releaseAddAccount(addAccountKHDAO);
            return "KO";
        }
    }
}
