package worksWithDatabase.manufacturerInformation;

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

}
