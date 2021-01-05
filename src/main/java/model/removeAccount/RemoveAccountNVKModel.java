package model.removeAccount;

import worksWithDatabase.removeAccount.RemoveAccountNVKDAO;
import worksWithDatabase.removeAccount.RemoveAccountNVKSource;

import java.util.ArrayList;

public class RemoveAccountNVKModel {

    private static RemoveAccountNVKModel removeAccountModel;

    public static RemoveAccountNVKModel getInstance(){
        if (removeAccountModel == null){
            removeAccountModel = new RemoveAccountNVKModel();
        }
        return removeAccountModel;
    }
    public void removeAccount(ArrayList<String> list){

        RemoveAccountNVKDAO removeAccountDAO = RemoveAccountNVKSource.getInstance().getRemoveAccount();
        for (String acc: list ) {
            removeAccountDAO.removeAccountDAO(acc);
        }
        RemoveAccountNVKSource.getInstance().releaseAddAccount(removeAccountDAO);
    }

}
