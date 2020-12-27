package model.loadAccount;

import worksWithDatabase.loadAccount.LoadNextPageKH;

public class LoadNextPageModel {

    private static LoadNextPageModel loadNextPageModel;

    public static LoadNextPageModel getInstance(){

        if(loadNextPageModel == null) {
            loadNextPageModel = new LoadNextPageModel();
        }
        return loadNextPageModel;

    }
    public int loadNumberPageKH(){
        return new LoadNextPageKH().loadNextPageKH();
    }

}
