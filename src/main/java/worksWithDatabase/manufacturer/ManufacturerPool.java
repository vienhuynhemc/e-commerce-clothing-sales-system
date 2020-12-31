package worksWithDatabase.manufacturer;

import worksWithDatabase.email.EmailWorksWithDatabase;

public class ManufacturerPool {

    //---------------------------------Pool ---------------------------------

    private ManufacturerWorksWithDatabase manufacturerWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo ManufacturerWorksWithDatabase
    public ManufacturerPool() {

        //  Khởi tạo  ManufacturerWorksWithDatabase
        manufacturerWorksWithDatabase = new ManufacturerWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized ManufacturerWorksWithDatabase getManufacturerWorksWithDatabase() {

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
        return manufacturerWorksWithDatabase;

    }

    //  Phương thứct trả về ManufacturerWorksWithDatabase
    public synchronized void releaseManufacturerWorksWithDatabase(ManufacturerWorksWithDatabase manufacturerWorksWithDatabase) {

        //  Kiểm tra ManufacturerWorksWithDatabase nhận vào có đúng là ManufacturerWorksWithDatabase cửa lớp này hay không
        if (this.manufacturerWorksWithDatabase == manufacturerWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }

}
