package beans.productAdmin;

import beans.DateTime;
import beans.jbCrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public class ProductAdmin {

    private String ma_sp;

    private String ten_sp;

    private DateTime ngay_tao;

    private int gioi_tinh;

    private int trang_thai;

    private int so_luong_ban_ra;

    private int ton_tai;

    //  Bảng hãng sản xuất
    private ProductAdminManufacturer hang_san_xuat;

    //  Bảng danh mục
    private ProductAdminCategory danh_muc;

    //  Bảng giá
    private int gia_sp;

    //  Bảng giá khuyến mãi
    private int gia_khuyen_mai;

    //  Bảng giá nhập
    private int gia_nhap;

    //  Bảng thong_tin_sp
    private List<String> thong_tin_sp;

    //  Bảng gioi_thieu_sp
    private List<String> gioi_thieu_sp;

    // Bảng cau_tao_sp;
    private List<String> cau_tao_sp;

    //  Bảng thông tin chi tiết sản phẩm
    private List<ProductAdminColor> danh_sach_mau;

    public ProductAdmin(String ma_sp, String ten_sp, DateTime ngay_tao, int gioi_tinh, int trang_thai, int so_luong_ban_ra, int ton_tai) {
        this.ma_sp = ma_sp;
        this.ten_sp = ten_sp;
        this.ngay_tao = ngay_tao;
        this.gioi_tinh = gioi_tinh;
        this.trang_thai = trang_thai;
        this.so_luong_ban_ra = so_luong_ban_ra;
        this.ton_tai = ton_tai;
    }

    public ProductAdmin() {
        danh_sach_mau = new ArrayList<ProductAdminColor>();
    }

    public String toString() {
        String s = "[ ms_sp: " + ma_sp + "\n";
        s += "ten_sp: " + ten_sp + "\n";
        s += "ngay_tao: " + ngay_tao.toString() + "\n";
        s += "gioi_tinh: " + gioi_tinh + "\n";
        s += "trang_thai: " + trang_thai + "\n";
        s += "so_luong_ban_ra: " + so_luong_ban_ra + "\n";
        s += "ton_tai: " + ton_tai + "\n";
        s += "danh_muc: " + danh_muc.getId() + " - " + danh_muc.getName() + "\n";
        s += "hang_san_xuat: " + hang_san_xuat.getId() + " - " + hang_san_xuat.getName() + "\n";
        s += "gia_sp: " + gia_sp + "\n";
        s += "gia_km: " + gia_khuyen_mai + "\n";
        s += "gia_nhap: " + gia_nhap + "\n";
        s += "thong_tin_sp: " + thong_tin_sp + "\n";
        s += "gioi_thieu_sp: " + gioi_thieu_sp + "\n";
        s += "cau_tao_sp: " + cau_tao_sp + "\n";
        s+="danh_sach_mau: "+danh_sach_mau.size();
        for (ProductAdminColor productAdminColor : danh_sach_mau) {
            s+= productAdminColor.toString() + "\n";
        }
        s += "]";
        return s;
    }

    public String getMa_sp() {
        return ma_sp;
    }

    public void setMa_sp(String ma_sp) {
        this.ma_sp = ma_sp;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public DateTime getNgay_tao() {
        return ngay_tao;
    }

    public void setNgay_tao(DateTime ngay_tao) {
        this.ngay_tao = ngay_tao;
    }

    public int getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(int gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public int getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(int trang_thai) {
        this.trang_thai = trang_thai;
    }

    public int getSo_luong_ban_ra() {
        return so_luong_ban_ra;
    }

    public void setSo_luong_ban_ra(int so_luong_ban_ra) {
        this.so_luong_ban_ra = so_luong_ban_ra;
    }

    public int getTon_tai() {
        return ton_tai;
    }

    public void setTon_tai(int ton_tai) {
        this.ton_tai = ton_tai;
    }

    public ProductAdminManufacturer getHang_san_xuat() {
        return hang_san_xuat;
    }

    public void setHang_san_xuat(ProductAdminManufacturer hang_san_xuat) {
        this.hang_san_xuat = hang_san_xuat;
    }

    public ProductAdminCategory getDanh_muc() {
        return danh_muc;
    }

    public void setDanh_muc(ProductAdminCategory danh_muc) {
        this.danh_muc = danh_muc;
    }

    public int getGia_sp() {
        return gia_sp;
    }

    public void setGia_sp(int gia_sp) {
        this.gia_sp = gia_sp;
    }

    public int getGia_khuyen_mai() {
        return gia_khuyen_mai;
    }

    public void setGia_khuyen_mai(int gia_khuyen_mai) {
        this.gia_khuyen_mai = gia_khuyen_mai;
    }

    public int getGia_nhap() {
        return gia_nhap;
    }

    public void setGia_nhap(int gia_nhap) {
        this.gia_nhap = gia_nhap;
    }

    public List<String> getThong_tin_sp() {
        return thong_tin_sp;
    }

    public void setThong_tin_sp(List<String> thong_tin_sp) {
        this.thong_tin_sp = thong_tin_sp;
    }

    public List<String> getGioi_thieu_sp() {
        return gioi_thieu_sp;
    }

    public void setGioi_thieu_sp(List<String> gioi_thieu_sp) {
        this.gioi_thieu_sp = gioi_thieu_sp;
    }

    public List<String> getCau_tao_sp() {
        return cau_tao_sp;
    }

    public void setCau_tao_sp(List<String> cau_tao_sp) {
        this.cau_tao_sp = cau_tao_sp;
    }

    public List<ProductAdminColor> getDanh_sach_mau() {
        return danh_sach_mau;
    }

    public void setDanh_sach_mau(List<ProductAdminColor> danh_sach_mau) {
        this.danh_sach_mau = danh_sach_mau;
    }

}
