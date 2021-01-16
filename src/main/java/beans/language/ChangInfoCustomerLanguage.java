package beans.language;

import java.util.HashMap;
import java.util.Map;

public class ChangInfoCustomerLanguage {
    // map dùng để lưu ngôn ngữ
    private Map<String, String> vietnamese;
    private Map<String, String> english;

    //  Constructor khởi tạo 2 map ngôn ngữ
    public ChangInfoCustomerLanguage() {

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
        vietnamese.put("1", "Ảnh đại diện");
        vietnamese.put("2", "Thay đổi");
        vietnamese.put("3", "Xóa");
        vietnamese.put("4", "Tài khoản");
        vietnamese.put("5", "Tên hiển thị");
        vietnamese.put("6", "Hiển thị tên người dùng");
        vietnamese.put("7", "Tên đầy đủ");
        vietnamese.put("8", "Bạn muốn được gọi như thế nào?");
        vietnamese.put("9", "Dùng để đăng nhập");
        vietnamese.put("10", "Mật khẩu");
        vietnamese.put("11", "Đổi mật khẩu");
        vietnamese.put("12", "Địa chỉ email");
        vietnamese.put("13", "Dùng để nhận thông báo và lấy lại mật khẩu");
        vietnamese.put("14", "Số điện thoại");
        vietnamese.put("15", "Ngày tạo");
        vietnamese.put("16", "Bạn đã tham gia với chúng tôi lâu chưa?");
        vietnamese.put("17", "Mã tài khoản");
        vietnamese.put("18", "Để chúng tôi nhận biết tài khoản của bạn");
        vietnamese.put("19", "Liên kết tài khoản");
        vietnamese.put("20", "Chúng tôi sử dụng nó để cho phép bạn đăng nhập và hoàn thiện thông tin của bạn");
        vietnamese.put("21", "Đăng nhập với Google");
        vietnamese.put("22", "Kết nối");
        vietnamese.put("23", "Xóa tài khoản");
        vietnamese.put("24", "Nếu xóa tài khoản, bạn sẽ mất toàn bộ dữ liệu của mình");
        vietnamese.put("25", "Lưu thay đổi");
        vietnamese.put("26", "Trạng thái");
        vietnamese.put("27", "Lịch sử mua");
        vietnamese.put("28", "Đăng xuất");
        vietnamese.put("29", "Độ sôi nổi:");
        vietnamese.put("30", "Thay đổi ảnh đại diện");
        vietnamese.put("31", "Độ sôi nổi của bạn");
        vietnamese.put("32", "Nhấp chuột trong ngày");
        vietnamese.put("33", "Nhấp chuột trong tháng");


    }

    //  Phương thứuc khởi tạo ngôn ngữ english
    private void initializedEnglish() {

        //  content
        english.put("1", "Avatar");
        english.put("2", "Change");
        english.put("3", "Delete");
        english.put("4", "Account");
        english.put("5", "Display name");
        english.put("6", "Show username");
        english.put("7", "Full name");
        english.put("8", "How would you like to be called?");
        english.put("9", "Use to login");
        english.put("10", "Password");
        english.put("11", "Change Password");
        english.put("12", "Email address");
        english.put("13", "Used to receive notifications and retrieve the password");
        english.put("14", "Phone number");
        english.put("15", "Date created");
        english.put("16", "Have you been with us for a long time?");
        english.put("17", "Account code");
        english.put("18", "Let us know your account");
        english.put("19", "Account Links");
        english.put("20", "We use it to allow you to log in and complete your information");
        english.put("21", "Sign in with Google");
        english.put("22", "Connect");
        english.put("23", "Delete the account");
        english.put("24", "If you delete the account, you will lose all of your data");
        english.put("25", "Save changes");
        english.put("26", "Status");
        english.put("27", "Purchase history");
        english.put("28", "logout");
        english.put("29", "Boiliness:");
        english.put("30", "Change avatar");
        english.put("31", "Your excitement");
        english.put("32", "Clicks of the day");
        english.put("33", "Clicks for the month");


    }

    //  GETTER AND SETTER
    public Map<String, String> getVietnamese() {
        return vietnamese;
    }

    public Map<String, String> getEnglish() {
        return english;
    }
}
