package model.productDetailInformation;

import beans.productAdmin.ProductAdmin;
import beans.productAdmin.ProductAdminColorAddProduct;
import beans.productAdmin.ProductAdminEditSingle;
import beans.productAdmin.ProductAdminSizeAdd;
import worksWithDatabase.productDetailInformation.ProductDetailInformationDataSource;
import worksWithDatabase.productDetailInformation.ProductDetailInformationWorksWithDatabase;

import java.util.List;

public class ProductDetailInformationModel {

    private static ProductDetailInformationModel productDetailInformationModel;

    public static ProductDetailInformationModel getInstance() {
        if (productDetailInformationModel == null) {
            productDetailInformationModel = new ProductDetailInformationModel();
        }
        return productDetailInformationModel;
    }

    //  Phương thúc lấy ra các màu và size đầu tiên
    public void fillProductAdminFirst(List<ProductAdmin> products, int line_per_page) {
        ProductDetailInformationWorksWithDatabase productDetailInformationWorksWithDatabase = ProductDetailInformationDataSource.getInstance().getProductDetailInformationWorksWithDatabase();
        productDetailInformationWorksWithDatabase.fillProductAdminFirst(products, line_per_page);
        ProductDetailInformationDataSource.getInstance().releaseProductDetailInformationWorksWithDatabase(productDetailInformationWorksWithDatabase);
    }


    //  Phương thức lấy số sản phẩm tối đa đầu tiên
    public int getNumberOfMaxProductFirst() {
        ProductDetailInformationWorksWithDatabase productDetailInformationWorksWithDatabase = ProductDetailInformationDataSource.getInstance().getProductDetailInformationWorksWithDatabase();
        int result = productDetailInformationWorksWithDatabase.getNumberOfMaxProductFirst();
        ProductDetailInformationDataSource.getInstance().releaseProductDetailInformationWorksWithDatabase(productDetailInformationWorksWithDatabase);
        return result;
    }

    public void fillProductAdminFromALl(List<ProductAdmin> products, String selectSearchAndSort, String sort, String search, int lineOfOnPageQuanLySanPham, int nowPage) {
        ProductDetailInformationWorksWithDatabase productDetailInformationWorksWithDatabase = ProductDetailInformationDataSource.getInstance().getProductDetailInformationWorksWithDatabase();
        productDetailInformationWorksWithDatabase.fillProductAdminFromAll(products, selectSearchAndSort, sort, search, lineOfOnPageQuanLySanPham, nowPage);
        ProductDetailInformationDataSource.getInstance().releaseProductDetailInformationWorksWithDatabase(productDetailInformationWorksWithDatabase);
    }

    public int getNumberOfMaxProductFromAll(String selectSearchAndSort, String search) {
        ProductDetailInformationWorksWithDatabase productDetailInformationWorksWithDatabase = ProductDetailInformationDataSource.getInstance().getProductDetailInformationWorksWithDatabase();
        int result = productDetailInformationWorksWithDatabase.getNumberOfMaxProductFromAll(selectSearchAndSort, search);
        ProductDetailInformationDataSource.getInstance().releaseProductDetailInformationWorksWithDatabase(productDetailInformationWorksWithDatabase);
        return result;
    }

    public void addToDatabae(String ma_sp, List<ProductAdminColorAddProduct> listColor, List<ProductAdminSizeAdd> listSize) {
        ProductDetailInformationWorksWithDatabase productDetailInformationWorksWithDatabase = ProductDetailInformationDataSource.getInstance().getProductDetailInformationWorksWithDatabase();
        productDetailInformationWorksWithDatabase.addToDatabae(ma_sp, listColor, listSize);
        ProductDetailInformationDataSource.getInstance().releaseProductDetailInformationWorksWithDatabase(productDetailInformationWorksWithDatabase);
    }

    public void fillProductAdminEditSingle(ProductAdminEditSingle productAdminEditSingle) {
        ProductDetailInformationWorksWithDatabase productDetailInformationWorksWithDatabase = ProductDetailInformationDataSource.getInstance().getProductDetailInformationWorksWithDatabase();
        productDetailInformationWorksWithDatabase.fillProductAdminEditSingle(productAdminEditSingle);
        ProductDetailInformationDataSource.getInstance().releaseProductDetailInformationWorksWithDatabase(productDetailInformationWorksWithDatabase);
    }

    public void updateEditSingle(String ma_sp, String ma_mau, List<ProductAdminSizeAdd> list_size, int hinh_anh_trong_firebase) {
        ProductDetailInformationWorksWithDatabase productDetailInformationWorksWithDatabase = ProductDetailInformationDataSource.getInstance().getProductDetailInformationWorksWithDatabase();
        productDetailInformationWorksWithDatabase.updateEditSingle(ma_sp, ma_mau, list_size, hinh_anh_trong_firebase);
        ProductDetailInformationDataSource.getInstance().releaseProductDetailInformationWorksWithDatabase(productDetailInformationWorksWithDatabase);
    }

}
