package worksWithDatabase.productDetailInformation;

public class ProductDetailInformationPool {

    //---------------------------------Pool ---------------------------------

    private ProductDetailInformationWorksWithDatabase productDetailInformationWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo email ProductDetailInformation works with database
    public ProductDetailInformationPool() {

        //  Khởi tạo  ProductDetailInformation works with database
        productDetailInformationWorksWithDatabase = new ProductDetailInformationWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized ProductDetailInformationWorksWithDatabase getProductDetailInformationWorksWithDatabase() {

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
        return productDetailInformationWorksWithDatabase;

    }

    //  Phương thứct trả về ProductDetailInformationWorksWithDatabase
    public synchronized void releaseProductDetailInformationWorksWithDatabase(ProductDetailInformationWorksWithDatabase productDetailInformationWorksWithDatabase) {

        //  Kiểm tra mail nhận vào có đúng là mail cửa lớp này hay không
        if (this.productDetailInformationWorksWithDatabase == productDetailInformationWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }

}
