package mail;

public class MailConfiguration {

    //  URL host
    public static final String MAIL_HOST = "mail.smtp.host";

    //  Server mail, ở đây là server của google
    public static final String MAIL_SERVER = "smtp.gmail.com";

    //  URL port
    public static final String URL_MAIL_PORT = "mail.smtp.port";

    //  Mail port
    public static final String MAIL_PORT = "587";

    //  URL để kiểm tra gửi mail có cần đăng nhập hay không
    public static final String MAIL_AUTH = "mail.smtp.auth";

    //  Và đây là điều ta muốn gửi mail có cần đăng nhập hay không
    public static final String MAIL_AUTH_STATUS = "true";

    //  TLS
    public static final String URL_MAIL_TLS = "mail.smtp.starttls.enable";

    //  Điều ta muốn của TLS
    public static final String MAIL_TLS_STATUS = "true";

    //  Tài khoản gmail của shop
    public static final String USERNAME_TVTSHOP = "hvvien2k@gmail.com";

    //  Mật khẩu cấp 2 của gmail shop
    public static final String PASSWORD_TVTSHOP = "jkkxrprzunwbsyyf";

    //  Gửi mail = text
    public static final int MAIL_TEXT = 0;

    //  Gửi mail = html
    public static final int MAIL_HTML = 1;


}
