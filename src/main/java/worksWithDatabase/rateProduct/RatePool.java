package worksWithDatabase.rateProduct;



public class RatePool {

    //---------------------------------Pool ---------------------------------

    private RateDAO rateDAO;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo category works with database
    public RatePool() {

        //  Khởi tạo category works with database
        rateDAO = new RateDAO();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized RateDAO getRateDAO() {

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
        return rateDAO;

    }

    //  Phương thứct trả về CategoryWorksWithDatabas
    public synchronized void releaseRateDAO(RateDAO rateDAO) {

        //  Kiểm tra mail nhận vào có đúng là CategoryWorksWithDatabas cửa lớp này hay không
        if (this.rateDAO == rateDAO) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }
    }


}
