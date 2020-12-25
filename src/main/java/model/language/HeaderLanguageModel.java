package model.language;

import beans.language.HeaderLanguage;

import java.util.Map;

public class HeaderLanguageModel {

    //  Tạo thể hiện cho lớp
    private static HeaderLanguageModel headerLanguageModel;

    //  Class này có một thằng beans là footerlanguage
    private HeaderLanguage headerLanguage;

    //  Constructor tạo beaans
    private HeaderLanguageModel() {

        headerLanguage = new HeaderLanguage();

    }

    //  Phương thức lấy thể hiện
    public static HeaderLanguageModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (headerLanguageModel == null) {
            headerLanguageModel = new HeaderLanguageModel();
        }

        //  Trả về thể hiện
        return headerLanguageModel;

    }

    //  Phương thức lấy về danh sách ngôn ngữ
    public Map<String, String> getList(String lang) {

        //  Nếu là english thì trả về danh sách ngôn ngữ tiếng anh
        if (lang.equals("english")) {
            return headerLanguage.getEnglish();
        }

        //  Không thì danh sách ngôn ngữ tiếng việt
        else {
            return headerLanguage.getVietnamese();
        }
    }

}
