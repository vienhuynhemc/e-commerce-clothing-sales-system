package controllerIndex.manufacturer;

import beans.BeansConfiguration;
import beans.manufacturer.Manufacturer;
import beans.nextPage.NextPageObject;
import model.manufacturer.ManufacturerModel;
import model.nextPage.NextPageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManufacturerSortController", urlPatterns = "/ManufacturerSortController")
public class ManufacturerSortController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //  Lấy nội dung tìm kiếm
        String search = (String) request.getAttribute("search");

        //  Lấy phong cách sort
        String sort = (String) request.getAttribute("sort");

        //  Lấy bộ lọc
        String selectSearchAndSort = (String) request.getAttribute("selectSearchAndSort");

        //  Lấy số trang hiện tại
        int nowPage = Integer.parseInt((String) request.getAttribute("nowPage"));

        //  Lấy số trang tối đa
        int maximunPage = Integer.parseInt((String) request.getAttribute("maximumPage"));

        //  Lấy list nextPage và set cho requesst để đổ dữ liệu next page
        List<NextPageObject> nextPages = NextPageModel.getInstance().getListNextPageObjectAdmin(nowPage, maximunPage);
        request.setAttribute("nextPages", nextPages);

        //  Trước tiên lấy list hãng sản xuất
        List<Manufacturer> manufacturers = ManufacturerModel.getInstance().getListManufacturerFromAll(selectSearchAndSort, sort, search, BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_HSX,nowPage);
        request.setAttribute("manufacturers", manufacturers);

        //  cho request số show để đổ dữ liệu next page
        request.setAttribute("numberOfShow", manufacturers.size());

        //  Số hãng sản xuất tốt đa
        int maximunManufacturer = ManufacturerModel.getInstance().getMaximunManufacturerFromAll(selectSearchAndSort,search);
        request.setAttribute("maximumManufacturer", maximunManufacturer);

        // forward tới trang của mình thôi nào
        request.getRequestDispatcher("admin/home/quanLyHangSanXuat.jsp").forward(request, response);

    }
}
