package controllerIndex.loadPageProduct;

import beans.product.Product;
import beans.product.ProductImage;
import model.loadProduct.LoadProductModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name = "LoadProduct",urlPatterns = "/LoadProduct")
public class LoadProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        int page = Integer.parseInt(request.getParameter("page"));
        int num = Integer.parseInt(request.getParameter("num"));
        String type = request.getParameter("type");
        String orderby = request.getParameter("order");
        String category = request.getParameter("category");
        String color = request.getParameter("color");
        double price = Double.parseDouble(request.getParameter("price"));
        String size = request.getParameter("size");
        String search = request.getParameter("search");

//        System.out.println(page);
//        System.out.println(num);
//        System.out.println(type);
//        System.out.println(orderby);
//        System.out.println(category);
//        System.out.println(color);
//        System.out.println(price);
//        System.out.println(size);
//        System.out.println("search " + search );


        LoadProductModel loadProductModel = new LoadProductModel();

        loadProductModel.loadProduct(page,num,type,orderby,category,color,price,size,search);

        ArrayList<Product> listProduct = loadProductModel.getListProduct();

        int numPage = loadProductModel.getNumPage();

        request.setAttribute("listProduct",listProduct);
        request.setAttribute("numPage",numPage);
        request.setAttribute("page",page);

//        System.out.println(listProduct);
//        System.out.println(numPage);
//        System.out.println(page);

        request.getRequestDispatcher("ajax/product_Ajax.jsp").forward(request,response);

    }
}
