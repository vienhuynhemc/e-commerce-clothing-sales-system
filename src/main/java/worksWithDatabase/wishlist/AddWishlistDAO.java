package worksWithDatabase.wishlist;

import beans.DateTime;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;

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

    public static void main(String[] args) {
        AddWishlistDAO dao = new AddWishlistDAO();
       //System.out.println(dao.addWishlist("sp_1","kh001","mau_1"));
       //System.out.println(dao.updateWishlist("sp004","kh002","vang02"));

//        DateTime now = new DateTime(LocalDate.now().getYear(),LocalDate.now().getMonthValue(),
//                LocalDate.now().getDayOfMonth(), LocalTime.now().getHour(),LocalTime.now().getMinute(),(int)LocalTime.now().getSecond()+);
//        System.out.println(now);

    }

}
