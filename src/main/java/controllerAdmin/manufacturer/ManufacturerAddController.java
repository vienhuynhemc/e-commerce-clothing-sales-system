package controllerAdmin.manufacturer;

import beans.loginAdmin.UserAdmin;
import model.manufacturer.ManufacturerInformationModel;
import model.manufacturer.ManufacturerModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManufacturerAddController", urlPatterns = "/ManufacturerAddController")
public class ManufacturerAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        if (userAdmin == null) {
            response.sendRedirect("admin/home/login.jsp");
        } else {
            // set charset cho cả request và responne
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            //  Lấy tên hãng ra
            String manufacturerName = request.getParameter("manufacturerName");

            //  Lấy list thông tin ra
            String manufacturerInformations = request.getParameter("manufacturerInformations");
            manufacturerInformations = manufacturerInformations.trim();

            //  Chuyển về list String
            String[] informations = manufacturerInformations.split(";");

            //  Lấy mã_hsx tiếp theo
            String manufacturerId = ManufacturerModel.getInstance().getNextManufacturerId();

            //  add to table hang_san_xuat
            ManufacturerModel.getInstance().addManufacturerToDatabase(manufacturerId, manufacturerName);

            //  add to table chi_tiet_hsx
            ManufacturerInformationModel.getInstance().addInformationToDatabase(manufacturerId, informations);

            //  Xóa xong thì set một biến cho request biết là thêm một đối tượng để nó cập nhập lại
            request.setAttribute("forward", "add");
            request.setAttribute("more", manufacturerId);

            //  Xong foward tới controller đỗ dữ liệu
            request.getRequestDispatcher("ManufacturerController").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
