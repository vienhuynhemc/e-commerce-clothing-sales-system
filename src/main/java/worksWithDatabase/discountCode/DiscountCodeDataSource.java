package worksWithDatabase.discountCode;

public class DiscountCodeDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy DiscountCodeWorksWithDatabase
     *      2. Trả DiscountCodeWorksWithDatabase
     */

    //  Khai báo DiscountCodePool
    private static DiscountCodePool discountCodePool;

    //  Khai báo instance
    private static DiscountCodeDataSource discountCodeDataSource;

    //  Constructor thì khởi tạo discountCodePool
    private DiscountCodeDataSource() {
        discountCodePool = new DiscountCodePool();
    }

    //  Trả về thể hiện của DiscountCodeDataSource
    public static synchronized DiscountCodeDataSource getInstance() {

        //  Kiểm tra thử DiscountCodeDataSource có null?
        if (discountCodeDataSource == null) {

            //  null thì khởi tạo nó
            discountCodeDataSource = new DiscountCodeDataSource();

        }

        //  return về instance
        return discountCodeDataSource;

    }

    //  Phương thúc lấy discountCodeWorksWithDatabase
    public DiscountCodeWorksWithDatabase getDiscountCodeWorksWithDatabase() {

        //  Lấy DiscountCodeWorksWithDatabase từ DiscountCodePool
        return discountCodePool.getDiscountCodeWorksWithDatabase();

    }

    //  Phương thức trả discountCodeWorksWithDatabase cho discountCodePool
    public void releaseDiscountCodeWorksWithDatabase(DiscountCodeWorksWithDatabase discountCodeWorksWithDatabase) {

        //  Trả DiscountCodeWorksWithDatabase về cho DiscountCodePool
        discountCodePool.releaseDiscountCodeWorksWithDatabase(discountCodeWorksWithDatabase);

    }

}
