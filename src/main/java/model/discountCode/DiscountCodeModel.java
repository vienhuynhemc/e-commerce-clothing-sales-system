package model.discountCode;

import beans.BeansConfiguration;
import beans.DateTime;
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
    public void update() {

        //  Mượn discountcode works with database
        DiscountCodeWorksWithDatabase discountCodeWorksWithDatabase = DiscountCodeDataSource.getInstance().getDiscountCodeWorksWithDatabase();

        //  update
        discountCodeWorksWithDatabase.update();

        //  Có mượn thì có trả
        DiscountCodeDataSource.getInstance().releaseDiscountCodeWorksWithDatabase(discountCodeWorksWithDatabase);

    }

    //  Hàm này trả về list mã giảm giá dựa trên các tham số truyền vào: bộ lọc, sort, search and numberOfPage
    public List<DiscountCode> getListDiscountCodeFromAll(String selectSearchAndSort, String sort, String search, int numberOfPage, int nowPage) {

        //  Mượn discountcode works with database
        DiscountCodeWorksWithDatabase discountCodeWorksWithDatabase = DiscountCodeDataSource.getInstance().getDiscountCodeWorksWithDatabase();

        //  Lấy list first
        List<DiscountCode> resultList = discountCodeWorksWithDatabase.getListDiscountCodeFromAll(selectSearchAndSort, sort, search, numberOfPage, nowPage);

        //  Có mượn thì có trả
        DiscountCodeDataSource.getInstance().releaseDiscountCodeWorksWithDatabase(discountCodeWorksWithDatabase);

        //  Trả về kết quả
        return resultList;

    }

    //  Hàm này trả về số lượng tối đa mã giảm giá
    public int getMaximunDiscountCodeFromAll(String selectSearchAndSort, String search) {

        //  Mượn discountcode works with database
        DiscountCodeWorksWithDatabase discountCodeWorksWithDatabase = DiscountCodeDataSource.getInstance().getDiscountCodeWorksWithDatabase();

        //  Lấy maximun number of pages
        int result = discountCodeWorksWithDatabase.getMaximunDiscountCodeFromAll(selectSearchAndSort, search);

        //  Có mượn thì có trả
        DiscountCodeDataSource.getInstance().releaseDiscountCodeWorksWithDatabase(discountCodeWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

    //  Phương thức lấy mã mã giảm giá tiếp theo
    public String getNextDiscountCodeId() {

        //  Mượn discountcode works with database
        DiscountCodeWorksWithDatabase discountCodeWorksWithDatabase = DiscountCodeDataSource.getInstance().getDiscountCodeWorksWithDatabase();

        //  Lấy mã hãng sản xuất tiếp theo
        String result = discountCodeWorksWithDatabase.getNextDiscountCodeId();

        //  Có mượn thì có trả
        DiscountCodeDataSource.getInstance().releaseDiscountCodeWorksWithDatabase(discountCodeWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

    //   Phương thức nhận vào mã nhập, kiểm tra mã nhập này đã tồn tại trong cơ sở dữ liệu hay chưa với những mã giảm giá còn hoạt động
    public boolean isInDatabaseWithExists(String name) {

        //  Mượn discountcode works with database
        DiscountCodeWorksWithDatabase discountCodeWorksWithDatabase = DiscountCodeDataSource.getInstance().getDiscountCodeWorksWithDatabase();

        //  Lấy kết quả
        boolean result = discountCodeWorksWithDatabase.isInDatabaseWithExists(name);

        //  Có mượn thì có trả
        DiscountCodeDataSource.getInstance().releaseDiscountCodeWorksWithDatabase(discountCodeWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

    //  Phương thức nhận vào 1 type có kiểu là String, trả về số nguyên tương tứng
    public int coverTypeFromStringToInt(String type) {

        if (type.equals("mpvc")) return 0;
        else if (type.equals("ggtpt")) return 2;
        else return 1;

    }

    //  Phương thức thêm một mã giảm giá vô cơ sở dữ liệu
    public boolean addDiscountCode(String ma_mgg, int kieu_mgg, int gia_tri, int so_lan_su_dung, int so_lan_su_dung_toi_da, DateTime han_su_dung, DateTime ngay_tao, int ton_tai, String ma_nhap, int trang_thai_su_dung) {

        //  Mượn discountcode works with database
        DiscountCodeWorksWithDatabase discountCodeWorksWithDatabase = DiscountCodeDataSource.getInstance().getDiscountCodeWorksWithDatabase();

        //  Lấy kết quả
        boolean result = discountCodeWorksWithDatabase.addDiscountCode(ma_mgg, kieu_mgg, gia_tri, so_lan_su_dung, so_lan_su_dung_toi_da, han_su_dung, ngay_tao, ton_tai, ma_nhap, trang_thai_su_dung);

        //  Có mượn thì có trả
        DiscountCodeDataSource.getInstance().releaseDiscountCodeWorksWithDatabase(discountCodeWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

    //  Phương thức nhận vào mã mgg, xóa nó trong cơ sở dữ liệu
    public boolean removeOneDiscountCodeInDatabase(String id) {

        //  Mượn discountcode works with database
        DiscountCodeWorksWithDatabase discountCodeWorksWithDatabase = DiscountCodeDataSource.getInstance().getDiscountCodeWorksWithDatabase();

        //  update xóa nó trong cơ sở dữ liệu
        boolean result = discountCodeWorksWithDatabase.removeOneDiscountCodeInDatabase(id);

        //  Có mượn thì có trả
        DiscountCodeDataSource.getInstance().releaseDiscountCodeWorksWithDatabase(discountCodeWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

    //  Phương thức nhận vào list mã mgg, xóa nó trong cơ sở dữ liệu
    public int removeGroupDiscountCodeInDatabase(String[] discountCodeIds) {

        //  Mượn discountcode works with database
        DiscountCodeWorksWithDatabase discountCodeWorksWithDatabase = DiscountCodeDataSource.getInstance().getDiscountCodeWorksWithDatabase();

        //  update xóa nó trong cơ sở dữ liệu
        int result = discountCodeWorksWithDatabase.removeGroupDiscountCodeInDatabase(discountCodeIds);

        //  Có mượn thì có trả
        DiscountCodeDataSource.getInstance().releaseDiscountCodeWorksWithDatabase(discountCodeWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

    //  Phương thức nhận vào mã mgg, xem thử nó còn tồn tại hay không
    public boolean isExistsInDatabaseWithId(String id){

        //  Mượn discountcode works with database
        DiscountCodeWorksWithDatabase discountCodeWorksWithDatabase = DiscountCodeDataSource.getInstance().getDiscountCodeWorksWithDatabase();

        //  lấy kết quả
        boolean result = discountCodeWorksWithDatabase.isExistsInDatabaseWithId(id);

        //  Có mượn thì có trả
        DiscountCodeDataSource.getInstance().releaseDiscountCodeWorksWithDatabase(discountCodeWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

    //  Phương thức nhận vào name và id, xem thử ngoài id đó ra còn id nào có name như v nữa không
    public boolean isInDatabaseWithNameAndId(String name ,String id){

        //  Mượn discountcode works with database
        DiscountCodeWorksWithDatabase discountCodeWorksWithDatabase = DiscountCodeDataSource.getInstance().getDiscountCodeWorksWithDatabase();

        //  lấy kết quả
        boolean result = discountCodeWorksWithDatabase.isInDatabaseWithNameAndId(name,id);

        //  Có mượn thì có trả
        DiscountCodeDataSource.getInstance().releaseDiscountCodeWorksWithDatabase(discountCodeWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

    //  Phương thức cập nhập mã giảm giá
    public boolean editDiscountCode(String ma_mgg, int kieu_mgg, int gia_tri, int so_lan_su_dung, int so_lan_su_dung_toi_da, DateTime han_su_dung, String ngay_tao, int ton_tai, String ma_nhap, int trang_thai_su_dung) {

        //  Mượn discountcode works with database
        DiscountCodeWorksWithDatabase discountCodeWorksWithDatabase = DiscountCodeDataSource.getInstance().getDiscountCodeWorksWithDatabase();

        //  Lấy kết quả
        boolean result = discountCodeWorksWithDatabase.editDiscountCode(ma_mgg, kieu_mgg, gia_tri, so_lan_su_dung, so_lan_su_dung_toi_da, han_su_dung, ngay_tao, ton_tai, ma_nhap, trang_thai_su_dung);

        //  Có mượn thì có trả
        DiscountCodeDataSource.getInstance().releaseDiscountCodeWorksWithDatabase(discountCodeWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

}

