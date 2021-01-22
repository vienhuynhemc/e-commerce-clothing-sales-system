package controllerIndex.detailProduct;

import beans.account.AccountCustomer;
import beans.product.Product;
import beans.rate.Rate;
import model.loadDetailProduct.LoadDetailProductModel;
import model.rateProduct.RateProductModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

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

            int page = Integer.parseInt(request.getParameter("page"));
            String type = request.getParameter("type");

            RateProductModel rateProductModel = new RateProductModel();
            ArrayList<Rate> list = rateProductModel.loadListRate(page,type,3,id);
            request.setAttribute("listRate",list);

            int numPage = rateProductModel.getNumPage();
            request.setAttribute("numPage",numPage);


            request.getRequestDispatcher("home/detailsProduct.jsp").forward(request,response);
    }
}
