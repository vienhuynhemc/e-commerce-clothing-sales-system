package connectionDatabase;

public class DataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy connection
     *      2. Trả connection
     */

    //  Khởi tạo connection pool
    private static final ConnectionPool connectionPool = new ConnectionPool(DatabaseConfiguration.DATABASE_MAX_CONNECTION, DatabaseConfiguration.DATABASE_MIN_CONNECTION);

    public static ConnectionPool getInstance() {
        return connectionPool;
    }

}
