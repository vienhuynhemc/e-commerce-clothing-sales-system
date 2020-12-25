package beans.language;

import java.util.HashMap;
import java.util.Map;

public class IndexLanguage {

    // map dùng để lưu ngôn ngữ
    private Map<String, String> vietnamese;
    private Map<String, String> english;

    //  Constructor khởi tạo 2 map ngôn ngữ
    public IndexLanguage() {

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

        // other
        vietnamese.put("31", "THỜI TRANG CÔNG SỞ NỮ");
        vietnamese.put("32", "GIẢM GIÁ");
        vietnamese.put("33", "MUA SẮM NGAY");
        vietnamese.put("34", "ĐỒ TÂY NAM");
        vietnamese.put("35", "ÁO SƠ MI NỮ");
        vietnamese.put("36", "THỜI TRANG DỰ TIỆC");
        vietnamese.put("37", "THỜI TRANG NAM HÔM NAY");
        vietnamese.put("38", "MUA SẮM VỚI");
        vietnamese.put("39", "CHÚNG TÔI");
        vietnamese.put("40", "Mục yêu thích được lựa chọn cẩn thận chỉ dành cho bạn");
        vietnamese.put("41", "Áo Khoác Nữ");
        vietnamese.put("42", "Áo Thun Nam");
        vietnamese.put("43", "Áo Váy");
        vietnamese.put("44", "Váy Trắng");
        vietnamese.put("45", "Đồ Tây Nam");
        vietnamese.put("46", "Áo Khoác Nam");
        vietnamese.put("47", "TẤT CẢ ĐỒ NAM CÓ THUƠNG HIỆU ĐỀU ĐƯỢC");
        vietnamese.put("48", "Ghé thăm cửa hàng của chúng tôi để xem những sáng tạo tuyệt vời từ các nhà thiết kế");
        vietnamese.put("49", "ĐẾN VỚI CHÚNG TÔI HÃY CHUẨN BỊ TINH THẦN ĐỂ TRỞ THÀNH NGƯỜI");
        vietnamese.put("50", "XINH ĐẸP");
        vietnamese.put("51", "Những thiết kế hiện đại giúp bạn đi lên tất cả");
        vietnamese.put("52", "Những thời trang vừa mới được cập nhập");
        vietnamese.put("53", "Thời trang nam");
        vietnamese.put("54", "Thời trang nữ");
        vietnamese.put("55", "Xem tất cả sản phẩm");
        vietnamese.put("56", "SET ĐỒ BƯỚC RA TỪ CỔ TÍCH SET ĐỒ");
        vietnamese.put("57", "TRUYỀN THUYẾT");
        vietnamese.put("58", "Gái nào mặc cũng đẹp - Trai nào mặc cũng sang");
        vietnamese.put("59", "XU HUỚNG MUA");
        vietnamese.put("60", "HÀNG");
        vietnamese.put("61", "Chọn lọc những sản phẩm được khách hàng mua nhiều nhất");
        vietnamese.put("62", "Phổ biến");
        vietnamese.put("63", "ĐẶC BIỆT");
        vietnamese.put("64", "KHÁCH HÀNG");
        vietnamese.put("65", "YÊU THÍCH");
        vietnamese.put("66", "Mọi người nói gì về chúng tôi");
        vietnamese.put("67", "THAM GIA VỚI CHÚNG TÔI ĐỂ NHẬN NHỮNG");
        vietnamese.put("68", "EMAIL THÔNG TIN SỚM NHẤT");
        vietnamese.put("69", "Đăng ký và nhận thông báo về bản cập nhật và ưu đãi mới nhất trước tất cả!");
        vietnamese.put("70", "Nhập email của bạn ở đây");
        vietnamese.put("71", "Tham gia");
        vietnamese.put("72", "Thêm vào yêu thích");
        vietnamese.put("73", "Xem nhanh");
        vietnamese.put("74", "Thêm vào giỏ");
        vietnamese.put("75","Mới!");
        vietnamese.put("76","Giảm giá!");
        vietnamese.put("77","Hết hàng!");

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

        //  other
        english.put("31", "OFFICE FASHION WOMEN");
        english.put("32", "SALE");
        english.put("33", "SHOP NOW");
        english.put("34", "SOUTHWEST CLOTHING");
        english.put("35", "WOMEN's SHIRT");
        english.put("36", "PARTY FASHION");
        english.put("37", "MEN'S CLOTHING TODAY");
        english.put("38", "SHOP WITH");
        english.put("39", "US");
        english.put("40", "Carefully selected favorites just for you");
        english.put("41", "Women's Coat");
        english.put("42", "Men's T-Shirt");
        english.put("43", "Dress");
        english.put("44", "White Skirt");
        english.put("45", "Southwest Clothes");
        english.put("46", "Men's Coat");
        english.put("47", "ALL MEN HAVE EFFECTIVE SYMPTOMS");
        english.put("48", "Visit our store to see great creations from designers");
        english.put("49", "Come to us, prepare your spirit to become a human");
        english.put("50", "beautiful");
        english.put("51", "Modern designs help you go all the way up");
        english.put("52", "The fashion has just been updated");
        english.put("53", "Men's Fashion");
        english.put("54", "Women's Fashion");
        english.put("55", "View all products");
        english.put("56", "SET CHECK STEP FROM THE FISHES SET COPY");
        english.put("57", "LEGEND");
        english.put("58", "Every girl wears it well - Every guy wears it");
        english.put("59", "Buy");
        english.put("60", "trends");
        english.put("61", "Select the products that customers buy the most");
        english.put("62", "COMMON");
        english.put("63", "ESPECIALLY");
        english.put("64", "CUSTOMERS");
        english.put("65", "FAVORITE");
        english.put("66", "What do people say about us");
        english.put("67", "JOIN US TO GET");
        english.put("68", "THE EARLY INFORMATION EMAILS");
        english.put("69", "Sign up and get notified of the latest updates and offers before all!");
        english.put("70", "Enter your email here");
        english.put("71", "Join");
        english.put("72", "Add to favorites");
        english.put("73", "Quick view");
        english.put("74", "Add to cart");
        english.put("75", "New!");
        english.put("76", "Sale!");
        english.put("77", "Over!");

    }

    //  GETTER AND SETTER
    public Map<String, String> getVietnamese() {
        return vietnamese;
    }

    public Map<String, String> getEnglish() {
        return english;
    }

}
