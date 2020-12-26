package worksWithDatabase.loadAccount;

import beans.Address;
import beans.DateTime;
import beans.account.AccountKH;
import beans.account.AccountNVK;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class LoadNVKDAO {
    Map<String, AccountNVK> list ;
    public LoadNVKDAO(){
        list = new HashMap<>();
    }
    public Map<String, AccountNVK> loadListNVK(int num){

        Connection con = null;
        try {
            // lay connection
            //con = DataSource.getInstance().getConnection();

            // test thôi
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tvtshop?useUnicode=true&characterEncoding=utf-8", "root", "");

            // sql load list khach hang
            // laod khach hang tu 2 bang account va employee
            String sql = "select a.IDUser, a.Type,a.UserName,a.`PassWord`,a.Email,a.Phone, a.Avatar, a.DisplayName,\n" +
                    "                    a.FullName,a.RegisDate , e.Salary,e.`Level`,e.Address,e.Info\n" +
                    "                    from account a , employee e WHERE a.IDUser = e.IDUser and a.Type = 1;";
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

                        //String address = rs.getString("Address");

                        //String[] add = address.split("-");

                        //test do chưa có address
                        //Address address1 = new Address(add[0],add[1],add[2]);

                        Address address1 = new Address("Mỹ cát", "Phù Mỹ" , "Bình Định");

                        list.put(rs.getString("IDUser"),
                                new AccountNVK(rs.getString("IDUser"),
                                        rs.getInt("Type"),
                                        rs.getString("UserName"),
                                        rs.getString("PassWord"),
                                        rs.getString("Email"),
                                        rs.getString("phone"),
                                        rs.getString("Avatar"),
                                        rs.getString("DisplayName"),
                                        rs.getString("FullName"),
                                        datetime,rs.getInt("Salary"),
                                        rs.getInt("Level"),
                                        rs.getInt("Info"),address1));

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

                    double d = Double.parseDouble(time[2]);

                    int second = (int) d;

                    DateTime datetime = new DateTime(year,month,day,hour,minute,second);

                   // String address = rs.getString("Address");

                   // String[] add = address.split("-");

                   // Address address1 = new Address(add[0],add[1],add[2]);
                    //test tại chưa có address
                    Address address1 = new Address("Mỹ cát", "Phù Mỹ" , "Bình Định");

                    list.put(rs.getString("IDUser"),
                            new AccountNVK(rs.getString("IDUser"),
                                    rs.getInt("Type"),
                                    rs.getString("UserName"),
                                    rs.getString("PassWord"),
                                    rs.getString("Email"),
                                    rs.getString("phone"),
                                    rs.getString("Avatar"),
                                    rs.getString("DisplayName"),
                                    rs.getString("FullName"),
                                    datetime,rs.getInt("Salary"),
                                    rs.getInt("Level"),
                                    rs.getInt("Info"),address1));


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
        LoadNVKDAO lao = new LoadNVKDAO();
        Map<String,AccountNVK> list = lao.loadListNVK(1);

        System.out.println(list.toString());

    }
}
