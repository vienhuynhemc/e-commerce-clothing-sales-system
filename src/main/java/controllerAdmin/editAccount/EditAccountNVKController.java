package controllerAdmin.editAccount;

import model.editAccountAdmin.EditAccountNVKModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditAccountNVKController",urlPatterns = "/EditAccountNVKController")
public class EditAccountNVKController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String idUser = request.getParameter("IDUser");
        String displayName = request.getParameter("displayName");
        String fullName = request.getParameter("fullName");
        String tinh = request.getParameter("tinh");
        String huyen = request.getParameter("huyen");
        String xa = request.getParameter("xa");
        String pass = request.getParameter("passWord");
        String rePass = request.getParameter("rePassWord");
        //String avatar = request.getParameter("avatar");
        String avatar = "dep trai the";
        String salary = request.getParameter("salary");
        String gioithieu = request.getParameter("info");

        String edit  = EditAccountNVKModel.getInstance().editAccount(idUser,fullName,displayName,tinh,huyen,xa,pass,rePass,avatar,salary,gioithieu);

        request.setAttribute("edit",edit);

        System.out.println(edit);

        //response.getWriter().println(status);

        request.getRequestDispatcher("admin/home/quanLyNVK.jsp").forward(request,response);

    }
}
