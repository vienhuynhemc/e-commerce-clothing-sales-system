package beans.account;

public class ErrorAccount {

    private String status;

    public ErrorAccount(String error){
        this.status = error;
    }

    public String getTitle(){
        if(status.equals("error1")){
            return "Xác nhận mật khẩu sai";
        }else if(status.equals("error2")){
            return "Email đã tồn tại trong cơ sở dữ liệu";
        }else if(status.equals("error3")){
            return "Email không tồn tại";
        }else if (status.equals("erro4")){
            return "Tài khoản đã tồn tại";
        }else {
           return "Đã thêm tài khoản thành công";
        }
    }
    public String getContent(){
        if(status.equals("error1")){
            return "Xác nhận mật khẩu không chính xác, vui lòng xác nhận lại mật khẩu.";
        }else if(status.equals("error2")){
            return "Email này đã được đăng ký trước đó, vui lòng nhập lại Email.";
        }else if(status.equals("error3")){
            return "Email này không tồn tại, vui lòng nhập lại Email.";
        }else if (status.equals("erro4")){
            return "Tài khoản này đã được đăng kí trước đó, vui lòng nhập một tài khoản hợp lệ";
        }else {
            return "Đã thêm tài khoản thành công";
        }
    }

}
