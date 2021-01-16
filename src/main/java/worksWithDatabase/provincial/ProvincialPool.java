package worksWithDatabase.provincial;


public class ProvincialPool {

    //---------------------------------Pool ---------------------------------

    private ProvincialWorksWithDatabase provincialWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo ProvincialWorksWithDatabase
    public ProvincialPool() {

        //  Khởi tạo  ProvincialWorksWithDatabase
        provincialWorksWithDatabase = new ProvincialWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized ProvincialWorksWithDatabase getProvincialWorksWithDatabase() {

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
        return provincialWorksWithDatabase;

    }

    //  Phương thứct trả về provincialWorksWithDatabase
    public synchronized void releaseProvincialWorksWithDatabase(ProvincialWorksWithDatabase ProvincialWorksWithDatabase) {

        //  Kiểm tra provincialWorksWithDatabase nhận vào có đúng là provincialWorksWithDatabase cửa lớp này hay không
        if (this.provincialWorksWithDatabase == provincialWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }
    
}
