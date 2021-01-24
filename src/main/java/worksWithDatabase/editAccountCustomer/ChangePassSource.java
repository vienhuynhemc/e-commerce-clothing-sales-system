package worksWithDatabase.editAccountCustomer;

public class ChangePassSource {

    private static ChangePassSource accountSource;
    private static ChangePassPool accountPool;

    private ChangePassSource(){
        accountPool = new ChangePassPool();
    }
    public static synchronized ChangePassSource getInstance(){
        if (accountSource == null){
            accountSource = new ChangePassSource();
        }
        return accountSource;
    }

    public ChangePassWordDAO getEditAccount(){
        return accountPool.getAccount();
    }
    public void releaseEditAccount(ChangePassWordDAO addAccountDAO){
        accountPool.releaseEditAccount(addAccountDAO);
    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                ChangePassWordDAO a = ChangePassSource.getInstance().getEditAccount();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                ChangePassSource.getInstance().releaseEditAccount(a);
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
