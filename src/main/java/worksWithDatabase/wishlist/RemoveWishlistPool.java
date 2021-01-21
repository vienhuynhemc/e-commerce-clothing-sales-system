package worksWithDatabase.wishlist;

public class RemoveWishlistPool {
    private RemoveWishlistDAO wishlist;
    private boolean isActive;

    public RemoveWishlistPool(){
        wishlist = new RemoveWishlistDAO();
        isActive = false;
    }
    public synchronized RemoveWishlistDAO getAccount(){
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
    public synchronized void releaseAddWishlist(RemoveWishlistDAO w){
        if(this.wishlist == w){
            isActive = false;
            notifyAll();
        }
    }

}
