package connectionDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    /*
     *  Khai báo 2 list chứa các connection, ở đây ta sẽ synchronized phương thức nên:
     *  - list chứa không cần khai báo bằng Collection.synschronizedList
     *  - list sẽ ở trạng thái final là tốt nhất, tránh sự cố thay đổi nó
     *  - 2 list gồm:
     *      + availableConnection chứa những connection đang rãnh
     *      + busyConnections chứa những connection đang bận
     */
    private static final List<Connection> availableConnections = new ArrayList<Connection>();
    private static final List<Connection> busyConnections = new ArrayList<Connection>();

    //  Số kết nối tốt đa có thể có
    private int maxConnection;

    //  Số kết nối tối thiểu, sẽ được tạo số kết nối này lúc khởi tạo
    private int minConnection;

    //  Constructor nhận vào 2 tham số là minConnection và maxConnection
    public ConnectionPool(int maxConnection, int minConnection) {

        //  Gán 2 tham số nhận vào vào 2 biến của nó
        this.maxConnection = maxConnection;
        this.minConnection = minConnection;

        //  Load driver kết nối cơ sở dữ liệu mysql
        loadMySQLDatabaseConnectionDriver();

        //  Tạo các connection bỏ vô availableConnections, tạo bằng số kết nối tổi thiểu thôi :v
        initializeConnectionPool();

    }

    /*
     *  Phương thức này dùng để tải trình điều khiển kết nối cơ sở dữ liệu MySQL
     *  Vì chỉ có ở class này tạo các kết nối với cơ sở dữ liệu nên ta để phương thúc ở trạng thái private
     *  Phương thức này chỉ dùng 1 lần duy nhất, và được gọi trong constructor
     */
    private void loadMySQLDatabaseConnectionDriver() {

        try {

            //  Nếu không có gì xảy ra thì tải driver
            Class.forName(DatabaseConfiguration.DATABASE_DRIVER);

        } catch (ClassNotFoundException e) {

            //  Lỗi thì in ra màn hình cho biết lỗi là gì và địa chỉ của class để dễ dàng fix
            System.out.println("Không thể tải trình điều khiển kết nối cơ sở dữ liệu MySQL");
            System.out.println("Địa chỉ lỗi: connectionDatabase/ConnectionPool line 53");
            e.printStackTrace();

        }

    }

    /*
     *  Phương thức này dùng khởi tạo các kết nối ban đầu
     *  Vì chỉ dùng ở class này nên để phương thức ở trạng thái private
     *  Phương thức này chỉ dùng 1 lần duy nhất, và được gọi trong constructor
     */
    private void initializeConnectionPool() {

        try {

            //  Xem thử số connection đang có có bé hơn minConnection
            while (availableConnections.size() < minConnection) {

                //  Nếu bé hơn thì tạo connection, connection url-username-password lấy từ databaseConfiguration
                Connection connection = DriverManager.getConnection(DatabaseConfiguration.CONNECTION_URL, DatabaseConfiguration.USER_NAME, DatabaseConfiguration.PASSWORD);

                //  Tạo xong kết nối thì thêm vào list kết nối: availableConnections
                availableConnections.add(connection);

            }

        } catch (SQLException throwables) {

            //  Lỗi thì in ra màn hình cho biết lỗi là gì và địa chỉ của class để dễ dàng fix
            System.out.println("Không thể tạo nối đến cơ sở dữ liệu");
            System.out.println("Địa chỉ lỗi: connectionDatabase/ConnectionPool line 79");
            throwables.printStackTrace();

        }

    }

    /*
     *  Hàm này sẽ tạo ra một connection mới
     *  Được gọi trong 2 trường hợp:
     *      - Connection được trả lại mà đã bị close thì ta không thêm connection bị close này vào mà tạo connection mới
     *      - Khi có requset yêu cầu connection mà availableConnections rỗng
     */
    private void createNewConnection() {

        try {

            //  Xem thử số connection đang có có bé hơn maxConnection
            if (availableConnections.size() + busyConnections.size() < maxConnection) {

                //  Nếu bé hơn thì tạo connection, connection url-username-password lấy từ databaseConfiguration
                Connection connection = DriverManager.getConnection(DatabaseConfiguration.CONNECTION_URL, DatabaseConfiguration.USER_NAME, DatabaseConfiguration.PASSWORD);

                // Tạo xong kết nối thì thêm vào list kết nối: availableConnections
                availableConnections.add(connection);

                //  Tạo xong thì đánh thức các thread đang await(), để nó biết đã có connection mới mà nó lấy sử dụng
                notifyAll();

            }

        } catch (SQLException throwables) {

            //  Lỗi thì in ra màn hình cho biết lỗi là gì và địa chỉ của class để dễ dàng fix
            System.out.println("Không thể tạo nối đến cơ sở dữ liệu");
            System.out.println("Địa chỉ lỗi: connectionDatabase/ConnectionPool line 111");
            throwables.printStackTrace();

        }

    }

    /*
     *  Phương thức này dùng để lấy connection
     *  Nếu tất cả connection đều đang bận thì ta bắt client phải chờ cho tới khi có connection rãnh
     *  Cụ thể ở comment trong phương thức
     */
    public synchronized Connection getConnection() {

        //  Trước tiên xem thử có còn kết nối vào rãnh không và các kết nối đang bận có bé hơn max connection
        if (availableConnections.size() == 0 && busyConnections.size() < maxConnection) {

            //  Nếu thõa thì ta tạo 1 kết nối mới
            createNewConnection();

        }

        //  Tiếp theo xem thử còn kết nối nào rãnh không
        while (availableConnections.size() == 0) {

            //  Nếu không còn kết nối nào cả thì
            try {

                //  Ta bắt nó đợi cho đến khi nào có lời gọi nó dậy  ( notifyAll() sẽ làm điều đó )
                wait();

            } catch (InterruptedException e) {

                //  Lỗi thì in ra màn hình cho biết lỗi là gì và địa chỉ của class để dễ dàng fix
                System.out.println("Không thể wait()");
                System.out.println("Địa chỉ lỗi: connectionDatabase/ConnectionPool line 146");
                e.printStackTrace();

            }
        }

        //  Nếu như đi tới đây thì đã có connection sẵn sàng cho kết nối, ta cứ lấy connection ở vị trí đầu tiên
        //  Lấy connection từ availableConnections
        Connection connection = availableConnections.get(0);

        //  Xóa nó khỏi availableConnections
        availableConnections.remove(0);

        //  Thêm nó vào bysyConnections
        busyConnections.add(connection);

        //  Trả về connection
        return connection;

    }

    /*
     *  Phương thức này được gọi khi client trả về connection
     *  Phương thúc này phải ở trạng thái synchronized vì connectionPool là dùng chung
     */
    public synchronized void releaseConnection(Connection connection) {

        try {

            //  Nếu connection trả về ở trạng thái close
            if (connection.isClosed()) {

                //  Thì ta sẽ tạo mới connection thứ, trong này có đánh thức các client đang wait();
                createNewConnection();

            } else {

                //  Nếu không ở trạng thái close thì ta thêm nó vào availableConnection
                availableConnections.add(connection);

                //  Xóa nó khỏi busyConnections
                busyConnections.remove(connection);

                //  Đánh thức các client đang wait(), cho chúng biết đã có connecteion sẵn sàng
                notifyAll();

            }
        } catch (SQLException e) {

            //  Lỗi thì in ra màn hình cho biết lỗi là gì và địa chỉ của class để dễ dàng fix
            System.out.println("Không thể tạo nối đến cơ sở dữ liệu");
            System.out.println("Địa chỉ lỗi: connectionDatabase/ConnectionPool line 190");
            e.printStackTrace();

        }

    }

}
