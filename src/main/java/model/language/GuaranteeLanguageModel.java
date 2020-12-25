package model.language;

import beans.language.GuaranteeLanguage;
import beans.language.PaymentPolicyLanguage;

import java.util.Map;

public class GuaranteeLanguageModel {

    //  Tạo thể hiện cho lớp
    private static GuaranteeLanguageModel guaranteeLanguageModel;

    //  Class này có một thằng beans là GuaranteeLanguageModel
    private GuaranteeLanguage guaranteeLanguage;

    //  Constructor tạo beaans
    private GuaranteeLanguageModel() {

        guaranteeLanguage = new GuaranteeLanguage();

    }

    //  Phương thức lấy thể hiện
    public static GuaranteeLanguageModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (guaranteeLanguageModel == null) {
            guaranteeLanguageModel = new GuaranteeLanguageModel();
        }

        //  Trả về thể hiện
        return guaranteeLanguageModel;

    }

    //  Phương thức lấy về danh sách ngôn ngữ
    public Map<String, String> getList(String lang) {

        //  Nếu là english thì trả về danh sách ngôn ngữ tiếng anh
        if (lang.equals("english")) {
            return guaranteeLanguage.getEnglish();
        }

        //  Không thì danh sách ngôn ngữ tiếng việt
        else {
            return guaranteeLanguage.getVietnamese();
        }
    }

}
