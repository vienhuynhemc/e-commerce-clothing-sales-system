package controllerAdmin.discountCode;

import model.discountCode.DiscountCodeModel;
import model.manufacturer.ManufacturerModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountCodeRemoveController", urlPatterns = "/DiscountCodeRemoveController")
public class DiscountCodeRemoveController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // set charset cho cả request và responne
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        //  Lấy kiểu xóa
        String type = request.getParameter("type");

        //  Tùy theo cách xóa để ta lấy dữ liệu
        if (type.equals("single")) {

            //  Một mình thì lấy mã mã giảm giá ra
            String id = request.getParameter("id");

            //  Cho model cái mã để nó xóa mã mgg , thay đổi cột tồn tại từ 0 -> 1
            boolean check = DiscountCodeModel.getInstance().removeOneDiscountCodeInDatabase(id);

            //  Xóa xong thì set một biến cho request biết là xóa một đối tượng để nó cập nhập lại
            request.setAttribute("forward", "remove");

            //  Xóa thành công chức tỏ mã có tồn tại và đã xóa
            if (check) {
                request.setAttribute("more", "Bạn đã xóa thành công #" + id);
                request.setAttribute("more2", "Việc xóa đã thay đổi dữ liệu của bạn");
            } else {
                request.setAttribute("more", "Mã giảm giá không tồn tại");
                request.setAttribute("more2", "Dữ liệu không có gì thay đổi");
            }

            //  Xong foward tới controller đỗ dữ liệu
            request.getRequestDispatcher("DiscountCodeController").forward(request, response);

        } else if (type.equals("group")) {

            //  Lấy list id ra
            String discountCodes = request.getParameter("discountCodes");
            String[] discountCodeIds = discountCodes.split(" ");

            //  Cho model cái list mã để nó xóa mã mgg , thay đổi cột tồn tại từ 0 -> 1
            int row = DiscountCodeModel.getInstance().removeGroupDiscountCodeInDatabase(discountCodeIds);

            //  Xóa xong thì set một biến cho request biết là xóa một đối tượng để nó cập nhập lại
            request.setAttribute("forward", "remove");

            //  Xem thử nó xóa được bao nhiêu dòng
            if (row == 0) {
                request.setAttribute("more", "Không xóa được mã giảm giá nào hết vì nó không tồn tại");
                request.setAttribute("more2", "Dữ liệu không có gì thay đổi");
            } else {
                request.setAttribute("more", "Bạn đã xóa thành công " + row + " mã giảm giá");
                request.setAttribute("more2", "Việc xóa đã thay đổi dữ liệu của bạn");
            }

            //  Xong foward tới controller đỗ dữ liệu
            request.getRequestDispatcher("DiscountCodeController").forward(request, response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
