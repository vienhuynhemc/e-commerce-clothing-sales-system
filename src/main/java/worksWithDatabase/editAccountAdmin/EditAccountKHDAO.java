package worksWithDatabase.editAccountAdmin;

import beans.encode.MD5;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditAccountKHDAO {

    public EditAccountKHDAO() {
    }
    public boolean updateAccountKH(String userName,String fullName,String displayName,String activeStatus,String activeEvaluate,String passWord){
        Connection con = null;

        try {

             con = DataSource.getInstance().getConnection();

        String sql = "UPDATE tai_khoan a , khach_hang c SET a.ten_hien_thi = ?, a.ten_day_du = ?, a.mat_khau = ?, c.trang_thai_kich_hoat = ?," +
                "c.trang_thai_danh_gia = ? WHERE a.ma_tai_khoan = c.ma_kh and a.ma_tai_khoan = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            String encode = MD5.md5(passWord);

            ps.setString(1,displayName);
            ps.setString(2,fullName);
            ps.setString(3,encode);
            ps.setInt(4,Integer.parseInt(activeStatus));
            ps.setInt(5,Integer.parseInt(activeEvaluate));
            ps.setString(6,userName);

            ps.executeUpdate();

            ps.close();
            con.close();
            DataSource.getInstance().releaseConnection(con);
            return true;

        }  catch (SQLException throwables) {
            throwables.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
            return false;
        }
    }

    public static void main(String[] args) {
        EditAccountKHDAO editAccountKHDAO = new EditAccountKHDAO();
        System.out.println(editAccountKHDAO.updateAccountKH("kh218","nguyen van an","detrailam","an no pro","1","0"));
    }
}
