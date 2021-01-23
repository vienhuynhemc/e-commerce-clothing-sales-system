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
}
