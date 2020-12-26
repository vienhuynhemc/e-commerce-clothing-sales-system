package worksWithDatabase.loadAccount;

import beans.DateTime;
import beans.account.AccountKH;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class LoadKHDAO {

    Map<String, AccountKH> list ;
    public LoadKHDAO(){
        list = new HashMap<>();
    }
    public Map<String,AccountKH> loadListKH(){

        Connection con = null;
        try {
            // lay connection
            con = DataSource.getInstance().getConnection();

            // sql load list khach hang
            // laod khach hang tu 2 bang account va customer
            String sql = "select a.IDUser, a.Type,a.UserName," +
                    "a.`PassWord`,a.Email,a.Phone, a.Avatar, a.DisplayName," +
                    "a.FullName,a.RegisDate ,c.ActiveStatus,c.ActiveEvaluate  " +
                    "from account a , customer c WHERE a.IDUser = c.IDUser";
            Statement sm = con.createStatement();

            ResultSet rs = sm.executeQuery(sql);

            while (rs.next()){

                String date = rs.getString("RegisDate");
                String[] split = date.split(" ");

                String[] dmy = split[0].split("-");
                String[] time = split[1].split(":");

                int year = Integer.parseInt(dmy[0]);
                int month = Integer.parseInt(dmy[1]);
                int day = Integer.parseInt(dmy[2]);
                int hour = Integer.parseInt(time[0]);
                int minute = Integer.parseInt(time[1]);
                int second = Integer.parseInt(time[2]);

                DateTime datetime = new DateTime(year,month,day,hour,minute,second);

                list.put(rs.getString("IDUser"),
                    new AccountKH(rs.getString("IDUser"),
                            rs.getInt("Type"),
                            rs.getString("UserName"),
                            rs.getString("PassWord"),
                            rs.getString("Email"),
                            rs.getString("phone"),
                            rs.getString("Avatar"),
                            rs.getString("DisplayName"),
                            rs.getString("FullName"),
                            datetime,rs.getInt("ActiveStatus"),
                            rs.getInt("ActiveEvaluate")));
            }
            rs.close();
            sm.close();

            DataSource.getInstance().releaseConnection(con);

            return  list;



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DataSource.getInstance().releaseConnection(con);
        }

        return null;

    }
}
