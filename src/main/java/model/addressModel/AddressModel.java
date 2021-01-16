package model.addressModel;

import beans.address.Provincial;
import worksWithDatabase.provincial.ProvincialDataSource;
import worksWithDatabase.provincial.ProvincialWorksWithDatabase;

import java.util.List;

public class AddressModel {

    private static AddressModel addressModel;

    public static AddressModel getInstance() {
        if (addressModel == null) addressModel = new AddressModel();
        return addressModel;
    }

    //  Phương thức trả về một list đẩy đủ các tỉnh thành
    public List<Provincial> getListProvincial() {

        ProvincialWorksWithDatabase provincialWorksWithDatabase = ProvincialDataSource.getInstance().getProvincialWorksWithDatabase();
        List<Provincial> provincials = provincialWorksWithDatabase.getListProvincial();
        ProvincialDataSource.getInstance().releaseProvincialWorksWithDatabase(provincialWorksWithDatabase);

        return provincials;

    }

}
