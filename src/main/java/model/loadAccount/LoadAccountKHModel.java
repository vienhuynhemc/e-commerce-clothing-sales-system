package model.loadAccount;

import beans.account.AccountCustomer;
import worksWithDatabase.loadAccount.LoadKHDAO;

import java.util.Map;

public class LoadAccountKHModel {

    private static LoadAccountKHModel loadAccountKH;

    public static  LoadAccountKHModel getInstance(){

        if (loadAccountKH == null){
            loadAccountKH = new LoadAccountKHModel();
        }
        return loadAccountKH;

    }
    public Map<String, AccountCustomer> loadListKH(int num){
         LoadKHDAO loadKHDAO =  new LoadKHDAO();

         Map<String, AccountCustomer> result = loadKHDAO.loadListKH(num);

         return result;
    }
}
