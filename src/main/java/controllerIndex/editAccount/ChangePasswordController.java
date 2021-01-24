package controllerIndex.editAccount;

import beans.account.AccountCustomer;
import com.google.gson.Gson;
import model.editAccountCustomer.ChangePasswordModel;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ChangePasswordController",urlPatterns = "/ChangePasswordController")
public class ChangePasswordController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        AccountCustomer user = (AccountCustomer) session.getAttribute("user");

        String userName = user.getUserName();

        String mat_khau_cu = request.getParameter("mat_khau_cu");
        String mat_khau_moi = request.getParameter("mat_khau_moi");

        boolean result;

        ChangePasswordModel changePasswordModel = new ChangePasswordModel();

        if (changePasswordModel.checkOldPassWord(userName,mat_khau_cu)){

            if (changePasswordModel.changePassWord(userName,mat_khau_moi)){
                result = true;
            }else{
                result = false;
            }
        }else{
            result = false;
        }

        String json = new Gson().toJson(result);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }
}
