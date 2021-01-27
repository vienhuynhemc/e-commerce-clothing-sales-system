package worksWithDatabase.editAccountCustomer;

public class RemoveAccountPool {


    private RemoveAccountDAO editAccountDAO;
    private boolean isActive;

    public RemoveAccountPool(){
        editAccountDAO = new RemoveAccountDAO();
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
        return editAccountDAO;
    }
    public synchronized void releaseEditAccount(RemoveAccountDAO aa){
        if (this.editAccountDAO == aa){
            isActive = false;
            notifyAll();
        }

    }

}
