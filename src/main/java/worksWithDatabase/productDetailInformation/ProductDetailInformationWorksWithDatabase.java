package worksWithDatabase.productDetailInformation;

import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDetailInformationWorksWithDatabase {

    //  Constructor rỗng không có gì hết
    public ProductDetailInformationWorksWithDatabase() {
    }

    //  Phương thức nhận vào hãng sản xuất id , trả về số sản phẩm còn lại của hãng này
    public int getNumberOfProductByManufacturerId(String manufacturerId,Connection connection) {

        //  Khai báo kết quả
        int result = 0;

        try {

            //  Tạo 1 preparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT SUM(t.so_luong_con_lai) as tong_so_luong  FROM thong_tin_chi_tiet_sp t JOIN san_pham sp WHERE sp.ma_hsx = ?");

            //  Set where là id hãng sản xuất truyền vào
            preparedStatement.setString(1, manufacturerId);

            //  Lấy result set
            ResultSet resultSet = preparedStatement.executeQuery();

            //  Nếu có kết quả thì gán lại kết quả;
            while (resultSet.next()) {
                result = resultSet.getInt("tong_so_luong");
            }

            //  Đóng resultset và preparedStatement
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

        //  Trả về kết quả
        return  result;

    }

}
