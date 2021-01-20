package controllerIndex.loadPageProduct;

import beans.product.Category;
import beans.product.ProductColor;
import beans.product.Size;
import model.loadProduct.LoadCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Signature;
import java.util.ArrayList;

@WebServlet(name = "LoadPageProduct",urlPatterns = "/LoadPageProduct")
public class LoadPageProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");
        request.setAttribute("type",type);

        LoadCategoryModel loadCategoryModel = new LoadCategoryModel();

        ArrayList<Category> listCategory = loadCategoryModel.laodCategory(type);
        ArrayList<ProductColor> listColor = loadCategoryModel.loadColor(type);
        ArrayList<Size> listSize = loadCategoryModel.loadSize(type);

        request.setAttribute("listCategory",listCategory);
        request.setAttribute("listColor",listColor);
        request.setAttribute("listSize",listSize);


        request.getRequestDispatcher("home/product.jsp").forward(request,response);

    }
}
