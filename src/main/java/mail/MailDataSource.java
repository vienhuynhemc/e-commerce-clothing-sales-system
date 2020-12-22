package mail;

public class MailDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy mailmodel
     *      2. Trả mailmodel
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

    //  Phương thúc lấy mailModel
    public MailModel getMailModel() {

        //  Lấy mailModel từ mailPool
        return mailPool.getMailModel();

    }

    //  Phương thức trả mailModel cho mailPool
    public void releaseMailModel(MailModel mailModel) {

        //  Trả mailModel về cho mailPool
        mailPool.releaseMailModel(mailModel);

    }

}
