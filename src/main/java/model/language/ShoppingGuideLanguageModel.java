package model.language;

import beans.language.ShoppingGuideLanguage;

import java.util.Map;

public class ShoppingGuideLanguageModel {

    //  Tạo thể hiện cho lớp
    private static ShoppingGuideLanguageModel shoppingGuideLanguageModel;

    //  Class này có một thằng beans là footerlanguage
    private ShoppingGuideLanguage shoppingGuideLanguage;

    //  Constructor tạo beaans
    private ShoppingGuideLanguageModel() {

        shoppingGuideLanguage = new ShoppingGuideLanguage();

    }

    //  Phương thức lấy thể hiện
    public static ShoppingGuideLanguageModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (shoppingGuideLanguageModel == null) {
            shoppingGuideLanguageModel = new ShoppingGuideLanguageModel();
        }

        //  Trả về thể hiện
        return shoppingGuideLanguageModel;

    }

    //  Phương thức lấy về danh sách ngôn ngữ
    public Map<String, String> getList(String lang) {

        //  Nếu là english thì trả về danh sách ngôn ngữ tiếng anh
        if (lang.equals("english")) {
            return shoppingGuideLanguage.getEnglish();
        }

        //  Không thì danh sách ngôn ngữ tiếng việt
        else {
            return shoppingGuideLanguage.getVietnamese();
        }
    }

}
