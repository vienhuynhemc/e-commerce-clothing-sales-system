package worksWithDatabase.cart;

public class ChangeCartPool {
    private ChangeCartDAO cart;
    private boolean isActive;

    public ChangeCartPool(){
        cart = new ChangeCartDAO();
        isActive = false;
    }
    public synchronized ChangeCartDAO getAccount(){

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
    public synchronized void releaseIncreaseCart(ChangeCartDAO aa){
        if (this.cart == aa){
            isActive = false;
            notifyAll();
        }

    }
}
