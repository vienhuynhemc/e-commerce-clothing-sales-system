package worksWithDatabase.ralatedProducts;

import beans.DateTime;
import beans.product.Product;
import beans.rate.Rate;
import beans.rate.Star;
import connectionDatabase.DataSource;
import worksWithDatabase.detailProductIndex.DetailProductDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RalatedProductDAO {

    public ArrayList<Product> LoadRalatedProduct(int price) {
        Connection connection = DataSource.getInstance().getConnection();
        ArrayList<Product> list = new ArrayList<Product>();
        try {
            PreparedStatement s = connection.prepareStatement("SELECT DISTINCT s.ma_sp FROM san_pham s," +
                    " gia_sp g WHERE s.ma_sp = g.ma_sp AND g.gia_sp BETWEEN (?-50000) AND (?+50000)");
            s.setInt(1,price);
            s.setInt(2,price);
            ResultSet rs = s.executeQuery();
            int count = 0;
            while(rs.next()){
                count++;
                DetailProductDAO dp = new DetailProductDAO();
                Product p = dp.getProductById(rs.getString(1));
                list.add(p);
            }
            rs.close();
            s.close();
            System.out.println(count);
            DataSource.getInstance().releaseConnection(connection);
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        RalatedProductDAO a = new RalatedProductDAO();
        for(Product p : a.LoadRalatedProduct(300000)){
            System.out.println(p);
        }
    }

}
