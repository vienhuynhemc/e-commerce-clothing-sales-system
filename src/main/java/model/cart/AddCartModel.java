package model.cart;

import worksWithDatabase.cart.AddCartDAO;
import worksWithDatabase.cart.AddCartSource;

public class AddCartModel {
    private static AddCartModel cartModel;

    public static AddCartModel getInstance(){
        if (cartModel == null){
            cartModel = new AddCartModel();
        }
        return cartModel;
    }

    public boolean executeCart(String ma_sp,String ma_kh,String ma_mau){

        AddCartDAO cartDAO = AddCartSource.getInstance().getAddCart();

        boolean result = cartDAO.addCart(ma_sp,ma_kh,ma_mau);

        AddCartSource.getInstance().releaseAddCart(cartDAO);

        return result;

    }

}
