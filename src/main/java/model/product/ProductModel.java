package model.product;

import beans.productAdmin.ProductAdmin;
import worksWithDatabase.product.ProductDataSource;
import worksWithDatabase.product.ProductWorksWithDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProductModel {

    private static ProductModel productModel;

    public static ProductModel getInstance(){
        if(productModel == null){
            productModel = new ProductModel();
        }
        return productModel;
    }

    public void update(){
        ProductWorksWithDatabase productWorksWithDatabase = ProductDataSource.getInstance().getProductWorksWithDatabase();
        productWorksWithDatabase.update();
        ProductDataSource.getInstance().releaseProductWorksWithDatabase(productWorksWithDatabase);
    }

    //  Phương thức nhận vô List productAdmin điền thông tin cho nó
    public void fillDataProduct(List<ProductAdmin> products){
        ProductWorksWithDatabase productWorksWithDatabase = ProductDataSource.getInstance().getProductWorksWithDatabase();
        productWorksWithDatabase.fillDataProduct(products);
        ProductDataSource.getInstance().releaseProductWorksWithDatabase(productWorksWithDatabase);
    }

    //  Phuơng thức lấy mã sản phẩm tiếp theo
    public String getNextId(){
        ProductWorksWithDatabase productWorksWithDatabase = ProductDataSource.getInstance().getProductWorksWithDatabase();
      String result = productWorksWithDatabase.getNextId();
        ProductDataSource.getInstance().releaseProductWorksWithDatabase(productWorksWithDatabase);
        return result;
    }

}
