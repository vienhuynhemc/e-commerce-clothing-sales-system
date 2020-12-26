package controllerAdmin.LoadAccount;

import beans.account.AccountKH;
import model.loadAccount.LoadAccountKHModel;
import worksWithDatabase.loadAccount.LoadKHSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "LoadAccountKHController",urlPatterns = "/LoadAccountKHController")
public class LoadAccountKHController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, AccountKH> listKH = LoadAccountKHModel.getInstance().loadListKH();

        request.setAttribute("listKH",listKH);

        request.getRequestDispatcher("admin/home/quanLyKhachHang.jsp");

    }
}
