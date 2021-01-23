package worksWithDatabase.promotionalPrice;


public class PromotionalPriceDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy PromotionalPrice works with data base
     *      2. Trả PromotionalPrice works with data base
     */

    //  Khai báo PromotionalPricepool
    private static PromotionalPricePool promotionalPricePool;

    //  Khai báo instance
    private static PromotionalPriceDataSource promotionalPriceDataSource;

    //  Constructor thì khởi tạo PromotionalPricePool
    private PromotionalPriceDataSource() {
        promotionalPricePool = new PromotionalPricePool();
    }

    //  Trả về thể hiện của PromotionalPriceDataSource
    public static synchronized PromotionalPriceDataSource getInstance() {

        //  Kiểm tra thử PromotionalPriceDataSource có null?
        if (promotionalPriceDataSource == null) {

            //  null thì khởi tạo nó
            promotionalPriceDataSource = new PromotionalPriceDataSource();

        }

        //  return về instance
        return promotionalPriceDataSource;

    }

    //  Phương thúc lấy PromotionalPriceWorksWithDatabase
    public PromotionalPriceWorksWithDatabase getPromotionalPriceWorksWithDatabase() {

        //  Lấy PromotionalPriceWorksWithDatabase từ PromotionalPricePool
        return promotionalPricePool.getPromotionalPriceWorksWithDatabase();

    }

    //  Phương thức trả PromotionalPriceWorksWithDatabase cho PromotionalPricePool
    public void releasePromotionalPriceWorksWithDatabase(PromotionalPriceWorksWithDatabase promotionalPriceWorksWithDatabase) {

        //  Trả PromotionalPriceWorksWithDatabase về cho PromotionalPricePool
        promotionalPricePool.releasePromotionalPriceWorksWithDatabase(promotionalPriceWorksWithDatabase);

    }


}
