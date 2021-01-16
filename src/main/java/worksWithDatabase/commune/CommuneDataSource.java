package worksWithDatabase.commune;

public class CommuneDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy commune works with data base
     *      2. Trả commune works with data base
     */

    //  Khai báo communepool
    private static CommunePool communePool;

    //  Khai báo instance
    private static CommuneDataSource communeDataSource;

    //  Constructor thì khởi tạo communePool
    private CommuneDataSource() {
        communePool = new CommunePool();
    }

    //  Trả về thể hiện của communeDataSource
    public static synchronized CommuneDataSource getInstance() {

        //  Kiểm tra thử communeDataSource có null?
        if (communeDataSource == null) {

            //  null thì khởi tạo nó
            communeDataSource = new CommuneDataSource();

        }

        //  return về instance
        return communeDataSource;

    }

    //  Phương thúc lấy communeWorksWithDatabase
    public CommuneWorksWithDatabase getCommuneWorksWithDatabase() {

        //  Lấy communeWorksWithDatabase từ communePool
        return communePool.getCommuneWorksWithDatabase();

    }

    //  Phương thức trả communeWorksWithDatabase cho communePool
    public void releaseCommuneWorksWithDatabase(CommuneWorksWithDatabase communeWorksWithDatabase) {

        //  Trả communeWorksWithDatabase về cho communePool
        communePool.releaseCommuneWorksWithDatabase(communeWorksWithDatabase);

    }


}
