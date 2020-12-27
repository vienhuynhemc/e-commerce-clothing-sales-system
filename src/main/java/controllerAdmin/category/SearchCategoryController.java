package controllerAdmin.category;

import beans.category.Category;
import worksWithDatabase.category.CategoryWorksWithDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchCategoryController",urlPatterns = "/SearchCategoryController")
public class SearchCategoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String keyword = request.getParameter("keyword");
//        List<Category> list = CategoryWorksWithDatabase.search(keyword);
        response.sendRedirect("admin/home/quanLyDanhMuc.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
