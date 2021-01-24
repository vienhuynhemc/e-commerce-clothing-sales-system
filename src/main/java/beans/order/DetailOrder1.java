package beans.order;

public class DetailOrder1 {

    private String ten_dm;
    private String hinh_anh;
    private String ten_sp;
    private String ten_size;
    private String ten_mau;
    private int so_luong_sp;
    private int gia;
    private int giakm;
    private int tong_tien;
    private String ghi_chu;

    public DetailOrder1() {
    }

    public DetailOrder1(String ten_dm, String hinh_anh, String ten_sp, String ten_size, String ten_mau, int so_luong_sp, int gia, int giakm, int tong_tien, String ghi_chu) {
        this.ten_dm = ten_dm;
        this.hinh_anh = hinh_anh;
        this.ten_sp = ten_sp;
        this.ten_size = ten_size;
        this.ten_mau = ten_mau;
        this.so_luong_sp = so_luong_sp;
        this.gia = gia;
        this.giakm = giakm;
        this.tong_tien = tong_tien;
        this.ghi_chu = ghi_chu;
    }

    public String getTen_dm() {
        return ten_dm;
    }

    public void setTen_dm(String ten_dm) {
        this.ten_dm = ten_dm;
    }

    public String getHinh_anh() {
        return hinh_anh;
    }

    public void setHinh_anh(String hinh_anh) {
        this.hinh_anh = hinh_anh;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public String getTen_size() {
        return ten_size;
    }

    public void setTen_size(String ten_size) {
        this.ten_size = ten_size;
    }

    public String getTen_mau() {
        return ten_mau;
    }

    public void setTen_mau(String ten_mau) {
        this.ten_mau = ten_mau;
    }

    public int getSo_luong_sp() {
        return so_luong_sp;
    }

    public void setSo_luong_sp(int so_luong_sp) {
        this.so_luong_sp = so_luong_sp;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getGiakm() {
        return giakm;
    }

    public void setGiakm(int giakm) {
        this.giakm = giakm;
    }

    public int getTong_tien() {
        return tong_tien;
    }

    public void setTong_tien(int tong_tien) {
        this.tong_tien = tong_tien;
    }

    public String getGhi_chu() {
        return ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }

    @Override
    public String toString() {
        return "DetailOrder1{" +
                "ten_dm='" + ten_dm + '\'' +
                ", hinh_anh='" + hinh_anh + '\'' +
                ", ten_sp='" + ten_sp + '\'' +
                ", ten_size='" + ten_size + '\'' +
                ", ten_mau='" + ten_mau + '\'' +
                ", so_luong_sp=" + so_luong_sp +
                ", gia=" + gia +
                ", giakm=" + giakm +
                ", tong_tien=" + tong_tien +
                '}' + "\n";
    }
}
