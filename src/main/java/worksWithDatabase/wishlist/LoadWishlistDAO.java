package worksWithDatabase.wishlist;

import beans.DateTime;

import beans.wishlist.Wishlist;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

public class LoadWishlistDAO {
    private ArrayList<Wishlist> list;
    // so luong trang 1,2,3,...4,5,6
    static int numberPage;
    static int sumProduct;

    public ArrayList<Wishlist> getAllWishList(int page,String idCustomer,String search,String type,String sex, String status, int numberPerPage){

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

            String sql = "SELECT s.ten_sp, g.gia_sp, t.ma_size,y.so_luong, t.ma_mau, t.so_luong_con_lai, y.ngay_them from yeu_thich y,san_pham s, gia_sp g, thong_tin_chi_tiet_sp t where " +
                    "y.ma_sp = t.ma_sp AND s.ma_sp = g.ma_sp AND t.ma_mau = y.ma_mau AND  t.ma_sp = s.ma_sp AND (s.ma_sp like ? or y.ma_kh like ? or DAY(y.ngay_them) = ?" +
                    " or MONTH(y.ngay_them) = ? or Year(y.ngay_them) = ? or g.gia_sp LIKE ?) AND y.ma_kh = ?" +
                    " ORDER BY s." + type + " LIMIT ?," + numberPerPage;

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
            s2.setInt(8, start - 1);


            ResultSet rss = s2.executeQuery();
            list = new ArrayList<Wishlist>();
            while (rss.next()) {

                // lấy ra ngày để sử lí r cho nào class datetime
                String date = rss.getString(7);

                String[] split = date.split(" ");

                String[] dmy = split[0].split("-");
                String[] time = split[1].split(":");

                int year = Integer.parseInt(dmy[0]);
                int month = Integer.parseInt(dmy[1]);
                int day = Integer.parseInt(dmy[2]);
                int hour = Integer.parseInt(time[0]);
                int minute = Integer.parseInt(time[1]);

                double d = Double.parseDouble(time[2]);

                int second = (int) d;

                DateTime datetime = new DateTime(year, month, day, hour, minute, second);


                Wishlist p = new Wishlist();
                p.setName(rss.getString(1));
                p.setPrice(rss.getDouble(2));
                p.setSize(rss.getString(3));
                p.setQuantity(rss.getInt(4));
                p.setColor(rss.getString(5));
                p.setDateAdded(datetime);
                p.setStatus(rss.getInt(6));

                list.add(p);
            }
            rss.close();
            s2.close();
            DataSource.getInstance().releaseConnection(connection);
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return new ArrayList<>();


    }

    public ArrayList<Wishlist> getList() {
        return list;
    }

    public void setList(ArrayList<Wishlist> list) {
        this.list = list;
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
        for (Wishlist w : dao.getAllWishList(1, "kh001", "", "ten_sp", "", "", 1)) {
            System.out.println(w);
        }
        //System.out.println(dao.getQuantity("sp_1","mau_1","size_1"));
    }
}
