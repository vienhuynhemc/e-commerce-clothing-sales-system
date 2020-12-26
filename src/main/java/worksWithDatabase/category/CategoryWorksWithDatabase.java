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
    // lấy một danh mục dựa vào mã danh mục
    public static Category getCategoryById(String id){
        Connection connection = DataSource.getInstance().getConnection();
        try {
            if(check(id)) {
                PreparedStatement s = connection.prepareStatement("SELECT * FROM danhmuc WHERE maDM = ? AND EXIST = 1");
                s.setString(1, id);
                s.execute();
                ResultSet rs = s.executeQuery();
                if (rs.next()) {
                    Category category = new Category();
                    category.setId(rs.getString(1));
                    category.setName(rs.getString(2));
                    category.setDateCreated(rs.getDate(3));
                    category.setTimeCreated(rs.getTime(4));
                    category.setExist(rs.getInt(5));

                    DataSource.getInstance().releaseConnection(connection);
                    rs.close();
                    s.close();
                    return category;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        System.out.println("Không tồn tại danh mục trong hệ thống");
        return null;
    }
    // hiển thị danh sách danh mục theo mã danh mục tăng dần
    public static List<Category> getCategoriesByIdASC(){
        Connection connection = DataSource.getInstance().getConnection();
        List<Category> categories = new ArrayList<>();
        try{
            String input = "maDM";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM danhmuc ORDER BY maDM");
            while(rs.next()) {
                categories.add(new Category(rs.getString(1), rs.getString(2),
                        rs.getDate(3), rs.getTime(4), rs.getInt(5)));
            }
            rs.close();
            s.close();
            DataSource.getInstance().releaseConnection(connection);
            return categories;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return new ArrayList<>();
    }
    // hiển thị danh sách danh mục theo mã danh mục giảm dần
    public static List<Category> getCategoriesByIdDESC(){
        Connection connection = DataSource.getInstance().getConnection();
        List<Category> categories = new ArrayList<>();
        try{
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM danhmuc ORDER BY maDM DESC");
            while(rs.next()) {
                categories.add(new Category(rs.getString(1), rs.getString(2),
                        rs.getDate(3), rs.getTime(4), rs.getInt(5)));
            }
            rs.close();
            s.close();
            DataSource.getInstance().releaseConnection(connection);
            return categories;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return new ArrayList<>();
    }
    // hiển thị danh sách danh mục theo tên danh mục tăng dần
    public static List<Category> getCategoriesByNameASC(){
        Connection connection = DataSource.getInstance().getConnection();
        List<Category> categories = new ArrayList<>();
        try{
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM danhmuc ORDER BY tenDM");
            while(rs.next()) {
                categories.add(new Category(rs.getString(1), rs.getString(2),
                        rs.getDate(3), rs.getTime(4), rs.getInt(5)));
            }
            rs.close();
            s.close();
            DataSource.getInstance().releaseConnection(connection);
            return categories;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return new ArrayList<>();
    }
    // hiển thị danh sách danh mục theo tên danh mục giảm dần
    public static List<Category> getCategoriesByNameDESC(){
        Connection connection = DataSource.getInstance().getConnection();
        List<Category> categories = new ArrayList<>();
        try{
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM danhmuc ORDER BY tenDM");
            while(rs.next()) {
                categories.add(new Category(rs.getString(1), rs.getString(2),
                        rs.getDate(3), rs.getTime(4), rs.getInt(5)));
            }
            rs.close();
            s.close();
            DataSource.getInstance().releaseConnection(connection);
            return categories;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return new ArrayList<>();
    }
    // hiển thị danh sách danh mục theo ngày tạo tăng dần
    public static List<Category> getCategoriesByDateCreatedASC(){
        Connection connection = DataSource.getInstance().getConnection();
        List<Category> categories = new ArrayList<>();
        try{
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM danhmuc ORDER BY ngaytao, thoigiantao");
            while(rs.next()) {
                categories.add(new Category(rs.getString(1), rs.getString(2),
                        rs.getDate(3), rs.getTime(4), rs.getInt(5)));
            }
            rs.close();
            s.close();
            DataSource.getInstance().releaseConnection(connection);
            return categories;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return new ArrayList<>();
    }
    // hiển thị danh sách danh mục theo ngày tạo giảm dần
    public static List<Category> getCategoriesByDateCreatedDESC(){
        Connection connection = DataSource.getInstance().getConnection();
        List<Category> categories = new ArrayList<>();
        try{
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM danhmuc ORDER BY ngaytao DESC, thoigiantao DESC");
            while(rs.next()) {
                categories.add(new Category(rs.getString(1), rs.getString(2),
                        rs.getDate(3), rs.getTime(4), rs.getInt(5)));
            }
            rs.close();
            s.close();
            DataSource.getInstance().releaseConnection(connection);
            return categories;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return new ArrayList<>();
    }
    // hiển thị danh sách danh mục theo số lượng sản phẩm tăng dần
    public static List<Category> getCategoriesByProDuctQuantityASC(){
        Connection connection = DataSource.getInstance().getConnection();
        List<Category> categories = new ArrayList<>();
        try{
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT danhmuc.maDM, count(*) as tong FROM danhmuc,sanpham " +
                    "WHERE danhmuc.maDM = sanpham.maDM GROUP BY danhmuc.maDM ORDER BY count(*)");
            // dùng map lưu kết quả
            HashMap<Category,Integer> map = new HashMap<>();
            while(rs.next()) {
                map.put(getCategoryById(rs.getString(1)),rs.getInt(2));
            }
            for(Map.Entry<Category,Integer> ca : map.entrySet()){
                categories.add(ca.getKey());
            }
            rs.close();
            s.close();
            DataSource.getInstance().releaseConnection(connection);
            return categories;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return new ArrayList<>();
    }
    // hiển thị danh sách danh mục theo số lượng sản phẩm giảm dần
    public static List<Category> getCategoriesByProDuctQuantityDESC(){
        Connection connection = DataSource.getInstance().getConnection();
        List<Category> categories = new ArrayList<>();
        try{
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT danhmuc.maDM, count(*) as tong FROM danhmuc,sanpham " +
                    "WHERE danhmuc.maDM = sanpham.maDM GROUP BY danhmuc.maDM ORDER BY count(*) DESC");
            // dùng map lưu kết quả
            HashMap<Category,Integer> map = new HashMap<>();
            while(rs.next()) {
                map.put(getCategoryById(rs.getString(1)),rs.getInt(2));
            }
            for(Map.Entry<Category,Integer> ca : map.entrySet()){
                categories.add(ca.getKey());
            }
            rs.close();
            s.close();
            DataSource.getInstance().releaseConnection(connection);
            return categories;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return new ArrayList<>();
    }

    public static void main(String[] args) {
//       System.out.println(getCategoryById("DM1"));
//        for(Category ca : getCategoriesByDateCreatedDESC()){
//            System.out.println(ca);
//        }

    }


}
