package model.importProductInformation;

import worksWithDatabase.importProductInformation.ImportProductInformationDataSource;
import worksWithDatabase.importProductInformation.ImportProductInformationWorksWithDatabase;

import java.util.List;

public class ImportProductInformationModel {

    private static ImportProductInformationModel importProductInformationModel;

    public static ImportProductInformationModel getInstance() {
        if (importProductInformationModel == null) {
            importProductInformationModel = new ImportProductInformationModel();
        }
        return importProductInformationModel;
    }

    //  Phương thức nhận vô List mã phiếu nhập, trả về số lượng hàng hóa nhập của những phiếu hàng đó
    public int getSumImportProductByListId(List<String> maPhieuNhaps) {
        ImportProductInformationWorksWithDatabase importProductInformationWorksWithDatabase = ImportProductInformationDataSource.getInstance().getImportProductInformationWorksWithDatabase();
        int result = importProductInformationWorksWithDatabase.getSumImportProductByListId(maPhieuNhaps);
        ImportProductInformationDataSource.getInstance().releaseImportProductInformationWorksWithDatabase(importProductInformationWorksWithDatabase);
        return result;
    }

}
