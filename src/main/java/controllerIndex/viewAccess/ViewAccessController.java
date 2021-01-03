package controllerIndex.viewAccess;

import model.viewAccess.ViewAccessModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ViewAccessController",urlPatterns = "/ViewAccessController")
public class ViewAccessController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.isNew()){
            ViewAccessModel.updateView();
        }
        int view = ViewAccessModel.getViews();
        String format = String.format("%05d",view);
        request.setAttribute("view",format);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
