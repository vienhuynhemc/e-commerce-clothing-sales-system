package beans.product;

import beans.DateTime;

public class ProductPriceSale {
    private String ma_sp;
    private double gia_sp_km;
    private DateTime ngay_cap_nhat;

    public ProductPriceSale(String ma_sp, double gia_sp, DateTime ngay_cap_nhat) {
        this.ma_sp = ma_sp;
        this.gia_sp_km = gia_sp;
        this.ngay_cap_nhat = ngay_cap_nhat;
    }

    public ProductPriceSale() {
    }

    public String getMa_sp() {
        return ma_sp;
    }

    public void setMa_sp(String ma_sp) {
        this.ma_sp = ma_sp;
    }

    public double getGia_sp_km() {
        return gia_sp_km;
    }

    public void setGia_sp_km(double gia_sp_km) {
        this.gia_sp_km = gia_sp_km;
    }

    public DateTime getNgay_cap_nhat() {
        return ngay_cap_nhat;
    }

    public void setNgay_cap_nhat(DateTime ngay_cap_nhat) {
        this.ngay_cap_nhat = ngay_cap_nhat;
    }

    @Override
    public String toString() {
        return "ProductPriceSale{" +
                "ma_sp='" + ma_sp + '\'' +
                ", gia_sp_km=" + gia_sp_km +
                ", ngay_cap_nhat=" + ngay_cap_nhat +
                '}';
    }
}
