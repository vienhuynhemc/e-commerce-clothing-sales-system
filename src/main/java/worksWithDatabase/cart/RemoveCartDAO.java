package worksWithDatabase.cart;

import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RemoveCartDAO {
    public RemoveCartDAO() {
    }

    public boolean remove(String ma_sp,String ma_kh,String ma_mau,String ma_size) {
        Connection con = null;
        try {
             con = DataSource.getInstance().getConnection();

            String exe = "delete FROM gio_hang WHERE ma_sp = ? and ma_kh = ? and ma_mau = ? and ma_size = ?";

            PreparedStatement ps = ps = con.prepareStatement(exe);

            ps.setString(1, ma_sp);
            ps.setString(2, ma_kh);
            ps.setString(3, ma_mau);
            ps.setString(4, ma_size);

            int n = ps.executeUpdate();

            ps.close();


            if(n == 1){
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
        RemoveCartDAO cartDAO = new RemoveCartDAO();
        System.out.println(cartDAO.remove("sp_1","kh001","mau_2","size_1"));
    }
}
