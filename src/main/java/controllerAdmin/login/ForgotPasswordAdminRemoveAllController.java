package controllerAdmin.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ForgotPasswordAdminRemoveAllController", urlPatterns = "/ForgotPasswordAdminRemoveAllController")
public class ForgotPasswordAdminRemoveAllController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //  Controller này chỉ đơn giản là xóa thằng forgotAdminObject ra khỏi session
        //  1. Xóa forgotPasswordAdminObject khỏi session
        request.getSession().removeAttribute("forgotPasswordAdminObject");

        //  2. sendredirect tới login
        response.sendRedirect("admin/home/login.jsp");

    }

}
