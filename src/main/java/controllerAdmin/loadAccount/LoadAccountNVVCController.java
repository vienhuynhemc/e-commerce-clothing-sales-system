package controllerAdmin.loadAccount;

import beans.account.AccountEmployee;
import model.loadAccount.LoadAccountNVVCModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "LoadAccountNVVCController",urlPatterns = "/LoadAccountNVVCController")
public class LoadAccountNVVCController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");


        int number = Integer.parseInt(request.getParameter("page"));

        Collection<AccountEmployee> listNVVC = LoadAccountNVVCModel.getInstance().loadListNVVC(number).values();

        // int numberPage = LoadNextPageModel.getInstance().loadNumberPageKH();
        //Load số trang
        //request.setAttribute("numberPage",numberPage);
        //load danh sách khách hàng
        request.setAttribute("listNVVC",listNVVC);

        request.getRequestDispatcher("admin/home/quanLyNVGH.jsp").forward(request,response);

    }
}
