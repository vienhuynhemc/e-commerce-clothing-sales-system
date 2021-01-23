package worksWithDatabase.productStructure;

public class ProductStructurePool {

    //---------------------------------Pool ---------------------------------

    private ProductStructureWorksWithDatabase productStructureWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo ProductStructure works with database
    public ProductStructurePool() {

        //  Khởi tạo  ProductStructure works with database
        productStructureWorksWithDatabase = new ProductStructureWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized ProductStructureWorksWithDatabase getProductStructureWorksWithDatabase() {

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
        return productStructureWorksWithDatabase;

    }

    //  Phương thứct trả về ProductStructureWorksWithDatabase
    public synchronized void releaseProductStructureWorksWithDatabase(ProductStructureWorksWithDatabase productStructureWorksWithDatabase) {

        //  Kiểm tra ProductStructureWorksWithDatabase nhận vào có đúng là ProductStructureWorksWithDatabase cửa lớp này hay không
        if (this.productStructureWorksWithDatabase == productStructureWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }
    
}
