package beans.order;

import beans.DateTime;

public class Order {

    private String ma_don_hang;

    private String ma_khach_hang;

    private DateTime ngay_tao;

    private DateTime ngay_giao_hang;

    private double phi_van_chuyen;

    private DateTime ngay_admin_duyet;

    private DateTime ngay_nvk_duyet;

    private DateTime ngay_nvvc_duyet;

    private String ma_nvk;

    private String ma_nvvc;

    private String ma_admin;

    private String ghi_chu;

    private int trang_thai_van_chuyen;

    private String ma_giam_gia;

    private int trang_thai_thanh_toan;

    private int tong_tien;

    public Order(String ma_don_hang, String ma_khach_hang, DateTime ngay_tao, DateTime ngay_giao_hang, double phi_van_chuyen, DateTime ngay_admin_duyet, DateTime ngay_nvk_duyet, DateTime ngay_nvvc_duyet, String ma_nvk, String ma_nvvc, String ma_admin, String ghi_chu, int trang_thai_van_chuyen, String ma_giam_gia, int trang_thai_thanh_toan, int tong_tien) {
        this.ma_don_hang = ma_don_hang;
        this.ma_khach_hang = ma_khach_hang;
        this.ngay_tao = ngay_tao;
        this.ngay_giao_hang = ngay_giao_hang;
        this.phi_van_chuyen = phi_van_chuyen;
        this.ngay_admin_duyet = ngay_admin_duyet;
        this.ngay_nvk_duyet = ngay_nvk_duyet;
        this.ngay_nvvc_duyet = ngay_nvvc_duyet;
        this.ma_nvk = ma_nvk;
        this.ma_nvvc = ma_nvvc;
        this.ma_admin = ma_admin;
        this.ghi_chu = ghi_chu;
        this.trang_thai_van_chuyen = trang_thai_van_chuyen;
        this.ma_giam_gia = ma_giam_gia;
        this.trang_thai_thanh_toan = trang_thai_thanh_toan;
        this.tong_tien = tong_tien;
    }

    public String getMa_don_hang() {
        return ma_don_hang;
    }

    public void setMa_don_hang(String ma_don_hang) {
        this.ma_don_hang = ma_don_hang;
    }

    public String getMa_khach_hang() {
        return ma_khach_hang;
    }

    public void setMa_khach_hang(String ma_khach_hang) {
        this.ma_khach_hang = ma_khach_hang;
    }

    public DateTime getNgay_tao() {
        return ngay_tao;
    }

    public void setNgay_tao(DateTime ngay_tao) {
        this.ngay_tao = ngay_tao;
    }

    public DateTime getNgay_giao_hang() {
        return ngay_giao_hang;
    }

    public void setNgay_giao_hang(DateTime ngay_giao_hang) {
        this.ngay_giao_hang = ngay_giao_hang;
    }

    public double getPhi_van_chuyen() {
        return phi_van_chuyen;
    }

    public void setPhi_van_chuyen(double phi_van_chuyen) {
        this.phi_van_chuyen = phi_van_chuyen;
    }

    public DateTime getNgay_admin_duyet() {
        return ngay_admin_duyet;
    }

    public void setNgay_admin_duyet(DateTime ngay_admin_duyet) {
        this.ngay_admin_duyet = ngay_admin_duyet;
    }

    public DateTime getNgay_nvk_duyet() {
        return ngay_nvk_duyet;
    }

    public void setNgay_nvk_duyet(DateTime ngay_nvk_duyet) {
        this.ngay_nvk_duyet = ngay_nvk_duyet;
    }

    public DateTime getNgay_nvvc_duyet() {
        return ngay_nvvc_duyet;
    }

    public void setNgay_nvvc_duyet(DateTime ngay_nvvc_duyet) {
        this.ngay_nvvc_duyet = ngay_nvvc_duyet;
    }

    public String getMa_nvk() {
        return ma_nvk;
    }

    public void setMa_nvk(String ma_nvk) {
        this.ma_nvk = ma_nvk;
    }

    public String getMa_nvvc() {
        return ma_nvvc;
    }

    public void setMa_nvvc(String ma_nvvc) {
        this.ma_nvvc = ma_nvvc;
    }

    public String getMa_admin() {
        return ma_admin;
    }

    public void setMa_admin(String ma_admin) {
        this.ma_admin = ma_admin;
    }

    public String getGhi_chu() {
        return ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }

    public int getTrang_thai_van_chuyen() {
        return trang_thai_van_chuyen;
    }

    public void setTrang_thai_van_chuyen(int trang_thai_van_chuyen) {
        this.trang_thai_van_chuyen = trang_thai_van_chuyen;
    }

    public String getMa_giam_gia() {
        return ma_giam_gia;
    }

    public void setMa_giam_gia(String ma_giam_gia) {
        this.ma_giam_gia = ma_giam_gia;
    }

    public int getTrang_thai_thanh_toan() {
        return trang_thai_thanh_toan;
    }

    public void setTrang_thai_thanh_toan(int trang_thai_thanh_toan) {
        this.trang_thai_thanh_toan = trang_thai_thanh_toan;
    }

    public int getTong_tien() {
        return tong_tien;
    }

    public void setTong_tien(int tong_tien) {
        this.tong_tien = tong_tien;
    }
}
