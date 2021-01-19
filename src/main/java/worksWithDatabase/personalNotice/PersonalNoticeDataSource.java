package worksWithDatabase.personalNotice;

public class PersonalNoticeDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy PersonalNotice works with data base
     *      2. Trả PersonalNotice works with data base
     */

    //  Khai báo PersonalNoticepool
    private static PersonalNoticePool personalNoticePool;

    //  Khai báo instance
    private static PersonalNoticeDataSource personalNoticeDataSource;

    //  Constructor thì khởi tạo PersonalNoticePool
    private PersonalNoticeDataSource() {
        personalNoticePool = new PersonalNoticePool();
    }

    //  Trả về thể hiện của PersonalNoticeDataSource
    public static synchronized PersonalNoticeDataSource getInstance() {

        //  Kiểm tra thử PersonalNoticeDataSource có null?
        if (personalNoticeDataSource == null) {

            //  null thì khởi tạo nó
            personalNoticeDataSource = new PersonalNoticeDataSource();

        }

        //  return về instance
        return personalNoticeDataSource;

    }

    //  Phương thúc lấy PersonalNoticeWorksWithDatabase
    public PersonalNoticeWorksWithDatabase getPersonalNoticeWorksWithDatabase() {

        //  Lấy PersonalNoticeWorksWithDatabase từ PersonalNoticePool
        return personalNoticePool.getPersonalNoticeWorksWithDatabase();

    }

    //  Phương thức trả PersonalNoticeWorksWithDatabase cho PersonalNoticePool
    public void releasePersonalNoticeWorksWithDatabase(PersonalNoticeWorksWithDatabase personalNoticeWorksWithDatabase) {

        //  Trả PersonalNoticeWorksWithDatabase về cho PersonalNoticePool
        personalNoticePool.releasePersonalNoticeWorksWithDatabase(personalNoticeWorksWithDatabase);

    }
    
}
