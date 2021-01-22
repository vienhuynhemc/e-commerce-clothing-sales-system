package worksWithDatabase.loadPageProduct;

import beans.DateTime;
import beans.account.ConvertDate;
import beans.product.Category;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoadCategoryByTypeDAO {

    public LoadCategoryByTypeDAO() {
    }

    public ArrayList<Category> loadCategoryBytype(String type) {
        ArrayList<Category> list = new ArrayList<>();

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
    String sql = "SELECT DISTINCT dm.ma_dm,dm.ten_dm,dm.ngay_tao,dm.ton_tai FROM  danh_muc dm, san_pham sp " +
            "WHERE sp.ma_dm = dm.ma_dm and sp.gioi_tinh = ? and sp.ton_tai = 1 and dm.ton_tai = 1";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,sex);

        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            list.add(new Category(rs.getString(1),rs.getString(2), ConvertDate.changeDate(rs.getString(3)),rs.getInt(4)));
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

    public static void main(String[] args) {
        LoadCategoryByTypeDAO loadCategoryByTypeDAO = new LoadCategoryByTypeDAO();

            System.out.println(loadCategoryByTypeDAO.loadCategoryBytype("Nu"));

    }
}
