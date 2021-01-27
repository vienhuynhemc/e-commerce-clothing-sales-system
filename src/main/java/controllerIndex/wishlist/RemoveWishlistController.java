package controllerIndex.wishlist;

import beans.account.AccountCustomer;
import model.wishlist.RemoveWishlistModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RemoveWishlistController", urlPatterns = "/RemoveWishlistController")
public class RemoveWishlistController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        AccountCustomer accountCustomer = (AccountCustomer) session.getAttribute("user");

        String idProduct = request.getParameter("ma_sp");
        String size = request.getParameter("size");
        String color = request.getParameter("ma_mau");


        System.out.println("idProduct: "+idProduct);
        System.out.println("size: "+size);
        System.out.println("color: "+color);

        String page = request.getParameter("page");
        String sex = request.getParameter("sex");
        String status = request.getParameter("status");

        System.out.println(RemoveWishlistModel.removeWishlist(idProduct,accountCustomer.getIdUser(),color,size));

        response.sendRedirect("LoadWishlistController?page="+page+"&search=&type=ngay_tao&sex="+sex+"&status="+status);


    }
}
