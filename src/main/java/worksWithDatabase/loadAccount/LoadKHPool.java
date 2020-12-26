package worksWithDatabase.loadAccount;

public class LoadKHPool {

    private LoadKHDAO loadKHDAO;
    private boolean isActive;

    public LoadKHPool(){
        loadKHDAO = new LoadKHDAO();
        isActive = false;
    }
    public synchronized LoadKHDAO getListKH(){
        while (isActive){

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        isActive = true;
        return loadKHDAO;
    }
    public synchronized void releaseListKH(LoadKHDAO loadKHDAO){
        if (this.loadKHDAO  == loadKHDAO){
            isActive = false;
            notifyAll();
        }
    }
}
