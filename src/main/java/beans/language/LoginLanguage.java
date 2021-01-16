package beans.language;

import java.util.HashMap;
import java.util.Map;

public class LoginLanguage {

    // map dùng để lưu ngôn ngữ
    private Map<String, String> vietnamese;
    private Map<String, String> english;

    //  Constructor khởi tạo 2 map ngôn ngữ
    public LoginLanguage() {

        //  Khởi tạo 2 map
        vietnamese = new HashMap<String, String>();
        english = new HashMap<String, String>();

        //  tạo dữ liệu cho nó
        initializedViewnamese();
        initializedEnglish();

    }

    //  Phương thức khởi tạo ngôn ngữ vietnam
    private void initializedViewnamese() {

        //  content
        vietnamese.put("1", "Chào mừng bạn trở lại, vui lòng đăng nhập vào tài khoản của mình");
        vietnamese.put("2", "Đăng nhập bằng facebook");
        vietnamese.put("3", "Hoặc");
        vietnamese.put("4", "Tài khoản");
        vietnamese.put("5", "Nhập tài khoản của bạn ở đây");
        vietnamese.put("6", "Mật khẩu");
        vietnamese.put("7", "Nhập mật khẩu của bạn ở đây");
        vietnamese.put("8", "Nhớ mật khẩu");
        vietnamese.put("9", "Quên mật khẩu");
        vietnamese.put("10", "Đăng nhập");
        vietnamese.put("11", "Đăng kí");
        vietnamese.put("12", "Bằng cách đăng ký, bạn đồng ý với");
        vietnamese.put("13", "Xin chào, bạn của tôi!");
        vietnamese.put("14", "Đăng ký tài khoản dành riêng cho bạn và bắt đầu hành trình mua sắm với chúng tôi");
        vietnamese.put("15", "Đăng kí");
        vietnamese.put("16", "Chào mừng trở lại!");
        vietnamese.put("17", "Hãy duy trì kết nối với chúng tôi bằng cách đăng nhập tài khoản của bạn");
        vietnamese.put("18", "Cung cấp cho chúng tôi một số thông tin của bạn để có quyền truy cập vào trang và mua sắm");
        vietnamese.put("19", "Họ và tên");
        vietnamese.put("20", "Nhập họ và tên của bạn ở đây");
        vietnamese.put("21", "Số điện thoại");
        vietnamese.put("22", "Nhập số điện thoại của bạn ở đây");
        vietnamese.put("23", "Nhập email của bạn ở đây");
        vietnamese.put("24", "Bạn đã có tài khoản?");
        vietnamese.put("25", "Đăng nhập bằng google");
        vietnamese.put("26", "các điều khoản và điều kiện");
        vietnamese.put("27", "&");
        vietnamese.put("28", "chính sách bảo mật");
        vietnamese.put("29", "của chúng tôi");


    }

    //  Phương thứuc khởi tạo ngôn ngữ english
    private void initializedEnglish() {

        //  content
        english.put("1", "Welcome back, please login to your account");
        english.put("2", "Login with facebook");
        english.put("3", "Or");
        english.put("4", "Account");
        english.put("5", "Enter your account here");
        english.put("6", "Password");
        english.put("7", "Enter your password here");
        english.put("8", "Remember password");
        english.put("9", "Forgot password");
        english.put("10", "Login");
        english.put("11", "Register");
        english.put("12", "By registering, you agree to");
        english.put("13", "Hello my friend!");
        english.put("14", "Register for a personalized account and start your shopping journey with us");
        english.put("15", "Register");
        english.put("16", "Welcome back!");
        english.put("17", "Stay connected with us by logging into your account");
        english.put("18", "Give us some of your information for site access and shopping");
        english.put("19", "First and last name");
        english.put("20", "Enter your first and last name here");
        english.put("21", "Phone number");
        english.put("22", "Enter your phone number here");
        english.put("23", "Enter your email here");
        english.put("24", "Do you already have an account?");
        english.put("25", "Login with google");
        english.put("26", "Terms and conditions");
        english.put("27", "&");
        english.put("28", "Privacy Policy");
        english.put("29", "ours");

    }

    //  GETTER AND SETTER
    public Map<String, String> getVietnamese() {
        return vietnamese;
    }

    public Map<String, String> getEnglish() {
        return english;
    }

}
