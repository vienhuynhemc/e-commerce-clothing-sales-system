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
     int sumCustomer;
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
                                new AccountCustomer());
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

            String sql = "WITH list as(SELECT ROW_NUMBER() RDER BY a." +type+" "+orderBy +") as n" +
                        ", a.IDUser, a.Type,a.UserName,a.`PassWoOver(Ord`,a.Email,a.Phone, a.Avatar, " +
                        "a.DisplayName,a.FullName,a.RegisDate ,c.ActiveStatus,c.ActiveEvaluate " +
                        "from account a , customer c WHERE a.IDUser = c.IDUser and " +
                        "(a.FullName LIKE ? or a.Email LIKE ? or a.Phone LIKE ? or a.UserName LIKE ? or day(a.RegisDate) = ? or MONTH(a.RegisDate) = ? OR YEAR(a.RegisDate) = ?)) " +
                        "SELECT * from list WHERE n BETWEEN ? AND ?";

           String sql1 = "select *from account a , customer c WHERE a.IDUser = c.IDUser and (a.FullName LIKE ? or a.Email LIKE ? or a.Phone LIKE ? or a.UserName LIKE ? or day(a.RegisDate) = ? or MONTH(a.RegisDate) = ? OR YEAR(a.RegisDate) = ?)";

            PreparedStatement ps1 = con.prepareStatement(sql1);

            ps1.setString(1,"%" + search);
            ps1.setString(2,"%" + search + "%");
            ps1.setString(3, search + "%");
            ps1.setString(4,"%" + search + "%");
            ps1.setString(5, search );
            ps1.setString(6,search);
            ps1.setString(7, search);


            ResultSet rs1 = ps1.executeQuery();

            rs1.last();
            sumCustomer = rs1.getRow();
            rs1.beforeFirst();

            if(sumCustomer%10 != 0){
                setNumPage((int) (sumCustomer/10) +1);
            }else{
                setNumPage( sumCustomer/10);
            }
            ps1.close();
            rs1.close();


            PreparedStatement ps = con.prepareStatement(sql);
            int start = (page-1)*10+1;
            int end;
            if(page != numPage){
                end  = page * 10;

            }else{
                end = sumCustomer ;

            }


            ps.setString(1,"%" + search);
            ps.setString(2,"%" + search + "%");
            ps.setString(3,search + "%");
            ps.setString(4,"%" + search + "%");
            ps.setString(5,search);
            ps.setString(6,search);
            ps.setString(7,search);
            ps.setString(8,String.valueOf(start));
            ps.setString(9,String.valueOf(end));

            ResultSet rs = ps.executeQuery();

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
                        new AccountCustomer());

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

    public int getSumCustomer() {
        return sumCustomer;
    }

    public void setSumCustomer(int sumCustomer) {
        this.sumCustomer = sumCustomer;
    }



    public static void main(String[] args) throws SQLException {
    LoadKHDAO lao = new LoadKHDAO();
   // ArrayList<AccountCustomer> list = lao.loadListKH();
    //    System.out.println(list.toString());
      ArrayList<AccountCustomer> list2 = lao.LoadKHAll(6,"RegisDate",".","DESC");

        System.out.println(list2.toString());
        System.out.println(lao.getNumPage());
        System.out.println(list2.size());
    }
}
