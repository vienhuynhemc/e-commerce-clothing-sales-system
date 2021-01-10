package controllerAdmin.loadAccount;

import beans.account.AccountCustomer;
import worksWithDatabase.loadAccount.LoadKHDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "LoadAccountKH_AjaxController",urlPatterns = "/LoadAccountKH_AjaxController")
public class LoadAccountKH_AjaxController extends HttpServlet {
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


        LoadKHDAO loadKHDAO = new LoadKHDAO();
        Collection<AccountCustomer> listKH = loadKHDAO.LoadKHAll(page,type,search,orderby);


        int numberPage = loadKHDAO.getNumPage();
        //Laod số trang
        request.setAttribute("numberPage",numberPage);


        //load tổng sô khách hàng
        int sum = loadKHDAO.getSumCustomer();
        request.setAttribute("sumCustomer",sum);

        //load danh sách khách hàng
        request.setAttribute("listKH",listKH);

        System.out.println(numberPage);
        System.out.println(sum);
        System.out.println(listKH);

        request.getRequestDispatcher("admin/ajax/LoadKHAjax.jsp").forward(request,response);

    }
}
