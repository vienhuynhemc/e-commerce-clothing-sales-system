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

    public Cart increaseCart(String ma_sp, String ma_kh, String ma_mau,String ma_size,String active) {

        System.out.println(ma_sp);
        System.out.println(ma_mau);
        System.out.println(ma_size);


        Connection con = null;
        Cart cart = null;
        try {
             con = DataSource.getInstance().getConnection();



             // check thử số lượng còn lại trong giỏ hàng
            int so_luong_con_lai = 0;
            int so_luong_sp_hien_tai = 0;
            String sl = "SELECT tt.so_luong_con_lai FROM thong_tin_chi_tiet_sp tt " +
                    "WHERE tt.ma_sp = ? and tt.ma_size = ? and tt.ma_mau = ?";

            PreparedStatement pst = con.prepareStatement(sl);
            pst.setString(1,ma_sp);
            pst.setString(2,ma_size);
            pst.setString(3,ma_mau);
            ResultSet rst = pst.executeQuery();

            if (rst.next()){
                so_luong_con_lai = rst.getInt(1);
            }
            rst.close();
            pst.close();


             // check thử sản phẩm đó có trong giỏ hàng không đã
            String check = "SELECT * FROM gio_hang WHERE ma_sp = ? and ma_kh = ? and ma_mau = ? and ma_size = ?";

            PreparedStatement ps  = con.prepareStatement(check);

            ps.setString(1, ma_sp);
            ps.setString(2, ma_kh);
            ps.setString(3, ma_mau);
            ps.setString(4, ma_size);

            ResultSet rs = ps.executeQuery();
            String exe = "";
            if (rs.next()){

                // tính số lượng sản phẩm hiện tại
                String soluong = "select so_luong from gio_hang WHERE ma_sp = ? and ma_kh = ? and ma_mau = ? and ma_size = ?";
                PreparedStatement ps0 = con.prepareStatement(soluong);
                ps0.setString(1,ma_sp);
                ps0.setString(2,ma_kh);
                ps0.setString(3,ma_mau);
                ps0.setString(4,ma_size);

                ResultSet rs0 = ps0.executeQuery();
                int soluongsp = 0;
                if(rs0.next()){

                    so_luong_sp_hien_tai = rs0.getInt("so_luong");

                    if (active.equals("tang")){

                        // nếu số lượng sản phẩm hiện tại nhỏ hơn số lượng còn lại thì đc phép thêm
                        if (so_luong_sp_hien_tai  < so_luong_con_lai){

                        soluongsp = so_luong_sp_hien_tai + 1;

                        }else{
                            // nếu bằng thì ....
                            soluongsp = so_luong_sp_hien_tai;
                        }

                    }else{
                        // nếu số lượng sp hiện tại lớn hơn 1 mới đc trừ
                        if (so_luong_sp_hien_tai > 1){

                            soluongsp = so_luong_sp_hien_tai - 1;
                        }else{
                            // nếu bằng thì ....
                            soluongsp = so_luong_sp_hien_tai;
                        }
                    }
                }
                rs0.close();
                ps0.close();

                exe = "UPDATE gio_hang set so_luong = " +soluongsp +" WHERE ma_sp = ? and ma_kh = ? and ma_mau = ? and ma_size = ?";
            }else{
                exe = "UPDATE gio_hang set so_luong = " +so_luong_sp_hien_tai +" WHERE ma_sp = ? and ma_kh = ? and ma_mau = ? and ma_size = ?";

            }
            rs.close();
            ps.close();

            PreparedStatement pse = con.prepareStatement(exe);

            pse.setString(1,ma_sp);
            pse.setString(2,ma_kh);
            pse.setString(3,ma_mau);
            pse.setString(4,ma_size);

             pse.executeUpdate();


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
                    "gio.ma_kh = ? and gio.ma_mau = ? and gio.ma_sp = ? and gio.ma_size = ? " +
                    "GROUP BY gio.ma_sp, gio.ma_kh , gio.ma_mau,gio.ma_size";

            PreparedStatement ps2 = con.prepareStatement(sql);
            ps2.setString(1,ma_kh);
            ps2.setString(2,ma_mau);
            ps2.setString(3,ma_sp);
            ps2.setString(4,ma_size);

            ResultSet rs2 = ps2.executeQuery();

            if (rs2.next()){

                 cart = new Cart(rs2.getString(1),rs2.getString(2)
                        ,rs2.getString(3),rs2.getString(4),rs2.getString(5),rs2.getString(6)
                        ,rs2.getString(7),rs2.getString(8),rs2.getInt(9),rs2.getDouble(10),rs2.getDouble(11));

                DataSource.getInstance().releaseConnection(con);
               return cart;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
            return cart;
        }
        DataSource.getInstance().releaseConnection(con);
        return cart;
    }

    public static void main(String[] args) {
        ChangeCartDAO cartDAO = new ChangeCartDAO();
        System.out.println(cartDAO.increaseCart("sp_1","KH001","mau_1","size_1","tang"));
    }
}
