package controllerAdmin.informationAccountAdmin;

import beans.BeansConfiguration;
import beans.loginAdmin.UserAdmin;
import model.account.AccountModel;
import model.personalNotice.PersonalNoticeModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InformationAccountAdminRemoveAvatarController", urlPatterns = "/InformationAccountAdminRemoveAvatarController")
public class InformationAccountAdminRemoveAvatarController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //  Cập nhập lại ảnh link ảnh dại diện trong user admin
        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        userAdmin.getAccount().setAvatarLink(BeansConfiguration.LINK_AVATAR_DEFAULT);

        //  Ta không quan tâm tới thằng hinh đại diện vì khi thay đổi hình đại diện ta ghi đè lên nó luôn mà
        //  Tiếp theo cập nhật lại trong csdl
        AccountModel.getInstance().updateAvatarLinkById(userAdmin.getAccount().getId(), userAdmin.getAccount().getAvatarLink());

        //  Tạo thông báo cá nhân
        PersonalNoticeModel.getInstance().addNewPersonalNoticeToDatabase(userAdmin.getAccount().getId(), "Bạn", "vừa xóa", "hình đại diện" ,"của mình", "");

        request.setAttribute("forward","removeAvatar");
        request.getRequestDispatcher("InformationAccountAdminController").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
