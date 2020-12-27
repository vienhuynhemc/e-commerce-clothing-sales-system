package worksWithDatabase.addAccount;

public class AddAccountNVKSource {
    private static AddAccountNVKSource addAccountSource;
    private static AccountNVKPool accountPool;

    private AddAccountNVKSource(){
        accountPool = new AccountNVKPool();
    }
    public static synchronized AddAccountNVKSource getInstance(){
        if (addAccountSource == null){
            addAccountSource = new AddAccountNVKSource();
        }
        return addAccountSource;
    }

    public AddAccountNVKDAO getAddAccount(){
        return accountPool.getAccount();
    }
    public void releaseAddAccount (AddAccountNVKDAO addAccountNVKDAO){
        accountPool.releaseAddAccount(addAccountNVKDAO);
    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                AddAccountNVKDAO a = AddAccountNVKSource.getInstance().getAddAccount();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                AddAccountNVKSource.getInstance().releaseAddAccount(a);
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
