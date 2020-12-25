package worksWithDatabase.category;

import beans.DateTime;
import beans.category.Category;
import connectionDatabase.DataSource;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.*;

public class CategoryWorksWithDatabase {

    public CategoryWorksWithDatabase() {
    }
    // kiểm tra danh mục đó có tồn tại trong hệ thống chưa
    public static boolean check(String id) {

        Connection c = DataSource.getInstance().getConnection();

        try {
            PreparedStatement p = c.prepareStatement("SELECT * FROM danhmuc WHERE maDM = ?");
            p.setString(1, id);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                DataSource.getInstance().releaseConnection(c);
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(c);
        return false;
    }
    // thêm một danh mục mới
    public static boolean addCategory(String name){
        // lấy ra 1 connection
        Connection connection = DataSource.getInstance().getConnection();
        try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM danhmuc");
                rs.beforeFirst();
                rs.last();
                int row = rs.getRow();

                long millis = System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);
                LocalDateTime now = LocalDateTime.now();
                Time time = new Time(now.getHour(),now.getMinute(),now.getMinute());
                PreparedStatement s = connection.prepareStatement("INSERT INTO danhmuc VALUES (?,?,?,?,?)");
                s.setString(1, "DM" + (row + 1));
                s.setString(2, name);
                s.setDate(3, date);
                s.setTime(4,time);
                s.setInt(5,1);

                s.execute();

                s.close();
                DataSource.getInstance().releaseConnection(connection);
                return true;

        }catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        System.out.println("Không thể thêm danh mục do đã tồn tại");
        return false;
    }
    // xóa một danh mục
    public static boolean removeCategory(String id){
        // lấy ra 1 connection
        Connection connection = DataSource.getInstance().getConnection();
        try {
            if (check(id)) {
                PreparedStatement s = connection.prepareStatement("DELETE FROM danhmuc where maDM = ?");
                s.setString(1, id);
                s.execute();

                DataSource.getInstance().releaseConnection(connection);
                s.close();
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        System.out.println("Không thể xóa danh mục!");
        return false;
    }
    // cập nhật danh mục sản phẩm
    public static boolean updateCategory(String id, String newName){
        Connection connection = DataSource.getInstance().getConnection();
        try{
            if(check(id)){
                PreparedStatement s = connection.prepareStatement("UPDATE danhmuc SET tenDM = ? WHERE maDM = ?");
                s.setString(1,newName);
                s.setString(2,id);
                s.execute();
                s.close();
                DataSource.getInstance().releaseConnection(connection);
                return true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return false;
    }
    

    public static void main(String[] args) {
//       System.out.println(getCategoryById("DM1"));
//        for(Category ca : getCategoriesByDateCreatedDESC()){
//            System.out.println(ca);
//        }

    }


}
