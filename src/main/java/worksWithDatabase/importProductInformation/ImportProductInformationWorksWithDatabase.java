package worksWithDatabase.importProductInformation;

import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ImportProductInformationWorksWithDatabase {

    public ImportProductInformationWorksWithDatabase(){

    }

    //  Phương thức nhận vô List mã phiếu nhập, trả về số lượng hàng hóa nhập của những phiếu hàng đó
    public int getSumImportProductByListId(List<String> maPhieuNhaps){

        int result = 0;
        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT SUM(so_luong) AS so_luong FROM chi_tiet_phieu_nhap WHERE ma_phieu_nhap = ?");

            for(String ma_phieu_nhap : maPhieuNhaps){
                preparedStatement.setString(1,ma_phieu_nhap);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                result+=resultSet.getInt("so_luong");
                resultSet.close();
            }
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return result;

    }

}
