package worksWithDatabase.promotionalPrice;

public class PromotionalPricePool {

    //---------------------------------Pool ---------------------------------

    private PromotionalPriceWorksWithDatabase promotionalPriceWorksWithDatabase;
    private boolean isActive;

    //-----------------------------------------------------------------------

    //  Constructor thì khởi tạo PromotionalPrice works with database
    public PromotionalPricePool() {

        //  Khởi tạo  PromotionalPrice works with database
        promotionalPriceWorksWithDatabase = new PromotionalPriceWorksWithDatabase();

        //  Đặt trạng thái hoạt động ban đầu là false
        isActive = false;

    }

    //  Lấy thể hiện của lớp, để ở trạng thái synchronized
    public synchronized PromotionalPriceWorksWithDatabase getPromotionalPriceWorksWithDatabase() {

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
        return promotionalPriceWorksWithDatabase;

    }

    //  Phương thứct trả về PromotionalPriceWorksWithDatabase
    public synchronized void releasePromotionalPriceWorksWithDatabase(PromotionalPriceWorksWithDatabase promotionalPriceWorksWithDatabase) {

        //  Kiểm tra PromotionalPriceWorksWithDatabase nhận vào có đúng là PromotionalPriceWorksWithDatabase cửa lớp này hay không
        if (this.promotionalPriceWorksWithDatabase == promotionalPriceWorksWithDatabase) {

            //  Đúng thì cho trạng thái hoạt động thành false
            isActive = false;

            //  Đánh thức các client đang chờ
            notifyAll();

        }

    }
    
}
