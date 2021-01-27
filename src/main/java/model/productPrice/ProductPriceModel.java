package model.productPrice;

import beans.DateTime;
import beans.productAdmin.ProductAdmin;
import beans.productAdmin.ProductAdminAdd;
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

    public void addToDatabse(String ma_sp, int gia_sp, DateTime ngay_cap_nhat){
        ProductPriceWorksWithDatabase productPriceWorksWithDatabase = ProductPriceDataSource.getInstance().getProductPriceWorksWithDatabase();
        productPriceWorksWithDatabase.addToDatabse(ma_sp, gia_sp, ngay_cap_nhat);
        ProductPriceDataSource.getInstance().releaseProductPriceWorksWithDatabase(productPriceWorksWithDatabase);
    }

    public void fillDataProductAdminEditGroup(ProductAdminAdd productAdminEditGroup){
        ProductPriceWorksWithDatabase productPriceWorksWithDatabase = ProductPriceDataSource.getInstance().getProductPriceWorksWithDatabase();
        productPriceWorksWithDatabase.fillDataProductAdminEditGroup(productAdminEditGroup);
        ProductPriceDataSource.getInstance().releaseProductPriceWorksWithDatabase(productPriceWorksWithDatabase);
    }


}
