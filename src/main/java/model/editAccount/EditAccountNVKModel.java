package model.editAccount;

import worksWithDatabase.editAccount.EditAccountNVKDAO;
import worksWithDatabase.editAccount.EditAccountNVKSource;

public class EditAccountNVKModel {

    private static EditAccountNVKModel editAccountNVKModel;

    public static EditAccountNVKModel getInstance(){

        if(editAccountNVKModel == null){
            editAccountNVKModel = new EditAccountNVKModel();
        }
        return editAccountNVKModel;

    }
    public String editAccount(String idUser,String fullName,String displayName,String tinh,String huyen,String xa,String passWord,String rePass,String avatar,String salary,String num){
        // lấy ra
        EditAccountNVKDAO editAccountNVKDAO = EditAccountNVKSource.getInstance().getEditAccount();

        // chess repass vs pass trc nếu nhập sai thì trả về luôn
        if(!passWord.equals(rePass)){
            EditAccountNVKSource.getInstance().releaseEditAccount(editAccountNVKDAO);
            return "error1";
        }
        // nếu k có lỗi thì sửa thôi
        String address = xa + " - " + huyen + " - " + tinh;

        editAccountNVKDAO.upDateAccountNVK(idUser,fullName,displayName,address,passWord,avatar,salary,num);

        // sửa xog trả kết nối lại

        EditAccountNVKSource.getInstance().releaseEditAccount(editAccountNVKDAO);
        return "OK";
    }


}
