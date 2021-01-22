package worksWithDatabase.loadPageProduct;

import beans.product.ProductColor;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoadColorByTypeDAO {

    public LoadColorByTypeDAO() {
    }

    public ArrayList<ProductColor> loadColorBytype(String type){
        ArrayList<ProductColor> list = new ArrayList<>();

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
            String sql = "SELECT DISTINCT m.ma_mau , m.ten_mau , m.hinh_anh_mau,m.link_hinh_anh FROM san_pham sp,mau m,thong_tin_chi_tiet_sp tt " +
                    "WHERE sp.ma_sp = tt.ma_sp and m.ma_mau = tt.ma_mau and sp.gioi_tinh = ? and tt.ton_tai = 1;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,sex);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new ProductColor(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
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

    public static void main(String[] args){
        LoadColorByTypeDAO loadColor = new LoadColorByTypeDAO();
        System.out.println(loadColor.loadColorBytype("Nu"));
    }
}
