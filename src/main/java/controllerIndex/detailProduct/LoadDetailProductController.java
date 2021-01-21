package controllerIndex.detailProduct;

import beans.product.Product;
import model.loadDetailProduct.LoadDetailProductModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoadDetailProductController",urlPatterns = "/LoadDetailProductController")
public class LoadDetailProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");

            String id = request.getParameter("idProduct");

            LoadDetailProductModel loadDetailProductModel = new LoadDetailProductModel();
            Product p = loadDetailProductModel.loadProductById(id);
            request.setAttribute("product",p);
            System.out.println("id: "+id);

            request.getRequestDispatcher("home/detailsProduct.jsp").forward(request,response);
    }
}
