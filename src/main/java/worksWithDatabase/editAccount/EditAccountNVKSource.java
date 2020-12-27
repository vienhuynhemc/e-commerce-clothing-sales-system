package worksWithDatabase.editAccount;


public class EditAccountNVKSource {
    private static EditAccountNVKSource addAccountSource;
    private static EditAccountNVKPool accountPool;

    private EditAccountNVKSource(){
        accountPool = new EditAccountNVKPool();
    }
    public static synchronized EditAccountNVKSource getInstance(){
        if (addAccountSource == null){
            addAccountSource = new EditAccountNVKSource();
        }
        return addAccountSource;
    }

    public EditAccountNVKDAO getEditAccount(){
        return accountPool.getAccount();
    }
    public void releaseEditAccount(EditAccountNVKDAO addAccountNVKDAO){
        accountPool.releaseEditAccount(addAccountNVKDAO);
    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                EditAccountNVKDAO a = EditAccountNVKSource.getInstance().getEditAccount();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                EditAccountNVKSource.getInstance().releaseEditAccount(a);
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
