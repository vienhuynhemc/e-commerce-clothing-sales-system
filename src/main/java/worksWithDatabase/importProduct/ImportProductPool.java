package worksWithDatabase.importProduct;


public class ImportProductPool {

    //---------------------------------Pool ---------------------------------

    private ImportProductWorksWithDatabase importProductWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo ImportProduct works with database
    public ImportProductPool() {

        //  Khởi tạo  ImportProduct works with database
        importProductWorksWithDatabase = new ImportProductWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized ImportProductWorksWithDatabase getImportProductWorksWithDatabase() {

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
        return importProductWorksWithDatabase;

    }

    //  Phương thứct trả về ImportProductWorksWithDatabase
    public synchronized void releaseImportProductWorksWithDatabase(ImportProductWorksWithDatabase importProductWorksWithDatabase) {

        //  Kiểm tra ImportProductWorksWithDatabase nhận vào có đúng là ImportProductWorksWithDatabase cửa lớp này hay không
        if (this.importProductWorksWithDatabase == importProductWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }
    
}
