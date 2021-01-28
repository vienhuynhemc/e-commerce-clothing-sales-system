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

            String sql = "update khach_hang set ton_tai = 0 where ma_kh = ?";

            PreparedStatement ps1 = con.prepareStatement(sql);
            ps1.setString(1,id);
            ps1.executeUpdate();

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
