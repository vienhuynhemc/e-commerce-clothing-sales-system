package model.loadProduct;

import beans.product.Product;
import beans.product.ProductImage;
import worksWithDatabase.loadPageProduct.LoadListProductDAO;

import java.util.ArrayList;
import java.util.Map;

public class LoadProductModel {
    private static LoadProductModel loadProductModel;
    private  int numPage;
    private ArrayList<Product> listProduct;

    public static  LoadProductModel getInstance(){

        if (loadProductModel == null){
            loadProductModel = new LoadProductModel();
        }
        return loadProductModel;

    }
    public static LoadProductModel getLoadProductModel() {
        return loadProductModel;
    }

    public static void setLoadProductModel(LoadProductModel loadProductModel) {
        LoadProductModel.loadProductModel = loadProductModel;
    }

    public int getNumPage() {
        return numPage;
    }

    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }

    public ArrayList<Product> getListProduct() {
        return listProduct;
    }


    public void loadProduct(int trang,int xem,String type,String xeptheo,String danhmuc,String mau, double gia,String size,String search){

        LoadListProductDAO loadListProductDAO = new LoadListProductDAO();

        loadListProductDAO.loadProduct(trang,xem,type,xeptheo,danhmuc,mau,gia,size,search);

        listProduct = loadListProductDAO.getListProduct();

        numPage = loadListProductDAO.getNumPage();

    }


}
