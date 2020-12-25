package mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
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

    // Đăng kí nhân viên kho
    public static  final int REGISTER_NVK = 2;
    // Đăng kí nhân viên giao hàng
    public static final int REGISTER_NVVC = 3;
    // Đăng kí khách hàng
    public static final int REGISTER_KH = 4;


    //--------------------------------- Khai báo thuộc tính cần thiết để gửi email ---------------------------------
    //  Properties để thiết lập server
    private Properties properties;

    //  sesstion để thiết lập phiên gửi mail, user password người gửi email
    private Session session;

    //  username để send email
    private String username;

    //--------------------------------------------------------------------------------------------------------------

    //-------------------------------------------------SINGLETON----------------------------------------------------

    private static MailModel mailModel;

    //--------------------------------------------------------------------------------------------------------------

    //  Constructor khởi tạo properties và sesstion
    private MailModel() {

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

    //  Trả về thể hiện của lớp
    public static synchronized MailModel getInstance() {

        //  Nếu thể hiện null thì tạo nó
        if (mailModel == null) {
            mailModel = new MailModel();
        }

        //  Trả về thể hiện
        return mailModel;

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
            case REGISTER_NVK:
                subject = "Tham gia TVTSHOP";
                text = "Xin chào: " + email + "\n\n Chúc mừng bạn đã trở thành nhân viên kho của TVTSHOP, hãy cùng nhau cố gắng xây dựng và phát triển Shop nhé!\n\n\nCảm ơn, chúc bạn một ngày tốt lành\nTVTSHOP";
                break;
            case REGISTER_NVVC:
                subject = "Tham gia TVTSHOP";
                text = "Xin chào: " + email + "\n\n Chúc mừng bạn đã trở thành nhân viên vận chuyển của TVTSHOP, hãy cùng nhau cố gắng xây dựng và phát triển Shop nhé!\n\n\nCảm ơn, chúc bạn một ngày tốt lành\nTVTSHOP";
                break;
            case REGISTER_KH:
                subject = "Tham gia TVTSHOP";
                text = "Xin chào: " + email + "\n\n Chúc mừng bạn đã trở thành thành viên mới của TVTSHOP, hãy mua sắm để nhận nhiều ưu đãi từ chúng tôi!\n\n\nCảm ơn, chúc bạn một ngày tốt lành\nTVTSHOP";
                break;
        }

        //  Trả về trạng thái gửi thư, thành công = email tồn tại và ngược lại
        return sendMail("TVTSHOP", email, subject, text);

    }

    //  Phương thức gửi email tới một email khách nhận vào tên người gửi, tiêu đề + nội dung
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

}
