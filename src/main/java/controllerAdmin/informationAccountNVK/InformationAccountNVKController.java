package controllerAdmin.informationAccountNVK;

import beans.address.Commune;
import beans.address.District;
import beans.address.Provincial;
import beans.informationAccountNVGH.InformationAccountNVGHObject;
import beans.informationAccountNVK.InformationAccountNVKObject;
import beans.loginAdmin.UserAdmin;
import model.account.AccountModel;
import model.address.AddressModel;
import model.commune.CommuneModel;
import model.district.DistrictModel;
import model.informationAccountNVGH.InformationAccountNVGHModel;
import model.informationAccountNVK.InformationAccountNVKModel;
import model.personalNotice.PersonalNoticeModel;
import model.provincial.ProvincialModel;
import model.staff.StaffModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "InformationAccountNVKController", urlPatterns = "/InformationAccountNVKController")
public class InformationAccountNVKController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        if (userAdmin == null) {
            request.getSession().setAttribute("trackPage", "admin.thongTinTaiKhoanNVK");
            response.sendRedirect("admin/home/login.jsp");
        } else {

            //  Kiểm tra foward, xem trang khác có foward tới này không
            String foward = (String) request.getAttribute("forward");

            //  Nếu khác null thì xem thử nó là từ trang nào
            if (foward != null) {

                //  Lấy đối tượng ra
                InformationAccountNVKObject informationAccountNVKObject = (InformationAccountNVKObject) userAdmin.getListOfFunction().get("informationAccountNVKObject");

                if (foward.equals("removeAvatar")) {
                    informationAccountNVKObject.setTitle("Bạn đã xóa hình đại diện thành công");
                    informationAccountNVKObject.setContent("Dữ liệu của bạn đã được thay đổi");
                } else if (foward.equals("changeAvatar")) {
                    informationAccountNVKObject.setTitle("Bạn đã thay đổi ảnh đại diện thành công");
                    informationAccountNVKObject.setContent("Dữ liệu của bạn đã được thay đổi");
                }

                //  Cập nhật là thông báo
                informationAccountNVKObject.setNotify(true);

                //  Cập nhật đang ở trang chỉnh sửa
                informationAccountNVKObject.setEdit(true);

                informationAccountNVKObject.setReady(true);
                userAdmin.getListOfFunction().put("informationAccountNVKObject", informationAccountNVKObject);
                userAdmin.updateReady("informationAccountNVKObject");
                request.getSession().setAttribute("userAdmin", userAdmin);

                // sedirect tới trang của mình thôi nào
                response.sendRedirect("admin/home/thongTinTaiKhoanNVK.jsp");


            } else {

                //  Trước tiên kiểm tra xem thử nó bắt đầu hay đã có và đang gọi một action
                InformationAccountNVKObject informationAccountNVKObject = (InformationAccountNVKObject) userAdmin.getListOfFunction().get("informationAccountNVKObject");

                if (informationAccountNVKObject == null || !informationAccountNVKObject.isReady()) {


                    // set charset cho cả request và responne
                    request.setCharacterEncoding("UTF-8");
                    response.setContentType("text/html; charset=UTF-8");
                    response.setCharacterEncoding("UTF-8");

                    informationAccountNVKObject = new InformationAccountNVKObject();
                    //  Cập nhật số đơn hàng admin này đã duyệt
                    int orderApproval = InformationAccountNVKModel.getInstance().getOrderApprovalByIdNVK(userAdmin.getAccount().getId());
                    informationAccountNVKObject.setOrderApproval(orderApproval);

                    //  Cập nhật list tỉnh thành để đổ dữ liệu ra
                    List<Provincial> provincials = ProvincialModel.getInstance().getListProvincial();
                    informationAccountNVKObject.setProvincials(provincials);

                    //  Cập nhật tỉnh huyện xã hiện tại là của ông userAdmin
                    informationAccountNVKObject.setProvincial(userAdmin.getAccount().getProvincial());
                    informationAccountNVKObject.setDistrict(userAdmin.getAccount().getDistrict());
                    informationAccountNVKObject.setCommune(userAdmin.getAccount().getCommune());

                    //  Cập nhật list huyện theo tỉnh của userAdmin
                    List<District> districts = DistrictModel.getInstance().getDistrictByProvincialId(userAdmin.getAccount().getProvincial().getProvincialId());
                    informationAccountNVKObject.setDistricts(districts);

                    //  Cập nhật list phường xã theo tỉnh hiện tại của userAdmin
                    List<Commune> communes = CommuneModel.getInstance().getCommuneByDistrictId(userAdmin.getAccount().getDistrict().getDistrictId());
                    informationAccountNVKObject.setCommunes(communes);

                    //  Cập nhật thông tin khasc
                    informationAccountNVKObject.setFullName(userAdmin.getAccount().getFullName());
                    informationAccountNVKObject.setDisplayName(userAdmin.getAccount().getDisplayName());
                    informationAccountNVKObject.setPhoneNumber(userAdmin.getAccount().getPhoneNumber());
                    informationAccountNVKObject.setPassword(userAdmin.getAccount().getPassword());
                    informationAccountNVKObject.setCheckPassword(userAdmin.getAccount().getPassword());
                    informationAccountNVKObject.setIntroduct(userAdmin.getAccount().getIntroduce());

                    informationAccountNVKObject.setReady(true);
                    userAdmin.getListOfFunction().put("informationAccountNVKObject", informationAccountNVKObject);
                    userAdmin.updateReady("informationAccountNVKObject");
                    request.getSession().setAttribute("userAdmin", userAdmin);

                    // sedirect tới trang của mình thôi nào
                    response.sendRedirect("admin/home/thongTinTaiKhoanNVK.jsp");

                } else {

                    // set charset cho cả request và responne
                    request.setCharacterEncoding("UTF-8");
                    response.setContentType("text/html; charset=UTF-8");
                    response.setCharacterEncoding("UTF-8");

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

                    informationAccountNVKObject.setFullName(fullName);
                    informationAccountNVKObject.setDisplayName(displayName);
                    informationAccountNVKObject.setPhoneNumber(phoneNumber);
                    informationAccountNVKObject.setPassword(password);
                    informationAccountNVKObject.setCheckPassword(checkPassword);
                    informationAccountNVKObject.setIntroduct(introduct);
                    if (district.equals("none")) {
                        informationAccountNVKObject.setDistrict(null);
                    } else {
                        District districtObject = DistrictModel.getInstance().getDistrictById(district);
                        informationAccountNVKObject.setDistrict(districtObject);
                    }
                    if (commune.equals("none")) {
                        informationAccountNVKObject.setCommune(null);
                    } else {
                        Commune communeObject = CommuneModel.getInstance().getCommuneById(commune);
                        informationAccountNVKObject.setCommune(communeObject);
                    }

                    String action = request.getParameter("action");
                    if (action.equals("goToEdit")) {
                        informationAccountNVKObject.setEdit(true);
                    } else if (action.equals("backEdit")) {
                        informationAccountNVKObject.setEdit(false);
                    } else if (action.equals("loadProvincial")) {

                        // Cap nhat lai tinh hien tai
                        String provincialId = request.getParameter("provincial");
                        informationAccountNVKObject.setProvincial(ProvincialModel.getInstance().getProvincialById(provincialId));

                        // Cật nhật lại list huyện
                        informationAccountNVKObject.setDistricts(DistrictModel.getInstance().getDistrictByProvincialId(provincialId));
                        informationAccountNVKObject.setDistrict(null);

                        // Cho list xã thành null
                        informationAccountNVKObject.setCommunes(null);
                        informationAccountNVKObject.setCommune(null);

                    } else if (action.equals("loadDistrict")) {

                        // Cập nhật lại huyện hiện tại
                        String districtId = request.getParameter("district");
                        informationAccountNVKObject.setDistrict(DistrictModel.getInstance().getDistrictById(districtId));

                        // Cập nhât lại list xa
                        informationAccountNVKObject.setCommunes(CommuneModel.getInstance().getCommuneByDistrictId(districtId));
                        informationAccountNVKObject.setCommune(null);

                    }else if(action.equals("save")){
                        int hinh_anh_trong_firebase = Integer.parseInt(request.getParameter("hinh_anh_trong_firebase"));

                        // Cập nhập lại cho userAdmin
                        userAdmin.getAccount().setNubmerOfImgInFirebase(hinh_anh_trong_firebase);
                        userAdmin.getAccount().setIntroduce(introduct);
                        userAdmin.getAccount().setPassword(password);
                        userAdmin.getAccount().setPhoneNumber(phoneNumber);
                        userAdmin.getAccount().setFullName(fullName);
                        userAdmin.getAccount().setDisplayName(displayName);
                        userAdmin.getAccount().setProvincial(informationAccountNVKObject.getProvincial());
                        userAdmin.getAccount().setDistrict(informationAccountNVKObject.getDistrict());
                        userAdmin.getAccount().setCommune(informationAccountNVKObject.getCommune());

                        // Update trong csdl luôn
                        StaffModel.getInstance().updateIntroductById(userAdmin.getAccount().getId(),userAdmin.getAccount().getIntroduce());
                        StaffModel.getInstance().updateNumberOfPictureInFirebaseById(userAdmin.getAccount().getId(),userAdmin.getAccount().getNubmerOfImgInFirebase());
                        AccountModel.getInstance().updatePassword(userAdmin.getAccount().getId(),userAdmin.getAccount().getPassword());
                        AccountModel.getInstance().updatePhoneNumber(userAdmin.getAccount().getId(),userAdmin.getAccount().getPhoneNumber());
                        AccountModel.getInstance().updateFullName(userAdmin.getAccount().getId(),userAdmin.getAccount().getFullName());
                        AccountModel.getInstance().updateDisplayName(userAdmin.getAccount().getId(),userAdmin.getAccount().getDisplayName());
                        AddressModel.getInstance().updateAddressById(userAdmin.getAccount().getId(),informationAccountNVKObject.getProvincial().getProvincialId(),informationAccountNVKObject.getDistrict().getDistrictId(),informationAccountNVKObject.getCommune().getCommuneId());

                        //  Tao thông báo cá nhân
                        PersonalNoticeModel.getInstance().addNewPersonalNoticeToDatabase(userAdmin.getAccount().getId(), "Bạn", "vừa thay đổi", "thông tin" ,"của mình", "");

                        //  Cho biết là thông báo
                        informationAccountNVKObject.setNotify(true);
                        informationAccountNVKObject.setTitle("Bạn đã lưu lại dữ liệu thành công");
                        informationAccountNVKObject.setContent("Dữ liệu của bạn đã được cập nhật");

                    }

                    informationAccountNVKObject.setReady(true);
                    userAdmin.getListOfFunction().put("informationAccountNVKObject", informationAccountNVKObject);
                    userAdmin.updateReady("informationAccountNVKObject");
                    request.getSession().setAttribute("userAdmin", userAdmin);

                    // sedirect tới trang của mình thôi nào
                    response.sendRedirect("admin/home/thongTinTaiKhoanNVK.jsp");
                }
            }
        }
    }
}
