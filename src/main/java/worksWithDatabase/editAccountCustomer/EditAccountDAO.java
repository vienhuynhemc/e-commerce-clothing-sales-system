package worksWithDatabase.editAccountCustomer;

import beans.DateTime;
import beans.account.AccountCustomer;
import beans.encode.MD5;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class EditAccountDAO {

    public EditAccountDAO(){}

    // pt chess username pass có đúng hay k?
    public boolean checkOldPassWord(String userName,String passWord ){

        Connection con = null;

        try {

            // sài tạm database khác khi nào có thì dùng cái này
            // con = DataSource.getInstance().getConnection();

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tvtshop?useUnicode=true&characterEncoding=utf-8", "root", "");

            String sql = "Select * from account where userName = ? and passWord = ? and type = 3";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,userName);

            String encode = MD5.md5(passWord);

            ps.setString(2,encode);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                rs.close();
                ps.close();
                //DataSource.getInstance().releaseConnection(con);
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            // chưa có database nên test thủ
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            // DataSource.getInstance().releaseConnection(con);
        }


      return false;

    }

    public AccountCustomer changeInfoCustomer(String userName, String displayName, String fullName, String avatar, String newPass,String oldPass,String rePass){

        Connection con = null;

        AccountCustomer acc = new AccountCustomer();

        try {

            // sài tạm database khác khi nào có thì dùng cái này
            // con = DataSource.getInstance().getConnection();

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tvtshop?useUnicode=true&characterEncoding=utf-8", "root", "");
            String sql;

            if(oldPass.equals("") && newPass.equals("") && rePass.equals("")){
                sql = "UPDATE account a set a.DisplayName = ?, a.FullName = ?,a.Avatar = ? WHERE a.UserName = ?";
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1,displayName);
                ps.setString(2,fullName);
                ps.setString(3,avatar);

                ps.setString(4,userName);
                ps.executeUpdate();
                ps.close();

            }else{
                sql = "UPDATE account a set a.DisplayName = ?, a.FullName = ?,a.Avatar = ?,a.`PassWord` = ?  WHERE a.UserName = ?";
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1,displayName);
                ps.setString(2,fullName);
                ps.setString(3,avatar);

                String encode = MD5.md5(newPass);

                ps.setString(4,encode);
                ps.setString(5,userName);
                ps.executeUpdate();
                ps.close();
            }


           String sql1 = "select * from account where userName = ? and type = 3";

            PreparedStatement ps1 = con.prepareStatement(sql1);

            ps1.setString(1,userName);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()){

                String date = rs.getString("RegisDate");
                String[] split = date.split(" ");
                String[] dmy = split[0].split("-");
                String[] time = split[1].split(":");

                int year = Integer.parseInt(dmy[0]);
                int month = Integer.parseInt(dmy[1]);
                int day = Integer.parseInt(dmy[2]);
                int hour = Integer.parseInt(time[0]);
                int minute = Integer.parseInt(time[1]);

                int second = (int) Double.parseDouble(time[2]);

                DateTime datetime = new DateTime(year,month,day,hour,minute,second);


                acc.setIdUser(rs.getString("idUser"));
                acc.setType(rs.getInt("type"));
                acc.setUserName(rs.getString("UserName"));
                acc.setPassWord(rs.getString("passWord"));
                acc.setEmail(rs.getString("email"));
                acc.setPhone(rs.getString("phone"));
                acc.setAvatar(rs.getString("avatar"));
                acc.setDisplayName(rs.getString("displayname"));
                acc.setRegisDate(datetime);
                acc.setFullName(rs.getString("fullname"));
                rs.close();
                ps1.close();
            }
          // DataSource.getInstance().releaseConnection(con);

           return acc;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            // chưa có database nên test thủ
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            // DataSource.getInstance().releaseConnection(con);
        }
        return acc;
    }


    public static void main(String[] args) {
        EditAccountDAO editAccountDAO = new EditAccountDAO();
      //  System.out.println(editAccountDAO.checkOldPassWord("kh005","andeptrai"));

     //   System.out.println(editAccountDAO.changeInfoCustomer("KH005","An NoPro","Nguyễn Văn An","dẹp chai","andeptrai"));


    }

}
