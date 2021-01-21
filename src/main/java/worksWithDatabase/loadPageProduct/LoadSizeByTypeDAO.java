package worksWithDatabase.loadPageProduct;

import beans.product.ProductColor;
import beans.product.Size;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoadSizeByTypeDAO {

    public LoadSizeByTypeDAO() {
    }

    public ArrayList<Size> loadColorBytype(String type) {
        ArrayList<Size> list = new ArrayList<>();

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
                    "WHERE sp.ma_sp = tt.ma_sp and tt.ma_size = s.ma_size and sp.gioi_tinh = ? and tt.ton_tai = 1;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,sex);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Size(rs.getString(1),rs.getString(2)));
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

    public static void main(String[] args)  {
        LoadSizeByTypeDAO loadSizeByTypeDAO = new LoadSizeByTypeDAO();
        System.out.println(loadSizeByTypeDAO.loadColorBytype("Nu"));
    }
}
