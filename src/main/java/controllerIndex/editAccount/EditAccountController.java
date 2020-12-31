package controllerIndex.editAccount;

import beans.account.AccountCustomer;
import model.editAccountCustomer.EditAccountModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EditAccountController",urlPatterns = "/EditAccountController")
public class EditAccountController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();

        ///AccountCustomer acc = (AccountCustomer) session.getAttribute("user");

        //String userName = acc.getUserName();
        String userName = request.getParameter("userName");
        String avatar = request.getParameter("avatar");
        String displayName = request.getParameter("displayName");
        String fullName = request.getParameter("fullName");
        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");
        String rePass = request.getParameter("rePass");

        System.out.println(userName);
        System.out.println(newPass);
        System.out.println(avatar);

        try {
            EditAccountModel editAccountModel = EditAccountModel.getInstance();

            String status = editAccountModel.chessPass(userName, oldPass, newPass, rePass);

            System.out.println(status);

            if (!status.equals("OK")) {
                request.setAttribute("error", status);
                request.getRequestDispatcher("thong-tin").forward(request, response);
            }else{
                AccountCustomer accountCustomer =  editAccountModel.editAccount(userName, displayName, fullName, avatar, newPass,oldPass,rePass);
                request.setAttribute("error", "none");
                session.setAttribute("user",accountCustomer);
                request.getRequestDispatcher("thong-tin").forward(request, response);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }
}
