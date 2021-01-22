package model.loadProduct;

import beans.product.Category;
import beans.product.Product;
import beans.product.ProductColor;
import beans.product.Size;
import worksWithDatabase.loadPageProduct.LoadCategoryByTypeDAO;
import worksWithDatabase.loadPageProduct.LoadColorByTypeDAO;
import worksWithDatabase.loadPageProduct.LoadSizeByTypeDAO;
import worksWithDatabase.loadPageProduct.LoadTopProductDAO;

import java.util.ArrayList;

public class LoadCategoryModel {
    private static LoadCategoryModel loadCategory;
    private  int numPage;

    public static  LoadCategoryModel getInstance(){

        if (loadCategory == null){
            loadCategory = new LoadCategoryModel();
        }
        return loadCategory;

    }
    public ArrayList<Category> laodCategory(String type){
        return new LoadCategoryByTypeDAO().loadCategoryBytype(type);
    }
    public ArrayList<ProductColor> loadColor(String type){
        return new LoadColorByTypeDAO().loadColorBytype(type);
    }
    public ArrayList<Size> loadSize(String type){
        return new LoadSizeByTypeDAO().loadColorBytype(type);
    }
    public ArrayList<Product> loadTopProduct(String type){return new LoadTopProductDAO().loadTopProduct(type);
    }
}
