package beans.account;

public class ErrorEditAccountCustomer {
    private String status;

    public ErrorEditAccountCustomer(String error){
        this.status = error;
    }

    public String getTitle(){
        if(status.equals("error1")){
            return "Nhập sai mật khẩu";
        }
       if (status.equals("error2")){
           return "Xác nhận mật khẩu sai.";
       }
       else{
           return "Có thể thay đổi mật khẩu.";
       }

    }
    public String getContent(){
        if(status.equals("error1")) {
            return "Bạn đã nhập sai mật khẩu cũ.";
        }
        if (status.equals("error2")){
            return "Bạn đã nhập sai xác nhận mật khẩu, vui long nhập lại.";
        }
        else{
            return "Hãy nhấn lưu để thay đổi thông tin.";
        }
    }
}
