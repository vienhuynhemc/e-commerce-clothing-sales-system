package controllerIndex.loginUser;

import beans.account.AccountCustomer;
import model.loginUser.LoginUserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginUserCustomerController",urlPatterns = "/LoginUserCustomerController")
public class LoginUserCustomerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");

        // lấy ra user với username và pass ở trên kiểm tra có hay k ?

        AccountCustomer accountCustomer = LoginUserModel.getInstance().getAccountCustomer(userName,passWord);
        // nếu khác null chứng tỏ đăng nhập đúng. add user vào session User , trả về trang index;
       // System.out.println(LoginUserModel.getInstance().getStatus());
        if(accountCustomer != null){
            HttpSession session = request.getSession();
            session.setAttribute("user",accountCustomer);
            response.sendRedirect("index.jsp");
        }else{ // nếu = null chứng tỏ sai
            request.setAttribute("loginStatus",LoginUserModel.getInstance().getStatus());
            request.getRequestDispatcher("dang-nhap").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
