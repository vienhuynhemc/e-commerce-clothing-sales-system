package worksWithDatabase.wishlist;

public class LoadWishlistPool {
    private LoadWishlistDAO wishlistDAO;
    private boolean isActive;

    public LoadWishlistPool(){
        wishlistDAO = new LoadWishlistDAO();
        isActive = false;
    }
    public synchronized LoadWishlistDAO getAccount(){
        while(isActive){
            try {
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        isActive = true;
        return wishlistDAO;
    }
    public synchronized void releaseLoadAccount(LoadWishlistDAO w){
        if(wishlistDAO == w) {
            isActive = false;
            notifyAll();
        }
    }
}
