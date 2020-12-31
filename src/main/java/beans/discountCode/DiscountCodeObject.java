package beans.discountCode;

import beans.nextPage.NextPageObject;

import java.util.List;

public class DiscountCodeObject {

    //  List mã giảm giá để đổ dữ liệu ra
    List<DiscountCode> discountCodes;

    //  Trang hiện tại
    private int nowPage;

    //  Số hãng sản xuất tối đa
    private int maximumDiscountCode;

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

    //  is notify
    private boolean isNotify;

    //  Content notify
    private String title;
    private String conntent;

    //  Constructor rỗng
    public DiscountCodeObject() {
    }

    //  GETTER  AND SETTER
    public List<DiscountCode> getDiscountCodes() {
        return discountCodes;
    }

    public void setDiscountCodes(List<DiscountCode> discountCodes) {
        this.discountCodes = discountCodes;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getMaximumDiscountCode() {
        return maximumDiscountCode;
    }

    public void setMaximumDiscountCode(int maximumDiscountCode) {
        this.maximumDiscountCode = maximumDiscountCode;
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

    public String getConntent() {
        return conntent;
    }

    public void setConntent(String conntent) {
        this.conntent = conntent;
    }

}
