package controllerAdmin.manufacturer;

import beans.loginAdmin.UserAdmin;
import model.manufacturer.ManufacturerModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManufacturerRemoveController", urlPatterns = "/ManufacturerRemoveController")
public class ManufacturerRemoveController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        if (userAdmin == null) {
            response.sendRedirect("admin/home/login.jsp");
        } else {
            // set charset cho cả request và responne
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            //  Lấy kiểu xóa
            String type = request.getParameter("type");

            //  Tùy theo cách xóa để ta lấy dữ liệu
            if (type.equals("single")) {

                //  Một mình thì lấy mã sản xuất ra
                String manufacturerId = request.getParameter("manufacturerId");

                //  Cho model cái mã để nó xóa mã hãng , thay đổi cột tồn tại từ 0 -> 1
                boolean check = ManufacturerModel.getInstance().removeOneManufacturerInDatabase(manufacturerId);

                //  Xóa xong thì set một biến cho request biết là xóa một đối tượng để nó cập nhập lại
                request.setAttribute("forward", "remove");

                //  Xóa thành công chức tỏ mã có tồn tại và đã xóa
                if (check) {
                    request.setAttribute("more", "Bạn đã xóa thành công " + manufacturerId);
                    request.setAttribute("more2", "Việc xóa đã thay đổi dữ liệu của bạn");
                } else {
                    request.setAttribute("more", "Hãng sản xuất không tồn tại");
                    request.setAttribute("more2", "Dữ liệu không có gì thay đổi");
                }

                //  Xong foward tới controller đỗ dữ liệu
                request.getRequestDispatcher("ManufacturerController").forward(request, response);

            } else if (type.equals("group")) {

                //  Lấy list id ra
                String manufacturers = request.getParameter("manufacturers");
                String[] manufacturerIds = manufacturers.split(" ");

                //  Cho model cái list mã để nó xóa mã hãng , thay đổi cột tồn tại từ 0 -> 1
                int row = ManufacturerModel.getInstance().removeGroupManufacturerInDatabase(manufacturerIds);

                //  Xóa xong thì set một biến cho request biết là xóa một đối tượng để nó cập nhập lại
                request.setAttribute("forward", "remove");

                //  Xem thử nó xóa được bao nhiêu dòng
                if (row == 0) {
                    request.setAttribute("more", "Không xóa được hãng nào hết vì nó không tồn tại");
                    request.setAttribute("more2", "Dữ liệu không có gì thay đổi");
                } else {
                    request.setAttribute("more", "Bạn đã xóa thành công " + row + " hãng sản xuất");
                    request.setAttribute("more2", "Việc xóa đã thay đổi dữ liệu của bạn");
                }

                //  Xong foward tới controller đỗ dữ liệu
                request.getRequestDispatcher("ManufacturerController").forward(request, response);

            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
