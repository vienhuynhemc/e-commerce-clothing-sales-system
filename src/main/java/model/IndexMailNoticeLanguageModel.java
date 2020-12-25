package model;

import beans.IndexMailNoticeLanguage;

import java.util.Map;

public class IndexMailNoticeLanguageModel {

    //  Tạo thể hiện cho lớp
    private static IndexMailNoticeLanguageModel indexMailNoticeLanguageModel;

    //  Class này có một thằng beans là footerlanguage
    private IndexMailNoticeLanguage indexMailNoticeLanguage;

    //  Constructor tạo beaans
    private IndexMailNoticeLanguageModel() {

        indexMailNoticeLanguage = new IndexMailNoticeLanguage();

    }

    //  Phương thức lấy thể hiện
    public static IndexMailNoticeLanguageModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (indexMailNoticeLanguageModel == null) {
            indexMailNoticeLanguageModel = new IndexMailNoticeLanguageModel();
        }

        //  Trả về thể hiện
        return indexMailNoticeLanguageModel;

    }

    //  Phương thức lấy về danh sách ngôn ngữ
    public Map<String, String> getList(String lang) {

        //  Nếu là english thì trả về danh sách ngôn ngữ tiếng anh
        if (lang.equals("english")) {
            return indexMailNoticeLanguage.getEnglish();
        }

        //  Không thì danh sách ngôn ngữ tiếng việt
        else {
            return indexMailNoticeLanguage.getVietnamese();
        }
    }


}
