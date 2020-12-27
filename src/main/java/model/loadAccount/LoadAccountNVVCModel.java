package model.loadAccount;

import beans.account.AccountEmployee;
import worksWithDatabase.loadAccount.LoadNVVCDAO;

import java.util.Map;

public class LoadAccountNVVCModel {

    private static LoadAccountNVVCModel loadAccountNVVC;

    public static LoadAccountNVVCModel getInstance(){

        if (loadAccountNVVC == null){
            loadAccountNVVC = new LoadAccountNVVCModel();
        }
        return loadAccountNVVC;

    }
    public Map<String, AccountEmployee> loadListNVVC(int num){

        LoadNVVCDAO loadNVKDAO =  new LoadNVVCDAO();

        Map<String, AccountEmployee> result = loadNVKDAO.loadListNVVC(num);

        return result;
    }
}
