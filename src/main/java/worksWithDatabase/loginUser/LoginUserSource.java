package worksWithDatabase.loginUser;


public class LoginUserSource {
    private static LoginUserSource addAccountSource;
    private static LoginPool accountPool;

    private LoginUserSource(){
        accountPool = new LoginPool();
    }
    public static synchronized LoginUserSource getInstance(){
        if (addAccountSource == null){
            addAccountSource = new LoginUserSource();
        }
        return addAccountSource;
    }

    public LoginUserDAO getAccount(){
        return accountPool.getAccount();
    }
    public void releaseLoginAccount(LoginUserDAO addAccountKHDAO){
        accountPool.releaseLoginAccount(addAccountKHDAO);
    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                LoginUserDAO a = LoginUserSource.getInstance().getAccount();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                LoginUserSource.getInstance().releaseLoginAccount(a);
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
