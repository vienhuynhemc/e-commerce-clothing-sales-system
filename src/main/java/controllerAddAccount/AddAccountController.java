package controllerAddAccount;

import model.AddAccountModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddAccountController",urlPatterns = "/AddAccountController")
public class AddAccountController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }

    public void execute(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        String fullName = request.getParameter("full-name");
        String displayName = request.getParameter("display-name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String tinh = request.getParameter("tinh");
        String huyen = request.getParameter("huyen");
        String xa = request.getParameter("xa");
        String user = request.getParameter("userName");
        String pass = request.getParameter("passWord");
        String rePass = request.getParameter("rePassWord");
        String salary = request.getParameter("salary");
        String gioithieu = request.getParameter("gioi-thieu");
        String trangthaidanhgia = request.getParameter("ttdg");
        String trangthaikichhoat = request.getParameter("ttkh");



        if (pass.equals(rePass)){
            int type = Integer.parseInt(request.getParameter("type"));
            String address = xa + " - " + huyen + " - " + tinh;
            String exe = AddAccountModel.getInstance().addAccount(type,user,pass,email,phone,displayName,fullName,salary,gioithieu,address,trangthaidanhgia,trangthaikichhoat);
            if (exe.equals("OK")){
                response.sendRedirect("index.jsp");
            }else{
                request.setAttribute("fail",exe);
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        }else{
            request.setAttribute("fail","Xác nhận mật khẩu sai");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }


    }
}
