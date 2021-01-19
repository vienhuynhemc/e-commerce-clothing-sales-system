package worksWithDatabase.detailedRingerNotification;

public class DetailedRingerNotificationDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy DetailedRingerNotification works with data base
     *      2. Trả DetailedRingerNotification works with data base
     */

    //  Khai báo DetailedRingerNotificationpool
    private static DetailedRingerNotificationPool detailedRingerNotificationPool;

    //  Khai báo instance
    private static DetailedRingerNotificationDataSource detailedRingerNotificationDataSource;

    //  Constructor thì khởi tạo DetailedRingerNotificationPool
    private DetailedRingerNotificationDataSource() {
        detailedRingerNotificationPool = new DetailedRingerNotificationPool();
    }

    //  Trả về thể hiện của DetailedRingerNotificationDataSource
    public static synchronized DetailedRingerNotificationDataSource getInstance() {

        //  Kiểm tra thử DetailedRingerNotificationDataSource có null?
        if (detailedRingerNotificationDataSource == null) {

            //  null thì khởi tạo nó
            detailedRingerNotificationDataSource = new DetailedRingerNotificationDataSource();

        }

        //  return về instance
        return detailedRingerNotificationDataSource;

    }

    //  Phương thúc lấy DetailedRingerNotificationWorksWithDatabase
    public DetailedRingerNotificationWorksWithDatabase getDetailedRingerNotificationWorksWithDatabase() {

        //  Lấy DetailedRingerNotificationWorksWithDatabase từ DetailedRingerNotificationPool
        return detailedRingerNotificationPool.getDetailedRingerNotificationWorksWithDatabase();

    }

    //  Phương thức trả DetailedRingerNotificationWorksWithDatabase cho DetailedRingerNotificationPool
    public void releaseDetailedRingerNotificationWorksWithDatabase(DetailedRingerNotificationWorksWithDatabase detailedRingerNotificationWorksWithDatabase) {

        //  Trả DetailedRingerNotificationWorksWithDatabase về cho DetailedRingerNotificationPool
        detailedRingerNotificationPool.releaseDetailedRingerNotificationWorksWithDatabase(detailedRingerNotificationWorksWithDatabase);

    }
    
}
