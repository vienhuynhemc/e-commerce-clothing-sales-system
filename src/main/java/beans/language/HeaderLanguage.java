package beans.language;

import java.util.HashMap;
import java.util.Map;

public class HeaderLanguage {
    // map dùng để lưu ngôn ngữ
    private Map<String, String> vietnamese;
    private Map<String, String> english;

    //  Constructor khởi tạo 2 map ngôn ngữ
    public HeaderLanguage() {

        //  Khởi tạo 2 map
        vietnamese = new HashMap<String, String>();
        english = new HashMap<String, String>();

        //  tạo dữ liệu cho nó
        initializedViewnamese();
        initializedEnglish();

    }

    //  Phương thức khởi tạo ngôn ngữ vietnam
    private void initializedViewnamese() {

        //  type
        vietnamese.put("type", "vietnamese");

        //  header
        vietnamese.put("1", "FREE SHIP VỚI");
        vietnamese.put("2", "ĐƠN");
        vietnamese.put("3", "HÀNG TỪ");
        vietnamese.put("4", "Giỏ Hàng");
        vietnamese.put("5", "Thanh Toán");
        vietnamese.put("6", "TRANG CHỦ");
        vietnamese.put("7", "NAM");
        vietnamese.put("8", "ÁO NAM");
        vietnamese.put("9", "ÁO KHOÁC");
        vietnamese.put("10", "ÁO THUN");
        vietnamese.put("11", "ÁO SƠ MI");
        vietnamese.put("12", "ÁO POLO");
        vietnamese.put("13", "QUẦN NAM");
        vietnamese.put("14", "QUẦN NGẮN");
        vietnamese.put("15", "QUẦN DÀI");
        vietnamese.put("16", "NỮ");
        vietnamese.put("17", "ÁO NỮ");
        vietnamese.put("18", "QUẦN / VÁY NỮ");
        vietnamese.put("19", "VÁY");
        vietnamese.put("21", "LIÊN HỆ");
        vietnamese.put("22", "VỀ CHÚNG TÔI");
        vietnamese.put("23", "QUẢN TRỊ");
        vietnamese.put("24", "GIÁ RẺ");
        vietnamese.put("25", "NHANH CHÓNG");
        vietnamese.put("26", "ĐẦM");
        vietnamese.put("27", "Giỏ hàng");
        vietnamese.put("28", "Thanh toán");
        vietnamese.put("29", "Tìm kiếm ở đây");
        vietnamese.put("30", "Tổng tiền");

    }

    //  Phương thứuc khởi tạo ngôn ngữ english
    private void initializedEnglish() {

        //  type
        english.put("type", "english");

        //  header
        english.put("1", "FREESHIP WITH");
        english.put("2", "ORDER");
        english.put("3", "FROM");
        english.put("4", "Shopping Cart");
        english.put("5", "Checkout");
        english.put("6", "HOME");
        english.put("7", "MEN");
        english.put("8", "MENS SHIRT");
        english.put("9", "COAT");
        english.put("10", "T-SHIRT");
        english.put("11", "DRESS SHIRT");
        english.put("12", "POLO SHIRT");
        english.put("13", "MEN PANTS");
        english.put("14", "SHORT PANTS");
        english.put("15", "LONG PANTS");
        english.put("16", "WOMEN");
        english.put("17", "WOMENS SHIRT");
        english.put("18", "PANTS / SKIRTS WOMEN");
        english.put("19", "SKIRT");
        english.put("21", "CONTACT");
        english.put("22", "ABOUT US");
        english.put("23", "ADMIN");
        english.put("24", "CHEAP");
        english.put("25", "FAST");
        english.put("26", "DRESS");
        english.put("27", "Shopping cart");
        english.put("28", "Checkout");
        english.put("29", "Search here");
        english.put("30", "Total money");

    }

    //  GETTER AND SETTER
    public Map<String, String> getVietnamese() {
        return vietnamese;
    }

    public Map<String, String> getEnglish() {
        return english;
    }

}
