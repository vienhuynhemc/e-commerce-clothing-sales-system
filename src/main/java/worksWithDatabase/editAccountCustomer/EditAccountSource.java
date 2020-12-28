package worksWithDatabase.editAccountCustomer;

public class EditAccountSource {

    private static EditAccountSource addAccountSource;
    private static EditAccountPool accountPool;

    private EditAccountSource(){
        accountPool = new EditAccountPool();
    }
    public static synchronized EditAccountSource getInstance(){
        if (addAccountSource == null){
            addAccountSource = new EditAccountSource();
        }
        return addAccountSource;
    }

    public EditAccountDAO getEditAccount(){
        return accountPool.getAccount();
    }
    public void releaseEditAccount(EditAccountDAO addAccountDAO){
        accountPool.releaseEditAccount(addAccountDAO);
    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                EditAccountDAO a = EditAccountSource.getInstance().getEditAccount();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                EditAccountSource.getInstance().releaseEditAccount(a);
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
