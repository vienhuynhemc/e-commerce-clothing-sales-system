package worksWithDatabase.loadPageHistory;

import beans.cart.Cart;
import beans.order.DetailOrder1;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoadDetailOrderDAO {
    public LoadDetailOrderDAO() {
    }


    public ArrayList<DetailOrder1> listOrderByID(String ID){
        ArrayList<DetailOrder1> result = new ArrayList<DetailOrder1>();
        Connection con = null;
        try {
            con = DataSource.getInstance().getConnection();

            String sql = "SELECT dm.ten_dm, hinh.link_hinh_anh, sp.ten_sp, s.ten_size,m.ten_mau,gio.so_luong_san_pham, gia.gia_sp*gio.so_luong_san_pham,giakm.gia_km*gio.so_luong_san_pham , dh.tong_tien,dh.ghi_chu_don_hang\n" +
                    "from chi_tiet_don_hang gio, san_pham sp, thong_tin_chi_tiet_sp tt, hinh_anh_sp hinh, gia_sp gia, gia_sp_khuyen_mai giakm,size s, mau m, don_hang dh,danh_muc dm\n" +
                    "                    WHERE sp.ma_sp = gio.ma_san_pham and\n" +
                    "                    tt.ma_sp = gio.ma_san_pham and \n" +
                    "                    tt.ma_mau = gio.ma_mau and\n" +
                    "                    tt.ma_size = gio.ma_size and\n" +
                    "                    hinh.ma_sp = sp.ma_sp and\n" +
                    "                    hinh.ma_sp = gio.ma_san_pham and\n" +
                    "                    gio.ma_mau= hinh.ma_mau and\n" +
                    "                    sp.ma_sp = gia.ma_sp and\n" +
                    "                    sp.ma_sp = giakm.ma_sp and \n" +
                    "                    m.ma_mau = gio.ma_mau and \n" +
                    "                    s.ma_size = tt.ma_size and\n" +
                    "\t\t\t\t\t\t\t\t\tsp.ma_dm = dm.ma_dm and\t\t \n" +
                    "\t\t\t\t\t\t\t\t\t\tdh.ma_don_hang = gio.ma_don_hang\n" +
                    "\t\t\t\t\t\t\t\t\t\tand dh.ma_don_hang = ? \t\t\t\t\t\t\t\t\t\n" +
                    "                    GROUP BY gio.ma_san_pham , gio.ma_mau,gio.ma_size";

            PreparedStatement ps = ps = con.prepareStatement(sql);

            ps.setString(1,ID);

            ResultSet rs = ps.executeQuery();


            while (rs.next()){

                DetailOrder1 order = new DetailOrder1(rs.getString(1),rs.getString(2)
                ,rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),
                        rs.getInt(7),rs.getInt(8),rs.getInt(9), rs.getString(10));

                result.add(order);
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
        LoadDetailOrderDAO  detailOrderDAO = new LoadDetailOrderDAO();

        System.out.println(detailOrderDAO.listOrderByID("donhang_KH0018255961140"));

    }

}
