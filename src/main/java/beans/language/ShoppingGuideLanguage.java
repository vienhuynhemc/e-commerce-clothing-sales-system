package beans.language;

import java.util.HashMap;
import java.util.Map;

public class ShoppingGuideLanguage {

    // map dùng để lưu ngôn ngữ
    private Map<String, String> vietnamese;
    private Map<String, String> english;

    //  Constructor khởi tạo 2 map ngôn ngữ
    public ShoppingGuideLanguage() {

        //  Khởi tạo 2 map
        vietnamese = new HashMap<String, String>();
        english = new HashMap<String, String>();

        //  tạo dữ liệu cho nó
        initializedViewnamese();
        initializedEnglish();

    }

    //  Phương thức khởi tạo ngôn ngữ vietnam
    private void initializedViewnamese() {

        //  Content
        vietnamese.put("1", "HƯỚNG DẪN");
        vietnamese.put("2", "Mọi thú thật dễ dàng khi đến với chúng tôi");
        vietnamese.put("3", "Cách 1");
        vietnamese.put("4", "09-7112-290");
        vietnamese.put("5", "từ");
        vietnamese.put("6", "8h00-17hh00");
        vietnamese.put("7", "anh Huỳnh Nhật Trường sẵn sàng phục vụ bạn");
        vietnamese.put("8", "Cách 2");
        vietnamese.put("9", "Đặt hàng trên Website theo 5 bước nhẹ nhàng");
        vietnamese.put("10", "Chọn sản phẩm");
        vietnamese.put("11", "Chọn màu sắc và size");
        vietnamese.put("12", "Thêm vào giỏ hàng");
        vietnamese.put("13", "Kiểm tra giỏ hàng");
        vietnamese.put("14", "Thanh toán");
        vietnamese.put("15","MUA HÀNG");
        vietnamese.put("16","Gọi điện tới tổng đài");

    }

    //  Phương thứuc khởi tạo ngôn ngữ english
    private void initializedEnglish() {

        english.put("1", "SHOPPING");
        english.put("2", "Every confession is easy when it comes to us");
        english.put("3", "Way 1");
        english.put("4", "09-7112-290");
        english.put("5", "from");
        english.put("6", "8h00-17hh00");
        english.put("7", "Mr. Huynh Nhat Truong is ready to serve you");
        english.put("8", "Way 2");
        english.put("9", "Ordering on the Website in 5 easy steps:");
        english.put("10", "Select the product");
        english.put("11", "Choose color and size");
        english.put("12", "Add to shopping cart");
        english.put("13", "Check out shopping cart");
        english.put("14", "Checkout");
        english.put("15","GUIDE");
        english.put("16","Call the switchboard");

    }

    //  GETTER AND SETTER
    public Map<String, String> getVietnamese() {
        return vietnamese;
    }

    public Map<String, String> getEnglish() {
        return english;
    }

}
