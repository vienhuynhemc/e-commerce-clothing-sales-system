package worksWithDatabase.viewAccess;

import connectionDatabase.DataSource;
import model.viewAccess.ViewAccessModel;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewAccessDAO {
    public int getViews(){
        Connection connection = DataSource.getInstance().getConnection();
        try{
            int view = 0;
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM luot_truy_cap");
            while(rs.next()){
                view = rs.getInt(1);
                return view;
            }
            rs.close();
            s.close();
            DataSource.getInstance().releaseConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return 0;
    }
    public void updateViews(){
        Connection connection = DataSource.getInstance().getConnection();
        try{
            Statement s = connection.createStatement();
            int rs = s.executeUpdate("UPDATE luot_truy_cap SET luot_truy_cap = luot_truy_cap + 1");
            s.close();
            DataSource.getInstance().releaseConnection(connection);
            System.out.println("Cập nhật thành công!");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
    }

    public static void main(String[] args) {
        ViewAccessDAO s = new ViewAccessDAO();
        s.updateViews();
    }


}
