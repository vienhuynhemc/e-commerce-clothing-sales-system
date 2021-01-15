package worksWithDatabase.wishlist;

public class AddWishlistPool {
    private AddWishlistDAO wishlist;
    private boolean isActive;

    public AddWishlistPool(){
        wishlist = new AddWishlistDAO();
        isActive = false;
    }
    public synchronized AddWishlistDAO getAccount(){
        while(isActive){
            try{
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        isActive = true;
        return wishlist;
    }
    public synchronized void releaseAddWishlist(AddWishlistDAO w){
        if(this.wishlist == w){
            isActive = false;
            notifyAll();
        }
    }

}
