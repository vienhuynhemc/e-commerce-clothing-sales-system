package controllerAdmin.addAccount;

import com.google.gson.Gson;
import model.addAccount.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddAccountKHController",urlPatterns = "/AddAccountKHController")
public class AddAccountKHController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    public void execute(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String fullName = request.getParameter("fullName");
        String displayName = request.getParameter("displayName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String user = request.getParameter("userName");
        String pass = request.getParameter("passWord");
        String avatar = request.getParameter("avatar");
        String ttdg =  request.getParameter("ttdg");
        String ttkh = request.getParameter("ttkh");

        String exe = AddAccountKHModel.getInstance().addAccount( user, pass, email, avatar, phone, displayName, fullName, ttdg, ttkh);

        String json = new Gson().toJson(exe);

        System.out.println(json);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }
}
