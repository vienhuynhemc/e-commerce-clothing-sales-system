package worksWithDatabase.color;


public class ColorPool {

    //---------------------------------Pool ---------------------------------

    private ColorWorksWithDatabase colorWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo Color works with database
    public ColorPool() {

        //  Khởi tạo  Color works with database
        colorWorksWithDatabase = new ColorWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized ColorWorksWithDatabase getColorWorksWithDatabase() {

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
        return colorWorksWithDatabase;

    }

    //  Phương thứct trả về ColorWorksWithDatabase
    public synchronized void releaseColorWorksWithDatabase(ColorWorksWithDatabase colorWorksWithDatabase) {

        //  Kiểm tra ColorWorksWithDatabase nhận vào có đúng là ColorWorksWithDatabase cửa lớp này hay không
        if (this.colorWorksWithDatabase == colorWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }
    
}
