package model.editAccountCustomer;

import worksWithDatabase.editAccountCustomer.RemoveAccountDAO;
import worksWithDatabase.editAccountCustomer.RemoveAccountSource;

public class RemoveAccountModel {

    private static RemoveAccountModel editAccountNVKModel;

    public static RemoveAccountModel getInstance(){

        if(editAccountNVKModel == null){
            editAccountNVKModel = new RemoveAccountModel();
        }
        return editAccountNVKModel;

    }
    public boolean removeAccount(String id){

        RemoveAccountDAO removeAccountDAO = RemoveAccountSource.getInstance().getEditAccount();
        boolean check = removeAccountDAO.removeAccount(id);

        RemoveAccountSource.getInstance().releaseEditAccount(removeAccountDAO);

        return check;

    }

}
