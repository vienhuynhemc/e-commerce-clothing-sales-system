package model.account;

import worksWithDatabase.account.AddAccountNVVCDAO;
import worksWithDatabase.account.AddAccountNVVCSource;

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
        if(passWord.equals(rePassWord)){
            AddAccountNVVCSource.getInstance().releaseAddAccount(addAccountNVVCDAO);
            return "error1";
        }
        if(addAccountNVVCDAO.isEmailInDatabase(email)){
            AddAccountNVVCSource.getInstance().releaseAddAccount(addAccountNVVCDAO);
            return "error2";
        }else if (!addAccountNVVCDAO.isEmail(email)){
            AddAccountNVVCSource.getInstance().releaseAddAccount(addAccountNVVCDAO);
            return "error3";
        }
        if(addAccountNVVCDAO.isAccountInDatabase(userName)){
            AddAccountNVVCSource.getInstance().releaseAddAccount(addAccountNVVCDAO);
            return "error4";
        }
        String address = xa + " - " + huyen + " - " + tinh;
        addAccountNVVCDAO.addAccount( userName, passWord, email, phone,  avatar, displayName, fullName,salary,num, address);
        AddAccountNVVCSource.getInstance().releaseAddAccount(addAccountNVVCDAO);
        return "OK";
    }
}
