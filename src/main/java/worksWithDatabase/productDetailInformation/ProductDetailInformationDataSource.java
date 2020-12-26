package worksWithDatabase.productDetailInformation;

public class ProductDetailInformationDataSource {


    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy ProductDetailInformation works with data base
     *      2. Trả ProductDetailInformation works with data base
     */

    //  Khai báo productDetailInformationpool
    private static ProductDetailInformationPool productDetailInformationPool;

    //  Khai báo instance
    private static ProductDetailInformationDataSource productDetailInformationDataSource;

    //  Constructor thì khởi tạo ProductDetailInformationPool
    private ProductDetailInformationDataSource() {
        productDetailInformationPool = new ProductDetailInformationPool();
    }

    //  Trả về thể hiện của ProductDetailInformationDataSource
    public static synchronized ProductDetailInformationDataSource getInstance() {

        //  Kiểm tra thử ProductDetailInformationDataSource có null?
        if (productDetailInformationDataSource == null) {

            //  null thì khởi tạo nó
            productDetailInformationDataSource = new ProductDetailInformationDataSource();

        }

        //  return về instance
        return productDetailInformationDataSource;

    }

    //  Phương thúc lấy ProductDetailInformationWorksWithDatabase
    public ProductDetailInformationWorksWithDatabase getProductDetailInformationWorksWithDatabase() {

        //  Lấy ProductDetailInformationWorksWithDatabase từ ProductDetailInformationPool
        return productDetailInformationPool.getProductDetailInformationWorksWithDatabase();

    }

    //  Phương thức trả ProductDetailInformationWorksWithDatabase cho ProductDetailInformationPool
    public void releaseProductDetailInformationWorksWithDatabase(ProductDetailInformationWorksWithDatabase productDetailInformationWorksWithDatabase) {

        //  Trả ProductDetailInformationWorksWithDatabase về cho ProductDetailInformationPool
        productDetailInformationPool.releaseProductDetailInformationWorksWithDatabase(productDetailInformationWorksWithDatabase);

    }

}
