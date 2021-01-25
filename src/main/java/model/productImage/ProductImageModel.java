package model.productImage;

import beans.productAdmin.ProductAdmin;
import beans.productAdmin.ProductAdminColorAddProduct;
import worksWithDatabase.productImage.ProductImageDataSource;
import worksWithDatabase.productImage.ProductImageWorksWithDatabase;

import java.util.List;

public class ProductImageModel {

    private static ProductImageModel productImageModel;

    public static ProductImageModel getInstance(){
        if(productImageModel == null){
            productImageModel = new ProductImageModel();
        }
        return productImageModel;
    }

    public void fileLinkHinhAnhListProduct(List<ProductAdmin> products){

        ProductImageWorksWithDatabase productImageWorksWithDatabase = ProductImageDataSource.getInstance().getProductImageWorksWithDatabase();
        productImageWorksWithDatabase.fileLinkHinhAnhListProduct(products);
        ProductImageDataSource.getInstance().releaseProductImageWorksWithDatabase(productImageWorksWithDatabase);

    }

    public void addToDatbase(String ma_sp, List<ProductAdminColorAddProduct> list) {
        ProductImageWorksWithDatabase productImageWorksWithDatabase = ProductImageDataSource.getInstance().getProductImageWorksWithDatabase();
        productImageWorksWithDatabase.addToDatbase(ma_sp,list);
        ProductImageDataSource.getInstance().releaseProductImageWorksWithDatabase(productImageWorksWithDatabase);
    }

}
