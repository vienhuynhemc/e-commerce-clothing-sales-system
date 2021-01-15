package worksWithDatabase.provincial;

import worksWithDatabase.productDetailInformation.ProductDetailInformationDataSource;
import worksWithDatabase.productDetailInformation.ProductDetailInformationWorksWithDatabase;

public class ProvincialDataSource {


    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy ProductDetailInformation works with data base
     *      2. Trả ProductDetailInformation works with data base
     */

    //  Khai báo provincialPool
    private static ProvincialPool provincialPool;

    //  Khai báo instance
    private static ProvincialDataSource provincialDataSource;

    //  Constructor thì khởi tạo provincialPool
    private ProvincialDataSource() {
        provincialPool = new ProvincialPool();
    }

    //  Trả về thể hiện của provincialDataSource
    public static synchronized ProvincialDataSource getInstance() {

        //  Kiểm tra thử ProductDetailInformationDataSource có null?
        if (provincialDataSource == null) {

            //  null thì khởi tạo nó
           provincialDataSource = new ProvincialDataSource();

        }

        //  return về instance
        return provincialDataSource;

    }

    //  Phương thúc lấy ProvincialWorksWithDatabase
    public ProvincialWorksWithDatabase getProvincialWorksWithDatabase() {

        //  Lấy ProvincialWorksWithDatabase từ provincialPool
        return provincialPool.getProvincialWorksWithDatabase();

    }

    //  Phương thức trả ProvincialWorksWithDatabase cho provincialPool
    public void releaseProvincialWorksWithDatabase(ProvincialWorksWithDatabase provincialWorksWithDatabase) {

        //  Trả ProvincialWorksWithDatabase về cho provincialPool
        provincialPool.releaseProvincialWorksWithDatabase(provincialWorksWithDatabase);

    }


}
