package controllerAdmin.login;

import beans.ObjectPageAdmin;
import beans.loginAdmin.*;
import model.loginAdmin.LoginAdminModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "LoginAdminController", urlPatterns = "/LoginAdminController")
public class LoginAdminController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // set charset cho cả request và responne
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        //  Lấy dữ liệu
        String tai_khoan = request.getParameter("taikhoan").trim();
        String mat_khau = request.getParameter("matkhau");
        String remember = request.getParameter("remember");

        //  Lưu biến thông báo
        LoginAdminObject loginAdminObject = new LoginAdminObject("", remember);
        boolean notify = false;

        //  Kiểm tra xem thử đúng tài khoản có đúng hay không
        String ma_tai_khoan = LoginAdminModel.getInstance().isValidAccount(tai_khoan);

        //  Nếu mã tài khoản trả về là null thì nhập sai tài khoản rồi
        if (ma_tai_khoan == null) {
            notify = true;
            loginAdminObject.setNotifyAccount(true);
            loginAdminObject.setContent("Bạn nhập sai tài khoản");
        } else {

            //  Tiếp theo kiểm tra xem tài khoản đúng rồi mà hiện tại nó bị vô hiệu hóa hay chưa
            boolean isActiveAccount = LoginAdminModel.getInstance().isExistsAccount(ma_tai_khoan);

            //  Nếu tài khoản bị vô hiệu hóa thì thông báo
            if (!isActiveAccount) {
                notify = true;
                loginAdminObject.setNotifyAccount(true);
                loginAdminObject.setContent("Tài khoản của bạn đã bị vô hiệu hóa");
            } else {

                //  Tới đây thì tài khoản của bạn đã oke rồi, kiểm tra mật khẩu thôi nào
                boolean isValidPassword = LoginAdminModel.getInstance().isValidPassword(tai_khoan, mat_khau);

                //  Nếu không đúng mật khẩu thì lưu lại tài khoản
                if (!isValidPassword) {
                    notify = true;
                    loginAdminObject.setNotifyPassword(true);
                    loginAdminObject.setAccount(tai_khoan);
                    loginAdminObject.setContent("Bạn nhập sai mật khẩu");
                }
            }
        }

        //  Nếu như có thông báo thì bạn đã nhập sai
        if (notify) {

            //  Tới trang đăng nhập thì ta xóa remember account khỏi sesstion
            request.getSession().removeAttribute("rememberAccount");

            //  Lưu vô session rồi senDirect
            request.getSession().setAttribute("loginAdminObject", loginAdminObject);
            response.sendRedirect("admin/home/login.jsp");

        } else {

            //  Nếu tới đây là oke hết rồi, chuyển người dùng tới controller chuyển trang, nếu đủ quyền hạn thì nó ở
            //  đấy luôn còn nếu không đủ thì nó sẽ cuyển tới trang tương ứng (làm thế này để trấch trường hợp vào = link)
            //  À khoang trước đó phải lưu vô session
            //  1. Lấy AccountStaffAdmin
            AccountStaffAdmin accountStaffAdmin = LoginAdminModel.getInstance().getAccountStaffAdmin(ma_tai_khoan);

            //  2. Lấy role của account này và set cho accountStaffAdmin
            Role role = new Role(LoginAdminModel.getInstance().getListRole(ma_tai_khoan));
            accountStaffAdmin.setRole(role);

            //  oke . H tạo đối tượng user rồi lưu vào session
            UserAdmin userAdmin = new UserAdmin(accountStaffAdmin, new HashMap<String, ObjectPageAdmin>());
            request.getSession().setAttribute("userAdmin", userAdmin);

            //  À quên, kiểm tra xem thứ có nhớ mật khẩu hay không. có thì tạo một đối tượng rêmmberAccount lưu vào session
            if (remember != null) {
                RememberAccount rememberAccount = new RememberAccount(tai_khoan, mat_khau);
                request.getSession().setAttribute("rememberAccount", rememberAccount);
            }

            //  sendirect tới controller điều hướng trackpage
            response.sendRedirect("TrackPageController");

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
