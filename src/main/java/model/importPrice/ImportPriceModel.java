package model.importPrice;

import beans.productAdmin.ProductAdmin;
import worksWithDatabase.importPrice.ImportPriceDataSource;
import worksWithDatabase.importPrice.ImportPriceWorksWithDatabase;

import java.util.List;

public class ImportPriceModel {

    private static ImportPriceModel importPriceModel;

    public static ImportPriceModel getInstance(){
        if(importPriceModel == null){
            importPriceModel = new ImportPriceModel();
        }
        return importPriceModel;
    }

    //  Phương thức nhận vô list product điền giá sp cho bó
    public void fillPriceListProductAdmin(List<ProductAdmin> products) {
        ImportPriceWorksWithDatabase importPriceWorksWithDatabase = ImportPriceDataSource.getInstance().getImportPriceWorksWithDatabase();
        importPriceWorksWithDatabase.fillPriceListProductAdmin(products);
        ImportPriceDataSource.getInstance().releaseImportPriceWorksWithDatabase(importPriceWorksWithDatabase);
    }

}
