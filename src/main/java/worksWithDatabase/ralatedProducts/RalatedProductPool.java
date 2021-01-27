package worksWithDatabase.ralatedProducts;


public class RalatedProductPool {

    //---------------------------------Pool ---------------------------------

    private RalatedProductDAO ralatedProductDAO;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo category works with database
    public RalatedProductPool() {

        //  Khởi tạo category works with database
        ralatedProductDAO = new RalatedProductDAO();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized RalatedProductDAO getRateDAO() {

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
        return ralatedProductDAO;

    }

    //  Phương thứct trả về CategoryWorksWithDatabas
    public synchronized void releaseRalatedProductDAO(RalatedProductDAO ralatedProductDAO) {

        //  Kiểm tra mail nhận vào có đúng là CategoryWorksWithDatabas cửa lớp này hay không
        if (this.ralatedProductDAO == ralatedProductDAO) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }
    }


}
