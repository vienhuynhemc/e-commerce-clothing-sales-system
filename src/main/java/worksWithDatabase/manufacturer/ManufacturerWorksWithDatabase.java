package worksWithDatabase.manufacturer;

import beans.DateTime;
import beans.manufacturer.Manufacturer;
import connectionDatabase.DataSource;
import worksWithDatabase.manufacturerInformation.ManufacturerInformationDataSource;
import worksWithDatabase.manufacturerInformation.ManufacturerInformationWorksWithDatabase;
import worksWithDatabase.productDetailInformation.ProductDetailInformationDataSource;
import worksWithDatabase.productDetailInformation.ProductDetailInformationWorksWithDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

            //  Taọ 1 statement
            Statement statement = connection.createStatement();

            //  Lấy danh sách tương ứng, ở đây là ban đầu nên lấy linesPerPage hãng sản xuất đầu tiên, sắp xếp theo ngày tạo DESC
            ResultSet resultSet = statement.executeQuery("SELECT * FROM hang_san_xuat ORDER BY ngay_tao DESC LIMIT 0," + linesPerPage + ";");

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
            statement.close();

        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

        //  Trả connection
        DataSource.getInstance().releaseConnection(connection);

        //  Trả về kết quả
        return resultList;

    }

    //  Phương thức lấy số trang tối đa của trang quản lý hãng sản xuất không có điều kiện gì cả
    public int getMaximunManufacturer() {

        //  Mượn connection
        Connection connection = DataSource.getInstance().getConnection();

        //  Khai báo kết quả
        int result = 0;

        try {

            //  Tạo một connection
            Statement statement = connection.createStatement();

            //  Lấy kết quả mong muốn
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(ma_hsx) AS so_luong FROM hang_san_xuat");

            //  Gán co result
            while (resultSet.next()) {
                result = resultSet.getInt("so_luong");
            }

            //  Đóng các kết nối
            resultSet.close();
            statement.close();

        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

        //  Trả connection
        DataSource.getInstance().releaseConnection(connection);

        //  Trả về kết quả
        return result;

    }

}
