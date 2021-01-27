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

    //  Phương thức nhận vô list giới thiệu và masp, cho vô csdl
    public void addIntroductToDabase(String ma_sp, List<String> gioiThieus) {
        ProductIntroductionWorksWithDatabase productIntroductionWorksWithDatabase = ProductIntroductionDataSource.getInstance().getProductIntroductionWorksWithDatabase();
        productIntroductionWorksWithDatabase.addIntroductToDabase(ma_sp, gioiThieus);
        ProductIntroductionDataSource.getInstance().releaseProductIntroductionWorksWithDatabase(productIntroductionWorksWithDatabase);
    }

    public List<String> getListById(String ma_sp) {
        ProductIntroductionWorksWithDatabase productIntroductionWorksWithDatabase = ProductIntroductionDataSource.getInstance().getProductIntroductionWorksWithDatabase();
        List<String> result = productIntroductionWorksWithDatabase.getListById(ma_sp);
        ProductIntroductionDataSource.getInstance().releaseProductIntroductionWorksWithDatabase(productIntroductionWorksWithDatabase);
        return result;
    }

    public void editIntroductToDabase(String ma_sp,List<String> gioiThieus){
        ProductIntroductionWorksWithDatabase productIntroductionWorksWithDatabase = ProductIntroductionDataSource.getInstance().getProductIntroductionWorksWithDatabase();
        productIntroductionWorksWithDatabase.editIntroductToDabase(ma_sp, gioiThieus);
        ProductIntroductionDataSource.getInstance().releaseProductIntroductionWorksWithDatabase(productIntroductionWorksWithDatabase);
    }

}
