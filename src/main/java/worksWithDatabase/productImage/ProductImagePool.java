package worksWithDatabase.productImage;


public class ProductImagePool {

    //---------------------------------Pool ---------------------------------

    private ProductImageWorksWithDatabase productImageWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo ProductImage works with database
    public ProductImagePool() {

        //  Khởi tạo  ProductImage works with database
        productImageWorksWithDatabase = new ProductImageWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized ProductImageWorksWithDatabase getProductImageWorksWithDatabase() {

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
        return productImageWorksWithDatabase;

    }

    //  Phương thứct trả về ProductImageWorksWithDatabase
    public synchronized void releaseProductImageWorksWithDatabase(ProductImageWorksWithDatabase productImageWorksWithDatabase) {

        //  Kiểm tra ProductImageWorksWithDatabase nhận vào có đúng là ProductImageWorksWithDatabase cửa lớp này hay không
        if (this.productImageWorksWithDatabase == productImageWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }
    
}
