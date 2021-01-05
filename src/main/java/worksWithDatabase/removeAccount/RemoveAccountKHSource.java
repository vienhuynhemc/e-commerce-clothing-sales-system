package worksWithDatabase.removeAccount;

public class RemoveAccountKHSource {
    private static RemoveAccountKHSource accountSource;
    private static RemoveAccountKHPool accountPool;

    private RemoveAccountKHSource(){
        accountPool = new RemoveAccountKHPool();
    }
    public static synchronized RemoveAccountKHSource getInstance(){
        if (accountSource == null){
            accountSource = new RemoveAccountKHSource();
        }
        return accountSource;
    }

    public RemoveAccountKHDAO getRemoveAccount(){
        return accountPool.getAccount();
    }
    public void releaseRemoveAccount (RemoveAccountKHDAO accountDAO){
        accountPool.releaseRemoveAccount(accountDAO);
    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                RemoveAccountKHDAO a = RemoveAccountKHSource.getInstance().getRemoveAccount();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                RemoveAccountKHSource.getInstance().releaseRemoveAccount(a);
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
