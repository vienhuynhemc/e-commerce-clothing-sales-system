package worksWithDatabase.addAccount;

public class AddAccountKHPool {
    private AddAccountKHDAO addAccountKHDAO;
    private boolean isActive;

    public AddAccountKHPool(){
        addAccountKHDAO = new AddAccountKHDAO();
        isActive = false;
    }
    public synchronized AddAccountKHDAO getAccount(){

        while (isActive){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isActive = true;
        return addAccountKHDAO;
    }
    public synchronized void releaseAddAccount(AddAccountKHDAO aa){
        if (this.addAccountKHDAO == aa){
            isActive = false;
            notifyAll();
        }

    }
}
