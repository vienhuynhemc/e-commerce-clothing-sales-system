package worksWithDatabase.wishlist;

import beans.DateTime;
import beans.wishlist.Wishlist;
import beans.wishlist.WishlistToCart;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class AddWishlistDAO {
    public AddWishlistDAO(){

    }
    // kiểm tra xem sp có nằm trong trong wishlist chưa?
    public boolean isExist(String idProduct, String idCustomer, String color,String size){
        Connection connection = DataSource.getInstance().getConnection();
        try{
            PreparedStatement s = connection.prepareStatement("" +
                    "SELECT * FROM yeu_thich where ma_sp = ? AND ma_kh = ? AND ma_mau = ? AND size = ?");
            s.setString(1,idProduct);
            s.setString(2,idCustomer);
            s.setString(3,color);
            s.setString(4,size);

            ResultSet rs = s.executeQuery();
            if(rs.next()){
                DataSource.getInstance().releaseConnection(connection);
                return true;
            }
            rs.close();
            s.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return false;
    }
    // them san pham moi vao wishlist
    public boolean insertWishlist(String idProduct, String idCustomer, String color,String size){
        Connection connection = DataSource.getInstance().getConnection();
        try{
            PreparedStatement s = connection.prepareStatement("INSERT INTO yeu_thich VALUES(?,?,?,1,?,?)");
            s.setString(1,idProduct);
            s.setString(2,idCustomer);
            s.setString(3,color);
            DateTime now = new DateTime(LocalDate.now().getYear(),LocalDate.now().getMonthValue(),
                    LocalDate.now().getDayOfMonth(), LocalTime.now().getHour(),LocalTime.now().getMinute(),LocalTime.now().getSecond());

            s.setString(4,now.toString());
            s.setString(5,size);

            int row = s.executeUpdate();
            if(row > 0) {
                DataSource.getInstance().releaseConnection(connection);
                return true;
            }
            s.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return false;
    }
    // cap nhap san pham da co trong wishlist
    public boolean updateWishlist(String idProduct, String idCustomer, String color,String size){
        Connection connection = DataSource.getInstance().getConnection();
        try{
            PreparedStatement s = connection.prepareStatement("UPDATE yeu_thich SET so_luong = so_luong + 1,ngay_them = ? WHERE" +
                    " ma_sp = ? AND ma_kh = ? AND ma_mau = ? AND size = ?");

            DateTime now = new DateTime(LocalDate.now().getYear(),LocalDate.now().getMonthValue(),
                    LocalDate.now().getDayOfMonth(), LocalTime.now().getHour(),LocalTime.now().getMinute(),LocalTime.now().getSecond());
            s.setString(1,now.toString());
            s.setString(2,idProduct);
            s.setString(3,idCustomer);
            s.setString(4,color);
            s.setString(5,size);
            int row = s.executeUpdate();
            if(row > 0){
                DataSource.getInstance().releaseConnection(connection);
                s.close();
                return true;
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return false;
    }
    // them san pham vao wishlist
    public boolean addWishlist(String idProduct, String idCustomer, String color, String size){
        Connection connection = DataSource.getInstance().getConnection();
        try{
            if(!isExist(idProduct,idCustomer,color,size)){
                if(insertWishlist(idProduct,idCustomer,color,size)){
                    DataSource.getInstance().releaseConnection(connection);
                    return true;
                }
            }
            else{
                if(updateWishlist(idProduct,idCustomer,color,size)){
                    DataSource.getInstance().releaseConnection(connection);
                    return true;
                }
            }
            DataSource.getInstance().releaseConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return false;
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
    public boolean checkCustomer(String id){
        Connection connection = DataSource.getInstance().getConnection();
        try{
            PreparedStatement p = connection.prepareStatement("SELECT * FROM khach_hang WHERE ma_kh = ?");
            p.setString(1,id);
            ResultSet rs = p.executeQuery();
            if(rs.next()){
                rs.close();
                p.close();
                DataSource.getInstance().releaseConnection(connection);
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return false;

    }
    public void addWishlistToCart(String idCustomer, ArrayList<WishlistToCart> list){
        if(checkCustomer(idCustomer)) {
            for (WishlistToCart w : list){
                addCart(w.getIdProduct(), idCustomer, w.getColor(), w.getSize(), w.getQuantity());
                System.out.println("Them thanh cong" + w);
            }
        }
    }

    public static void main(String[] args) {
        AddWishlistDAO dao = new AddWishlistDAO();
       //System.out.println(dao.addWishlist("sp_1","kh001","mau_1"));
       //System.out.println(dao.updateWishlist("sp004","kh002","vang02"));

//        DateTime now = new DateTime(LocalDate.now().getYear(),LocalDate.now().getMonthValue(),
//                LocalDate.now().getDayOfMonth(), LocalTime.now().getHour(),LocalTime.now().getMinute(),(int)LocalTime.now().getSecond()+);
//        System.out.println(now);

        ArrayList<WishlistToCart> w = new ArrayList<WishlistToCart>();
        w.add(new WishlistToCart("sp_1","mau_1","size_1",1));
        w.add(new WishlistToCart("sp_1","mau_2","size_1",1));

       dao.addWishlistToCart("kh001",w);
    }


}
