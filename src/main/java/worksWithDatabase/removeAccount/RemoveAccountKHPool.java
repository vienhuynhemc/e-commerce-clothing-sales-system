package worksWithDatabase.removeAccount;

public class RemoveAccountKHPool {

    private RemoveAccountKHDAO removeAccountDAO;
    private boolean isActive;

    public RemoveAccountKHPool(){
        removeAccountDAO = new RemoveAccountKHDAO();
        isActive = false;
    }
    public synchronized RemoveAccountKHDAO getAccount(){

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
    public synchronized void releaseRemoveAccount(RemoveAccountKHDAO aa){
        if (this.removeAccountDAO == aa){
            isActive = false;
            notifyAll();
        }

    }

}
