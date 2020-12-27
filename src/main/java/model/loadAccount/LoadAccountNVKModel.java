package model.loadAccount;
import beans.account.AccountEmployee;
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
    public Map<String, AccountEmployee> loadListNVK(int num){

        LoadNVKDAO loadNVKDAO =  new LoadNVKDAO();

        Map<String, AccountEmployee> result = loadNVKDAO.loadListNVK(num);

        return result;
    }


}
