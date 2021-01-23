package worksWithDatabase.checkout;



public class PayPool {
    private Pay pay;
    private boolean isActive;

    public PayPool(){
        pay = new Pay();
        isActive = false;
    }
    public synchronized Pay getPay(){
        while (isActive){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isActive = true;
        return pay;
    }
    public synchronized void releasePay(Pay aa){
        if (this.pay == aa){
            isActive = false;
            notifyAll();
        }

    }
}
