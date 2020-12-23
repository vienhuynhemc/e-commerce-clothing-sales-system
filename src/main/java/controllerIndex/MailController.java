package controllerIndex;

import model.JoinUsModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MailController", urlPatterns = "/MailController")
public class MailController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //  Lấy email từ input ra
        String email = request.getParameter("email");

        //  Gọi model xử lý, nếu oke thì thêm vô database không thì không thêm vô, xong trả về kết quả
        String pageAddress = JoinUsModel.getInstance().action(email);

        //  Set attribute pageAdress vào request
        request.setAttribute("pageAddress",pageAddress);

        //  Forward lại trang index
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
