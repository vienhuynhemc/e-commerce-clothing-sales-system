package worksWithDatabase.loginUser;


public class LoginPool {

    private LoginUserDAO loginUserDAO;
    private boolean isActive;

    public LoginPool(){
        loginUserDAO = new LoginUserDAO();
        isActive = false;
    }
    public synchronized LoginUserDAO getAccount(){

        while (isActive){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isActive = true;
        return loginUserDAO;
    }
    public synchronized void releaseLoginAccount(LoginUserDAO aa){
        if (this.loginUserDAO == aa){
            isActive = false;
            notifyAll();
        }
}}
