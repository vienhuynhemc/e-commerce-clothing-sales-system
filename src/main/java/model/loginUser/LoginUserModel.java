package model.loginUser;

import beans.account.AccountCustomer;
import worksWithDatabase.loginUser.LoginUserDAO;
import worksWithDatabase.loginUser.LoginUserSource;

public class LoginUserModel {

    private static LoginUserModel loadAccountKH;
    private String status;

    public static  LoginUserModel getInstance(){

        if (loadAccountKH == null){
            loadAccountKH = new LoginUserModel();
        }
        return loadAccountKH;

    }
    public AccountCustomer getAccountCustomer(String userName,String passWord){

        LoginUserDAO loginUserDAO = LoginUserSource.getInstance().getAccount();

        if (userName.equals("")){
            status = "error4";
            LoginUserSource.getInstance().releaseLoginAccount(loginUserDAO);
            return null;
        }

        if (passWord.equals("")){
            status = "error5";
            LoginUserSource.getInstance().releaseLoginAccount(loginUserDAO);
            return null;
        }

        if(!loginUserDAO.isUserInDatabase(userName)){
            status = "error1";
            LoginUserSource.getInstance().releaseLoginAccount(loginUserDAO);
            return null;
        }

        if(!loginUserDAO.checkActiveStatus(userName)){
            status = "error2";
            LoginUserSource.getInstance().releaseLoginAccount(loginUserDAO);
            return null;
        }

        AccountCustomer accountCustomer = loginUserDAO.checkLogin(userName,passWord);

        if (accountCustomer == null){
            status = "error3";
            LoginUserSource.getInstance().releaseLoginAccount(loginUserDAO);
            return null;
        }

        LoginUserSource.getInstance().releaseLoginAccount(loginUserDAO);
        return accountCustomer ;
    }

    public  String getStatus() {
        return status;
    }

    public static void main(String[] args) {

    }

}
