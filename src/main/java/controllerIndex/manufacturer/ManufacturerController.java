package controllerIndex.manufacturer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManufacturerController", urlPatterns = "/ManufacturerController")
public class ManufacturerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectSearchAndSort = request.getParameter("selectSearchAndSort");
        String sort = request.getParameter("sort");
        String search = request.getParameter("search");
        String numberOfPage = request.getParameter("numberOfPage");

        response.getWriter().println(selectSearchAndSort);
        response.getWriter().println(sort);
        response.getWriter().println(search);
        response.getWriter().println(numberOfPage);
    }
}
