package controllerIndex.loginUser;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CheckSessionController",urlPatterns = "/CheckSessionController")
public class CheckSessionController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();


        if (session.getAttribute("user") != null){
            response.sendRedirect("home/changeInforCustomer.jsp");
        }else{
            response.sendRedirect("home/login.jsp");
        }

    }
}
