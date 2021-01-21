package model.loadDetailProduct;

import beans.product.Product;
import model.loadProduct.LoadProductModel;
import worksWithDatabase.detailProductIndex.DetailProductDAO;
import worksWithDatabase.detailProductIndex.DetailProductDataSource;

public class LoadDetailProductModel {
    private static LoadProductModel loadProductModel;

    public static LoadProductModel getInstanse() {
        if (loadProductModel != null) {
            return loadProductModel;
        }
        return loadProductModel;
    }
    public Product loadProductById(String id){
        DetailProductDAO detailProductDAO = DetailProductDataSource.getInstance().getDetailProduct();
        Product p = detailProductDAO.getProductById(id);
        DetailProductDataSource.getInstance().releaseDetailProduct(detailProductDAO);
        return p;
    }

    public static void main(String[] args) {
        LoadDetailProductModel d = new LoadDetailProductModel();
        System.out.println(d.loadProductById("sp_1"));
    }
}
