package controllerAdmin.loadAccount;

import beans.account.AccountEmployee;
import model.loadAccount.LoadAccountNVKModel;
import worksWithDatabase.loadAccount.LoadNVKDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@WebServlet(name = "LoadAccountNVKController",urlPatterns = "/LoadAccountNVKController")
public class LoadAccountNVKController extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int page = Integer.parseInt(request.getParameter("page"));
        String type = request.getParameter("type");
        String search = request.getParameter("search");
        String orderby = request.getParameter("orderBy");

        LoadNVKDAO loadNVKDAO = new LoadNVKDAO();
        ArrayList<AccountEmployee> listNVK = loadNVKDAO.loadNVKAll(page, type, search, orderby);

        int numberPage = loadNVKDAO.getNumPage();
        //Laod số trang
        request.setAttribute("numberPage",numberPage);

        //load tổng sô nhân viên kho
        int sum = loadNVKDAO.getSumEployee();
        request.setAttribute("sumEployee",sum);

        //load danh sách khách hàng
        request.setAttribute("listNVK",listNVK);

        request.getRequestDispatcher("admin/home/quanLyNVK.jsp").forward(request,response);

    }
}
