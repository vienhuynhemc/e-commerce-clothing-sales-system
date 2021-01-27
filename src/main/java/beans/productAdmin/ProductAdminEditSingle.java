package beans.productAdmin;

import java.util.ArrayList;
import java.util.List;

public class ProductAdminEditSingle {

    private String ma_mau;
    private String ten_mau;
    private String ma_sp;
    private int hinh_anh_trong_firebase;
    private List<String> list_hinh_anh_sp;
    private List<ProductAdminSizeAdd> list_size;
    private List<ProductAdminSizeAdd> list_size_do_du_lieu;

    public ProductAdminEditSingle(){
        list_size = new ArrayList<ProductAdminSizeAdd>();
        list_hinh_anh_sp = new ArrayList<String>();
    }

    public String getMa_mau() {
        return ma_mau;
    }

    public void setMa_mau(String ma_mau) {
        this.ma_mau = ma_mau;
    }

    public String getMa_sp() {
        return ma_sp;
    }

    public void setMa_sp(String ma_sp) {
        this.ma_sp = ma_sp;
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

    public List<ProductAdminSizeAdd> getList_size() {
        return list_size;
    }

    public void setList_size(List<ProductAdminSizeAdd> list_size) {
        this.list_size = list_size;
    }

    public String getTen_mau() {
        return ten_mau;
    }

    public void setTen_mau(String ten_mau) {
        this.ten_mau = ten_mau;
    }

    public List<ProductAdminSizeAdd> getList_size_do_du_lieu() {
        return list_size_do_du_lieu;
    }

    public void setList_size_do_du_lieu(List<ProductAdminSizeAdd> list_size_do_du_lieu) {
        this.list_size_do_du_lieu = list_size_do_du_lieu;
    }
}
