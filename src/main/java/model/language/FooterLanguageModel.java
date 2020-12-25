package model.language;

import beans.language.FooterLanguage;

import java.util.Map;

public class FooterLanguageModel {

    //  Tạo thể hiện cho lớp
    private static FooterLanguageModel footerLanguageModel;

    //  Class này có một thằng beans là footerlanguage
    private FooterLanguage footerLanguage;

    //  Constructor tạo beaans
    private FooterLanguageModel() {

        footerLanguage = new FooterLanguage();

    }

    //  Phương thức lấy thể hiện
    public static FooterLanguageModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (footerLanguageModel == null) {
            footerLanguageModel = new FooterLanguageModel();
        }

        //  Trả về thể hiện
        return footerLanguageModel;

    }

    //  Phương thức lấy về danh sách ngôn ngữ
    public Map<String, String> getList(String lang) {

        //  Nếu là english thì trả về danh sách ngôn ngữ tiếng anh
        if (lang.equals("english")) {
            return footerLanguage.getEnglish();
        }

        //  Không thì danh sách ngôn ngữ tiếng việt
        else {
            return footerLanguage.getVietnamese();
        }
    }

}
