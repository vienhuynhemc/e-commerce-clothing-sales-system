package model.signUp;

import worksWithDatabase.signUpUser.SignUpDAO;
import worksWithDatabase.signUpUser.SignUpDataSource;

public class SignUp {
    private static SignUp signUp;

    public static SignUp getInstance(){
        if(signUp == null){
            signUp = new SignUp();
        }
        return signUp;
    }

    // kiểm tra thông tin đầu vào
    public String checkUserInput(String username, String pass, String name,String phone, String mail, String check){
        SignUpDAO signUpDAO = SignUpDataSource.getInstance().getSignUpDAO();
        if (username.equals("") || pass.equals("") || name.equals("") || phone.equals("") || mail.equals("")){
            return "no";
        }
        // kiểm tra có tồn tại username chưa
        if(SignUpDAO.checkUser(username)){
            SignUpDataSource.getInstance().releaseSignUpDAO(signUpDAO);
            return "error2";
        }
        // kiểm tra mail có tồn tại mail trong db không
        if(SignUpDAO.checkMail(mail)){
            SignUpDataSource.getInstance().releaseSignUpDAO(signUpDAO);
            return "error1";
        }
        // kiểm tra email có tồn tại không
        if(SignUpDAO.isEmail(mail)){
            SignUpDataSource.getInstance().releaseSignUpDAO(signUpDAO);
            return "error3";
        }
        // kiểm tra xem người dùng có đồng ý thỏa thuận chưa
        if(check == null){
            SignUpDataSource.getInstance().releaseSignUpDAO(signUpDAO);
            return "error4";
        }

        SignUpDAO.addUser(username, pass, name, phone, mail);
        SignUpDataSource.getInstance().releaseSignUpDAO(signUpDAO);
        return "OK";
    }

    public static void main(String[] args) {
        SignUp s = new SignUp();
        String username = "nhattruongagtm";
        String pass = "123456789";
        String name = "Truong";
        String phone = "0384458719";
        String mail = "nhattruongagtm@gmail.com";
        System.out.println(s.checkUserInput(username,pass,name,phone,mail,"on"));
    }



}
