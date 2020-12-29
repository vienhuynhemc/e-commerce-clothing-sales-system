package controllerIndex.signUp;

import model.signUp.SignUp;
import worksWithDatabase.signUpUser.SignUpDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignUpController",urlPatterns = "/SignUpController")
public class SignUpController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String mail = request.getParameter("mail");
        String check = request.getParameter("check");

        String exe = SignUp.getInstance().checkUserInput(username, pass, name, phone, mail, check);

        System.out.println(exe);


        if (exe.equals("OK")) {
            request.setAttribute("statuss", exe);
            request.getRequestDispatcher("home/login.jsp").forward(request, response);
        }
        else {
            request.setAttribute("statuss", exe);
            request.getRequestDispatcher("home/login.jsp").forward(request, response);
        }
    }
}
