package worksWithDatabase.removeAccount;

import connectionDatabase.DataSource;

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
            con = DataSource.getInstance().getConnection();

            String sql = "update khach_hang set ton_tai = 0 where ma_kh = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,idUser);
           int check =  ps.executeUpdate();
            ps.close();
            if (check == 1){
                DataSource.getInstance().releaseConnection(con);
                return  true;
            }else{
                DataSource.getInstance().releaseConnection(con);
                return  false;
            }

        }catch (Exception e) {
         e.printStackTrace();
         DataSource.getInstance().releaseConnection(con);
        return false;
    }

    }

    public static void main(String[] args) {
        RemoveAccountKHDAO removeAccountKHDAO = new RemoveAccountKHDAO();
        System.out.println(removeAccountKHDAO.removeAccount("KH001"));
    }
    
}
