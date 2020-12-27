package controllerAdmin.category;

import worksWithDatabase.category.CategoryWorksWithDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FixCategoryController", urlPatterns = "/FixCategoryController")
public class FixCategoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("name");
            String id = request.getParameter("ids");
            CategoryWorksWithDatabase.updateCategory(id,name);
            response.sendRedirect("admin/home/quanLyDanhMuc.jsp");
    }
}
