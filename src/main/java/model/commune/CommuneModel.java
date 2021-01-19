package model.commune;

import beans.address.Commune;
import worksWithDatabase.commune.CommuneDataSource;
import worksWithDatabase.commune.CommuneWorksWithDatabase;

public class CommuneModel {

    private static CommuneModel communeModel;

    public static CommuneModel getInstance() {
        if (communeModel == null) communeModel = new CommuneModel();
        return communeModel;
    }

    //  Phuơng thức nhận vô một Commune điền tên cho nó
    public void fillNameById(Commune commune) {
        CommuneWorksWithDatabase communeWorksWithDatabase = CommuneDataSource.getInstance().getCommuneWorksWithDatabase();
        communeWorksWithDatabase.fillNameById(commune);
        CommuneDataSource.getInstance().releaseCommuneWorksWithDatabase(communeWorksWithDatabase);
    }

}
