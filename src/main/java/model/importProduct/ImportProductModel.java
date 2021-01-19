package model.importProduct;

import worksWithDatabase.importProduct.ImportProductDataSource;
import worksWithDatabase.importProduct.ImportProductWorksWithDatabase;

import java.util.List;

public class ImportProductModel {

    private static ImportProductModel importProductModel;

    public static ImportProductModel getInstance() {
        if (importProductModel == null) {
            importProductModel = new ImportProductModel();
        }
        return importProductModel;
    }

    // phương thứuc nhận vào mã admin, kiểm tra xem admin này nhập mấy đơn hàng rồi
    public int getNumberOfImportProductByIdAmin(String ma_nv) {
        ImportProductWorksWithDatabase importProductWorksWithDatabase = ImportProductDataSource.getInstance().getImportProductWorksWithDatabase();
        int result = importProductWorksWithDatabase.getNumberOfImportProductByIdAmin(ma_nv);
        ImportProductDataSource.getInstance().releaseImportProductWorksWithDatabase(importProductWorksWithDatabase);
        return result;
    }

    //  Phuowng thúc nhập  vào mã admin, trả về list mã nhập hàng của id này
    public List<String> getAllImportProductByIdAdmin(String ma_nv) {
        ImportProductWorksWithDatabase importProductWorksWithDatabase = ImportProductDataSource.getInstance().getImportProductWorksWithDatabase();
        List<String> result = importProductWorksWithDatabase.getAllImportProductByIdAdmin(ma_nv);
        ImportProductDataSource.getInstance().releaseImportProductWorksWithDatabase(importProductWorksWithDatabase);
        return result;
    }

}
