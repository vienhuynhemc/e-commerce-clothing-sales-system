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
        //  Trước tiên cứ lấy từ session ra, nếu không có thì tạo mới
        ForgotPasswordAdminObject forgotPasswordAdminObject = (ForgotPasswordAdminObject) request.getSession().getAttribute("forgotPasswordAdminObject");
        if (forgotPasswordAdminObject == null) forgotPasswordAdminObject = new ForgotPasswordAdminObject(false,false);

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
                    forgotPasswordAdminObject.setEmail(email);
                    forgotPasswordAdminObject.setFillEmail(true);
                    forgotPasswordAdminObject.setContent("Tài khoản của bạn đã bị vô hiệu hóa");

                } else {

                    //  Nếu đúng email rồi, tồn tại oke hết thì cho nó dừng ở điền code, có nghĩa là xong giao đoạn này

                    //  1. Điền thông tin đầy đủ cho ọbject
                    forgotPasswordAdminObject.setFillEmail(false);
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
                    ForgotPasswordAdminModel.getInstance().updateVerifyCodeAndTimeOut(ma_tai_khoan, verifyCode, timeExistsTypeDateTime.toString());
                    //  Gửi email có cái mã này đến địa chỉ email này
                    ForgotPasswordAdminModel.getInstance().sendMailForgotPasswordVerifyCode(email, verifyCode);

                }
            }
        } else if (role.equals("verifyCode")) {

            //  Lấy code người dùng nhập
            String code = request.getParameter("code").trim();

            if (code.length() != 6) {
                forgotPasswordAdminObject.setContent2("Mã xác nhận phải điền đủ 6 số");
                forgotPasswordAdminObject.setFillEmail(false);
                forgotPasswordAdminObject.setFillCode(true);
                forgotPasswordAdminObject.setCodeFill(code);
            } else {

                try {

                    int intCode = Integer.parseInt(code);
                    if (code.equals(forgotPasswordAdminObject.getCode())) {

                        if(forgotPasswordAdminObject.getTimeOut()>0){
                            forgotPasswordAdminObject.setContent2("");
                            forgotPasswordAdminObject.setFillEmail(false);
                            forgotPasswordAdminObject.setFillCode(false);
                            forgotPasswordAdminObject.setValidPassword(true);
                            forgotPasswordAdminObject.setCodeFill(code);
                        }else{
                            forgotPasswordAdminObject.setContent2("Mã đã hết hạn");
                            forgotPasswordAdminObject.setFillEmail(false);
                            forgotPasswordAdminObject.setFillCode(true);
                            forgotPasswordAdminObject.setCodeFill(code);
                        }

                    } else {
                        forgotPasswordAdminObject.setContent2("Mã xác nhận không đúng");
                        forgotPasswordAdminObject.setFillEmail(false);
                        forgotPasswordAdminObject.setFillCode(true);
                        forgotPasswordAdminObject.setCodeFill(code);
                    }

                } catch (Exception e) {
                    forgotPasswordAdminObject.setContent2("Mã xác nhận phải là số");
                    forgotPasswordAdminObject.setFillEmail(false);
                    forgotPasswordAdminObject.setFillCode(true);
                    forgotPasswordAdminObject.setCodeFill(code);
                }
            }
        } else if (role.equals("validPassword")) {

            //  Lấy mk và mk xác nhận
            String pass1 = request.getParameter("pass1");
            String pass2 = request.getParameter("pass2");

            //  Lấy chế độ xem
            String pass1check = request.getParameter("pass1check");
            String pass2check = request.getParameter("pass2check");

            //  Set lại chế độ xem
            if(pass1check != null){
                forgotPasswordAdminObject.setShowPass1(true);
            }else{
                forgotPasswordAdminObject.setShowPass1(false);
            }
            if(pass2check != null){
                forgotPasswordAdminObject.setShowPass2(true);
            }else{
                forgotPasswordAdminObject.setShowPass2(false);
            }

            if (pass1.equals(pass2)) {

                //  Cập nhập lại mật khẩu mới cho tài khoản
                ForgotPasswordAdminModel.getInstance().updatePasswordFromEmail(pass1,forgotPasswordAdminObject.getEmail());

                forgotPasswordAdminObject.setContent3("");
                forgotPasswordAdminObject.setFillEmail(false);
                forgotPasswordAdminObject.setFillCode(false);
                forgotPasswordAdminObject.setValidPassword(false);
                forgotPasswordAdminObject.setComplete(true);
                forgotPasswordAdminObject.setPass1(pass1);
                forgotPasswordAdminObject.setPass2(pass2);

            } else {

                forgotPasswordAdminObject.setContent3("Mật khẩu xác nhận không trùng khớp");
                forgotPasswordAdminObject.setFillEmail(false);
                forgotPasswordAdminObject.setFillCode(false);
                forgotPasswordAdminObject.setValidPassword(true);
                forgotPasswordAdminObject.setPass1(pass1);
                forgotPasswordAdminObject.setPass2(pass2);

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
