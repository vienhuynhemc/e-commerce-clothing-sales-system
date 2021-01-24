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
    public AccountCustomer editAccount(String userName, String displayName, String fullName, String avatar){
        EditAccountDAO editAccountDAO = EditAccountSource.getInstance().getEditAccount();

        AccountCustomer accountCustomer =  editAccountDAO.changeInfoCustomer(userName,displayName,fullName,avatar);

        EditAccountSource.getInstance().releaseEditAccount(editAccountDAO);
        return accountCustomer;
    }
}
