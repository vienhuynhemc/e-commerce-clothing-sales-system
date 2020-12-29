package controllerIndex.manufacturer;

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
            ManufacturerModel.getInstance().removeOneManufacturerInDatabase(manufacturerId);

            //  Xóa xong thì set một biến cho request biết là xóa một đối tượng để nó cập nhập lại
            request.setAttribute("forward", "remove");
            request.setAttribute("more",manufacturerId);

            //  Xong foward tới controller đỗ dữ liệu
            request.getRequestDispatcher("ManufacturerController").forward(request, response);

        } else if (type.equals("group")) {

            //  Lấy list id ra
            String manufacturers = request.getParameter("manufacturers");
            String[] manufacturerIds = manufacturers.split(" ");

            //  Cho model cái list mã để nó xóa mã hãng , thay đổi cột tồn tại từ 0 -> 1
            ManufacturerModel.getInstance().removeGroupManufacturerInDatabase(manufacturerIds);

            //  Xóa xong thì set một biến cho request biết là xóa một đối tượng để nó cập nhập lại
            request.setAttribute("forward", "remove");
            request.setAttribute("more",manufacturerIds.length +" hãng sản xuất");

            //  Xong foward tới controller đỗ dữ liệu
            request.getRequestDispatcher("ManufacturerController").forward(request, response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
