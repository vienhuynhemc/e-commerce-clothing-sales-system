package controllerAdmin.discountCode;

import beans.DateTime;
import beans.DateTimeConfiguration;
import beans.loginAdmin.UserAdmin;
import model.discountCode.DiscountCodeModel;
import model.manufacturer.ManufacturerInformationModel;
import model.manufacturer.ManufacturerModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountCodeEditController", urlPatterns = "/DiscountCodeEditController")
public class DiscountCodeEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        if(userAdmin == null){
            response.sendRedirect("admin/home/login.jsp");
        }else {
            // set charset cho cả request và responne
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            //  Lấy các thông tin cần thiết
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            String value = request.getParameter("value");
            String deadline = request.getParameter("deadline");
            String maximunNumberOfUse = request.getParameter("maximunNumberOfUse");
            String dateCreated = request.getParameter("dateCreated");

            //  Kiểm tra còn tồn tại hay không
            boolean checkId = DiscountCodeModel.getInstance().isExistsInDatabaseWithId(id);

            //  Kiểm tra đợt 1
            if (checkId) {

                boolean checkName = DiscountCodeModel.getInstance().isInDatabaseWithNameAndId(name, id);

                //  Kiểm tra đợt 2
                if (!checkName) {

                    //  Cập nhập
                    //  Trước tiên chuyển dealline thành dateTime
                    DateTime dateTimeDeadLine = new DateTime(deadline, DateTimeConfiguration.COVER_DATE_TIME_LIKE_DATETIME_LOCAL);

                    //  Chuyển type từ String thành int
                    int intType = DiscountCodeModel.getInstance().coverTypeFromStringToInt(type);

                    //  insert vô database thôi nào
                    DiscountCodeModel.getInstance().editDiscountCode(id, intType, Integer.parseInt(value), 0, Integer.parseInt(maximunNumberOfUse), dateTimeDeadLine, dateCreated, 0, name, 0);

                    request.setAttribute("more", "Cập nhật thành công #" + id);
                    request.setAttribute("more2", "Việc cập nhật đã thay đổi dữ liệu của bạn");

                } else {

                    request.setAttribute("more", "Cập nhật không thành công vì mã nhập đã tồn tại ở mã giảm giá khác");
                    request.setAttribute("more2", "Dữ liệu không có gì thay đổi");

                }

                //  Edit xong thì set một biến cho request biết là thêm một đối tượng để nó cập nhập lại
                request.setAttribute("forward", "edit");

                //  Xong foward tới controller đỗ dữ liệu
                request.getRequestDispatcher("DiscountCodeController").forward(request, response);

            } else {

                request.setAttribute("more", "Cập nhật không thành công vì mã giảm giá không tồn tại");
                request.setAttribute("more2", "Dữ liệu không có gì thay đổi");

                //  Edit xong thì set một biến cho request biết là thêm một đối tượng để nó cập nhập lại
                request.setAttribute("forward", "edit");

                //  Xong foward tới controller đỗ dữ liệu
                request.getRequestDispatcher("DiscountCodeController").forward(request, response);
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
