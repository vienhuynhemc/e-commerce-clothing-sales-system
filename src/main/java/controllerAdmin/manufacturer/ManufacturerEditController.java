package controllerAdmin.manufacturer;

import beans.loginAdmin.UserAdmin;
import model.manufacturer.ManufacturerInformationModel;
import model.manufacturer.ManufacturerModel;
import model.personalNotice.PersonalNoticeModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManufacturerEditController", urlPatterns = "/ManufacturerEditController")
public class ManufacturerEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        if(userAdmin == null){
            response.sendRedirect("admin/home/login.jsp");
        }else {
            // set charset cho cả request và responne
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            //  Lấy mã hãng cần cập nhập ra
            String manufacturerId = request.getParameter("manufacturerId");

            //  Lấy tên hãng ra
            String manufacturerName = request.getParameter("manufacturerName");

            //  Lấy list thông tin ra
            String manufacturerInformations = request.getParameter("manufacturerInformations");
            manufacturerInformations = manufacturerInformations.trim();

            //  Chuyển về list String
            String[] informations = manufacturerInformations.split(";");

            //  Cập nhập trong bảng hãng sản xuất
            boolean checkManufacturerTable = ManufacturerModel.getInstance().updateManufacturer(manufacturerId, manufacturerName);

            //  Nếu như việc cập nhập trong bảng manufacturer thành công thì mới làm tiếp không thì thông báo hãng sản xuất không tồn tại
            if (checkManufacturerTable) {

                //  Cập nhập trong bảng chi_tiet_hsx
                ManufacturerInformationModel.getInstance().updateInformation(manufacturerId, informations);

                request.setAttribute("more", "Cập nhật thành công " + manufacturerId);
                request.setAttribute("more2", "Việc cập nhật đã thay đổi dữ liệu của bạn");

                //  Tạo thông báo cá nhân
                PersonalNoticeModel.getInstance().addNewPersonalNoticeToDatabase(userAdmin.getAccount().getId(), "Bạn", "vừa cập nhật thông tin", "một hãng sản xuất", "có ID là:", "#"+manufacturerId);

            } else {

                request.setAttribute("more", "Cập nhật không thành công vì hãng sản xuất không tồn tại");
                request.setAttribute("more2", "Dữ liệu không có gì thay đổi");

            }

            //  Edit xong thì set một biến cho request biết là thêm một đối tượng để nó cập nhập lại
            request.setAttribute("forward", "edit");

            //  Xong foward tới controller đỗ dữ liệu
            request.getRequestDispatcher("ManufacturerController").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
