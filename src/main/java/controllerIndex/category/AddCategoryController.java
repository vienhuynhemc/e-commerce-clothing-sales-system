package controllerIndex.category;

import worksWithDatabase.category.CategoryWorksWithDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddCategoryController", urlPatterns = "/AddCategoryController")
public class AddCategoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if(name != null){
            CategoryWorksWithDatabase.addCategory(name);
            response.sendRedirect("admin/home/quanLyDanhMuc.jsp");
        }
        else {
            response.sendRedirect("admin/home/quanLyDanhMuc.jsp");
        }
    }
}
