package worksWithDatabase.wishlist;

import connectionDatabase.DataSource;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddWishlistDAO {
    public AddWishlistDAO(){

    }
    // kiểm tra xem sp có nằm trong trong wishlist chưa?
    public boolean isExist(String idProduct, String idCustomer, String color){
        Connection connection = DataSource.getInstance().getConnection();
        try{
            PreparedStatement s = connection.prepareStatement("" +
                    "SELECT * FROM yeu_thich where ma_sp = ? AND ma_kh = ? AND ma_mau = ?");
            s.setString(1,idProduct);
            s.setString(2,idCustomer);
            s.setString(3,color);

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
    public boolean insertWishlist(String idProduct, String idCustomer, String color){
        Connection connection = DataSource.getInstance().getConnection();
        try{
            PreparedStatement s = connection.prepareStatement("INSERT INTO yeu_thich VALUES(?,?,?,1)");
            s.setString(1,idProduct);
            s.setString(2,idCustomer);
            s.setString(3,color);

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
    public boolean updateWishlist(String idProduct, String idCustomer, String color){
        Connection connection = DataSource.getInstance().getConnection();
        try{
            PreparedStatement s = connection.prepareStatement("UPDATE yeu_thich SET so_luong = so_luong + 1 WHERE" +
                    " ma_sp = ? AND ma_kh = ? AND ma_mau = ?");
            s.setString(1,idProduct);
            s.setString(2,idCustomer);
            s.setString(3,color);

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
    public boolean addWishlist(String idProduct, String idCustomer, String color){
        Connection connection = DataSource.getInstance().getConnection();
        try{
            if(!isExist(idProduct,idCustomer,color)){
                if(insertWishlist(idProduct,idCustomer,color)){
                    DataSource.getInstance().releaseConnection(connection);
                    return true;
                }
            }
            else{
                if(updateWishlist(idProduct,idCustomer,color)){
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
       //System.out.println(dao.addWishlist("sp003","kh002","vang02"));
        //System.out.println(dao.updateWishlist("sp004","kh002","vang02"));
    }

}
