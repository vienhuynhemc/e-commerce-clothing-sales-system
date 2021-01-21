package model.wishlist;

import beans.wishlist.Wishlist;

import worksWithDatabase.wishlist.LoadWishlistDAO;
import worksWithDatabase.wishlist.LoadWishlistSource;

import java.util.ArrayList;

public class LoadWishlistModel {
    private static LoadWishlistModel wishlistModel;

    public static LoadWishlistModel getInstanse(){
        if(wishlistModel == null){
            wishlistModel = new LoadWishlistModel();
        }
        return wishlistModel;
    }
    public static ArrayList<Wishlist> loadWishlistById(int page,String idCustomer,String search,String type,int sex, int status, int numberPerPage){
            ArrayList<Wishlist> wishlists;
            LoadWishlistDAO wishlistDAO = LoadWishlistSource.getInstance().getAddWishlist();
            wishlists = wishlistDAO.getAllWishList(page,idCustomer,search,type,sex,status,numberPerPage);
            LoadWishlistSource.getInstance().releaseAddWishlist(wishlistDAO);
            return wishlists;
    }

    public static void main(String[] args) {
        System.out.println(loadWishlistById(1, "KH001", "", "ten_sp", 0, 1, 1));
    }
}
