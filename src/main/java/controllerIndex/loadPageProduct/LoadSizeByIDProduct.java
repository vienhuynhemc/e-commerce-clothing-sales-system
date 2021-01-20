package controllerIndex.loadPageProduct;

import beans.product.Size;
import model.loadProduct.LoadSizeByIDProductModel;
import model.signUp.SignUp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoadSizeByIDProduct",urlPatterns = "/LoadSizeByIDProduct")
public class LoadSizeByIDProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ma_sp = request.getParameter("ma_sp");


        ArrayList<Size> list = new LoadSizeByIDProductModel().loadSizeByID(ma_sp);

        request.setAttribute("listSize",list);

        System.out.println(list);

        request.getRequestDispatcher("ajax/sizeByIDProduct.jsp").forward(request,response);



    }
}
