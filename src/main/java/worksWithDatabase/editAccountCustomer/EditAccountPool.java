package worksWithDatabase.editAccountCustomer;


public class EditAccountPool {

    private EditAccountDAO editAccountDAO;
    private boolean isActive;

    public EditAccountPool(){
        editAccountDAO = new EditAccountDAO();
        isActive = false;
    }
    public synchronized EditAccountDAO getAccount(){

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
    public synchronized void releaseEditAccount(EditAccountDAO aa){
        if (this.editAccountDAO == aa){
            isActive = false;
            notifyAll();
        }

    }

}
