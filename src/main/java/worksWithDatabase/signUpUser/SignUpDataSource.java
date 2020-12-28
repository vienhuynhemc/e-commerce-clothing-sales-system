package worksWithDatabase.signUpUser;

public class SignUpDataSource {


        //  Khai báo instance
        private static SignUpDataSource signUpDataSource;

        //  Khai báo categoryPool
        private SignUpPool signUpPool;

        //  Constructor thì khởi tạo signUpPool
        private SignUpDataSource() {
            signUpPool = new SignUpPool();
        }

        //  Trả về thể hiện của categorydatasource
        public static synchronized SignUpDataSource getInstance() {

            //  Kiểm tra thử signupdatasource có null?
            if (signUpDataSource == null) {

                //  null thì khởi tạo nó
                signUpDataSource = new SignUpDataSource();

            }

            //  return về instance
            return signUpDataSource;

        }

        //  Phương thúc lấy SignUpDAO
        public SignUpDAO getSignUpDAO() {

            //  Lấy SignUpDAO từ SignUpPool
            return signUpPool.getSignUpDAO();

        }

        //  Phương thức trả signUp cho singupPool
        public void releaseSignUpDAO(SignUpDAO signUpDAO) {

            //  Trả SignUPWithDatabase về cho mailPool
            signUpPool.releaseSignUpDAO(signUpDAO);

        }





}
