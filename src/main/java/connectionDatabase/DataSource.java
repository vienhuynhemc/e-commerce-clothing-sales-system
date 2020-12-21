package connectionDatabase;

import java.sql.Connection;

public class DataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy connection
     *      2. Trả connection
     */

    //  Khai báo connection pool
    private static ConnectionPool connectionPool;

    //  Khai báo instance
    private static DataSource dataSource;

    //  Constructor thì khởi tạo connectionPool
    private DataSource() {
        connectionPool = new ConnectionPool(DatabaseConfiguration.DATABASE_MAX_CONNECTION, DatabaseConfiguration.DATABASE_MIN_CONNECTION);
    }

    //  Trả về thể hiện của datasource
    public static synchronized DataSource getInstance() {

        //  Kiểm tra thử datasource có null?
        if (dataSource == null) {

            //  null thì khởi tạo nó
            dataSource = new DataSource();

        }

        //  return về instance
        return dataSource;

    }

    //  Phương thúc lấy connection
    public Connection getConnection() {

        //  Lấy connection từ connectionPool
        return connectionPool.getConnection();

    }

    //  Phương thức trả connection cho connectionPool
    public void releaseConnection(Connection connection) {

        //  Trả connection về cho connectionPool
        connectionPool.releaseConnection(connection);

    }

}
