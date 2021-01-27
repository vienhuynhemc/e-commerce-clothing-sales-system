package controllerIndex.editAccount;

import beans.account.AccountCustomer;
import com.google.gson.Gson;
import model.editAccountCustomer.EditAccountModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EditAccountController",urlPatterns = "/EditAccountController")
public class EditAccountController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();

        AccountCustomer user = (AccountCustomer) session.getAttribute("user");

        String idUser = user.getIdUser();

        String displayName = request.getParameter("displayName");
        String fullName = request.getParameter("fullName");

       EditAccountModel editAccountModel = new EditAccountModel();

       AccountCustomer acc = editAccountModel.editAccount(idUser,displayName,fullName);

       boolean check = false;

       if (acc != null){
           session.setAttribute("user",acc);
           check = true;
       }
        String json = new Gson().toJson(check);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }
}
