package worksWithDatabase.productInformation;

public class ProductInformationDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy ProductInformation works with data base
     *      2. Trả ProductInformation works with data base
     */

    //  Khai báo ProductInformationpool
    private static ProductInformationPool productInformationPool;

    //  Khai báo instance
    private static ProductInformationDataSource productInformationDataSource;

    //  Constructor thì khởi tạo ProductInformationPool
    private ProductInformationDataSource() {
        productInformationPool = new ProductInformationPool();
    }

    //  Trả về thể hiện của ProductInformationDataSource
    public static synchronized ProductInformationDataSource getInstance() {

        //  Kiểm tra thử ProductInformationDataSource có null?
        if (productInformationDataSource == null) {

            //  null thì khởi tạo nó
            productInformationDataSource = new ProductInformationDataSource();

        }

        //  return về instance
        return productInformationDataSource;

    }

    //  Phương thúc lấy ProductInformationWorksWithDatabase
    public ProductInformationWorksWithDatabase getProductInformationWorksWithDatabase() {

        //  Lấy ProductInformationWorksWithDatabase từ ProductInformationPool
        return productInformationPool.getProductInformationWorksWithDatabase();

    }

    //  Phương thức trả ProductInformationWorksWithDatabase cho ProductInformationPool
    public void releaseProductInformationWorksWithDatabase(ProductInformationWorksWithDatabase productInformationWorksWithDatabase) {

        //  Trả ProductInformationWorksWithDatabase về cho ProductInformationPool
        productInformationPool.releaseProductInformationWorksWithDatabase(productInformationWorksWithDatabase);

    }


}
