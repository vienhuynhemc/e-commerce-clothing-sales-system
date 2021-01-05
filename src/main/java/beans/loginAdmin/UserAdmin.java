package beans.loginAdmin;

import java.util.Map;

public class UserAdmin {

    //  User Admin chứa một tài khoản nhân viên
    private AccountStaffAdmin account;

    //  User Admin chứa một hashMap các object quản lý trang
    private Map<String,Object> listOfFunction;

    //  CONSTRUCTOR nhận đầy đủ thông tin
    public UserAdmin(AccountStaffAdmin account, Map<String, Object> listOfFunction) {
        this.account = account;
        this.listOfFunction = listOfFunction;
    }

    //  GETTER AND SETTER
    public AccountStaffAdmin getAccount() {
        return account;
    }

    public void setAccount(AccountStaffAdmin account) {
        this.account = account;
    }

    public Map<String, Object> getListOfFunction() {
        return listOfFunction;
    }

    public void setListOfFunction(Map<String, Object> listOfFunction) {
        this.listOfFunction = listOfFunction;
    }
}
