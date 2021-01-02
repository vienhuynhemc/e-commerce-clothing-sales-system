package controllerAdmin.editAccount;

import model.editAccountAdmin.EditAccountKHModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditAccountKHController",urlPatterns = "/EditAccountKHController")
public class EditAccountKHController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("userName");
        String displayName = request.getParameter("displayName");
        String fullName = request.getParameter("fullName");

        String avatar = request.getParameter("avatar");
        String pass = request.getParameter("passWord");
        String rePass = request.getParameter("rePassWord");
        String activeStatus = request.getParameter("activeStatus");
        String activeEvaluate = request.getParameter("activeEvaluate");

        System.out.println(username);
        System.out.println(displayName);
        System.out.println(pass);
        System.out.println(avatar);
        System.out.println(rePass);
        System.out.println(username);
        System.out.println(activeStatus);
        System.out.println(activeEvaluate);


        String edit = EditAccountKHModel.getInstance().editAccount(username,fullName,avatar,displayName,activeStatus,activeEvaluate,pass,rePass);

        request.setAttribute("edit",edit);

        System.out.println(edit);


        request.getRequestDispatcher("admin/home/quanLyKhachHang.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
