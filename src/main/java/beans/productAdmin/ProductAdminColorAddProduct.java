package beans.productAdmin;

import java.util.List;

public class ProductAdminColorAddProduct {

    private String ma_mau;
    private String ten_mau;
    private String link_hinh_anh;
    private int hinh_anh_trong_firebase;
    private List<String> list_hinh_anh_sp;

    public ProductAdminColorAddProduct(){
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

    public String getLink_hinh_anh() {
        return link_hinh_anh;
    }

    public void setLink_hinh_anh(String link_hinh_anh) {
        this.link_hinh_anh = link_hinh_anh;
    }

    public int getHinh_anh_trong_firebase() {
        return hinh_anh_trong_firebase;
    }

    public void setHinh_anh_trong_firebase(int hinh_anh_trong_firebase) {
        this.hinh_anh_trong_firebase = hinh_anh_trong_firebase;
    }

    public List<String> getList_hinh_anh_sp() {
        return list_hinh_anh_sp;
    }

    public void setList_hinh_anh_sp(List<String> list_hinh_anh_sp) {
        this.list_hinh_anh_sp = list_hinh_anh_sp;
    }

}
