package worksWithDatabase.account;

public class AccountPool {

    private AddAccountDAO addAccountDAO;
    private boolean isActive;

    public AccountPool(){
         addAccountDAO = new AddAccountDAO();
         isActive = false;
     }
     public synchronized AddAccountDAO getAccount(){

        while (isActive){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isActive = true;
        return  addAccountDAO;
     }
     public synchronized void releaseAddAccount(AddAccountDAO aa){
        if (this.addAccountDAO == aa){
            isActive = false;
            notifyAll();
        }

     }


}
