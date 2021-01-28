package worksWithDatabase.loginUser;

import beans.DateTime;
import beans.account.AccountCustomer;
import beans.account.ConvertDate;
import beans.encode.MD5;
import connectionDatabase.DataSource;

import java.sql.*;

public class LoginUserDAO {

    public LoginUserDAO (){}

    public boolean isUserInDatabase(String user){

        Connection con = null;

        try {

            con = DataSource.getInstance().getConnection();

            // type = 3 khach hang
            String sql = "SELECT * FROM tai_khoan WHERE tai_khoan = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                rs.close();
                ps.close();
                DataSource.getInstance().releaseConnection(con);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
            return false;
        }
        DataSource.getInstance().releaseConnection(con);
        return false;
    }

    public boolean checkActiveStatus (String user){
        AccountCustomer acc = new AccountCustomer();
        Connection con = null;
        try {

              con = DataSource.getInstance().getConnection();

            // type = 3 khach hang
            String sql = "select * from tai_khoan a , khach_hang c WHERE a.ma_tai_khoan = c.ma_kh and a.kieu_tai_khoan = 3 and c.trang_thai_kich_hoat = 1 and c.ton_tai = 1 and a.tai_khoan = ? ";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                rs.close();
                ps.close();
                 DataSource.getInstance().releaseConnection(con);
                return true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
            return false;
        }
        DataSource.getInstance().releaseConnection(con);
        return false;
    }

    public AccountCustomer checkLogin(String user, String pass){
        AccountCustomer acc = new AccountCustomer();
        Connection con = null;
        try {

              con = DataSource.getInstance().getConnection();

            // type = 3 khach hang
            String sql = "select a.ma_tai_khoan, a.kieu_tai_khoan,a.tai_khoan, a.mat_khau,a.email,a.so_dien_thoai, a.link_hinh_dai_dien, a.ten_hien_thi,\n" +
                    "                                       a.ten_day_du,a.ngay_tao,a.han_su_dung_ma_qmk ,c.trang_thai_kich_hoat,c.trang_thai_danh_gia,c.ton_tai,c.ngon_ngu \n" +
                    "                                       from tai_khoan a , khach_hang c WHERE a.ma_tai_khoan = c.ma_kh and c.trang_thai_kich_hoat = 1 and a.tai_khoan = ? and a.mat_khau = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            String encode = MD5.md5(pass);

            ps.setString(1, user);
            ps.setString(2,encode);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                acc.setIdUser(rs.getString("ma_tai_khoan"));
                acc.setType(rs.getInt("kieu_tai_khoan"));
                acc.setUserName(rs.getString("tai_khoan"));
                acc.setPassWord(rs.getString("mat_khau"));
                acc.setEmail(rs.getString("email"));
                acc.setPhone(rs.getString("so_dien_thoai"));
                acc.setAvatar(rs.getString("link_hinh_dai_dien"));
                acc.setDisplayName(rs.getString("ten_hien_thi"));
                acc.setFullName(rs.getString("ten_day_du"));
                acc.setDeadline(ConvertDate.changeDate(rs.getString("han_su_dung_ma_qmk")));
                acc.setRegisDate(ConvertDate.changeDate(rs.getString("ngay_tao")));
                acc.setActiveStatus(rs.getInt("trang_thai_kich_hoat"));
                acc.setActiveEvaluate(rs.getInt("trang_thai_danh_gia"));
                acc.setTon_tai(rs.getInt("ton_tai"));
                acc.setNgon_ngu(rs.getString("ngon_ngu"));


                rs.close();
                ps.close();
                DataSource.getInstance().releaseConnection(con);
                return acc;
            }
        } catch (Exception e) {
            DataSource.getInstance().releaseConnection(con);
        } finally {

            DataSource.getInstance().releaseConnection(con);
        }
        DataSource.getInstance().releaseConnection(con);
        return null;

    }

    public static void main(String[] args) {
        LoginUserDAO  loginUserDAO = new LoginUserDAO();

      // System.out.println(loginUserDAO.isUserInDatabase("kh001"));
      // System.out.println(loginUserDAO.checkLogin("kh001","khso1"));
      // System.out.println(loginUserDAO.checkActiveStatus("kh001"));
    }

}
