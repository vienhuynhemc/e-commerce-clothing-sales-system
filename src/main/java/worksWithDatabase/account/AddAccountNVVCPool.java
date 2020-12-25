package worksWithDatabase.account;

public class AddAccountNVVCPool {

    private AddAccountNVVCDAO addAccountNVVCDAO;
    private boolean isActive;

    public AddAccountNVVCPool(){
        addAccountNVVCDAO = new AddAccountNVVCDAO();
        isActive = false;
    }
    public synchronized AddAccountNVVCDAO getAccount(){

        while (isActive){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isActive = true;
        return addAccountNVVCDAO;
    }
    public synchronized void releaseAddAccount(AddAccountNVVCDAO aa){
        if (this.addAccountNVVCDAO == aa){
            isActive = false;
            notifyAll();
        }

    }

}
