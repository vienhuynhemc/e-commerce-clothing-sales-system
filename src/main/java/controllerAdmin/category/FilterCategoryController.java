package controllerAdmin.category;

import beans.category.Category;
import worksWithDatabase.category.CategoryWorksWithDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "FilterCategoryController", urlPatterns = "/loc-danh-muc")
public class FilterCategoryController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        Collection<Category> categories = CategoryWorksWithDatabase.sort(type);
        request.setAttribute("list",categories);
        request.getRequestDispatcher("/admin/home/quanLyDanhMuc.jsp").forward(request,response);

    }
}
