package controllerAdmin.emailNotification;

import beans.loginAdmin.UserAdmin;
import mail.MailModel;
import model.emailNotification.EmailNotificationModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmailNotificationAddController", urlPatterns = "/EmailNotificationAddController")
public class EmailNotificationAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        if (userAdmin == null) {
            response.sendRedirect("admin/home/login.jsp");
        } else {
            // set charset cho cả request và responne
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            String title = request.getParameter("titleSend");
            String data = request.getParameter("dataSend");

            //  Lấy id tiếp theo
            String nextId = EmailNotificationModel.getInstance().getNextIdEmailNotification();

            //  Lấy mã nhân viên
            String ma_nv = userAdmin.getAccount().getId();

            //  Thêm vô csdl
            EmailNotificationModel.getInstance().addEmailNotificationToDatabase(nextId, data, ma_nv, title);

            //  Gửi email tới tất cả moi nguoi
            MailModel.getInstance().sendMailAllJoinUs(data,title);

            //  Tạo thông báo chuông tới tất cả các accoutn admin khác

            //  Tọa thông báo cá nhân cho chính user gửi

            request.setAttribute("forward", "add");
            request.setAttribute("more", "Gửi thông báo #" + nextId + " thành công");
            request.setAttribute("more2", "Cơ sở dữ liệu của bạn đã được thay đổi");

            //  Xong foward tới controller đỗ dữ liệu
            request.getRequestDispatcher("EmailNotificationController").forward(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
