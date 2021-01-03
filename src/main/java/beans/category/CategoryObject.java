package beans.category;

import beans.nextPage.NextPageObject;

import java.util.List;

public class CategoryObject {

    // trang hiện tại
    private int nowPage;

    // List danh mục lấy ra
    List<Category> categoryList;

    // số trang tối đa
    private int maximumPage;

    // số danh mục hiện tại
    private int numberOfShow;

    // List để đổ dữ liệu phân trang
    private List<NextPageObject> nextPage;

    // sort
    private String sort;

    // search
    private String search;

    // select searchandSort
    private String selectSearchAndSort;

    //  is notify
    private boolean isNotify;

    //  Content notify
    private String title;
    private String conntent;

    //  Constructor rỗng
    public CategoryObject() {
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
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

    public List<NextPageObject> getNextPage() {
        return nextPage;
    }

    public void setNextPage(List<NextPageObject> nextPage) {
        this.nextPage = nextPage;
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
