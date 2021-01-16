package beans.loginAdmin;

import beans.ObjectPageAdmin;

import java.util.Map;

public class UserAdmin {

    //  User Admin chứa một tài khoản nhân viên
    private AccountStaffAdmin account;

    //  User Admin chứa một hashMap các object quản lý trang
    private Map<String, ObjectPageAdmin> listOfFunction;

    //  CONSTRUCTOR nhận đầy đủ thông tin
    public UserAdmin(AccountStaffAdmin account, Map<String, ObjectPageAdmin> listOfFunction) {
        this.account = account;
        this.listOfFunction = listOfFunction;
    }

    //  Phương thức cập nhập ready tất cả thành false trừ thằng có key truyền vào
    public void updateReady(String keyIgnore) {
        for (Map.Entry<String, ObjectPageAdmin> e : listOfFunction.entrySet()) {
            if(!e.getKey().equals(keyIgnore)){
                e.getValue().setReady(false);
            }
        }
    }

    //  GETTER AND SETTER
    public AccountStaffAdmin getAccount() {
        return account;
    }

    public void setAccount(AccountStaffAdmin account) {
        this.account = account;
    }

    public Map<String, ObjectPageAdmin> getListOfFunction() {
        return listOfFunction;
    }

    public void setListOfFunction(Map<String, ObjectPageAdmin> listOfFunction) {
        this.listOfFunction = listOfFunction;
    }
}
