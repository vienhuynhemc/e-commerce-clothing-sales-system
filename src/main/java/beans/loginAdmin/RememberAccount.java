package beans.loginAdmin;

public class RememberAccount {

    //  Thuộc tính
    private String account;
    private String password;

    //  Constructor
    public RememberAccount(String account, String password) {
        this.account = account;
        this.password = password;
    }

    //  GETTER AND SETTER
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
