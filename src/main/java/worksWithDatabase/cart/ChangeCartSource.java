package worksWithDatabase.cart;

public class ChangeCartSource {
    private static ChangeCartSource cartSource;
    private static ChangeCartPool cartPool;

    private ChangeCartSource(){
        cartPool = new ChangeCartPool();
    }
    public static synchronized ChangeCartSource getInstance(){
        if (cartSource == null){
            cartSource = new ChangeCartSource();
        }
        return cartSource;
    }

    public ChangeCartDAO getAddCart(){
        return cartPool.getAccount();
    }
    public void releaseRemoveCart (ChangeCartDAO cartDAO){
        cartPool.releaseIncreaseCart(cartDAO);
    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                ChangeCartDAO a = ChangeCartSource.getInstance().getAddCart();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                ChangeCartSource.getInstance().releaseRemoveCart(a);
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
