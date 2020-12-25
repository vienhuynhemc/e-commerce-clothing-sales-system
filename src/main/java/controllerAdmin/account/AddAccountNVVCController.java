package controllerAdmin.account;

import model.account.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddAccountNVVCController",urlPatterns = "/AddAccountNVVCController")
public class AddAccountNVVCController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
        //execute(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    public void execute(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        String fullName = request.getParameter("full-name");
        String displayName = request.getParameter("display-name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String tinh = request.getParameter("tinh");
        String huyen = request.getParameter("huyen");
        String xa = request.getParameter("xa");
        String user = request.getParameter("userName");
        String pass = request.getParameter("passWord");
        String rePass = request.getParameter("rePassWord");
        String avatar = request.getParameter("avatar");
        int salary = Integer.parseInt(request.getParameter("salary"));
        int gioithieu = Integer.parseInt(request.getParameter("gioi-thieu"));


        String exe = AddAccountNVVCModel.getInstance().addAccount( user, pass, rePass, email, phone, avatar, displayName, fullName, salary, gioithieu, tinh,huyen,xa);
        if (exe.equals("OK")){
            response.sendRedirect("index.jsp");
        }else{
            request.setAttribute("fail",exe);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}
