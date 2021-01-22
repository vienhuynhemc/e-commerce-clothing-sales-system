package controllerIndex.rateProduct;

import beans.account.AccountCustomer;
import beans.rate.Rate;
import model.rateProduct.RateProductModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RateProductController", urlPatterns = "/RateProductController")
public class RateProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String idProduct = request.getParameter("idProduct");
//        int page = Integer.parseInt(request.getParameter("page"));
//        String type = request.getParameter("type");
//
//        RateProductModel rateProductModel = new RateProductModel();
//        ArrayList<Rate> list = rateProductModel.loadListRate(page,type,3,idProduct);
//        request.setAttribute("listRate",list);
//
//        int numPage = rateProductModel.getNumPage();
//        request.setAttribute("numPage",numPage);
//
//        request.getRequestDispatcher("LoadDetailProductController?idProduct="+idProduct).forward(request,response);
        }
}
