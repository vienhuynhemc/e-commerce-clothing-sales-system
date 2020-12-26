package worksWithDatabase.manufacturer;

public class ManufacturerDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy ManufacturerWorksWithDatabase()
     *      2. Trả ManufacturerWorksWithDatabase()
     */

    //  Khai báo ManufacturerPool
    private static ManufacturerPool manufacturerPool;

    //  Khai báo instance
    private static ManufacturerDataSource manufacturerDataSource;

    //  Constructor thì khởi tạo ManufacturerPool
    private ManufacturerDataSource() {
        manufacturerPool = new ManufacturerPool();
    }

    //  Trả về thể hiện của ManufacturerDataSource
    public static synchronized ManufacturerDataSource getInstance() {

        //  Kiểm tra thử ManufacturerDataSource có null?
        if (manufacturerDataSource == null) {

            //  null thì khởi tạo nó
            manufacturerDataSource = new ManufacturerDataSource();

        }

        //  return về instance
        return manufacturerDataSource;

    }

    //  Phương thúc lấy ManufacturerWorksWithDatabase
    public ManufacturerWorksWithDatabase getManufacturerWorksWithDatabase() {

        //  Lấy ManufacturerWorksWithDatabase từ ManufacturerPool
        return manufacturerPool.getManufacturerWorksWithDatabase();

    }

    //  Phương thức trả ManufacturerWorksWithDatabase cho ManufacturerPool
    public void releaseManufacturerWorksWithDatabase(ManufacturerWorksWithDatabase manufacturerWorksWithDatabase) {

        //  Trả ManufacturerWorksWithDatabase về cho ManufacturerPool
        manufacturerPool.releaseManufacturerWorksWithDatabase(manufacturerWorksWithDatabase);

    }

}
