package model.language;


import beans.language.CartLanguage;

import java.util.Map;

public class CartLanguageModel {
    //  Tạo thể hiện cho lớp
    private static CartLanguageModel loginLanguageModel;

    //  Class này có một thằng beans là footerlanguage
    private CartLanguage cartLanguage;

    //  Constructor tạo beaans
    private CartLanguageModel() {

        cartLanguage = new CartLanguage();

    }
    public static CartLanguageModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (loginLanguageModel == null) {
            loginLanguageModel = new CartLanguageModel();
        }

        //  Trả về thể hiện
        return loginLanguageModel;

    }
    public Map<String, String> getList(String lang) {

        //  Nếu là english thì trả về danh sách ngôn ngữ tiếng anh
        if (lang.equals("english")) {
            return cartLanguage.getEnglish();
        }

        //  Không thì danh sách ngôn ngữ tiếng việt
        else {
            return cartLanguage.getVietnamese();
        }
    }
}
