package controllerIndex.loadPay;

import beans.order.DetailOrder1;
import worksWithDatabase.loadPageHistory.LoadDetailOrderDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoadDetailOrderController",urlPatterns = "/LoadDetailOrderController")
public class LoadDetailOrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String ma_don_hang = request.getParameter("ma_dh");

        ArrayList<DetailOrder1> list = new LoadDetailOrderDAO().listOrderByID(ma_don_hang);

        request.setAttribute("listO",list);
        request.setAttribute("donhang",ma_don_hang);

        request.getRequestDispatcher("ajax/detailOrder.jsp").forward(request,response);


    }
}
