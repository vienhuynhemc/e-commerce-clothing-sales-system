package model.cart;


import beans.cart.Cart;
import worksWithDatabase.cart.ChangeCartDAO;
import worksWithDatabase.cart.ChangeCartSource;

public class ChangeCartModel {
    private static ChangeCartModel cartModel;

    public static ChangeCartModel getInstance(){
        if (cartModel == null){
            cartModel = new ChangeCartModel();
        }
        return cartModel;
    }

    public Cart executeCart(String ma_sp, String ma_kh, String ma_mau,String active){

        ChangeCartDAO cartDAO = ChangeCartSource.getInstance().getAddCart();

        Cart result = cartDAO.increaseCart(ma_sp,ma_kh,ma_mau,active);

        ChangeCartSource.getInstance().releaseRemoveCart(cartDAO);

        return result;

    }
}
