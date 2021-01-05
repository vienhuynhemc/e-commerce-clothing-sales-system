package worksWithDatabase.category;

import beans.DateTime;
import beans.account.AccountCustomer;
import beans.category.Category;
import connectionDatabase.DataSource;
import worksWithDatabase.loadAccount.LoadKHDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoadCategoryDAO {
    ArrayList<Category> list;
    int numberOfPage;
    int numberCategories;

    public ArrayList<Category> LoadAllCategories(int page, String type, String search, String orderBy,int numberPerPage){
        Connection connection = DataSource.getInstance().getConnection();
        try{
            String sql = "SELECT * from danh_muc where (ma_dm like ? or ten_dm like ? or DAY(ngay_tao) = ?" +
                    "or MONTH(ngay_tao) = ? or Year(ngay_tao) = ?) " +
                    " AND ton_tai = 1 ORDER BY "+type+ " "+ orderBy +" LIMIT ?," +numberPerPage;
            String sql1 = "SELECT * from danh_muc where (ma_dm like ? or ten_dm like ? or DAY(ngay_tao) = ?" +
                    "or MONTH(ngay_tao) = ? or Year(ngay_tao) = ?) AND ton_tai = 1";

            PreparedStatement s = connection.prepareStatement(sql1);
            s.setString(1,"%"+search+"%");
            s.setString(2,"%"+search+"%");
            s.setString(3,search);
            s.setString(4,search);
            s.setString(5,search);

            ResultSet rs = s.executeQuery();
            rs.last();
            numberCategories = rs.getRow();
            rs.beforeFirst();

            if(numberCategories%numberPerPage == 0){
                setNumberOfPage(numberCategories/numberPerPage);
            }
            else{
                setNumberOfPage((numberCategories/numberPerPage) + 1);
            }
            rs.close();
            s.close();

            PreparedStatement s2 = connection.prepareStatement(sql);
            int start = (page - 1) * numberPerPage + 1;
            s2.setString(1,"%"+search+"%");
            s2.setString(2,"%"+search+"%");
            s2.setString(3,search);
            s2.setString(4,search);
            s2.setString(5,search);
            s2.setInt(6,start);


            ResultSet rss = s2.executeQuery();
            list = new ArrayList<Category>();

            while(rss.next()){

                // lấy ra ngày để sử lí r cho nào class datetime
                String date = rss.getString("ngay_tao");
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


                Category c = new Category();
                c.setId(rss.getString("ma_dm"));
                c.setName(rss.getString("ten_dm"));
                c.setDateCreated(datetime);
                c.setExist(rss.getInt("ton_tai"));
                list.add(c);

            }
            rss.close();
            s2.close();
            DataSource.getInstance().releaseConnection(connection);
            return list;
        }
     catch (SQLException throwables) {
        throwables.printStackTrace();
//     } finally {
//        try {
//            connection.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        DataSource.getInstance().releaseConnection(connection);
    }
        return list;
    }

    public static void main(String[] args) throws SQLException{
        LoadCategoryDAO lao = new LoadCategoryDAO();

        ArrayList<Category> list2 = lao.LoadAllCategories(1,"ten_dm","","ASC",3);

        for(Category c : list2){
            System.out.println(c);
        }
//        System.out.println(list2.toString());
        System.out.println(lao.getNumberOfPage());
        System.out.println(list2.size());
    }

    public ArrayList<Category> getList() {
        return list;
    }

    public void setList(ArrayList<Category> list) {
        this.list = list;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public int getNumberCategories() {
        return numberCategories;
    }

    public void setNumberCategories(int numberCategories) {
        this.numberCategories = numberCategories;
    }
}
