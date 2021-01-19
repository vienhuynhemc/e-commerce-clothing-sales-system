package worksWithDatabase.order;

public class OrderPool {

    //---------------------------------Pool ---------------------------------

    private OrderWorksWithDatabase orderWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo Order works with database
    public OrderPool() {

        //  Khởi tạo  Order works with database
        orderWorksWithDatabase = new OrderWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized OrderWorksWithDatabase getOrderWorksWithDatabase() {

        //  Xem thử nó có đang được hoạt động hay không, đang hoạt động thì bắt client yêu cầu chờ
        while (isActive) {

            try {

                //  Hàm này sẽ bắt nó chờ đến khi nào được thông báo thức dậy
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        //  Xuống tới đây có nghĩa là đã được đánh thức
        //  Cho trạng thái thành true
        isActive = true;

        //  Trả về thể hiện
        return orderWorksWithDatabase;

    }

    //  Phương thứct trả về OrderWorksWithDatabase
    public synchronized void releaseOrderWorksWithDatabase(OrderWorksWithDatabase orderWorksWithDatabase) {

        //  Kiểm tra OrderWorksWithDatabase nhận vào có đúng là OrderWorksWithDatabase cửa lớp này hay không
        if (this.orderWorksWithDatabase == orderWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }
    
}
