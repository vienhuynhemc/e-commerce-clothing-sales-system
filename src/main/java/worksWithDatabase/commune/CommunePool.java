package worksWithDatabase.commune;


public class CommunePool {

    //---------------------------------Pool ---------------------------------

    private CommuneWorksWithDatabase communeWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo Commune works with database
    public CommunePool() {

        //  Khởi tạo  Commune works with database
        communeWorksWithDatabase = new CommuneWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized CommuneWorksWithDatabase getCommuneWorksWithDatabase() {

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
        return communeWorksWithDatabase;

    }

    //  Phương thứct trả về CommuneWorksWithDatabase
    public synchronized void releaseCommuneWorksWithDatabase(CommuneWorksWithDatabase communeWorksWithDatabase) {

        //  Kiểm tra CommuneWorksWithDatabase nhận vào có đúng là CommuneWorksWithDatabase cửa lớp này hay không
        if (this.communeWorksWithDatabase == communeWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }

}
