package worksWithDatabase.detailedRingerNotification;


public class DetailedRingerNotificationPool {

    //---------------------------------Pool ---------------------------------

    private DetailedRingerNotificationWorksWithDatabase detailedRingerNotificationWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo DetailedRingerNotification works with database
    public DetailedRingerNotificationPool() {

        //  Khởi tạo  DetailedRingerNotification works with database
        detailedRingerNotificationWorksWithDatabase = new DetailedRingerNotificationWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized DetailedRingerNotificationWorksWithDatabase getDetailedRingerNotificationWorksWithDatabase() {

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
        return detailedRingerNotificationWorksWithDatabase;

    }

    //  Phương thứct trả về DetailedRingerNotificationWorksWithDatabase
    public synchronized void releaseDetailedRingerNotificationWorksWithDatabase(DetailedRingerNotificationWorksWithDatabase detailedRingerNotificationWorksWithDatabase) {

        //  Kiểm tra DetailedRingerNotificationWorksWithDatabase nhận vào có đúng là DetailedRingerNotificationWorksWithDatabase cửa lớp này hay không
        if (this.detailedRingerNotificationWorksWithDatabase == detailedRingerNotificationWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }
    
}
