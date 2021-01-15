package worksWithDatabase.cart;

public class AddCartPool {
    private AddCartDAO cart;
    private boolean isActive;

    public AddCartPool(){
        cart = new AddCartDAO();
        isActive = false;
    }
    public synchronized AddCartDAO getAccount(){

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
    public synchronized void releaseAddCart(AddCartDAO aa){
        if (this.cart == aa){
            isActive = false;
            notifyAll();
        }

    }
}
