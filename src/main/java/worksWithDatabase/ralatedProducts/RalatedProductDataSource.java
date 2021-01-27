package worksWithDatabase.ralatedProducts;


public class RalatedProductDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy CategoryWorksWithDatabase
     *      2. Trả CategoryWorksWithDatabase
     */

    //  Khai báo instance
    private static RalatedProductDataSource ralatedProductDataSource;

    //  Khai báo categoryPool
    private RalatedProductPool ralatedProductPool;

    //  Constructor thì khởi tạo categoryPool
    private RalatedProductDataSource() {
        ralatedProductPool = new RalatedProductPool();
    }

    //  Trả về thể hiện của categorydatasource
    public static synchronized RalatedProductDataSource getInstance() {

        //  Kiểm tra thử categorydatasource có null?
        if (ralatedProductDataSource == null) {

            //  null thì khởi tạo nó
            ralatedProductDataSource = new RalatedProductDataSource();

        }

        //  return về instance
        return ralatedProductDataSource;

    }

    //  Phương thúc lấy CategoryWorksWithDatabase
    public RalatedProductDAO getRalatedProductDAO() {

        //  Lấy CategoryWorksWithDatabase từ categoryPool
        return ralatedProductPool.getRateDAO();

    }

    //  Phương thức trả CategoryWorksWithDatabase cho categoryPool
    public void releaseRalatedProductDAO(RalatedProductDAO ralatedProductDAO) {

        //  Trả EmailWorksWithDatabase về cho mailPool
        ralatedProductPool.releaseRalatedProductDAO(ralatedProductDAO);

    }
    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                RalatedProductDAO a = RalatedProductDataSource.getInstance().getRalatedProductDAO();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
//                    System.out.println(a.checkRatePermission("sp_5","kh001"));
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                RalatedProductDataSource.getInstance().releaseRalatedProductDAO(a);
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


