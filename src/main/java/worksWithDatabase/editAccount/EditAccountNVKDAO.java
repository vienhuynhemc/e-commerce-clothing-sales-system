package worksWithDatabase.editAccount;

import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EditAccountNVKDAO {

    public EditAccountNVKDAO(){

    }
    public void upDateAccountNVK(String idUser,String fullName,String displayName,String address,String passWord,String avatar,String salary,String num){

        Connection con = null;

        try {

            // sài tạm database khác khi nào có thì dùng cái này
           // con = DataSource.getInstance().getConnection();

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tvtshop?useUnicode=true&characterEncoding=utf-8", "root", "");

            // sql update nhân viên kho trong bang account
            String sql = "UPDATE account a set a.DisplayName = \""+displayName+"\", a.FullName = \""+fullName+"\",a.PassWord = \""+passWord+ "\",a.avatar = \"" + avatar+"\" WHERE a.IDUser = \""+idUser+"\"";
            System.out.println(sql);

            // sql update nhân viên kho trong bản eployee

            // chuyển thành int
            int luong = Integer.parseInt(salary);
            int gioithiu = Integer.parseInt(num);

            String sql1 = "UPDATE employee e SET e.Salary = "+luong+",e. Info = "+gioithiu+",e.Address = \""+address+"\" WHERE e.IDUser = \""+idUser+"\"";

            System.out.println(sql1);
            // update nên dùng statement

            Statement sm = con.createStatement();

            sm.executeUpdate(sql);

            sm.executeUpdate(sql1);

            // xog thì đóng lại
            sm.close();
    System.out.println("Sửa dc r");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            // chưa có database nên test thủ
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

           // DataSource.getInstance().releaseConnection(con);
        }


    }

    public static void main(String[] args) {
        EditAccountNVKDAO editAccountNVKDAO = new EditAccountNVKDAO();

        editAccountNVKDAO.upDateAccountNVK("NVK002","Nguyen van b","b pro so 1","An Mỹ - Mỹ Cát - Bình Định","123456","jaja","4000000","2");

    }




}
