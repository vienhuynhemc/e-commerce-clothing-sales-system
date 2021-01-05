package worksWithDatabase.account;

public class AccountDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy account works with data base
     *      2. Trả account works with data base
     */

    //  Khai báo accountpool
    private static AccountPool accountPool;

    //  Khai báo instance
    private static AccountDataSource accountDataSource;

    //  Constructor thì khởi tạo accountPool
    private AccountDataSource() {
        accountPool = new AccountPool();
    }

    //  Trả về thể hiện của accountDataSource
    public static synchronized AccountDataSource getInstance() {

        //  Kiểm tra thử accountDataSource có null?
        if (accountDataSource == null) {

            //  null thì khởi tạo nó
            accountDataSource = new AccountDataSource();

        }

        //  return về instance
        return accountDataSource;

    }

    //  Phương thúc lấy accountWorksWithDatabase
    public AccountWorksWithDatabase getAccountWorksWithDatabase() {

        //  Lấy accountWorksWithDatabase từ accountPool
        return accountPool.getAccountWorksWithDatabase();

    }

    //  Phương thức trả accountWorksWithDatabase cho accountPool
    public void releaseAccountWorksWithDatabase(AccountWorksWithDatabase accountWorksWithDatabase) {

        //  Trả accountWorksWithDatabase về cho accountPool
        accountPool.releaseAccountWorksWithDatabase(accountWorksWithDatabase);

    }

}
