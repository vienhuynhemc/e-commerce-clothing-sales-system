package model.loadDetailProduct;

import beans.product.Product;
import beans.product.ProductDetailInformation;
import model.loadProduct.LoadProductModel;
import worksWithDatabase.detailProductIndex.DetailProductDAO;
import worksWithDatabase.detailProductIndex.DetailProductDataSource;

import java.util.ArrayList;

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
    // lấy size sản phẩm thông qua màu và giá sản phẩm
    public ArrayList<ProductDetailInformation> getSizeById(String id, String color){
        DetailProductDAO detailProductDAO = DetailProductDataSource.getInstance().getDetailProduct();

        ArrayList<ProductDetailInformation> list = detailProductDAO.getInfoDetailProduct(id,color);
        DetailProductDataSource.getInstance().releaseDetailProduct(detailProductDAO);
        return list;
    }

    public static void main(String[] args) {
        LoadDetailProductModel d = new LoadDetailProductModel();
        //System.out.println(d.loadProductById("sp_1"));

        for(ProductDetailInformation p : d.getSizeById("sp_1","mau_1")){
            System.out.println(p.getTen_size());
        }

    }

}
