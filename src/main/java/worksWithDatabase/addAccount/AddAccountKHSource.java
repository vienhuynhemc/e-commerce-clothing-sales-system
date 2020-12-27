package worksWithDatabase.addAccount;

public class AddAccountKHSource {
    private static AddAccountKHSource addAccountSource;
    private static AddAccountKHPool accountPool;

    private AddAccountKHSource(){
        accountPool = new AddAccountKHPool();
    }
    public static synchronized AddAccountKHSource getInstance(){
        if (addAccountSource == null){
            addAccountSource = new AddAccountKHSource();
        }
        return addAccountSource;
    }

    public AddAccountKHDAO getAddAccount(){
        return accountPool.getAccount();
    }
    public void releaseAddAccount (AddAccountKHDAO addAccountKHDAO){
        accountPool.releaseAddAccount(addAccountKHDAO);
    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                AddAccountKHDAO a = AddAccountKHSource.getInstance().getAddAccount();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                AddAccountKHSource.getInstance().releaseAddAccount(a);
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
