package worksWithDatabase.wishlist;

import beans.DateTime;
import beans.wishlist.Wishlist;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class RemoveWishlistDAO {
    public RemoveWishlistDAO(){

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
    public boolean removeWishlist(String idProduct, String idCustomer, String color,String size) {
        Connection connection = DataSource.getInstance().getConnection();
        try{
            PreparedStatement s = connection.prepareStatement("DELETE" +
                    " FROM yeu_thich where ma_sp = ? AND ma_kh = ? AND ma_mau = ? AND ma_size = ?");
            s.setString(1,idProduct);
            s.setString(2,idCustomer);
            s.setString(3,color);
            s.setString(4,size);

            int a = s.executeUpdate();
            if(a > 0) {
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
    public int removeWishlists(ArrayList<Wishlist> list){
        for(Wishlist w : list){
//            removeWishlist(new Wishlist(w.getName(),w.getPrice(),w.getSize(),w.getQuantity(),w.getColor(),w.getDateAdded(),w.getRestNumber(),w.getImg()));
        }
        return 0;
    }


    public static void main(String[] args) {
        RemoveWishlistDAO dao = new RemoveWishlistDAO();
        System.out.println(dao.removeWishlist("sp_2","kh001","mau_2","size_1"));

    }

}
