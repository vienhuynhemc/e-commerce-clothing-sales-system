package model;

import beans.IndexLanguage;

import java.util.Map;

public class IndexLanguageModel {

    //  Tạo thể hiện cho lớp
    private static IndexLanguageModel indexLanguageModel;

    //  Class này có một thằng beans là indexlanguage
    private IndexLanguage indexLanguage;

    //  Constructor tạo beaans
    private IndexLanguageModel() {

        indexLanguage = new IndexLanguage();

    }

    //  Phương thức lấy thể hiện
    public static IndexLanguageModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (indexLanguageModel == null) {
            indexLanguageModel = new IndexLanguageModel();
        }

        //  Trả về thể hiện
        return indexLanguageModel;

    }

    //  Phương thức lấy về danh sách ngôn ngữ
    public Map<String, String> getList(String lang) {

        //  Nếu là english thì trả về danh sách ngôn ngữ tiếng anh
        if (lang.equals("english")) {
            return indexLanguage.getEnglish();
        }

        //  Không thì danh sách ngôn ngữ tiếng việt
        else {
            return indexLanguage.getVietnamese();
        }
    }

}
