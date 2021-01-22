package model.cart;


import worksWithDatabase.cart.RemoveCartDAO;
import worksWithDatabase.cart.RemoveCartSource;

public class RemoveCartModel {
    private static RemoveCartModel cartModel;

    public static RemoveCartModel getInstance(){
        if (cartModel == null){
            cartModel = new RemoveCartModel();
        }
        return cartModel;
    }

    public boolean executeCart(String ma_sp,String ma_kh,String ma_mau,String ma_size){

        RemoveCartDAO cartDAO = RemoveCartSource.getInstance().getAddCart();

        boolean result = cartDAO.remove(ma_sp,ma_kh,ma_mau,ma_size);

        RemoveCartSource.getInstance().releaseRemoveCart(cartDAO);

        return result;

    }
}
