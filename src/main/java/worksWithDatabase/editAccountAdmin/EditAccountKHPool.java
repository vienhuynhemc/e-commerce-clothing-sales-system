package worksWithDatabase.editAccountAdmin;

public class EditAccountKHPool {
    private EditAccountKHDAO editAccountDAO;
    private boolean isActive;

    public EditAccountKHPool(){
        editAccountDAO = new EditAccountKHDAO();
        isActive = false;
    }
    public synchronized EditAccountKHDAO getAccount(){

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
    public synchronized void releaseEditAccount(EditAccountKHDAO aa){
        if (this.editAccountDAO == aa){
            isActive = false;
            notifyAll();
        }

    }

}
