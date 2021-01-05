package controllerAdmin.removeAccountAdmin;

import beans.account.ConvertArrayString;
import model.removeAccount.RemoveAccountNVVCModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RemoveAccountNVVCController",urlPatterns = "/RemoveAccountNVVCController")
public class RemoveAccountNVVCController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String list = request.getParameter("list");

        ArrayList<String> listRemove = new ArrayList<String>();
        listRemove = ConvertArrayString.convertString(list);

        RemoveAccountNVVCModel removeAccountNVKModel = new RemoveAccountNVVCModel();
        removeAccountNVKModel.removeAccount(listRemove);
    }
}
