package worksWithDatabase.cart;

public class RemoveCartSource {
    private static RemoveCartSource cartSource;
    private static RemoveCartPool cartPool;

    private RemoveCartSource(){
        cartPool = new RemoveCartPool();
    }
    public static synchronized RemoveCartSource getInstance(){
        if (cartSource == null){
            cartSource = new RemoveCartSource();
        }
        return cartSource;
    }

    public RemoveCartDAO getAddCart(){
        return cartPool.getAccount();
    }
    public void releaseRemoveCart (RemoveCartDAO cartDAO){
        cartPool.releaseAddCart(cartDAO);
    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                RemoveCartDAO a = RemoveCartSource.getInstance().getAddCart();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                RemoveCartSource.getInstance().releaseRemoveCart(a);
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
