package mail;

import connectionDatabase.DataSource;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.Properties;

public class MailModel {

    /*
     *  Khai báo các type để check email
     *  Cách check email ở đây là mình sẽ gửi 1 email với một nội dung tới email, nếu gửi không được chứng tỏ email
     *  không tồn tại, còn nội dung như thế nào thì tùy thuộc vào type
     */
    //  Liên hệ ở index.jsp
    public static final int CONTACT_INDEX = 0;

    //  Liên hệ ở contact.jsp
    public static final int CONTACT_CONTACT = 1;

    //--------------------------------- Khai báo thuộc tính cần thiết để gửi email ---------------------------------
    //  Properties để thiết lập server
    private Properties properties;

    //  sesstion để thiết lập phiên gửi mail, user password người gửi email
    private Session session;

    //  username để send email
    private String username;

    //--------------------------------------------------------------------------------------------------------------

    //  Constructor khởi tạo properties và sesstion
    public MailModel() {

        //--------------------------------- Properties ---------------------------------
        //  Khởi tạo properties
        properties = new Properties();

        //  Put server
        properties.put(MailConfiguration.MAIL_HOST, MailConfiguration.MAIL_SERVER);

        //  Kết nối cổng
        properties.put(MailConfiguration.URL_MAIL_PORT, MailConfiguration.MAIL_PORT);

        //  Đăng nhập mới được gửi gmail
        properties.put(MailConfiguration.MAIL_AUTH, MailConfiguration.MAIL_AUTH_STATUS);

        //  TLS
        properties.put(MailConfiguration.URL_MAIL_TLS, MailConfiguration.MAIL_TLS_STATUS);
        //------------------------------------------------------------------------------

        /*
         *  Khởi tạo sesstion, truyền vô username và password, mục đích để tất cả user có thể dùng chung tiện lợi
         *  bằng cách gọi lại hàm này và truyền lại username và password mới
         */
        initializedSesstion(MailConfiguration.USERNAME_TVTSHOP, MailConfiguration.PASSWORD_TVTSHOP);

    }

    //  Phương thức tạo session
    public void initializedSesstion(String username, String password) {

        //  Khởi tạo sesstion nhận vô properties và tạo mới 1 authen có 2 tham số là username và passowrd truyền vào
        session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        //  gán username cho username hiện tại để gửi email
        this.username = username;

    }

    //  Phương thức kiểm tra email có thật hay không bằng cách gửi gmail
    public boolean checkEmail(String email, int type) {

        //  Check email chỉ được sử dụng đối với gmail shop, vì vậy xem thử sesstion hiện tại có phải là gmail shop?
        if (this.username.compareTo(MailConfiguration.USERNAME_TVTSHOP) != 0) {

            //  Nếu khác thì ta khởi tạo lại session là gmail shop
            initializedSesstion(MailConfiguration.USERNAME_TVTSHOP, MailConfiguration.PASSWORD_TVTSHOP);

        }

        /*
         *  Khởi tạo text và subject, nội dung của chúng tùy thuộc vào type truyền vào
         *  Ta chỉ sử lý ở 2 trường hợp liên hệ, vì tạo tài khoản hay quên mật khẩu thì ta sẽ gửi mã xác nhân tới người
         *  dùng, có quy trình nghiệp vụ riêng không sài hàm này, thế nên hàm này ta chỉ viết với mục đích check email
         *  có thật hay không ở 2 form liên hệ index và contact
         */
        String subject = null;
        String text = null;

        //  Tạo tiêu đề và nội dung dựa trên type
        switch (type) {
            case CONTACT_INDEX:
                subject = "Tham gia TVTSHOP";
                text = "Kính gửi: " + email + "\n\nCảm ơn bạn đã tham gia với TVTSHOP chúng tôi, ngay từ lúc này mỗi khi có thông báo mới bạn sẽ là người biết đầu tiên!\n\n\nCảm ơn, chúc bạn một ngày tốt lành\nTVTSHOP";
                break;
            case CONTACT_CONTACT:
                subject = "Liên hệ TVTSHOP";
                text = "Kính gửi: " + email + "\n\nCảm ơn bạn đã liên hệ với TVTSHOP chúng tôi, chúng tôi đã nhận được vấn đề của bạn và nó đang trên đường tới các cộng tác viên, họ sẽ trả lời trong thời gian sớm nhất có thể, mong bạn hài lòng vì điều này!\n\n\nCảm ơn, chúc bạn một ngày tốt lành\nTVTSHOP";
                break;
        }

        //  Trả về trạng thái gửi thư, thành công = email tồn tại và ngược lại
        return sendMail("TVTSHOP", email, subject, text);

    }

    public boolean sendMail(String personal, String address, String subject, String text) {

        //  Bỏ vào try catch, nếu ok thì trả về true, ngược lại xảy ra ngoại lệ thì trả về false;
        try {

            //  Khởi tạo message
            Message message = new MimeMessage(this.session);

            //  Thiết lập người gửi
            message.setFrom(new InternetAddress(this.username, personal));

            //  Thiết lập người nhận
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(address));

            //  Thiết lập subject
            message.setSubject(subject);

            //  Thiết lập nội dung thư
            message.setText(text);

            //  Gửi thư
            Transport.send(message);

            //  oke hết thì trả về true
            return true;

        } catch (MessagingException | UnsupportedEncodingException e) {

            //  Xảy ra ngoại lệ thì thông báo rồi trả về false
            e.printStackTrace();
            System.out.println("Email: " + address + " không tồn tại");
            return false;

        }
    }

    //  Phương thức kiểm tra xem thử email có tồn tại trong cơ sở dữ liệu hay chưa
    public boolean isEmailInDatabase(String email) {

        //  Trước tiền lấy 1 connection ra
        Connection connection = DataSource.getInstance().getConnection();

        try {

            //  Tạo 1 prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT email FROM email WHERE email = ?");

            //  Gán email truyèn vào cho nó
            preparedStatement.setString(1, email);

            //  excute để lấy ra resyltset
            ResultSet resultSet = preparedStatement.executeQuery();

            //  Nếu tồn tại kết quả thì
            if (resultSet.next()) {

                //  Không null thì đóng resultset
                resultSet.close();

                //  Đóng prepared statement
                preparedStatement.close();

                //  Trả connection cho connection pool
                DataSource.getInstance().releaseConnection(connection);

                //  return true
                return true;

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //  Đi tới đây nghĩa là không tồn tại email nào cả, nên trả connection cho connection pool
        DataSource.getInstance().releaseConnection(connection);

        //  trả về false
        return false;

    }

    //  Phương thức thêm 1 email vào bảng email trong cơ sở dữ liệu
    public boolean addEmailToEmailTable(String email) {

        //  Lấy 1 connection ra
        Connection conection = DataSource.getInstance().getConnection();

        try {

            //  Bởi vị không có where ở đây nên tạo statement mà sử dụng
            Statement statement = conection.createStatement();

            //  insert dũ liệu nào
            int numberOfRowsAdded = statement.executeUpdate("INSERT INTO email VALUES('" + email + "')");

            //  Nếu như có một hàng thêm vào thì thành công
            if (numberOfRowsAdded == 1) {

                //  Đóng statement
                statement.close();

                //  Trả conncetion
                DataSource.getInstance().releaseConnection(conection);

                //  Return true
                return true;

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //  Tới đây có nghĩa là việc thêm không hoàn thành, trả connection vè trả về false
        //  Trả conncetion
        DataSource.getInstance().releaseConnection(conection);

        //  Return false
        return false;

    }

}
