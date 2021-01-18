package controllerAdmin.emailNotification;

import beans.loginAdmin.UserAdmin;
import model.discountCode.DiscountCodeModel;
import model.emailNotification.EmailNotificationModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmailNotificationRemoveController", urlPatterns = "/EmailNotificationRemoveController")
public class EmailNotificationRemoveController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        if(userAdmin == null){
            response.sendRedirect("admin/home/login.jsp");
        }else {
            // set charset cho cả request và responne
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            String id = request.getParameter("id");

            //  Cho model cái mã để nó xóa mã mgg , thay đổi cột tồn tại từ 0 -> 1
            boolean check = EmailNotificationModel.getInstance().removeOneEmailNotificationInDatabase(id);

            //  Xóa xong thì set một biến cho request biết là xóa một đối tượng để nó cập nhập lại
            request.setAttribute("forward", "remove");

            //  Xóa thành công chức tỏ mã có tồn tại và đã xóa
            if (check) {
                request.setAttribute("more", "Bạn đã xóa thành công #" + id);
                request.setAttribute("more2", "Việc xóa đã thay đổi dữ liệu của bạn");
            } else {
                request.setAttribute("more", "Thông báo không tồn tại");
                request.setAttribute("more2", "Dữ liệu không có gì thay đổi");
            }

            //  Xong foward tới controller đỗ dữ liệu
            request.getRequestDispatcher("EmailNotificationController").forward(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
