package worksWithDatabase.product;

public class ProductDataSource {


    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy Product works with data base
     *      2. Trả Product works with data base
     */

    //  Khai báo productpool
    private static ProductPool productPool;

    //  Khai báo instance
    private static ProductDataSource productDataSource;

    //  Constructor thì khởi tạo ProductPool
    private ProductDataSource() {
        productPool = new ProductPool();
    }

    //  Trả về thể hiện của ProductDataSource
    public static synchronized ProductDataSource getInstance() {

        //  Kiểm tra thử ProductDataSource có null?
        if (productDataSource == null) {

            //  null thì khởi tạo nó
            productDataSource = new ProductDataSource();

        }

        //  return về instance
        return productDataSource;

    }

    //  Phương thúc lấy ProductWorksWithDatabase
    public ProductWorksWithDatabase getProductWorksWithDatabase() {

        //  Lấy ProductWorksWithDatabase từ ProductPool
        return productPool.getProductWorksWithDatabase();

    }

    //  Phương thức trả ProductWorksWithDatabase cho ProductPool
    public void releaseProductWorksWithDatabase(ProductWorksWithDatabase productWorksWithDatabase) {

        //  Trả ProductWorksWithDatabase về cho ProductPool
        productPool.releaseProductWorksWithDatabase(productWorksWithDatabase);

    }

}
