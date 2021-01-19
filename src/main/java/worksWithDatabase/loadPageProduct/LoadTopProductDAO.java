package worksWithDatabase.loadPageProduct;

import beans.product.Product;
import beans.product.Size;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LoadTopProductDAO {
    public LoadTopProductDAO() {
    }

    public ArrayList<Product> loadColorBytype(String type) {
        ArrayList<Product> list = new ArrayList<>();

        Connection con = null;
        try {
            con = DataSource.getInstance().getConnection();
            int sex;

            switch (type){
                case "Nam":
                    sex = 1;
                    break;
                case "Nu":
                    sex = 0;
                    break;
                default:
                    sex = 0;
                    break;
            }
            String sql = "SELECT DISTINCT s.ma_size , s.ten_size FROM san_pham sp,size s,thong_tin_chi_tiet_sp tt " +
                    "WHERE sp.ma_sp = tt.ma_sp and tt.ma_size = s.ma_size and sp.gioi_tinh = ?;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,sex);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){

            }

            rs.close();
            ps.close();
            DataSource.getInstance().releaseConnection(con);
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
            return list;
        }
    }
}
