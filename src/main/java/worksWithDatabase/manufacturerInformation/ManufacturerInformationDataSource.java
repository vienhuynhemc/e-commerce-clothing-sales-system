package worksWithDatabase.manufacturerInformation;

public class ManufacturerInformationDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy ManufacturerInformationWorksWithDatabase
     *      2. Trả ManufacturerInformationWorksWithDatabase
     */

    //  Khai báo manufacturerInformationPool
    private static ManufacturerInformationPool manufacturerInformationPool;

    //  Khai báo instance
    private static ManufacturerInformationDataSource manufacturerInformationDataSource;

    //  Constructor thì khởi tạo ManufacturerInformationPool
    private ManufacturerInformationDataSource() {
        manufacturerInformationPool = new ManufacturerInformationPool();
    }

    //  Trả về thể hiện của ManufacturerInformationDataSource
    public static synchronized ManufacturerInformationDataSource getInstance() {

        //  Kiểm tra thử ManufacturerInformationDataSource có null?
        if (manufacturerInformationDataSource == null) {

            //  null thì khởi tạo nó
            manufacturerInformationDataSource = new ManufacturerInformationDataSource();

        }

        //  return về instance
        return manufacturerInformationDataSource;

    }

    //  Phương thúc lấy ManufacturerInformationWorksWithDatabase
    public ManufacturerInformationWorksWithDatabase getManufacturerInformationWorksWithDatabase() {

        //  Lấy ManufacturerInformationWorksWithDatabase từ ManufacturerInformationPool
        return manufacturerInformationPool.getManufacturerInformationWorksWithDatabase();

    }

    //  Phương thức trả ManufacturerInformationWorksWithDatabase cho ManufacturerInformationPool
    public void releaseManufacturerInformationWorksWithDatabase(ManufacturerInformationWorksWithDatabase manufacturerInformationWorksWithDatabase) {

        //  Trả ManufacturerInformationWorksWithDatabase về cho ManufacturerInformationPool
        manufacturerInformationPool.releaseManufacturerInformationWorksWithDatabase(manufacturerInformationWorksWithDatabase);

    }

}
