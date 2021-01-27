package beans.wishlist;

import beans.DateTime;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Wishlist implements Serializable {
    private String ma_sp;
    private String ma_kh;
    private String ma_mau;
    private String ma_size;
    private String hinh_sp;
    private String ten_sp;
    private String size;
    private String mau_sp;
    private int so_luong;
    private double gia;
    private double gia_km;
    private DateTime ngay_them;
    private int trang_thai;

    public Wishlist() {
    }

    public Wishlist(String ma_sp, String ma_kh, String ma_mau, String ma_size, String hinh_sp, String ten_sp, String size, String mau_sp, int so_luong, double gia, double gia_km, DateTime ngay_them) {
        this.ma_sp = ma_sp;
        this.ma_kh = ma_kh;
        this.ma_mau = ma_mau;
        this.ma_size = ma_size;
        this.hinh_sp = hinh_sp;
        this.ten_sp = ten_sp;
        this.size = size;
        this.mau_sp = mau_sp;
        this.so_luong = so_luong;
        this.gia = gia;
        this.gia_km = gia_km;
        this.ngay_them = ngay_them;
    }

    public int getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(int trang_thai) {
        this.trang_thai = trang_thai;
    }

    public double getGia_km() {
        return gia_km;
    }

    public void setGia_km(double gia_km) {
        this.gia_km = gia_km;
    }

    public String getMa_size() {
        return ma_size;
    }

    public void setMa_size(String ma_size) {
        this.ma_size = ma_size;
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

    public String getMa_sp() {
        return ma_sp;
    }

    public void setMa_sp(String ma_sp) {
        this.ma_sp = ma_sp;
    }

    public String getMa_kh() {
        return ma_kh;
    }

    public void setMa_kh(String ma_kh) {
        this.ma_kh = ma_kh;
    }

    public String getMa_mau() {
        return ma_mau;
    }

    public void setMa_mau(String ma_mau) {
        this.ma_mau = ma_mau;
    }

    public DateTime getNgay_them() {
        return ngay_them;
    }

    public void setNgay_them(DateTime ngay_them) {
        this.ngay_them = ngay_them;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "ma_sp='" + ma_sp + '\'' +
                ", ma_kh='" + ma_kh + '\'' +
                ", ma_mau='" + ma_mau + '\'' +
                ", ma_size='" + ma_size + '\'' +
                ", hinh_sp='" + hinh_sp + '\'' +
                ", ten_sp='" + ten_sp + '\'' +
                ", size='" + size + '\'' +
                ", mau_sp='" + mau_sp + '\'' +
                ", so_luong=" + so_luong +
                ", gia=" + gia +
                ", gia_km=" + gia_km +
                ", ngay_them=" + ngay_them +
                ", trang_thai=" + trang_thai +
                '}';
    }
}
