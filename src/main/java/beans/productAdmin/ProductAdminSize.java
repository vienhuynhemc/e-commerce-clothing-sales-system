package beans.productAdmin;

public class ProductAdminSize {

    private String id;
    private String name;
    private int so_luong_con_lai;

    public ProductAdminSize() {
    }

    public String toString(){
        return id+" - "+name+" - "+so_luong_con_lai;
    }

    public int getSo_luong_con_lai() {
        return so_luong_con_lai;
    }

    public void setSo_luong_con_lai(int so_luong_con_lai) {
        this.so_luong_con_lai = so_luong_con_lai;
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
}
