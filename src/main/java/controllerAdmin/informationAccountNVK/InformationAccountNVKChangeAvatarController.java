package controllerAdmin.informationAccountNVK;

import beans.BeansConfiguration;
import beans.address.Commune;
import beans.address.District;
import beans.informationAccountNVGH.InformationAccountNVGHObject;
import beans.informationAccountNVK.InformationAccountNVKObject;
import beans.loginAdmin.UserAdmin;
import model.account.AccountModel;
import model.commune.CommuneModel;
import model.district.DistrictModel;
import model.personalNotice.PersonalNoticeModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InformationAccountNVKChangeAvatarController", urlPatterns = "/InformationAccountNVKChangeAvatarController")
public class InformationAccountNVKChangeAvatarController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // set charset cho cả request và responne
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");

        if(action.equals("remove")){
            //  Cập nhập lại ảnh link ảnh dại diện trong user admin
            userAdmin.getAccount().setAvatarLink(BeansConfiguration.LINK_AVATAR_DEFAULT);

            //  Ta không quan tâm tới thằng hinh đại diện vì khi thay đổi hình đại diện ta ghi đè lên nó luôn mà
            //  Tiếp theo cập nhật lại trong csdl
            AccountModel.getInstance().updateAvatarLinkById(userAdmin.getAccount().getId(), userAdmin.getAccount().getAvatarLink());

            //  Tạo thông báo cá nhân
            PersonalNoticeModel.getInstance().addNewPersonalNoticeToDatabase(userAdmin.getAccount().getId(), "Bạn", "vừa xóa", "hình đại diện" ,"của mình", "");


        }else if(action.equals("change")){
            String data= request.getParameter("data");

            //  Cập nhập lại ảnh link ảnh dại diện trong user admin
            userAdmin.getAccount().setAvatarLink(data);

            //  Ta không quan tâm tới thằng hinh đại diện vì khi thay đổi hình đại diện ta ghi đè lên nó luôn mà
            //  Tiếp theo cập nhật lại trong csdl
            AccountModel.getInstance().updateAvatarLinkById(userAdmin.getAccount().getId(), userAdmin.getAccount().getAvatarLink());

            //  Tạo thông báo cá nhân
            PersonalNoticeModel.getInstance().addNewPersonalNoticeToDatabase(userAdmin.getAccount().getId(), "Bạn", "vừa thay đổi", "hình đại diện" ,"của mình", "");

        }

        //  Cập nhật lại sửa đổi nhập liệu của người dùng
        String fullName = request.getParameter("fullName");
        String displayName = request.getParameter("displayName");
        String phoneNumber = request.getParameter("phoneNumber");
        String provincial = request.getParameter("provincial");
        String district = request.getParameter("district");
        String commune = request.getParameter("commune");
        String password = request.getParameter("password");
        String checkPassword = request.getParameter("checkPassword");
        String introduct = request.getParameter("introduct");


        InformationAccountNVKObject informationAccountNVKObject = (InformationAccountNVKObject) userAdmin.getListOfFunction().get("informationAccountNVKObject");
        informationAccountNVKObject.setFullName(fullName);
        informationAccountNVKObject.setDisplayName(displayName);
        informationAccountNVKObject.setPhoneNumber(phoneNumber);
        informationAccountNVKObject.setPassword(password);
        informationAccountNVKObject.setCheckPassword(checkPassword);
        informationAccountNVKObject.setIntroduct(introduct);

        if(district.equals("none")){
            informationAccountNVKObject.setDistrict(null);
        }else{
            District districtObject = DistrictModel.getInstance().getDistrictById(district);
            informationAccountNVKObject.setDistrict(districtObject);
        }
        if(commune.equals("none")){
            informationAccountNVKObject.setCommune(null);
        }else{
            Commune communeObject = CommuneModel.getInstance().getCommuneById(commune);
            informationAccountNVKObject.setCommune(communeObject);
        }

        userAdmin.getListOfFunction().put("informationAccountNVKObject",informationAccountNVKObject);
        request.getSession().setAttribute("userAdmin", userAdmin);

        request.setAttribute("forward", "changeAvatar");
        request.getRequestDispatcher("InformationAccountNVKController").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
