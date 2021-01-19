package beans.informationAccountAdmin;

import beans.ObjectPageAdmin;

public class InformationAccountAdminObject implements ObjectPageAdmin {


    private boolean ready;




    public InformationAccountAdminObject(){
    }


    @Override
    public boolean isReady() {
        return ready;
    }

    @Override
    public void setReady(boolean ready) {
        this.ready =ready;
    }
}
