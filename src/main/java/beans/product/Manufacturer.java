package beans.product;

import beans.DateTime;

import java.util.ArrayList;

public class Manufacturer {
    private String ma_hsx;
    private String ten_hsx;
    private DateTime ngay_tao;
    private int ton_tai;
    private ArrayList<String> thong_tin;

    public Manufacturer(String ma_hsx, String ten_hsx, DateTime ngay_tao, int ton_tai, ArrayList<String> thong_tin) {
        this.ma_hsx = ma_hsx;
        this.ten_hsx = ten_hsx;
        this.ngay_tao = ngay_tao;
        this.ton_tai = ton_tai;
        this.thong_tin = thong_tin;
    }

    public Manufacturer() {
    }

    public String getMa_hsx() {
        return ma_hsx;
    }

    public void setMa_hsx(String ma_hsx) {
        this.ma_hsx = ma_hsx;
    }

    public String getTen_hsx() {
        return ten_hsx;
    }

    public void setTen_hsx(String ten_hsx) {
        this.ten_hsx = ten_hsx;
    }

    public DateTime getNgay_tao() {
        return ngay_tao;
    }

    public void setNgay_tao(DateTime ngay_tao) {
        this.ngay_tao = ngay_tao;
    }

    public int getTon_tai() {
        return ton_tai;
    }

    public void setTon_tai(int ton_tai) {
        this.ton_tai = ton_tai;
    }

    public ArrayList<String> getThong_tin() {
        return thong_tin;
    }

    public void setThong_tin(ArrayList<String> thong_tin) {
        this.thong_tin = thong_tin;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "ma_hsx='" + ma_hsx + '\'' +
                ", ten_hsx='" + ten_hsx + '\'' +
                ", ngay_tao=" + ngay_tao +
                ", ton_tai=" + ton_tai +
                ", thong_tin=" + thong_tin +
                '}';
    }
}
