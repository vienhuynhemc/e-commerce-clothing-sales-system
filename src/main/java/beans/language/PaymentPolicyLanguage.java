package beans.language;

import java.util.HashMap;
import java.util.Map;

public class PaymentPolicyLanguage {

    // map dùng để lưu ngôn ngữ
    private Map<String, String> vietnamese;
    private Map<String, String> english;

    //  Constructor khởi tạo 2 map ngôn ngữ
    public PaymentPolicyLanguage() {

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
        vietnamese.put("1", "CHÍNH SÁCH");
        vietnamese.put("2", "ĐỔI TRẢ");
        vietnamese.put("3", "Chúng tôi nhận đổi trả sản phẩm với các quy định sau");

    }

    //  Phương thứuc khởi tạo ngôn ngữ english
    private void initializedEnglish() {

        //  content
        english.put("1", "PAYMENT");
        english.put("2", "POLICY");
        english.put("3", "We accept and return products with the following regulations");

    }

    //  GETTER AND SETTER
    public Map<String, String> getVietnamese() {
        return vietnamese;
    }

    public Map<String, String> getEnglish() {
        return english;
    }


}
