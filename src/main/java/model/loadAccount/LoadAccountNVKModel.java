package model.loadAccount;
import beans.account.AccountNVK;
import worksWithDatabase.loadAccount.LoadNVKDAO;

import java.util.Map;

public class LoadAccountNVKModel {
    private static LoadAccountNVKModel loadAccountNVK;

    public static LoadAccountNVKModel getInstance(){

        if (loadAccountNVK == null){
            loadAccountNVK = new LoadAccountNVKModel();
        }
        return loadAccountNVK;

    }
    public Map<String, AccountNVK> loadListNVK(int num){

        LoadNVKDAO loadNVKDAO =  new LoadNVKDAO();

        Map<String,AccountNVK> result = loadNVKDAO.loadListNVK(num);

        return result;
    }


}
