package beans;

import java.util.HashMap;
import java.util.Map;

public class IndexMailNoticeLanguage {

    // map dùng để lưu ngôn ngữ
    private Map<String, String> vietnamese;
    private Map<String, String> english;

    //  Constructor khởi tạo 2 map ngôn ngữ
    public IndexMailNoticeLanguage() {

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
        vietnamese.put("1", "Tham gia không thành công");
        vietnamese.put("2", "Chúng tôi rất vui, nhưng Email này đã tham với chúng tôi rồi!");
        vietnamese.put("3", "Trở về");
        vietnamese.put("4", "Dường như Email bạn nhập cho chúng tôi có một tí sự nhầm lẫn, chúng tôi thấy rằng Email của bạn không tồn tại, nhập lại và tham gia với chúng tôi nhé!");
        vietnamese.put("5", "Tham gia thành công");
        vietnamese.put("6", "Cảm ơn bạn đã tham gia với TVTSHOP chúng tôi, ngay từ lúc này mỗi khi có thông báo mới bạn sẽ là người biết đầu tiên!");

    }

    //  Phương thứuc khởi tạo ngôn ngữ english
    private void initializedEnglish() {

        //  content
        english.put("1", "Participation was not successful");
        english.put("2", "We are very happy, but this Email has joined us!");
        english.put("3", "Go back");
        english.put("4", "It seems that the Email you entered for us has a little bit of confusion, we see that your Email does not exist, re-enter and join us!");
        english.put("5", "Join successfully");
        english.put("6", "Thank you for joining us TVTSHOP, from now on every new announcement you will be the first to know!");

    }

    //  GETTER AND SETTER
    public Map<String, String> getVietnamese() {
        return vietnamese;
    }

    public Map<String, String> getEnglish() {
        return english;
    }

}
