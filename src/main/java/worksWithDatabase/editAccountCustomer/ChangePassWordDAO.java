package worksWithDatabase.editAccountCustomer;

import beans.encode.MD5;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangePassWordDAO {

    public ChangePassWordDAO() {
    }

    public boolean checkOldPassWord(String userName,String passWord ){

        Connection con = null;

        try {
            con = DataSource.getInstance().getConnection();


            String sql = "Select * from tai_khoan where tai_khoan = ? and mat_khau = ? and kieu_tai_khoan = 3";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,userName);

            String encode = MD5.md5(passWord);

            ps.setString(2,encode);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
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

    public boolean changePassWord(String user,String newPass){

        Connection con = null;

        try {
            con = DataSource.getInstance().getConnection();


            String sql = "update tai_khoan set mat_khau = ? where tai_khoan = ? and kieu_tai_khoan = 3";

            PreparedStatement ps = con.prepareStatement(sql);

            String encode = MD5.md5(newPass);
            ps.setString(1,encode);
            ps.setString(2,user);

           int check = ps.executeUpdate();

            if(check == 1){
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

    public static void main(String[] args) {
        ChangePassWordDAO changePassWordDAO = new ChangePassWordDAO();
       // System.out.println(changePassWordDAO.checkOldPassWord("KH001","khso1"));
        System.out.println(changePassWordDAO.changePassWord("kh001","khso1"));
    }
}
