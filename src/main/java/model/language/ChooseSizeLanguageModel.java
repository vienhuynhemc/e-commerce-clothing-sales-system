package model.language;

import beans.language.ChooseSizeLanguage;

import java.util.Map;

public class ChooseSizeLanguageModel {

    //  Tạo thể hiện cho lớp
    private static ChooseSizeLanguageModel chooseSizeLanguageModel;

    //  Class này có một thằng beans là chooseSizeLanguageModel
    private ChooseSizeLanguage chooseSizeLanguage;

    //  Constructor tạo beaans
    private ChooseSizeLanguageModel() {

        chooseSizeLanguage = new ChooseSizeLanguage();

    }

    //  Phương thức lấy thể hiện
    public static ChooseSizeLanguageModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (chooseSizeLanguageModel == null) {
            chooseSizeLanguageModel = new ChooseSizeLanguageModel();
        }

        //  Trả về thể hiện
        return chooseSizeLanguageModel;

    }

    //  Phương thức lấy về danh sách ngôn ngữ
    public Map<String, String> getList(String lang) {

        //  Nếu là english thì trả về danh sách ngôn ngữ tiếng anh
        if (lang.equals("english")) {
            return chooseSizeLanguage.getEnglish();
        }

        //  Không thì danh sách ngôn ngữ tiếng việt
        else {
            return chooseSizeLanguage.getVietnamese();
        }
    }

}
