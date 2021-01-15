package worksWithDatabase.wishlist;

import worksWithDatabase.cart.LoadCartDAO;
import worksWithDatabase.cart.LoadCartSource;

public class LoadWishlistSource {
    private static LoadWishlistPool wishlistPool;
    private static LoadWishlistSource wishlistSource;

    private LoadWishlistSource(){
        wishlistPool = new LoadWishlistPool();
    }
    public static synchronized LoadWishlistSource getInstance(){
        if(wishlistSource == null){
            wishlistSource = new LoadWishlistSource();
        }
        return wishlistSource;
    }
    public LoadWishlistDAO getAddWishlist(){ return wishlistPool.getAccount();}

    public void releaseAddWishlist(LoadWishlistDAO a){
        wishlistPool.releaseLoadAccount(a);
    }
    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                LoadWishlistDAO a = LoadWishlistSource.getInstance().getAddWishlist();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                LoadWishlistSource.getInstance().releaseAddWishlist(a);
                System.out.println(Thread.currentThread().getName() + "end");
            }
        };

        Thread t1 = new Thread(r1,"1");

        Thread t2 = new Thread(r1,"2");

        Thread t3 = new Thread(r1,"3");

        Thread t4 = new Thread(r1,"4");
        t4.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
