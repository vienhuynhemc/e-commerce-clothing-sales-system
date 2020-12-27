package worksWithDatabase.editAccount;



public class EditAccountNVKPool {

    private EditAccountNVKDAO editAccountNVKDAO;
    private boolean isActive;

    public EditAccountNVKPool(){
        editAccountNVKDAO = new EditAccountNVKDAO();
        isActive = false;
    }
    public synchronized EditAccountNVKDAO getAccount(){

        while (isActive){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isActive = true;
        return editAccountNVKDAO;
    }
    public synchronized void releaseEditAccount(EditAccountNVKDAO aa){
        if (this.editAccountNVKDAO == aa){
            isActive = false;
            notifyAll();
        }

    }


}
