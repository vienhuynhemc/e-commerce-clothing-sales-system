package worksWithDatabase.cart;

import beans.cart.Cart;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangeCartDAO {
    public ChangeCartDAO() {
    }

    public Cart increaseCart(String ma_sp, String ma_kh, String ma_mau,String active) {
        Connection con = null;
        try {
             con = DataSource.getInstance().getConnection();

            String check = "SELECT * FROM gio_hang WHERE ma_sp = ? and ma_kh = ? and ma_mau = ?";

            PreparedStatement ps  = con.prepareStatement(check);

            ps.setString(1, ma_sp);
            ps.setString(2, ma_kh);
            ps.setString(3, ma_mau);

            ResultSet rs = ps.executeQuery();
            String exe = "";
            if (rs.next()){

                String soluong = "select so_luong from gio_hang WHERE ma_sp = ? and ma_kh = ? and ma_mau = ?";
                PreparedStatement ps0 = con.prepareStatement(soluong);
                ps0.setString(1,ma_sp);
                ps0.setString(2,ma_kh);
                ps0.setString(3,ma_mau);

                ResultSet rs0 = ps0.executeQuery();
                int soluongsp = 0;
                if(rs0.next()){

                    if (active.equals("tang")){
                        soluongsp = rs0.getInt("so_luong") + 1;
                    }else{
                        soluongsp = rs0.getInt("so_luong") - 1;
                    }
                }
                rs0.close();
                ps0.close();

                exe = "UPDATE gio_hang set so_luong = " +soluongsp +" WHERE ma_sp = ? and ma_kh = ? and ma_mau = ?";
            }
            rs.close();
            ps.close();

            PreparedStatement pse = con.prepareStatement(exe);

            pse.setString(1,ma_sp);
            pse.setString(2,ma_kh);
            pse.setString(3,ma_mau);

             pse.executeUpdate();



            String sql = "SELECT g.ma_sp,g.ma_kh,g.ma_mau, sp.ten_sp,h.link_hinh_anh,s.ten_size, m.ten_mau,g.so_luong,g.so_luong*gsp.gia_sp as gia\n" +
                    "from gio_hang g, hinh_anh_sp h,san_pham sp,thong_tin_chi_tiet_sp tt,gia_sp gsp,size s,mau m \n" +
                    "WHERE g.ma_kh = ?\n" +
                    "and g.ma_sp = ? \n" +
                    "and g.ma_mau = ? \n" +
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
            PreparedStatement ps2 = con.prepareStatement(sql);
            ps2.setString(1,ma_kh);
            ps2.setString(2,ma_sp);
            ps2.setString(3,ma_mau);

            ResultSet rs2 = ps2.executeQuery();

            if (rs2.next()){
                DataSource.getInstance().releaseConnection(con);
               return new Cart(rs2.getString(1),rs2.getString(2)
                       ,rs2.getString(3),rs2.getString(5),rs2.getString(4),rs2.getString(6)
                       ,rs2.getString(7),rs2.getInt(8),rs2.getDouble(9));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
        }
        DataSource.getInstance().releaseConnection(con);
        return null;
    }

    public static void main(String[] args) {
        ChangeCartDAO cartDAO = new ChangeCartDAO();
        System.out.println(cartDAO.increaseCart("sp_1","kh001","mau_1","tang"));
    }
}
