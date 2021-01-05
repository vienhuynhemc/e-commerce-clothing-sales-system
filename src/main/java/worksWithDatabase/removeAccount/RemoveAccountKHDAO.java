package worksWithDatabase.removeAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveAccountKHDAO {
    public RemoveAccountKHDAO(){
        
    }
    
    public boolean removeAccount(String idUser){
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tvtshop?useUnicode=true&characterEncoding=utf-8", "root", "");

            String sql = "Delete from account where idUser = ? and type = 3";
            String sql1 = "Delete from customer where iduser = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,idUser);
            ps.executeUpdate();
            ps.close();
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setString(1,idUser);
            ps1.executeUpdate();
            ps1.close();

            return  true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;

    }

    public static void main(String[] args) {
        RemoveAccountKHDAO removeAccountKHDAO = new RemoveAccountKHDAO();
        System.out.println(removeAccountKHDAO.removeAccount("KH050"));
    }
    
}
