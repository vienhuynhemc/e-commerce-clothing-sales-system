package beans.order;

public class DetailOrder {

    private String ma_don_hang;

    private String ma_san_pham;

    private String ma_mau;

    private String ma_size;

    private int so_luong_san_pham;

    public DetailOrder(String ma_don_hang, String ma_san_pham, String ma_mau, String ma_size, int so_luong_san_pham) {
        this.ma_don_hang = ma_don_hang;
        this.ma_san_pham = ma_san_pham;
        this.ma_mau = ma_mau;
        this.ma_size = ma_size;
        this.so_luong_san_pham = so_luong_san_pham;
    }

    public String getMa_don_hang() {
        return ma_don_hang;
    }

    public void setMa_don_hang(String ma_don_hang) {
        this.ma_don_hang = ma_don_hang;
    }

    public String getMa_san_pham() {
        return ma_san_pham;
    }

    public void setMa_san_pham(String ma_san_pham) {
        this.ma_san_pham = ma_san_pham;
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

    public int getSo_luong_san_pham() {
        return so_luong_san_pham;
    }

    public void setSo_luong_san_pham(int so_luong_san_pham) {
        this.so_luong_san_pham = so_luong_san_pham;
    }

    @Override
    public String toString() {
        return "DetailOrder{" +
                "ma_don_hang='" + ma_don_hang + '\'' +
                ", ma_san_pham='" + ma_san_pham + '\'' +
                ", ma_mau='" + ma_mau + '\'' +
                ", ma_size='" + ma_size + '\'' +
                ", so_luong_san_pham=" + so_luong_san_pham +
                '}' + "\n";
    }
}
