package worksWithDatabase.category;

import beans.DateTime;
import beans.category.Category;
import connectionDatabase.DataSource;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class CategoryWorksWithDatabase {

    public CategoryWorksWithDatabase() {
    }
    // kiểm tra danh mục đó có tồn tại trong hệ thống chưa
    public static boolean check(String id) {

        Connection c = DataSource.getInstance().getConnection();

        try {
            PreparedStatement p = c.prepareStatement("SELECT * FROM danh_muc WHERE ma_dm = ?");
            p.setString(1, id);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                DataSource.getInstance().releaseConnection(c);
                return true;
            }
            rs.close();
            p.close();
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
                if(name.equals("")){
                    return false;
                }
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM danh_muc");
                rs.beforeFirst();
                rs.last();
                int row = rs.getRow();

                LocalDate date = LocalDate.now();
                LocalDateTime now = LocalDateTime.now();
                DateTime dateTime = new DateTime(date.getYear(),date.getMonthValue(),date.getDayOfMonth(),now.getHour(),now.getMinute(),now.getSecond());
                PreparedStatement s = connection.prepareStatement("INSERT INTO danh_muc VALUES (?,?,?,?)");
                s.setString(1, "dm_" + (row + 1));
                s.setString(2, name);
                s.setString(3,dateTime.toString());
                s.setInt(4,1);

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
                PreparedStatement s = connection.prepareStatement("DELETE FROM danh_muc where ma_dm = ?");
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
                PreparedStatement s = connection.prepareStatement("UPDATE danh_muc SET ten_dm = ? WHERE ma_dm = ?");
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
    // hiển thị danh sách danh mục sản phẩm
    public static List<Category> getAllCategories(){
        List<Category> categories = new ArrayList<>();
        Connection connection = DataSource.getInstance().getConnection();
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM danh_muc");
            while(rs.next()){
                Category category = new Category();
                category.setId(rs.getString("ma_dm"));
                category.setName(rs.getString("ten_dm"));
                String dateTime = rs.getString("ngay_tao");
                DateTime dayTime = getDateTime(dateTime);
                category.setDateCreated(dayTime);
                category.setExist(rs.getInt("ton_tai"));
                categories.add(category);
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
     public static DateTime getDateTime(String dateTime){
         DateTime dayTime = new DateTime();
         String[] date_time = dateTime.split(" ");
         String[] date = date_time[0].split("-");
         String[] time = date_time[1].split(":");

         dayTime.setYear(Integer.parseInt(date[0]));
         dayTime.setMonth(Integer.parseInt(date[1]));
         dayTime.setDay(Integer.parseInt(date[2]));
         dayTime.setHour(Integer.parseInt(time[0]));
         dayTime.setMinute(Integer.parseInt(time[1]));
         dayTime.setSecond((int)Double.parseDouble(time[2]));
         return dayTime;
     }
    // lấy một danh mục dựa vào mã danh mục
    public static Category getCategoryById(String id){
        Connection connection = DataSource.getInstance().getConnection();
        try {
                PreparedStatement s = connection.prepareStatement("SELECT * FROM danh_muc WHERE ma_dm = ? and ton_tai = 1");
                s.setString(1, id);
                s.execute();
                ResultSet rs = s.executeQuery();
                if (rs.next()) {
                    Category category = new Category();
                    category.setId(rs.getString("ma_dm"));
                    category.setName(rs.getString("ten_dm"));
                    String dateTime = rs.getString("ngay_tao");

//                  xứ lí chuỗi yyyy-mm-dd hh:mm:ss
                    DateTime dayTime = getDateTime(dateTime);
                    category.setDateCreated(dayTime);
                    category.setExist(rs.getInt("ton_tai"));

                    DataSource.getInstance().releaseConnection(connection);
                    rs.close();
                    s.close();
                    return category;
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
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM danh_muc ORDER BY ma_dm");
            while(rs.next()) {
                Category category = new Category();
                category.setId(rs.getString("ma_dm"));
                category.setName(rs.getString("ten_dm"));
                String dateTime = rs.getString("ngay_tao");
                DateTime dayTime = getDateTime(dateTime);
                category.setDateCreated(dayTime);
                category.setExist(rs.getInt("ton_tai"));
                categories.add(category);
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
            ResultSet rs = s.executeQuery("SELECT * FROM danh_muc ORDER BY ma_dm DESC");
            while(rs.next()) {
                Category category = new Category();
                category.setId(rs.getString("ma_dm"));
                category.setName(rs.getString("ten_dm"));
                String dateTime = rs.getString("ngay_tao");
                DateTime dayTime = getDateTime(dateTime);
                category.setDateCreated(dayTime);
                category.setExist(rs.getInt("ton_tai"));
                categories.add(category);
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
            ResultSet rs = s.executeQuery("SELECT * FROM danh_muc ORDER BY ten_dm");
            while(rs.next()) {
                Category category = new Category();
                category.setId(rs.getString("ma_dm"));
                category.setName(rs.getString("ten_dm"));
                String dateTime = rs.getString("ngay_tao");
                DateTime dayTime = getDateTime(dateTime);
                category.setDateCreated(dayTime);
                category.setExist(rs.getInt("ton_tai"));
                categories.add(category);
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
            ResultSet rs = s.executeQuery("SELECT * FROM danh_muc ORDER BY ten_dm DESC");
            while(rs.next()) {
                Category category = new Category();
                category.setId(rs.getString("ma_dm"));
                category.setName(rs.getString("ten_dm"));
                String dateTime = rs.getString("ngay_tao");
                DateTime dayTime = getDateTime(dateTime);
                category.setDateCreated(dayTime);
                category.setExist(rs.getInt("ton_tai"));
                categories.add(category);
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
            ResultSet rs = s.executeQuery("SELECT * FROM danh_muc ORDER BY ngay_tao");
            while(rs.next()) {
                Category category = new Category();
                category.setId(rs.getString("ma_dm"));
                category.setName(rs.getString("ten_dm"));
                String dateTime = rs.getString("ngay_tao");
                DateTime dayTime = getDateTime(dateTime);
                category.setDateCreated(dayTime);
                category.setExist(rs.getInt("ton_tai"));
                categories.add(category);
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
            ResultSet rs = s.executeQuery("SELECT * FROM danh_muc ORDER BY ngay_tao DESC");
            while(rs.next()) {
                Category category = new Category();
                category.setId(rs.getString("ma_dm"));
                category.setName(rs.getString("ten_dm"));
                String dateTime = rs.getString("ngay_tao");
                DateTime dayTime = getDateTime(dateTime);
                category.setDateCreated(dayTime);
                category.setExist(rs.getInt("ton_tai"));
                categories.add(category);
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
            ResultSet rs = s.executeQuery("SELECT danh_muc.maDM, count(*) as tong FROM danh_muc,sanpham " +
                    "WHERE danh_muc.maDM = sanpham.maDM GROUP BY danh_muc.maDM ORDER BY count(*)");
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
            ResultSet rs = s.executeQuery("SELECT danh_muc.maDM, count(*) as tong FROM danh_muc,sanpham " +
                    "WHERE danh_muc.maDM = sanpham.maDM GROUP BY danh_muc.maDM ORDER BY count(*) DESC");
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
    public static List<Category> sort(String input){
        if(input.equals("1")){
            return getCategoriesByDateCreatedASC();
        }
        else if(input.equals("2")){
            return getCategoriesByNameASC();
        }
        else if(input.equals("2")){
            return getCategoriesByIdASC();
        }
        return null;
    }

    public static void main(String[] args) {
//       System.out.println(addCategory("ÁP"));
//        for(Category ca : getCategoriesByNameASC()){
//            System.out.println(ca);
//        }

    }


}
