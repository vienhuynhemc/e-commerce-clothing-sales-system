package worksWithDatabase.loginUser;

import beans.DateTime;
import beans.account.AccountCustomer;
import beans.encode.MD5;

import java.sql.*;

public class LoginUserDAO {

    public LoginUserDAO (){}

    public boolean isUserInDatabase(String user){

        Connection con = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tvtshop?useUnicode=true&characterEncoding=utf-8", "root", "");

          //  con = DataSource.getInstance().getConnection();

            // type = 3 khach hang
            String sql = "SELECT * FROM account WHERE userName = ? and Type = 3";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                rs.close();
                ps.close();
               /// DataSource.getInstance().releaseConnection(con);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            //DataSource.getInstance().releaseConnection(con);
        }

        return false;
    }

    public boolean checkActiveStatus (String user){
        AccountCustomer acc = new AccountCustomer();
        Connection con = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tvtshop?useUnicode=true&characterEncoding=utf-8", "root", "");

            //  con = DataSource.getInstance().getConnection();

            // type = 3 khach hang
            String sql = "select * from account a , customer c WHERE a.IDUser = c.IDUser and c.ActiveStatus = 1 and a.UserName = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                rs.close();
                ps.close();
                /// DataSource.getInstance().releaseConnection(con);
                return true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            //DataSource.getInstance().releaseConnection(con);
        }

        return false;
    }

    public AccountCustomer checkLogin(String user, String pass){
        AccountCustomer acc = new AccountCustomer();
        Connection con = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tvtshop?useUnicode=true&characterEncoding=utf-8", "root", "");

            //  con = DataSource.getInstance().getConnection();

            // type = 3 khach hang
            String sql = "select a.IDUser, a.Type,a.UserName, a.`PassWord`,a.Email,a.Phone, a.Avatar, a.DisplayName,\n" +
                    "                                       a.FullName,a.RegisDate ,c.ActiveStatus,c.ActiveEvaluate\n" +
                    "                                       from account a , customer c WHERE a.IDUser = c.IDUser and c.ActiveStatus = 1 and a.UserName = ? and a.`PassWord` = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            String encode = MD5.md5(pass);

            ps.setString(1, user);
            ps.setString(2,encode);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                acc.setIdUser(rs.getString("IDUser"));
                acc.setType(rs.getInt("type"));
                acc.setUserName(rs.getString("UserName"));
                acc.setPassWord(rs.getString("passWord"));
                acc.setEmail(rs.getString("email"));
                acc.setPhone(rs.getString("phone"));
                acc.setAvatar(rs.getString("avatar"));
                acc.setDisplayName(rs.getString("displayname"));
                acc.setFullName(rs.getString("fullname"));


                String date = rs.getString("RegisDate");
                String[] split = date.split(" ");

                String[] dmy = split[0].split("-");
                String[] time = split[1].split(":");

                // sử lí lấy ra dc ngày tháng năm + time
                int year = Integer.parseInt(dmy[0]);
                int month = Integer.parseInt(dmy[1]);
                int day = Integer.parseInt(dmy[2]);
                int hour = Integer.parseInt(time[0]);
                int minute = Integer.parseInt(time[1]);

                double d = Double.parseDouble(time[2]);

                int second = (int) d;

                DateTime datetime = new DateTime(year,month,day,hour,minute,second);

                acc.setRegisDate(datetime);
                acc.setActiveStatus(rs.getInt("ActiveStatus"));
                acc.setActiveEvaluate(rs.getInt("ActiveEvaluate"));


                rs.close();
                ps.close();
                /// DataSource.getInstance().releaseConnection(con);
                return acc;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            //DataSource.getInstance().releaseConnection(con);
        }

        return null;

    }

    public static void main(String[] args) {
//        LoginUserDAO  loginUserDAO = new LoginUserDAO();
//
//       System.out.println(loginUserDAO.isUserInDatabase("kh005"));
//       System.out.println(loginUserDAO.checkLogin("kh005","khso5"));
//       System.out.println(loginUserDAO.checkActiveStatus("kh004"));
    }

}
