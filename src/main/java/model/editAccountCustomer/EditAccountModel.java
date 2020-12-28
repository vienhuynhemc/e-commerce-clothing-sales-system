package model.editAccountCustomer;


import beans.account.AccountCustomer;
import worksWithDatabase.editAccountCustomer.EditAccountDAO;
import worksWithDatabase.editAccountCustomer.EditAccountSource;

public class EditAccountModel {
    private static EditAccountModel editAccountNVKModel;

    public static EditAccountModel getInstance(){

        if(editAccountNVKModel == null){
            editAccountNVKModel = new EditAccountModel();
        }
        return editAccountNVKModel;

    }
    public String chessPass(String userName,String oldPass,String newPass,String rePass){

        EditAccountDAO editAccountDAO = EditAccountSource.getInstance().getEditAccount();

        if(!editAccountDAO.checkOldPassWord(userName,oldPass)){
            EditAccountSource.getInstance().releaseEditAccount(editAccountDAO);
            return "error1";
        }
        if(!rePass.equals(newPass)){
            EditAccountSource.getInstance().releaseEditAccount(editAccountDAO);
            return "error2";
        }
        EditAccountSource.getInstance().releaseEditAccount(editAccountDAO);
        return "OK";
    }
    public AccountCustomer editAccount(String userName, String displayName, String fullName, String avatar, String newPass){
        EditAccountDAO editAccountDAO = EditAccountSource.getInstance().getEditAccount();

        AccountCustomer accountCustomer =  editAccountDAO.changeInfoCustomer(userName,displayName,fullName,avatar,newPass);

        EditAccountSource.getInstance().releaseEditAccount(editAccountDAO);
        return accountCustomer;
    }
}
