package worksWithDatabase;

import connectionDatabase.DataSource;

import java.sql.*;

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
                PreparedStatement s = connection.prepareStatement("INSERT INTO danhmuc VALUES (?,?,?)");
                s.setString(1, "DM" + (row + 1));
                s.setString(2, name);
                s.setDate(3, date);
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

}
