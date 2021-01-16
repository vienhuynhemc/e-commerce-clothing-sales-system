package worksWithDatabase.cart;

import beans.cart.Cart;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoadCartDAO {
    public LoadCartDAO() {
    }

    public ArrayList<Cart> listCartByID(String ID){
     ArrayList<Cart> result = new ArrayList<Cart>();
        try {
        Connection con = DataSource.getInstance().getConnection();

        String sql = "SELECT g.ma_sp,g.ma_kh,g.ma_mau, sp.ten_sp,h.link_hinh_anh,s.ten_size, m.ten_mau,g.so_luong,g.so_luong*gsp.gia_sp as gia\n" +
                "from gio_hang g, hinh_anh_sp h,san_pham sp,thong_tin_chi_tiet_sp tt,gia_sp gsp,size s,mau m \n" +
                "WHERE g.ma_kh = ?\n" +
                "and g.ma_sp = h.ma_sp \n" +
                "and g.ma_mau = h.ma_mau \n" +
                "and g.ma_sp = sp.ma_sp \n" +
                "and sp.ma_sp = tt.ma_sp\n" +
                "and g.ma_sp = tt.ma_sp \n" +
                "and g.ma_mau = tt.ma_mau \n" +
                "and s.ma_size = tt.ma_size\n" +
                "and g.ma_mau = m.ma_mau\n" +
                "and g.ma_sp = gsp.ma_sp\n" +
                "\n" +
                "group by m.ten_mau, sp.ten_sp,s.ten_size,g.so_luong\n" +
                "; ";

            PreparedStatement ps = ps = con.prepareStatement(sql);

            ps.setString(1,ID);

            ResultSet rs = ps.executeQuery();


            while (rs.next()){
                result.add(new Cart(rs.getString(1),rs.getString(2)
                ,rs.getString(3),rs.getString(5),rs.getString(4),rs.getString(6)
                ,rs.getString(7),rs.getInt(8),rs.getDouble(9)));
            }
            rs.close();
            ps.close();
            DataSource.getInstance().releaseConnection(con);
            return result;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    return result;
    }

    public static void main(String[] args) {
        LoadCartDAO cartDAO = new LoadCartDAO();

        System.out.println(cartDAO.listCartByID("KH001"));

    }

}
