package worksWithDatabase.address;


public class AddressDataSource {

    /*
     *  Ở đây chúng ta sẽ áp dụng mẫu singleton, có 2 nhiệm vụ có thể thực hiện khi getInstance ở đây
     *      1. Lấy Address works with data base
     *      2. Trả Address works with data base
     */

    //  Khai báo Addresspool
    private static AddressPool addressPool;

    //  Khai báo instance
    private static AddressDataSource addressDataSource;

    //  Constructor thì khởi tạo AddressPool
    private AddressDataSource() {
        addressPool = new AddressPool();
    }

    //  Trả về thể hiện của AddressDataSource
    public static synchronized AddressDataSource getInstance() {

        //  Kiểm tra thử AddressDataSource có null?
        if (addressDataSource == null) {

            //  null thì khởi tạo nó
            addressDataSource = new AddressDataSource();

        }

        //  return về instance
        return addressDataSource;

    }

    //  Phương thúc lấy AddressWorksWithDatabase
    public AddressWorksWithDatabase getAddressWorksWithDatabase() {

        //  Lấy AddressWorksWithDatabase từ AddressPool
        return addressPool.getAddressWorksWithDatabase();

    }

    //  Phương thức trả AddressWorksWithDatabase cho AddressPool
    public void releaseAddressWorksWithDatabase(AddressWorksWithDatabase addressWorksWithDatabase) {

        //  Trả AddressWorksWithDatabase về cho AddressPool
        addressPool.releaseAddressWorksWithDatabase(addressWorksWithDatabase);

    }
    
}
