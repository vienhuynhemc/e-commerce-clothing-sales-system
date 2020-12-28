package beans.account;

public class ErrorLogin {
    private String status;

    public ErrorLogin(String error){
        this.status = error;
    }

    public String getTitle(){
        if(status.equals("error1")){
            return "Tài khoản không tồn tại";
        }
        if (status.equals("error2")){
            return "Tài khoản đã bị khóa";
        }
        if (status.equals("error3")){
            return "Sai mật khẩu";
        }
        else {
            return "Đăng nhập thành công";
        }

    }
    public String getContent(){
        if(status.equals("error1")) {
            return "Có vẻ như bạn nhầm lẫn gì đó về tài khoản, vui lòng nhập lại tài khoản.";
        }
        if (status.equals("error2")){
            return "Tài khoản này đã bị khóa do một số lý, vui lòng đăng nhập bằng một tài khoản khác hoặc liên hệ với A Trường để giải quyết";
        }
        if(status.equals("error3")) {
            return "Có vẻ như bạn nhầm lẫn gì đó về mật khẩu, vui lòng nhập lại mật khẩu, hoặc lấy lại mật khẩu đã quên";
        }
        else{
            return "Chúc mừng bạn đã đăng nhập thành công, Chào mừng bạn đã đến với TVTShop chúng tôi, Chúng tôi luôn giành những điều tốt đẹp nhất đến với bạn, hãy thỏa sức mua sắm nhé";
        }



    }
}
