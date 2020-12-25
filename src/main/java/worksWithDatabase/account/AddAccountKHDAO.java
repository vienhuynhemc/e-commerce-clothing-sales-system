package worksWithDatabase.account;

import connectionDatabase.DataSource;
import mail.MailModel;

import java.sql.*;

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
            String sql = "SELECT * FROM account WHERE Email = ? AND Type = 3";

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

            String sql = "SELECT * FROM account WHERE UserName = ? AND Type = 3";

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
    public static void addAccount(String userName,String passWord,String email,String avatar,String phone,String displayName,String fullName,String ttdg,String ttkh){

        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tvtshop?useUnicode=true&characterEncoding=utf-8", "root", "");

            // con = DataSource.getInstance().getConnection();
            String count = "Select count(*) from account where type = 3";
            Statement sm = con.createStatement();
            ResultSet rs = sm.executeQuery(count);

            rs.next();
            int sum = rs.getInt(1) + 1;

            rs.close();

            String sql =  "INSERT INTO account VALUES (\"KH0" + sum + "\"" + "," + 3 + ",\"" + userName + "\""
                    + ",\"" + passWord + "\"" + ",\"" + email + "\"" + ",\"" + phone + "\"" + ",\"" + avatar +"\"," + null
                    +",\"" + displayName + "\"" + ",\"" + fullName + "\"," + "CURRENT_TIMESTAMP" +"," + null + ")";

            sm.executeUpdate(sql);

            int n1 = Integer.parseInt(ttdg) ;
            int n2 = Integer.parseInt(ttkh);
            String sql2 = "INSERT INTO customer VALUES (\"KH0" + sum + "\"" + "," + "CURRENT_TIMESTAMP" + "," + n1
                        + "," + n2  + ")";
            sm.executeUpdate(sql2);

            sm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //  DataSource.getInstance().releaseConnection(con);
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        addAccount("kh014","123","thaha@gmail.com","hinhdep","huhu","sasa","nguyen van a","1","1");
    }
}
