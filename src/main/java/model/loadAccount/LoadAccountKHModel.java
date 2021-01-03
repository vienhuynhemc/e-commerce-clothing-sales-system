package model.loadAccount;

import beans.account.AccountCustomer;
import worksWithDatabase.loadAccount.LoadKHDAO;

import java.util.ArrayList;
import java.util.Map;

public class LoadAccountKHModel {

    private static LoadAccountKHModel loadAccountKH;
    private  int numPage;

    public static  LoadAccountKHModel getInstance(){

        if (loadAccountKH == null){
            loadAccountKH = new LoadAccountKHModel();
        }
        return loadAccountKH;

    }
    public ArrayList<AccountCustomer> loadListKH(int page, String type, String search, String orderby){
         LoadKHDAO loadKHDAO =  new LoadKHDAO();

        ArrayList<AccountCustomer> result = loadKHDAO.LoadKHAll(page,type,search,orderby);
         numPage = loadKHDAO.getNumPage();

         return result;
    }



    public int getNumPage() {
        return numPage;
    }
}
