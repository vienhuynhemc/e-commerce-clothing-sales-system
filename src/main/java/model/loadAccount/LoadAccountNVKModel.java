package model.loadAccount;
import beans.account.AccountEmployee;
import worksWithDatabase.loadAccount.LoadNVKDAO;

import java.util.ArrayList;

public class LoadAccountNVKModel {
    private static LoadAccountNVKModel loadAccountNVK;

    public static LoadAccountNVKModel getInstance(){

        if (loadAccountNVK == null){
            loadAccountNVK = new LoadAccountNVKModel();
        }
        return loadAccountNVK;

    }
    public ArrayList<AccountEmployee> loadListNVK(int page, String type, String search, String orderby){

        LoadNVKDAO loadNVKDAO =  new LoadNVKDAO();

       ArrayList<AccountEmployee> result = loadNVKDAO.loadNVKAll(page,type,search,orderby);

        return result;
    }


}
