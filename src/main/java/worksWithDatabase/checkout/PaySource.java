package worksWithDatabase.checkout;


public class PaySource {

    private static PaySource paySource;
    private static PayPool payPool;

    private PaySource(){
        payPool = new PayPool();
    }
    public static synchronized PaySource getInstance(){
        if (paySource == null){
            paySource = new PaySource();
        }
        return paySource;
    }

    public Pay getPay(){
        return payPool.getPay();
    }
    public void releasePay(Pay pay){
        payPool.releasePay(pay);
    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                Pay a = PaySource.getInstance().getPay();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                PaySource.getInstance().releasePay(a);
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
