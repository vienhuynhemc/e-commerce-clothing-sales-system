package model.language;


import beans.language.ChangInfoCustomerLanguage;

import java.util.Map;

public class ChangInfoCustomerLanguageModel {
    //  Tạo thể hiện cho lớp
    private static ChangInfoCustomerLanguageModel loginLanguageModel;

    //  Class này có một thằng beans là footerlanguage
    private ChangInfoCustomerLanguage changInfoCustomerLanguage;

    //  Constructor tạo beaans
    private ChangInfoCustomerLanguageModel() {

        changInfoCustomerLanguage = new ChangInfoCustomerLanguage();

    }
    public static ChangInfoCustomerLanguageModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (loginLanguageModel == null) {
            loginLanguageModel = new ChangInfoCustomerLanguageModel();
        }

        //  Trả về thể hiện
        return loginLanguageModel;

    }
    public Map<String, String> getList(String lang) {

        //  Nếu là english thì trả về danh sách ngôn ngữ tiếng anh
        if (lang.equals("english")) {
            return changInfoCustomerLanguage.getEnglish();
        }

        //  Không thì danh sách ngôn ngữ tiếng việt
        else {
            return changInfoCustomerLanguage.getVietnamese();
        }
    }
}
