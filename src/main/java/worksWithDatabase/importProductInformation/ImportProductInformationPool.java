package worksWithDatabase.importProductInformation;

public class ImportProductInformationPool {

    //---------------------------------Pool ---------------------------------

    private ImportProductInformationWorksWithDatabase importProductInformationWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo ImportProductInformation works with database
    public ImportProductInformationPool() {

        //  Khởi tạo  ImportProductInformation works with database
        importProductInformationWorksWithDatabase = new ImportProductInformationWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized ImportProductInformationWorksWithDatabase getImportProductInformationWorksWithDatabase() {

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
        return importProductInformationWorksWithDatabase;

    }

    //  Phương thứct trả về ImportProductInformationWorksWithDatabase
    public synchronized void releaseImportProductInformationWorksWithDatabase(ImportProductInformationWorksWithDatabase importProductInformationWorksWithDatabase) {

        //  Kiểm tra ImportProductInformationWorksWithDatabase nhận vào có đúng là ImportProductInformationWorksWithDatabase cửa lớp này hay không
        if (this.importProductInformationWorksWithDatabase == importProductInformationWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }
    
}
