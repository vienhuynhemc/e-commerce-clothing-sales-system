package worksWithDatabase.loadAccount;

import worksWithDatabase.account.AddAccountKHDAO;
import worksWithDatabase.account.AddAccountKHSource;

public class LoadKHSource {

    private static LoadKHPool loadKHPool;
    private static LoadKHSource loadKHSource;

    private LoadKHSource(){
        loadKHPool = new LoadKHPool();
    }
    public static synchronized LoadKHSource getInstance(){

        if(loadKHSource == null){
            loadKHSource = new LoadKHSource();
        }
        return loadKHSource;

    }
    public LoadKHDAO getLoadKHDAO(){ return loadKHPool.getListKH(); }
    public void releaseLoadKH(LoadKHDAO loadKHDAO) { loadKHPool.releaseListKH(loadKHDAO); }


    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                LoadKHDAO a = LoadKHSource.getInstance().getLoadKHDAO();
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                LoadKHSource.getInstance().releaseLoadKH(a);
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

