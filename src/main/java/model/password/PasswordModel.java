package model.password;

public class PasswordModel {

    private static PasswordModel passwordModel;

    public static PasswordModel getInstance(){
        if(passwordModel == null){
            passwordModel = new PasswordModel();
        }
        return passwordModel;
    }


    public String coverPasswordToStars(String password){
        String result = "";
        for(int i =0; i < password.length();i++){
            result+="*";
        }
        return result;
    }

}
