package worksWithDatabase.manufacturer;

import beans.BeansConfiguration;
import beans.DateTime;
import beans.manufacturer.Manufacturer;
import connectionDatabase.DataSource;
import worksWithDatabase.manufacturerInformation.ManufacturerInformationDataSource;
import worksWithDatabase.manufacturerInformation.ManufacturerInformationWorksWithDatabase;
import worksWithDatabase.productDetailInformation.ProductDetailInformationDataSource;
import worksWithDatabase.productDetailInformation.ProductDetailInformationWorksWithDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManufacturerWorksWithDatabase {

    //  Constructor rỗng không có gì hết
    ManufacturerWorksWithDatabase() {
    }

    //  Phương thức lấy list hãng sản xuất ban đầu, lúc khởi tạo trang
    public List<Manufacturer> getListManufacturerFirst(int linesPerPage) {

        //  Khởi tạo list result
        List<Manufacturer> resultList = new ArrayList<Manufacturer>();

        //  Mượn một connection
        Connection connection = DataSource.getInstance().getConnection();

        try {

            //  Taọ 1 preparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM hang_san_xuat WHERE ton_tai = ? ORDER BY ngay_tao DESC LIMIT 0," + linesPerPage + ";");

            //  set giá trị cho preparedsstatement 0 là tồn tại
            preparedStatement.setInt(1, 0);

            //  Lấy danh sách tương ứng, ở đây là ban đầu nên lấy linesPerPage hãng sản xuất đầu tiên, sắp xếp theo ngày tạo DESC
            ResultSet resultSet = preparedStatement.executeQuery();

            //  Duyệt qua resultset
            while (resultSet.next()) {

                //  Lấy các thông tin hiện có của bản hãng sản xuất
                String manufacturerId = resultSet.getString("ma_hsx");
                String manufacturerName = resultSet.getString("ten_hsx");
                DateTime dateCreated = new DateTime(resultSet.getString("ngay_tao"));
                int exist = resultSet.getInt("ton_tai");

                //--------------lấy list thông tin chi tiết hãng từ bảng chi tiết hãng sản xuất-----------------

                //  Lấy manufacturerInformationWorksWithDatabase
                ManufacturerInformationWorksWithDatabase manufacturerInformationWorksWithDatabase = ManufacturerInformationDataSource.getInstance().getManufacturerInformationWorksWithDatabase();

                //  Lấy danh sách
                List<String> informationList = manufacturerInformationWorksWithDatabase.getListManufacturerInformationById(manufacturerId, connection);

                //  Trả manufacturerInformationWorksWithDatabase
                ManufacturerInformationDataSource.getInstance().releaseManufacturerInformationWorksWithDatabase(manufacturerInformationWorksWithDatabase);

                //--------------------------------------------------------------------------------------------------

                // ----------------Lấy số lượng sản phẩm còn phải của hãng này từ bảng chi tiết sản phẩm----------------

                //  Lấy productDetaiInformationWorksWithDabase
                ProductDetailInformationWorksWithDatabase productDetailInformationWorksWithDatabase = ProductDetailInformationDataSource.getInstance().getProductDetailInformationWorksWithDatabase();

                //  Lấy số lượng sản phẩm
                int nubmerOfProduct = productDetailInformationWorksWithDatabase.getNumberOfProductByManufacturerId(manufacturerId, connection);

                //  Trả productDetaiInformationWorksWithDabase
                ProductDetailInformationDataSource.getInstance().releaseProductDetailInformationWorksWithDatabase(productDetailInformationWorksWithDatabase);

                //--------------------------------------------------------------------------------------------------

                //  Sau khi có đủ thông tin ta thêm hãng sản xuất này vào list kết quả
                resultList.add(new Manufacturer(manufacturerId, manufacturerName, dateCreated, exist, informationList, nubmerOfProduct));

            }

            // Đóng các kết nối
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

        //  Trả connection
        DataSource.getInstance().releaseConnection(connection);

        //  Trả về kết quả
        return resultList;

    }

    //  Phương thức lấy số hsx tối đa của trang quản lý hãng sản xuất không có điều kiện gì cả
    public int getMaximunManufacturer() {

        //  Mượn connection
        Connection connection = DataSource.getInstance().getConnection();

        //  Khai báo kết quả
        int result = 0;

        try {

            //  Taọ 1 preparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(ma_hsx) AS so_luong FROM hang_san_xuat WHERE ton_tai = ?");

            //  set giá trị cho preparedsstatement 0 là tồn tại
            preparedStatement.setInt(1, 0);

            //  Lấy danh sách tương ứng, ở đây là ban đầu nên lấy linesPerPage hãng sản xuất đầu tiên, sắp xếp theo ngày tạo DESC
            ResultSet resultSet = preparedStatement.executeQuery();

            //  Gán co result
            while (resultSet.next()) {
                result = resultSet.getInt("so_luong");
            }

            //  Đóng các kết nối
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

        //  Trả connection
        DataSource.getInstance().releaseConnection(connection);

        //  Trả về kết quả
        return result;

    }

    //  Phương thức lấy list hãng sản xuất từ tất cả điều kiện
    public List<Manufacturer> getListManufacturerFromAll(String selectSearchAndSort, String sort, String search, int linesPerPage ,int nowPage) {

        //  Hàm lấy ra filter tương ứng trong database
        String filter = null;
        switch (selectSearchAndSort) {
            case "dateCreated":
                filter = "ngay_tao";
                break;
            case "manufacturerName":
                filter = "ten_hsx";
                break;
            case "manufacturerId":
                filter = "ma_hsx";
                break;
            case "informationList":
                filter = "so_luong_thong_tin";
                break;
            case "numberOfProducts":
                filter = "so_luong_san_pham";
                break;
        }

        //  Nếu như không phải 2 trường hợp cuối thì ta cứ làm đơn gian vì nó chung bảng
        if(filter.compareTo("so_luong_thong_tin") != 0 && filter.compareTo("so_luong_san_pham") != 0) {


            //  Khởi tạo list result
            List<Manufacturer> resultList = new ArrayList<Manufacturer>();

            //  Mượn một connection
            Connection connection = DataSource.getInstance().getConnection();

            try {

                //  Tọa limit line
                int limitLine = (nowPage-1)*BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_HSX;
                if(limitLine<0) limitLine = 0;

                //  Taọ 1 preparedStatement
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM hang_san_xuat WHERE ton_tai = ? AND "+filter+" LIKE ? ORDER BY "+filter+" "+sort+" LIMIT "+limitLine+" , " + linesPerPage + ";");

                //  set giá trị cho preparedsstatement 0 là tồn tại
                preparedStatement.setInt(1, 0);
                preparedStatement.setString(2,"%"+search+"%");

                //  Lấy danh sách tương ứng, ở đây là ban đầu nên lấy linesPerPage hãng sản xuất đầu tiên, sắp xếp theo ngày tạo DESC
                ResultSet resultSet = preparedStatement.executeQuery();

                //  Duyệt qua resultset
                while (resultSet.next()) {

                    //  Lấy các thông tin hiện có của bản hãng sản xuất
                    String manufacturerId = resultSet.getString("ma_hsx");
                    String manufacturerName = resultSet.getString("ten_hsx");
                    DateTime dateCreated = new DateTime(resultSet.getString("ngay_tao"));
                    int exist = resultSet.getInt("ton_tai");

                    //--------------lấy list thông tin chi tiết hãng từ bảng chi tiết hãng sản xuất-----------------

                    //  Lấy manufacturerInformationWorksWithDatabase
                    ManufacturerInformationWorksWithDatabase manufacturerInformationWorksWithDatabase = ManufacturerInformationDataSource.getInstance().getManufacturerInformationWorksWithDatabase();

                    //  Lấy danh sách
                    List<String> informationList = manufacturerInformationWorksWithDatabase.getListManufacturerInformationById(manufacturerId, connection);

                    //  Trả manufacturerInformationWorksWithDatabase
                    ManufacturerInformationDataSource.getInstance().releaseManufacturerInformationWorksWithDatabase(manufacturerInformationWorksWithDatabase);

                    //--------------------------------------------------------------------------------------------------

                    // ----------------Lấy số lượng sản phẩm còn phải của hãng này từ bảng chi tiết sản phẩm----------------

                    //  Lấy productDetaiInformationWorksWithDabase
                    ProductDetailInformationWorksWithDatabase productDetailInformationWorksWithDatabase = ProductDetailInformationDataSource.getInstance().getProductDetailInformationWorksWithDatabase();

                    //  Lấy số lượng sản phẩm
                    int nubmerOfProduct = productDetailInformationWorksWithDatabase.getNumberOfProductByManufacturerId(manufacturerId, connection);

                    //  Trả productDetaiInformationWorksWithDabase
                    ProductDetailInformationDataSource.getInstance().releaseProductDetailInformationWorksWithDatabase(productDetailInformationWorksWithDatabase);

                    //--------------------------------------------------------------------------------------------------

                    //  Sau khi có đủ thông tin ta thêm hãng sản xuất này vào list kết quả
                    resultList.add(new Manufacturer(manufacturerId, manufacturerName, dateCreated, exist, informationList, nubmerOfProduct));

                }

                // Đóng các kết nối
                resultSet.close();
                preparedStatement.close();

            } catch (SQLException throwables) {

                throwables.printStackTrace();

            }

            //  Trả connection
            DataSource.getInstance().releaseConnection(connection);

            //  Trả về kết quả
            return resultList;

        }else if(filter.equals("so_luong_thong_tin")){

            //  Khởi tạo list result
            List<Manufacturer> resultList = new ArrayList<Manufacturer>();

            //  Mượn một connection
            Connection connection = DataSource.getInstance().getConnection();

            try {

                //  Tọa limit line
                int limitLine = (nowPage-1)*BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_HSX;
                if(limitLine<0) limitLine = 0;

                //  Taọ 1 preparedStatement
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT t.ma_hsx,t.ngay_tao,t.ten_hsx,t.ton_tai, t.so_luong_chi_tiet FROM\n" +
                        "(SELECT h.ma_hsx,h.ngay_tao,h.ten_hsx,h.ton_tai, COUNT(c.chi_tiet) as so_luong_chi_tiet FROM hang_san_xuat h JOIN chi_tiet_hsx c ON h.ma_hsx = c.ma_hsx\n" +
                        "WHERE h.ton_tai = ?\n" +
                        "GROUP BY h.ma_hsx,h.ngay_tao,h.ten_hsx\n" +
                        "ORDER BY so_luong_chi_tiet "+sort+") t\n" +
                        "WHERE t.so_luong_chi_tiet LIKE ? LIMIT "+limitLine+" , "+ BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_HSX);

                //  set giá trị cho preparedsstatement 0 là tồn tại
                preparedStatement.setInt(1, 0);
                preparedStatement.setString(2,"%"+search+"%");

                //  Lấy danh sách tương ứng, ở đây là ban đầu nên lấy linesPerPage hãng sản xuất đầu tiên, sắp xếp theo ngày tạo DESC
                ResultSet resultSet = preparedStatement.executeQuery();

                //  Duyệt qua resultset
                while (resultSet.next()) {

                    //  Lấy các thông tin hiện có của bản hãng sản xuất
                    String manufacturerId = resultSet.getString("ma_hsx");
                    String manufacturerName = resultSet.getString("ten_hsx");
                    DateTime dateCreated = new DateTime(resultSet.getString("ngay_tao"));
                    int exist = resultSet.getInt("ton_tai");

                    //--------------lấy list thông tin chi tiết hãng từ bảng chi tiết hãng sản xuất-----------------

                    //  Lấy manufacturerInformationWorksWithDatabase
                    ManufacturerInformationWorksWithDatabase manufacturerInformationWorksWithDatabase = ManufacturerInformationDataSource.getInstance().getManufacturerInformationWorksWithDatabase();

                    //  Lấy danh sách
                    List<String> informationList = manufacturerInformationWorksWithDatabase.getListManufacturerInformationById(manufacturerId, connection);

                    //  Trả manufacturerInformationWorksWithDatabase
                    ManufacturerInformationDataSource.getInstance().releaseManufacturerInformationWorksWithDatabase(manufacturerInformationWorksWithDatabase);

                    //--------------------------------------------------------------------------------------------------

                    // ----------------Lấy số lượng sản phẩm còn phải của hãng này từ bảng chi tiết sản phẩm----------------

                    //  Lấy productDetaiInformationWorksWithDabase
                    ProductDetailInformationWorksWithDatabase productDetailInformationWorksWithDatabase = ProductDetailInformationDataSource.getInstance().getProductDetailInformationWorksWithDatabase();

                    //  Lấy số lượng sản phẩm
                    int nubmerOfProduct = productDetailInformationWorksWithDatabase.getNumberOfProductByManufacturerId(manufacturerId, connection);

                    //  Trả productDetaiInformationWorksWithDabase
                    ProductDetailInformationDataSource.getInstance().releaseProductDetailInformationWorksWithDatabase(productDetailInformationWorksWithDatabase);

                    //--------------------------------------------------------------------------------------------------

                    //  Sau khi có đủ thông tin ta thêm hãng sản xuất này vào list kết quả
                    resultList.add(new Manufacturer(manufacturerId, manufacturerName, dateCreated, exist, informationList, nubmerOfProduct));

                }

                // Đóng các kết nối
                resultSet.close();
                preparedStatement.close();

            } catch (SQLException throwables) {

                throwables.printStackTrace();

            }

            //  Trả connection
            DataSource.getInstance().releaseConnection(connection);

            //  Trả về kết quả
            return resultList;

        }else{

            //  Khởi tạo list result
            List<Manufacturer> resultList = new ArrayList<Manufacturer>();

            //  Mượn một connection
            Connection connection = DataSource.getInstance().getConnection();

            try {

                //  Tọa limit line
                int limitLine = (nowPage-1)*BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_HSX;
                if(limitLine<0) limitLine = 0;

                //  Taọ 1 preparedStatement
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT t2.ma_hsx,t2.ngay_tao,t2.ten_hsx,t2.ton_tai,t2.so_luong\n" +
                                "FROM(\n" +
                                "SELECT t.ma_hsx,t.ngay_tao,t.ten_hsx,t.ton_tai,\n" +
                                "CASE \n" +
                                "WHEN t.tong_so_luong IS NULL THEN 0\n" +
                                "ELSE t.tong_so_luong\n" +
                                "END AS so_luong\n" +
                                "FROM\n" +
                                "(SELECT h.ma_hsx,h.ngay_tao, h.ten_hsx, h.ton_tai,\n" +
                                "\n" +
                                "(SELECT SUM(sp.so_luong_con_lai) FROM san_pham s JOIN thong_tin_chi_tiet_sp sp ON s.ma_sp =sp.ma_sp\n" +
                                "\tWHERE s.ma_hsx = h.ma_hsx\n" +
                                "\tAND sp.ton_tai = ?\n" +
                                "\tGROUP BY s.ma_sp\n" +
                                ") AS tong_so_luong\n" +
                                "\n" +
                                "FROM hang_san_xuat h\n" +
                                "WHERE h.ton_tai = ?) t\n" +
                                ") t2\n" +
                                "WHERE t2.so_luong LIKE ? ORDER BY t2.so_luong " +sort+"\n"+
                                "LIMIT "+limitLine+" , "+ BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_HSX);

                //  set giá trị cho preparedsstatement 0 là tồn tại
                preparedStatement.setInt(1, 0);
                preparedStatement.setInt(2, 0);
                preparedStatement.setString(3,"%"+search+"%");

                //  Lấy danh sách tương ứng, ở đây là ban đầu nên lấy linesPerPage hãng sản xuất đầu tiên, sắp xếp theo ngày tạo DESC
                ResultSet resultSet = preparedStatement.executeQuery();

                //  Duyệt qua resultset
                while (resultSet.next()) {

                    //  Lấy các thông tin hiện có của bản hãng sản xuất
                    String manufacturerId = resultSet.getString("ma_hsx");
                    String manufacturerName = resultSet.getString("ten_hsx");
                    DateTime dateCreated = new DateTime(resultSet.getString("ngay_tao"));
                    int exist = resultSet.getInt("ton_tai");

                    //--------------lấy list thông tin chi tiết hãng từ bảng chi tiết hãng sản xuất-----------------

                    //  Lấy manufacturerInformationWorksWithDatabase
                    ManufacturerInformationWorksWithDatabase manufacturerInformationWorksWithDatabase = ManufacturerInformationDataSource.getInstance().getManufacturerInformationWorksWithDatabase();

                    //  Lấy danh sách
                    List<String> informationList = manufacturerInformationWorksWithDatabase.getListManufacturerInformationById(manufacturerId, connection);

                    //  Trả manufacturerInformationWorksWithDatabase
                    ManufacturerInformationDataSource.getInstance().releaseManufacturerInformationWorksWithDatabase(manufacturerInformationWorksWithDatabase);

                    //--------------------------------------------------------------------------------------------------

                    // ----------------Lấy số lượng sản phẩm còn phải của hãng này từ bảng chi tiết sản phẩm----------------

                    //  Lấy productDetaiInformationWorksWithDabase
                    ProductDetailInformationWorksWithDatabase productDetailInformationWorksWithDatabase = ProductDetailInformationDataSource.getInstance().getProductDetailInformationWorksWithDatabase();

                    //  Lấy số lượng sản phẩm
                    int nubmerOfProduct = productDetailInformationWorksWithDatabase.getNumberOfProductByManufacturerId(manufacturerId, connection);

                    //  Trả productDetaiInformationWorksWithDabase
                    ProductDetailInformationDataSource.getInstance().releaseProductDetailInformationWorksWithDatabase(productDetailInformationWorksWithDatabase);

                    //--------------------------------------------------------------------------------------------------

                    //  Sau khi có đủ thông tin ta thêm hãng sản xuất này vào list kết quả
                    resultList.add(new Manufacturer(manufacturerId, manufacturerName, dateCreated, exist, informationList, nubmerOfProduct));

                }

                // Đóng các kết nối
                resultSet.close();
                preparedStatement.close();

            } catch (SQLException throwables) {

                throwables.printStackTrace();

            }

            //  Trả connection
            DataSource.getInstance().releaseConnection(connection);

            //  Trả về kết quả
            return resultList;

        }
    }

    //  Phương thức lấy list hãng sản xuất từ tất cả điều kiện
    public int getMaximunManufacturerFromAll(String selectSearchAndSort,  String search) {

        //  Hàm lấy ra filter tương ứng trong database
        String filter = null;
        switch (selectSearchAndSort) {
            case "dateCreated":
                filter = "ngay_tao";
                break;
            case "manufacturerName":
                filter = "ten_hsx";
                break;
            case "manufacturerId":
                filter = "ma_hsx";
                break;
            case "informationList":
                filter = "so_luong_thong_tin";
                break;
            case "numberOfProducts":
                filter = "so_luong_san_pham";
                break;
        }

        //  Nếu như không phải 2 trường hợp cuối thì ta cứ làm đơn gian vì nó chung bảng
        if(filter.compareTo("so_luong_thong_tin") != 0 && filter.compareTo("so_luong_san_pham") != 0) {


            //  Khởi tạo result
            int result = 0;

            //  Mượn một connection
            Connection connection = DataSource.getInstance().getConnection();

            try {

                //  Taọ 1 preparedStatement
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(ma_hsx) AS so_luong FROM hang_san_xuat WHERE ton_tai = ? AND "+filter+" LIKE ?");

                //  set giá trị cho preparedsstatement 0 là tồn tại
                preparedStatement.setInt(1, 0);
                preparedStatement.setString(2,"%"+search+"%");

                //  Lấy danh sách tương ứng, ở đây là ban đầu nên lấy linesPerPage hãng sản xuất đầu tiên, sắp xếp theo ngày tạo DESC
                ResultSet resultSet = preparedStatement.executeQuery();

                //  Duyệt qua resultset
                while (resultSet.next()) {
                    result = resultSet.getInt("so_luong");
                }

                // Đóng các kết nối
                resultSet.close();
                preparedStatement.close();

            } catch (SQLException throwables) {

                throwables.printStackTrace();

            }

            //  Trả connection
            DataSource.getInstance().releaseConnection(connection);

            //  Trả về kết quả
            return result;

        }else if(filter.equals("so_luong_thong_tin")){

            //  Khởi tạo result
            int result = 0;

            //  Mượn một connection
            Connection connection = DataSource.getInstance().getConnection();

            try {

                //  Taọ 1 preparedStatement
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT COUNT(t.ma_hsx) as SO_LUONG FROM\n" +
                                "(SELECT h.ma_hsx, COUNT(c.chi_tiet) as so_luong_chi_tiet FROM hang_san_xuat h JOIN chi_tiet_hsx c ON h.ma_hsx = c.ma_hsx\n" +
                                "WHERE h.ton_tai = ?\n" +
                                "GROUP BY h.ma_hsx\n" +
                                ") t\n" +
                                "WHERE t.so_luong_chi_tiet LIKE ?");

                //  set giá trị cho preparedsstatement 0 là tồn tại
                preparedStatement.setInt(1, 0);
                preparedStatement.setString(2,"%"+search+"%");

                //  Lấy danh sách tương ứng, ở đây là ban đầu nên lấy linesPerPage hãng sản xuất đầu tiên, sắp xếp theo ngày tạo DESC
                ResultSet resultSet = preparedStatement.executeQuery();

                //  Duyệt qua resultset
                while (resultSet.next()) {
                    result = resultSet.getInt("so_luong");
                }

                // Đóng các kết nối
                resultSet.close();
                preparedStatement.close();

            } catch (SQLException throwables) {

                throwables.printStackTrace();

            }

            //  Trả connection
            DataSource.getInstance().releaseConnection(connection);

            //  Trả về kết quả
            return result;

        }else{

            //  Khởi tạo result
            int result = 0;

            //  Mượn một connection
            Connection connection = DataSource.getInstance().getConnection();

            try {

                //  Taọ 1 preparedStatement
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT COUNT(t2.ma_hsx) AS so_luong\n" +
                                "FROM(\n" +
                                "SELECT t.ma_hsx,\n" +
                                "CASE \n" +
                                "WHEN t.tong_so_luong IS NULL THEN 0\n" +
                                "ELSE t.tong_so_luong\n" +
                                "END AS so_luong\n" +
                                "FROM\n" +
                                "(SELECT h.ma_hsx,\n" +
                                "\n" +
                                "(SELECT SUM(sp.so_luong_con_lai) FROM san_pham s JOIN thong_tin_chi_tiet_sp sp ON s.ma_sp =sp.ma_sp\n" +
                                "\tWHERE s.ma_hsx = h.ma_hsx\n" +
                                "\tAND sp.ton_tai = ?\n" +
                                "\tGROUP BY s.ma_sp\n" +
                                ") AS tong_so_luong\n" +
                                "\n" +
                                "FROM hang_san_xuat h\n" +
                                "WHERE h.ton_tai = ?) t\n" +
                                ") t2\n" +
                                "WHERE t2.so_luong LIKE ?\n"
                                );

                //  set giá trị cho preparedsstatement 0 là tồn tại
                preparedStatement.setInt(1, 0);
                preparedStatement.setInt(2, 0);
                preparedStatement.setString(3,"%"+search+"%");

                //  Lấy danh sách tương ứng, ở đây là ban đầu nên lấy linesPerPage hãng sản xuất đầu tiên, sắp xếp theo ngày tạo DESC
                ResultSet resultSet = preparedStatement.executeQuery();

                //  Duyệt qua resultset
                while (resultSet.next()) {
                    result = resultSet.getInt("so_luong");
                }

                // Đóng các kết nối
                resultSet.close();
                preparedStatement.close();

            } catch (SQLException throwables) {

                throwables.printStackTrace();

            }

            //  Trả connection
            DataSource.getInstance().releaseConnection(connection);

            //  Trả về kết quả
            return result;

        }
    }

    //  Phương thức nhận vào mã hãng sản xuất, xóa nó trong cơ sở dữ liệu
    public boolean removeOneManufacturerInDatabase(String maufacturerId){

        //  Lấy connection
        Connection connection = DataSource.getInstance().getConnection();

        //  Kết quả
        boolean result = false;

        try {

            //  Tạo 1 preparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE hang_san_xuat  SET ton_tai = 1 WHERE ma_hsx = ?");

            //  Set dữ liệu
            preparedStatement.setString(1,maufacturerId);

            // update
            int row = preparedStatement.executeUpdate();

            //  Nếu có đúng 1 dòng được cập nhập thì bạn đsung
            if(row == 1){
                result  =true;
            }

            //  Đóng các thứ
            preparedStatement.close();

        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

        //  Trả connection
        DataSource.getInstance().releaseConnection(connection);

        //  Trả về kết quả có update đc hay không
        return result;

    }

    //  Phương thức nhận vào list mã hãng sản xuất, xóa nó trong cơ sở dữ liệu
    public boolean removeGroupManufacturerInDatabase(String[] manufacturerIds){

        //  Lấy connection
        Connection connection = DataSource.getInstance().getConnection();

        //  Kết quả
        boolean result = false;

        try {

            //  Tạo 1 preparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE hang_san_xuat  SET ton_tai = 1 WHERE ma_hsx = ?");

            // update
            int row = 0;
            for(String manufacturerId : manufacturerIds){
                preparedStatement.setString(1,manufacturerId);
                row+= preparedStatement.executeUpdate();
            }

            //  Nếu có đúng số dòng bằng length mảng truyền vào là
            if(row == manufacturerIds.length){
                result  =true;
            }

            //  Đóng các thứ
            preparedStatement.close();

        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

        //  Trả connection
        DataSource.getInstance().releaseConnection(connection);

        //  Trả về kết quả có update đc hay không
        return result;

    }

    //  Phương thức lấy mã hãng sản xuất tiếp theo
    public String getNextManufacturerId(){

        //  Lấy connection
        Connection connection = DataSource.getInstance().getConnection();

        //  Khai báo kết quả
        String result = null;

        //  Khai báo vị trí
        int index = 0;

        try {

            //  Tạo connection
            Statement statement = connection.createStatement();

            //  Lấy resultSet
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(ma_hsx) AS so_luong FROM hang_san_xuat");

            //  Lấy kết quả
            while(resultSet.next()){
                index = resultSet.getInt("so_luong")+1;
            }

            //  Đóng các thứ
            resultSet.close();
            statement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //  Trả connection
        DataSource.getInstance().releaseConnection(connection);

        //  Ráp vô kết quả
        result = "hsx_"+index;

        //  Trả về kết quả
        return result;

    }

    //  Phương thức nhận vào mã_hsx và tên hãng , thêm vô bảng hang_san_xuat
    public boolean addManufacturerToDatabase(String manufacturerId,String manufacturerName){

        //  Lấy connection
        Connection connection = DataSource.getInstance().getConnection();

        //  Khai báo kểt quả
        boolean result = false;

        try {

            //  Tạo preparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO hang_san_xuat VALUES (?,?,?,?)");

            //  Tạo ngày tạo là ngày hôm nay
            Date date = new Date();
            DateTime nowDate = new DateTime(date.getYear()+1900,date.getMonth()+1,date.getDate(),date.getHours(),date.getMinutes(),date.getSeconds());

            //  Set dữ liệu
            preparedStatement.setString(1,manufacturerId);
            preparedStatement.setString(2,manufacturerName);
            preparedStatement.setString(3,nowDate.toString());
            preparedStatement.setInt(4,0);

            //  update
            int row = preparedStatement.executeUpdate();

            //  Kiểm tra số dòng được thêm vào
            if(row == 1) result = true;

            //  Đóng các kết nối
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //  Trả connection
        DataSource.getInstance().releaseConnection(connection);

        //  Trả kết quả
        return result;

    }

}
