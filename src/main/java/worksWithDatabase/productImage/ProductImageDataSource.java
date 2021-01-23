package worksWithDatabase.productImage;

public class ProductImageDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy ProductImage works with data base
     *      2. Trả ProductImage works with data base
     */

    //  Khai báo ProductImagepool
    private static ProductImagePool productImagePool;

    //  Khai báo instance
    private static ProductImageDataSource productImageDataSource;

    //  Constructor thì khởi tạo ProductImagePool
    private ProductImageDataSource() {
        productImagePool = new ProductImagePool();
    }

    //  Trả về thể hiện của ProductImageDataSource
    public static synchronized ProductImageDataSource getInstance() {

        //  Kiểm tra thử ProductImageDataSource có null?
        if (productImageDataSource == null) {

            //  null thì khởi tạo nó
            productImageDataSource = new ProductImageDataSource();

        }

        //  return về instance
        return productImageDataSource;

    }

    //  Phương thúc lấy ProductImageWorksWithDatabase
    public ProductImageWorksWithDatabase getProductImageWorksWithDatabase() {

        //  Lấy ProductImageWorksWithDatabase từ ProductImagePool
        return productImagePool.getProductImageWorksWithDatabase();

    }

    //  Phương thức trả ProductImageWorksWithDatabase cho ProductImagePool
    public void releaseProductImageWorksWithDatabase(ProductImageWorksWithDatabase productImageWorksWithDatabase) {

        //  Trả ProductImageWorksWithDatabase về cho ProductImagePool
        productImagePool.releaseProductImageWorksWithDatabase(productImageWorksWithDatabase);

    }


}
