package worksWithDatabase.manufacturer;

import beans.DateTime;
import beans.manufacturer.Manufacturer;
import connectionDatabase.DataSource;
import worksWithDatabase.manufacturerInformation.ManufacturerInformationDataSource;
import worksWithDatabase.productDetailInformation.ProductDetailInformationDataSource;

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

            //  Trả connection
            DataSource.getInstance().releaseConnection(connection);

            //  Lấy danh sách tương ứng, ở đây là ban đầu nên lấy linesPerPage hãng sản xuất đầu tiên, sắp xếp theo ngày tạo DESC
            ResultSet resultSet = statement.executeQuery("SELECT * FROM hang_san_xuat ORDER BY ngay_tao DESC LIMIT 0," + linesPerPage + ";");

            //  Duyệt qua resultset
            while (resultSet.next()) {
                System.out.println("a");
                //  Lấy các thông tin hiện có của bản hãng sản xuất
                String manufacturerId = resultSet.getString("ma_hsx");
                String manufacturerName = resultSet.getString("ten_hsx");
                DateTime dateCreated = new DateTime(resultSet.getString("ngay_tao"));
                int exist = resultSet.getInt("ton_tai");
                System.out.println("b");
                //  lấy list thông tin chi tiết hãng từ bảng chi tiết hãng sản xuất
                List<String> informationList = ManufacturerInformationDataSource.getInstance().getManufacturerInformationWorksWithDatabase().getListManufacturerInformationById(manufacturerId);
                System.out.println("c");
                //  Lấy số lượng sản phẩm còn phải của hãng này từ bảng chi tiết sản phẩm
                int nubmerOfProduct = ProductDetailInformationDataSource.getInstance().getProductDetailInformationWorksWithDatabase().getNumberOfProductByManufacturerId(manufacturerId);
                System.out.println("d");
                //  Sau khi có đủ thông tin ta thêm hãng sản xuất này vào list kết quả
                resultList.add(new Manufacturer(manufacturerId, manufacturerName, dateCreated, exist, informationList, nubmerOfProduct));
                System.out.println("e");
            }

            // Đóng các kết nối
            resultSet.close();
            statement.close();

        } catch (SQLException throwables) {

            throwables.printStackTrace();

            //  Trả connection
            DataSource.getInstance().releaseConnection(connection);

        }

        //  Trả về kết quả
        return resultList;

    }

    public static void main(String[] args) {
        System.out.println(ManufacturerDataSource.getInstance().getManufacturerWorksWithDatabase().getListManufacturerFirst(10));
    }

}
