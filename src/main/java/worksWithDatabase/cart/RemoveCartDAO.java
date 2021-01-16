package worksWithDatabase.cart;

import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RemoveCartDAO {
    public RemoveCartDAO() {
    }

    public boolean remove(String ma_sp,String ma_kh,String ma_mau) {
        try {
            Connection con = DataSource.getInstance().getConnection();

            String check = "SELECT * FROM gio_hang WHERE ma_sp = ? and ma_kh = ? and ma_mau = ?";

            PreparedStatement ps = ps = con.prepareStatement(check);

            ps.setString(1, ma_sp);
            ps.setString(2, ma_kh);
            ps.setString(3, ma_mau);

            ResultSet rs = ps.executeQuery();
            String exe = "";
            if (rs.next()){

                String soluong = "select so_luong from gio_hang WHERE ma_sp = ? and ma_kh = ? and ma_mau = ?";
                PreparedStatement ps0 = con.prepareStatement(soluong);
                ps0.setString(1,ma_sp);
                ps0.setString(2,ma_kh);
                ps0.setString(3,ma_mau);

                ResultSet rs0 = ps0.executeQuery();
                int soluongsp = 0;
                if(rs0.next()){
                    soluongsp = rs0.getInt("so_luong") - 1;
                }
                rs0.close();
                ps0.close();

                exe = "UPDATE gio_hang set so_luong = " +soluongsp +" WHERE ma_sp = ? and ma_kh = ? and ma_mau = ?";
            }
            rs.close();
            ps.close();


            PreparedStatement pse = con.prepareStatement(exe);

            pse.setString(1,ma_sp);
            pse.setString(2,ma_kh);
            pse.setString(3,ma_mau);

            int n = pse.executeUpdate();

            DataSource.getInstance().releaseConnection(con);

            if(n != 0)
                return true;
            else
                return false;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        RemoveCartDAO cartDAO = new RemoveCartDAO();
        System.out.println(cartDAO.remove("sp_1","kh001","mau_1"));
    }
}
