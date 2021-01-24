package beans.productAdmin;

import beans.ObjectPageAdmin;
import beans.nextPage.NextPageObject;

import java.util.List;

public class ProductAdminObject implements ObjectPageAdmin {

    //  Trang hiện tại
    private int nowPage;

    //  Số hãng sản xuất tối đa
    private int maximumProduct;

    //  Số trang tối đa
    private int maximumPage;

    //  Số mã giảm giá hiện thị
    private int numberOfShow;

    //  List để đổ dữ liệu phân trang
    private List<NextPageObject> nextPages;

    //  Sort
    private String sort;

    //  Search
    private String search;

    //  Select searchandSort
    private String selectSearchAndSort;

    private boolean ready;

    //  Thông báo
    private boolean isNotify;
    private String title;
    private String content;

    //  Trạng thái thêm mới
    private boolean is_them_moi;

    //  Trạng thái sửa đơn
    private boolean is_sua_don;

    //  Trạng thái sửa đa
    private boolean is_sua_da;

    //  List sản phẩm
    private List<ProductAdmin> products;

    //  List hãng sản xuất
    private List<ProductAdminManufacturer> danh_sach_hang_san_xuat;

    //  List danh mục
    private List<ProductAdminCategory> danh_sach_danh_muc;

    //  List màu
    private List<ProductAdminColorAdd> danh_sach_mau;

    //  List size
    private List<ProductAdminSizeAdd> danh_sach_size;

    //  Mã màu tiếp theo
    private String ma_mau_tiep_theo;

    //  Đối tượng sở hữu bác thêm sản phẩm tiếp theo
    private ProductAdminAdd productAdminAdd;

    public ProductAdminObject() {
    }

    public boolean isNotify() {
        return isNotify;
    }

    public void setNotify(boolean notify) {
        isNotify = notify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getMaximumProduct() {
        return maximumProduct;
    }

    public void setMaximumProduct(int maximumProduct) {
        this.maximumProduct = maximumProduct;
    }

    public int getMaximumPage() {
        return maximumPage;
    }

    public void setMaximumPage(int maximumPage) {
        this.maximumPage = maximumPage;
    }

    public int getNumberOfShow() {
        return numberOfShow;
    }

    public void setNumberOfShow(int numberOfShow) {
        this.numberOfShow = numberOfShow;
    }

    public List<NextPageObject> getNextPages() {
        return nextPages;
    }

    public void setNextPages(List<NextPageObject> nextPages) {
        this.nextPages = nextPages;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSelectSearchAndSort() {
        return selectSearchAndSort;
    }

    public void setSelectSearchAndSort(String selectSearchAndSort) {
        this.selectSearchAndSort = selectSearchAndSort;
    }

    public List<ProductAdmin> getProducts() {
        return products;
    }

    public void setProducts(List<ProductAdmin> products) {
        this.products = products;
    }

    public boolean isIs_them_moi() {
        return is_them_moi;
    }

    public void setIs_them_moi(boolean is_them_moi) {
        this.is_them_moi = is_them_moi;
    }

    public boolean isIs_sua_don() {
        return is_sua_don;
    }

    public void setIs_sua_don(boolean is_sua_don) {
        this.is_sua_don = is_sua_don;
    }

    public boolean isIs_sua_da() {
        return is_sua_da;
    }

    public void setIs_sua_da(boolean is_sua_da) {
        this.is_sua_da = is_sua_da;
    }

    @Override
    public boolean isReady() {
        return ready;
    }

    @Override
    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public List<ProductAdminManufacturer> getDanh_sach_hang_san_xuat() {
        return danh_sach_hang_san_xuat;
    }

    public void setDanh_sach_hang_san_xuat(List<ProductAdminManufacturer> danh_sach_hang_san_xuat) {
        this.danh_sach_hang_san_xuat = danh_sach_hang_san_xuat;
    }

    public List<ProductAdminCategory> getDanh_sach_danh_muc() {
        return danh_sach_danh_muc;
    }

    public void setDanh_sach_danh_muc(List<ProductAdminCategory> danh_sach_danh_muc) {
        this.danh_sach_danh_muc = danh_sach_danh_muc;
    }

    public List<ProductAdminColorAdd> getDanh_sach_mau() {
        return danh_sach_mau;
    }

    public void setDanh_sach_mau(List<ProductAdminColorAdd> danh_sach_mau) {
        this.danh_sach_mau = danh_sach_mau;
    }

    public List<ProductAdminSizeAdd> getDanh_sach_size() {
        return danh_sach_size;
    }

    public void setDanh_sach_size(List<ProductAdminSizeAdd> danh_sach_size) {
        this.danh_sach_size = danh_sach_size;
    }

    public String getMa_mau_tiep_theo() {
        return ma_mau_tiep_theo;
    }

    public void setMa_mau_tiep_theo(String ma_mau_tiep_theo) {
        this.ma_mau_tiep_theo = ma_mau_tiep_theo;
    }

    public ProductAdminAdd getProductAdminAdd() {
        return productAdminAdd;
    }

    public void setProductAdminAdd(ProductAdminAdd productAdminAdd) {
        this.productAdminAdd = productAdminAdd;
    }

}
