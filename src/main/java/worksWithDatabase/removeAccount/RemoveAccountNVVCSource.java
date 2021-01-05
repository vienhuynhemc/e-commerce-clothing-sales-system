package worksWithDatabase.removeAccount;

public class RemoveAccountNVVCSource {
    private static RemoveAccountNVVCSource addAccountSource;
    private static RemoveAccountNVVCPool accountPool;

    private RemoveAccountNVVCSource(){
        accountPool = new RemoveAccountNVVCPool();
    }
    public static synchronized RemoveAccountNVVCSource getInstance(){
        if (addAccountSource == null){
            addAccountSource = new RemoveAccountNVVCSource();
        }
        return addAccountSource;
    }

    public RemoveAccountNVVCDAO getRemoveAccount(){
        return accountPool.getAccount();
    }
    public void releaseAddAccount (RemoveAccountNVVCDAO addAccountNVKDAO){
        accountPool.releaseRemoveAccount(addAccountNVKDAO);
    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                RemoveAccountNVVCDAO a = RemoveAccountNVVCSource.getInstance().getRemoveAccount();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                RemoveAccountNVVCSource.getInstance().releaseAddAccount(a);
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
