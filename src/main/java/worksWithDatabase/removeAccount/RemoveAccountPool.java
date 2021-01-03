package worksWithDatabase.removeAccount;


public class RemoveAccountPool {

    private RemoveAccountDAO removeAccountDAO;
    private boolean isActive;

    public RemoveAccountPool(){
        removeAccountDAO = new RemoveAccountDAO();
        isActive = false;
    }
    public synchronized RemoveAccountDAO getAccount(){

        while (isActive){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isActive = true;
        return removeAccountDAO;
    }
    public synchronized void releaseRemoveAccount(RemoveAccountDAO aa){
        if (this.removeAccountDAO == aa){
            isActive = false;
            notifyAll();
        }

    }


}
