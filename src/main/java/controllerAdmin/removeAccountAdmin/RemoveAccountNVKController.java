package controllerAdmin.removeAccountAdmin;

import beans.account.ConvertArrayString;
import model.removeAccount.RemoveAccountNVKModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name = "RemoveAccountNVKController",urlPatterns = "/RemoveAccountNVKController")
public class RemoveAccountNVKController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String list = request.getParameter("list");


        ArrayList<String> listRemove = new ArrayList<String>();
        listRemove = ConvertArrayString.convertString(list);

        RemoveAccountNVKModel removeAccountNVKModel = new RemoveAccountNVKModel();
        removeAccountNVKModel.removeAccount(listRemove);

    }
}
