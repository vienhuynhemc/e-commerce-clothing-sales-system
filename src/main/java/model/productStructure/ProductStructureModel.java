package model.productStructure;

import beans.productAdmin.ProductAdmin;
import model.productAdmin.ProductAdminModel;
import worksWithDatabase.productStructure.ProductStructureDataSource;
import worksWithDatabase.productStructure.ProductStructureWorksWithDatabase;

import java.util.List;

public class ProductStructureModel {

    private static ProductStructureModel productStructureModel;

    public static ProductStructureModel getInstance(){
        if(productStructureModel == null){
            productStructureModel = new ProductStructureModel();
        }
        return productStructureModel;
    }

    public void fillStructureProdcut(List<ProductAdmin> products){
        ProductStructureWorksWithDatabase productStructureWorksWithDatabase = ProductStructureDataSource.getInstance().getProductStructureWorksWithDatabase();
        productStructureWorksWithDatabase.fillStructureProdcut(products);
        ProductStructureDataSource.getInstance().releaseProductStructureWorksWithDatabase(productStructureWorksWithDatabase);
    }

}
