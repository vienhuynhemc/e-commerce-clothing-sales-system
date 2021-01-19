package worksWithDatabase.order;

public class OrderDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy Order works with data base
     *      2. Trả Order works with data base
     */

    //  Khai báo Orderpool
    private static OrderPool orderPool;

    //  Khai báo instance
    private static OrderDataSource orderDataSource;

    //  Constructor thì khởi tạo OrderPool
    private OrderDataSource() {
        orderPool = new OrderPool();
    }

    //  Trả về thể hiện của OrderDataSource
    public static synchronized OrderDataSource getInstance() {

        //  Kiểm tra thử OrderDataSource có null?
        if (orderDataSource == null) {

            //  null thì khởi tạo nó
            orderDataSource = new OrderDataSource();

        }

        //  return về instance
        return orderDataSource;

    }

    //  Phương thúc lấy OrderWorksWithDatabase
    public OrderWorksWithDatabase getOrderWorksWithDatabase() {

        //  Lấy OrderWorksWithDatabase từ OrderPool
        return orderPool.getOrderWorksWithDatabase();

    }

    //  Phương thức trả OrderWorksWithDatabase cho OrderPool
    public void releaseOrderWorksWithDatabase(OrderWorksWithDatabase orderWorksWithDatabase) {

        //  Trả OrderWorksWithDatabase về cho OrderPool
        orderPool.releaseOrderWorksWithDatabase(orderWorksWithDatabase);

    }
    
}
