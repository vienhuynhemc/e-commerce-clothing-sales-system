package model.loadAccount;

import beans.account.AccountKH;
import worksWithDatabase.loadAccount.LoadKHDAO;
import worksWithDatabase.loadAccount.LoadKHSource;

import java.util.Map;

public class LoadAccountKHModel {

    private static LoadAccountKHModel loadAccountKH;

    private LoadAccountKHModel(){
        loadAccountKH = new LoadAccountKHModel();
    }
    
    public static synchronized LoadAccountKHModel getInstance(){

        if (loadAccountKH == null){
            loadAccountKH = new LoadAccountKHModel();
        }
        return loadAccountKH;

    }
    public Map<String, AccountKH> loadListKH(){
         LoadKHDAO loadKHDAO =  LoadKHSource.getInstance().getLoadKHDAO();

         Map<String,AccountKH> result = loadKHDAO.loadListKH();

         LoadKHSource.getInstance().releaseLoadKH(loadKHDAO);

         return result;
    }
}
