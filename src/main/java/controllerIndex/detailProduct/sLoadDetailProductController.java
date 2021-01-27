package controllerIndex.detailProduct;

import beans.product.Product;
import beans.product.ProductColor;
import beans.product.ProductImage;
import beans.product.Size;
import model.loadDetailProduct.LoadDetailProductModel;
import worksWithDatabase.detailProductIndex.DetailProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "sLoadDetailProductController",urlPatterns = "/sLoadDetailProductController")
public class sLoadDetailProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idProduct = request.getParameter("idProduct");
        LoadDetailProductModel a = new LoadDetailProductModel();
        Product p = a.loadProductById(idProduct);

        request.setAttribute("product",p);
        System.out.println(p);

//        String mau = p.getListColor().get(0).getMa_mau();
//        ArrayList<String> img = new ArrayList<String>();
//        for(ProductImage s : p.getListIMG()){
//            if(mau.equals(s.getMa_mau())){
//                img.add(s.getLink_hinh());
//            }
//        }
//        request.setAttribute("imgs",img);



        request.getRequestDispatcher("home/detailsProduct1.jsp").forward(request,response);

      //  ArrayList<ProductColor>  colors = a.loadColorById(idProduct);

    }
}
