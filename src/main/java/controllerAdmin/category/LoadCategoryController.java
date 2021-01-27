package controllerAdmin.category;

import beans.account.AccountCustomer;
import beans.category.Category;
import model.category.CategoryModel;
import worksWithDatabase.category.CategoryWorksWithDatabase;
import worksWithDatabase.category.LoadCategoryDAO;
import worksWithDatabase.loadAccount.LoadKHDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@WebServlet(name = "LoadCategoryController",urlPatterns = "/LoadCategoryController")
public class LoadCategoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int page = Integer.parseInt(request.getParameter("page"));

        String type = request.getParameter("type");

        String s = (String)request.getParameter("search");

        String search;
        if(s == null){
            search = "";
        }
        else{
            search = s;
        }
        System.out.println("search: "+s);
        String orderby = request.getParameter("orderBy");

        System.out.println(page);
        System.out.println(type);
        System.out.println(search);
        System.out.println(orderby);
        CategoryModel loadCategoryDAO = new CategoryModel();
        ArrayList<Category> listDM = loadCategoryDAO.getAllCategories(page,type,search,orderby,3);


        int numberPage = loadCategoryDAO.getNumberOfPage();
        //Load số trang
        request.setAttribute("numberPage",numberPage);


        //load tổng sô danh muc
        int sum = loadCategoryDAO.getNumberCategories();
        request.setAttribute("sumCategory",sum);


        //load danh sách khách hàng
        request.setAttribute("listDM",listDM);

        request.getRequestDispatcher("admin/home/quanLyDanhMuc.jsp").forward(request,response);
    }
}
