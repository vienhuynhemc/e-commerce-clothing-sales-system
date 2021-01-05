package model.loadAccount;

import beans.account.AccountEmployee;
import worksWithDatabase.loadAccount.LoadNVVCDAO;

import java.util.ArrayList;
import java.util.Map;

public class LoadAccountNVVCModel {

    private static LoadAccountNVVCModel loadAccountNVVC;

    public static LoadAccountNVVCModel getInstance(){

        if (loadAccountNVVC == null){
            loadAccountNVVC = new LoadAccountNVVCModel();
        }
        return loadAccountNVVC;

    }
    public ArrayList<AccountEmployee> loadListNVK(int page, String type, String search, String orderby){

        LoadNVVCDAO loadNVKDAO =  new LoadNVVCDAO();

        ArrayList<AccountEmployee> result = loadNVKDAO.loadNVVCAll(page,type,search,orderby);

        return result;
    }
}
