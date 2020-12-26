package controllerAdmin.loadAccount;

import beans.account.AccountKH;
import model.loadAccount.LoadAccountKHModel;
import model.loadAccount.LoadNextPageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;


@WebServlet(name = "LoadAccountKHController",urlPatterns = "/LoadAccountKHController")
public class LoadAccountKHController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int number = Integer.parseInt(request.getParameter("page"));

        Collection<AccountKH> listKH = LoadAccountKHModel.getInstance().loadListKH(number).values();

        int numberPage = LoadNextPageModel.getInstance().loadNumberPageKH();
        //Laod số trang
        request.setAttribute("numberPage",numberPage);
        //load danh sách khách hàng
        request.setAttribute("listKH",listKH);

        request.getRequestDispatcher("admin/home/quanLyKhachHang.jsp").forward(request,response);

    }
}
