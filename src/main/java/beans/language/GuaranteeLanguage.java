package beans.language;

import java.util.HashMap;
import java.util.Map;

public class GuaranteeLanguage {

    // map dùng để lưu ngôn ngữ
    private Map<String, String> vietnamese;
    private Map<String, String> english;

    //  Constructor khởi tạo 2 map ngôn ngữ
    public GuaranteeLanguage() {

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
        vietnamese.put("2", "BẢO HÀNH");
        vietnamese.put("3", "Chúng tôi có những quy định về việc bảo hành và sửa chữa sản phẩm");

    }

    //  Phương thứuc khởi tạo ngôn ngữ english
    private void initializedEnglish() {

        //  content
        english.put("1", "WARRANTY");
        english.put("2", "POLICY");
        english.put("3", "We have regulations for product warranties and repairs");

    }

    //  GETTER AND SETTER
    public Map<String, String> getVietnamese() {
        return vietnamese;
    }

    public Map<String, String> getEnglish() {
        return english;
    }

}
