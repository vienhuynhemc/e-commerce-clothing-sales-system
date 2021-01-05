package worksWithDatabase.account;

public class AccountPool {

    //---------------------------------Pool ---------------------------------

    private AccountWorksWithDatabase accountWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo account works with database
    public AccountPool() {

        //  Khởi tạo  account works with database
        accountWorksWithDatabase = new AccountWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized AccountWorksWithDatabase getAccountWorksWithDatabase() {

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
        return accountWorksWithDatabase;

    }

    //  Phương thứct trả về accountWorksWithDatabase
    public synchronized void releaseAccountWorksWithDatabase(AccountWorksWithDatabase accountWorksWithDatabase) {

        //  Kiểm tra accountWorksWithDatabase nhận vào có đúng là accountWorksWithDatabase cửa lớp cnày hay không
        if (this.accountWorksWithDatabase == accountWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }


}
