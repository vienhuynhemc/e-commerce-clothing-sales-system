package controllerIndex.manufacturer;

import model.manufacturer.ManufacturerInformationModel;
import model.manufacturer.ManufacturerModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManufacturerEditController", urlPatterns = "/ManufacturerEditController")
public class ManufacturerEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        ManufacturerModel.getInstance().updateManufacturer(manufacturerId, manufacturerName);

        //  Cập nhập trong bảng chi_tiet_hsx
        ManufacturerInformationModel.getInstance().updateInformation(manufacturerId, informations);

        //  Edit xong thì set một biến cho request biết là thêm một đối tượng để nó cập nhập lại
        request.setAttribute("forward", "edit");
        request.setAttribute("more", manufacturerId);

        //  Xong foward tới controller đỗ dữ liệu
        request.getRequestDispatcher("ManufacturerController").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
