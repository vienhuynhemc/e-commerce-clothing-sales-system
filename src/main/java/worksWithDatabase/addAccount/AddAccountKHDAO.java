package worksWithDatabase.addAccount;

import beans.encode.MD5;
import connectionDatabase.DataSource;
import mail.MailModel;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.*;
import java.util.Random;

public class AddAccountKHDAO implements AddAccountInterface{
    public AddAccountKHDAO(){}
    @Override
    public boolean isEmail(String email){
        return MailModel.getInstance().checkEmail(email,MailModel.REGISTER_KH);
    }
    @Override
    public boolean isEmailInDatabase(String email){
        Connection connection = null;

        try {

            connection = DataSource.getInstance().getConnection();

            // type = 3 khach hang
            String sql = "SELECT * FROM tai_khoan WHERE email = ? AND kieu_tai_khoan = 3";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                rs.close();
                ps.close();
                DataSource.getInstance().releaseConnection(connection);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSource.getInstance().releaseConnection(connection);
        }
        return false;
    }

    @Override
    public boolean isAccountInDatabase(String idUser) {
        Connection connection = null;

        try {

            connection = DataSource.getInstance().getConnection();

            String sql = "SELECT * FROM tai_khoan WHERE tai_khoan = ? AND kieu_tai_khoan = 3";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, idUser);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                rs.close();
                ps.close();
                DataSource.getInstance().releaseConnection(connection);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSource.getInstance().releaseConnection(connection);
        }
        return false;
    }
    public boolean addAccount(String userName,String passWord,String email,String avatar,String phone,String displayName,String fullName,String ttdg,String ttkh){

        Connection con = null;

        try {

             con = DataSource.getInstance().getConnection();
            String count = "Select count(*) from tai_khoan where kieu_tai_khoan = 3";
            Statement sm = con.createStatement();
            ResultSet rs = sm.executeQuery(count);

            rs.next();
            Random random = new Random();

            int sum = rs.getInt(1) + random.nextInt(1000);
            String ma_kh = "KH" + sum;

            rs.close();
            //CURRENT_TIMESTAMP

            String hinh_dai_dien = "hinh_dai_dien_kh/" + ma_kh +".jpg";

            String sql =  "INSERT INTO tai_khoan VALUES (?,3,?,?,?,?,null,?,?,?,?,CURRENT_TIMESTAMP,null,null)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,ma_kh);
            ps.setString(2,userName);
            ps.setString(3, MD5.md5(passWord));
            ps.setString(4,email);
            ps.setString(5,phone);
            ps.setString(6,hinh_dai_dien);
            ps.setString(7,avatar);
            ps.setString(8,displayName);
            ps.setString(9,fullName);

            ps.executeUpdate();


            int n1 = Integer.parseInt(ttdg) ;
            int n2 = Integer.parseInt(ttkh);
            String sql2 = "INSERT INTO khach_hang VALUES (?,CURRENT_TIMESTAMP,?,?,1,null)";

            PreparedStatement ps1 = con.prepareStatement(sql2);
            ps1.setString(1,ma_kh);
            ps1.setInt(2, Integer.parseInt(ttkh));
            ps1.setInt(3, Integer.parseInt(ttdg));

            ps1.executeUpdate();

            DataSource.getInstance().releaseConnection(con);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
            return false;
        }
    }

    public static void main(String[] args) {
       // addAccount("kh014","123","thaha@gmail.com","hinhdep","huhu","sasa","nguyen van a","1","1");
        AddAccountKHDAO addAccountKHDAO = new AddAccountKHDAO();
        System.out.println(addAccountKHDAO.isEmail("18108868678678699@st.hcmuaf.edu.vn"));
    }
}
