package beans.account;

import beans.DateTime;

public class AccountCustomer {

    private String idUser;
    private int type;
    private String userName;
    private String passWord;
    private String email;
    private String phone;
    private String avatar;
    private String displayName;
    private String fullName;
    private DateTime regisDate;
    private int activeStatus;
    private int activeEvaluate;
    private DateTime deadline;
    private int ton_tai;
    private String ngon_ngu;

    public AccountCustomer(String idUser, int type, String userName, String passWord, String email, String phone, String avatar, String displayName, String fullName, DateTime regisDate, int activeStatus, int activeEvaluate, DateTime deadline, int ton_tai, String ngon_ngu) {
        this.idUser = idUser;
        this.type = type;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.phone = phone;
        this.avatar = avatar;
        this.displayName = displayName;
        this.fullName = fullName;
        this.regisDate = regisDate;
        this.activeStatus = activeStatus;
        this.activeEvaluate = activeEvaluate;
        this.deadline = deadline;
        this.ton_tai = ton_tai;
        this.ngon_ngu = ngon_ngu;
    }

    public AccountCustomer() {
    }

    public int getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(int activeStatus) {
        this.activeStatus = activeStatus;
    }

    public int getActiveEvaluate() {
        return activeEvaluate;
    }

    public void setActiveEvaluate(int activeEvaluate) {
        this.activeEvaluate = activeEvaluate;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public DateTime getRegisDate() {
        return regisDate;
    }

    public void setRegisDate(DateTime regisDate) {
        this.regisDate = regisDate;
    }

    public DateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(DateTime deadline) {
        this.deadline = deadline;
    }

    public int getTon_tai() {
        return ton_tai;
    }

    public void setTon_tai(int ton_tai) {
        this.ton_tai = ton_tai;
    }

    public String getNgon_ngu() {
        return ngon_ngu;
    }

    public void setNgon_ngu(String ngon_ngu) {
        this.ngon_ngu = ngon_ngu;
    }

    @Override
    public String toString() {
        return "AccountCustomer{" +
                "idUser='" + idUser + '\'' +
                ", type=" + type +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", avatar='" + avatar + '\'' +
                ", displayName='" + displayName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", regisDate=" + regisDate +
                ", activeStatus=" + activeStatus +
                ", activeEvaluate=" + activeEvaluate +
                ", deadline=" + deadline +
                ", ton_tai=" + ton_tai +
                ", ngon_ngu='" + ngon_ngu + '\'' +
                '}';
    }
}
