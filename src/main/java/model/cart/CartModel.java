package model.cart;


import beans.cart.Cart;
import worksWithDatabase.cart.LoadCartDAO;
import worksWithDatabase.cart.LoadCartSource;

import java.util.ArrayList;

public class CartModel {
    private static CartModel cartModel;

    public static CartModel getInstance(){
        if (cartModel == null){
            cartModel = new CartModel();
        }
        return cartModel;
    }

    public ArrayList<Cart> loadCartByID(String id){

        LoadCartDAO cartDAO = LoadCartSource.getInstance().getAddAccount();

        ArrayList<Cart> result = cartDAO.listCartByID(id);

        LoadCartSource.getInstance().releaseAddAccount(cartDAO);

    return result;
    }

    public static void main(String[] args) {
        CartModel cart = CartModel.getInstance();

        System.out.println(cart.loadCartByID("kh001"));
    }
}
