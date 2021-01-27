package controllerIndex.detailProduct;

import beans.product.Product;
import beans.product.ProductDetailInformation;
import model.loadDetailProduct.LoadDetailProductModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "sLoadNumberController",urlPatterns = "/sLoadNumberController")
public class sLoadNumberController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idProduct");

        String color = request.getParameter("ma_mau");

        String size = request.getParameter("ma_size");

        LoadDetailProductModel loadDetailProductModel = new LoadDetailProductModel();

        Product p = loadDetailProductModel.loadProductById("id");

        int pi = loadDetailProductModel.getRestNumber(id,color,size);

        request.setAttribute("rest",pi);
        System.out.println("rest = "+pi);

        request.getRequestDispatcher("home/detailsProduct1.jsp").forward(request,response);


    }
}
