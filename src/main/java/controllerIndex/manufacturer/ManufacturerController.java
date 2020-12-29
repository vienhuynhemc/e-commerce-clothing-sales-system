package controllerIndex.manufacturer;

import beans.BeansConfiguration;
import beans.manufacturer.Manufacturer;
import beans.manufacturer.ManufacturerObject;
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

        //  Kiểm tra foward, xem trang khác có foward tới này không
        String foward = (String) request.getAttribute("forward");

        //  Nếu khác null thì xem thử nó là từ trang nào
        if (foward!= null) {

            //  Lấy đối tượng ra
            ManufacturerObject manufacturerObject = (ManufacturerObject) request.getSession().getAttribute("manufacturerObject");

            //  Lấy lại list hãng sản xuất đổ dữ liệu
            List<Manufacturer> manufacturers = ManufacturerModel.getInstance().getListManufacturerFromAll(manufacturerObject.getSelectSearchAndSort(), manufacturerObject.getSort(), manufacturerObject.getSearch(), BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_HSX, manufacturerObject.getNowPage());

            //  Cập nhập lại list hãng sản xuất
            manufacturerObject.setManufacturers(manufacturers);

            //  Nếu là từ trang xóa thì làm như thế này
            if (foward.equals("remove")) {

                //  Kiểm tra nếu như manufacturers.size == 0 thì có nghĩa trang này hết dữ liệu rồi, cập nhập lại nowPage -1
                if (manufacturers.size() == 0) {
                    if (manufacturerObject.getNowPage() > 0) {
                        manufacturerObject.setNowPage(manufacturerObject.getNowPage() - 1);
                        manufacturers = ManufacturerModel.getInstance().getListManufacturerFromAll(manufacturerObject.getSelectSearchAndSort(), manufacturerObject.getSort(), manufacturerObject.getSearch(), BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_HSX, manufacturerObject.getNowPage());
                        manufacturerObject.setManufacturers(manufacturers);
                    }
                }

                //  Cập nhập lại số lượng hiển thị
                manufacturerObject.setNumberOfShow(manufacturers.size());

                //  Cập nhập lại số sản phẩm tối đa
                int maximumMaufacturer = ManufacturerModel.getInstance().getMaximunManufacturerFromAll(manufacturerObject.getSelectSearchAndSort(), manufacturerObject.getSearch());
                manufacturerObject.setMaximumManufacturer(maximumMaufacturer);

                //  Cập nhập lại số trang tối đa
                int maximumPage = ManufacturerModel.getInstance().getMaximunNumberOfPage(maximumMaufacturer);
                manufacturerObject.setMaximumPage(maximumPage);

                //  Cập nhập lại list Next page
                List<NextPageObject> nextPages = NextPageModel.getInstance().getListNextPageObjectAdmin(manufacturerObject.getNowPage(), manufacturerObject.getMaximumPage());
                manufacturerObject.setNextPages(nextPages);

                //  Cập nhập lại là bị xóa
                manufacturerObject.setNotify(true);
                manufacturerObject.setTitle("Bạn đã xóa thành công "+request.getAttribute("more"));
                manufacturerObject.setConntent("Việc xóa đã thay đổi dữ liệu của bạn");

                //  Nếu là từ trang thêm thì làm như thế này
            } else if (foward.equals("add")) {

                //  Cập nhập lại số lượng hiển thị
                manufacturerObject.setNumberOfShow(manufacturers.size());

                //  Cập nhập lại số sản phẩm tối đa
                int maximumMaufacturer = ManufacturerModel.getInstance().getMaximunManufacturerFromAll(manufacturerObject.getSelectSearchAndSort(), manufacturerObject.getSearch());
                manufacturerObject.setMaximumManufacturer(maximumMaufacturer);

                //  Cập nhập lại số trang tối đa
                int maximumPage = ManufacturerModel.getInstance().getMaximunNumberOfPage(maximumMaufacturer);
                manufacturerObject.setMaximumPage(maximumPage);

                //  Cập nhập lại list Next page
                List<NextPageObject> nextPages = NextPageModel.getInstance().getListNextPageObjectAdmin(manufacturerObject.getNowPage(), manufacturerObject.getMaximumPage());
                manufacturerObject.setNextPages(nextPages);

                //  Cập nhập lại là thêm mới
                manufacturerObject.setNotify(true);
                manufacturerObject.setTitle("Bạn đã thêm thành công "+request.getAttribute("more"));
                manufacturerObject.setConntent("Việc thêm đã thay đổi dữ liệu của bạn");

            }

            //  Gán lại cho sesstion
            request.getSession().setAttribute("manufacturerObject", manufacturerObject);

            // sedirect tới trang của mình thôi nào
            response.sendRedirect("admin/home/quanLyHangSanXuat.jsp");

        } else {

            //  Không thì chạy bình thường như chưa từng xảy ra

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

                //  Khi mới chuyển tới trang này thì tạo 1 ManufacturerObject gán cho sesstion
                ManufacturerObject manufacturerObject = new ManufacturerObject();
                manufacturerObject.setManufacturers(manufacturers);
                manufacturerObject.setNowPage(nowPage);
                manufacturerObject.setMaximumManufacturer(maximunManufacturer);
                manufacturerObject.setMaximumPage(maximunPage);
                manufacturerObject.setNumberOfShow(manufacturers.size());
                manufacturerObject.setNextPages(nextPages);
                manufacturerObject.setSort("DESC");
                manufacturerObject.setSearch("");
                manufacturerObject.setSelectSearchAndSort("dateCreated");
                request.getSession().setAttribute("manufacturerObject", manufacturerObject);

                // sedirect tới trang của mình thôi nào
                response.sendRedirect("admin/home/quanLyHangSanXuat.jsp");

            } else {

                //  Lấy đối tượng ra
                ManufacturerObject manufacturerObject = (ManufacturerObject) request.getSession().getAttribute("manufacturerObject");

                switch (action) {

                    case "sort":

                        //  Lấy lại cách sắp xếp
                        if (sort != null) {
                            manufacturerObject.setSort("DESC");
                        } else {
                            manufacturerObject.setSort("ASC");
                        }

                        break;

                    case "changeFilter":

                        //  Lấy lại bộ lọc
                        manufacturerObject.setSelectSearchAndSort(selectSearchAndSort);

                        //  Cập nhập lại maximun hãng sản xuất
                        int maximunManufacturee = ManufacturerModel.getInstance().getMaximunManufacturerFromAll(manufacturerObject.getSelectSearchAndSort(), manufacturerObject.getSearch());
                        manufacturerObject.setMaximumManufacturer(maximunManufacturee);

                        //  Cập nhập lại số trang tối đa
                        int maximumPagee = ManufacturerModel.getInstance().getMaximunNumberOfPage(maximunManufacturee);
                        manufacturerObject.setMaximumPage(maximumPagee);

                        //  Cập nhập lại list nextPage
                        List<NextPageObject> nextPagesss = NextPageModel.getInstance().getListNextPageObjectAdmin(1, maximumPagee);
                        manufacturerObject.setNextPages(nextPagesss);

                        //  Cập nhập lại nowPage là 1
                        manufacturerObject.setNowPage(1);

                        break;

                    case "nextPage":

                        //  Lấy lại nowPage
                        manufacturerObject.setNowPage(Integer.parseInt(numberOfPage));

                        //  Cập nhập lại list nextPage
                        List<NextPageObject> nextPages = NextPageModel.getInstance().getListNextPageObjectAdmin(manufacturerObject.getNowPage(), manufacturerObject.getMaximumPage());
                        manufacturerObject.setNextPages(nextPages);

                        break;

                    case "search":

                        //  Cập nhập now page là 1
                        manufacturerObject.setNowPage(1);

                        //  Lấy lại search
                        manufacturerObject.setSearch(search);

                        //  Cập nhập lại maximun hãng sản xuất
                        int maximunManufacture = ManufacturerModel.getInstance().getMaximunManufacturerFromAll(manufacturerObject.getSelectSearchAndSort(), manufacturerObject.getSearch());
                        manufacturerObject.setMaximumManufacturer(maximunManufacture);

                        //  Cập nhập lại số trang tối đa
                        int maximumPage = ManufacturerModel.getInstance().getMaximunNumberOfPage(maximunManufacture);
                        manufacturerObject.setMaximumPage(maximumPage);

                        //  Cập nhập lại list nextPage
                        List<NextPageObject> nextPagess = NextPageModel.getInstance().getListNextPageObjectAdmin(1, maximumPage);
                        manufacturerObject.setNextPages(nextPagess);

                        break;

                }

                //  Lấy lại hãng sản xuất
                List<Manufacturer> manufacturers = ManufacturerModel.getInstance().getListManufacturerFromAll(manufacturerObject.getSelectSearchAndSort(), manufacturerObject.getSort(), manufacturerObject.getSearch(), BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_HSX, manufacturerObject.getNowPage());
                manufacturerObject.setManufacturers(manufacturers);

                //  Cập nhập lại số sản phẩm hiện thị
                manufacturerObject.setNumberOfShow(manufacturers.size());

                //  Gán lại cho sesstion
                request.getSession().setAttribute("manufacturerObject", manufacturerObject);

                // sedirect tới trang của mình thôi nào
                response.sendRedirect("admin/home/quanLyHangSanXuat.jsp");

            }
        }
    }

}
