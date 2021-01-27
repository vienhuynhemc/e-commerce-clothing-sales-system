package controllerIndex.detailProduct;

import beans.product.ProductDetailInformation;
import model.loadDetailProduct.LoadDetailProductModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoadSizeDetailProductController", urlPatterns = "/LoadSizeDetailProductController")
public class LoadSizeDetailProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("idProduct");

        String color = request.getParameter("ma_mau");

        int page = Integer.parseInt(request.getParameter("page"));
        String type = request.getParameter("type");

        LoadDetailProductModel p = new LoadDetailProductModel();
        ArrayList<ProductDetailInformation> pe =  p.getSizeById(id,color);
        System.out.println("size size size: "+pe);
        request.setAttribute("listSize",pe);

        request.getRequestDispatcher("LoadDetailProductController?idProduct="+id+"&type="+type+"&page="+page).forward(request,response);


    }
}
