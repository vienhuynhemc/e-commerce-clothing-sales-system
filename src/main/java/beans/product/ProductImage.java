package beans.product;

public class ProductImage {
    private String ma_sp;
    private String ma_mau;
//    private String hinh_anh;
    private String link_hinh;

    public ProductImage(String ma_sp, String ma_mau, String link_hinh) {
        this.ma_sp = ma_sp;
        this.ma_mau = ma_mau;
//        this.hinh_anh = hinh_anh;
        this.link_hinh = link_hinh;
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

//    public String getHinh_anh() {
//        return hinh_anh;
//    }
//
//    public void setHinh_anh(String hinh_anh) {
//        this.hinh_anh = hinh_anh;
//    }

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
//                ", hinh_anh='" + hinh_anh + '\'' +
                ", link_hinh='" + link_hinh + '\'' +
                '}' +"\n";
    }
}
