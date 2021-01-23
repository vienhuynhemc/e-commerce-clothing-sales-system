package worksWithDatabase.productStructure;

import beans.productAdmin.ProductAdmin;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductStructureWorksWithDatabase {

    public ProductStructureWorksWithDatabase() {

    }

    //  Phương thức nhận vào list product admin điền cho nó list cấu tạo sp
    public void fillStructureProdcut(List<ProductAdmin> products) {

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT cau_tao FROM cau_tao_sp WHERE ma_sp = ?");

            for (ProductAdmin productAdmin : products) {
                preparedStatement.setString(1, productAdmin.getMa_sp());
                ResultSet resultSet = preparedStatement.executeQuery();
                List<String> structure = new ArrayList<String>();
                while (resultSet.next()) {
                    structure.add(resultSet.getString("cau_tao"));
                }
                resultSet.close();
                productAdmin.setCau_tao_sp(structure);
            }

            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

}
