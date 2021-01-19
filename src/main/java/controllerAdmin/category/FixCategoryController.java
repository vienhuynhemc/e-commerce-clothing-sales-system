package controllerAdmin.category;

import model.category.CategoryModel;
import worksWithDatabase.category.CategoryWorksWithDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FixCategoryController", urlPatterns = "/FixCategoryController")
public class FixCategoryController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("name");
            String id = request.getParameter("ids").trim();

            System.out.println("ma danh muc la:"+id);


        if(CategoryModel.checkUpdateCategory(id,name)){
            System.out.println("cap nhat ok");
            request.getRequestDispatcher("LoadCategoryController?page=1&type=ngay_tao&search=&orderBy=ASC").forward(request,response);

        }
        else{
            request.getRequestDispatcher("LoadCategoryController?page=1&type=ngay_tao&search=&orderBy=ASC").forward(request,response);
        }

    }
}
