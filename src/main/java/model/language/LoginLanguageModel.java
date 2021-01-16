package model.language;

import beans.language.IndexMailNoticeLanguage;
import beans.language.LoginLanguage;

import java.util.Map;

public class LoginLanguageModel {

    //  Tạo thể hiện cho lớp
    private static LoginLanguageModel loginLanguageModel;

    //  Class này có một thằng beans là footerlanguage
    private LoginLanguage loginLanguage;

    //  Constructor tạo beaans
    private LoginLanguageModel() {

        loginLanguage = new LoginLanguage();

    }
    public static LoginLanguageModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (loginLanguageModel == null) {
            loginLanguageModel = new LoginLanguageModel();
        }

        //  Trả về thể hiện
        return loginLanguageModel;

    }
    public Map<String, String> getList(String lang) {

        //  Nếu là english thì trả về danh sách ngôn ngữ tiếng anh
        if (lang.equals("english")) {
            return loginLanguage.getEnglish();
        }

        //  Không thì danh sách ngôn ngữ tiếng việt
        else {
            return loginLanguage.getVietnamese();
        }
    }

}
