package controllerIndex.cart;

import beans.account.AccountCustomer;
import model.cart.RemoveCartModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DecreaseInCartController",urlPatterns = "/DecreaseInCartController")
public class DecreaseInCartController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        AccountCustomer user = (AccountCustomer) session.getAttribute("user");

        String ma_kh = user.getIdUser();

        String ma_sp = request.getParameter("ma_sp");
        String ma_mau = request.getParameter("ma_mau");

        System.out.println(ma_kh);
        System.out.println(ma_sp);
        System.out.println(ma_mau);

        RemoveCartModel removeCartModel = new RemoveCartModel();

        boolean check = removeCartModel.executeCart(ma_sp,ma_kh,ma_mau);

        System.out.println(check);

        request.setAttribute("check",check);

    }
}
