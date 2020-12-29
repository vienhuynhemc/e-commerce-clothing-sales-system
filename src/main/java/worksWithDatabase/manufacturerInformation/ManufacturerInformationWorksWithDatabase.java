package worksWithDatabase.manufacturerInformation;

import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerInformationWorksWithDatabase {

    //  Constructor rỗng không có gì hết
    ManufacturerInformationWorksWithDatabase() {
    }

    //  Phương thức nhận vào mã hãng sản xuất, trả về 1 list chi tiết hãng sản xuất
    public List<String> getListManufacturerInformationById(String manufacturerId, Connection connection) {

        //  Tọa list kết quả
        List<String> resultList = new ArrayList<String>();

        try {

            //  Tạo 1 preparedstatement
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT chi_tiet FROM chi_tiet_hsx WHERE ma_hsx = ?");

            //  Set ? là id truyền vào
            preparedStatement.setString(1, manufacturerId);

            //  Lấy result set
            ResultSet resultSet = preparedStatement.executeQuery();

            //  Duyệt qua resultset và lấy từng kết quả add vào list result
            while (resultSet.next()) {
                resultList.add(resultSet.getString("chi_tiet"));
            }

            // Lấy xong nhớ đóng tất cả
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

        //  Trả về danh sách kết quả
        return resultList;

    }

    //  Add các thông tin vô database dựa theo ma_hsx nhận vào và list thông tin
    public boolean addInformationToDatabase(String manufacturerId, String[] informations) {

        //  Mượn connection
        Connection connection = DataSource.getInstance().getConnection();

        //  Khai báo kết quả
        boolean result = false;

        try {

            //  Tạo 1 preparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO chi_tiet_hsx VALUES(?,?)");

            //  Set giá trị đầu là ma_hsx
            preparedStatement.setString(1, manufacturerId);

            //  Khai báo số row được thêm vô
            int row = 0;

            //  update insert tất cả informations
            for (String s : informations) {
                preparedStatement.setString(2, s);
                row += preparedStatement.executeUpdate();
            }

            //  Kiểm tra , nếu row thêm vô == informations.length thì bạn đúng
            if (row == informations.length) {
                result = true;
            }

            //  Đóng các kết nối
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
