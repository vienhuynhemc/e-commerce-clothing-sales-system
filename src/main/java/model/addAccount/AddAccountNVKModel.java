package model.addAccount;

import worksWithDatabase.addAccount.AddAccountNVKDAO;
import worksWithDatabase.addAccount.AddAccountNVKSource;

public class AddAccountNVKModel {

    private static AddAccountNVKModel addAccountModel;

    public static AddAccountNVKModel getInstance(){
        if (addAccountModel == null){
            addAccountModel = new AddAccountNVKModel();
        }
        return addAccountModel;
    }

    public String addAccount(String userName,String passWord,String rePassWord,String email,String phone, String avatar,String displayName,String fullName,String salary,String num,String tinh,String huyen,String xa){

        AddAccountNVKDAO addAccountNVKDAO = AddAccountNVKSource.getInstance().getAddAccount();
        // chess repass vs pass trc nếu nhập sai thì trả về luôn
        if(!passWord.equals(rePassWord)){
            AddAccountNVKSource.getInstance().releaseAddAccount(addAccountNVKDAO);
            return "error1";
        }
        // chess coi email có tồn tại trong databasae hay k??
        if(addAccountNVKDAO.isEmailInDatabase(email)){
            AddAccountNVKSource.getInstance().releaseAddAccount(addAccountNVKDAO);
            return "error2";
        }
        // chess username có tôn tại hay k
        if(addAccountNVKDAO.isAccountInDatabase(userName)){
            AddAccountNVKSource.getInstance().releaseAddAccount(addAccountNVKDAO);
            return "error4";
        }
       // nếu k thì chess có tồn tại thực hay k??
        if (!addAccountNVKDAO.isEmail(email)){
            AddAccountNVKSource.getInstance().releaseAddAccount(addAccountNVKDAO);
            return "error3";
        }
        // tới đây là ok r
        String address = xa + " - " + huyen + " - " + tinh;
        addAccountNVKDAO.addAccount( userName, passWord, email, phone,  avatar, displayName, fullName,salary,num, address);
        AddAccountNVKSource.getInstance().releaseAddAccount(addAccountNVKDAO);
        return "OK";
    }
}
