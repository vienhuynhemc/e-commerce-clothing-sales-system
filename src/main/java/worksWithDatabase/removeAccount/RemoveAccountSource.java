package worksWithDatabase.removeAccount;


public class RemoveAccountSource {
    private static RemoveAccountSource addAccountSource;
    private static RemoveAccountPool accountPool;

    private RemoveAccountSource(){
        accountPool = new RemoveAccountPool();
    }
    public static synchronized RemoveAccountSource getInstance(){
        if (addAccountSource == null){
            addAccountSource = new RemoveAccountSource();
        }
        return addAccountSource;
    }

    public RemoveAccountDAO getAddAccount(){
        return accountPool.getAccount();
    }
    public void releaseAddAccount (RemoveAccountDAO addAccountNVKDAO){
        accountPool.releaseRemoveAccount(addAccountNVKDAO);
    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                RemoveAccountDAO a = RemoveAccountSource.getInstance().getAddAccount();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                RemoveAccountSource.getInstance().releaseAddAccount(a);
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
