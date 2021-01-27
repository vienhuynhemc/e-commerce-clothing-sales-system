package controllerIndex.detailProduct;

import beans.product.Product;
import model.loadDetailProduct.LoadRalatedProductModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoadRalatedProductController",urlPatterns = "/LoadRalatedProductController")
public class LoadRalatedProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession pdNow = request.getSession();
//        double price = (double)pdNow.getAttribute("pdNow");

        LoadRalatedProductModel loadRalatedProductModel = new LoadRalatedProductModel();
        ArrayList<Product> list = loadRalatedProductModel.loadRalatedProduct(300000);
        request.setAttribute("listRalated",list);
      //  System.out.println("listRalated:"+price);

        request.getRequestDispatcher("home/detailsProduct.jsp").forward(request,response);
    }
}
