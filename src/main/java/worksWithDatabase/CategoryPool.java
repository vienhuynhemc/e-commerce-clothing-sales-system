package worksWithDatabase;

public class CategoryPool {

    private CategoryWorksWithDatabase c;
    private boolean isActive;

    public CategoryPool() {
        c = new CategoryWorksWithDatabase();
        isActive = false;
    }

    public synchronized CategoryWorksWithDatabase getCategory() {

        while (isActive) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        isActive = true;
        return c;
    }

    public synchronized void releaseCategory(CategoryWorksWithDatabase c) {
        if (c == this.c) {
            isActive = false;
            notifyAll();
        }
    }


}
