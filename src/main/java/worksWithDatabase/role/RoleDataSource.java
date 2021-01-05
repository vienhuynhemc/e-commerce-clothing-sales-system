package worksWithDatabase.role;

public class RoleDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy role works with data base
     *      2. Trả role works with data base
     */

    //  Khai báo rolepool
    private static RolePool rolePool;

    //  Khai báo instance
    private static RoleDataSource roleDataSource;

    //  Constructor thì khởi tạo rolePool
    private RoleDataSource() {
        rolePool = new RolePool();
    }

    //  Trả về thể hiện của roleDataSource
    public static synchronized RoleDataSource getInstance() {

        //  Kiểm tra thử roleDataSource có null?
        if (roleDataSource == null) {

            //  null thì khởi tạo nó
            roleDataSource = new RoleDataSource();

        }

        //  return về instance
        return roleDataSource;

    }

    //  Phương thúc lấy roleWorksWithDatabase
    public RoleWorksWithDatabase getRoleWorksWithDatabase() {

        //  Lấy roleWorksWithDatabase từ rolePool
        return rolePool.getRoleWorksWithDatabase();

    }

    //  Phương thức trả roleWorksWithDatabase cho rolePool
    public void releaseRoleWorksWithDatabase(RoleWorksWithDatabase roleWorksWithDatabase) {

        //  Trả roleWorksWithDatabase về cho rolePool
        rolePool.releaseRoleWorksWithDatabase(roleWorksWithDatabase);

    }

}
