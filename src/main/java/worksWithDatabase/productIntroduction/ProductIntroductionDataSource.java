package worksWithDatabase.productIntroduction;


public class ProductIntroductionDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy ProductIntroduction works with data base
     *      2. Trả ProductIntroduction works with data base
     */

    //  Khai báo ProductIntroductionpool
    private static ProductIntroductionPool productIntroductionPool;

    //  Khai báo instance
    private static ProductIntroductionDataSource productIntroductionDataSource;

    //  Constructor thì khởi tạo ProductIntroductionPool
    private ProductIntroductionDataSource() {
        productIntroductionPool = new ProductIntroductionPool();
    }

    //  Trả về thể hiện của ProductIntroductionDataSource
    public static synchronized ProductIntroductionDataSource getInstance() {

        //  Kiểm tra thử ProductIntroductionDataSource có null?
        if (productIntroductionDataSource == null) {

            //  null thì khởi tạo nó
            productIntroductionDataSource = new ProductIntroductionDataSource();

        }

        //  return về instance
        return productIntroductionDataSource;

    }

    //  Phương thúc lấy ProductIntroductionWorksWithDatabase
    public ProductIntroductionWorksWithDatabase getProductIntroductionWorksWithDatabase() {

        //  Lấy ProductIntroductionWorksWithDatabase từ ProductIntroductionPool
        return productIntroductionPool.getProductIntroductionWorksWithDatabase();

    }

    //  Phương thức trả ProductIntroductionWorksWithDatabase cho ProductIntroductionPool
    public void releaseProductIntroductionWorksWithDatabase(ProductIntroductionWorksWithDatabase productIntroductionWorksWithDatabase) {

        //  Trả ProductIntroductionWorksWithDatabase về cho ProductIntroductionPool
        productIntroductionPool.releaseProductIntroductionWorksWithDatabase(productIntroductionWorksWithDatabase);

    }


}
