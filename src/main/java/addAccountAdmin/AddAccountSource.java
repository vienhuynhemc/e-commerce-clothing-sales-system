package addAccountAdmin;

public class AddAccountSource {
    private static AddAccountSource addAccountSource;
    private static AccountPool accountPool;

    private AddAccountSource(){
        accountPool = new AccountPool();
    }
    public static synchronized AddAccountSource getInstance(){
        if (addAccountSource == null){
            addAccountSource = new AddAccountSource();
        }
        return addAccountSource;
    }

    public AddAccountDAO getAddAccount(){
        return accountPool.getAccount();
    }
    public void releaseAddAccount (AddAccountDAO addAccountDAO){
        accountPool.releaseAddAccount(addAccountDAO);
    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                AddAccountDAO a = AddAccountSource.getInstance().getAddAccount();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                AddAccountSource.getInstance().releaseAddAccount(a);
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
