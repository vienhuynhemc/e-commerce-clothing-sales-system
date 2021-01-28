package model.wishlist;

import beans.cart.Cart;
import model.cart.ChangeCartModel;
import worksWithDatabase.wishlist.ChangeWishListDAO;

public class ChangeWishlistModell {
    private static ChangeWishlistModell cartModel;

    public static ChangeWishlistModell getInstance(){
        if (cartModel == null){
            cartModel = new ChangeWishlistModell();
        }
        return cartModel;
    }

    public Cart executeCart(String ma_sp, String ma_kh, String ma_mau, String ma_size, String active){

        ChangeWishListDAO changeWishListDAO = new ChangeWishListDAO();

        Cart result = changeWishListDAO.increaseCart(ma_sp,ma_kh,ma_mau,ma_size,active);

        return result;

    }
}
