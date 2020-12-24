package worksWithDatabase;

public class CategoryDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy CategoryWorksWithDatabase
     *      2. Trả CategoryWorksWithDatabase
     */

    //  Khai báo instance
    private static CategoryDataSource categoryDataSource;

    //  Khai báo categoryPool
    private CategoryPool categoryPool;

    //  Constructor thì khởi tạo categoryPool
    private CategoryDataSource() {
        categoryPool = new CategoryPool();
    }

    //  Trả về thể hiện của categorydatasource
    public static synchronized CategoryDataSource getInstance() {

        //  Kiểm tra thử categorydatasource có null?
        if (categoryDataSource == null) {

            //  null thì khởi tạo nó
            categoryDataSource = new CategoryDataSource();

        }

        //  return về instance
        return categoryDataSource;

    }

    //  Phương thúc lấy CategoryWorksWithDatabase
    public CategoryWorksWithDatabase getCategoryWorksWithDatabase() {

        //  Lấy CategoryWorksWithDatabase từ categoryPool
        return categoryPool.getCategoryWorksWithDatabase();

    }

    //  Phương thức trả CategoryWorksWithDatabase cho categoryPool
    public void releaseCategoryWorksWithDatabase(CategoryWorksWithDatabase categoryWorksWithDatabase) {

        //  Trả EmailWorksWithDatabase về cho mailPool
        categoryPool.releaseCategoryWorksWithDatabase(categoryWorksWithDatabase);

    }


}


