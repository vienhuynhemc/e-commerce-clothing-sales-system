package model.productPrice;

import beans.productAdmin.ProductAdmin;
import worksWithDatabase.productPrice.ProductPriceDataSource;
import worksWithDatabase.productPrice.ProductPriceWorksWithDatabase;

import java.util.List;

public class ProductPriceModel {

    private static ProductPriceModel productPriceModel;

    public static ProductPriceModel getInstance() {
        if (productPriceModel == null) {
            productPriceModel = new ProductPriceModel();
        }
        return productPriceModel;
    }

    //  Phương thức nhận vô list product điền giá sp cho bó
    public void fillPriceListProductAdmin(List<ProductAdmin> products) {
        ProductPriceWorksWithDatabase productPriceWorksWithDatabase = ProductPriceDataSource.getInstance().getProductPriceWorksWithDatabase();
        productPriceWorksWithDatabase.fillPriceListProductAdmin(products);
        ProductPriceDataSource.getInstance().releaseProductPriceWorksWithDatabase(productPriceWorksWithDatabase);
    }

}
