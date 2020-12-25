package worksWithDatabase.account;

import connectionDatabase.DataSource;
import mail.MailModel;

import java.sql.*;

public class AddAccountNVKDAO implements AddAccountInterface{

    public AddAccountNVKDAO(){

    }
    @Override
    public boolean isEmail(String email) {
       // if(type == 1){
            return MailModel.getInstance().checkEmail(email,MailModel.REGISTER_NVK);
       // }else if (type == 2){
       //     return  MailModel.getInstance().checkEmail(email,MailModel.REGISTER_NVVC);
       // }else{
       //     return  MailModel.getInstance().checkEmail(email,MailModel.REGISTER_KH);
       // }
    }
    // kiểm tra email có trong database hay k
    @Override
    public boolean isEmailInDatabase(String email) {
        Connection connection = null;

        try {
            // tạo connection
            connection = DataSource.getInstance().getConnection();
            // type = 1 - nhân viên kho
            String sql = "SELECT * FROM account WHERE Email = ? AND Type = 1";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            // nếu next dc thì có email rồi -> trả kết nối -> return
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
    // kiểm tra có tài khoản trong database hay k
    @Override
    public boolean isAccountInDatabase(String userName){
        Connection connection = null;

        try {

            connection = DataSource.getInstance().getConnection();

            String sql = "SELECT * FROM account WHERE UserName = ? AND Type = 1";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, userName);

            ResultSet rs = ps.executeQuery();
            // nếu next dc thì có email rồi -> trả kết nối -> return
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

    public static void addAccount(String userName,String passWord,String email,String phone,String avatar,String displayName,String fullName,int salary,int num,String address){

        Connection con = null;

        try {
            // test thử thôi chứ lấy connec dưới
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tvtshop?useUnicode=true&characterEncoding=utf-8", "root", "");

           // con = DataSource.getInstance().getConnection();

            // iduser tự tạo nên đếm số lượng isuser đang có r tăng thêm 1
            String count = "Select count(*) from account where type = 1";
            Statement sm = con.createStatement();
            ResultSet rs = sm.executeQuery(count);

            // next cái lấy dc giá trị
            rs.next();
            int sum = rs.getInt(1) + 1;
            rs.close();



            // sql insert nhân viên kho vào bảng account
            String sql =  "INSERT INTO account VALUES (\"NVK0" + sum + "\"" + "," + 1 + ",\"" + userName + "\""
                        + ",\"" + passWord + "\"" + ",\"" + email + "\"" + ",\"" + phone + "\"" + "," + avatar +"," + null
                        + ",\"" + displayName + "\"" + ",\"" + fullName + "\"," + "CURRENT_TIMESTAMP" +"," + null + ")";

            sm.executeUpdate(sql);

            // sql insert vào bảng employee
            String sql2 =  "INSERT INTO employee VALUES (\"NVK0" + sum + "\"" + "," + salary + "," + num
                        + "," + 1  + ",\"" + address + "\""+ ")";
            sm.executeUpdate(sql2);
            sm.close();

//            if (type == 3){
//
//                int n1 = Integer.parseInt(ttdg) ;
//                int n2 = Integer.parseInt(ttkh);
//
//                String sql =  "INSERT INTO account VALUES (\"KH0" + sum + ia;
//                Statement sm = con.createStatement();
//                sm.executeUpdate(sql);
//
//                String sql2 =  "INSERT INTO customer VALUES (\"KH0" + sum + "\"" + "," + "CURRENT_TIMESTAMP" + "," + n1
//                        + "," + n2  + ")" ;
//                sm.executeUpdate(sql2);
//                sm.close();
//
//            }
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
        addAccount("nvk014","123","thaha@gmail.com","022930","2332","huhu","sasa",30000,2,"hahaaa");
    }


}
