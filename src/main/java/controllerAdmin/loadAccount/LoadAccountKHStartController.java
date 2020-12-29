package controllerAdmin.loadAccount;

import beans.account.AccountCustomer;
import model.loadAccount.LoadKHStartModel;
import model.loadAccount.LoadNextPageModel;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "LoadAccountKHStartController",urlPatterns = "/LoadAccountKHStartController")
public class LoadAccountKHStartController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Collection<AccountCustomer> listKH = LoadKHStartModel.getInstance().loadListKH();

        int numberPage = LoadNextPageModel.getInstance().loadNumberPageKH();
        //Laod số trang
        request.setAttribute("numberPage",numberPage);
        //load danh sách khách hàng
        request.setAttribute("listKH",listKH);

        request.getRequestDispatcher("admin/home/quanLyKhachHang.jsp").forward(request,response);

    }
}
