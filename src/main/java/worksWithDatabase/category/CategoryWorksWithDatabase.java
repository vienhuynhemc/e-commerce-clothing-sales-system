package worksWithDatabase.category;

import beans.DateTime;
import beans.category.Category;
import beans.productAdmin.ProductAdmin;
import connectionDatabase.DataSource;
import model.category.CategoryModel;

import javax.xml.crypto.Data;
import java.sql.*;
import java.sql.Date;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class CategoryWorksWithDatabase {
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

        }
        DataSource.getInstance().releaseConnection(connection);
        return list;
    }

//    public static void main(String[] args) throws SQLException{
//        LoadCategoryDAO lao = new LoadCategoryDAO();
//
//        ArrayList<Category> list2 = lao.LoadAllCategories(1,"ten_dm","","ASC",3);
//
//        for(Category c : list2){
//            System.out.println(c);
//        }
////        System.out.println(list2.toString());
//        System.out.println(lao.getNumberOfPage());
//        System.out.println(list2.size());
//    }

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


    public CategoryWorksWithDatabase() {
    }
    // kiểm tra danh mục đó có tồn tại trong hệ thống chưa
    public boolean check(String id) {

        Connection c = DataSource.getInstance().getConnection();

        try {
            PreparedStatement p = c.prepareStatement("SELECT * FROM danh_muc WHERE ma_dm = ? AND ton_tai = 1");
            p.setString(1, id);
            ResultSet rs = p.executeQuery();
            int count = 0;
            if (rs.next()) {
               count++;
            }
                if(count > 0){
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
    public boolean checkName(String name) {

        Connection c = DataSource.getInstance().getConnection();

        try {
            PreparedStatement p = c.prepareStatement("SELECT * FROM danh_muc WHERE ten_dm = ? AND ton_tai = 1");
            p.setString(1, name);
            ResultSet rs = p.executeQuery();
            int count = 0;
            if (rs.next()) {
                count++;
            }
            if(count > 0){
                DataSource.getInstance().releaseConnection(c);
                rs.close();
                p.close();
                return true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(c);
        return false;
    }

    // thêm một danh mục mới
    public boolean addCategory(String name){
        // lấy ra 1 connection
        Connection connection = DataSource.getInstance().getConnection();
        try {
                PreparedStatement check = connection.prepareStatement("SELECT * FROM danh_muc where ten_dm = ?");
                check.setString(1,name);
                ResultSet rsc = check.executeQuery();
                if(rsc.next()){
                    System.out.println("Ten danh muc da ton tai!");
                    DataSource.getInstance().releaseConnection(connection);
                    rsc.close();
                    check.close();
                    return false;
                }
                else {
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM danh_muc");
                    rs.beforeFirst();
                    rs.last();
                    int row = rs.getRow();
                    rs.close();

                    LocalDate date = LocalDate.now();
                    LocalDateTime now = LocalDateTime.now();
                    DateTime dateTime = new DateTime(date.getYear(), date.getMonthValue(), date.getDayOfMonth(), now.getHour(), now.getMinute(), now.getSecond());
                    PreparedStatement s = connection.prepareStatement("INSERT INTO danh_muc VALUES (?,?,?,?)");
                    s.setString(1, "dm_" + (row + 1));
                    s.setString(2, name);
                    s.setString(3, dateTime.toString());
                    s.setInt(4, 1);

                    int a = s.executeUpdate();

                    if (a > 0) {
                        DataSource.getInstance().releaseConnection(connection);
                        System.out.println("Them danh muc thanh cong!");
                        return true;
                    }
                    s.close();
                }

        }catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        System.out.println("Không thể thêm danh mục do đã tồn tại");
        return false;
    }
    // xóa một danh mục
    public boolean removeCategory(String id){
        // lấy ra 1 connection
        Connection connection = DataSource.getInstance().getConnection();
        try {
                    if(!check(id)){
                        DataSource.getInstance().releaseConnection(connection);
                        System.out.println("Khong ton tai danh muc!");
                        return false;
                    }
                    else {
                        PreparedStatement s = connection.prepareStatement("UPDATE danh_muc SET ton_tai = 0 where ma_dm = ?");
                        s.setString(1, id);
                        int a = s.executeUpdate();
                        s.close();
                        if (a > 0) {
                            DataSource.getInstance().releaseConnection(connection);
                            System.out.println("Xoa thanh cong");
                            return true;
                        }
                    }


        }catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        System.out.println("Không thể xóa danh mục!");
        return false;
    }
    // cập nhật danh mục sản phẩm
    public boolean updateCategory(String id, String newName){
        Connection connection = DataSource.getInstance().getConnection();
        try {
                PreparedStatement s = connection.prepareStatement("UPDATE danh_muc SET ten_dm = ? WHERE ma_dm = ? AND ton_tai = 1");
                s.setString(1, newName);
                s.setString(2, id);
                int a = s.executeUpdate();
                if(a > 0) {
                    DataSource.getInstance().releaseConnection(connection);
                    System.out.println("Cap nhat thanh cong!");
                    return true;
                }
                s.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        System.out.println("Khong the cap nhat danh muc!");
        return false;
    }
    // hiển thị danh sách danh mục sản phẩm
    public static ArrayList<Category> getAllCategories(){
        ArrayList<Category> categories = new ArrayList<>();
        Connection connection = DataSource.getInstance().getConnection();
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM danh_muc where ton_tai = 1");
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
//        finally {
//            try{
//                connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
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
            ResultSet rs = s.executeQuery("SELECT * FROM danh_muc WHERE ton_tai = 1 ORDER BY ma_dm");
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
        finally {
            try{
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
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
            ResultSet rs = s.executeQuery("SELECT * FROM danh_muc WHERE ton_tai = 1 ORDER BY ma_dm DESC");
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
        finally {
            try{
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
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
            ResultSet rs = s.executeQuery("SELECT * FROM danh_muc WHERE ton_tai = 1 ORDER BY ten_dm");
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
        finally {
            try{
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
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
            ResultSet rs = s.executeQuery("SELECT * FROM danh_muc WHERE ton_tai = 1 ORDER BY ten_dm DESC");
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
        finally {
            try{
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
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
            ResultSet rs = s.executeQuery("SELECT * FROM danh_muc WHERE ton_tai = 1 ORDER BY ngay_tao");
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
        finally {
            try{
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
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
            ResultSet rs = s.executeQuery("SELECT * FROM danh_muc WHERE ton_tai = 1 ORDER BY ngay_tao DESC");
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
        finally {
            try{
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
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
        finally {
            try{
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
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
        finally {
            try{
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        DataSource.getInstance().releaseConnection(connection);
        return new ArrayList<>();
    }
    public static List<Category> sort(String input){
        if(input.equals("1".toString())){
            return getCategoriesByDateCreatedASC();
        }
        else if(input.equals("2".toString())){
            return getCategoriesByNameASC();
        }
        else if(input.equals("3".toString())){
            return getCategoriesByIdASC();
        }
        return getAllCategories();
    }
    public ArrayList<Category> search(String input){
        Connection connection = DataSource.getInstance().getConnection();
        try {
            ArrayList<Category> categories = new ArrayList<>();
//            PreparedStatement s = connection.prepareStatement("SELECT * FROM danh_muc WHERE ? = ? OR ten_dm LIKE ? OR ngay_tao = ? AND ton_tai = 1");
            PreparedStatement s = connection.prepareStatement("SELECT * FROM danh_muc WHERE ten_dm LIKE ? AND ton_tai = 1");
            s.setString(1,"%"+input+"%");
//            s.setString(2,"ma_dm");
//            s.setString(1,"%"+input+"%");
            ResultSet rs = s.executeQuery();
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
        catch(Exception e){
            e.printStackTrace();
        }
//        finally {
//            try{
//                connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
        DataSource.getInstance().releaseConnection(connection);
        return new ArrayList<>();
    }
    // hiển thị số danh mục từ kết quả tìm kiếm để phân trang (theo tên danh mục)
//    public static int numberOfPage(String input){
//        Connection connection = DataSource.getInstance().getConnection();
//        try {
//            PreparedStatement s = connection.prepareStatement("SELECT COUNT(*) FROM danh_muc WHERE ten_dm LIKE ?");
//            s.setString(1,"%"+input+"%");
//            ResultSet rs = s.executeQuery();
//            while(rs.next()){
//                return rs.getInt(1);
//            }
//            rs.close();
//            s.close();
//            DataSource.getInstance().releaseConnection(connection);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        DataSource.getInstance().releaseConnection(connection);
//        return 0;
//    }
    public static int numberOfPage(){
        Connection connection = DataSource.getInstance().getConnection();
        try {
            Statement s = connection.createStatement();

            ResultSet rs = s.executeQuery("SELECT COUNT(*) FROM danh_muc WHERE ton_tai = 1");
            while(rs.next()){
                return rs.getInt(1);
            }
            rs.close();
            s.close();

            DataSource.getInstance().releaseConnection(connection);


        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        DataSource.getInstance().releaseConnection(connection);
        return 0;
    }
    // vid dụ 15 trang
    public static int getIndex(int index,int number){
        int result = number*(index-1)+1;
        return result;
    }
    public ArrayList<Category> getCategoriesByIndex(int index,int number){
        Connection connection = DataSource.getInstance().getConnection();
        try{
            ArrayList<Category> categories = new ArrayList<>();
            PreparedStatement s = connection.prepareStatement("select * from danh_muc WHERE ton_tai = 1 LIMIT ?,?");
            int value = getIndex(index,number);
            s.setInt(1,value-1);
            s.setInt(2,number);

            ResultSet rs = s.executeQuery();
            while(rs.next()){
                Category category = new Category();
                category.setId(rs.getString("ma_dm"));
                category.setName(rs.getString("ten_dm"));
                DateTime dateTime = getDateTime(rs.getString("ngay_tao"));
                category.setDateCreated(dateTime);
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
        finally {
            try{
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        DataSource.getInstance().releaseConnection(connection);
        return new ArrayList<>();
    }

    //  Phuơng thức nhận vô list product admin, điền tên danh mục cho nó
    public void fillNameForProductAdmin(List<ProductAdmin> products){

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ten_dm FROM danh_muc WHERE ma_dm = ?");
            for(ProductAdmin productAdmin:products){
                preparedStatement.setString(1,productAdmin.getDanh_muc().getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                productAdmin.getDanh_muc().setName(resultSet.getString("ten_dm"));
                resultSet.close();
            }
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    public static void main(String[] args) {
        CategoryWorksWithDatabase test = new CategoryWorksWithDatabase();

      // System.out.println(addCategory("ÁP"));
//        for(Category ca : categoryDAO.getCategoriesByIndex(1,3)){
//            System.out.println(ca);
//        }
        System.out.println(test.updateCategory("dm_10","ao nu"));





        }




}
