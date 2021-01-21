package beans.product;

import beans.DateTime;

import java.util.ArrayList;
import java.util.Map;

public class Product {
    private String ma_sp;
    private String ten_sp;
    private String ma_hsx;
    private String ma_dm;
    private DateTime ngay_tao;
    private int gioi_tinh;
    private int trang_thai;
    private int so_luong_ban_ra;
    private int ton_tai;
    private ArrayList<ProductImage> listIMG;
    private ArrayList<Size> listSize;
    private ArrayList<ProductInfomation> listInfo;
    private ProductPrice price;
    private ProductPriceSale priceSale;
    private int extant;
    private String categoryName;
    private int so_luong_con_lai;

    public Product(String ma_sp, String ten_sp, String ma_hsx, String ma_dm, DateTime ngay_tao, int gioi_tinh, int trang_thai, int so_luong_ban_ra, int ton_tai) {
        this.ma_sp = ma_sp;
        this.ten_sp = ten_sp;
        this.ma_hsx = ma_hsx;
        this.ma_dm = ma_dm;
        this.ngay_tao = ngay_tao;
        this.gioi_tinh = gioi_tinh;
        this.trang_thai = trang_thai;
        this.so_luong_ban_ra = so_luong_ban_ra;
        this.ton_tai = ton_tai;
        listIMG = new ArrayList<ProductImage>();
        listSize = new ArrayList<Size>();
        listInfo = new ArrayList<ProductInfomation>();
        price = new ProductPrice();
        priceSale = new ProductPriceSale();

    }

    public Product() {
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

    public String getMa_hsx() {
        return ma_hsx;
    }

    public void setMa_hsx(String ma_hsx) {
        this.ma_hsx = ma_hsx;
    }

    public String getMa_dm() {
        return ma_dm;
    }

    public void setMa_dm(String ma_dm) {
        this.ma_dm = ma_dm;
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

    public ArrayList<ProductImage> getListIMG() {
        return listIMG;
    }

    public void setListIMG(ArrayList<ProductImage> listIMG) {
        this.listIMG = listIMG;
    }

    public ArrayList<Size> getListSize() {
        return listSize;
    }

    public void setListSize(ArrayList<Size> listSize) {
        this.listSize = listSize;
    }

    public ArrayList<ProductInfomation> getListInfo() {
        return listInfo;
    }

    public void setListInfo(ArrayList<ProductInfomation> listInfo) {
        this.listInfo = listInfo;
    }

    public ProductPrice getPrice() {
        return price;
    }

    public void setPrice(ProductPrice price) {
        this.price = price;
    }

    public ProductPriceSale getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(ProductPriceSale priceSale) {
        this.priceSale = priceSale;
    }

    public int getExtant() {
        return extant;
    }


    public void setExtant(int extant) {
        this.extant = extant;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getSo_luong_con_lai() {
        return so_luong_con_lai;
    }

    public void setSo_luong_con_lai(int so_luong_con_lai) {
        this.so_luong_con_lai = so_luong_con_lai;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ma_sp='" + ma_sp + '\'' +
                ", ten_sp='" + ten_sp + '\'' +
                ", ma_hsx='" + ma_hsx + '\'' +
                ", ma_dm='" + ma_dm + '\'' +
                ", ngay_tao=" + ngay_tao +
                ", gioi_tinh=" + gioi_tinh +
                ", trang_thai=" + trang_thai +
                ", so_luong_ban_ra=" + so_luong_ban_ra +
                ", ton_tai=" + ton_tai +
                ", danh muc =" + categoryName +
                '}' + "\n";
    }

}
