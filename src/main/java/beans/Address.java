package beans;

public class Address {

    private String tinh;
    private String huyen;
    private String xa;

    public Address(String tinh, String huyen, String xa) {
        this.tinh = tinh;
        this.huyen = huyen;
        this.xa = xa;
    }

    public Address() {
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public String getHuyen() {
        return huyen;
    }

    public void setHuyen(String huyen) {
        this.huyen = huyen;
    }

    public String getXa() {
        return xa;
    }

    public void setXa(String xa) {
        this.xa = xa;
    }
}
