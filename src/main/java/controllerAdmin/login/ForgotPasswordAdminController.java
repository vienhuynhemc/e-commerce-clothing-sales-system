package controllerAdmin.login;

import beans.DateTime;
import beans.DateTimeConfiguration;
import beans.loginAdmin.ForgotPasswordAdminObject;
import beans.loginAdmin.ForgotPasswordAdminObjectConfiguration;
import model.loginAdmin.ForgotPasswordAdminModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "ForgotPasswordAdminController", urlPatterns = "/ForgotPasswordAdminController")
public class ForgotPasswordAdminController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // set charset cho cả request và responne
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        //  Kiểm tra chức năng nhận vào là gì
        String role = request.getParameter("role");

        //  Tạo sẵn 1 thằng forgot password admin object
        ForgotPasswordAdminObject forgotPasswordAdminObject = new ForgotPasswordAdminObject();

        if (role.equals("email")) {

            String email = request.getParameter("email");

            //  Kiểm tra xem thử email có tồn tại hay không
            String ma_tai_khoan = ForgotPasswordAdminModel.getInstance().isValidEmail(email);
            if (ma_tai_khoan == null) {

                //  Nếu không tồn tại thì cho nó thông báo ở chỗ email
                forgotPasswordAdminObject.setEmail(email);
                forgotPasswordAdminObject.setFillEmail(true);
                forgotPasswordAdminObject.setContent("Email của bạn chưa liên kết với tài khoản");

            } else {

                //  Tiếp theo kiểm tra thử tài khoản liên kết với email đó còn tồn tại hay không
                boolean isExistsAccount = ForgotPasswordAdminModel.getInstance().isExistsAccount(ma_tai_khoan);

                if (!isExistsAccount) {

                    //  Nếu tài khoản khôgn tồn tại thì dừng ở chỗ fill email
                    forgotPasswordAdminObject.setCode("");
                    forgotPasswordAdminObject.setFillEmail(true);
                    forgotPasswordAdminObject.setContent("Tài khoản của bạn đã bị vô hiệu hóa");

                } else {

                    //  Nếu đúng email rồi, tồn tại oke hết thì cho nó dừng ở điền code, có nghĩa là xong giao đoạn này

                    //  1. Điền thông tin đầy đủ cho ọbject
                    forgotPasswordAdminObject.setCode("");
                    forgotPasswordAdminObject.setFillCode(true);
                    forgotPasswordAdminObject.setContent("");
                    forgotPasswordAdminObject.setEmail(email);

                    //  2. Tạo và gửi cái mã tới email này, và điều không thể thiếu là lưu các thông tin cần thiết vô forgotPasswordAdminObject
                    //  Mã
                    String verifyCode = ForgotPasswordAdminModel.getInstance().getVerifyCode();
                    //  Datetime để lưu vô csdl
                    DateTime timeExistsTypeDateTime = new DateTime(DateTimeConfiguration.NOW_DATE_ADD_SOME_MINUTE);
                    //  Date để lưu vô forgotpasswordadminobject cho dễ hành động
                    Date nowDate = new Date();
                    Date timeExistsTypeDate = new Date(nowDate.getTime() + (ForgotPasswordAdminObjectConfiguration.TIME_EXISTS * DateTimeConfiguration.ONE_MINUTE_IN_MILLIS));
                    //  Lưu thông tin vô forgotpasssword admin object
                    forgotPasswordAdminObject.setCode(verifyCode);
                    forgotPasswordAdminObject.setTimeExists(timeExistsTypeDate);
                    //  Đưa mã và thời gian hết hạn mã vô csdl
                    ForgotPasswordAdminModel.getInstance().updateVerifyCodeAndTimeOut(ma_tai_khoan,verifyCode,timeExistsTypeDateTime.toString());
                    //  Gửi email có cái mã này đến địa chỉ email này
                    ForgotPasswordAdminModel.getInstance().sendMailForgotPasswordVerifyCode(email,verifyCode);

                }
            }
        }

        //  Xong xui hết thì lưu vào session và chuyển tới trang login
        request.getSession().setAttribute("forgotPasswordAdminObject", forgotPasswordAdminObject);
        response.sendRedirect("admin/home/login.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
