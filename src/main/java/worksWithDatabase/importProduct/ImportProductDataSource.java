package worksWithDatabase.importProduct;

public class ImportProductDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy ImportProduct works with data base
     *      2. Trả ImportProduct works with data base
     */

    //  Khai báo ImportProductpool
    private static ImportProductPool importProductPool;

    //  Khai báo instance
    private static ImportProductDataSource importProductDataSource;

    //  Constructor thì khởi tạo ImportProductPool
    private ImportProductDataSource() {
        importProductPool = new ImportProductPool();
    }

    //  Trả về thể hiện của ImportProductDataSource
    public static synchronized ImportProductDataSource getInstance() {

        //  Kiểm tra thử ImportProductDataSource có null?
        if (importProductDataSource == null) {

            //  null thì khởi tạo nó
            importProductDataSource = new ImportProductDataSource();

        }

        //  return về instance
        return importProductDataSource;

    }

    //  Phương thúc lấy ImportProductWorksWithDatabase
    public ImportProductWorksWithDatabase getImportProductWorksWithDatabase() {

        //  Lấy ImportProductWorksWithDatabase từ ImportProductPool
        return importProductPool.getImportProductWorksWithDatabase();

    }

    //  Phương thức trả ImportProductWorksWithDatabase cho ImportProductPool
    public void releaseImportProductWorksWithDatabase(ImportProductWorksWithDatabase importProductWorksWithDatabase) {

        //  Trả ImportProductWorksWithDatabase về cho ImportProductPool
        importProductPool.releaseImportProductWorksWithDatabase(importProductWorksWithDatabase);

    }
    
}
