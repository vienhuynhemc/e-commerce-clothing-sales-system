package worksWithDatabase.removeAccount;

public class RemoveAccountNVVCPool {

    private RemoveAccountNVVCDAO removeAccountDAO;
    private boolean isActive;

    public RemoveAccountNVVCPool(){
        removeAccountDAO = new RemoveAccountNVVCDAO();
        isActive = false;
    }
    public synchronized RemoveAccountNVVCDAO getAccount(){

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
    public synchronized void releaseRemoveAccount(RemoveAccountNVVCDAO aa){
        if (this.removeAccountDAO == aa){
            isActive = false;
            notifyAll();
        }

    }
}
