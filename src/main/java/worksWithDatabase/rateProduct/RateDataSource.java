package worksWithDatabase.rateProduct;


import beans.rate.Rate;

public class RateDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy CategoryWorksWithDatabase
     *      2. Trả CategoryWorksWithDatabase
     */

    //  Khai báo instance
    private static RateDataSource rateDataSource;

    //  Khai báo categoryPool
    private RatePool ratePool;

    //  Constructor thì khởi tạo categoryPool
    private RateDataSource() {
        ratePool = new RatePool();
    }

    //  Trả về thể hiện của categorydatasource
    public static synchronized RateDataSource getInstance() {

        //  Kiểm tra thử categorydatasource có null?
        if (rateDataSource == null) {

            //  null thì khởi tạo nó
            rateDataSource = new RateDataSource();

        }

        //  return về instance
        return rateDataSource;

    }

    //  Phương thúc lấy CategoryWorksWithDatabase
    public RateDAO getRateDAO() {

        //  Lấy CategoryWorksWithDatabase từ categoryPool
        return ratePool.getRateDAO();

    }

    //  Phương thức trả CategoryWorksWithDatabase cho categoryPool
    public void releaseRateDAO(RateDAO rateDAO) {

        //  Trả EmailWorksWithDatabase về cho mailPool
        ratePool.releaseRateDAO(rateDAO);

    }
    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                RateDAO a = RateDataSource.getInstance().getRateDAO();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    System.out.println(a.checkRatePermission("sp_5","kh001"));
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                RateDataSource.getInstance().releaseRateDAO(a);
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


