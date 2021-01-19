package worksWithDatabase.importProductInformation;



public class ImportProductInformationDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy ImportProductInformation works with data base
     *      2. Trả ImportProductInformation works with data base
     */

    //  Khai báo ImportProductInformationpool
    private static ImportProductInformationPool importProductInformationPool;

    //  Khai báo instance
    private static ImportProductInformationDataSource importProductInformationDataSource;

    //  Constructor thì khởi tạo ImportProductInformationPool
    private ImportProductInformationDataSource() {
        importProductInformationPool = new ImportProductInformationPool();
    }

    //  Trả về thể hiện của ImportProductInformationDataSource
    public static synchronized ImportProductInformationDataSource getInstance() {

        //  Kiểm tra thử ImportProductInformationDataSource có null?
        if (importProductInformationDataSource == null) {

            //  null thì khởi tạo nó
            importProductInformationDataSource = new ImportProductInformationDataSource();

        }

        //  return về instance
        return importProductInformationDataSource;

    }

    //  Phương thúc lấy ImportProductInformationWorksWithDatabase
    public ImportProductInformationWorksWithDatabase getImportProductInformationWorksWithDatabase() {

        //  Lấy ImportProductInformationWorksWithDatabase từ ImportProductInformationPool
        return importProductInformationPool.getImportProductInformationWorksWithDatabase();

    }

    //  Phương thức trả ImportProductInformationWorksWithDatabase cho ImportProductInformationPool
    public void releaseImportProductInformationWorksWithDatabase(ImportProductInformationWorksWithDatabase importProductInformationWorksWithDatabase) {

        //  Trả ImportProductInformationWorksWithDatabase về cho ImportProductInformationPool
        importProductInformationPool.releaseImportProductInformationWorksWithDatabase(importProductInformationWorksWithDatabase);

    }
    
}
