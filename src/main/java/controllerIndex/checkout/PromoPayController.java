package controllerIndex.checkout;

import com.google.gson.Gson;
import model.checkout.PromoPayModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PromoPayController",urlPatterns = "/PromoPayController")
public class PromoPayController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        double gia = Double.parseDouble(request.getParameter("total"));
        String ma_gg = request.getParameter("ma_nhap");

        System.out.println(gia);
        System.out.println(ma_gg);


        double result = new PromoPayModel().priceAfter(gia,ma_gg);


        String json = new Gson().toJson(result);


        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);


    }
}
