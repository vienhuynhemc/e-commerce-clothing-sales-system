package beans.productAdmin;

import java.util.ArrayList;
import java.util.List;

public class ProductAdminAdd {

    //  Danh mục hiện tại được chọn
    private ProductAdminCategory danh_muc;

    //  Hãng sản xuất hiện tại được chọn
    private ProductAdminManufacturer hang_san_xuat;

    //  Tên sản phẩm
    private String ten_sp;

    //  Giới tính
    private String gioi_tinh;

    //  Giá hiện tại
    private String gia_sp;

    //  Giá khuyễn mãi hiện tại
    private String gia_khuyen_mai;

    //  Giá nhập
    private String gia_nhap;

    //  List size hiện tại
    private List<ProductAdminSizeAdd> list_size;

    //  List thông tin
    private List<String> list_thong_tin;

    //  List giới thiệu
    private List<String> list_gioi_thieu;

    //  List cấu tạo
    private List<String> list_cau_tao;

    //  List hình ảnh kèm sản phẩm
    private List<ProductAdminColorAddProduct> list_mau_kem_hinh_anh;

    //  Loại sản phẩm, áo hay quần
    private String loai_sp;

    public ProductAdminAdd(){
    }

    public void removeOneSzeById(String ma_size){
        for (int i = 0; i <list_size.size() ; i++) {
            if(list_size.get(i).getId().equals(ma_size)){
                list_size.remove(i);
                return;
            }
        }
    }

    public void removeColor(String ma_mau){
        for (int i = 0; i <list_mau_kem_hinh_anh.size() ; i++) {
            if(list_mau_kem_hinh_anh.get(i).getMa_mau().equals(ma_mau)){
                list_mau_kem_hinh_anh.remove(i);
                return;
            }
        }
    }

    public void addImage(String ma_mau,String hinh){
        for (int i = 0; i <list_mau_kem_hinh_anh.size() ; i++) {
            if(list_mau_kem_hinh_anh.get(i).getMa_mau().equals(ma_mau)){
                list_mau_kem_hinh_anh.get(i).getList_hinh_anh_sp().add(hinh);
                list_mau_kem_hinh_anh.get(i).setHinh_anh_trong_firebase(list_mau_kem_hinh_anh.get(i).getHinh_anh_trong_firebase()+1);
                return;
            }
        }
    }

    public void removeImage(String ma_mau,String hinh){
        for (int i = 0; i <list_mau_kem_hinh_anh.size() ; i++) {
            if(list_mau_kem_hinh_anh.get(i).getMa_mau().equals(ma_mau)){
                list_mau_kem_hinh_anh.get(i).getList_hinh_anh_sp().remove(hinh);
                return;
            }
        }
    }

    public ProductAdminCategory getDanh_muc() {
        return danh_muc;
    }

    public void setDanh_muc(ProductAdminCategory danh_muc) {
        this.danh_muc = danh_muc;
    }

    public ProductAdminManufacturer getHang_san_xuat() {
        return hang_san_xuat;
    }

    public void setHang_san_xuat(ProductAdminManufacturer hang_san_xuat) {
        this.hang_san_xuat = hang_san_xuat;
    }

    public String getGia_sp() {
        return gia_sp;
    }

    public void setGia_sp(String gia_sp) {
        this.gia_sp = gia_sp;
    }

    public String getGia_khuyen_mai() {
        return gia_khuyen_mai;
    }

    public void setGia_khuyen_mai(String gia_khuyen_mai) {
        this.gia_khuyen_mai = gia_khuyen_mai;
    }

    public String getGia_nhap() {
        return gia_nhap;
    }

    public void setGia_nhap(String gia_nhap) {
        this.gia_nhap = gia_nhap;
    }

    public List<ProductAdminSizeAdd> getList_size() {
        return list_size;
    }

    public void setList_size(List<ProductAdminSizeAdd> list_size) {
        this.list_size = list_size;
    }

    public List<String> getList_thong_tin() {
        return list_thong_tin;
    }

    public void setList_thong_tin(List<String> list_thong_tin) {
        this.list_thong_tin = list_thong_tin;
    }

    public List<String> getList_gioi_thieu() {
        return list_gioi_thieu;
    }

    public void setList_gioi_thieu(List<String> list_gioi_thieu) {
        this.list_gioi_thieu = list_gioi_thieu;
    }

    public List<String> getList_cau_tao() {
        return list_cau_tao;
    }

    public void setList_cau_tao(List<String> list_cau_tao) {
        this.list_cau_tao = list_cau_tao;
    }

    public List<ProductAdminColorAddProduct> getList_mau_kem_hinh_anh() {
        return list_mau_kem_hinh_anh;
    }

    public void setList_mau_kem_hinh_anh(List<ProductAdminColorAddProduct> list_mau_kem_hinh_anh) {
        this.list_mau_kem_hinh_anh = list_mau_kem_hinh_anh;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public String getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(String gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public String getLoai_sp() {
        return loai_sp;
    }

    public void setLoai_sp(String loai_sp) {
        this.loai_sp = loai_sp;
    }
}

