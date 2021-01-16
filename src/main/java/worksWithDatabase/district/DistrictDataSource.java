package worksWithDatabase.district;

public class DistrictDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy district works with data base
     *      2. Trả district works with data base
     */

    //  Khai báo districtpool
    private static DistrictPool districtPool;

    //  Khai báo instance
    private static DistrictDataSource districtDataSource;

    //  Constructor thì khởi tạo districtPool
    private DistrictDataSource() {
        districtPool = new DistrictPool();
    }

    //  Trả về thể hiện của districtDataSource
    public static synchronized DistrictDataSource getInstance() {

        //  Kiểm tra thử districtDataSource có null?
        if (districtDataSource == null) {

            //  null thì khởi tạo nó
            districtDataSource = new DistrictDataSource();

        }

        //  return về instance
        return districtDataSource;

    }

    //  Phương thúc lấy districtWorksWithDatabase
    public DistrictWorksWithDatabase getDistrictWorksWithDatabase() {

        //  Lấy districtWorksWithDatabase từ districtPool
        return districtPool.getDistrictWorksWithDatabase();

    }

    //  Phương thức trả districtWorksWithDatabase cho districtPool
    public void releaseDistrictWorksWithDatabase(DistrictWorksWithDatabase districtWorksWithDatabase) {

        //  Trả districtWorksWithDatabase về cho districtPool
        districtPool.releaseDistrictWorksWithDatabase(districtWorksWithDatabase);

    }

}
