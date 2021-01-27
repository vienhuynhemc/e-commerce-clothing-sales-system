package controllerAdmin.removeAccountAdmin;

import beans.account.ConvertArrayString;
import com.google.gson.Gson;
import model.removeAccount.RemoveAccountKHModel;
import worksWithDatabase.removeAccount.RemoveAccountKHDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RemoveAccountHKController",urlPatterns = "/RemoveAccountHKController")
public class RemoveAccountHKController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String list = request.getParameter("list");

        ArrayList<String> listRemove = new ArrayList<String>();
        listRemove = ConvertArrayString.convertString(list);

        System.out.println(listRemove);

        RemoveAccountKHModel removeAccountKHModel = RemoveAccountKHModel.getInstance();

        int result = removeAccountKHModel.removeAccount(listRemove);

        String json = new Gson().toJson(result);

        System.out.println(json);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }
}
