package model.loadAccount;


import beans.account.AccountCustomer;
import worksWithDatabase.loadAccount.LoadKHDAO;

import java.util.ArrayList;
import java.util.Map;

public class LoadKHStartModel {
    private static LoadKHStartModel loadAccountKH;

    public static  LoadKHStartModel getInstance(){

        if (loadAccountKH == null){
            loadAccountKH = new LoadKHStartModel();
        }
        return loadAccountKH;

    }
    public ArrayList<AccountCustomer> loadListKH(){
        LoadKHDAO loadKHDAO =  new LoadKHDAO();

        //Map<String, AccountCustomer> result = loadKHDAO.loadListKH(num);

        ArrayList<AccountCustomer> result = loadKHDAO.loadListKH();

        return result;
    }

}
