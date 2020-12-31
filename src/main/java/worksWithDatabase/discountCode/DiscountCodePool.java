package worksWithDatabase.discountCode;

public class DiscountCodePool {

    //---------------------------------Pool ---------------------------------

    private DiscountCodeWorksWithDatabase discountCodeWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo DiscountCodeWorksWithDatabase
    public DiscountCodePool() {

        //  Khởi tạo  DiscountCodeWorksWithDatabase
        discountCodeWorksWithDatabase = new DiscountCodeWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized DiscountCodeWorksWithDatabase getDiscountCodeWorksWithDatabase() {

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
        return discountCodeWorksWithDatabase;

    }

    //  Phương thứct trả về DiscountCodeWorksWithDatabase
    public synchronized void releaseDiscountCodeWorksWithDatabase(DiscountCodeWorksWithDatabase discountCodeWorksWithDatabase) {

        //  Kiểm tra discountCodeWorksWithDatabase nhận vào có đúng là discountCodeWorksWithDatabase cửa lớp này hay không
        if (this.discountCodeWorksWithDatabase == discountCodeWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }

}
