package worksWithDatabase.cart;



public class LoadCartSource {
    private static LoadCartSource cartSource;
    private static LoadCartPool cartPool;

    private LoadCartSource(){
        cartPool = new LoadCartPool();
    }
    public static synchronized LoadCartSource getInstance(){
        if (cartSource == null){
            cartSource = new LoadCartSource();
        }
        return cartSource;
    }

    public LoadCartDAO getAddAccount(){
        return cartPool.getAccount();
    }
    public void releaseAddAccount (LoadCartDAO cartDAO){
        cartPool.releaseAddAccount(cartDAO);
    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                LoadCartDAO a = LoadCartSource.getInstance().getAddAccount();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                LoadCartSource.getInstance().releaseAddAccount(a);
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
