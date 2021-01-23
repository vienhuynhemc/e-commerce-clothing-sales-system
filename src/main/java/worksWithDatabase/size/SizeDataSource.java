package worksWithDatabase.size;

public class SizeDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy Size works with data base
     *      2. Trả Size works with data base
     */

    //  Khai báo Sizepool
    private static SizePool sizePool;

    //  Khai báo instance
    private static SizeDataSource sizeDataSource;

    //  Constructor thì khởi tạo SizePool
    private SizeDataSource() {
        sizePool = new SizePool();
    }

    //  Trả về thể hiện của SizeDataSource
    public static synchronized SizeDataSource getInstance() {

        //  Kiểm tra thử SizeDataSource có null?
        if (sizeDataSource == null) {

            //  null thì khởi tạo nó
            sizeDataSource = new SizeDataSource();

        }

        //  return về instance
        return sizeDataSource;

    }

    //  Phương thúc lấy SizeWorksWithDatabase
    public SizeWorksWithDatabase getSizeWorksWithDatabase() {

        //  Lấy SizeWorksWithDatabase từ SizePool
        return sizePool.getSizeWorksWithDatabase();

    }

    //  Phương thức trả SizeWorksWithDatabase cho SizePool
    public void releaseSizeWorksWithDatabase(SizeWorksWithDatabase sizeWorksWithDatabase) {

        //  Trả SizeWorksWithDatabase về cho SizePool
        sizePool.releaseSizeWorksWithDatabase(sizeWorksWithDatabase);

    }


}
