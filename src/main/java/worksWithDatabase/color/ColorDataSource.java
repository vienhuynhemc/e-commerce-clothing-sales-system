package worksWithDatabase.color;

public class ColorDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy Color works with data base
     *      2. Trả Color works with data base
     */

    //  Khai báo Colorpool
    private static ColorPool colorPool;

    //  Khai báo instance
    private static ColorDataSource colorDataSource;

    //  Constructor thì khởi tạo ColorPool
    private ColorDataSource() {
        colorPool = new ColorPool();
    }

    //  Trả về thể hiện của ColorDataSource
    public static synchronized ColorDataSource getInstance() {

        //  Kiểm tra thử ColorDataSource có null?
        if (colorDataSource == null) {

            //  null thì khởi tạo nó
            colorDataSource = new ColorDataSource();

        }

        //  return về instance
        return colorDataSource;

    }

    //  Phương thúc lấy ColorWorksWithDatabase
    public ColorWorksWithDatabase getColorWorksWithDatabase() {

        //  Lấy ColorWorksWithDatabase từ ColorPool
        return colorPool.getColorWorksWithDatabase();

    }

    //  Phương thức trả ColorWorksWithDatabase cho ColorPool
    public void releaseColorWorksWithDatabase(ColorWorksWithDatabase colorWorksWithDatabase) {

        //  Trả ColorWorksWithDatabase về cho ColorPool
        colorPool.releaseColorWorksWithDatabase(colorWorksWithDatabase);

    }


}
