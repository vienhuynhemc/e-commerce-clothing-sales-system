package controllerIndex.checkout;

import beans.account.AccountCustomer;
import beans.cart.Cart;
import com.google.gson.Gson;
import model.checkout.PayModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PayController",urlPatterns = "/PayController")
public class PayController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        AccountCustomer user = (AccountCustomer) session.getAttribute("user");

        ArrayList<Cart> carts = (ArrayList<Cart>) session.getAttribute("carts");

        String ma_kh = user.getIdUser();

        String ghi_chu = request.getParameter("ghi_chu");

        String ma_gg = request.getParameter("ma_gg");

        int trang_thai = Integer.parseInt(request.getParameter("trang_thai"));

        String ma_tinh = request.getParameter("ma_tinh");
        String ma_huyen = request.getParameter("ma_huyen");
        String ma_xa = request.getParameter("ma_xa");

        double tong_tien = Double.parseDouble(request.getParameter("tong_tien"));

        PayModel payModel = new PayModel();

        boolean check = payModel.pay(ma_kh,ghi_chu,ma_gg,trang_thai,carts,tong_tien,ma_tinh,ma_huyen,ma_xa);

        request.setAttribute("check",check);

        request.getRequestDispatcher("notifyCheckout/checkPay.jsp").forward(request,response);

       // String json = new Gson().toJson(check);

        //System.out.println(json);

//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(json);


    }
}
