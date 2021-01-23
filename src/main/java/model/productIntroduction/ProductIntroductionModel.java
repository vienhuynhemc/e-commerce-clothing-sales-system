package model.productIntroduction;

import beans.productAdmin.ProductAdmin;
import worksWithDatabase.productIntroduction.ProductIntroductionDataSource;
import worksWithDatabase.productIntroduction.ProductIntroductionWorksWithDatabase;

import java.util.List;

public class ProductIntroductionModel {

    private static ProductIntroductionModel productIntroductionModel;

    public static ProductIntroductionModel getInstance() {
        if (productIntroductionModel == null) {
            productIntroductionModel = new ProductIntroductionModel();
        }
        return productIntroductionModel;
    }

    public void fillProductIntroduction(List<ProductAdmin> products) {
        ProductIntroductionWorksWithDatabase productIntroductionWorksWithDatabase = ProductIntroductionDataSource.getInstance().getProductIntroductionWorksWithDatabase();
        productIntroductionWorksWithDatabase.fillProductIntroduction(products);
        ProductIntroductionDataSource.getInstance().releaseProductIntroductionWorksWithDatabase(productIntroductionWorksWithDatabase);
    }

}
