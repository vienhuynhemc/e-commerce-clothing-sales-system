package worksWithDatabase.importPrice;

public class ImportPriceDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy ImportPrice works with data base
     *      2. Trả ImportPrice works with data base
     */

    //  Khai báo ImportPricepool
    private static ImportPricePool importPricePool;

    //  Khai báo instance
    private static ImportPriceDataSource importPriceDataSource;

    //  Constructor thì khởi tạo ImportPricePool
    private ImportPriceDataSource() {
        importPricePool = new ImportPricePool();
    }

    //  Trả về thể hiện của ImportPriceDataSource
    public static synchronized ImportPriceDataSource getInstance() {

        //  Kiểm tra thử ImportPriceDataSource có null?
        if (importPriceDataSource == null) {

            //  null thì khởi tạo nó
            importPriceDataSource = new ImportPriceDataSource();

        }

        //  return về instance
        return importPriceDataSource;

    }

    //  Phương thúc lấy ImportPriceWorksWithDatabase
    public ImportPriceWorksWithDatabase getImportPriceWorksWithDatabase() {

        //  Lấy ImportPriceWorksWithDatabase từ ImportPricePool
        return importPricePool.getImportPriceWorksWithDatabase();

    }

    //  Phương thức trả ImportPriceWorksWithDatabase cho ImportPricePool
    public void releaseImportPriceWorksWithDatabase(ImportPriceWorksWithDatabase importPriceWorksWithDatabase) {

        //  Trả ImportPriceWorksWithDatabase về cho ImportPricePool
        importPricePool.releaseImportPriceWorksWithDatabase(importPriceWorksWithDatabase);

    }


}
