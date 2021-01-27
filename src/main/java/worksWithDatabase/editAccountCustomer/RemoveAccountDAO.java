package worksWithDatabase.editAccountCustomer;

import beans.account.AccountCustomer;
import connectionDatabase.DataSource;

import java.lang.ref.PhantomReference;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RemoveAccountDAO {
    public RemoveAccountDAO() {
    }

    public boolean removeAccount(String id){

        Connection con = null;
        AccountCustomer acc = null;
        try {
            con = DataSource.getInstance().getConnection();

            boolean check = false;

            String sql1 = "DELETE FROM tai_khoan WHERE ma_tai_khoan = ?";
            String sql2 = "DELETE FROM khach_hang WHERE ma_kh = ?";


            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setString(1,id);
            ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setString(1,id);
            ps2.executeUpdate();

            DataSource.getInstance().releaseConnection(con);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
            return false;
        }
    }

    public static void main(String[] args) {
        RemoveAccountDAO removeAccountDAO = new RemoveAccountDAO();
        System.out.println(removeAccountDAO.removeAccount("KH003"));

    }

}
