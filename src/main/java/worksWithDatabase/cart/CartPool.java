package worksWithDatabase.cart;


public class CartPool {
    private CartDAO cart;
    private boolean isActive;

    public CartPool(){
        cart = new CartDAO();
        isActive = false;
    }
    public synchronized CartDAO getAccount(){

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
    public synchronized void releaseAddAccount(CartDAO aa){
        if (this.cart == aa){
            isActive = false;
            notifyAll();
        }

    }
}
