package beans.informationAccountAdmin;

import beans.ObjectPageAdmin;

public class InformationAccountAdminObject implements ObjectPageAdmin {


    private boolean ready;

    //  Số đơn hàng đã duyệt
    private int orderApproval;

    //  Số lần nhập hàng
    private int numberOfImportProduct;

    //  Số hàng đã nhập
    private int sumImportProduct;

    public InformationAccountAdminObject() {
    }

    // GETTER AND SETTER
    public int getOrderApproval() {
        return orderApproval;
    }

    public void setOrderApproval(int orderApproval) {
        this.orderApproval = orderApproval;
    }

    public int getNumberOfImportProduct() {
        return numberOfImportProduct;
    }

    public void setNumberOfImportProduct(int numberOfImportProduct) {
        this.numberOfImportProduct = numberOfImportProduct;
    }

    public int getSumImportProduct() {
        return sumImportProduct;
    }

    public void setSumImportProduct(int sumImportProduct) {
        this.sumImportProduct = sumImportProduct;
    }

    @Override
    public boolean isReady() {
        return ready;
    }

    @Override
    public void setReady(boolean ready) {
        this.ready = ready;
    }

}
