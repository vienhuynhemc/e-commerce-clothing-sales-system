package beans.emailNotification;

import beans.ObjectPageAdmin;
import beans.nextPage.NextPageObject;

import java.util.List;

public class EmailNotificationObject implements ObjectPageAdmin {

    //  List email thông báo để đổ dữ liệu ra
    private List<EmailNotification> emailNotificationLists;

    //  Trang hiện tại
    private int nowPage;

    //  Số email thông báo tối ta
    private int maximumEmailNotification;

    //  Số trang tối đa
    private int maximumPage;

    //  Số email thông báo hiện tại
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

    //  Next id email
    private String nextId;

    private boolean ready;

    //  Constructor rỗng
    public EmailNotificationObject() {
    }

    // GETTER AND SETTER
    public List<EmailNotification> getEmailNotificationLists() {
        return emailNotificationLists;
    }

    public void setEmailNotificationLists(List<EmailNotification> emailNotificationLists) {
        this.emailNotificationLists = emailNotificationLists;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getMaximumEmailNotification() {
        return maximumEmailNotification;
    }

    public void setMaximumEmailNotification(int maximumEmailNotification) {
        this.maximumEmailNotification = maximumEmailNotification;
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

    @Override
    public boolean isReady() {
        return ready;
    }

    @Override
    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public String getNextId() {
        return nextId;
    }

    public void setNextId(String nextId) {
        this.nextId = nextId;
    }

}
