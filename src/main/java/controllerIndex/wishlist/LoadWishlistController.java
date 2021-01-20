package controllerIndex.wishlist;

import beans.account.AccountCustomer;
import beans.wishlist.Wishlist;
import model.wishlist.LoadWishlistModel;
import worksWithDatabase.wishlist.LoadWishlistDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoadWishlistController", urlPatterns = "/LoadWishlistController")
public class LoadWishlistController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        AccountCustomer accountCustomer = (AccountCustomer) session.getAttribute("user");

        String search = request.getParameter("search");
        String type = request.getParameter("type");
        int page = Integer.parseInt(request.getParameter("page")) ;
        int sex = Integer.parseInt(request.getParameter("sex"));
        int status = Integer.parseInt(request.getParameter("status"));

         ArrayList<Wishlist> list = LoadWishlistModel.loadWishlistById(page,accountCustomer.getIdUser(),search,type,sex,status,1);
         request.setAttribute("list",list);

         int numPage = LoadWishlistDAO.getNumberPage();
         request.setAttribute("numPage",numPage);

         int sumProduct = LoadWishlistDAO.getSumProduct();
         request.setAttribute("sumProduct",sumProduct);

        System.out.println("id: "+accountCustomer.getIdUser());
        System.out.println("search: "+search);
        System.out.println("page: "+page);
        System.out.println("type: "+ type);
        System.out.println("sex: "+sex);
        System.out.print("status: "+status);

        System.out.println("numPage: "+numPage);


         request.getRequestDispatcher("home/wishlist.jsp").forward(request,response);

    }
}
