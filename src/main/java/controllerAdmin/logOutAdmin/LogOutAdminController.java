package controllerAdmin.logOutAdmin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogOutAdminController", urlPatterns = "/LogOutAdminController")
public class LogOutAdminController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //  Trước tiên xóa userAdmin khỏi sesstion, à xóa phải kiểm tra xem thử hiện tại nó có null không đã
        if(request.getSession().getAttribute("userAdmin") != null){
            request.getSession().removeAttribute("userAdmin");
        }

        //   Xong sendirect tới trang login
        response.sendRedirect("admin/home/login.jsp");

    }
}
