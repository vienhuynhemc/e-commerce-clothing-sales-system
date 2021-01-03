package model.removeAccount;

import worksWithDatabase.removeAccount.RemoveAccountDAO;

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
        RemoveAccountDAO removeAccountDAO = new RemoveAccountDAO();
        for (String acc: list ) {
            removeAccountDAO.RemoveAccountDAO(acc);
        }
    }

}
