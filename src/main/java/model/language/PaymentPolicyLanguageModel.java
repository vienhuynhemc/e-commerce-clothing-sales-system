package model.language;

import beans.language.PaymentPolicyLanguage;

import java.util.Map;

public class PaymentPolicyLanguageModel {

    //  Tạo thể hiện cho lớp
    private static PaymentPolicyLanguageModel paymentPolicyLanguageModel;

    //  Class này có một thằng beans là PaymentPolicyLanguageModel
    private PaymentPolicyLanguage paymentPolicyLanguage;

    //  Constructor tạo beaans
    private PaymentPolicyLanguageModel() {

        paymentPolicyLanguage = new PaymentPolicyLanguage();

    }

    //  Phương thức lấy thể hiện
    public static PaymentPolicyLanguageModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (paymentPolicyLanguageModel == null) {
            paymentPolicyLanguageModel = new PaymentPolicyLanguageModel();
        }

        //  Trả về thể hiện
        return paymentPolicyLanguageModel;

    }

    //  Phương thức lấy về danh sách ngôn ngữ
    public Map<String, String> getList(String lang) {

        //  Nếu là english thì trả về danh sách ngôn ngữ tiếng anh
        if (lang.equals("english")) {
            return paymentPolicyLanguage.getEnglish();
        }

        //  Không thì danh sách ngôn ngữ tiếng việt
        else {
            return paymentPolicyLanguage.getVietnamese();
        }
    }

}
