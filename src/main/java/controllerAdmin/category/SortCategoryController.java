package controllerAdmin.category;

import worksWithDatabase.category.CategoryWorksWithDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SortCategoryController")
public class SortCategoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String input = request.getParameter("sort");
            if(input.equals("1")){
                CategoryWorksWithDatabase.getCategoriesByDateCreatedASC();
            }
            if(input.equals("2")){
                CategoryWorksWithDatabase.getCategoriesByNameASC();
            }
            if(input.equals("3")){
                CategoryWorksWithDatabase.getCategoriesByIdASC();
            }
    }
}
