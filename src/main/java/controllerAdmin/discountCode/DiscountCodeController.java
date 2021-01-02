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

        //  Kiểm tra foward, xem trang khác có foward tới này không
        String foward = (String) request.getAttribute("forward");

        //  Nếu khác null thì xem thử nó là từ trang nào
        if (foward != null) {

            //  Lấy đối tượng ra
            DiscountCodeObject discountCodeObject = (DiscountCodeObject) request.getSession().getAttribute("discountCodeObject");

            //  Lấy lại list mã giảm giá để đổ dữ liệu
            List<DiscountCode> discountCodes = DiscountCodeModel.getInstance().getListDiscountCodeFromAll(discountCodeObject.getSelectSearchAndSort(), discountCodeObject.getSort(), discountCodeObject.getSearch(), BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_MGG, discountCodeObject.getNowPage());

            //  Cập nhập lại list mã giảm giá
            discountCodeObject.setDiscountCodes(discountCodes);

            //  Nếu là từ trang xóa thì làm như thế này
            if (foward.equals("remove")) {


                //  Nếu là từ trang thêm thì làm như thế này
            } else if (foward.equals("add")) {

                //  Cập nhập lại số lượng hiển thị
                discountCodeObject.setNumberOfShow(discountCodes.size());

                //  Cập nhập lại số mã giảm giá tốit đa
                int maximumDiscountCode = DiscountCodeModel.getInstance().getMaximunDiscountCodeFromAll(discountCodeObject.getSelectSearchAndSort(), discountCodeObject.getSearch());
                discountCodeObject.setMaximumDiscountCode(maximumDiscountCode);

                //  Cập nhập lại số trang tối đa
                int maximumPage = DiscountCodeModel.getInstance().getMaximunNumberOfPage(maximumDiscountCode);
                discountCodeObject.setMaximumPage(maximumPage);

                //  Cập nhập lại list Next page
                List<NextPageObject> nextPages = NextPageModel.getInstance().getListNextPageObjectAdmin(discountCodeObject.getNowPage(), discountCodeObject.getMaximumPage());
                discountCodeObject.setNextPages(nextPages);

                //  Cập nhập lại là hãy thông báo
                discountCodeObject.setNotify(true);
                discountCodeObject.setTitle((String) request.getAttribute("more"));
                discountCodeObject.setConntent((String) request.getAttribute("more2"));

            } else if (foward.equals("edit")) {

                //  Cập nhập lại là edit

            }

            //  Gán lại cho sesstion
            request.getSession().setAttribute("discountCodeObject", discountCodeObject);

            // sedirect tới trang của mình thôi nào
            response.sendRedirect("admin/home/quanLyMaGiamGia.jsp");

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

                //  Action load là một thứ gì đó khác hoàn toàn nên ta phải làm như trường hợp xóa
                if (action.equals("load")) {

                    //  Lấy đối tượng ra
                    DiscountCodeObject discountCodeObject = (DiscountCodeObject) request.getSession().getAttribute("discountCodeObject");

                    //  Lấy lại list hãng sản xuất đổ dữ liệu
                    List<DiscountCode> discountCodes = DiscountCodeModel.getInstance().getListDiscountCodeFromAll(discountCodeObject.getSelectSearchAndSort(), discountCodeObject.getSort(), discountCodeObject.getSearch(), BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_MGG, discountCodeObject.getNowPage());

                    //  Cập nhập lại list mã giảm giá
                    discountCodeObject.setDiscountCodes(discountCodes);

                    //  Kiểm tra nếu như discountCodes.size == 0 thì có nghĩa trang này hết dữ liệu rồi, cập nhập lại nowPage -1
                    if (discountCodes.size() == 0) {
                        if (discountCodeObject.getNowPage() > 0) {
                            discountCodeObject.setNowPage(discountCodeObject.getNowPage() - 1);
                            discountCodes = DiscountCodeModel.getInstance().getListDiscountCodeFromAll(discountCodeObject.getSelectSearchAndSort(), discountCodeObject.getSort(), discountCodeObject.getSearch(), BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_MGG, discountCodeObject.getNowPage());
                            discountCodeObject.setDiscountCodes(discountCodes);
                        }
                    }

                    //  Cập nhập lại số lượng hiển thị
                    discountCodeObject.setNumberOfShow(discountCodes.size());

                    //  Cập nhập lại số sản phẩm tối đa
                    int maximumDiscountCode = DiscountCodeModel.getInstance().getMaximunDiscountCodeFromAll(discountCodeObject.getSelectSearchAndSort(), discountCodeObject.getSearch());
                    discountCodeObject.setMaximumDiscountCode(maximumDiscountCode);

                    //  Cập nhập lại số trang tối đa
                    int maximumPage = DiscountCodeModel.getInstance().getMaximunNumberOfPage(maximumDiscountCode);
                    discountCodeObject.setMaximumPage(maximumPage);

                    //  Cập nhập lại list Next page
                    List<NextPageObject> nextPages = NextPageModel.getInstance().getListNextPageObjectAdmin(discountCodeObject.getNowPage(), discountCodeObject.getMaximumPage());
                    discountCodeObject.setNextPages(nextPages);

                    //  Gán lại cho sesstion
                    request.getSession().setAttribute("discountCodeObject", discountCodeObject);

                    // sedirect tới trang của mình thôi nào
                    response.sendRedirect("admin/home/quanLyMaGiamGia.jsp");

                } else {

                    //  Lấy đối tượng ra
                    DiscountCodeObject discountCodeObject = (DiscountCodeObject) request.getSession().getAttribute("discountCodeObject");

                    switch (action) {

                        case "sort":

                            //  Lấy lại cách sắp xếp
                            if (sort != null) {
                                discountCodeObject.setSort("DESC");
                            } else {
                                discountCodeObject.setSort("ASC");
                            }

                            break;

                        case "changeFilter":

                            //  Lấy lại bộ lọc
                            discountCodeObject.setSelectSearchAndSort(selectSearchAndSort);

                            //  Cập nhập lại maximun mã giảm giá
                            int maximunDiscountCode = DiscountCodeModel.getInstance().getMaximunDiscountCodeFromAll(discountCodeObject.getSelectSearchAndSort(), discountCodeObject.getSearch());
                            discountCodeObject.setMaximumDiscountCode(maximunDiscountCode);

                            //  Cập nhập lại số trang tối đa
                            int maximumPagee = DiscountCodeModel.getInstance().getMaximunNumberOfPage(maximunDiscountCode);
                            discountCodeObject.setMaximumPage(maximumPagee);

                            //  Cập nhập lại list nextPage
                            List<NextPageObject> nextPagesss = NextPageModel.getInstance().getListNextPageObjectAdmin(1, maximumPagee);
                            discountCodeObject.setNextPages(nextPagesss);

                            //  Cập nhập lại nowPage là 1
                            discountCodeObject.setNowPage(1);

                            break;

                        case "nextPage":

                            //  Lấy lại nowPage
                            discountCodeObject.setNowPage(Integer.parseInt(numberOfPage));

                            //  Cập nhập lại list nextPage
                            List<NextPageObject> nextPages = NextPageModel.getInstance().getListNextPageObjectAdmin(discountCodeObject.getNowPage(), discountCodeObject.getMaximumPage());
                            discountCodeObject.setNextPages(nextPages);

                            break;

                        case "search":

                            //  Cập nhập now page là 1
                            discountCodeObject.setNowPage(1);

                            //  Lấy lại search
                            discountCodeObject.setSearch(search);

                            //  Cập nhập lại maximun mã giảm giá
                            int maximunDiscountcode = DiscountCodeModel.getInstance().getMaximunDiscountCodeFromAll(discountCodeObject.getSelectSearchAndSort(), discountCodeObject.getSearch());
                            discountCodeObject.setMaximumDiscountCode(maximunDiscountcode);

                            //  Cập nhập lại số trang tối đa
                            int maximumPage = DiscountCodeModel.getInstance().getMaximunNumberOfPage(maximunDiscountcode);
                            discountCodeObject.setMaximumPage(maximumPage);

                            //  Cập nhập lại list nextPage
                            List<NextPageObject> nextPagess = NextPageModel.getInstance().getListNextPageObjectAdmin(1, maximumPage);
                            discountCodeObject.setNextPages(nextPagess);

                            break;

                    }

                    //  Lấy lại hãng sản xuất
                    List<DiscountCode> discountCodes = DiscountCodeModel.getInstance().getListDiscountCodeFromAll(discountCodeObject.getSelectSearchAndSort(), discountCodeObject.getSort(), discountCodeObject.getSearch(), BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_MGG, discountCodeObject.getNowPage());
                    discountCodeObject.setDiscountCodes(discountCodes);

                    //  Cập nhập lại số sản phẩm hiện thị
                    discountCodeObject.setNumberOfShow(discountCodes.size());

                    //  Gán lại cho sesstion
                    request.getSession().setAttribute("manufacturerObject", discountCodeObject);

                    // sedirect tới trang của mình thôi nào
                    response.sendRedirect("admin/home/quanLyMaGiamGia.jsp");

                }

            }

        }

    }

}
