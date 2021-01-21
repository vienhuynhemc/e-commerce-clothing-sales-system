package model.wishlist;

import worksWithDatabase.wishlist.AddWishlistDAO;
import worksWithDatabase.wishlist.AddWishlistSource;

public class AddWishlistModel {
    private static AddWishlistModel wishlistModel;

    public static AddWishlistModel getInstanse(){
        if(wishlistModel == null){
            wishlistModel = new AddWishlistModel();
        }
        return wishlistModel;
    }
    public static boolean addWishlist(String idProduct, String idCustomer, String color,String size){
        AddWishlistDAO addWishlistDAO = AddWishlistSource.getInstance().getAddWishlist();
        boolean check = addWishlistDAO.addWishlist(idProduct,idCustomer,color,size);
        AddWishlistSource.getInstance().releaseAddWishlist(addWishlistDAO);
        return check;
    }

    public static void main(String[] args) {

        System.out.println(addWishlist("sp_1","kh001","vang","s"));
    }
}
