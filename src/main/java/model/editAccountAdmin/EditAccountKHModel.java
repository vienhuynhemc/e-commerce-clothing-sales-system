package model.editAccountAdmin;


import worksWithDatabase.editAccountAdmin.EditAccountKHDAO;
import worksWithDatabase.editAccountAdmin.EditAccountKHSource;

public class EditAccountKHModel {
    private static EditAccountKHModel editAccountModel;

    public static EditAccountKHModel getInstance(){

        if(editAccountModel == null){
            editAccountModel = new EditAccountKHModel();
        }
        return editAccountModel;

    }
    public String editAccount(String userName,String fullName,String avatar,String displayName,String activeStatus,String activeEvaluate,String passWord,String rePass){
        // lấy ra
        EditAccountKHDAO editAccountDAO = EditAccountKHSource.getInstance().getEditAccount();

        // chess repass vs pass trc nếu nhập sai thì trả về luôn
        if(!passWord.equals(rePass)){
            EditAccountKHSource.getInstance().releaseEditAccount(editAccountDAO);
            return "error1";
            // mật khẩu ít nhất 6 kí tự và có chũ và số
        }else if (passWord.matches("\"^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$\"")){
            EditAccountKHSource.getInstance().releaseEditAccount(editAccountDAO);
            return "error2";
        }

        editAccountDAO.updateAccountKH(userName,fullName,avatar,displayName,activeStatus,activeEvaluate,passWord);

        // sửa xog trả kết nối lại

        EditAccountKHSource.getInstance().releaseEditAccount(editAccountDAO);
        return "OK";
    }
}
