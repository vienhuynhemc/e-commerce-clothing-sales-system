package worksWithDatabase.size;


public class SizePool {

    //---------------------------------Pool ---------------------------------

    private SizeWorksWithDatabase sizeWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo Size works with database
    public SizePool() {

        //  Khởi tạo  Size works with database
        sizeWorksWithDatabase = new SizeWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized SizeWorksWithDatabase getSizeWorksWithDatabase() {

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
        return sizeWorksWithDatabase;

    }

    //  Phương thứct trả về SizeWorksWithDatabase
    public synchronized void releaseSizeWorksWithDatabase(SizeWorksWithDatabase SizeWorksWithDatabase) {

        //  Kiểm tra SizeWorksWithDatabase nhận vào có đúng là SizeWorksWithDatabase cửa lớp này hay không
        if (this.sizeWorksWithDatabase == SizeWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }
    
}
