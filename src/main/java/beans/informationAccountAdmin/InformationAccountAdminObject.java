package beans.informationAccountAdmin;

import beans.ObjectPageAdmin;
import beans.address.Commune;
import beans.address.District;
import beans.address.Provincial;

import java.util.List;

public class InformationAccountAdminObject implements ObjectPageAdmin {


    private boolean ready;

    //  Số đơn hàng đã duyệt
    private int orderApproval;

    //  Số lần nhập hàng
    private int numberOfImportProduct;

    //  Số hàng đã nhập
    private int sumImportProduct;

    //  List full tinh thành
    private List<Provincial> provincials;

    //  List quận huyện
    private List<District> districts;

    //  List phường xã
    private List<Commune> communes;

    //  boolean kiểm tra đang ở chế độ sửa hay
    private boolean isEdit;

    //  boolean kiểm tra có thông báo hay không
    private boolean isNotify;

    //  Tiêu đề và nội dung thông báo
    private String title;
    private String content;

    //  Tỉnh thành quận huyện hiện tại
    private Provincial provincial;
    private District district;
    private Commune commune;

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


    public List<Provincial> getProvincials() {
        return provincials;
    }

    public void setProvincials(List<Provincial> provincials) {
        this.provincials = provincials;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public List<Commune> getCommunes() {
        return communes;
    }

    public void setCommunes(List<Commune> communes) {
        this.communes = communes;
    }

    public boolean isEdit() {
        return isEdit;
    }

    public void setEdit(boolean edit) {
        isEdit = edit;
    }

    public Provincial getProvincial() {
        return provincial;
    }

    public void setProvincial(Provincial provincial) {
        this.provincial = provincial;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public boolean isNotify() {
        return isNotify;
    }

    public void setNotify(boolean notify) {
        isNotify = notify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
