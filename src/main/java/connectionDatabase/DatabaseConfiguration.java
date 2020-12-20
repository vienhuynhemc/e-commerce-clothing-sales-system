package connectionDatabase;

/*
 *  Cấu trúc connection url bình thường hoặc offline là: jdbc:mysql://hostname:port/dbname
 *  - Ở đây chúng ta sử dụng database online nên connection url không có port
 *  - Cấu trúc connection url của project: jdbc:mysql://hostname/dbname
 *  - Databse của chúng ta sử dụng trên trang Clever Clound có 1 số thông tin nhưu sau:
 *      + Lưu lượng: 10mb
 *      + Kết nối tối đa: 5
 *      + Vì kết nối tối đa là 5 nên connection pool có số kết nối tối đa là 5 và tối thiểu 2
 *      (Tối đa 5 là hiển nhiên, tối thiểu là 2 ở đây có nghĩa là lúc connection ở trạng thái rãnh
 *      - 5 kết nối rãnh hết thì ta xóa bớt các connection chỉ để lại 2 connection )
 */

public class DatabaseConfiguration {

    //  Cái này là host của database online, database này của trang Clever Cloud
    public static final String HOST_NAME = "b2mp0eqcjjmuc0pzg4rh-mysql.services.clever-cloud.com";

    //  Tên của đatabase, cái này mặc định khi tạo online, không đổi được
    public static final String DATABASE_NAME = "b2mp0eqcjjmuc0pzg4rh";

    //  User name của database, được cho khi tạo database online
    public static final String USER_NAME = "ucgmnuzffqk244q9";

    //  Password của database, được cho khi tạo database online
    public static final String PASSWORD = "AqvCI2PQ96P77uHtMN2N";

    //  Url tải drivel kết nối cơ sở dữ liệu
    public static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";

    // Số kết nối tối thiểu ta thiết lập cho connection pool
    public static final int DATABASE_MIN_CONNECTION = 2;

    // Số kết nối tối đa ta thiết lập cho connection pool
    public static final int DATABASE_MAX_CONNECTION = 5;

    // Url để DrivelManager getConnection cùng với user name và password
    public static final String CONNECTION_URL = "jdbc:mysql://" + HOST_NAME + "/" + DATABASE_NAME;

}
