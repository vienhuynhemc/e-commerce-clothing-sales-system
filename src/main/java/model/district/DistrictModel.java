package model.district;

import beans.address.District;
import worksWithDatabase.district.DistrictDataSource;
import worksWithDatabase.district.DistrictWorksWithDatabase;

import java.util.List;

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

    //  Phương thức nhận vô mã tỉnh, trả về list huyện của nó
    public List<District> getDistrictByProvincialId(String ma_tinh_thanh) {
        DistrictWorksWithDatabase districtWorksWithDatabase = DistrictDataSource.getInstance().getDistrictWorksWithDatabase();
        List<District> result = districtWorksWithDatabase.getDistrictByProvincialId(ma_tinh_thanh);
        DistrictDataSource.getInstance().releaseDistrictWorksWithDatabase(districtWorksWithDatabase);
        return result;
    }

    //  Phương thức nhận vô một mã huyện trả về huyện đó
    public District getDistrictById(String ma_quan_huyen) {
        DistrictWorksWithDatabase districtWorksWithDatabase = DistrictDataSource.getInstance().getDistrictWorksWithDatabase();
        District result = districtWorksWithDatabase.getDistrictById(ma_quan_huyen);
        DistrictDataSource.getInstance().releaseDistrictWorksWithDatabase(districtWorksWithDatabase);
        return result;
    }

}
