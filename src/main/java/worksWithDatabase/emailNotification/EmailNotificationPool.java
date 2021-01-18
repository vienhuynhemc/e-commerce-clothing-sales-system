package worksWithDatabase.emailNotification;


public class EmailNotificationPool {

    //---------------------------------Pool ---------------------------------

    private EmailNotificationWorksWithDatabase emailNotificationWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo emailNotification works with database
    public EmailNotificationPool() {

        //  Khởi tạo  emailNotification works with database
        emailNotificationWorksWithDatabase = new EmailNotificationWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized EmailNotificationWorksWithDatabase getEmailNotificationWorksWithDatabase() {

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
        return emailNotificationWorksWithDatabase;

    }

    //  Phương thứct trả về emailNotificationWorksWithDatabase
    public synchronized void releaseEmailNotificationWorksWithDatabase(EmailNotificationWorksWithDatabase emailNotificationWorksWithDatabase) {

        //  Kiểm tra emailNotificationWorksWithDatabase nhận vào có đúng là emailNotificationWorksWithDatabase cửa lớp này hay không
        if (this.emailNotificationWorksWithDatabase == emailNotificationWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }
    
}
