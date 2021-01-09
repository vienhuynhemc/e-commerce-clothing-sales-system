package worksWithDatabase.cart;

public class AddCartSource {
    private static AddCartSource cartSource;
    private static AddCartPool cartPool;

    private AddCartSource(){
        cartPool = new AddCartPool();
    }
    public static synchronized AddCartSource getInstance(){
        if (cartSource == null){
            cartSource = new AddCartSource();
        }
        return cartSource;
    }

    public AddCartDAO getAddCart(){
        return cartPool.getAccount();
    }
    public void releaseAddCart (AddCartDAO cartDAO){
        cartPool.releaseAddCart(cartDAO);
    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                AddCartDAO a = AddCartSource.getInstance().getAddCart();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                AddCartSource.getInstance().releaseAddCart(a);
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
