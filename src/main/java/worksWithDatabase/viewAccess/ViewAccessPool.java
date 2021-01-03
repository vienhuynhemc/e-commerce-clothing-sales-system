package worksWithDatabase.viewAccess;




public class ViewAccessPool {


        //---------------------------------Pool ---------------------------------

        private ViewAccessDAO viewAccessDAO;
        private boolean isActive;

        //-----------------------------------------------------------------------

        //  Constructor thì khởi tạo category works with database
        public ViewAccessPool() {

            //  Khởi tạo category works with database
            viewAccessDAO = new ViewAccessDAO();

            //  Đặt trạng thái hoạt động ban đầu là false
            isActive = false;

        }

        //  Lấy thể hiện của lớp, để ở trạng thái synchronized
        public synchronized ViewAccessDAO getViewAccessDAO() {
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
            return viewAccessDAO;

        }

        //  Phương thứct trả về SignUpDAO
        public synchronized void releaseViewAccessDAO(ViewAccessDAO viewAccessDAO) {

            //  Kiểm tra mail nhận vào có đúng là SignUpDAO cửa lớp này hay không
            if (this.viewAccessDAO == viewAccessDAO) {

                //  Đúng thì cho trạng thái hoạt động thành false
                isActive = false;

                //  Đánh thức các client đang chờ
                notifyAll();

            }
        }


}
