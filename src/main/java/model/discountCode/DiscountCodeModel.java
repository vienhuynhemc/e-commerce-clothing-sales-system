package model.discountCode;

import beans.BeansConfiguration;
import beans.discountCode.DiscountCode;
import worksWithDatabase.discountCode.DiscountCodeDataSource;
import worksWithDatabase.discountCode.DiscountCodeWorksWithDatabase;

import java.util.List;

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

    //  Phương thức nhận vào 1 số nguyên trả về type
    public String getType(int type) {
        if (type == 0) return "MPVC";
        else if (type == 1) return "VND";
        else return "%";
    }

    //  Phương thức trả về list discount code ban đầu để đổ dữ liêu ra, lúc khởi tạo trang
    public List<DiscountCode> getListDiscountCodeFirst(int numberOfPage) {

        //  Mượn discount code works with database
        DiscountCodeWorksWithDatabase discountCodeWorksWithDatabase = DiscountCodeDataSource.getInstance().getDiscountCodeWorksWithDatabase();

        //  Lấy list first
        List<DiscountCode> resultList = discountCodeWorksWithDatabase.getListDiscountCodeFirst(numberOfPage);

        //  Có mượn thì có trả
        DiscountCodeDataSource.getInstance().releaseDiscountCodeWorksWithDatabase(discountCodeWorksWithDatabase);

        //  Trả về kết quả
        return resultList;

    }

    //  Hàm này trả về số lượng tối đa mã giảm giá ban đầu
    public int getMaximunDiscountCode() {

        //  Mượn discountcode works with database
        DiscountCodeWorksWithDatabase discountCodeWorksWithDatabase = DiscountCodeDataSource.getInstance().getDiscountCodeWorksWithDatabase();

        //  Lấy maximun number of pages
        int result = discountCodeWorksWithDatabase.getMaximunDiscountCode();

        //  Có mượn thì có trả
        DiscountCodeDataSource.getInstance().releaseDiscountCodeWorksWithDatabase(discountCodeWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

    //  Phương thức nhận vô số mgg tối đa, trả về số trang tối đa
    public int getMaximunNumberOfPage(int maximunDiscountCode) {

        return maximunDiscountCode % BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_MGG > 0 ? maximunDiscountCode / BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_MGG + 1 : maximunDiscountCode / BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_MGG;

    }

    //  Phương thức update lại bảng mã giảm giá  ngay lúc gọi
    public void update(){

        //  Mượn discountcode works with database
        DiscountCodeWorksWithDatabase discountCodeWorksWithDatabase = DiscountCodeDataSource.getInstance().getDiscountCodeWorksWithDatabase();

        //  update
        discountCodeWorksWithDatabase.update();

        //  Có mượn thì có trả
        DiscountCodeDataSource.getInstance().releaseDiscountCodeWorksWithDatabase(discountCodeWorksWithDatabase);

    }

}

