package worksWithDatabase.address;


public class AddressPool {

    //---------------------------------Pool ---------------------------------

    private AddressWorksWithDatabase addressWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo Address works with database
    public AddressPool() {

        //  Khởi tạo  Address works with database
        addressWorksWithDatabase = new AddressWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized AddressWorksWithDatabase getAddressWorksWithDatabase() {

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
        return addressWorksWithDatabase;

    }

    //  Phương thứct trả về AddressWorksWithDatabase
    public synchronized void releaseAddressWorksWithDatabase(AddressWorksWithDatabase addressWorksWithDatabase) {

        //  Kiểm tra AddressWorksWithDatabase nhận vào có đúng là AddressWorksWithDatabase cửa lớp này hay không
        if (this.addressWorksWithDatabase == addressWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }
    
}
