package worksWithDatabase.loadAccount;

import beans.DateTime;
import beans.account.AccountKH;
import connectionDatabase.DataSource;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class LoadKHDAO {

    Map<String, AccountKH> list ;
    public LoadKHDAO(){
        list = new HashMap<>();
    }
    public Map<String,AccountKH> loadListKH(int num){

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


            // di chuyển tới cuối hàng để lấy số hàng
            rs.last();
            int end = rs.getRow();
            // lấy dc r thì di chuyển lại vị trí bắt đầu lấy
            rs.absolute((num-1)*10);

            if(num*10 < end){
                // lấy đủ 10 thằng thôi
                int count = 0;
                while (rs.next()){
                    if(count < 10){

                        // lấy ra ngày để sử lí r cho nào class datetime
                    String date = rs.getString("RegisDate");
                    String[] split = date.split(" ");

                    String[] dmy = split[0].split("-");
                    String[] time = split[1].split(":");

                    int year = Integer.parseInt(dmy[0]);
                    int month = Integer.parseInt(dmy[1]);
                    int day = Integer.parseInt(dmy[2]);
                    int hour = Integer.parseInt(time[0]);
                    int minute = Integer.parseInt(time[1]);

                    double d = Double.parseDouble(time[2]);

                    int second = (int) d;


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

                    count ++;
                    }else{
                        break;
                    }
                }

            }else{
                while (rs.next()){
                        // lấy ra ngày để sử lí r cho nào class datetime
                        String date = rs.getString("RegisDate");
                        String[] split = date.split(" ");

                        String[] dmy = split[0].split("-");
                        String[] time = split[1].split(":");

                        int year = Integer.parseInt(dmy[0]);
                        int month = Integer.parseInt(dmy[1]);
                        int day = Integer.parseInt(dmy[2]);
                        int hour = Integer.parseInt(time[0]);
                        int minute = Integer.parseInt(time[1]);
                    int second = Integer.parseInt(time[2].split(".")[0]);

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
            }

            rs.close();
            sm.close();

           // DataSource.getInstance().releaseConnection(con);

            return  list;

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

        return list;

    }

    public static void main(String[] args) throws SQLException {
    LoadKHDAO lao = new LoadKHDAO();
    Map<String,AccountKH> list = lao.loadListKH(5);

    System.out.println(list.toString());

    }
}
