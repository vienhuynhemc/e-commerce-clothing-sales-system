package model.loadDetailProduct;

import beans.product.Product;
import beans.product.ProductColor;
import beans.product.ProductDetailInformation;

import model.loadProduct.LoadProductModel;
import worksWithDatabase.detailProductIndex.DetailProductDAO;
import worksWithDatabase.detailProductIndex.DetailProductDataSource;

import java.util.ArrayList;

public class LoadDetailProductModel {
    public static LoadProductModel loadProductModel;

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
    public ArrayList<String> loadImgById(String id, String color){
        DetailProductDAO detailProductDAO = DetailProductDataSource.getInstance().getDetailProduct();
        ArrayList<String> list = detailProductDAO.loadImgById(id,color);
        DetailProductDataSource.getInstance().releaseDetailProduct(detailProductDAO);
        return list;
    }
    public ArrayList<ProductColor> loadColorById(String id){
        DetailProductDAO detailProductDAO = DetailProductDataSource.getInstance().getDetailProduct();
        ArrayList<ProductColor> list = detailProductDAO.loadColorById(id);
        DetailProductDataSource.getInstance().releaseDetailProduct(detailProductDAO);
        return list;
    }
    public int getRestNumber(String id, String color, String size){
        DetailProductDAO detailProductDAO = DetailProductDataSource.getInstance().getDetailProduct();
        int a = detailProductDAO.getRestNumber(id,color,size);
        DetailProductDataSource.getInstance().releaseDetailProduct(detailProductDAO);
        return a;
    }
    public ArrayList<ProductDetailInformation> getInfoDetailProduct(String id, String color){
        DetailProductDAO detailProductDAO = DetailProductDataSource.getInstance().getDetailProduct();
        ArrayList<ProductDetailInformation> list = detailProductDAO.getInfoDetailProduct(id,color);
        DetailProductDataSource.getInstance().releaseDetailProduct(detailProductDAO);
        return list;
    }

    public static void main(String[] args) {
        LoadDetailProductModel d = new LoadDetailProductModel();
        //System.out.println(d.loadProductById("sp_1"));

//        for(ProductDetailInformation p : d.getSizeById("sp_1","mau_1")){
//            System.out.println(p.getTen_size());
//        }

        System.out.println(d.getRestNumber("sp_1","mau_1","size_1"));

    }

}
