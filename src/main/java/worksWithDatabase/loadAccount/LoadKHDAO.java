package worksWithDatabase.loadAccount;

import beans.DateTime;
import beans.account.AccountCustomer;
import beans.account.ConvertDate;
import connectionDatabase.DataSource;

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

            con = DataSource.getInstance().getConnection();

            String sql = "SELECT * from khach_hang k ,tai_khoan t WHERE k.ma_kh = t.ma_tai_khoan\n" +
                    "and (t.ten_day_du LIKE ? \n" +
                    "or t.email LIKE ? \n" +
                    "or t.so_dien_thoai LIKE ? \n" +
                    "or t.tai_khoan LIKE ? \n" +
                    "or DAY(t.ngay_tao) = ? \n" +
                    "or MONTH(t.ngay_tao) = ? \n" +
                    "OR YEAR(t.ngay_tao) = ? )\n" +
                    "ORDER BY t." +type+ " " + orderBy + " "+
                    "LIMIT ?,?";

           String sql1 = "SELECT * from khach_hang k ,tai_khoan t WHERE k.ma_kh = t.ma_tai_khoan\n" +
                   "and (t.ten_day_du LIKE ? \n" +
                   "or t.email LIKE ? \n" +
                   "or t.so_dien_thoai LIKE ? \n" +
                   "or t.tai_khoan LIKE ? \n" +
                   "or DAY(t.ngay_tao) = ? \n" +
                   "or MONTH(t.ngay_tao) = ? \n" +
                   "OR YEAR(t.ngay_tao) = ? )\n";

            PreparedStatement ps1 = con.prepareStatement(sql1);

            ps1.setString(1,"%" + search + "%");
            ps1.setString(2,"%" + search + "%");
            ps1.setString(3, search + "%");
            ps1.setString(4,"%" + search + "%");
            ps1.setString(5, search);
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
            int start = (page-1)*10;

            ps.setString(1,"%" + search + "%");
            ps.setString(2,"%" + search + "%");
            ps.setString(3,search + "%");
            ps.setString(4,"%" + search + "%");
            ps.setString(5,search);
            ps.setString(6,search);
            ps.setString(7,search);
            ps.setInt(8,start);
            ps.setInt(9,10);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

               AccountCustomer acc = new AccountCustomer();
                acc.setIdUser(rs.getString("ma_tai_khoan"));
                acc.setType(rs.getInt("kieu_tai_khoan"));
                acc.setUserName(rs.getString("tai_khoan"));
                acc.setPassWord(rs.getString("mat_khau"));
                acc.setEmail(rs.getString("email"));
                acc.setPhone(rs.getString("so_dien_thoai"));
                acc.setAvatar(rs.getString("link_hinh_dai_dien"));
                acc.setDisplayName(rs.getString("ten_hien_thi"));
                acc.setFullName(rs.getString("ten_day_du"));
                acc.setDeadline(ConvertDate.changeDate(rs.getString("han_su_dung_ma_qmk")));
                acc.setRegisDate(ConvertDate.changeDate(rs.getString("ngay_tao")));
                acc.setActiveStatus(rs.getInt("trang_thai_kich_hoat"));
                acc.setActiveEvaluate(rs.getInt("trang_thai_danh_gia"));
                acc.setTon_tai(rs.getInt("ton_tai"));
                acc.setNgon_ngu(rs.getString("ngon_ngu"));
                System.out.println(ConvertDate.changeDate(rs.getString("ngay_tao")));
                list.add(acc);
            }

        rs.close();
        ps.close();

             DataSource.getInstance().releaseConnection(con);
            return  list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
        }finally {
             DataSource.getInstance().releaseConnection(con);
        }
        DataSource.getInstance().releaseConnection(con);
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
      ArrayList<AccountCustomer> list2 = lao.LoadKHAll(1,"ngay_tao","","DESC");

        System.out.println(list2.toString());
        System.out.println(lao.getNumPage());
        System.out.println(list2.size());
    }
}
