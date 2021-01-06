package beans.loginAdmin;

import model.loginAdmin.ForgotPasswordAdminModel;

import java.util.Date;

public class ForgotPasswordAdminObject {

    //  Boolean show chỗ điền email
    private boolean isFillEmail;

    //  Email để điền lại khi sendredirect
    private String email;

    //  Boolean show chỗ nhập mã xác nhận
    private boolean isFillCode;

    //  Code để tí fill lại khi sendriderect
    private String codeFill;

    //  Boolean showw chỗ nhập lại mật khẩu
    private boolean isValidPassword;

    //  2 mật khẩu để tí fill lại
    private String pass1;
    private String pass2;

    //  Boolean show thành công
    private boolean isComplete;

    //  Nội dung thông báo email
    private String content;

    //  Nội dung thông báo verify code
    private String content2;

    //  Nội dung thông báo validpassword
    private String content3;

    //  Biến thời gian hiệu lực, tính = giây
    private int timeOut;

    //  Mã code để người dùng xác nhận
    private String code;

    //  Thời hạn của mã code;
    private Date timeExists;

    // is show pass1
    private boolean isShowPass1;

    //  is showw pass2
    private boolean isShowPass2;

    //  Constructor rỗng, rồi set từng thằng cho dễ, ở khoang phải chứa 2 cái show pass1 pass2
    public ForgotPasswordAdminObject(boolean isShowPass1, boolean isShowPass2) {
        this.isShowPass1 = isShowPass1;
        this.isShowPass2 = isShowPass2;
    }

    //  Phương thức lấy thời gian còn lại từ model, hết hến hạn thì trả về 0
    public int getTimeOut() {
        this.timeOut = ForgotPasswordAdminModel.getInstance().getTimeOut(timeExists);
        return timeOut;
    }

    //  GETTER AND SETTER
    public boolean isFillEmail() {
        return isFillEmail;
    }

    public void setFillEmail(boolean fillEmail) {
        isFillEmail = fillEmail;
    }

    public boolean isFillCode() {
        return isFillCode;
    }

    public void setFillCode(boolean fillCode) {
        isFillCode = fillCode;
    }

    public boolean isValidPassword() {
        return isValidPassword;
    }

    public void setValidPassword(boolean validPassword) {
        isValidPassword = validPassword;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPass1() {
        return pass1;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    public String getCodeFill() {
        return codeFill;
    }

    public void setCodeFill(String codeFill) {
        this.codeFill = codeFill;
    }

    public Date getTimeExists() {
        return timeExists;
    }

    public void setTimeExists(Date timeExists) {
        this.timeExists = timeExists;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getContent3() {
        return content3;
    }

    public void setContent3(String content3) {
        this.content3 = content3;
    }

    public boolean isShowPass1() {
        return isShowPass1;
    }

    public void setShowPass1(boolean showPass1) {
        isShowPass1 = showPass1;
    }

    public boolean isShowPass2() {
        return isShowPass2;
    }

    public void setShowPass2(boolean showPass2) {
        isShowPass2 = showPass2;
    }

}
