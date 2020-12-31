package model.discountCode;

public class DiscountCodeModel {

    //  Tạo thể hiện cho lớp
    private static DiscountCodeModel discountCodeModel;

    //  Phương thức lấy thể hiện
    public static DiscountCodeModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (discountCodeModel == null) {
            discountCodeModel = new DiscountCodeModel();
        }

        //  Trả về thể hiện
        return discountCodeModel;

    }

}
