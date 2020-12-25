package worksWithDatabase.email;

public class MailPool {

    //---------------------------------Pool ---------------------------------

    private EmailWorksWithDatabase emailWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo email works with database
    public MailPool() {

        //  Khởi tạo  email works with database
        emailWorksWithDatabase = new EmailWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized EmailWorksWithDatabase getEmailWorksWithDatabase() {

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
        return emailWorksWithDatabase;

    }

    //  Phương thứct trả về EmailWorksWithDatabase
    public synchronized void releaseEmailWorksWithDatabase(EmailWorksWithDatabase emailWorksWithDatabase) {

        //  Kiểm tra mail nhận vào có đúng là mail cửa lớp này hay không
        if (this.emailWorksWithDatabase == emailWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }

}
