package worksWithDatabase.editAccountAdmin;

public class EditAccountKHSource {
    private static EditAccountKHSource editAccountKHSource;
    private static EditAccountKHPool accountPool;

    private EditAccountKHSource(){
        accountPool = new EditAccountKHPool();
    }
    public static synchronized EditAccountKHSource getInstance(){
        if (editAccountKHSource == null){
            editAccountKHSource = new EditAccountKHSource();
        }
        return editAccountKHSource;
    }

    public EditAccountKHDAO getEditAccount(){
        return accountPool.getAccount();
    }
    public void releaseEditAccount(EditAccountKHDAO addAccountDAO){
        accountPool.releaseEditAccount(addAccountDAO);
    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                EditAccountKHDAO a = EditAccountKHSource.getInstance().getEditAccount();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                EditAccountKHSource.getInstance().releaseEditAccount(a);
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
