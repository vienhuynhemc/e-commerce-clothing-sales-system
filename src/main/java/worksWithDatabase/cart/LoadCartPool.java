package worksWithDatabase.cart;


public class LoadCartPool {
    private LoadCartDAO cart;
    private boolean isActive;

    public LoadCartPool(){
        cart = new LoadCartDAO();
        isActive = false;
    }
    public synchronized LoadCartDAO getAccount(){

        while (isActive){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isActive = true;
        return cart;
    }
    public synchronized void releaseAddAccount(LoadCartDAO aa){
        if (this.cart == aa){
            isActive = false;
            notifyAll();
        }

    }
}
