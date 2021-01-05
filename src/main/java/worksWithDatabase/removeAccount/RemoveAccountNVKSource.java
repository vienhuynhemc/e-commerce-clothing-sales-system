package worksWithDatabase.removeAccount;


public class RemoveAccountNVKSource {
    private static RemoveAccountNVKSource addAccountSource;
    private static RemoveAccountNVKPool accountPool;

    private RemoveAccountNVKSource(){
        accountPool = new RemoveAccountNVKPool();
    }
    public static synchronized RemoveAccountNVKSource getInstance(){
        if (addAccountSource == null){
            addAccountSource = new RemoveAccountNVKSource();
        }
        return addAccountSource;
    }

    public RemoveAccountNVKDAO getRemoveAccount(){
        return accountPool.getAccount();
    }
    public void releaseAddAccount (RemoveAccountNVKDAO addAccountNVKDAO){
        accountPool.releaseRemoveAccount(addAccountNVKDAO);
    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                RemoveAccountNVKDAO a = RemoveAccountNVKSource.getInstance().getRemoveAccount();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                RemoveAccountNVKSource.getInstance().releaseAddAccount(a);
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
