package controllerIndex.loadPay;

import beans.account.AccountCustomer;
import beans.order.Order;
import model.loadPay.LoadPayModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoadListPayController",urlPatterns = "/LoadListPayController")
public class LoadListPayController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        AccountCustomer user = (AccountCustomer)  session.getAttribute("user");

        int page = Integer.parseInt(request.getParameter("page"));
        String search = request.getParameter("search");

//        System.out.println(page);
//        System.out.println(search);


        LoadPayModel payModel = new LoadPayModel();

        ArrayList<Order> list = payModel.loadListPay(user.getIdUser(),page,search);

        request.setAttribute("listOrder",list);
        request.setAttribute("page",page);
        request.setAttribute("numPage",payModel.getNumpage());

//        System.out.println(list);
//        System.out.println(page);
//        System.out.println(payModel.getNumpage());


        request.getRequestDispatcher("ajax/historyOrder.jsp").forward(request,response);


    }
}
