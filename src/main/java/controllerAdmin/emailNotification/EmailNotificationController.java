package controllerAdmin.emailNotification;

import beans.BeansConfiguration;
import beans.discountCode.DiscountCode;
import beans.discountCode.DiscountCodeObject;
import beans.emailNotification.EmailNotification;
import beans.emailNotification.EmailNotificationObject;
import beans.loginAdmin.UserAdmin;
import beans.nextPage.NextPageObject;
import model.discountCode.DiscountCodeModel;
import model.emailNotification.EmailNotificationModel;
import model.nextPage.NextPageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmailNotificationController", urlPatterns = "/EmailNotificationController")
public class EmailNotificationController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        if (userAdmin == null) {
            request.getSession().setAttribute("trackPage", "admin.guiEmailThongBao");
            response.sendRedirect("admin/home/login.jsp");
        } else {
            //  Kiểm tra foward, xem trang khác có foward tới này không
            String foward = (String) request.getAttribute("forward");

            //  Nếu khác null thì xem thử nó là từ trang nào
            if (foward != null) {
                //  Lấy đối tượng ra
                EmailNotificationObject emailNotificationObject = (EmailNotificationObject) userAdmin.getListOfFunction().get("emailNotificationObject");

                List<EmailNotification> emailNotificationList = EmailNotificationModel.getInstance().getListEmailNotificationFromAll(emailNotificationObject.getSelectSearchAndSort(), emailNotificationObject.getSort(), emailNotificationObject.getSearch(), BeansConfiguration.LINE_OF_ON_PAGE_GUI_EMAIL_THONG_BAO, emailNotificationObject.getNowPage());
                emailNotificationObject.setEmailNotificationLists(emailNotificationList);

                //  Nếu là từ trang xóa thì làm như thế này
                if (foward.equals("remove")) {

                    //  Kiểm tra nếu như discountCodes.size == 0 thì có nghĩa trang này hết dữ liệu rồi, cập nhập lại nowPage -1
                    if (emailNotificationList.size() == 0) {
                        if (emailNotificationObject.getNowPage() > 1) {
                            emailNotificationObject.setNowPage(emailNotificationObject.getNowPage() - 1);
                            emailNotificationList = EmailNotificationModel.getInstance().getListEmailNotificationFromAll(emailNotificationObject.getSelectSearchAndSort(), emailNotificationObject.getSort(), emailNotificationObject.getSearch(), BeansConfiguration.LINE_OF_ON_PAGE_GUI_EMAIL_THONG_BAO, emailNotificationObject.getNowPage());
                            emailNotificationObject.setEmailNotificationLists(emailNotificationList);
                        }
                    }

                    //  Cập nhập lại số lượng hiển thị
                    emailNotificationObject.setNumberOfShow(emailNotificationList.size());

                    //  Cập nhập lại số sản phẩm tối đa
                    int maximumEmailNotification = EmailNotificationModel.getInstance().getMaximumNotificationFromAll(emailNotificationObject.getSelectSearchAndSort(), emailNotificationObject.getSearch());
                    emailNotificationObject.setMaximumEmailNotification(maximumEmailNotification);

                    //  Cập nhập lại số trang tối đa
                    int maximumPage = EmailNotificationModel.getInstance().getMaximunNumberOfPage(maximumEmailNotification);
                    emailNotificationObject.setMaximumPage(maximumPage);

                    //  Cập nhập lại list Next page
                    List<NextPageObject> nextPages = NextPageModel.getInstance().getListNextPageObjectAdmin(emailNotificationObject.getNowPage(), emailNotificationObject.getMaximumPage());
                    emailNotificationObject.setNextPages(nextPages);

                    //  Cập nhập lại là bị xóa
                    emailNotificationObject.setNotify(true);
                    emailNotificationObject.setTitle((String) request.getAttribute("more"));
                    emailNotificationObject.setConntent((String) request.getAttribute("more2"));

                    //  Nếu là từ trang thêm thì làm như thế này
                } else if (foward.equals("add")) {

                    //  Cập nhập lại số lượng hiển thị
                    emailNotificationObject.setNumberOfShow(emailNotificationList.size());

                    //  Cập nhập lại số sản phẩm tối đa
                    int maximumEmailNotification = EmailNotificationModel.getInstance().getMaximumNotificationFromAll(emailNotificationObject.getSelectSearchAndSort(), emailNotificationObject.getSearch());
                    emailNotificationObject.setMaximumEmailNotification(maximumEmailNotification);

                    //  Cập nhập lại số trang tối đa
                    int maximumPage = EmailNotificationModel.getInstance().getMaximunNumberOfPage(maximumEmailNotification);
                    emailNotificationObject.setMaximumPage(maximumPage);

                    //  Cập nhập lại list Next page
                    List<NextPageObject> nextPages = NextPageModel.getInstance().getListNextPageObjectAdmin(emailNotificationObject.getNowPage(), emailNotificationObject.getMaximumPage());
                    emailNotificationObject.setNextPages(nextPages);

                    //  Cập nhập lại next Id
                    emailNotificationObject.setNextId(EmailNotificationModel.getInstance().getNextIdEmailNotification());

                    //  Cập nhập lại là hãy thông báo
                    emailNotificationObject.setNotify(true);
                    emailNotificationObject.setTitle((String) request.getAttribute("more"));
                    emailNotificationObject.setConntent((String) request.getAttribute("more2"));

                }

                //  Gán lại cho sesstion
                emailNotificationObject.setReady(true);
                userAdmin.getListOfFunction().put("emailNotificationObject", emailNotificationObject);
                userAdmin.updateReady("emailNotificationObject");
                request.getSession().setAttribute("userAdmin", userAdmin);


                // sedirect tới trang của mình thôi nào
                response.sendRedirect("admin/home/guiEmailThongBao.jsp");
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
                    //  Trước tiên lấy email thông báo đầu tiên
                    List<EmailNotification> emailNotifications = EmailNotificationModel.getInstance().getListEmailNotifictaionsFirst(BeansConfiguration.LINE_OF_ON_PAGE_GUI_EMAIL_THONG_BAO);

                    //  Số trang hiện tại chắc chắn là 1
                    int nowPage = 1;

                    //  Số hãng sản xuất tốt đa
                    int maximumEmailNotification = EmailNotificationModel.getInstance().getMaximumEmailNotification();

                    //  Số trang tối đa
                    int maximunPage = EmailNotificationModel.getInstance().getMaximunNumberOfPage(maximumEmailNotification);

                    //  Lấy list nextPage
                    List<NextPageObject> nextPages = NextPageModel.getInstance().getListNextPageObjectAdmin(nowPage, maximunPage);

                    //  Khi mới chuyển tới trang này thì tạo 1 EmailNotifictaioNobject
                    EmailNotificationObject emailNotificationObject = new EmailNotificationObject();
                    emailNotificationObject.setEmailNotificationLists(emailNotifications);
                    emailNotificationObject.setNowPage(nowPage);
                    emailNotificationObject.setMaximumEmailNotification(maximumEmailNotification);
                    emailNotificationObject.setMaximumPage(maximunPage);
                    emailNotificationObject.setNumberOfShow(emailNotifications.size());
                    emailNotificationObject.setNextPages(nextPages);
                    emailNotificationObject.setSort("DESC");
                    emailNotificationObject.setSearch("");
                    emailNotificationObject.setSelectSearchAndSort("dateCreated");
                    emailNotificationObject.setNextId(EmailNotificationModel.getInstance().getNextIdEmailNotification());

                    emailNotificationObject.setReady(true);
                    userAdmin.getListOfFunction().put("emailNotificationObject", emailNotificationObject);
                    userAdmin.updateReady("emailNotificationObject");
                    request.getSession().setAttribute("userAdmin", userAdmin);

                    // sedirect tới trang của mình thôi nào
                    response.sendRedirect("admin/home/guiEmailThongBao.jsp");

                } else {
                    //  Action load là một thứ gì đó khác hoàn toàn nên ta phải làm như trường hợp xóa
                    if (action.equals("load")) {

                        //  Lấy đối tượng ra
                        EmailNotificationObject emailNotificationObject = (EmailNotificationObject) userAdmin.getListOfFunction().get("emailNotificationObject");

                        //  Lấy lại list emailNotification đổ dữ liệu
                        List<EmailNotification> emailNotificationList = EmailNotificationModel.getInstance().getListEmailNotificationFromAll(emailNotificationObject.getSelectSearchAndSort(), emailNotificationObject.getSort(), emailNotificationObject.getSearch(), BeansConfiguration.LINE_OF_ON_PAGE_GUI_EMAIL_THONG_BAO, emailNotificationObject.getNowPage());

                        //  Cập nhập lại list emailNotification
                        emailNotificationObject.setEmailNotificationLists(emailNotificationList);

                        //  Kiểm tra nếu nhưemailNotificationList.size == 0 thì có nghĩa trang này hết dữ liệu rồi, cập nhập lại nowPage -1
                        if (emailNotificationList.size() == 0) {
                            if (emailNotificationObject.getNowPage() > 0) {
                                emailNotificationObject.setNowPage(emailNotificationObject.getNowPage() - 1);
                                emailNotificationList = EmailNotificationModel.getInstance().getListEmailNotificationFromAll(emailNotificationObject.getSelectSearchAndSort(), emailNotificationObject.getSort(), emailNotificationObject.getSearch(), BeansConfiguration.LINE_OF_ON_PAGE_GUI_EMAIL_THONG_BAO, emailNotificationObject.getNowPage());
                                emailNotificationObject.setEmailNotificationLists(emailNotificationList);
                            }
                        }

                        //  Cập nhập lại số lượng hiển thị
                        emailNotificationObject.setNumberOfShow(emailNotificationList.size());

                        //  Cập nhập lại số sản phẩm tối đa
                        int maximumEmailNotification = EmailNotificationModel.getInstance().getMaximumNotificationFromAll(emailNotificationObject.getSelectSearchAndSort(), emailNotificationObject.getSearch());
                        emailNotificationObject.setMaximumEmailNotification(maximumEmailNotification);

                        //  Cập nhập lại số trang tối đa
                        int maximumPage = EmailNotificationModel.getInstance().getMaximunNumberOfPage(maximumEmailNotification);
                        emailNotificationObject.setMaximumPage(maximumPage);

                        //  Cập nhập lại list Next page
                        List<NextPageObject> nextPages = NextPageModel.getInstance().getListNextPageObjectAdmin(emailNotificationObject.getNowPage(), emailNotificationObject.getMaximumPage());
                        emailNotificationObject.setNextPages(nextPages);

                        //  Cập nhập lại nextId
                        emailNotificationObject.setNextId(EmailNotificationModel.getInstance().getNextIdEmailNotification());

                        //  Gán lại cho sesstion
                        emailNotificationObject.setReady(true);
                        userAdmin.getListOfFunction().put("emailNotificationObject", emailNotificationObject);
                        userAdmin.updateReady("emailNotificationObject");
                        request.getSession().setAttribute("userAdmin", userAdmin);

                        // sedirect tới trang của mình thôi nào
                        response.sendRedirect("admin/home/guiEmailThongBao.jsp");

                    } else {

                        //  Lấy đối tượng ra
                        EmailNotificationObject emailNotificationObject = (EmailNotificationObject) userAdmin.getListOfFunction().get("emailNotificationObject");

                        switch (action) {

                            case "sort":

                                //  Lấy lại cách sắp xếp
                                if (sort != null) {
                                    emailNotificationObject.setSort("DESC");
                                } else {
                                    emailNotificationObject.setSort("ASC");
                                }

                                break;

                            case "changeFilter":

                                //  Lấy lại bộ lọc
                                emailNotificationObject.setSelectSearchAndSort(selectSearchAndSort);

                                //  Cập nhập lại maximun hãng sản xuất
                                int maximumEmailNotification = EmailNotificationModel.getInstance().getMaximumNotificationFromAll(emailNotificationObject.getSelectSearchAndSort(), emailNotificationObject.getSearch());
                                emailNotificationObject.setMaximumEmailNotification(maximumEmailNotification);

                                //  Cập nhập lại số trang tối đa
                                int maximumPagee = EmailNotificationModel.getInstance().getMaximunNumberOfPage(maximumEmailNotification);
                                emailNotificationObject.setMaximumPage(maximumPagee);

                                //  Cập nhập lại list nextPage
                                List<NextPageObject> nextPagesss = NextPageModel.getInstance().getListNextPageObjectAdmin(1, maximumPagee);
                                emailNotificationObject.setNextPages(nextPagesss);

                                //  Cập nhập lại nowPage là 1
                                emailNotificationObject.setNowPage(1);

                                break;

                            case "nextPage":

                                //  Lấy lại nowPage
                                emailNotificationObject.setNowPage(Integer.parseInt(numberOfPage));

                                //  Cập nhập lại list nextPage
                                List<NextPageObject> nextPages = NextPageModel.getInstance().getListNextPageObjectAdmin(emailNotificationObject.getNowPage(), emailNotificationObject.getMaximumPage());
                                emailNotificationObject.setNextPages(nextPages);
                                break;

                            case "search":

                                //  Cập nhập now page là 1
                                emailNotificationObject.setNowPage(1);

                                //  Lấy lại search
                                emailNotificationObject.setSearch(search);

                                //  Cập nhập lại maximun hãng sản xuất
                                maximumEmailNotification = EmailNotificationModel.getInstance().getMaximumNotificationFromAll(emailNotificationObject.getSelectSearchAndSort(), emailNotificationObject.getSearch());
                                emailNotificationObject.setMaximumEmailNotification(maximumEmailNotification);

                                //  Cập nhập lại số trang tối đa
                                int maximumPage = EmailNotificationModel.getInstance().getMaximunNumberOfPage(maximumEmailNotification);
                                emailNotificationObject.setMaximumPage(maximumPage);

                                //  Cập nhập lại list nextPage
                                List<NextPageObject> nextPagess = NextPageModel.getInstance().getListNextPageObjectAdmin(1, maximumPage);
                                emailNotificationObject.setNextPages(nextPagess);

                                break;

                        }

                        //  Lấy lại hãng sản xuất
                        List<EmailNotification> emailNotificationList = EmailNotificationModel.getInstance().getListEmailNotificationFromAll(emailNotificationObject.getSelectSearchAndSort(), emailNotificationObject.getSort(), emailNotificationObject.getSearch(), BeansConfiguration.LINE_OF_ON_PAGE_GUI_EMAIL_THONG_BAO, emailNotificationObject.getNowPage());
                        emailNotificationObject.setEmailNotificationLists(emailNotificationList);

                        //  Cập nhập lại số sản phẩm hiện thị
                        emailNotificationObject.setNumberOfShow(emailNotificationList.size());

                        //  Cập nhập lại nextId
                        emailNotificationObject.setNextId(EmailNotificationModel.getInstance().getNextIdEmailNotification());

                        //  Gán lại cho sesstion
                        emailNotificationObject.setReady(true);
                        userAdmin.getListOfFunction().put("emailNotificationObject", emailNotificationObject);
                        userAdmin.updateReady("emailNotificationObject");
                        request.getSession().setAttribute("userAdmin", userAdmin);

                        // sedirect tới trang của mình thôi nào
                        response.sendRedirect("admin/home/guiEmailThongBao.jsp");
                    }
                }
            }
        }
    }
}
