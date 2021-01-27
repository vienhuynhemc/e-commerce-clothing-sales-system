package model.productImage;

import beans.productAdmin.ProductAdmin;
import beans.productAdmin.ProductAdminAdd;
import beans.productAdmin.ProductAdminColorAddProduct;
import beans.productAdmin.ProductAdminEditSingle;
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

    public void editToDatbase(String ma_sp, List<ProductAdminColorAddProduct> list) {
        ProductImageWorksWithDatabase productImageWorksWithDatabase = ProductImageDataSource.getInstance().getProductImageWorksWithDatabase();
        productImageWorksWithDatabase.editToDatbase(ma_sp,list);
        ProductImageDataSource.getInstance().releaseProductImageWorksWithDatabase(productImageWorksWithDatabase);
    }

    public void fillImageByProductAdminEditSingle(ProductAdminEditSingle productAdminEditSingle){
        ProductImageWorksWithDatabase productImageWorksWithDatabase = ProductImageDataSource.getInstance().getProductImageWorksWithDatabase();
        productImageWorksWithDatabase.fillImageByProductAdminEditSingle(productAdminEditSingle);
        ProductImageDataSource.getInstance().releaseProductImageWorksWithDatabase(productImageWorksWithDatabase);
    }

    public void updateImgProductSingleEdit(String ma_sp,String ma_mau,List<String> list_hinh_anh){
        ProductImageWorksWithDatabase productImageWorksWithDatabase = ProductImageDataSource.getInstance().getProductImageWorksWithDatabase();
        productImageWorksWithDatabase.updateImgProductSingleEdit(ma_sp, ma_mau, list_hinh_anh);
        ProductImageDataSource.getInstance().releaseProductImageWorksWithDatabase(productImageWorksWithDatabase);
    }

    public void fillDataProductAdminEditGroup(ProductAdminAdd productAdminAdd){
        ProductImageWorksWithDatabase productImageWorksWithDatabase = ProductImageDataSource.getInstance().getProductImageWorksWithDatabase();
        productImageWorksWithDatabase.fillDataProductAdminEditGroup(productAdminAdd);
        ProductImageDataSource.getInstance().releaseProductImageWorksWithDatabase(productImageWorksWithDatabase);
    }

}
