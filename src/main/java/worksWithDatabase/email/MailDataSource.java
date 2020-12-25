package worksWithDatabase.email;

public class MailDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy EmailWorksWithDatabase
     *      2. Trả EmailWorksWithDatabase
     */

    //  Khai báo mailpool
    private static MailPool mailPool;

    //  Khai báo instance
    private static MailDataSource mailDataSource;

    //  Constructor thì khởi tạo mailPool
    private MailDataSource() {
        mailPool = new MailPool();
    }

    //  Trả về thể hiện của maildatasource
    public static synchronized MailDataSource getInstance() {

        //  Kiểm tra thử maildatasource có null?
        if (mailDataSource == null) {

            //  null thì khởi tạo nó
            mailDataSource = new MailDataSource();

        }

        //  return về instance
        return mailDataSource;

    }

    //  Phương thúc lấy EmailWorksWithDatabase
    public EmailWorksWithDatabase getEmailWorksWithDatabase() {

        //  Lấy EmailWorksWithDatabase từ mailPool
        return mailPool.getEmailWorksWithDatabase();

    }

    //  Phương thức trả EmailWorksWithDatabase cho mailPool
    public void releaseMailModel(EmailWorksWithDatabase emailWorksWithDatabase) {

        //  Trả EmailWorksWithDatabase về cho mailPool
        mailPool.releaseEmailWorksWithDatabase(emailWorksWithDatabase);

    }

}
