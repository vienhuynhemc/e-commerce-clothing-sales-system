package beans.loginAdmin;

import beans.DateTime;
import beans.address.Commune;
import beans.address.District;
import beans.address.Provincial;

public class AccountStaffAdmin {

    //  Mã nhân viên
    private String id;

    //  Lương
    private int salary;

    //  Giới thiệu
    private String introduce;

    //  Cấp độ
    private int level;

    //  Tồn tại
    private int exists;

    //  Tài khoản
    private String account;

    //  Mật khẩu
    private String password;

    //  Email
    private String email;

    //  Số điện thoại
    private String phoneNumber;

    //  Mã quên mật khẩu
    private int codeForgot;

    //  Hình đại diện, link firebase để xóa sử
    private String avatar;

    //  Link hình đại diện, dùng để hiện thị hình
    private String avatarLink;

    //  Tên hiển thị
    private String displayName;

    //  Tên đầy đủ
    private String fullName;

    //  Ngày tạo tài khoản
    private DateTime dateCreated;

    //  Hạn mã quên mật khẩu
    private DateTime deadLineCodeForget;

    //  Vai trò của account
    private Role role;

    //  Địa chỉ của nhân viên
    private Provincial provincial;
    private District district;
    private Commune commune;

    //  Constructor đầy đủ thông tin trừ mã quên mật khẩu và hạn sử dụng của mã quên mật khẩu
    public AccountStaffAdmin(String id, int salary, String introduce, int level, int exists, String account, String password, String email, String phoneNumber, String avatar, String avatarLink, String displayName, String fullName, DateTime dateCreated, Role role) {
        this.id = id;
        this.salary = salary;
        this.introduce = introduce;
        this.level = level;
        this.exists = exists;
        this.account = account;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.avatarLink = avatarLink;
        this.displayName = displayName;
        this.fullName = fullName;
        this.dateCreated = dateCreated;
        this.role = role;
    }

    //  Phương thức kiểm tra vai trò nhận vào
    public boolean accept(String role_function) {
        return role.accept(role_function);
    }

    //  Constructor rỗng, để ta tạo rồi set từ từ các thuộc tính cho nó
    public AccountStaffAdmin() {
    }

    //  Getter and setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExists() {
        return exists;
    }

    public void setExists(int exists) {
        this.exists = exists;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCodeForgot() {
        return codeForgot;
    }

    public void setCodeForgot(int codeForgot) {
        this.codeForgot = codeForgot;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
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

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public DateTime getDeadLineCodeForget() {
        return deadLineCodeForget;
    }

    public void setDeadLineCodeForget(DateTime deadLineCodeForget) {
        this.deadLineCodeForget = deadLineCodeForget;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Provincial getProvincial() {
        return provincial;
    }

    public void setProvincial(Provincial provincial) {
        this.provincial = provincial;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }
}
