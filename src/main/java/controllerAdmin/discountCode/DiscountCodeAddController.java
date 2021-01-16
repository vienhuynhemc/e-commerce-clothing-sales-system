package controllerAdmin.discountCode;

import beans.DateTime;
import beans.DateTimeConfiguration;
import beans.loginAdmin.UserAdmin;
import model.discountCode.DiscountCodeModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountCodeAddController", urlPatterns = "/DiscountCodeAddController")
public class DiscountCodeAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        if (userAdmin == null) {
            response.sendRedirect("admin/home/login.jsp");
        } else {
            // set charset cho cả request và responne
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            //  Lấy các thông tin cần thiết
            String id = DiscountCodeModel.getInstance().getNextDiscountCodeId();
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            String value = request.getParameter("value");
            String deadline = request.getParameter("deadline");
            String maximunNumberOfUse = request.getParameter("maximunNumberOfUse");

            //  Trước tiên kiểm tra mã nhập nhận vào có tồn tại trong cơ sở dữ liệu hay ko, tồn tại những mã vẫn còn tồn tại
            if (DiscountCodeModel.getInstance().isInDatabaseWithExists(name)) {

                //  Thêm xong thì set một biến cho request biết là thêm một đối tượng để nó cập nhập lại
                request.setAttribute("forward", "add");
                request.setAttribute("more", "Thêm thất bại, mã nhập đã tồn tại trong các mã giảm giá còn hoạt động");
                request.setAttribute("more2", "Cơ sở dữ liệu của bạn không có gì thay đổi");

                //  Xong foward tới controller đỗ dữ liệu
                request.getRequestDispatcher("DiscountCodeController").forward(request, response);

            } else {

                //  Thêm vào cơ sở dữ liệu
                //  Trước tiên chuyển dealline thành dateTime
                DateTime dateTimeDeadLine = new DateTime(deadline, DateTimeConfiguration.COVER_DATE_TIME_LIKE_DATETIME_LOCAL);

                //  Lấy ngày hiện tịa
                DateTime dateCreated = new DateTime(DateTimeConfiguration.NOW_DATE);

                //  Chuyển type từ String thành int
                int intType = DiscountCodeModel.getInstance().coverTypeFromStringToInt(type);

                //  insert vô database thôi nào
                DiscountCodeModel.getInstance().addDiscountCode(id, intType, Integer.parseInt(value), 0, Integer.parseInt(maximunNumberOfUse), dateTimeDeadLine, dateCreated, 0, name, 0);

                //  Thêm xong thì set một biến cho request biết là thêm một đối tượng để nó cập nhập lại
                request.setAttribute("forward", "add");
                request.setAttribute("more", "Thêm thành công mã giảm giá #" + id);
                request.setAttribute("more2", "Cơ sở dữ liệu của bạn đã được thay đổi");

                //  Xong foward tới controller đỗ dữ liệu
                request.getRequestDispatcher("DiscountCodeController").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
