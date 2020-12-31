package worksWithDatabase.loadAccount;

import beans.DateTime;
import beans.account.AccountCustomer;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadKHDAO {

    //Map<String, AccountCustomer> list ;
    ArrayList<AccountCustomer> list;
     int numPage;
    public LoadKHDAO(){
        //list = new HashMap<>();
        list = new ArrayList<>();
    }
    public ArrayList< AccountCustomer> loadListKH(){

        Connection con = null;
        try {
            // lay connection
            //con = DataSource.getInstance().getConnection();

            // test thôi
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tvtshop?useUnicode=true&characterEncoding=utf-8", "root", "");


            String sql = "WITH list as \n" +
                    "(\n" +
                    "SELECT ROW_NUMBER() Over(ORDER BY a.IDuser ASC) as n, a.IDUser, a.Type,a.UserName,a.`PassWord`,a.Email,a.Phone, a.Avatar, a.DisplayName,a.FullName,a.RegisDate ,c.ActiveStatus,c.ActiveEvaluate from account a , customer c WHERE a.IDUser = c.IDUser\n" +
                    " )  \n" +
                    "\n" +
                    "SELECT * from list WHERE n BETWEEN 0 AND 10";


            Statement sm = con.createStatement();

            ResultSet rs = sm.executeQuery(sql);

            // di chuyển tới cuối hàng để lấy số hàng
         //   rs.last();
          //  int end = rs.getRow();
            // lấy dc r thì di chuyển lại vị trí bắt đầu lấy
          //  rs.absolute((num-1)*10);

            //if(num*10 < end){
                // lấy đủ 10 thằng thôi
              //  int count = 0;
                while (rs.next()) {
                    //     if(count < 10){
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

                    DateTime datetime = new DateTime(year, month, day, hour, minute, second);

                        list.add(
                                new AccountCustomer(rs.getString("IDUser"),
                                        rs.getInt("Type"),
                                        rs.getString("UserName"),
                                        rs.getString("PassWord"),
                                        rs.getString("Email"),
                                        rs.getString("phone"),
                                        rs.getString("Avatar"),
                                        rs.getString("DisplayName"),
                                        rs.getString("FullName"),
                                        datetime, rs.getInt("ActiveStatus"),
                                        rs.getInt("ActiveEvaluate")));
                    }

                    rs.close();
                    sm.close();

                    // DataSource.getInstance().releaseConnection(con);

                    return list;

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

    public ArrayList<AccountCustomer> LoadKHAll(int page,String type,String search,String orderBy){
        Connection con = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tvtshop?useUnicode=true&characterEncoding=utf-8", "root", "");


            String sql = "WITH list as(SELECT ROW_NUMBER() Over(ORDER BY a." +type+" "+orderBy +") as n" +
                    ", a.IDUser, a.Type,a.UserName,a.`PassWord`,a.Email,a.Phone, a.Avatar, " +
                    "a.DisplayName,a.FullName,a.RegisDate ,c.ActiveStatus,c.ActiveEvaluate " +
                    "from account a , customer c WHERE a.IDUser = c.IDUser and " +
                    "(a.FullName LIKE ? or a.Email LIKE ? or a.Phone LIKE ? or a.UserName LIKE ?)) " +
                    "SELECT * from list WHERE n BETWEEN ? AND ?";

            PreparedStatement ps = con.prepareStatement(sql);

            int start = page*10;
            int end = (page+1) * 10;

            //ps.setString(1,type);
           // ps.setString(1,orderBy);
            ps.setString(1,"%" + search + "%");
            ps.setString(2,"%" + search + "%");
            ps.setString(3,"%" + search + "%");
            ps.setString(4,"%" + search + "%");
            ps.setString(5,String.valueOf(0));
            ps.setString(6,String.valueOf(10));




            ResultSet rs = ps.executeQuery();


        // di chuyển tới cuối hàng để lấy số hàng
//        rs.last();
//        int end = rs.getRow();
//
//            int sum = rs.getRow();
//
//            // nếu dư thì cho nó qua trang mới
//            if(sum%10 != 0){
//                numPage = (int) (sum/10) +1;
//            }else{
//                numPage = sum/10;
//            }


            while (rs.next()) {


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

                DateTime datetime = new DateTime(year, month, day, hour, minute, second);

                list.add(
                        new AccountCustomer(rs.getString("IDUser"),
                                rs.getInt("Type"),
                                rs.getString("UserName"),
                                rs.getString("PassWord"),
                                rs.getString("Email"),
                                rs.getString("phone"),
                                rs.getString("Avatar"),
                                rs.getString("DisplayName"),
                                rs.getString("FullName"),
                                datetime, rs.getInt("ActiveStatus"),
                                rs.getInt("ActiveEvaluate")));

            }

        rs.close();
        ps.close();

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

    public int getNumPage() {
        return numPage;
    }

    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }

    public static void main(String[] args) throws SQLException {
    LoadKHDAO lao = new LoadKHDAO();
   // ArrayList<AccountCustomer> list = lao.loadListKH();
    //    System.out.println(list.toString());
      ArrayList<AccountCustomer> list2 = lao.LoadKHAll(0,"email","gmail","DESC");
        System.out.println(list2.toString());
    }
}
