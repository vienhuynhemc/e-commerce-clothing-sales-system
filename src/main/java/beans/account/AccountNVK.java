package beans.account;

import beans.Address;
import beans.DateTime;

public class AccountNVK {
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
    private int salary;
    private int info;
    private int level;
    private Address address;

    public AccountNVK() {
    }

    public AccountNVK(String idUser, int type, String userName, String passWord, String email, String phone, String avatar, String displayName, String fullName, DateTime regisDate, int salary, int info, int level, Address address) {
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
        this.salary = salary;
        this.info = info;
        this.level = level;
        this.address = address;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
