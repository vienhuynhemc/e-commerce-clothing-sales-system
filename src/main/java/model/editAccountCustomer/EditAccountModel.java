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

        if (oldPass.equals("") && newPass.equals("") && rePass.equals("")){
            EditAccountSource.getInstance().releaseEditAccount(editAccountDAO);
            return "OK";
        }else if(!editAccountDAO.checkOldPassWord(userName,oldPass)){
            EditAccountSource.getInstance().releaseEditAccount(editAccountDAO);
            return "error1";
        }else if(!rePass.equals(newPass)){
            EditAccountSource.getInstance().releaseEditAccount(editAccountDAO);
            return "error2";
        }

        EditAccountSource.getInstance().releaseEditAccount(editAccountDAO);
        return "OK";
    }
    public AccountCustomer editAccount(String userName, String displayName, String fullName, String avatar, String newPass,String oldPass,String rePass){
        EditAccountDAO editAccountDAO = EditAccountSource.getInstance().getEditAccount();

        AccountCustomer accountCustomer =  editAccountDAO.changeInfoCustomer(userName,displayName,fullName,avatar,newPass,oldPass,rePass);

        EditAccountSource.getInstance().releaseEditAccount(editAccountDAO);
        return accountCustomer;
    }
}
