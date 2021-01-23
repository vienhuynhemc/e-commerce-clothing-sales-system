package beans.productAdmin;

import java.util.ArrayList;
import java.util.List;

public class ProductAdminColor {

    private List<ProductAdminSize> danh_sach_size;

    private String ma_mau;

    private String ten_mau;

    private String hinh_anh_mau;

    private int hinH_anh_trong_firebase;

    private List<String> link_hinh_anh;

    public ProductAdminColor() {
        link_hinh_anh = new ArrayList<String>();
        danh_sach_size = new ArrayList<ProductAdminSize>();
    }

    public String toString() {
        String s = "[ ma_mau: " + ma_mau + "\n";
        s += "ten_mau: " + ten_mau + "\n";
        s += "hinh_anh_mau: " + hinh_anh_mau + "\n";
        s += "hinh_anh_trong_firebase: " + hinH_anh_trong_firebase + "\n";
        s += "link_hinh_anh: " + link_hinh_anh + "\n";
        s += danh_sach_size + "\n";
        s += "]";
        return s;
    }

    public List<ProductAdminSize> getDanh_sach_size() {
        return danh_sach_size;
    }

    public void setDanh_sach_size(List<ProductAdminSize> danh_sach_size) {
        this.danh_sach_size = danh_sach_size;
    }

    public String getMa_mau() {
        return ma_mau;
    }

    public void setMa_mau(String ma_mau) {
        this.ma_mau = ma_mau;
    }

    public String getTen_mau() {
        return ten_mau;
    }

    public void setTen_mau(String ten_mau) {
        this.ten_mau = ten_mau;
    }

    public String getHinh_anh_mau() {
        return hinh_anh_mau;
    }

    public void setHinh_anh_mau(String hinh_anh_mau) {
        this.hinh_anh_mau = hinh_anh_mau;
    }

    public int getHinH_anh_trong_firebase() {
        return hinH_anh_trong_firebase;
    }

    public void setHinH_anh_trong_firebase(int hinH_anh_trong_firebase) {
        this.hinH_anh_trong_firebase = hinH_anh_trong_firebase;
    }

    public List<String> getLink_hinh_anh() {
        return link_hinh_anh;
    }

    public void setLink_hinh_anh(List<String> link_hinh_anh) {
        this.link_hinh_anh = link_hinh_anh;
    }
}
