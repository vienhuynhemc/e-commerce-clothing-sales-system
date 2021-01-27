package controllerIndex.editAccount;

import beans.account.AccountCustomer;
import com.google.gson.Gson;
import model.editAccountCustomer.RemoveAccountModel;
import model.logOut.LogOutModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RemoveAccountController",urlPatterns = "/RemoveAccountController")
public class RemoveAccountController extends HttpServlet {
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("ádasdasds");

        HttpSession session = request.getSession();

        AccountCustomer ma_kh = (AccountCustomer) session.getAttribute("user");

        System.out.println(ma_kh);

        RemoveAccountModel removeAccountModel = new RemoveAccountModel();

        boolean check = removeAccountModel.removeAccount(ma_kh.getIdUser());


        if (!check){
            String json = new Gson().toJson(check);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }else{
            session.invalidate();
            String json = new Gson().toJson(check);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
    }
}
