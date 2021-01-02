package controllerAdmin.category;

import beans.category.Category;
import model.category.CategoryModel;
import worksWithDatabase.category.CategoryWorksWithDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchCategoryController",urlPatterns = "/SearchCategoryController")
public class SearchCategoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String keyword = request.getParameter("keyword");
        System.out.println(keyword);
        if(keyword != null){
            ArrayList<Category> categories = CategoryModel.getCategoriesBySearch(keyword);
            request.setAttribute("input",keyword);
            request.setAttribute("listSearch",categories);
            request.getRequestDispatcher("CategoryController").forward(request,response);
        }
        else {
            request.getRequestDispatcher("admin/home/quanLyDanhMuc.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
