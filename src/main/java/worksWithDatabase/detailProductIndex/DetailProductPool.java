package worksWithDatabase.detailProductIndex;

public class DetailProductPool {

    //---------------------------------Pool ---------------------------------

    private DetailProductDAO detailProductDAO;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo category works with database
    public DetailProductPool() {

        //  Khởi tạo category works with database
        detailProductDAO = new DetailProductDAO();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized DetailProductDAO getDetailProductDAO() {

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
        return detailProductDAO;

    }

    //  Phương thứct trả về CategoryWorksWithDatabas
    public synchronized void releaseDetailProduct(DetailProductDAO detailProductDAO) {

        //  Kiểm tra mail nhận vào có đúng là CategoryWorksWithDatabas cửa lớp này hay không
        if (this.detailProductDAO == detailProductDAO) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }
    }


}
