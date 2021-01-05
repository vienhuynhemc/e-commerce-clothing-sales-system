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

    //  Nội dung thông báo
    private String content;

    //  Biến thời gian hiệu lực, tính = giây
    private int timeOut;

    //  Mã code để người dùng xác nhận
    private String code;

    //  Thời hạn của mã code;
    private Date timeExists;

    //  Constructor rỗng, rồi set từng thằng cho dễ
    public ForgotPasswordAdminObject() {
    }

    //  Phương thức lấy thời gian còn lại từ model, hết hến hạn thì trả về 0
    public int getTimeOut(){
        this.timeOut = ForgotPasswordAdminModel.getTimeOut(timeExists);
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

}
