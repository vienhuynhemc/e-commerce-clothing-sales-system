package worksWithDatabase.ringNotification;

public class RingNotificationDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy RingNotification works with data base
     *      2. Trả RingNotification works with data base
     */

    //  Khai báo RingNotificationpool
    private static RingNotificationPool ringNotificationPool;

    //  Khai báo instance
    private static RingNotificationDataSource ringNotificationDataSource;

    //  Constructor thì khởi tạo RingNotificationPool
    private RingNotificationDataSource() {
        ringNotificationPool = new RingNotificationPool();
    }

    //  Trả về thể hiện của RingNotificationDataSource
    public static synchronized RingNotificationDataSource getInstance() {

        //  Kiểm tra thử RingNotificationDataSource có null?
        if (ringNotificationDataSource == null) {

            //  null thì khởi tạo nó
            ringNotificationDataSource = new RingNotificationDataSource();

        }

        //  return về instance
        return ringNotificationDataSource;

    }

    //  Phương thúc lấy RingNotificationWorksWithDatabase
    public RingNotificationWorksWithDatabase getRingNotificationWorksWithDatabase() {

        //  Lấy RingNotificationWorksWithDatabase từ RingNotificationPool
        return ringNotificationPool.getRingNotificationWorksWithDatabase();

    }

    //  Phương thức trả RingNotificationWorksWithDatabase cho RingNotificationPool
    public void releaseRingNotificationWorksWithDatabase(RingNotificationWorksWithDatabase ringNotificationWorksWithDatabase) {

        //  Trả RingNotificationWorksWithDatabase về cho RingNotificationPool
        ringNotificationPool.releaseRingNotificationWorksWithDatabase(ringNotificationWorksWithDatabase);

    }
    
}
