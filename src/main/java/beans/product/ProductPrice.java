package beans.product;

import beans.DateTime;

public class ProductPrice {
    private String ma_sp;
    private double gia_sp;
    private DateTime ngay_cap_nhat;

    public ProductPrice(String ma_sp, double gia_sp, DateTime ngay_cap_nhat) {
        this.ma_sp = ma_sp;
        this.gia_sp = gia_sp;
        this.ngay_cap_nhat = ngay_cap_nhat;
    }

    public ProductPrice() {
    }

    public String getMa_sp() {
        return ma_sp;
    }

    public void setMa_sp(String ma_sp) {
        this.ma_sp = ma_sp;
    }

    public double getGia_sp() {
        return gia_sp;
    }

    public void setGia_sp(double gia_sp) {
        this.gia_sp = gia_sp;
    }

    public DateTime getNgay_cap_nhat() {
        return ngay_cap_nhat;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "ma_sp='" + ma_sp + '\'' +
                ", gia_sp=" + gia_sp +
                ", ngay_cap_nhat=" + ngay_cap_nhat +
                '}';
    }

    public void setNgay_cap_nhat(DateTime ngay_cap_nhat) {
        this.ngay_cap_nhat = ngay_cap_nhat;
    }
}
