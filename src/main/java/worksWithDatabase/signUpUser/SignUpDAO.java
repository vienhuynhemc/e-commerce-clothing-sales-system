package worksWithDatabase.signUpUser;

import beans.DateTime;
import connectionDatabase.DataSource;
import mail.MailModel;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SignUpDAO {
    public SignUpDAO() {

    }
    public static Connection openConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useUnicode=true&characterEncoding=utf-8", "root", "12345");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }
        // kiểm tra user có tồn tại trong hệ thống chưa
        public static boolean checkUser(String name){
              Connection connection = openConnection();
//            Connection connection = DataSource.getInstance().getConnection();
            try{
                PreparedStatement s = connection.prepareStatement("SELECT * FROM account WHERE UserName = ?");
                s.setString(1,name);
                ResultSet rs = s.executeQuery();
                if(rs.next()){
                    return true;
                }
//                DataSource.getInstance().releaseConnection(connection);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return false;
//            DataSource.getInstance().releaseConnection(connection);
    }
    // kiểm tra mail có tồn tại trong hệ thống chưa
    public static boolean checkMail(String mail){
        Connection connection = openConnection();
//            Connection connection = DataSource.getInstance().getConnection();
        try{
            PreparedStatement s = connection.prepareStatement("SELECT * FROM account WHERE Email = ?");
            s.setString(1,mail);
            ResultSet rs = s.executeQuery();
            if(rs.next()){
                return true;
            }
//                DataSource.getInstance().releaseConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
//            DataSource.getInstance().releaseConnection(connection);
    }
    public static void addUserIntoCustomers(String id, String regisDate){
        Connection connection = openConnection();
        try{
            LocalDate date = LocalDate.now();
            LocalDateTime time = LocalDateTime.now();
            DateTime dateTime = new DateTime(date.getYear(),date.getMonthValue(),
                    date.getDayOfMonth(),time.getHour(),time.getMinute(),time.getSecond());
            PreparedStatement s = connection.prepareStatement("INSERT INTO customer VALUES(?,?,1,1)");
            s.setString(1,id);
            s.setString(2,dateTime.toString());
            s.execute();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static boolean addUser( String username, String pass, String name,String phone, String mail){
        Connection connection = openConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM account");
            rs.last();
            int row = rs.getRow();
            LocalDate date = LocalDate.now();
            LocalDateTime now = LocalDateTime.now();
            DateTime dateTime = new DateTime(date.getYear(),date.getMonthValue(),
                    date.getDayOfMonth(),now.getHour(),now.getMinute(),now.getSecond());
            PreparedStatement s = connection.prepareStatement( "INSERT INTO `account` (`IDUser`, `Type`, `UserName`" +
                    ", `PassWord`, `Email`, `Phone`, " +
                    "`ForgotPass`, `Avatar`, `DisplayName`, `FullName`, `RegisDate`, `CodeTerm`) VALUES" +
                    " (?, 3, ?, ?, ?, ?, NULL, NULL, ?, ?, ?, NULL);");

            s.setString(1,"KH0"+(row+1));
            String id = "KH0"+(row+1);
            s.setString(2,username);
            s.setString(3,pass);
            s.setString(4,mail);
            s.setString(5,phone);
            s.setString(6,name);
            s.setString(7,name);
            s.setString(8,dateTime.toString());
            s.execute();

            addUserIntoCustomers(id,dateTime.toString());

            rs.close();
            st.close();
            s.close();
            return true;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean isEmail(String email){
        return MailModel.getInstance().checkEmail(email,MailModel.REGISTER_KH);
    }

    public static void main(String[] args) {
//        System.out.println(checkUser("KH001"));
//        System.out.println(checkMail("luyducpho@gmail.com"));
       // System.out.println(addUser("truong123","agtmzxc","HUYNH NHAT TRUONG","0961185373","nhattruongagtm@gmail.com"));
//        System.out.print(isEmail("nhattruongagtm@gmail.com"));
    }
}
