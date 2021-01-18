package worksWithDatabase.ringNotification;


public class RingNotificationPool {

    //---------------------------------Pool ---------------------------------

    private RingNotificationWorksWithDatabase ringNotificationWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo RingNotification works with database
    public RingNotificationPool() {

        //  Khởi tạo  RingNotification works with database
        ringNotificationWorksWithDatabase = new RingNotificationWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized RingNotificationWorksWithDatabase getRingNotificationWorksWithDatabase() {

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
        return ringNotificationWorksWithDatabase;

    }

    //  Phương thứct trả về RingNotificationWorksWithDatabase
    public synchronized void releaseRingNotificationWorksWithDatabase(RingNotificationWorksWithDatabase ingNotificationWorksWithDatabase) {

        //  Kiểm tra RingNotificationWorksWithDatabase nhận vào có đúng là RingNotificationWorksWithDatabase cửa lớp này hay không
        if (this.ringNotificationWorksWithDatabase == ringNotificationWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }
    
}
