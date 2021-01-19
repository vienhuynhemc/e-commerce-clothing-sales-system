package worksWithDatabase.wishlist;

public class AddWishlistSource {
    private static AddWishlistSource wishlistSource;
    private static AddWishlistPool wishlistPool;

    private AddWishlistSource(){ wishlistPool = new AddWishlistPool();}

    private static synchronized AddWishlistSource getInstance(){
        if(wishlistSource == null){
            wishlistSource =  new AddWishlistSource();
        }
        return wishlistSource;
    }
    public static AddWishlistDAO getAddWishlist(){ return wishlistPool.getAccount();}

    public static void releaseAddWishlist(AddWishlistDAO wishlistDAO){ wishlistPool.releaseAddWishlist(wishlistDAO);}

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                AddWishlistDAO a = AddWishlistSource.getInstance().getAddWishlist();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(2000);
                    a.addWishlist("sp012","kh002","vang02");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                AddWishlistSource.getInstance().releaseAddWishlist(a);
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
