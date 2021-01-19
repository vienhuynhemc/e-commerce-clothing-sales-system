package beans.product;

import beans.DateTime;

public class Category {
    private String ma_dm;
    private String ten_dm;
    private DateTime ngaytao;
    private int ton_tai;

    public Category(String ma_dm, String ten_dm, DateTime ngaytao, int ton_tai) {
        this.ma_dm = ma_dm;
        this.ten_dm = ten_dm;
        this.ngaytao = ngaytao;
        this.ton_tai = ton_tai;
    }

    public Category() {
    }

    public String getMa_dm() {
        return ma_dm;
    }

    public void setMa_dm(String ma_dm) {
        this.ma_dm = ma_dm;
    }

    public String getTen_dm() {
        return ten_dm;
    }

    public void setTen_dm(String ten_dm) {
        this.ten_dm = ten_dm;
    }

    public DateTime getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(DateTime ngaytao) {
        this.ngaytao = ngaytao;
    }

    public int getTon_tai() {
        return ton_tai;
    }

    public void setTon_tai(int ton_tai) {
        this.ton_tai = ton_tai;
    }

    @Override
    public String toString() {
        return "Category{" +
                "ma_dm='" + ma_dm + '\'' +
                ", ten_dm='" + ten_dm + '\'' +
                ", ngaytao=" + ngaytao +
                ", ton_tai=" + ton_tai +
                '}' + "\n";
    }
}
