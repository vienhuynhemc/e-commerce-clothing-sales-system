package controllerIndex.cart;

import beans.account.AccountCustomer;
import com.google.gson.Gson;
import model.cart.RemoveCartModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RemoveCartController",urlPatterns = "/RemoveCartController")
public class RemoveCartController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        AccountCustomer user = (AccountCustomer) session.getAttribute("user");

        String ma_kh = user.getIdUser();

        String ma_sp = request.getParameter("ma_sp");
        String ma_mau = request.getParameter("ma_mau");
        String ma_size = request.getParameter("ma_size");

//        System.out.println(ma_kh);
//        System.out.println(ma_sp);
//        System.out.println(ma_mau);
//        System.out.println(ma_size);

        RemoveCartModel removeCartModel = new RemoveCartModel();

        boolean check = removeCartModel.executeCart(ma_sp,ma_kh,ma_mau,ma_size);

        String json = new Gson().toJson(check);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }
}
