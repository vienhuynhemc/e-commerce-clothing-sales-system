package worksWithDatabase.manufacturerInformation;

public class ManufacturerInformationPool {

    //---------------------------------Pool ---------------------------------

    private ManufacturerInformationWorksWithDatabase manufacturerInformationWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo ManufacturerInformationWorksWithDatabase
    public ManufacturerInformationPool() {

        //  Khởi tạo  ManufacturerInformationWorksWithDatabase
        manufacturerInformationWorksWithDatabase = new ManufacturerInformationWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized ManufacturerInformationWorksWithDatabase getManufacturerInformationWorksWithDatabase() {

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
        return manufacturerInformationWorksWithDatabase;

    }

    //  Phương thứct trả về ManufacturerInformationWorksWithDatabase
    public synchronized void releaseManufacturerInformationWorksWithDatabase(ManufacturerInformationWorksWithDatabase manufacturerInformationWorksWithDatabase) {

        //  Kiểm tra ManufacturerInformationWorksWithDatabase nhận vào có đúng là ManufacturerInformationWorksWithDatabase cửa lớp này hay không
        if (this.manufacturerInformationWorksWithDatabase == manufacturerInformationWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }

}
