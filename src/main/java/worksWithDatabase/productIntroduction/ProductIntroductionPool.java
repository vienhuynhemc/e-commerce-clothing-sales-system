package worksWithDatabase.productIntroduction;


public class ProductIntroductionPool {

    //---------------------------------Pool ---------------------------------

    private ProductIntroductionWorksWithDatabase productIntroductionWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo ProductIntroduction works with database
    public ProductIntroductionPool() {

        //  Khởi tạo  ProductIntroduction works with database
        productIntroductionWorksWithDatabase = new ProductIntroductionWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized ProductIntroductionWorksWithDatabase getProductIntroductionWorksWithDatabase() {

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
        return productIntroductionWorksWithDatabase;

    }

    //  Phương thứct trả về ProductIntroductionWorksWithDatabase
    public synchronized void releaseProductIntroductionWorksWithDatabase(ProductIntroductionWorksWithDatabase productIntroductionWorksWithDatabase) {

        //  Kiểm tra ProductIntroductionWorksWithDatabase nhận vào có đúng là ProductIntroductionWorksWithDatabase cửa lớp này hay không
        if (this.productIntroductionWorksWithDatabase == productIntroductionWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }
    
}
