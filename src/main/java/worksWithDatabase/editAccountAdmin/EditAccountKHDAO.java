package worksWithDatabase.editAccountAdmin;

import beans.encode.MD5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditAccountKHDAO {

    public EditAccountKHDAO() {
    }
    public void updateAccountKH(String userName,String fullName,String avatar,String displayName,String activeStatus,String activeEvaluate,String passWord){
        Connection con = null;

        try {

            // sài tạm database khác khi nào có thì dùng cái này
            // con = DataSource.getInstance().getConnection();

            Class.forName("com.mysql.jdbc.Driver");


            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tvtshop?useUnicode=true&characterEncoding=utf-8", "root", "");

        String sql = "UPDATE account a , customer c SET a.displayName = ?, a.fullName = ?, a.PASSWORD = ?,a.avatar = ?, c.activeStatus = ?,c.activeEvaluate = ? WHERE a.Iduser = c.iduser and a.userName = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            String encode = MD5.md5(passWord);

            ps.setString(1,displayName);
            ps.setString(2,fullName);
            ps.setString(3,encode);
            ps.setString(4,avatar);
            ps.setInt(5,Integer.parseInt(activeStatus));
            ps.setInt(6,Integer.parseInt(activeEvaluate));
            ps.setString(7,userName);

            ps.executeUpdate();

            ps.close();
            con.close();
           // DataSource.getInstance().releaseConnection(con);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EditAccountKHDAO editAccountKHDAO = new EditAccountKHDAO();
        editAccountKHDAO.updateAccountKH("kh001","nguyen van an","detrailam","an no pro","1","0","1234");
    }
}
