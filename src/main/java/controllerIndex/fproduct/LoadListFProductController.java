package controllerIndex.fproduct;

import beans.fproduct.FProduct;
//import model.femaleProduct.FProductModel;
import worksWithDatabase.femaleProducts.FProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoadListFProductController", urlPatterns = "/LoadListFProductController")
public class LoadListFProductController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int page = Integer.parseInt(request.getParameter("page"));

        String search = request.getParameter("search");

        String type = request.getParameter("type");

        String orderBy = request.getParameter("orderBy");

        String idCategory = request.getParameter("idCategory");

        FProductDAO productDAO = new FProductDAO();
        ArrayList<FProduct> list = productDAO.loadAllFProduct(page,search,type,orderBy,idCategory,1);

        // lấy số trang 1,2,3...

        int numPage = productDAO.getNumberOfPage();
        request.setAttribute("numPage",numPage);

        // lấy tổng sản phẩm
        int sumProduct = productDAO.getNumberOfProduct();
        request.setAttribute("sumProduct",sumProduct);

        request.setAttribute("list",list);

        request.getRequestDispatcher("home/product2.jsp").forward(request,response);
    }
}
