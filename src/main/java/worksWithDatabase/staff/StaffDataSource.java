package worksWithDatabase.staff;

public class StaffDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy staff works with data base
     *      2. Trả staff works with data base
     */

    //  Khai báo staffpool
    private static StaffPool staffPool;

    //  Khai báo instance
    private static StaffDataSource staffDataSource;

    //  Constructor thì khởi tạo staffPool
    private StaffDataSource() {
        staffPool = new StaffPool();
    }

    //  Trả về thể hiện của staffDataSource
    public static synchronized StaffDataSource getInstance() {

        //  Kiểm tra thử staffDataSource có null?
        if (staffDataSource == null) {

            //  null thì khởi tạo nó
            staffDataSource = new StaffDataSource();

        }

        //  return về instance
        return staffDataSource;

    }

    //  Phương thúc lấy staffWorksWithDatabase
    public StaffWorksWithDatabase getStaffWorksWithDatabase() {

        //  Lấy staffWorksWithDatabase từ staffPool
        return staffPool.getStaffWorksWithDatabase();

    }

    //  Phương thức trả staffWorksWithDatabase cho staffPool
    public void releaseStaffWorksWithDatabase(StaffWorksWithDatabase staffWorksWithDatabase) {

        //  Trả staffWorksWithDatabase về cho staffPool
        staffPool.releaseStaffWorksWithDatabase(staffWorksWithDatabase);

    }
    
}
