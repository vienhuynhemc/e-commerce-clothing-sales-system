package worksWithDatabase.personalNotice;


public class PersonalNoticePool {


    //---------------------------------Pool ---------------------------------

    private PersonalNoticeWorksWithDatabase personalNoticeWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo PersonalNotice works with database
    public PersonalNoticePool() {

        //  Khởi tạo  PersonalNotice works with database
        personalNoticeWorksWithDatabase = new PersonalNoticeWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized PersonalNoticeWorksWithDatabase getPersonalNoticeWorksWithDatabase() {

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
        return personalNoticeWorksWithDatabase;

    }

    //  Phương thứct trả về PersonalNoticeWorksWithDatabase
    public synchronized void releasePersonalNoticeWorksWithDatabase(PersonalNoticeWorksWithDatabase personalNoticeWorksWithDatabase) {

        //  Kiểm tra PersonalNoticeWorksWithDatabase nhận vào có đúng là PersonalNoticeWorksWithDatabase cửa lớp này hay không
        if (this.personalNoticeWorksWithDatabase == personalNoticeWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }
    
}
