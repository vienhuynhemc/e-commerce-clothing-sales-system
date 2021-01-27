package model.product;

import beans.DateTime;
import beans.productAdmin.ProductAdmin;
import beans.productAdmin.ProductAdminAdd;
import worksWithDatabase.product.ProductDataSource;
import worksWithDatabase.product.ProductWorksWithDatabase;

import java.util.List;

public class ProductModel {

    private static ProductModel productModel;

    public static ProductModel getInstance() {
        if (productModel == null) {
            productModel = new ProductModel();
        }
        return productModel;
    }

    public void update() {
        ProductWorksWithDatabase productWorksWithDatabase = ProductDataSource.getInstance().getProductWorksWithDatabase();
        productWorksWithDatabase.update();
        ProductDataSource.getInstance().releaseProductWorksWithDatabase(productWorksWithDatabase);
    }

    //  Phương thức nhận vô List productAdmin điền thông tin cho nó
    public void fillDataProduct(List<ProductAdmin> products) {
        ProductWorksWithDatabase productWorksWithDatabase = ProductDataSource.getInstance().getProductWorksWithDatabase();
        productWorksWithDatabase.fillDataProduct(products);
        ProductDataSource.getInstance().releaseProductWorksWithDatabase(productWorksWithDatabase);
    }

    //  Phuơng thức lấy mã sản phẩm tiếp theo
    public String getNextId() {
        ProductWorksWithDatabase productWorksWithDatabase = ProductDataSource.getInstance().getProductWorksWithDatabase();
        String result = productWorksWithDatabase.getNextId();
        ProductDataSource.getInstance().releaseProductWorksWithDatabase(productWorksWithDatabase);
        return result;
    }

    //  Phương thức thêm một sản phẩm vô csdl
    public void addSpToDatabase(String ma_sp, String ten_sp, String ma_hsx, String ma_dm, DateTime ngay_tao, int gioi_tinh, int trang_thai, int so_luong_ban_ra, int ton_tai) {
        ProductWorksWithDatabase productWorksWithDatabase = ProductDataSource.getInstance().getProductWorksWithDatabase();
        productWorksWithDatabase.addSpToDatabase(ma_sp, ten_sp, ma_hsx, ma_dm, ngay_tao, gioi_tinh, trang_thai, so_luong_ban_ra, ton_tai);
        ProductDataSource.getInstance().releaseProductWorksWithDatabase(productWorksWithDatabase);
    }

    public void fillDataProductAdminEditGroup(ProductAdminAdd productAdminEditGroup) {
        ProductWorksWithDatabase productWorksWithDatabase = ProductDataSource.getInstance().getProductWorksWithDatabase();
        productWorksWithDatabase.fillDataProductAdminEditGroup(productAdminEditGroup);
        ProductDataSource.getInstance().releaseProductWorksWithDatabase(productWorksWithDatabase);
    }

    public void editSpToDatabase(String ma_sp,String ten_sp,String ma_hsx,String ma_dm,int gioi_tinh){
        ProductWorksWithDatabase productWorksWithDatabase = ProductDataSource.getInstance().getProductWorksWithDatabase();
        productWorksWithDatabase.editSpToDatabase(ma_sp, ten_sp, ma_hsx, ma_dm, gioi_tinh);
        ProductDataSource.getInstance().releaseProductWorksWithDatabase(productWorksWithDatabase);
    }

}
