package worksWithDatabase;

public class CategoryDataSource {

    private static CategoryDataSource c;
    private CategoryPool pool;

    private CategoryDataSource() {
        pool = new CategoryPool();
    }

    public static synchronized CategoryDataSource getInstance() {
        if (c == null) {
            c = new CategoryDataSource();
        }

        return c;
    }

    public CategoryWorksWithDatabase getC() {
        return pool.getCategory();
    }

    public void release(CategoryWorksWithDatabase c) {
        pool.releaseCategory(c);
    }

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                CategoryWorksWithDatabase c = CategoryDataSource.getInstance().getC();
                System.out.println(Thread.currentThread().getName() + " start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                CategoryDataSource.getInstance().release(c);
                System.out.println(Thread.currentThread().getName() + " end");
            }
        };
        Thread t1 = new Thread(r1, "1");
        Thread t2 = new Thread(r1, "2");
        Thread t3 = new Thread(r1, "3");
        Thread t4 = new Thread(r1, "4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }


}


