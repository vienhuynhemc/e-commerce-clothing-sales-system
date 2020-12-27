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

@WebServlet(name = "ManufacturerController", urlPatterns = "/ManufacturerController")
public class ManufacturerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // set charset cho cả request và responne
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        //----------Lấy những thông tin cần thiết của trang này------------------//

        //  Select sort and search
        String selectSearchAndSort = request.getParameter("selectSearchAndSort");

        //  sort DESC hay ASC, null == DESC on == ASC
        String sort = request.getParameter("sort");

        //  Nội dung ô tìm kiếm
        String search = request.getParameter("search");

        //  Số trang đi tới
        String numberOfPage = request.getParameter("numberOfPage");

        //  Số trang maximun
        String maximunNumberOfPage = request.getParameter("maximunNumberOfPage");

        //  action
        String action = request.getParameter("action");

        //--------------------------------------------------------------------------

        //  Kiểm tra thử select search and sort có dữ liệu hay chưa
        if (selectSearchAndSort == null) {

            //  Nếu chưa thì đây là lần đầu tiên tới trang này
            //  Trước tiên lấy list hãng sản xuất đầu tiên
            List<Manufacturer> manufacturers = ManufacturerModel.getInstance().getListManufacturerFirst(BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_HSX);

            //  Số trang hiện tại chắc chắn là 1
            int nowPage = 1;

            //  Số hãng sản xuất tốt đa
            int maximunManufacturer = ManufacturerModel.getInstance().getMaximunManufacturer();

            //  Số trang tối đa
            int maximunPage = ManufacturerModel.getInstance().getMaximunNumberOfPage(maximunManufacturer);

            //  Lấy list nextPage
            List<NextPageObject> nextPages = NextPageModel.getInstance().getListNextPageObjectAdmin(nowPage, maximunPage);

            //  Set các attribute cho request
            request.setAttribute("manufacturers", manufacturers);
            request.setAttribute("nowPage", nowPage);
            request.setAttribute("maximumManufacturer", maximunManufacturer);
            request.setAttribute("maximunPage", maximunPage);
            request.setAttribute("numberOfShow", manufacturers.size());
            request.setAttribute("nextPages",nextPages);
            request.setAttribute("sort","DESC");

            // forward tới trang của mình thôi nào
            request.getRequestDispatcher("admin/home/quanLyHangSanXuat.jsp").forward(request, response);

        } else {

            switch (action){
                case "sort":
                    break;
                case "changeFilter":
                    break;
                case "nextPage":
                    break;
            }

            response.getWriter().println(action);

        }

    }
}
