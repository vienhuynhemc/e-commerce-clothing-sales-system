package worksWithDatabase.productPrice;

public class ProductPriceDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy ProductPrice works with data base
     *      2. Trả ProductPrice works with data base
     */

    //  Khai báo ProductPricepool
    private static ProductPricePool productPricePool;

    //  Khai báo instance
    private static ProductPriceDataSource productPriceDataSource;

    //  Constructor thì khởi tạo ProductPricePool
    private ProductPriceDataSource() {
        productPricePool = new ProductPricePool();
    }

    //  Trả về thể hiện của ProductPriceDataSource
    public static synchronized ProductPriceDataSource getInstance() {

        //  Kiểm tra thử ProductPriceDataSource có null?
        if (productPriceDataSource == null) {

            //  null thì khởi tạo nó
            productPriceDataSource = new ProductPriceDataSource();

        }

        //  return về instance
        return productPriceDataSource;

    }

    //  Phương thúc lấy ProductPriceWorksWithDatabase
    public ProductPriceWorksWithDatabase getProductPriceWorksWithDatabase() {

        //  Lấy ProductPriceWorksWithDatabase từ ProductPricePool
        return productPricePool.getProductPriceWorksWithDatabase();

    }

    //  Phương thức trả ProductPriceWorksWithDatabase cho ProductPricePool
    public void releaseProductPriceWorksWithDatabase(ProductPriceWorksWithDatabase productPriceWorksWithDatabase) {

        //  Trả ProductPriceWorksWithDatabase về cho ProductPricePool
        productPricePool.releaseProductPriceWorksWithDatabase(productPriceWorksWithDatabase);

    }


}
