package worksWithDatabase.signUpUser;

import beans.DateTime;
import connectionDatabase.DataSource;
import mail.MailModel;

import javax.xml.crypto.Data;
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
           //   Connection connection = openConnection();
            Connection connection = DataSource.getInstance().getConnection();
            try{
                PreparedStatement s = connection.prepareStatement("SELECT * FROM tai_khoan WHERE tai_khoan = ?");
                s.setString(1,name);
                ResultSet rs = s.executeQuery();
                if(rs.next()){
                    DataSource.getInstance().releaseConnection(connection);
                    return true;
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }

            DataSource.getInstance().releaseConnection(connection);
            return false;
    }
    // kiểm tra mail có tồn tại trong hệ thống chưa
    public static boolean checkMail(String mail){
       // Connection connection = openConnection();
           Connection connection = DataSource.getInstance().getConnection();
        try{
            PreparedStatement s = connection.prepareStatement("SELECT * FROM tai_khoan WHERE email = ?");
            s.setString(1,mail);
            ResultSet rs = s.executeQuery();
            if(rs.next()){
                DataSource.getInstance().releaseConnection(connection);
                return true;
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return false;
    }
    public static void addUserIntoCustomers(String id, String regisDate){
        Connection connection = DataSource.getInstance().getConnection();
        try{
            LocalDate date = LocalDate.now();
            LocalDateTime time = LocalDateTime.now();
            DateTime dateTime = new DateTime(date.getYear(),date.getMonthValue(),
                    date.getDayOfMonth(),time.getHour(),time.getMinute(),time.getSecond());
            PreparedStatement s = connection.prepareStatement("INSERT INTO khach_hang VALUES(?,?,1,1,null,null)");
            s.setString(1,id);
            s.setString(2,dateTime.toString());
            s.executeUpdate();
                DataSource.getInstance().releaseConnection(connection);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static boolean addUser( String username, String pass, String name,String phone, String mail){
        Connection connection = DataSource.getInstance().getConnection();
        try {
            if (checkUser(username)) {
                DataSource.getInstance().releaseConnection(connection);
                return false;
            } else {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM tai_khoan WHERE ma_tai_khoan LIKE 'KH%'");
                rs.last();
                int row = rs.getRow();
                LocalDate date = LocalDate.now();
                LocalDateTime now = LocalDateTime.now();
                DateTime dateTime = new DateTime(date.getYear(), date.getMonthValue(),
                        date.getDayOfMonth(), now.getHour(), now.getMinute(), now.getSecond());
                PreparedStatement s = connection.prepareStatement("INSERT INTO `tai_khoan` (ma_tai_khoan, `kieu_tai_khoan`, `tai_khoan`" +
                        ", `mat_khau`, `email`, `so_dien_thoai`, " +
                        "`ma_quen_mat_khau`, `hinh_dai_dien`,link_hinh_dai_dien, `ten_hien_thi`, `ten_day_du`, `ngay_tao`, `han_su_dung_ma_qmk`) VALUES" +
                        " (?, 3, ?, ?, ?, ?, NULL, NULL,NULL, ?, ?, ?, NULL);");

                s.setString(1, "KH00" + (row + 1));
                String id = "KH00" + (row + 1);
                s.setString(2, username);
                s.setString(3, pass);
                s.setString(4, mail);
                s.setString(5, phone);
                s.setString(6, name);
                s.setString(7, name);
                s.setString(8, dateTime.toString());
                int a = s.executeUpdate();
                if (a > 0) {
                    DataSource.getInstance().releaseConnection(connection);
                    addUserIntoCustomers(id, dateTime.toString());
                    return true;
                }
                rs.close();
                st.close();
                s.close();
            }
        }

        catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return false;
    }
    public static boolean isEmail(String email){
        return MailModel.getInstance().checkEmail(email,MailModel.REGISTER_KH);
    }

    public static void main(String[] args) {
       System.out.println(checkUser("agtm"));
//        System.out.println(checkMail("luyducpho@gmail.com"));
      //  System.out.println(addUser("agtm","agtmzxc","HUYNH NHAT TRUONG","0961185373","nhattruongagtm@gmails.com"));
       // System.out.print(isEmail("nhatdfgdfgdfgtruongagtmhgjghjghj@gmail.com"));
    }
}
