package controllerAdmin.addAccount;

import model.addAccount.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddAccountController",urlPatterns = "/AddAccountController")
public class AddAccountNVKController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    execute(request, response);
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
        String salary = request.getParameter("salary");
        String gioithieu = request.getParameter("gioi-thieu");


        String exe = AddAccountNVKModel.getInstance().addAccount( user, pass, rePass, email, phone, avatar, displayName, fullName, salary, gioithieu, tinh,huyen,xa);

        request.setAttribute("status",exe);

        request.getRequestDispatcher("admin/home/quanLyNVK.jsp").forward(request,response);
    }
}
