package controllerAdmin.loadAccount;

import beans.account.AccountCustomer;
import model.loadAccount.LoadAccountKHModel;
import model.loadAccount.LoadNextPageModel;
import worksWithDatabase.loadAccount.LoadKHDAO;

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


        int page = Integer.parseInt(request.getParameter("page"));
        System.out.println(page);
      //  System.out.println(page);
        String type = request.getParameter("type");


        String search = request.getParameter("search");
        String orderby = request.getParameter("orderBy");

        System.out.println(type);
        System.out.println(search);
        System.out.println(orderby);

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

        request.getRequestDispatcher("admin/home/quanLyKhachHang.jsp").forward(request,response);

    }
}
