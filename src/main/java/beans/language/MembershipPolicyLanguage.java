package beans.language;

import java.util.HashMap;
import java.util.Map;

public class MembershipPolicyLanguage {

    // map dùng để lưu ngôn ngữ
    private Map<String, String> vietnamese;
    private Map<String, String> english;

    //  Constructor khởi tạo 2 map ngôn ngữ
    public MembershipPolicyLanguage() {

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
        vietnamese.put("2", "THÀNH VIÊN");
        vietnamese.put("3", "Thành viên tuyệt vời nên sở hữu những quyền lợi riêng của họ");

    }

    //  Phương thứuc khởi tạo ngôn ngữ english
    private void initializedEnglish() {

        //  content
        english.put("1", "MEMBERSHIP");
        english.put("2", "POLICY");
        english.put("3", "Great members should own their own interests");

    }

    //  GETTER AND SETTER
    public Map<String, String> getVietnamese() {
        return vietnamese;
    }

    public Map<String, String> getEnglish() {
        return english;
    }

}