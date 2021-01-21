package worksWithDatabase.cart;

import beans.cart.Cart;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddCartDAO {
    public AddCartDAO() {
    }

    public boolean addCart(String ma_sp,String ma_kh,String ma_mau,String ma_size,int so_luong) {
        Connection con = null;
        try {
             con = DataSource.getInstance().getConnection();


            // tính số lượng còn lại của sản phẩm đó trong data
            int so_luong_con_lai;
            String sl = "SELECT tt.so_luong_con_lai FROM thong_tin_chi_tiet_sp tt " +
                    "WHERE tt.ma_sp = ? and tt.ma_size = ? and tt.ma_mau = ? ";

            PreparedStatement pst = con.prepareStatement(sl);
            pst.setString(1,ma_sp);
            pst.setString(2,ma_size);
            pst.setString(3,ma_mau);
            ResultSet rst = pst.executeQuery();

            if (rst.next()){
                so_luong_con_lai = rst.getInt(1);
            }else {
                DataSource.getInstance().releaseConnection(con);
                return false;
            }
            rst.close();
            pst.close();



            // check thử sản phẩm đó có trong giỏ chưa  ?
            String check = "SELECT gio.ma_sp,gio.ma_kh,gio.ma_mau,gio.so_luong,gio.ma_size " +
                    "FROM gio_hang gio, san_pham sp,thong_tin_chi_tiet_sp tt" +
                    " WHERE gio.ma_sp = sp.ma_sp and tt.ma_sp = gio.ma_sp and tt.ma_size = gio.ma_size and tt.ma_mau = gio.ma_mau and tt.ton_tai = 1" +
                    " and sp.ma_sp = ? and gio.ma_kh = ? and gio.ma_mau = ? and gio.ma_size = ? and sp.ton_tai =1 and sp.trang_thai = 1 ";


            PreparedStatement ps = con.prepareStatement(check);

            ps.setString(1, ma_sp);
            ps.setString(2, ma_kh);
            ps.setString(3, ma_mau);
            ps.setString(4,ma_size);

            ResultSet rs = ps.executeQuery();
            String exe;
            int tong;
            if (rs.next()){
                // nếu có trong giỏ, thì check số lượng còn lại
                if (so_luong_con_lai < so_luong){
                    DataSource.getInstance().releaseConnection(con);
                    return false;
                }else{
                    tong = rs.getInt("so_luong") + so_luong;
                }

                exe = "UPDATE gio_hang set so_luong = ? WHERE ma_sp = ? and ma_kh = ? and ma_mau = ? and ma_size = ?";
            }else{
                // tới đây sảy ra 2 trường hợp, một là sản phẩm chưa có trong giỏ hàng, hoặc là sản phẩm đó không hoạt động
                String checkExit = "SELECT * FROM san_pham sp, thong_tin_chi_tiet_sp tt WHERE sp.ma_sp = tt.ma_sp " +
                        " and tt.ma_sp = ? and tt.ma_size = ? and tt.ma_mau = ? and tt.ton_tai = 1 and sp.ton_tai = 1 and sp.trang_thai = 1";

                PreparedStatement ps1 = con.prepareStatement(checkExit);
                ps1.setString(1,ma_sp);
                ps1.setString(2,ma_size);
                ps1.setString(3,ma_mau);

                ResultSet rs1 = ps1.executeQuery();

                if (rs1.next()){
                    // check số lượng còn lại
                    if (so_luong_con_lai < so_luong){
                        DataSource.getInstance().releaseConnection(con);
                        return false;
                    }else{
                        tong =so_luong;
                    }
                    exe = "INSERT INTO gio_hang(so_luong,ma_sp,ma_kh,ma_mau,ma_size) VALUES (?,?,?,?,?);";
                }else{
                    DataSource.getInstance().releaseConnection(con);
                    return false;
                }

                rs1.close();ps1.close();

            }
            rs.close();
            ps.close();

            PreparedStatement pse = con.prepareStatement(exe);

            pse.setInt(1,tong);
            pse.setString(2,ma_sp);
            pse.setString(3,ma_kh);
            pse.setString(4,ma_mau);
            pse.setString(5,ma_size);

             int n = pse.executeUpdate();

            DataSource.getInstance().releaseConnection(con);

             if(n != 0){
                 DataSource.getInstance().releaseConnection(con);
                 return true;
             }
            else{
                 DataSource.getInstance().releaseConnection(con);
                 return false;
             }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
            return false;
        }
    }

    public static void main(String[] args) {
        AddCartDAO cartDAO = new AddCartDAO();
        System.out.println(cartDAO.addCart("sp_2","kh001","mau_2","size_2",5));
    }
}