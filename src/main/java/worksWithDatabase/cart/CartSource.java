package worksWithDatabase.cart;



public class CartSource {
    private static CartSource cartSource;
    private static CartPool cartPool;

    private CartSource(){
        cartPool = new CartPool();
    }
    public static synchronized CartSource getInstance(){
        if (cartSource == null){
            cartSource = new CartSource();
        }
        return cartSource;
    }

    public CartDAO getAddAccount(){
        return cartPool.getAccount();
    }
    public void releaseAddAccount (CartDAO cartDAO){
        cartPool.releaseAddAccount(cartDAO);
    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                CartDAO a = CartSource.getInstance().getAddAccount();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                CartSource.getInstance().releaseAddAccount(a);
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
