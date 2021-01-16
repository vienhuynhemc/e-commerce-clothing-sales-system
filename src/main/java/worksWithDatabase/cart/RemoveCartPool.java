package worksWithDatabase.cart;

public class RemoveCartPool {
    private RemoveCartDAO cart;
    private boolean isActive;

    public RemoveCartPool(){
        cart = new RemoveCartDAO();
        isActive = false;
    }
    public synchronized RemoveCartDAO getAccount(){

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
    public synchronized void releaseAddCart(RemoveCartDAO aa){
        if (this.cart == aa){
            isActive = false;
            notifyAll();
        }

    }
}
