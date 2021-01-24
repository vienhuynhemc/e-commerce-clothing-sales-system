package model.color;

import beans.productAdmin.ProductAdmin;
import beans.productAdmin.ProductAdminColorAdd;
import worksWithDatabase.color.ColorDataSource;
import worksWithDatabase.color.ColorWorksWithDatabase;

import java.util.List;

public class ColorModel {

    private static ColorModel colorModel;

    public static ColorModel getInstance() {
        if (colorModel == null) colorModel = new ColorModel();
        return colorModel;
    }

    public void fillNameAndImgColorListProductAdmin(List<ProductAdmin> products) {
        ColorWorksWithDatabase colorWorksWithDatabase = ColorDataSource.getInstance().getColorWorksWithDatabase();
        colorWorksWithDatabase.fillNameAndImgColorListProductAdmin(products);
        ColorDataSource.getInstance().releaseColorWorksWithDatabase(colorWorksWithDatabase);
    }

    public List<ProductAdminColorAdd> getAllColor() {
        ColorWorksWithDatabase colorWorksWithDatabase = ColorDataSource.getInstance().getColorWorksWithDatabase();
        List<ProductAdminColorAdd> result = colorWorksWithDatabase.getAllColor();
        ColorDataSource.getInstance().releaseColorWorksWithDatabase(colorWorksWithDatabase);
        return result;
    }

    //  Phương thức lấy mã màu tiéptheo
    public String getNextId() {
        ColorWorksWithDatabase colorWorksWithDatabase = ColorDataSource.getInstance().getColorWorksWithDatabase();
        String result = colorWorksWithDatabase.getNextId();
        ColorDataSource.getInstance().releaseColorWorksWithDatabase(colorWorksWithDatabase);
        return result;
    }

    //   phuong thuc them vo csdl
    public boolean addToDatabase(String ma_mau, String ten_mau, String link_hinh_anh) {
        ColorWorksWithDatabase colorWorksWithDatabase = ColorDataSource.getInstance().getColorWorksWithDatabase();
        boolean result = colorWorksWithDatabase.addToDatabase(ma_mau, ten_mau, link_hinh_anh);
        ColorDataSource.getInstance().releaseColorWorksWithDatabase(colorWorksWithDatabase);
        return result;
    }
    //  Phuowng thuc tra ve productadmincoloradd
    public ProductAdminColorAdd getProductAdminColorAddById(String ma_mau){
        ColorWorksWithDatabase colorWorksWithDatabase = ColorDataSource.getInstance().getColorWorksWithDatabase();
        ProductAdminColorAdd result = colorWorksWithDatabase.getProductAdminColorAddById(ma_mau);
        ColorDataSource.getInstance().releaseColorWorksWithDatabase(colorWorksWithDatabase);
        return result;
    }


}
