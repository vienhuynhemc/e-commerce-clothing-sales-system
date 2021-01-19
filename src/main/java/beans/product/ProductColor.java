package beans.product;

public class ProductColor {
    private String ma_mau;
    private String ten_mau;
    private String hinh_anh_mau;
    private String link_hinh;

    public ProductColor(String ma_mau, String ten_mau, String hinh_anh_mau, String link_hinh) {
        this.ma_mau = ma_mau;
        this.ten_mau = ten_mau;
        this.hinh_anh_mau = hinh_anh_mau;
        this.link_hinh = link_hinh;
    }

    public ProductColor() {
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

    public String getLink_hinh() {
        return link_hinh;
    }

    public void setLink_hinh(String link_hinh) {
        this.link_hinh = link_hinh;
    }

    @Override
    public String toString() {
        return "ProductColor{" +
                "ma_mau='" + ma_mau + '\'' +
                ", ten_mau='" + ten_mau + '\'' +
                ", hinh_anh_mau='" + hinh_anh_mau + '\'' +
                ", link_hinh='" + link_hinh + '\'' +
                '}' +"\n";
    }
}
