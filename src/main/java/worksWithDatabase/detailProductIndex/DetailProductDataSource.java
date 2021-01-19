package worksWithDatabase.detailProductIndex;


public class DetailProductDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy CategoryWorksWithDatabase
     *      2. Trả CategoryWorksWithDatabase
     */

    //  Khai báo instance
    private static DetailProductDataSource detailProductDataSource;

    //  Khai báo categoryPool
    private DetailProductPool detailProductPool;

    //  Constructor thì khởi tạo categoryPool
    private DetailProductDataSource() {
        detailProductPool = new DetailProductPool();
    }

    //  Trả về thể hiện của categorydatasource
    public static synchronized DetailProductDataSource getInstance() {

        //  Kiểm tra thử categorydatasource có null?
        if (detailProductDataSource == null) {

            //  null thì khởi tạo nó
            detailProductDataSource = new DetailProductDataSource();

        }

        //  return về instance
        return detailProductDataSource;

    }

    //  Phương thúc lấy CategoryWorksWithDatabase
    public DetailProductDAO getDetailProduct() {

        //  Lấy CategoryWorksWithDatabase từ categoryPool
        return detailProductPool.getDetailProductDAO();

    }

    //  Phương thức trả CategoryWorksWithDatabase cho categoryPool
    public void releaseDetailProduct(DetailProductDAO detailProductDAO) {

        //  Trả EmailWorksWithDatabase về cho mailPool
        detailProductDataSource.releaseDetailProduct(detailProductDAO);

    }
//    public static void main(String[] args) {
//
//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
//                CategoryWorksWithDatabase a = DetailProductDataSource.getInstance().getCategoryWorksWithDatabase();
//                System.out.println(Thread.currentThread().getName() + "start");
//                try {
//                    System.out.println(a.removeCategory("dm_13"));
//                    Thread.sleep(2500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                DetailProductDataSource.getInstance().releaseCategoryWorksWithDatabase(a);
//                System.out.println(Thread.currentThread().getName() + "end");
//            }
//        };
//
//        Thread t1 = new Thread(r1,"1");
//
//        Thread t2 = new Thread(r1,"2");
//
//        Thread t3 = new Thread(r1,"3");
//
//        Thread t4 = new Thread(r1,"4");
//        t4.start();
//        t1.start();
//        t2.start();
//        t3.start();
//    }


}


