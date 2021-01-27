package controllerAdmin.category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchCategoryController", urlPatterns = "/SearchCategoryController")
public class SearchCategoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");


        String type = request.getParameter("type");
        String keyword = request.getParameter("search");
        String orderBy = request.getParameter("orderBy");

        System.out.println("keyword = " + keyword);


        request.getRequestDispatcher("LoadCategoryController?page=1&type="+type+"&search="+keyword+"&orderBy="+orderBy).forward(request,response);

    }
}
