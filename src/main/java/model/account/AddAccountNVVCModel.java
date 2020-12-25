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

    public String addAccount(String userName,String passWord,String rePassWord,String email,String phone, String avatar,String displayName,String fullName,int salary,int num,String tinh,String huyen,String xa){

        AddAccountNVVCDAO addAccountNVVCDAO = AddAccountNVVCSource.getInstance().getAddAccount();
        if(passWord.equals(rePassWord)){
            AddAccountNVVCSource.getInstance().releaseAddAccount(addAccountNVVCDAO);
            return "Xác nhận mật khẩu sai";
        }
        if(addAccountNVVCDAO.isEmailInDatabase(email)){
            AddAccountNVVCSource.getInstance().releaseAddAccount(addAccountNVVCDAO);
            return "Email đã tồn tại trong cơ sở dữ liệu";
        }else if (!addAccountNVVCDAO.isEmail(email)){
            AddAccountNVVCSource.getInstance().releaseAddAccount(addAccountNVVCDAO);
            return "Email không tồn tại";
        }
        if(addAccountNVVCDAO.isAccountInDatabase(userName)){
            AddAccountNVVCSource.getInstance().releaseAddAccount(addAccountNVVCDAO);
            return "Tài khoản đã tồn tại";
        }
        String address = xa + " - " + huyen + " - " + tinh;
        addAccountNVVCDAO.addAccount( userName, passWord, email, phone,  avatar, displayName, fullName,salary,num, address);
        AddAccountNVVCSource.getInstance().releaseAddAccount(addAccountNVVCDAO);
        return "OK";
    }
}
