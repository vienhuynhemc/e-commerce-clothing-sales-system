package controllerAdmin.editAccount;

import com.google.gson.Gson;
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
        String pass = request.getParameter("passWord");
        String activeStatus = request.getParameter("activeStatus");
        String activeEvaluate = request.getParameter("activeEvaluate");

        System.out.println(username);
        System.out.println(displayName);
        System.out.println(pass);
        System.out.println(activeStatus);
        System.out.println(activeEvaluate);

        if (pass == ""){
            request.setAttribute("thongbao",false);
            request.getRequestDispatcher("SendRedirectPageKH").forward(request,response);
        }else{
            boolean edit = EditAccountKHModel.getInstance().editAccount(username,fullName,displayName,activeStatus,activeEvaluate,pass);

            request.setAttribute("thongbao",edit);

            request.getRequestDispatcher("SendRedirectPageKH").forward(request,response);
        }

//        String json = new Gson().toJson(edit);
//
//        System.out.println(json);
//
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
