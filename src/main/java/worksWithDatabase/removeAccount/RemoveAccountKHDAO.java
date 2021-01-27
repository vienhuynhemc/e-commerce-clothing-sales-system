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

            String sql = "Delete from tai_khoan where ma_tai_khoan = ? and kieu_tai_khoan = 3";
            String sql1 = "Delete from khach_hang where ma_kh = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,idUser);
           int check =  ps.executeUpdate();
            ps.close();

            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setString(1,idUser);
          int check2 =  ps1.executeUpdate();
            ps1.close();

            if (check == 1 & check2 ==1){
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
        System.out.println(removeAccountKHDAO.removeAccount("KH050"));
    }
    
}
