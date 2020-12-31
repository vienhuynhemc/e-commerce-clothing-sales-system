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
import java.util.ArrayList;

@WebServlet(name = "PageCategoryController",urlPatterns = "/PageCategoryController")
public class PageCategoryController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("vi-tri"));
        request.setAttribute("index",index);
//        ArrayList<Category> categories = CategoryModel.getAllList();
//        int numPage = CategoryModel.getNumberOfPage(categories,3);
//        System.out.println(numPage);
//        request.setAttribute("numberOfPage", numPage);
        request.getRequestDispatcher("CategoryController").forward(request,response);
    }
}
