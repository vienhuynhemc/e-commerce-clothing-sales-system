package worksWithDatabase.addAccount;

public class AddAccountNVVCSource {
    private static AddAccountNVVCSource addAccountSource;
    private static AddAccountNVVCPool accountPool;

    private AddAccountNVVCSource(){
        accountPool = new AddAccountNVVCPool();
    }

    public static synchronized AddAccountNVVCSource getInstance(){
        if (addAccountSource == null){
            addAccountSource = new AddAccountNVVCSource();
        }
        return addAccountSource;
    }

    public AddAccountNVVCDAO getAddAccount(){
        return accountPool.getAccount();
    }

    public void releaseAddAccount (AddAccountNVVCDAO addAccountNVVCDAO){
        accountPool.releaseAddAccount(addAccountNVVCDAO);
    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                AddAccountNVVCDAO a = AddAccountNVVCSource.getInstance().getAddAccount();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                AddAccountNVVCSource.getInstance().releaseAddAccount(a);
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
