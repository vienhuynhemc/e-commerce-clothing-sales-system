package worksWithDatabase.wishlist;

import beans.DateTime;

import beans.account.ConvertDate;
import beans.wishlist.Wishlist;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoadWishlistDAO {

    // so luong trang 1,2,3,...4,5,6
    public static int numberPage;
    public static int sumProduct;

    public ArrayList<Wishlist> getAllWishList(int page,String idCustomer,String search,String type,int sex, int status, int numberPerPage){
       ArrayList<Wishlist> list = new ArrayList<Wishlist>();
        Connection connection = DataSource.getInstance().getConnection();
        try {
            String sql1 = "SELECT y.ma_sp, y.ma_kh, y.ma_mau, y.so_luong from yeu_thich y where (y.ma_sp like ? or y.ma_kh like ? or DAY(y.ngay_them) = ?" +
                    "or MONTH(y.ngay_them) = ? or Year(y.ngay_them) = ?) and y.ma_kh = ?";

            PreparedStatement s = connection.prepareStatement(sql1);
            s.setString(1, "%" + search + "%");
            s.setString(2, "%" + search + "%");
            s.setString(3, search);
            s.setString(4, search);
            s.setString(5, search);
            s.setString(6,idCustomer);

            ResultSet rs = s.executeQuery();
            rs.last();
            sumProduct = rs.getRow();
            rs.beforeFirst();

            if (sumProduct % numberPerPage == 0) {
                setNumberPage(sumProduct / numberPerPage);
            } else {
                setNumberPage((sumProduct / numberPerPage) + 1);
            }
            rs.close();
            s.close();

            String stt = "";

//            if(status == 0){
//                stt = "t.so_luong_con_lai = " + status;
//            }
//            else{
//                stt = "t.so_luong_con_lai >= " + status;
//            }

//            String sql = "SELECT s.ten_sp, g.gia_sp, t.ma_size,y.so_luong, t.ma_mau, t.so_luong_con_lai, y.ngay_them, h.link_hinh_anh, s.ma_sp from yeu_thich y,san_pham s, gia_sp g, thong_tin_chi_tiet_sp t, hinh_anh_sp h where " +
//                    "y.ma_sp = t.ma_sp AND s.ma_sp = g.ma_sp AND t.ma_mau = y.ma_mau AND t.ma_size = y.size AND t.ma_sp = s.ma_sp AND h.ma_sp = s.ma_sp  AND (s.ma_sp like ? or y.ma_kh like ? or DAY(y.ngay_them) = ?" +
//                    " or MONTH(y.ngay_them) = ? or Year(y.ngay_them) = ? or g.gia_sp LIKE ?) AND y.ma_kh = ? AND "+ stt +" AND gioi_tinh = ?" +
//                    " ORDER BY s." + type + " LIMIT ?," + numberPerPage;
            String sql ="SELECT s.ten_sp, g.gia_sp, si.ma_size,y.so_luong, m.ma_mau, s.trang_thai, y.ngay_them," +
                    " h.link_hinh_anh, s.ma_sp, si.ten_size,giakm.gia_km from gia_sp_khuyen_mai giakm, yeu_thich y,san_pham s, gia_sp g, thong_tin_chi_tiet_sp t," +
                    " hinh_anh_sp h, size si, mau m where giakm.ma_sp = s.ma_sp and y.ma_sp = s.ma_sp AND y.ma_mau = t.ma_mau AND" +
                    " t.ma_sp = s.ma_sp AND h.ma_sp = y.ma_sp AND s.ma_sp = g.ma_sp AND si.ma_size = y.ma_size " +
                    "AND m.ma_mau = h.ma_mau AND (s.ma_sp like ? or y.ma_kh like ? or DAY(y.ngay_them) = ? or MONTH(y.ngay_them) = ? " +
                    "or Year(y.ngay_them) = ? or g.gia_sp LIKE ?) AND y.ma_kh = ? AND gioi_tinh = ? AND h.ma_mau = y.ma_mau AND t.ma_mau = " +
                    "y.ma_mau group by s.ten_sp, si.ten_size,m.ten_mau ORDER BY s."+type+" LIMIT ?,"+numberPerPage;



//            SELECT  s.ten_sp, g.gia_sp, t.ma_size, y.so_luong, t.ma_mau, s.trang_thai, y.ngay_them from yeu_thich y,
//                    san_pham s, gia_sp g, thong_tin_chi_tiet_sp t where y.ma_sp = t.ma_sp AND s.ma_sp = g.ma_sp AND
//                    t.ma_sp = s.ma_sp AND y.ma_mau = t.ma_mau ORDER BY s.ten_sp;

            PreparedStatement s2 = connection.prepareStatement(sql);
            int start = (page - 1) * numberPerPage + 1;
            s2.setString(1, "%" + search + "%");
            s2.setString(2, "%" + search + "%");
            s2.setString(3, search);
            s2.setString(4, search);
            s2.setString(5, search);
            s2.setString(6, search);
            s2.setString(7,idCustomer);
            s2.setInt(8,sex);
            s2.setInt(9, start - 1);

            ResultSet rss = s2.executeQuery();
            while (rss.next()) {
               // System.out.println("dsd");

              //  System.out.println(rss.getString(1));

                // lấy ra ngày để sử lí r cho nào class datetime

                Wishlist p = new Wishlist();
                p.setTen_sp(rss.getString(1));
                p.setGia(rss.getInt(2));
                p.setMa_size(rss.getString(3));
                p.setSo_luong(rss.getInt(4));
                p.setMa_mau(rss.getString(5));
                p.setNgay_them(ConvertDate.changeDate(rss.getString(7)));
                p.setTrang_thai(rss.getInt(6));
                p.setHinh_sp(rss.getString(8));
                p.setMa_sp(rss.getString(9));
                p.setSize(rss.getString(10));
                p.setGia_km(rss.getInt(11));
                list.add(p);
              //  System.out.println("dsdd");
            }
            rss.close();
            s2.close();
            DataSource.getInstance().releaseConnection(connection);
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            DataSource.getInstance().releaseConnection(connection);
            return list;
        }

    }
    public String getColorById(String id){
        String result ="";
        Connection connection = DataSource.getInstance().getConnection();
        try{
            PreparedStatement s = connection.prepareStatement("SELECT ten_mau FROM mau where ma_mau = ?");
            s.setString(1,id);
            ResultSet rs = s.executeQuery();
            if(rs.next()){
                result = rs.getString(1);
            }
            rs.close();
            s.close();
            DataSource.getInstance().releaseConnection(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return result;
    }


    public static int getNumberPage() {
        return numberPage;
    }

    public static void setNumberPage(int numberPage) {
        LoadWishlistDAO.numberPage = numberPage;
    }

    public static int getSumProduct() {
        return sumProduct;
    }

    public static void setSumProduct(int sumProduct) {
        LoadWishlistDAO.sumProduct = sumProduct;
    }


    public static void main(String[] args) {
        LoadWishlistDAO dao = new LoadWishlistDAO();

       ArrayList<Wishlist> wishlists = dao.getAllWishList(1, "KH001", "", "ten_sp", 0, 0, 10);

        for (Wishlist w : wishlists ) {
            System.out.println(w.toString());
        }

        //System.out.println(dao.getQuantity("sp_1","mau_1","size_1"));
        //System.out.println(dao.getColorById("mau_1"));
    }
}
