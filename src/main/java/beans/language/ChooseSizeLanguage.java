package beans.language;

import java.util.HashMap;
import java.util.Map;

public class ChooseSizeLanguage {

    // map dùng để lưu ngôn ngữ
    private Map<String, String> vietnamese;
    private Map<String, String> english;

    //  Constructor khởi tạo 2 map ngôn ngữ
    public ChooseSizeLanguage() {

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
        vietnamese.put("1", "HƯỚNG DẪN");
        vietnamese.put("2", "CHỌN SIZE");
        vietnamese.put("3", "Ở đây bạn khỏi lo vấn đề đồ có vừa với mình hay không");
        vietnamese.put("4", "Dành cho nam");
        vietnamese.put("5", "Dành cho nữ");

    }

    //  Phương thứuc khởi tạo ngôn ngữ english
    private void initializedEnglish() {

        //  content
        english.put("1", "GUIDE TO");
        english.put("2", "CHOOSE SIZE");
        english.put("3", "Here you do not worry whether the item suits you or not");
        english.put("4", "For men");
        english.put("5", "For women");

    }

    //  GETTER AND SETTER
    public Map<String, String> getVietnamese() {
        return vietnamese;
    }

    public Map<String, String> getEnglish() {
        return english;
    }

}
