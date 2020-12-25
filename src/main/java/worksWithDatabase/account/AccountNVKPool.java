package worksWithDatabase.account;

public class AccountNVKPool {

    private AddAccountNVKDAO addAccountNVKDAO;
    private boolean isActive;

    public AccountNVKPool(){
         addAccountNVKDAO = new AddAccountNVKDAO();
         isActive = false;
     }
     public synchronized AddAccountNVKDAO getAccount(){

        while (isActive){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isActive = true;
        return addAccountNVKDAO;
     }
     public synchronized void releaseAddAccount(AddAccountNVKDAO aa){
        if (this.addAccountNVKDAO == aa){
            isActive = false;
            notifyAll();
        }

     }


}
