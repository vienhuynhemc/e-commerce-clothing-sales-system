package model.manufacturer;

import beans.BeansConfiguration;
import beans.manufacturer.Manufacturer;
import beans.productAdmin.ProductAdmin;
import worksWithDatabase.manufacturer.ManufacturerDataSource;
import worksWithDatabase.manufacturer.ManufacturerWorksWithDatabase;

import java.util.List;

public class ManufacturerModel {

    //  Tạo thể hiện cho lớp
    private static ManufacturerModel manufacturerModel;

    //  Phương thức lấy thể hiện
    public static ManufacturerModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (manufacturerModel == null) {
            manufacturerModel = new ManufacturerModel();
        }

        //  Trả về thể hiện
        return manufacturerModel;

    }

    //  Phương thức trả về list manufacturer ban đầu để đổ dữ liêu ra, lúc khởi tạo trang
    public List<Manufacturer> getListManufacturerFirst(int numberOfPage) {

        //  Mượn manufacturer works with database
        ManufacturerWorksWithDatabase manufacturerWorksWithDatabase = ManufacturerDataSource.getInstance().getManufacturerWorksWithDatabase();

        //  Lấy list first
        List<Manufacturer> resultList = manufacturerWorksWithDatabase.getListManufacturerFirst(numberOfPage);

        //  Có mượn thì có trả
        ManufacturerDataSource.getInstance().releaseManufacturerWorksWithDatabase(manufacturerWorksWithDatabase);

        //  Trả về kết quả
        return resultList;

    }

    //  Hàm này trả về số lượng tối đa hãng sản xuất ban đầu
    public int getMaximunManufacturer() {

        //  Mượn manufacturer works with database
        ManufacturerWorksWithDatabase manufacturerWorksWithDatabase = ManufacturerDataSource.getInstance().getManufacturerWorksWithDatabase();

        //  Lấy maximun number of pages
        int result = manufacturerWorksWithDatabase.getMaximunManufacturer();

        //  Có mượn thì có trả
        ManufacturerDataSource.getInstance().releaseManufacturerWorksWithDatabase(manufacturerWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

    //  Phương thức nhận vô số hãng sản xuất tối đa, trả về số trang tối đa
    public int getMaximunNumberOfPage(int maximunManufacturer) {

        return maximunManufacturer % BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_HSX > 0 ? maximunManufacturer / BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_HSX + 1 : maximunManufacturer / BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_HSX;

    }

    //  Hàm này trả về số nhà sản xuất dựa trên các tham số truyền vào: bộ lọc, sort, search and numberOfPage
    public List<Manufacturer> getListManufacturerFromAll(String selectSearchAndSort, String sort, String search, int numberOfPage, int nowPage) {

        //  Mượn manufacturer works with database
        ManufacturerWorksWithDatabase manufacturerWorksWithDatabase = ManufacturerDataSource.getInstance().getManufacturerWorksWithDatabase();

        //  Lấy list first
        List<Manufacturer> resultList = manufacturerWorksWithDatabase.getListManufacturerFromAll(selectSearchAndSort, sort, search, numberOfPage, nowPage);

        //  Có mượn thì có trả
        ManufacturerDataSource.getInstance().releaseManufacturerWorksWithDatabase(manufacturerWorksWithDatabase);

        //  Trả về kết quả
        return resultList;

    }

    //  Hàm này trả về số lượng tối đa hãng sản xuất
    public int getMaximunManufacturerFromAll(String selectSearchAndSort, String search) {

        //  Mượn manufacturer works with database
        ManufacturerWorksWithDatabase manufacturerWorksWithDatabase = ManufacturerDataSource.getInstance().getManufacturerWorksWithDatabase();

        //  Lấy maximun number of pages
        int result = manufacturerWorksWithDatabase.getMaximunManufacturerFromAll(selectSearchAndSort, search);

        //  Có mượn thì có trả
        ManufacturerDataSource.getInstance().releaseManufacturerWorksWithDatabase(manufacturerWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

    //  Phương thức nhận vào mã hãng sản xuất, xóa nó trong cơ sở dữ liệu
    public boolean removeOneManufacturerInDatabase(String maufacturerId) {

        //  Mượn manufacturer works with database
        ManufacturerWorksWithDatabase manufacturerWorksWithDatabase = ManufacturerDataSource.getInstance().getManufacturerWorksWithDatabase();

        //  update xóa nó trong cơ sở dữ liệu
        boolean result = manufacturerWorksWithDatabase.removeOneManufacturerInDatabase(maufacturerId);

        //  Có mượn thì có trả
        ManufacturerDataSource.getInstance().releaseManufacturerWorksWithDatabase(manufacturerWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

    //  Phương thức nhận vào list mã hãng sản xuất, xóa nó trong cơ sở dữ liệu
    public int removeGroupManufacturerInDatabase(String[] manufacturerIds) {

        //  Mượn manufacturer works with database
        ManufacturerWorksWithDatabase manufacturerWorksWithDatabase = ManufacturerDataSource.getInstance().getManufacturerWorksWithDatabase();

        //  update xóa nó trong cơ sở dữ liệu
        int result = manufacturerWorksWithDatabase.removeGroupManufacturerInDatabase(manufacturerIds);

        //  Có mượn thì có trả
        ManufacturerDataSource.getInstance().releaseManufacturerWorksWithDatabase(manufacturerWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

    //  Phương thức lấy mã hãng sản xuất tiếp theo
    public String getNextManufacturerId() {

        //  Mượn manufacturer works with database
        ManufacturerWorksWithDatabase manufacturerWorksWithDatabase = ManufacturerDataSource.getInstance().getManufacturerWorksWithDatabase();

        //  Lấy mã hãng sản xuất tiếp theo
        String result = manufacturerWorksWithDatabase.getNextManufacturerId();

        //  Có mượn thì có trả
        ManufacturerDataSource.getInstance().releaseManufacturerWorksWithDatabase(manufacturerWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

    //  Phương thức thêm một hãng sản xuất mới vào database , nhận vào id và name hãng sản xuất
    public boolean addManufacturerToDatabase(String manufacturerId, String manufacturerName) {

        //  Mượn manufacturer works with database
        ManufacturerWorksWithDatabase manufacturerWorksWithDatabase = ManufacturerDataSource.getInstance().getManufacturerWorksWithDatabase();

        //  Lấy kết quả add
        boolean result = manufacturerWorksWithDatabase.addManufacturerToDatabase(manufacturerId, manufacturerName);

        //  Có mượn thì có trả
        ManufacturerDataSource.getInstance().releaseManufacturerWorksWithDatabase(manufacturerWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

    //  Phương thức cập nhập lại hãng sản xuất nhận vào mã hãng và tên hãng
    public boolean updateManufacturer(String manufacturerId, String manufacturerName) {

        //  Mượn manufacturer works with database
        ManufacturerWorksWithDatabase manufacturerWorksWithDatabase = ManufacturerDataSource.getInstance().getManufacturerWorksWithDatabase();

        //  Lấy kết quả edit
        boolean result = manufacturerWorksWithDatabase.updateManufacturer(manufacturerId, manufacturerName);
        //  Có mượn thì có trả
        ManufacturerDataSource.getInstance().releaseManufacturerWorksWithDatabase(manufacturerWorksWithDatabase);

        //  Trả về kết quả
        return result;

    }

    //  Phương thức nhận vô list product admin fill tên hãng sản xuất
    public void fillNameManufactureProductAdmin(List<ProductAdmin> products){
        //  Mượn manufacturer works with database
        ManufacturerWorksWithDatabase manufacturerWorksWithDatabase = ManufacturerDataSource.getInstance().getManufacturerWorksWithDatabase();

        //  Lấy kết quả edit
        manufacturerWorksWithDatabase.fillNameManufactureProductAdmin(products);
        //  Có mượn thì có trả
        ManufacturerDataSource.getInstance().releaseManufacturerWorksWithDatabase(manufacturerWorksWithDatabase);
    }

}