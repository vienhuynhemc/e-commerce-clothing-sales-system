package model.language;

import beans.language.MembershipPolicyLanguage;

import java.util.Map;

public class MembershipPolicyLanguageModel {

    //  Tạo thể hiện cho lớp
    private static MembershipPolicyLanguageModel membershipPolicyLanguageModel;

    //  Class này có một thằng beans là MembershipPolicyLanguageModel
    private MembershipPolicyLanguage membershipPolicyLanguage;

    //  Constructor tạo beaans
    private MembershipPolicyLanguageModel() {

        membershipPolicyLanguage = new MembershipPolicyLanguage();

    }

    //  Phương thức lấy thể hiện
    public static MembershipPolicyLanguageModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (membershipPolicyLanguageModel == null) {
            membershipPolicyLanguageModel = new MembershipPolicyLanguageModel();
        }

        //  Trả về thể hiện
        return membershipPolicyLanguageModel;

    }

    //  Phương thức lấy về danh sách ngôn ngữ
    public Map<String, String> getList(String lang) {

        //  Nếu là english thì trả về danh sách ngôn ngữ tiếng anh
        if (lang.equals("english")) {
            return membershipPolicyLanguage.getEnglish();
        }

        //  Không thì danh sách ngôn ngữ tiếng việt
        else {
            return membershipPolicyLanguage.getVietnamese();
        }
    }


}
