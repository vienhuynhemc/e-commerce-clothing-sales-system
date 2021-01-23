package worksWithDatabase.editAccountCustomer;

import beans.DateTime;
import beans.account.AccountCustomer;
import beans.account.ConvertDate;
import beans.encode.MD5;
import connectionDatabase.DataSource;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class EditAccountDAO {

    public EditAccountDAO(){}


    public AccountCustomer changeInfoCustomer(String userName, String displayName, String fullName, String avatar){
        Connection con = null;
        AccountCustomer acc = null;
        try {
             con = DataSource.getInstance().getConnection();

             String sql = "UPDATE tai_khoan a set a.ten_hien_thi = ?, a.ten_day_du = ?,a.link_hinh_dai_dien = ?  WHERE a.ma_tai_khoan = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,displayName);
            ps.setString(2,fullName);
            ps.setString(3,avatar);
            ps.setString(4,userName);

            int check = ps.executeUpdate();
            ps.close();

            if (check == 1){
                String sql1 = "select a.ma_tai_khoan, a.kieu_tai_khoan,a.tai_khoan, a.mat_khau,a.email,a.so_dien_thoai, a.link_hinh_dai_dien, a.ten_hien_thi,\n" +
                        "a.ten_day_du,a.ngay_tao,a.han_su_dung_ma_qmk ,c.trang_thai_kich_hoat,c.trang_thai_danh_gia,c.ton_tai,c.ngon_ngu \n" +
                        "from tai_khoan a , khach_hang c WHERE a.ma_tai_khoan = c.ma_kh and c.trang_thai_kich_hoat = 1 and a.tai_khoan = ?";

                PreparedStatement ps1 = con.prepareStatement(sql1);
                ps1.setString(1,userName);

                ResultSet rs = ps1.executeQuery();

                if (rs.next()){
                    acc = new AccountCustomer();
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
            }
            DataSource.getInstance().releaseConnection(con);
            return acc;
        } catch (Exception e) {
            e.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
            return acc;
        }
    }


    public static void main(String[] args) {
        EditAccountDAO editAccountDAO = new EditAccountDAO();
      //  System.out.println(editAccountDAO.checkOldPassWord("kh005","andeptrai"));

        System.out.println(editAccountDAO.changeInfoCustomer("KH002","An NoPro","Nguyễn Văn An","kook"));


    }

}
