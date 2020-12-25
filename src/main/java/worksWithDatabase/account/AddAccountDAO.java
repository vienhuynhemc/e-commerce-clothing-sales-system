package worksWithDatabase.account;

import connectionDatabase.DataSource;
import mail.MailModel;

import java.sql.*;

public class AddAccountDAO {

    public AddAccountDAO(){

    }
    public boolean isEmail(String email, int type) {
        if(type == 1){
            return MailModel.getInstance().checkEmail(email,MailModel.REGISTER_NVK);
        }else if (type == 2){
            return  MailModel.getInstance().checkEmail(email,MailModel.REGISTER_NVVC);
        }else{
            return  MailModel.getInstance().checkEmail(email,MailModel.REGISTER_KH);
        }
    }

    public boolean isEmailInDatabase(String email,int type) {
        Connection connection = null;

        try {

            connection = DataSource.getInstance().getConnection();

            String sql = "SELECT * FROM account WHERE Email = ? AND Type = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, email);
            ps.setInt(2, type);

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

    public boolean isAccountInDatabase(String idUser, int type){
        Connection connection = null;

        try {

            connection = DataSource.getInstance().getConnection();

            String sql = "SELECT * FROM account WHERE UserName = ? AND Type = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, idUser);
            ps.setInt(2, type);

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

    public static void addAccount(int type,String userName,String passWord,String email,String phone,String displayName,String fullName,String salary,String num,String address,String ttdg,String ttkh){

        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tvtshop?useUnicode=true&characterEncoding=utf-8", "root", "");

           // con = DataSource.getInstance().getConnection();
            String count = "Select count(*) from account where type = ?";
            PreparedStatement ps = con.prepareStatement(count);
            ps.setInt(1,type);

            ResultSet rs = ps.executeQuery();

            rs.next();
            int sum = rs.getInt(1) + 1;

            rs.close();
            ps.close();


            String ia = "\"" + "," + type + ",\"" + userName + "\""
                    + ",\"" + passWord + "\"" + ",\"" + email + "\"" + ",\"" + phone + "\"" + "," + null +"," + null
                    +",\"" + displayName + "\"" + ",\"" + fullName + "\"," + "CURRENT_TIMESTAMP" +"," + null + ")";

            int sa = Integer.parseInt(salary);
            int nu = Integer.parseInt(num);

            String ie = "\"" + "," + sa + "," + nu
                    + "," + type  + ",\"" + address + "\""+ ")";
            if(type == 1){
                String sql =  "INSERT INTO account VALUES (\"NVK0" + sum + ia;
                Statement sm = con.createStatement();
                sm.executeUpdate(sql);

                String sql2 =  "INSERT INTO employee VALUES (\"NVK0" + sum + ie;
                sm.executeUpdate(sql2);
                sm.close();
            }
            if(type == 2){
                String sql =  "INSERT INTO account VALUES (\"NVVC0" + sum + ia;
                Statement sm = con.createStatement();
                sm.executeUpdate(sql);

                String sql2 =  "INSERT INTO employee VALUES (\"NVVC0" + sum + ie;
                sm.executeUpdate(sql2);
                sm.close();
            }
            if (type == 3){

                int n1 = Integer.parseInt(ttdg) ;
                int n2 = Integer.parseInt(ttkh);

                String sql =  "INSERT INTO account VALUES (\"KH0" + sum + ia;
                Statement sm = con.createStatement();
                sm.executeUpdate(sql);

                String sql2 =  "INSERT INTO customer VALUES (\"KH0" + sum + "\"" + "," + "CURRENT_TIMESTAMP" + "," + n1
                        + "," + n2  + ")" ;
                sm.executeUpdate(sql2);
                sm.close();

            }
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
        addAccount(3,"nvk014","123","thaha@gmail.com","022930","huhu","sasa","30000","2","hahaaa","1","1");
    }


}
