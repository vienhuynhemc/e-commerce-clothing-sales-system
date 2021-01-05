package worksWithDatabase.loadAccount;

import beans.Address;
import beans.DateTime;
import beans.account.AccountEmployee;

import java.sql.*;
import java.util.ArrayList;

public class LoadNVVCDAO {
    ArrayList<AccountEmployee> list;
    int numPage;
    int sumEployee;
    public LoadNVVCDAO(){
        list = new ArrayList<>();
    }
    public ArrayList<AccountEmployee> loadNVVCAll(int page, String type, String search, String orderBy){
        Connection con = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tvtshop?useUnicode=true&characterEncoding=utf-8", "root", "");

            String sql = "WITH list as(SELECT ROW_NUMBER() Over(ORDER BY " + type +" " + orderBy +") as n" +
                    "                    , a.IDUser, a.Type,a.UserName,a.`PassWord`,a.Email,a.Phone, a.Avatar," +
                    "                    a.DisplayName,a.FullName,a.RegisDate, e.salary,e.info,e.address,e.level" +
                    "                    from account a , employee e WHERE a.IDUser = e.IDUser and a.type = 2 and" +
                    "                    (a.FullName LIKE ? or a.Email LIKE ? or a.Phone LIKE ? or a.UserName LIKE ? or day(a.RegisDate) =    " +
                    "  ? or MONTH(a.RegisDate) = ? OR YEAR(a.RegisDate) = ? OR e.Salary = ? OR e.info = ? OR e.Address LIKE ?))" +
                    "                    SELECT * from list WHERE n BETWEEN ? AND ?";

            String sql1 = "select *from account a , employee e WHERE a.IDUser = e.IDUser and e.level = 2  and (a.FullName LIKE ? or a.Email LIKE ? or a.Phone LIKE ? or a.UserName LIKE ? or day(a.RegisDate) = ? or MONTH(a.RegisDate) = ? OR YEAR(a.RegisDate) = ?" +
                    "OR e.Salary = ? OR e.info = ? OR e.Address LIKE ?)";

            PreparedStatement ps1 = con.prepareStatement(sql1);

            ps1.setString(1,"%" + search);
            ps1.setString(2,"%" + search + "%");
            ps1.setString(3, search + "%");
            ps1.setString(4,"%" + search + "%");
            ps1.setString(5, search );
            ps1.setString(6,search);
            ps1.setString(7, search);
            ps1.setString(8,search);
            ps1.setString(9,search);
            ps1.setString(10,"%" + search + "%");

            ResultSet rs1 = ps1.executeQuery();

            rs1.last();
            sumEployee = rs1.getRow();
            rs1.beforeFirst();

            if(sumEployee %10 != 0){
                setNumPage((int) (sumEployee /10) +1);
            }else{
                setNumPage( sumEployee /10);
            }
            ps1.close();
            rs1.close();


            PreparedStatement ps = con.prepareStatement(sql);
            int start = (page-1)*10+1;
            int end;
            if(page != numPage){
                end  = page * 10;
            }else{
                end = sumEployee;

            }

            ps.setString(1,"%" + search);
            ps.setString(2,"%" + search + "%");
            ps.setString(3,search + "%");
            ps.setString(4,"%" + search + "%");
            ps.setString(5,search);
            ps.setString(6,search);
            ps.setString(7,search);
            ps.setString(8,search);
            ps.setString(9,search);
            ps.setString(10,"%" + search + "%");
            ps.setString(11,String.valueOf(start));
            ps.setString(12,String.valueOf(end));

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

                // String address = rs.getString("Address");

                //String[] add = address.split("-");

                Address address1 = new Address("Mỹ cát", "Phù Mỹ" , "Bình Định");
                // Address address1 = new Address(add[0],add[1],add[2]);

                list.add(
                        new AccountEmployee(rs.getString("IDUser"),
                                rs.getInt("Type"),
                                rs.getString("UserName"),
                                rs.getString("PassWord"),
                                rs.getString("Email"),
                                rs.getString("phone"),
                                rs.getString("Avatar"),
                                rs.getString("DisplayName"),
                                rs.getString("FullName"),
                                datetime,rs.getInt("salary"),
                                rs.getInt("info"),rs.getInt("level"),address1
                        ));
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

    public int getSumEployee() {
        return sumEployee;
    }

    public void setSumEployee(int sumEployee) {
        this.sumEployee = sumEployee;
    }

    public static void main(String[] args) {
        LoadNVVCDAO lao = new LoadNVVCDAO();

        System.out.println(lao.loadNVVCAll(1,"Iduser","","ASC"));

        System.out.println(lao.getNumPage());

        System.out.println(lao.getSumEployee());
    }
}

