package worksWithDatabase.signUpUser;



public class SignUpPool {


        //---------------------------------Pool ---------------------------------

        private SignUpDAO signUpDAO;
        private boolean isActive;

        //-----------------------------------------------------------------------

        //  Constructor thì khởi tạo category works with database
        public SignUpPool() {

            //  Khởi tạo category works with database
            signUpDAO = new SignUpDAO();

            //  Đặt trạng thái hoạt động ban đầu là false
            isActive = false;

        }

        //  Lấy thể hiện của lớp, để ở trạng thái synchronized
        public synchronized SignUpDAO getSignUpDAO() {
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
            return signUpDAO;

        }

        //  Phương thứct trả về SignUpDAO
        public synchronized void releaseSignUpDAO(SignUpDAO signUpDAO) {

            //  Kiểm tra mail nhận vào có đúng là SignUpDAO cửa lớp này hay không
            if (this.signUpDAO == signUpDAO) {

                //  Đúng thì cho trạng thái hoạt động thành false
                isActive = false;

                //  Đánh thức các client đang chờ
                notifyAll();

            }
        }


}
