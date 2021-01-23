package worksWithDatabase.productPrice;


public class ProductPricePool {

    //---------------------------------Pool ---------------------------------

    private ProductPriceWorksWithDatabase productPriceWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo ProductPrice works with database
    public ProductPricePool() {

        //  Khởi tạo  ProductPrice works with database
        productPriceWorksWithDatabase = new ProductPriceWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized ProductPriceWorksWithDatabase getProductPriceWorksWithDatabase() {

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
        return productPriceWorksWithDatabase;

    }

    //  Phương thứct trả về ProductPriceWorksWithDatabase
    public synchronized void releaseProductPriceWorksWithDatabase(ProductPriceWorksWithDatabase productPriceWorksWithDatabase) {

        //  Kiểm tra ProductPriceWorksWithDatabase nhận vào có đúng là ProductPriceWorksWithDatabase cửa lớp này hay không
        if (this.productPriceWorksWithDatabase == productPriceWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }
    
}
