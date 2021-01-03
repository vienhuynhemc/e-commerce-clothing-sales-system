package worksWithDatabase.removeAccount;


public class RemoveAccountNVKPool {

    private RemoveAccountNVKDAO removeAccountDAO;
    private boolean isActive;

    public RemoveAccountNVKPool(){
        removeAccountDAO = new RemoveAccountNVKDAO();
        isActive = false;
    }
    public synchronized RemoveAccountNVKDAO getAccount(){

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
    public synchronized void releaseRemoveAccount(RemoveAccountNVKDAO aa){
        if (this.removeAccountDAO == aa){
            isActive = false;
            notifyAll();
        }

    }


}
