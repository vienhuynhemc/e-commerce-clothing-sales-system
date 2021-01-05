package beans.loginAdmin;

public class LoginAdminObject {

    //  Xem thử có thông báo tài khoản hay không
    private boolean isNotifyAccount;

    //  Xem thử có thông báo mật khẩu hay không
    private boolean isNotifyPassword;

    //  Nội dung thông báo
    private String content;

    //  Tài khoản nếu chỉ có mật khẩu sai
    private String account;

    //  Trạng thái remember
    private String remember;

    //  Constructor nhận đây đủ thông tin
    public LoginAdminObject(String account, String remember) {
        this.account = account;
        this.remember = remember;
    }

    //GETTER AND SETTER
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }

    public boolean isNotifyAccount() {
        return isNotifyAccount;
    }

    public void setNotifyAccount(boolean notifyAccount) {
        isNotifyAccount = notifyAccount;
    }

    public boolean isNotifyPassword() {
        return isNotifyPassword;
    }

    public void setNotifyPassword(boolean notifyPassword) {
        isNotifyPassword = notifyPassword;
    }
}
