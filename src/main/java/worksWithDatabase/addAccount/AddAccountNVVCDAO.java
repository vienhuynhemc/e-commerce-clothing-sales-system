package worksWithDatabase.addAccount;

import connectionDatabase.DataSource;
import mail.MailModel;

import java.sql.*;

public class AddAccountNVVCDAO implements AddAccountInterface {

    public AddAccountNVVCDAO(){}
    @Override
    public boolean isEmail(String email){
        return MailModel.getInstance().checkEmail(email,MailModel.REGISTER_NVVC);
    }
    @Override
    public boolean isEmailInDatabase(String email){
        Connection connection = null;

        try {

            connection = DataSource.getInstance().getConnection();

            // type = 2 nhân viên vận chuyển
            String sql = "SELECT * FROM account WHERE Email = ? AND Type = 2";

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

            String sql = "SELECT * FROM account WHERE UserName = ? AND Type = 2";

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
    public static void addAccount(String userName,String passWord,String email,String phone, String avatar,String displayName,String fullName,String salary,String num,String address){

        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tvtshop?useUnicode=true&characterEncoding=utf-8", "root", "");

            // con = DataSource.getInstance().getConnection();
            String count = "Select count(*) from account where type = 2";
            Statement sm = con.createStatement();
            ResultSet rs = sm.executeQuery(count);

            rs.next();
            int sum = rs.getInt(1) + 1;

            rs.close();

            String sql =  "INSERT INTO account VALUES (\"NVVC0" + sum + "\"" + "," + 2 + ",\"" + userName + "\""
                    + ",\"" + passWord + "\"" + ",\"" + email + "\"" + ",\"" + phone + "\"" + "," + avatar +"," + null
                    +",\"" + displayName + "\"" + ",\"" + fullName + "\"," + "CURRENT_TIMESTAMP" +"," + null + ")";

            sm.executeUpdate(sql);

            int su = Integer.parseInt(salary);
            int nu = Integer.parseInt(num);

            String sql2 =  "INSERT INTO employee VALUES (\"NVVC0" + sum + "\"" + "," + su + "," + nu
                    + "," + 2  + ",\"" + address + "\""+ ")";
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
        addAccount("nvk014","123","thaha@gmail.com","0234234","022930","huhu","sasa","30000","2","hahaaa");
    }

}
