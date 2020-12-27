package beans.account;

public class ErrorEditAccount {
    private String status;

    public ErrorEditAccount(String error){
        this.status = error;
    }

    public String getTitle(){
        if(status.equals("error1")){
            return "Xác nhận mật khẩu sai";
    }else {
            return "Đã sửa thành công";
        }

    }
    public String getContent(){
        if(status.equals("error1")) {
            return "Xác nhận mật khẩu không chính xác, vui lòng xác nhận lại mật khẩu.";
        }
        return "Đã sửa tài khoản thành công";
        }
}

