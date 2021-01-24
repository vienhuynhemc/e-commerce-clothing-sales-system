package worksWithDatabase.editAccountCustomer;

public class ChangePassPool {

    private ChangePassWordDAO editAccountDAO;
    private boolean isActive;

    public ChangePassPool(){
        editAccountDAO = new ChangePassWordDAO();
        isActive = false;
    }
    public synchronized ChangePassWordDAO getAccount(){

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
    public synchronized void releaseEditAccount(ChangePassWordDAO aa){
        if (this.editAccountDAO == aa){
            isActive = false;
            notifyAll();
        }

    }

}
