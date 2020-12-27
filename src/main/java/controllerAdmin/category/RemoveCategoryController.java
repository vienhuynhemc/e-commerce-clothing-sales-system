package controllerAdmin.category;

import worksWithDatabase.category.CategoryWorksWithDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveCategoryController", urlPatterns = "/RemoveCategoryController")
public class RemoveCategoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =  request.getParameter("name_C");
        CategoryWorksWithDatabase.removeCategory(id);
        response.sendRedirect("admin/home/quanLyDanhMuc.jsp");
    }
}
