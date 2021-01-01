package controllerAdmin.discountCode;

import beans.BeansConfiguration;
import beans.discountCode.DiscountCode;
import beans.discountCode.DiscountCodeObject;
import beans.manufacturer.Manufacturer;
import beans.manufacturer.ManufacturerObject;
import beans.nextPage.NextPageObject;
import model.discountCode.DiscountCodeModel;
import model.manufacturer.ManufacturerModel;
import model.nextPage.NextPageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DiscountCodeController", urlPatterns = "/DiscountCodeController")
public class DiscountCodeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ////////////////////////********* QUAN TRỌNG **********//////////////////////////////////

        //  Khi tới controller này, mã giảm giá có ngày hết hạn, nên ta phải cập nhập lại cột trạng thái sử dụng nếu
        //  có mã giảm giá hết hạn sử dụng
        DiscountCodeModel.getInstance().update();

        /////////////////////////////////////////////////////////////////////////////////////////


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

        //  Kiểm tra thử select search and sort có dữ liệu hay chưa
        if (selectSearchAndSort == null) {

            //  Nếu chưa thì đây là lần đầu tiên tới trang này
            //  Trước tiên lấy list mã giảm giá đầu tiên
            List<DiscountCode> discountCodes = DiscountCodeModel.getInstance().getListDiscountCodeFirst(BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_MGG);

            //  Số trang hiện tại chắc chắn là 1
            int nowPage = 1;

            //  Số mã giảm giá tốt đa
            int maximunDiscountCode = DiscountCodeModel.getInstance().getMaximunDiscountCode();

            //  Số trang tối đa
            int maximunPage = DiscountCodeModel.getInstance().getMaximunNumberOfPage(maximunDiscountCode);

            //  Lấy list nextPage
            List<NextPageObject> nextPages = NextPageModel.getInstance().getListNextPageObjectAdmin(nowPage, maximunPage);

            //  Khi mới chuyển tới trang này thì tạo 1 DiscountCodeObject gán cho sesstion
            DiscountCodeObject discountCodeObject = new DiscountCodeObject();
            discountCodeObject.setDiscountCodes(discountCodes);
            discountCodeObject.setNowPage(nowPage);
            discountCodeObject.setMaximumDiscountCode(maximunDiscountCode);
            discountCodeObject.setMaximumPage(maximunPage);
            discountCodeObject.setNumberOfShow(discountCodes.size());
            discountCodeObject.setNextPages(nextPages);
            discountCodeObject.setSort("DESC");
            discountCodeObject.setSearch("");
            discountCodeObject.setSelectSearchAndSort("dateCreated");
            request.getSession().setAttribute("discountCodeObject", discountCodeObject);

            // sedirect tới trang của mình thôi nào
            response.sendRedirect("admin/home/quanLyMaGiamGia.jsp");

        } else {
        }

    }
}
