package controllerAdmin.navigation;

import beans.loginAdmin.UserAdmin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminIndexNavigation", urlPatterns = "/AdminIndexNavigation")
public class AdminIndexNavigation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //  Trước tiên xóa ông loginAdminObject khỏi session
        request.getSession().removeAttribute("loginAdminObject");

        //  Tùy theo level của nhân viên mà phân nó đến trang trang chủ tương ứng, mỗi level có một vai trò khác nhay
        //  Trước tiên lấy userAdmin ra
        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");

        //  Chuyển hướng
        //  Trang chủ admin - lv 0
        if (userAdmin.getAccount().accept("admin.index")) {
            response.sendRedirect("admin/index.jsp");
        }

        //  Trang chủ nhân viên kho - lv1
        if (userAdmin.getAccount().accept("admin.indexNVK")) {
            response.sendRedirect("admin/home/indexNVK.jsp");
        }

        //  Trang chủ nhân viên giao hàng - lv2
        if (userAdmin.getAccount().accept("admin.indexNVGH")) {
            response.sendRedirect("admin/home/indexNVGH.jsp");
        }

    }

}
