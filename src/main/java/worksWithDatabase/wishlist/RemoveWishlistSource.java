package worksWithDatabase.wishlist;

public class RemoveWishlistSource {
    private static RemoveWishlistSource wishlistSource;
    private RemoveWishlistPool wishlistPool;

    private RemoveWishlistSource(){ wishlistPool = new RemoveWishlistPool();}

    public static synchronized RemoveWishlistSource getInstance(){
        if(wishlistSource == null){
            wishlistSource =  new RemoveWishlistSource();
        }
        return wishlistSource;
    }
    public RemoveWishlistDAO getAddWishlist(){ return wishlistPool.getAccount();}

    public void releaseAddWishlist(RemoveWishlistDAO wishlistDAO){ wishlistPool.releaseAddWishlist(wishlistDAO);}

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                RemoveWishlistDAO a = RemoveWishlistSource.getInstance().getAddWishlist();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(2000);
                    System.out.println(a.removeWishlist("sp_5","kh002","vang","m"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                RemoveWishlistSource.getInstance().releaseAddWishlist(a);
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
