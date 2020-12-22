package mail;

public class MailPool {

    //---------------------------------Pool ---------------------------------

    private MailModel mailModel;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo mailModel
    public MailPool() {

        //  Khởi tạo mailPool
        mailModel = new MailModel();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized MailModel getMailModel() {

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
        return mailModel;

    }

    //  Phương thứct trả về mailmodel
    public synchronized void releaseMailModel(MailModel mailModel) {

        //  Kiểm tra mail nhận vào có đúng là mail cửa lớp này hay không
        if (this.mailModel == mailModel) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }

}
