package worksWithDatabase.product;

public class ProductPool {

    //---------------------------------Pool ---------------------------------

    private ProductWorksWithDatabase productWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo Product works with database
    public ProductPool() {

        //  Khởi tạo  Product works with database
        productWorksWithDatabase = new ProductWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized ProductWorksWithDatabase getProductWorksWithDatabase() {

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
        return productWorksWithDatabase;

    }

    //  Phương thứct trả về ProductWorksWithDatabase
    public synchronized void releaseProductWorksWithDatabase(ProductWorksWithDatabase productWorksWithDatabase) {

        //  Kiểm tra ProductWorksWithDatabase nhận vào có đúng là ProductWorksWithDatabase cửa lớp này hay không
        if (this.productWorksWithDatabase == productWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }

}
