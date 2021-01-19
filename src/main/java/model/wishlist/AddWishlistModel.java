package model.wishlist;

import worksWithDatabase.wishlist.AddWishlistDAO;
import worksWithDatabase.wishlist.AddWishlistSource;

public class AddWishlistModel {
    private static AddWishlistModel wishlistModel;

    private static AddWishlistModel getInstanse(){
        if(wishlistModel == null){
            wishlistModel = new AddWishlistModel();
        }
        return wishlistModel;
    }
    public static boolean addWishlist(String idProduct, String idCustomer, String color){
        AddWishlistDAO addWishlistDAO = AddWishlistSource.getAddWishlist();
        boolean check = addWishlistDAO.addWishlist(idProduct,idCustomer,color);
        AddWishlistSource.releaseAddWishlist(addWishlistDAO);
        return check;
    }
}
