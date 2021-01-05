package worksWithDatabase.staff;

public class StaffPool {

    //---------------------------------Pool ---------------------------------

    private StaffWorksWithDatabase staffWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo staff works with database
    public StaffPool() {

        //  Khởi tạo  staff works with database
        staffWorksWithDatabase = new StaffWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized StaffWorksWithDatabase getStaffWorksWithDatabase() {

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
        return staffWorksWithDatabase;

    }

    //  Phương thứct trả về staffWorksWithDatabase
    public synchronized void releaseStaffWorksWithDatabase(StaffWorksWithDatabase staffWorksWithDatabase) {

        //  Kiểm tra staffWorksWithDatabase nhận vào có đúng là staffWorksWithDatabase cửa lớp này hay không
        if (this.staffWorksWithDatabase == staffWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }


}
