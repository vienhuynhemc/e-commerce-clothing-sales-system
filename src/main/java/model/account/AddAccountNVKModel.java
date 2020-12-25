package model.account;

import worksWithDatabase.account.AddAccountNVKDAO;
import worksWithDatabase.account.AddAccountNVKSource;

public class AddAccountNVKModel {

    private static AddAccountNVKModel addAccountModel;

    public static AddAccountNVKModel getInstance(){
        if (addAccountModel == null){
            addAccountModel = new AddAccountNVKModel();
        }
        return addAccountModel;
    }

    public String addAccount(String userName,String passWord,String rePassWord,String email,String phone, String avatar,String displayName,String fullName,int salary,int num,String tinh,String huyen,String xa){

        AddAccountNVKDAO addAccountNVKDAO = AddAccountNVKSource.getInstance().getAddAccount();
        if(passWord.equals(rePassWord)){
            AddAccountNVKSource.getInstance().releaseAddAccount(addAccountNVKDAO);
            return "Xác nhận mật khẩu sai";
        }
        if(addAccountNVKDAO.isEmailInDatabase(email)){
            AddAccountNVKSource.getInstance().releaseAddAccount(addAccountNVKDAO);
            return "Email đã tồn tại trong cơ sở dữ liệu";
        }else if (!addAccountNVKDAO.isEmail(email)){
            AddAccountNVKSource.getInstance().releaseAddAccount(addAccountNVKDAO);
            return "Email không tồn tại";
        }
        if(addAccountNVKDAO.isAccountInDatabase(userName)){
            AddAccountNVKSource.getInstance().releaseAddAccount(addAccountNVKDAO);
            return "Tài khoản đã tồn tại";
        }
        String address = xa + " - " + huyen + " - " + tinh;
        addAccountNVKDAO.addAccount( userName, passWord, email, phone,  avatar, displayName, fullName,salary,num, address);
        AddAccountNVKSource.getInstance().releaseAddAccount(addAccountNVKDAO);
        return "OK";
    }
}
