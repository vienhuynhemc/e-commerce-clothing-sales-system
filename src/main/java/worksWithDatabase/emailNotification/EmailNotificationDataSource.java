package worksWithDatabase.emailNotification;

public class EmailNotificationDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy emailNotification works with data base
     *      2. Trả emailNotification works with data base
     */

    //  Khai báo emailNotificationpool
    private static EmailNotificationPool emailNotificationPool;

    //  Khai báo instance
    private static EmailNotificationDataSource emailNotificationDataSource;

    //  Constructor thì khởi tạo emailNotificationPool
    private EmailNotificationDataSource() {
        emailNotificationPool = new EmailNotificationPool();
    }

    //  Trả về thể hiện của emailNotificationDataSource
    public static synchronized EmailNotificationDataSource getInstance() {

        //  Kiểm tra thử emailNotificationDataSource có null?
        if (emailNotificationDataSource == null) {

            //  null thì khởi tạo nó
            emailNotificationDataSource = new EmailNotificationDataSource();

        }

        //  return về instance
        return emailNotificationDataSource;

    }

    //  Phương thúc lấy emailNotificationWorksWithDatabase
    public EmailNotificationWorksWithDatabase getEmailNotificationWorksWithDatabase() {

        //  Lấy emailNotificationWorksWithDatabase từ emailNotificationPool
        return emailNotificationPool.getEmailNotificationWorksWithDatabase();

    }

    //  Phương thức trả emailNotificationWorksWithDatabase cho emailNotificationPool
    public void releaseEmailNotificationWorksWithDatabase(EmailNotificationWorksWithDatabase emailNotificationWorksWithDatabase) {

        //  Trả emailNotificationWorksWithDatabase về cho emailNotificationPool
        emailNotificationPool.releaseEmailNotificationWorksWithDatabase(emailNotificationWorksWithDatabase);

    }
    
}
