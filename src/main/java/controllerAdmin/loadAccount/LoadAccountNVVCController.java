package controllerAdmin.loadAccount;

import beans.account.AccountEmployee;
import model.loadAccount.LoadAccountNVVCModel;
import worksWithDatabase.loadAccount.LoadNVVCDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "LoadAccountNVVCController",urlPatterns = "/LoadAccountNVVCController")
public class LoadAccountNVVCController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");


        int page = Integer.parseInt(request.getParameter("page"));
        String type = request.getParameter("type");
        String search = request.getParameter("search");
        String orderby = request.getParameter("orderBy");

        LoadNVVCDAO loadNVVCDAO = new LoadNVVCDAO();
        ArrayList<AccountEmployee> listNVVC = loadNVVCDAO.loadNVVCAll(page, type, search, orderby);

        int numberPage = loadNVVCDAO.getNumPage();
        //Laod số trang
        request.setAttribute("numberPage",numberPage);

        //load tổng sô nhân viên kho
        int sum = loadNVVCDAO.getSumEployee();
        request.setAttribute("sumEployee",sum);

        //load danh sách khách hàng
        request.setAttribute("listNVVC",listNVVC);

        request.getRequestDispatcher("admin/home/quanLyNVGH.jsp").forward(request,response);

    }
}
