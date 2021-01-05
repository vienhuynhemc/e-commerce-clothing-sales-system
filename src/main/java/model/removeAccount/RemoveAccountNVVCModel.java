package model.removeAccount;

import worksWithDatabase.removeAccount.RemoveAccountNVVCDAO;
import worksWithDatabase.removeAccount.RemoveAccountNVVCSource;

import java.util.ArrayList;

public class RemoveAccountNVVCModel {

    private static RemoveAccountNVVCModel removeAccountModel;

    public static RemoveAccountNVVCModel getInstance(){
        if (removeAccountModel == null){
            removeAccountModel = new RemoveAccountNVVCModel();
        }
        return removeAccountModel;
    }
    public void removeAccount(ArrayList<String> list){

        RemoveAccountNVVCDAO removeAccountDAO = RemoveAccountNVVCSource.getInstance().getRemoveAccount();
        for (String acc: list ) {
            removeAccountDAO.removeAccountDAO(acc);
        }
        RemoveAccountNVVCSource.getInstance().releaseAddAccount(removeAccountDAO);
    }
}
