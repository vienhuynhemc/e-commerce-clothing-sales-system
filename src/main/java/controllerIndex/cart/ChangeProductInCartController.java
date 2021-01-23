package controllerIndex.cart;

import beans.account.AccountCustomer;
import beans.cart.Cart;
import com.google.gson.Gson;
import model.cart.ChangeCartModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ChangeProductInCartController",urlPatterns = "/ChangeProductInCartController")
public class ChangeProductInCartController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();

        AccountCustomer user = (AccountCustomer) session.getAttribute("user");

        String ma_kh = user.getIdUser();

        String ma_sp = request.getParameter("ma_sp");
        String ma_mau = request.getParameter("ma_mau");
        String ma_size = request.getParameter("ma_size");
        String active = request.getParameter("active");

//        System.out.println(ma_kh);
//        System.out.println(ma_sp);
//        System.out.println(ma_mau);
//        System.out.println(ma_size);

        ChangeCartModel addCartModel = new ChangeCartModel();

        Cart cart = addCartModel.executeCart(ma_sp,ma_kh,ma_mau,ma_size,active);

//        System.out.println(cart);

        String json = new Gson().toJson(cart);

//        System.out.println(json);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }
}
