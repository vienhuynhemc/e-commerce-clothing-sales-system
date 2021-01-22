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
        Connection con = null;
        try {
         con = DataSource.getInstance().getConnection();

        String sql = "SELECT gio.ma_sp, gio.ma_kh, gio.ma_mau, gio.ma_size, hinh.link_hinh_anh, sp.ten_sp, s.ten_size,m.ten_mau,gio.so_luong, gia.gia_sp*gio.so_luong,giakm.gia_km*gio.so_luong from gio_hang gio, san_pham sp, thong_tin_chi_tiet_sp tt, hinh_anh_sp hinh, gia_sp gia, gia_sp_khuyen_mai giakm,\n" +
                "size s, mau m\n" +
                " WHERE sp.ma_sp = gio.ma_sp and\n" +
                "tt.ma_sp = gio.ma_sp and \n" +
                "tt.ma_mau = gio.ma_mau and\n" +
                "tt.ma_size = gio.ma_size and\n" +
                "hinh.ma_sp = sp.ma_sp and\n" +
                "hinh.ma_sp = gio.ma_sp and\n" +
                "gio.ma_mau= hinh.ma_mau and \n" +
                "sp.ma_sp = gia.ma_sp and\n" +
                "sp.ma_sp = giakm.ma_sp and \n" +
                "m.ma_mau = gio.ma_mau and \n" +
                "s.ma_size = tt.ma_size and \n" +
                "tt.ton_tai = 1 and\n" +
                "sp.ton_tai = 1 and\n" +
                "sp.trang_thai = 1 and\n" +
                "gio.ma_kh = ? \n" +
                "GROUP BY gio.ma_sp, gio.ma_kh , gio.ma_mau,gio.ma_size";

            PreparedStatement ps = ps = con.prepareStatement(sql);

            ps.setString(1,ID);

            ResultSet rs = ps.executeQuery();


            while (rs.next()){
                result.add(new Cart(rs.getString(1),rs.getString(2)
                ,rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)
                ,rs.getString(7),rs.getString(8),rs.getInt(9),rs.getDouble(10),rs.getDouble(11)));
            }
            rs.close();
            ps.close();
            DataSource.getInstance().releaseConnection(con);
            return result;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
        }

    return result;
    }

    public static void main(String[] args) {
        LoadCartDAO cartDAO = new LoadCartDAO();

        System.out.println(cartDAO.listCartByID("KH001"));

    }

}
