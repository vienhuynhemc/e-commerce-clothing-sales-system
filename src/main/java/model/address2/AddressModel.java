package model.address2;

import beans.address.Commune;
import beans.address.District;
import beans.address.Provincial;
import worksWithDatabase.address2.LoadAddressDAO;

import java.util.ArrayList;

public class AddressModel {
    private static AddressModel addressModel;

    public static AddressModel getInstance() {
        if (addressModel == null) addressModel = new AddressModel();
        return addressModel;
    }

    public ArrayList<Provincial> listProvincial(){

        return new LoadAddressDAO().listProvincial();

    }
    public ArrayList<District> listDistrictByID(String ma_tinh){
        return new LoadAddressDAO().listDistrictByID(ma_tinh);
    }
    public ArrayList<Commune> listCommuneID(String ma_quan_huyen){
        return  new LoadAddressDAO().listCommuneID(ma_quan_huyen);
    }

}
