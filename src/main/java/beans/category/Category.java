package beans.category;

import beans.DateTime;

public class Category {

    //  Mã danh mục
    private String id;

    //  Tên danh mục
    private String name;

    //  Ngày giờ tạo danh mục
    private DateTime dateCreated;

    //  Trạng thái hiệu lục
    private boolean exist;

    //  Constructor
    public Category(String id, String name, DateTime dateCreated, boolean exíst) {
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
        this.exist = exíst;
    }

    //  To Sting
    public String toString() {
        return id + " " + name + " " + dateCreated + " " + exist;
    }

    //  Getter and setter
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

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

}
