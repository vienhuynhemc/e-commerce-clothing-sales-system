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
    public int removeAccount(ArrayList<String> list){

        RemoveAccountKHDAO removeAccountDAO = RemoveAccountKHSource.getInstance().getRemoveAccount();
        int result = 0;
        for (String acc: list ) {
            if (removeAccountDAO.removeAccount(acc)){
                result++;
            }
        }
        RemoveAccountKHSource.getInstance().releaseRemoveAccount(removeAccountDAO);
        return result;
    }
}
