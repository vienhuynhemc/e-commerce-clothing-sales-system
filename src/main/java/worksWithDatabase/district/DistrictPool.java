package worksWithDatabase.district;


public class DistrictPool {

    //---------------------------------Pool ---------------------------------

    private DistrictWorksWithDatabase districtWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo district works with database
    public DistrictPool() {

        //  Khởi tạo  district works with database
        districtWorksWithDatabase = new DistrictWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized DistrictWorksWithDatabase getDistrictWorksWithDatabase() {

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
        return districtWorksWithDatabase;

    }

    //  Phương thứct trả về districtWorksWithDatabase
    public synchronized void releaseDistrictWorksWithDatabase(DistrictWorksWithDatabase districtWorksWithDatabase) {

        //  Kiểm tra districtWorksWithDatabase nhận vào có đúng là districtWorksWithDatabase cửa lớp này hay không
        if (this.districtWorksWithDatabase == districtWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }
    
}
