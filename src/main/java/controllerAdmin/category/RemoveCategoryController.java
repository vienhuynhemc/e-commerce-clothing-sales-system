package controllerAdmin.category;

import model.category.CategoryModel;
import worksWithDatabase.category.CategoryWorksWithDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RemoveCategoryController", urlPatterns = "/RemoveCategoryController")
public class RemoveCategoryController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id =  request.getParameter("name_C").trim();
        System.out.println("ma danh muc là"+id);
        if(CategoryModel.checkRemoveCategory(id)){
            System.out.println("ok");
            request.getRequestDispatcher("LoadCategoryController?page=1&type=ngay_tao&search=&orderBy=ASC").forward(request,response);

        }
        else {
            request.getRequestDispatcher("LoadCategoryController?page=1&type=ngay_tao&search=&orderBy=ASC").forward(request,response);
        }

    }
}
