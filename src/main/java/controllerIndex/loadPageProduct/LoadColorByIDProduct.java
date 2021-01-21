package controllerIndex.loadPageProduct;

import beans.product.ProductColor;
import model.loadProduct.LoadSizeByIDProductModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoadColorByIDProduct",urlPatterns = "/LoadColorByIDProduct")
public class LoadColorByIDProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ma_sp = request.getParameter("ma_sp");

        System.out.println(ma_sp);


        LoadSizeByIDProductModel loadSizeByIDProductModel = new LoadSizeByIDProductModel();


        ArrayList<ProductColor> list = loadSizeByIDProductModel.laodColorByID(ma_sp);

        request.setAttribute("listColor",list);


        System.out.println(list);

        request.getRequestDispatcher("ajax/colorByIDProduct.jsp").forward(request,response);


    }
}
