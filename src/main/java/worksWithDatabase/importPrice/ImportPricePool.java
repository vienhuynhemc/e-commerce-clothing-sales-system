package worksWithDatabase.importPrice;

public class ImportPricePool {

    //---------------------------------Pool ---------------------------------

    private ImportPriceWorksWithDatabase importPriceWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo ImportPrice works with database
    public ImportPricePool() {

        //  Khởi tạo  ImportPrice works with database
        importPriceWorksWithDatabase = new ImportPriceWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized ImportPriceWorksWithDatabase getImportPriceWorksWithDatabase() {

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
        return importPriceWorksWithDatabase;

    }

    //  Phương thứct trả về ImportPriceWorksWithDatabase
    public synchronized void releaseImportPriceWorksWithDatabase(ImportPriceWorksWithDatabase importPriceWorksWithDatabase) {

        //  Kiểm tra ImportPriceWorksWithDatabase nhận vào có đúng là ImportPriceWorksWithDatabase cửa lớp này hay không
        if (this.importPriceWorksWithDatabase == importPriceWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }
    
}
