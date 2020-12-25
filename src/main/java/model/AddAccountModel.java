package model;

import addAccountAdmin.AddAccountDAO;
import addAccountAdmin.AddAccountSource;

public class AddAccountModel {

    private static AddAccountModel addAccountModel;

    public static AddAccountModel getInstance(){
        if (addAccountModel == null){
            addAccountModel = new AddAccountModel();
        }
        return addAccountModel;
    }

    public String addAccount(int type,String userName,String passWord,String email,String phone,String displayName,String fullName,String salary,String num,String address,String ttdg,String ttkh){

        AddAccountDAO addAccountDAO =AddAccountSource.getInstance().getAddAccount();

//        if(addAccountDAO.isEmailInDatabase(email,type)){
//            AddAccountSource.getInstance().releaseAddAccount(addAccountDAO);
//            return "Email đã tồn tại trong cơ sở dữ liệu";
//        }else if (!addAccountDAO.isEmail(email, type)){
//            AddAccountSource.getInstance().releaseAddAccount(addAccountDAO);
//            return "Email không tồn tại";
//        }
 //       if(addAccountDAO.isAccountInDatabase(userName,type)){
//            AddAccountSource.getInstance().releaseAddAccount(addAccountDAO);
//            return "Tài khoản đã tồn tại";
//        }
        addAccountDAO.addAccount( type, userName, passWord, email, phone, displayName, fullName,salary,num,address,ttdg,ttkh);
        AddAccountSource.getInstance().releaseAddAccount(addAccountDAO);
        return "OK";
    }
}
