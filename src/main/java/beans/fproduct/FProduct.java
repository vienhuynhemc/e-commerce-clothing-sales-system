package beans.fproduct;

import beans.DateTime;

public class FProduct {
    private String id;
    private String name;
    private String idManufacturer;
    private String idCategory;
    private DateTime dateCreated;
    private int sex;
    private int status;
    private int numberSale;
    private int exist;

    public FProduct(String id, String name, String idManufacturer, String idCategory,
                    DateTime dateCreated, int sex, int status, int numberSale, int exist) {
        this.id = id;
        this.name = name;
        this.idManufacturer = idManufacturer;
        this.idCategory = idCategory;
        this.dateCreated = dateCreated;
        this.sex = sex;
        this.status = status;
        this.numberSale = numberSale;
        this.exist = exist;
    }
    public FProduct(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(String idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNumberSale() {
        return numberSale;
    }

    public void setNumberSale(int numberSale) {
        this.numberSale = numberSale;
    }

    public int getExist() {
        return exist;
    }

    public void setExist(int exist) {
        this.exist = exist;
    }

    @Override
    public String toString() {
        return "FProduct{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", idManufacturer='" + idManufacturer + '\'' +
                ", idCategory='" + idCategory + '\'' +
                ", dateCreated=" + dateCreated +
                ", sex=" + sex +
                ", status=" + status +
                ", numberSale=" + numberSale +
                ", exist=" + exist +
                '}';
    }
}
