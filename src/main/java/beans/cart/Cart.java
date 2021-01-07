package beans.cart;

import java.io.Serializable;

public class Cart implements Serializable {

    private String hinh_sp;
    private String ten_sp;
    private String size;
    private String mau_sp;
    private int so_luong;
    private double gia;

    public Cart() {
    }

    public Cart(String hinh_sp, String ten_sp, String size, String mau_sp, int so_luong, double gia) {
        this.hinh_sp = hinh_sp;
        this.ten_sp = ten_sp;
        this.size = size;
        this.mau_sp = mau_sp;
        this.so_luong = so_luong;
        this.gia = gia;
    }

    public String getHinh_sp() {
        return hinh_sp;
    }

    public void setHinh_sp(String hinh_sp) {
        this.hinh_sp = hinh_sp;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMau_sp() {
        return mau_sp;
    }

    public void setMau_sp(String mau_sp) {
        this.mau_sp = mau_sp;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "hinh_sp='" + hinh_sp + '\'' +
                ", ten_sp='" + ten_sp + '\'' +
                ", size='" + size + '\'' +
                ", mau_sp='" + mau_sp + '\'' +
                ", so_luong=" + so_luong +
                ", gia=" + gia +
                '}' + "\n";
    }
}
