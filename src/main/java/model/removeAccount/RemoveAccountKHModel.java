package model.removeAccount;


import worksWithDatabase.removeAccount.RemoveAccountKHDAO;
import worksWithDatabase.removeAccount.RemoveAccountKHSource;

import java.util.ArrayList;

public class RemoveAccountKHModel {
    private static RemoveAccountKHModel removeAccountModel;

    public static RemoveAccountKHModel getInstance(){
        if (removeAccountModel == null){
            removeAccountModel = new RemoveAccountKHModel();
        }
        return removeAccountModel;
    }
    public void removeAccount(ArrayList<String> list){

        RemoveAccountKHDAO removeAccountDAO = RemoveAccountKHSource.getInstance().getRemoveAccount();
        for (String acc: list ) {
            removeAccountDAO.removeAccount(acc);
        }
        RemoveAccountKHSource.getInstance().releaseRemoveAccount(removeAccountDAO);
    }
}
