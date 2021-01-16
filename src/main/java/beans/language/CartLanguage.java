package beans.language;

import java.util.HashMap;
import java.util.Map;

public class CartLanguage {
    // map dùng để lưu ngôn ngữ
    private Map<String, String> vietnamese;
    private Map<String, String> english;

    //  Constructor khởi tạo 2 map ngôn ngữ
    public CartLanguage() {

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
        vietnamese.put("1", "Giỏ hàng của bạn");
        vietnamese.put("2", "Tiếp tục mua sắm");
        vietnamese.put("3", "Tổng tiền sản phẩm");
        vietnamese.put("4", "Thông tin đơn hàng");
        vietnamese.put("5", "Phí vận chuyển:");
        vietnamese.put("6", "Tổng tiền:");
        vietnamese.put("7", "Số loại:");
        vietnamese.put("8", "Số lượng:");
        vietnamese.put("9", "Thời gian giao hàng từ 1-5 ngày tùy khu vực");
        vietnamese.put("10", "Free ship cho đơn hàng từ 499k trở lên");
        vietnamese.put("11", "Ghi chú đơn hàng");
        vietnamese.put("12", "Thanh toán");


    }

    //  Phương thứuc khởi tạo ngôn ngữ english
    private void initializedEnglish() {

        //  content
        english.put("1", "Your cart");
        english.put("2", "Continue shopping");
        english.put("3", "Total product money");
        english.put("4", "Information line");
        english.put("5", "Transport fee:");
        english.put("6", "Total amount:");
        english.put("7", "Number of types:");
        english.put("8", "Amount:");
        english.put("9", "Delivery time from 1-5 days depending on region");
        english.put("10", "Free ship for orders from 499k and above");
        english.put("11", "Order notes");
        english.put("12", "Pay");

    }

    //  GETTER AND SETTER
    public Map<String, String> getVietnamese() {
        return vietnamese;
    }

    public Map<String, String> getEnglish() {
        return english;
    }
}
