package worksWithDatabase.role;

public class RolePool {

    //---------------------------------Pool ---------------------------------

    private RoleWorksWithDatabase roleWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo role works with database
    public RolePool() {

        //  Khởi tạo  role works with database
        roleWorksWithDatabase = new RoleWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized RoleWorksWithDatabase getRoleWorksWithDatabase() {

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
        return roleWorksWithDatabase;

    }

    //  Phương thứct trả về roleWorksWithDatabase
    public synchronized void releaseRoleWorksWithDatabase(RoleWorksWithDatabase roleWorksWithDatabase) {

        //  Kiểm tra roleWorksWithDatabase nhận vào có đúng là roleWorksWithDatabase cửa lớp này hay không
        if (this.roleWorksWithDatabase == roleWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }
    
}
