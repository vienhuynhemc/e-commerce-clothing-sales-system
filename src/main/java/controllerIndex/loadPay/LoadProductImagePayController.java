package controllerIndex.loadPay;

import beans.product.ProductImage;
import worksWithDatabase.loadPageHistory.ProductImageByIDOrderDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoadProductImagePayController",urlPatterns = "/LoadProductImagePayController")
public class LoadProductImagePayController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String ma_don_hang = request.getParameter("ma_dh");

        ArrayList<ProductImage> list = new ProductImageByIDOrderDAO().listDetail(ma_don_hang);

        request.setAttribute("listI",list);

        request.getRequestDispatcher("ajax/loadImageDetailOrder.jsp").forward(request,response);


    }
}
