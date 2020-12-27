package model.addAccount;

import worksWithDatabase.addAccount.AddAccountNVVCDAO;
import worksWithDatabase.addAccount.AddAccountNVVCSource;

public class AddAccountNVVCModel {
    private static AddAccountNVVCModel addAccountModel;

    public static AddAccountNVVCModel getInstance(){
        if (addAccountModel == null){
            addAccountModel = new AddAccountNVVCModel();
        }
        return addAccountModel;
    }

    public String addAccount(String userName,String passWord,String rePassWord,String email,String phone, String avatar,String displayName,String fullName,String salary,String num,String tinh,String huyen,String xa){

        AddAccountNVVCDAO addAccountNVVCDAO = AddAccountNVVCSource.getInstance().getAddAccount();
        // chess repass vs pass trc nếu nhập sai thì trả về luôn
        if(!passWord.equals(rePassWord)){
            AddAccountNVVCSource.getInstance().releaseAddAccount(addAccountNVVCDAO);
            return "error1";
        } // chess coi email có tồn tại trong databasae hay k??
        if(addAccountNVVCDAO.isEmailInDatabase(email)){
            AddAccountNVVCSource.getInstance().releaseAddAccount(addAccountNVVCDAO);
            return "error2";
        }// chess username có tôn tại hay k
        if(addAccountNVVCDAO.isAccountInDatabase(userName)){
            AddAccountNVVCSource.getInstance().releaseAddAccount(addAccountNVVCDAO);
            return "error4";
        } // nếu k thì chess có tồn tại thực hay k??
        if (!addAccountNVVCDAO.isEmail(email)){
            AddAccountNVVCSource.getInstance().releaseAddAccount(addAccountNVVCDAO);
            return "error3";
        }
        String address = xa + " - " + huyen + " - " + tinh;
        addAccountNVVCDAO.addAccount( userName, passWord, email, phone,  avatar, displayName, fullName,salary,num, address);
        AddAccountNVVCSource.getInstance().releaseAddAccount(addAccountNVVCDAO);
        return "OK";
    }
}
