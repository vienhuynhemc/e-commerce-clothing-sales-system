package worksWithDatabase.category;

import worksWithDatabase.addAccount.AddAccountKHDAO;
import worksWithDatabase.addAccount.AddAccountKHSource;

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
    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                CategoryWorksWithDatabase a = CategoryDataSource.getInstance().getCategoryWorksWithDatabase();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    System.out.println(a.check("dm_102"));
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(a);
                System.out.println(Thread.currentThread().getName() + "end");
            }
        };

        Thread t1 = new Thread(r1,"1");

        Thread t2 = new Thread(r1,"2");

        Thread t3 = new Thread(r1,"3");

        Thread t4 = new Thread(r1,"4");
        t4.start();
        t1.start();
        t2.start();
        t3.start();
    }


}


