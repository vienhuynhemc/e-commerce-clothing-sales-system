package beans.product;

import java.util.ArrayList;

public class ProductDetailInformation {
    private String ma_sp;
    private String ma_mau;
    private String ma_size;
    private int so_luong_con_lai;
    private int ton_tai;
    private String ten_size;
    private ArrayList<String> listIMG;

    public ProductDetailInformation(){

    }

    public ProductDetailInformation(String ma_sp, String ma_mau, String ma_size, int so_luong_con_lai, int ton_tai, String ten_size, ArrayList<String> listIMG) {
        this.ma_sp = ma_sp;
        this.ma_mau = ma_mau;
        this.ma_size = ma_size;
        this.so_luong_con_lai = so_luong_con_lai;
        this.ton_tai = ton_tai;
        this.ten_size = ten_size;
        this.listIMG = listIMG;
    }

    public String getMa_sp() {
        return ma_sp;
    }

    public void setMa_sp(String ma_sp) {
        this.ma_sp = ma_sp;
    }

    public String getMa_mau() {
        return ma_mau;
    }

    public void setMa_mau(String ma_mau) {
        this.ma_mau = ma_mau;
    }

    public String getMa_size() {
        return ma_size;
    }

    public void setMa_size(String ma_size) {
        this.ma_size = ma_size;
    }

    public int getSo_luong_con_lai() {
        return so_luong_con_lai;
    }

    public void setSo_luong_con_lai(int so_luong_con_lai) {
        this.so_luong_con_lai = so_luong_con_lai;
    }

    public int getTon_tai() {
        return ton_tai;
    }

    public void setTon_tai(int ton_tai) {
        this.ton_tai = ton_tai;
    }

    public String getTen_size() {
        return ten_size;
    }

    public void setTen_size(String ten_size) {
        this.ten_size = ten_size;
    }

    public ArrayList<String> getListIMG() {
        return listIMG;
    }

    public void setListIMG(ArrayList<String> listIMG) {
        this.listIMG = listIMG;
    }

    @Override
    public String toString() {
        return "ProductDetailInformation{" +
                "ma_sp='" + ma_sp + '\'' +
                ", ma_mau='" + ma_mau + '\'' +
                ", ma_size='" + ma_size + '\'' +
                ", so_luong_con_lai=" + so_luong_con_lai +
                ", ton_tai=" + ton_tai +
                ", ten_size='" + ten_size + '\'' +
                ", listIMG=" + listIMG +
                '}';
    }
}
