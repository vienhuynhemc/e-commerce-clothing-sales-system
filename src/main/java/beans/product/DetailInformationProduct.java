package beans.product;

public class DetailInformationProduct {
    private String ma_sp;
    private String ma_mau;
    private String ma_size;
    private int so_luong_con_lai;
    private int ton_tai;

    public DetailInformationProduct(String ma_sp, String ma_mau, String ma_size, int so_luong_con_lai, int ton_tai) {
        this.ma_sp = ma_sp;
        this.ma_mau = ma_mau;
        this.ma_size = ma_size;
        this.so_luong_con_lai = so_luong_con_lai;
        this.ton_tai = ton_tai;
    }

    public DetailInformationProduct() {
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
}
