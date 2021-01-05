package worksWithDatabase.viewAccess;


public class ViewAccessDataSource {


        //  Khai báo instance
        private static ViewAccessDataSource viewAccessDataSource;

        //  Khai báo ViewAccessPool
        private ViewAccessPool viewAccessPool;

        //  Constructor thì khởi tạo ViewAccessPool
        private ViewAccessDataSource() {
            viewAccessPool = new ViewAccessPool();
        }

        //  Trả về thể hiện của categorydatasource
        public static synchronized ViewAccessDataSource getInstance() {

            //  Kiểm tra thử signupdatasource có null?
            if (viewAccessDataSource == null) {

                //  null thì khởi tạo nó
                viewAccessDataSource = new ViewAccessDataSource();

            }

            //  return về instance
            return viewAccessDataSource;

        }

        //  Phương thúc lấy ViewAccessDAO
        public ViewAccessDAO getViewAccessDAO() {

            //  Lấy ViewAccessDAO từ ViewAccessPool
            return viewAccessPool.getViewAccessDAO();

        }

        //  Phương thức trả ViewAccess cho ViewAccessPool
        public void releaseViewAccessDAO(ViewAccessDAO viewAccessDAO) {

            //  Trả ViewAccessDAO về cho ViewAccessPool
            viewAccessPool.releaseViewAccessDAO(viewAccessDAO);

        }





}
