package beans.account;

public class ErrorSignUpAccount {
    private String status;
    public ErrorSignUpAccount(String status){
        this.status = status;
    }
    public String getTitle(){
        if (status.equals("error1")){
            return "Email đã tồn tại!";
        }
        else if (status.equals("error2")){
            return "Tên tài khoản đã tồn tại!";
        }
        else if (status.equals("error3")){
            return "Vui lòng nhập đúng email!";
        }
        else if (status.equals("error4")){
            return "Vui lòng chấp nhận thỏa thuận để hoàn tất đăng ký!";
        }
        else if (status.equals("no")){
            return "Vui lòng nhập đầy đủ thông tin!";
        }
        else{
            return "Đăng ký tài khoản thành công!";
        }
    }
    public String getContent(){
        if (status.equals("error1")){
            return "Email đã tồn tại. Vui lòng nhập email khác!";
        }
        else if (status.equals("error2")){
            return "Tên tài khoản đã tồn tại. Vui lòng nhập tên khác!";
        }
        else if (status.equals("error3")){
            return "Phải chắc chắn một điều là bạn đã nhập đúng email!";
        }
        else if (status.equals("error4")){
            return "Vui lòng đọc thông tin và chấp nhận thỏa thuận nếu bạn muốn hoàn tất đăng ký!";
        }
        else if (status.equals("no")){
            return "Vui lòng nhập đầy đủ thông tin để đăng ký tài khoản!";
        }
        else{
            return "Đăng ký tài khoản thành công!";
        }
    }
}
