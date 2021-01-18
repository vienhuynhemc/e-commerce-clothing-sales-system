package worksWithDatabase.emailNotification;

import beans.BeansConfiguration;
import beans.DateTime;
import beans.discountCode.DiscountCode;
import beans.emailNotification.EmailNotification;
import connectionDatabase.DataSource;
import model.discountCode.DiscountCodeModel;
import worksWithDatabase.account.AccountDataSource;
import worksWithDatabase.account.AccountWorksWithDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmailNotificationWorksWithDatabase {

    public EmailNotificationWorksWithDatabase() {
    }

    //  Phương thức lấy list email thông báo đầu tiên
    public List<EmailNotification> getListEmailNotificationFirst(int line) {

        List<EmailNotification> emailNotificationLists = new ArrayList<EmailNotification>();

        Connection connection = DataSource.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM email_thong_bao WHERE ton_tai = ? ORDER BY ngay_thong_bao DESC LIMIT 0,"+line);
            preparedStatement.setInt(1,0);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                EmailNotification emailNotification = new EmailNotification();
                emailNotification.setEmailNotificationId(resultSet.getString("ma_email"));
                emailNotification.setTitle(resultSet.getString("tieu_de"));
                emailNotification.setContent(resultSet.getString("noi_dung"));
                emailNotification.setDateSend(new DateTime(resultSet.getString("ngay_thong_bao")));
                emailNotification.setExists(resultSet.getInt("ton_tai"));
                emailNotification.setStaffId(resultSet.getString("ma_nv"));
                emailNotificationLists.add(emailNotification);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);

        //  Fill nốt thông tin còn lại
        AccountWorksWithDatabase accountWorksWithDatabase = AccountDataSource.getInstance().getAccountWorksWithDatabase();
        accountWorksWithDatabase.fillInformationEmailNotifications(emailNotificationLists);
        AccountDataSource.getInstance().releaseAccountWorksWithDatabase(accountWorksWithDatabase);

        return emailNotificationLists;

    }

    //  Phuơng thức lấy số email thông báo tối đa
    public int getMaximumEmailNotification(){
        Connection connection = DataSource.getInstance().getConnection();
        int result = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(ma_email) AS so_luong FROM email_thong_bao WHERE ton_tai = ?");
            preparedStatement.setInt(1,0);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            result = resultSet.getInt("so_luong");
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return result;
    }

    //  Phương thúc trả về id tiếp theo của emailNotification
    public String getNextIdEmailNotification(){
        Connection connection = DataSource.getInstance().getConnection();
        int result = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(ma_email) AS so_luong FROM email_thong_bao");
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            result = resultSet.getInt("so_luong");
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return "email_"+(result+1);
    }

    //  Phương thức lấy list emailNotification từ tất cả điều kiện
    public List<EmailNotification> getListEmailNotificationFromAll(String selectSearchAndSort, String sort, String search, int linesPerPage, int nowPage) {

        //  Hàm lấy ra filter tương ứng trong database
        String filter = null;
        switch (selectSearchAndSort) {
            case "dateCreated":
                filter = "ngay_thong_bao";
                break;
            case "id":
                filter = "ma_email";
                break;
            case "nameStaff":
                filter = "ten_hien_thi";
                break;
        }

       if(filter.equals("ten_hien_thi")){

           List<EmailNotification> emailNotificationLists = new ArrayList<EmailNotification>();

           Connection connection = DataSource.getInstance().getConnection();
           try {
               //  Tọa limit line
               int limitLine = (nowPage-1)*BeansConfiguration.LINE_OF_ON_PAGE_GUI_EMAIL_THONG_BAO;
               if(limitLine<0) limitLine = 0;

               PreparedStatement preparedStatement = connection.prepareStatement("SELECT e.*,t.ten_hien_thi FROM email_thong_bao e JOIN tai_khoan t ON e.ma_nv = t.ma_tai_khoan WHERE ton_tai = ? AND "+filter+" LIKE ? ORDER BY "+filter+" "+sort+" LIMIT "+limitLine+" , " + linesPerPage + ";");
               preparedStatement.setInt(1, 0);
               preparedStatement.setString(2,"%"+search+"%");
               ResultSet resultSet = preparedStatement.executeQuery();
               while(resultSet.next()){
                   EmailNotification emailNotification = new EmailNotification();
                   emailNotification.setEmailNotificationId(resultSet.getString("ma_email"));
                   emailNotification.setTitle(resultSet.getString("tieu_de"));
                   emailNotification.setContent(resultSet.getString("noi_dung"));
                   emailNotification.setDateSend(new DateTime(resultSet.getString("ngay_thong_bao")));
                   emailNotification.setExists(resultSet.getInt("ton_tai"));
                   emailNotification.setStaffId(resultSet.getString("ma_nv"));
                   emailNotificationLists.add(emailNotification);
               }
               resultSet.close();
               preparedStatement.close();
           } catch (SQLException throwables) {
               throwables.printStackTrace();
           }
           DataSource.getInstance().releaseConnection(connection);

           //  Fill nốt thông tin còn lại
           AccountWorksWithDatabase accountWorksWithDatabase = AccountDataSource.getInstance().getAccountWorksWithDatabase();
           accountWorksWithDatabase.fillInformationEmailNotifications(emailNotificationLists);
           AccountDataSource.getInstance().releaseAccountWorksWithDatabase(accountWorksWithDatabase);

           return emailNotificationLists;
       }else{
           List<EmailNotification> emailNotificationLists = new ArrayList<EmailNotification>();

           Connection connection = DataSource.getInstance().getConnection();
           try {

               //  Tọa limit line
               int limitLine = (nowPage-1)*BeansConfiguration.LINE_OF_ON_PAGE_GUI_EMAIL_THONG_BAO;
               if(limitLine<0) limitLine = 0;

               PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM email_thong_bao WHERE ton_tai = ? AND "+filter+" LIKE ? ORDER BY "+filter+" "+sort+" LIMIT "+limitLine+" , " + linesPerPage + ";");
               preparedStatement.setInt(1, 0);
               preparedStatement.setString(2,"%"+search+"%");
               ResultSet resultSet = preparedStatement.executeQuery();
               while(resultSet.next()){
                   EmailNotification emailNotification = new EmailNotification();
                   emailNotification.setEmailNotificationId(resultSet.getString("ma_email"));
                   emailNotification.setTitle(resultSet.getString("tieu_de"));
                   emailNotification.setContent(resultSet.getString("noi_dung"));
                   emailNotification.setDateSend(new DateTime(resultSet.getString("ngay_thong_bao")));
                   emailNotification.setExists(resultSet.getInt("ton_tai"));
                   emailNotification.setStaffId(resultSet.getString("ma_nv"));
                   emailNotificationLists.add(emailNotification);
               }
               resultSet.close();
               preparedStatement.close();
           } catch (SQLException throwables) {
               throwables.printStackTrace();
           }
           DataSource.getInstance().releaseConnection(connection);

           //  Fill nốt thông tin còn lại
           AccountWorksWithDatabase accountWorksWithDatabase = AccountDataSource.getInstance().getAccountWorksWithDatabase();
           accountWorksWithDatabase.fillInformationEmailNotifications(emailNotificationLists);
           AccountDataSource.getInstance().releaseAccountWorksWithDatabase(accountWorksWithDatabase);

           return emailNotificationLists;
       }
    }

    //  Phương thức lấy số emailNotification tối  từ tất cả điều kiện
    public int getMaximumNotificationFromAll(String selectSearchAndSort,  String search) {

        //  Hàm lấy ra filter tương ứng trong database
        String filter = null;
        switch (selectSearchAndSort) {
            case "dateCreated":
                filter = "ngay_thong_bao";
                break;
            case "id":
                filter = "ma_email";
                break;
            case "nameStaff":
                filter = "ten_hien_thi";
                break;
        }

        if(filter.equals("ten_hien_thi")){

           int result = 0;

            Connection connection = DataSource.getInstance().getConnection();
            try {

                PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(e.ma_email) AS so_luong FROM email_thong_bao e JOIN tai_khoan t ON e.ma_nv = t.ma_tai_khoan WHERE ton_tai = ? AND "+filter+" LIKE ?");
                preparedStatement.setInt(1, 0);
                preparedStatement.setString(2,"%"+search+"%");
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                result = resultSet.getInt("so_luong");
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            DataSource.getInstance().releaseConnection(connection);

            //  Fill nốt thông tin còn lại
           return result;
        }else{

            int result = 0;

            Connection connection = DataSource.getInstance().getConnection();
            try {

                PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(ma_email) AS so_luong FROM email_thong_bao WHERE ton_tai = ? AND "+filter+" LIKE ?");
                preparedStatement.setInt(1, 0);
                preparedStatement.setString(2,"%"+search+"%");
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                result = resultSet.getInt("so_luong");
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            DataSource.getInstance().releaseConnection(connection);

           return result;
        }
    }

    //  Phương thức nhận vào mã thông báo, xóa nó trong cơ sở dữ liệu
    public boolean removeOneEmailNotificationInDatabase(String id){

        //  Lấy connection
        Connection connection = DataSource.getInstance().getConnection();

        //  Kết quả
        boolean result = false;

        try {

            //  Tạo 1 preparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE email_thong_bao  SET ton_tai = 1 WHERE ma_email = ? AND ton_tai = 0");

            //  Set dữ liệu
            preparedStatement.setString(1,id);

            // update
            int row = preparedStatement.executeUpdate();

            //  Nếu có đúng 1 dòng được cập nhập thì bạn đsung
            if(row == 1){
                result  =true;
            }

            //  Đóng các thứ
            preparedStatement.close();

        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

        //  Trả connection
        DataSource.getInstance().releaseConnection(connection);

        //  Trả về kết quả có update đc hay không
        return result;

    }

    //  Phương thức thêm một thông báo mới vô csdl
    public void addEmailNotificationToDatabase(String ma_email,String noi_dung,String ma_nv,String tieu_de){
        //  Lấy connection
        Connection connection = DataSource.getInstance().getConnection();

        try {

            //  Tạo preparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO email_thong_bao VALUES (?,?,?,?,?,?)");

            //  Tạo ngày tạo là ngày hôm nay
            Date date = new Date();
            DateTime nowDate = new DateTime(date.getYear()+1900,date.getMonth()+1,date.getDate(),date.getHours(),date.getMinutes(),date.getSeconds());

            //  Set dữ liệu
            preparedStatement.setString(1,ma_email);
            preparedStatement.setString(2,nowDate.toString());
            preparedStatement.setString(3,noi_dung);
            preparedStatement.setString(4,ma_nv);
            preparedStatement.setInt(5,0);
            preparedStatement.setString(6,tieu_de);

            preparedStatement.executeUpdate();

            //  Đóng các kết nối
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //  Trả connection
        DataSource.getInstance().releaseConnection(connection);

    }

}
