package model.color;

import beans.productAdmin.ProductAdmin;
import worksWithDatabase.color.ColorDataSource;
import worksWithDatabase.color.ColorWorksWithDatabase;

import java.util.List;

public class ColorModel {

    private static ColorModel colorModel;

    public static ColorModel getInstance(){
        if(colorModel == null) colorModel = new ColorModel();
        return colorModel;
    }

    public void fillNameAndImgColorListProductAdmin(List<ProductAdmin> products){
        ColorWorksWithDatabase colorWorksWithDatabase = ColorDataSource.getInstance().getColorWorksWithDatabase();
        colorWorksWithDatabase.fillNameAndImgColorListProductAdmin(products);
        ColorDataSource.getInstance().releaseColorWorksWithDatabase(colorWorksWithDatabase);
    }

}
