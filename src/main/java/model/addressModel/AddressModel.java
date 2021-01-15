package model.addressModel;

import beans.address.Provincial;
import worksWithDatabase.provincial.ProvincialDataSource;
import worksWithDatabase.provincial.ProvincialWorksWithDatabase;

import java.util.ArrayList;
import java.util.List;

public class AddressModel {

    private static AddressModel addressModel;

    public static AddressModel getInstance() {
        if (addressModel == null) addressModel = new AddressModel();
        return addressModel;
    }

    //  Phương thức trả về một list đẩy đủ các tỉnh thành
    public List<Provincial> getListProvincial() {

        //  Trước tiên tạo một list Provincial, đưa vô cho thằng Provincial works with database nó fill dữ liệu vào
        List<Provincial> provincials = new ArrayList<Provincial>();

        //  Điền thông tin tỉnh
        ProvincialWorksWithDatabase provincialWorksWithDatabase = ProvincialDataSource.getInstance().getProvincialWorksWithDatabase();
        provincialWorksWithDatabase.fillInformation(provincials);
        ProvincialDataSource.getInstance().releaseProvincialWorksWithDatabase(provincialWorksWithDatabase);

        //  Trả về kết quả
        return provincials;
    }

}
