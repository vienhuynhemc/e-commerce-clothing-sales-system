package worksWithDatabase.productInformation;


public class ProductInformationPool {

    //---------------------------------Pool ---------------------------------

    private ProductInformationWorksWithDatabase productInformationWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo ProductInformation works with database
    public ProductInformationPool() {

        //  Khởi tạo  ProductInformation works with database
        productInformationWorksWithDatabase = new ProductInformationWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized ProductInformationWorksWithDatabase getProductInformationWorksWithDatabase() {

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
        return productInformationWorksWithDatabase;

    }

    //  Phương thứct trả về ProductInformationWorksWithDatabase
    public synchronized void releaseProductInformationWorksWithDatabase(ProductInformationWorksWithDatabase productInformationWorksWithDatabase) {

        //  Kiểm tra ProductInformationWorksWithDatabase nhận vào có đúng là ProductInformationWorksWithDatabase cửa lớp này hay không
        if (this.productInformationWorksWithDatabase == productInformationWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }
    
}
