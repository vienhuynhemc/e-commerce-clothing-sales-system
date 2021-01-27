package controllerIndex.detailProduct;

import beans.product.Product;
import beans.product.ProductDetailInformation;
import beans.product.ProductImage;
import model.loadDetailProduct.LoadDetailProductModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "sLoadSizeController", urlPatterns = "/sLoadSizeController")
public class sLoadSizeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("idProduct");


        String color = request.getParameter("ma_mau");

        System.out.println("id "+id);
        System.out.println("ma_mau " +color);

//        int page = Integer.parseInt(request.getParameter("page"));
//        String type = request.getParameter("type");

        LoadDetailProductModel loadDetailProductModel = new LoadDetailProductModel();
        Product p = loadDetailProductModel.loadProductById(id);
        request.setAttribute("product",p);

        ArrayList<String> img = new ArrayList<String>();
        for(ProductImage s : p.getListIMG()){
            if(color.equals(s.getMa_mau())){
                img.add(s.getLink_hinh());
            }
        }
        System.out.println("List anh"+img);
        request.setAttribute("imgs",img);

//        request.setAttribute("listSize",pe);

        request.getRequestDispatcher("home/detailsProduct1.jsp").forward(request,response);


    }
}
