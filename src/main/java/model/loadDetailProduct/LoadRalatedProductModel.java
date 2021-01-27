package model.loadDetailProduct;

import beans.product.Product;
import model.loadProduct.LoadProductModel;
import worksWithDatabase.ralatedProducts.RalatedProductDAO;
import worksWithDatabase.ralatedProducts.RalatedProductDataSource;

import java.util.ArrayList;

public class LoadRalatedProductModel {
    public static LoadRalatedProductModel loadRalatedProductModel;

    public static LoadRalatedProductModel getInstanse() {
        if (loadRalatedProductModel != null) {
            return loadRalatedProductModel;
        }
        return loadRalatedProductModel;
    }
    public ArrayList<Product> loadRalatedProduct(int price){
        RalatedProductDAO ralatedProductDAO = RalatedProductDataSource.getInstance().getRalatedProductDAO();
        ArrayList<Product> list = ralatedProductDAO.LoadRalatedProduct(price);
        RalatedProductDataSource.getInstance().releaseRalatedProductDAO(ralatedProductDAO);
        return list;
    }
}
