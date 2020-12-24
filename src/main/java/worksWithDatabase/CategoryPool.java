package worksWithDatabase;

public class CategoryPool {

    //---------------------------------Pool ---------------------------------

    private CategoryWorksWithDatabase categoryWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo category works with database
    public CategoryPool() {

        //  Khởi tạo category works with database
        categoryWorksWithDatabase = new CategoryWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized CategoryWorksWithDatabase getCategoryWorksWithDatabase() {

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
        return categoryWorksWithDatabase;

    }

    //  Phương thứct trả về CategoryWorksWithDatabas
    public synchronized void releaseCategoryWorksWithDatabase(CategoryWorksWithDatabase categoryWorksWithDatabase) {

        //  Kiểm tra mail nhận vào có đúng là CategoryWorksWithDatabas cửa lớp này hay không
        if (this.categoryWorksWithDatabase == categoryWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }
    }


}
