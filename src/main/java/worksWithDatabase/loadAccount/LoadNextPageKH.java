package worksWithDatabase.loadAccount;

import beans.account.AccountCustomer;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class LoadNextPageKH {
    Map<String, AccountCustomer> list ;
    public LoadNextPageKH(){
        list = new HashMap<>();
    }
    public int loadNextPageKH(){
            int count = 0;
        Connection con = null;
        try {
            // lay connection
            //con = DataSource.getInstance().getConnection();

            // test thôi
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tvtshop?useUnicode=true&characterEncoding=utf-8", "root", "");

            // sql load list khach hang
            // laod khach hang tu 2 bang account va customer
            String sql = "select a.IDUser, a.Type,a.UserName," +
                    "a.`PassWord`,a.Email,a.Phone, a.Avatar, a.DisplayName," +
                    "a.FullName,a.RegisDate ,c.ActiveStatus,c.ActiveEvaluate  " +
                    "from account a , customer c WHERE a.IDUser = c.IDUser";
            Statement sm = con.createStatement();
            ResultSet rs = sm.executeQuery(sql);

            // di chuyển đến cuối hàng đếm số phần tử
            rs.last();

            int sum = rs.getRow();

            // nếu dư thì cho nó qua trang mới
            if(sum%10 != 0){
                count = (int) (sum/10) +1;
            }else{
                count = sum/10;
            }

            rs.close();
            sm.close();

            // DataSource.getInstance().releaseConnection(con);

            return count;

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            // DataSource.getInstance().releaseConnection(con);
        }

        return count;

    }

    public static void main(String[] args) throws SQLException {
        LoadNextPageKH loadNextPageKH = new LoadNextPageKH();

        System.out.println(loadNextPageKH.loadNextPageKH());

    }
}
