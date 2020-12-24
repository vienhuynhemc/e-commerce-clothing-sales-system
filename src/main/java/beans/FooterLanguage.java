package beans;

import java.util.HashMap;
import java.util.Map;

public class FooterLanguage {

    // map dùng để lưu ngôn ngữ
    private Map<String, String> vietnamese;
    private Map<String, String> english;

    //  Constructor khởi tạo 2 map ngôn ngữ
    public FooterLanguage() {

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
        vietnamese.put("1","CÔNG TY TNHH");
        vietnamese.put("2","Giới thiệu");
        vietnamese.put("3","Tuyển dụng");
        vietnamese.put("4","Tạp chí");
        vietnamese.put("5","Hợp tác");
        vietnamese.put("6","HỖ TRỢ KHÁCH HÀNG");
        vietnamese.put("7","Hướng dẫn chọn size");
        vietnamese.put("8","Hướng dẫn mua hàng");
        vietnamese.put("9","Chính sách thành viên");
        vietnamese.put("10","Chính sách đổi trả");
        vietnamese.put("11","Chính sách bảo hành");
        vietnamese.put("12","Tra cứu đơn hàng");
        vietnamese.put("13","ĐỐI TÁC VẬN CHUYỂN");
        vietnamese.put("14","PHƯƠNG THỨC THANH TOÁN");
        vietnamese.put("15","LIÊN HỆ CHÚNG TÔI");
        vietnamese.put("16","Đại học Nông Lâm");
        vietnamese.put("17","Được hỗ trợ bởi Haravan Enterprice");
        vietnamese.put("18","Điều khoản & điều kiện");
        vietnamese.put("19","An toàn & bảo mật");

    }

    //  Phương thứuc khởi tạo ngôn ngữ english
    private void initializedEnglish() {

        //  content
       english.put("1","L.L COMPANY");
       english.put("2","Introduce");
       english.put("3","Recruitment");
       english.put("4","Journal");
       english.put("5","Co-operate");
       english.put("6","CUSTOMER SUPPORT");
       english.put("7","Instructions for choosing a size");
       english.put("8","Shopping guide");
       english.put("9","Membership policy");
       english.put("10","Return policy");
       english.put("11","Warranty Policy");
       english.put("12","Look up orders");
       english.put("13","SHIPPING PARTNERS");
       english.put("14","PAYMENT METHODS");
       english.put("15","CONTACT US");
       english.put("16","Nông Lâm University");
       english.put("17","Powered by Haravan Enterprice");
        english.put("18","Terms & Conditions");
        english.put("19","Safety & Security");

    }

    //  GETTER AND SETTER
    public Map<String, String> getVietnamese() {
        return vietnamese;
    }

    public Map<String, String> getEnglish() {
        return english;
    }

}
