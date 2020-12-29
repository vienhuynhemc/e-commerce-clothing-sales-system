package model.manufacturer;

import worksWithDatabase.manufacturerInformation.ManufacturerInformationDataSource;
import worksWithDatabase.manufacturerInformation.ManufacturerInformationWorksWithDatabase;

public class ManufacturerInformationModel {

    //  Tạo thể hiện cho lớp
    private static ManufacturerInformationModel manufacturerInformationModel;

    //  Phương thức lấy thể hiện
    public static ManufacturerInformationModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (manufacturerInformationModel == null) {
            manufacturerInformationModel = new ManufacturerInformationModel();
        }

        //  Trả về thể hiện
        return manufacturerInformationModel;

    }

    //  Phương thức nhận vào ma_hsx và list information
    public boolean addInformationToDatabase(String manufacturerId, String[] informations) {

        //  Lấy ông thông tin sản xuất làm việc với database
        ManufacturerInformationWorksWithDatabase manufacturerInformationWorksWithDatabase = ManufacturerInformationDataSource.getInstance().getManufacturerInformationWorksWithDatabase();

        //  Add to database
        boolean result = manufacturerInformationWorksWithDatabase.addInformationToDatabase(manufacturerId, informations);

        //  Lấy thì trả
        ManufacturerInformationDataSource.getInstance().releaseManufacturerInformationWorksWithDatabase(manufacturerInformationWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

}
