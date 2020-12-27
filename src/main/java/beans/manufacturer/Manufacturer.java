package beans.manufacturer;

import beans.DateTime;

import java.util.List;

public class Manufacturer {

    //  Mã hãng sản xuất
    private String manufacturerId;

    //  Tên hãng sản xuất
    private String manufacturerName;

    //  Ngào tạo
    private DateTime dateCreated;

    //  Tồn tại
    private int exists;

    //  List thông tin chi tiết
    private List<String> informationList;

    //  Số lượng sản phẩm
    private int numberOfProduct;

    //  Constructor
    public Manufacturer(String manufacturerId, String manufacturerName, DateTime dateCreated, int exists, List<String> informationList, int numberOfProduct) {
        this.manufacturerId = manufacturerId;
        this.manufacturerName = manufacturerName;
        this.dateCreated = dateCreated;
        this.exists = exists;
        this.informationList = informationList;
        this.numberOfProduct = numberOfProduct;
    }

    //  Getter and setter
    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getExists() {
        return exists;
    }

    public void setExists(int exists) {
        this.exists = exists;
    }

    public List<String> getInformationList() {
        return informationList;
    }

    public void setInformationList(List<String> informationList) {
        this.informationList = informationList;
    }

    public int getNumberOfProduct() {
        return numberOfProduct;
    }

    public void setNumberOfProduct(int numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }

}
