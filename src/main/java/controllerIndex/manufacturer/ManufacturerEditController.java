package controllerIndex.manufacturer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManufacturerEditController", urlPatterns = "/ManufacturerEditController")
public class ManufacturerEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //  Lấy mã hãng cần cập nhập ra
        String manufacturerId = request.getParameter("manufacturerId");

        //  Lấy tên hãng ra
        String manufacturerName = request.getParameter("manufacturerName");

        //  Lấy list thông tin ra
        String manufacturerInformations = request.getParameter("manufacturerInformations");
        manufacturerInformations = manufacturerInformations.trim();

        //  Chuyển về list String
        String[] informations = manufacturerInformations.split(";");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
