package controllerIndex.detailProduct;

import beans.account.AccountCustomer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CheckLoginController", urlPatterns = "/CheckLoginController")
public class CheckLoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        AccountCustomer accountCustomer = (AccountCustomer) session.getAttribute("user");
        if(accountCustomer == null) {
            request.getRequestDispatcher("home/login.jsp").forward(request,response);
        }
    }
}
