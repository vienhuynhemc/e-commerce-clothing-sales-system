package model.district;

import beans.address.District;
import worksWithDatabase.district.DistrictDataSource;
import worksWithDatabase.district.DistrictWorksWithDatabase;

public class DistrictModel {

    private static DistrictModel districtModel;

    public static DistrictModel getInstance() {
        if (districtModel == null) {
            districtModel = new DistrictModel();
        }
        return districtModel;
    }

    //  Phuơng thức nhận vô một District điền tên cho nó
    public void fillNameById(District district) {
        DistrictWorksWithDatabase districtWorksWithDatabase = DistrictDataSource.getInstance().getDistrictWorksWithDatabase();
        districtWorksWithDatabase.fillNameById(district);
        DistrictDataSource.getInstance().releaseDistrictWorksWithDatabase(districtWorksWithDatabase);
    }

}
