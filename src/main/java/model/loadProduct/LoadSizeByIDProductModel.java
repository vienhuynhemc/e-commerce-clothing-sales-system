package model.loadProduct;

import beans.product.Product;
import beans.product.ProductColor;
import beans.product.Size;
import worksWithDatabase.loadPageProduct.LoadSizeAndColor;

import java.util.ArrayList;

public class LoadSizeByIDProductModel {
    private static LoadSizeByIDProductModel loadSize;
    private  int numPage;
    private ArrayList<Product> listProduct;

    public static  LoadSizeByIDProductModel getInstance(){

        if (loadSize == null){
            loadSize = new LoadSizeByIDProductModel();
        }
        return loadSize;

    }

    public ArrayList<Size> loadSizeByID(String ma_sp){

        LoadSizeAndColor loadSizeAndColor = new LoadSizeAndColor();

        return loadSizeAndColor.loadSizeByIDProduct(ma_sp);

    }
    public ArrayList<ProductColor> laodColorByID(String ma_sp){
        LoadSizeAndColor loadSizeAndColor = new LoadSizeAndColor();
        return loadSizeAndColor.laodColorByproduct(ma_sp);

    }
    public ArrayList<ProductColor> laodColorBySize(String ma_sp,String ma_size){

        LoadSizeAndColor loadSizeAndColor = new LoadSizeAndColor();

        return loadSizeAndColor.loadColorBySize(ma_sp,ma_size);

    }

}
