package model.address;

import beans.address.Commune;
import beans.address.District;
import beans.address.Provincial;
import worksWithDatabase.address.AddressDataSource;
import worksWithDatabase.address.AddressWorksWithDatabase;
import worksWithDatabase.provincial.ProvincialDataSource;
import worksWithDatabase.provincial.ProvincialWorksWithDatabase;

import java.util.List;

public class AddressModel {

    private static AddressModel addressModel;

    public static AddressModel getInstance() {
        if (addressModel == null) addressModel = new AddressModel();
        return addressModel;
    }

    //  Phương thúc nhận vào mã nhân viên và 3 đối tượgn tỉnh huyện xã, cập nhập mã cho chúng
    public void fillIdToAddressFromId(String ma_nv, Provincial provincial, District district, Commune commune){
        AddressWorksWithDatabase addressWorksWithDatabase = AddressDataSource.getInstance().getAddressWorksWithDatabase();
        addressWorksWithDatabase.fillIdToAddressFromId(ma_nv, provincial, district, commune);
        AddressDataSource.getInstance().releaseAddressWorksWithDatabase(addressWorksWithDatabase);
    }

    //  Phuong thuc nhan vo ma nhan vien, tinh quan huyen cap nhat no lai trong csdl
    public void updateAddressById(String ma_nv, String ma_tinh, String ma_huyen, String ma_xa) {
        AddressWorksWithDatabase addressWorksWithDatabase = AddressDataSource.getInstance().getAddressWorksWithDatabase();
        addressWorksWithDatabase.updateAddressById(ma_nv,ma_tinh,ma_huyen,ma_xa);
        AddressDataSource.getInstance().releaseAddressWorksWithDatabase(addressWorksWithDatabase);
    }

}
