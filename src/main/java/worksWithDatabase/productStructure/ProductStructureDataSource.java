package worksWithDatabase.productStructure;

public class ProductStructureDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy ProductStructure works with data base
     *      2. Trả ProductStructure works with data base
     */

    //  Khai báo ProductStructurepool
    private static ProductStructurePool productStructurePool;

    //  Khai báo instance
    private static ProductStructureDataSource productStructureDataSource;

    //  Constructor thì khởi tạo ProductStructurePool
    private ProductStructureDataSource() {
        productStructurePool = new ProductStructurePool();
    }

    //  Trả về thể hiện của ProductStructureDataSource
    public static synchronized ProductStructureDataSource getInstance() {

        //  Kiểm tra thử ProductStructureDataSource có null?
        if (productStructureDataSource == null) {

            //  null thì khởi tạo nó
            productStructureDataSource = new ProductStructureDataSource();

        }

        //  return về instance
        return productStructureDataSource;

    }

    //  Phương thúc lấy ProductStructureWorksWithDatabase
    public ProductStructureWorksWithDatabase getProductStructureWorksWithDatabase() {

        //  Lấy ProductStructureWorksWithDatabase từ ProductStructurePool
        return productStructurePool.getProductStructureWorksWithDatabase();

    }

    //  Phương thức trả ProductStructureWorksWithDatabase cho ProductStructurePool
    public void releaseProductStructureWorksWithDatabase(ProductStructureWorksWithDatabase productStructureWorksWithDatabase) {

        //  Trả ProductStructureWorksWithDatabase về cho ProductStructurePool
        productStructurePool.releaseProductStructureWorksWithDatabase(productStructureWorksWithDatabase);

    }


}
