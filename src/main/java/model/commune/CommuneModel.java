package model.commune;

import beans.address.Commune;
import worksWithDatabase.commune.CommuneDataSource;
import worksWithDatabase.commune.CommuneWorksWithDatabase;

import java.util.List;

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

    //  Phương thức nhận vào mã quận huyện trả về list phường xã
    public List<Commune> getCommuneByDistrictId(String ma_quan_huyen) {
        CommuneWorksWithDatabase communeWorksWithDatabase = CommuneDataSource.getInstance().getCommuneWorksWithDatabase();
        List<Commune> result = communeWorksWithDatabase.getCommuneByDistrictId(ma_quan_huyen);
        CommuneDataSource.getInstance().releaseCommuneWorksWithDatabase(communeWorksWithDatabase);
        return result;
    }

    //  Phuong thuc nhan vo ma phuong xa tra ve phuong xa do
    public Commune getCommuneById(String ma_phuong_xa) {
        CommuneWorksWithDatabase communeWorksWithDatabase = CommuneDataSource.getInstance().getCommuneWorksWithDatabase();
        Commune result = communeWorksWithDatabase.getCommuneById(ma_phuong_xa);
        CommuneDataSource.getInstance().releaseCommuneWorksWithDatabase(communeWorksWithDatabase);
        return result;
    }

}
