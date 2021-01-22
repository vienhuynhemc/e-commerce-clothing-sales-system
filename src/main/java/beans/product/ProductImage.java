package beans.product;

public class ProductImage {
    private String ma_sp;
    private String ma_mau;
    private String link_hinh;
    private int mac_dinh;

    public ProductImage(String ma_sp, String ma_mau, String link_hinh, int mac_dinh) {
        this.ma_sp = ma_sp;
        this.ma_mau = ma_mau;
        this.link_hinh = link_hinh;
        this.mac_dinh = mac_dinh;
    }

    public ProductImage() {
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

    public int getMac_dinh() {
        return mac_dinh;
    }

    public void setMac_dinh(int mac_dinh) {
        this.mac_dinh = mac_dinh;
    }

    public String getLink_hinh() {
        return link_hinh;
    }

    public void setLink_hinh(String link_hinh) {
        this.link_hinh = link_hinh;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "ma_sp='" + ma_sp + '\'' +
                ", ma_mau='" + ma_mau + '\'' +
                ", link_hinh='" + link_hinh + '\'' +
                ", mac_dinh=" + mac_dinh +
                '}' + "\n";
    }
}
