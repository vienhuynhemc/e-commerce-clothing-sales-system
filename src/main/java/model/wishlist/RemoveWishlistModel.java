package model.wishlist;

import worksWithDatabase.wishlist.AddWishlistDAO;
import worksWithDatabase.wishlist.AddWishlistSource;
import worksWithDatabase.wishlist.RemoveWishlistDAO;
import worksWithDatabase.wishlist.RemoveWishlistSource;

public class RemoveWishlistModel {
    private static RemoveWishlistModel wishlistModel;

    public static RemoveWishlistModel getInstanse(){
        if(wishlistModel == null){
            wishlistModel = new RemoveWishlistModel();
        }
        return wishlistModel;
    }
    public static boolean removeWishlist(String idProduct, String idCustomer, String color,String size){
        RemoveWishlistDAO removeWishlistDAO = RemoveWishlistSource.getInstance().getAddWishlist();
        boolean check = removeWishlistDAO.removeWishlist(idProduct,idCustomer,color,size);
        RemoveWishlistSource.getInstance().releaseAddWishlist(removeWishlistDAO);
        return check;
    }

    public static void main(String[] args) {

        System.out.println(removeWishlist("sp_1","kh001","mau_1","size_1"));
    }
}
