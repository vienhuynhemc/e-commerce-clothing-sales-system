package worksWithDatabase.femaleProducts;



public class FProductDataSource {

        //  Khai báo instance
        private static FProductDataSource fProductDataSource;

        //  Khai báo Pool
        private FProductPool fProductPool;

        //  Constructor thì khởi tạo categoryPool
        private FProductDataSource() {
            fProductPool = new FProductPool();
        }

        //  Trả về thể hiện của datasource
        public static synchronized FProductDataSource getInstance() {

            //  Kiểm tra thử datasource có null?
            if (fProductDataSource == null) {

                //  null thì khởi tạo nó
                fProductDataSource = new FProductDataSource();

            }

            //  return về instance
            return fProductDataSource;

        }

        //  Phương thúc lấy DAO
        public FProductDAO getFProductDAO() {

            //  Lấy DAO từ Pool
            return fProductPool.getfProductDAO();

        }

        //  Phương thức trả CategoryWorksWithDatabase cho categoryPool
        public void releaseFProductDAO(FProductDAO fProductDAO) {

            //  Trả DAO về cho Pool
            fProductPool.releaseFProductDAO(fProductDAO);

        }



}
