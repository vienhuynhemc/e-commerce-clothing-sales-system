package controllerAdmin.informationAccountNVGH;

import beans.address.Commune;
import beans.address.District;
import beans.address.Provincial;
import beans.informationAccountAdmin.InformationAccountAdminObject;
import beans.informationAccountNVGH.InformationAccountNVGHObject;
import beans.loginAdmin.UserAdmin;
import model.account.AccountModel;
import model.address.AddressModel;
import model.commune.CommuneModel;
import model.district.DistrictModel;
import model.informationAccountAdmin.InformationAccountAdminModel;
import model.informationAccountNVGH.InformationAccountNVGHModel;
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

@WebServlet(name = "InformationAccountNVGHController", urlPatterns = "/InformationAccountNVGHController")
public class InformationAccountNVGHController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        if (userAdmin == null) {
            request.getSession().setAttribute("trackPage", "admin.thongTinTaiKhoanNVGH");
            response.sendRedirect("admin/home/login.jsp");
        } else {

            //  Kiểm tra foward, xem trang khác có foward tới này không
            String foward = (String) request.getAttribute("forward");

            //  Nếu khác null thì xem thử nó là từ trang nào
            if (foward != null) {

                //  Lấy đối tượng ra
                InformationAccountNVGHObject informationAccountNVGHObject = (InformationAccountNVGHObject) userAdmin.getListOfFunction().get("informationAccountNVGHObject");

                if (foward.equals("removeAvatar")) {
                    informationAccountNVGHObject.setTitle("Bạn đã xóa hình đại diện thành công");
                    informationAccountNVGHObject.setContent("Dữ liệu của bạn đã được thay đổi");
                } else if (foward.equals("changeAvatar")) {
                    informationAccountNVGHObject.setTitle("Bạn đã thay đổi ảnh đại diện thành công");
                    informationAccountNVGHObject.setContent("Dữ liệu của bạn đã được thay đổi");
                }

                //  Cập nhật là thông báo
                informationAccountNVGHObject.setNotify(true);

                //  Cập nhật đang ở trang chỉnh sửa
                informationAccountNVGHObject.setEdit(true);

                informationAccountNVGHObject.setReady(true);
                userAdmin.getListOfFunction().put("informationAccountNVGHObject", informationAccountNVGHObject);
                userAdmin.updateReady("informationAccountNVGHObject");
                request.getSession().setAttribute("userAdmin", userAdmin);

                // sedirect tới trang của mình thôi nào
                response.sendRedirect("admin/home/thongTinTaiKhoanNVGH.jsp");


            } else {

                //  Trước tiên kiểm tra xem thử nó bắt đầu hay đã có và đang gọi một action
                InformationAccountNVGHObject informationAccountNVGHObject = (InformationAccountNVGHObject) userAdmin.getListOfFunction().get("informationAccountNVGHObject");

                if (informationAccountNVGHObject == null || !informationAccountNVGHObject.isReady()) {


                    // set charset cho cả request và responne
                    request.setCharacterEncoding("UTF-8");
                    response.setContentType("text/html; charset=UTF-8");
                    response.setCharacterEncoding("UTF-8");

                    informationAccountNVGHObject = new InformationAccountNVGHObject();
                    //  Cập nhật số đơn hàng admin này đã duyệt
                    int orderApproval = InformationAccountNVGHModel.getInstance().getOrderApprovalByIdNVGH(userAdmin.getAccount().getId());
                    informationAccountNVGHObject.setOrderApproval(orderApproval);

                    //  Cập nhật list tỉnh thành để đổ dữ liệu ra
                    List<Provincial> provincials = ProvincialModel.getInstance().getListProvincial();
                    informationAccountNVGHObject.setProvincials(provincials);

                    //  Cập nhật tỉnh huyện xã hiện tại là của ông userAdmin
                    informationAccountNVGHObject.setProvincial(userAdmin.getAccount().getProvincial());
                    informationAccountNVGHObject.setDistrict(userAdmin.getAccount().getDistrict());
                    informationAccountNVGHObject.setCommune(userAdmin.getAccount().getCommune());

                    //  Cập nhật list huyện theo tỉnh của userAdmin
                    List<District> districts = DistrictModel.getInstance().getDistrictByProvincialId(userAdmin.getAccount().getProvincial().getProvincialId());
                    informationAccountNVGHObject.setDistricts(districts);

                    //  Cập nhật list phường xã theo tỉnh hiện tại của userAdmin
                    List<Commune> communes = CommuneModel.getInstance().getCommuneByDistrictId(userAdmin.getAccount().getDistrict().getDistrictId());
                    informationAccountNVGHObject.setCommunes(communes);

                    //  Cập nhật thông tin khasc
                    informationAccountNVGHObject.setFullName(userAdmin.getAccount().getFullName());
                    informationAccountNVGHObject.setDisplayName(userAdmin.getAccount().getDisplayName());
                    informationAccountNVGHObject.setPhoneNumber(userAdmin.getAccount().getPhoneNumber());
                    informationAccountNVGHObject.setPassword(userAdmin.getAccount().getPassword());
                    informationAccountNVGHObject.setCheckPassword(userAdmin.getAccount().getPassword());
                    informationAccountNVGHObject.setIntroduct(userAdmin.getAccount().getIntroduce());

                    informationAccountNVGHObject.setReady(true);
                    userAdmin.getListOfFunction().put("informationAccountNVGHObject", informationAccountNVGHObject);
                    userAdmin.updateReady("informationAccountNVGHObject");
                    request.getSession().setAttribute("userAdmin", userAdmin);

                    // sedirect tới trang của mình thôi nào
                    response.sendRedirect("admin/home/thongTinTaiKhoanNVGH.jsp");

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

                    informationAccountNVGHObject.setFullName(fullName);
                    informationAccountNVGHObject.setDisplayName(displayName);
                    informationAccountNVGHObject.setPhoneNumber(phoneNumber);
                    informationAccountNVGHObject.setPassword(password);
                    informationAccountNVGHObject.setCheckPassword(checkPassword);
                    informationAccountNVGHObject.setIntroduct(introduct);
                    if (district.equals("none")) {
                        informationAccountNVGHObject.setDistrict(null);
                    } else {
                        District districtObject = DistrictModel.getInstance().getDistrictById(district);
                        informationAccountNVGHObject.setDistrict(districtObject);
                    }
                    if (commune.equals("none")) {
                        informationAccountNVGHObject.setCommune(null);
                    } else {
                        Commune communeObject = CommuneModel.getInstance().getCommuneById(commune);
                        informationAccountNVGHObject.setCommune(communeObject);
                    }

                    String action = request.getParameter("action");
                    if (action.equals("goToEdit")) {
                        informationAccountNVGHObject.setEdit(true);
                    } else if (action.equals("backEdit")) {
                        informationAccountNVGHObject.setEdit(false);
                    } else if (action.equals("loadProvincial")) {

                        // Cap nhat lai tinh hien tai
                        String provincialId = request.getParameter("provincial");
                        informationAccountNVGHObject.setProvincial(ProvincialModel.getInstance().getProvincialById(provincialId));

                        // Cật nhật lại list huyện
                        informationAccountNVGHObject.setDistricts(DistrictModel.getInstance().getDistrictByProvincialId(provincialId));
                        informationAccountNVGHObject.setDistrict(null);

                        // Cho list xã thành null
                        informationAccountNVGHObject.setCommunes(null);
                        informationAccountNVGHObject.setCommune(null);

                    } else if (action.equals("loadDistrict")) {

                        // Cập nhật lại huyện hiện tại
                        String districtId = request.getParameter("district");
                        informationAccountNVGHObject.setDistrict(DistrictModel.getInstance().getDistrictById(districtId));

                        // Cập nhât lại list xa
                        informationAccountNVGHObject.setCommunes(CommuneModel.getInstance().getCommuneByDistrictId(districtId));
                        informationAccountNVGHObject.setCommune(null);

                    }else if(action.equals("save")){
                        int hinh_anh_trong_firebase = Integer.parseInt(request.getParameter("hinh_anh_trong_firebase"));

                        // Cập nhập lại cho userAdmin
                        userAdmin.getAccount().setNubmerOfImgInFirebase(hinh_anh_trong_firebase);
                        userAdmin.getAccount().setIntroduce(introduct);
                        userAdmin.getAccount().setPassword(password);
                        userAdmin.getAccount().setPhoneNumber(phoneNumber);
                        userAdmin.getAccount().setFullName(fullName);
                        userAdmin.getAccount().setDisplayName(displayName);
                        userAdmin.getAccount().setProvincial(informationAccountNVGHObject.getProvincial());
                        userAdmin.getAccount().setDistrict(informationAccountNVGHObject.getDistrict());
                        userAdmin.getAccount().setCommune(informationAccountNVGHObject.getCommune());

                        // Update trong csdl luôn
                        StaffModel.getInstance().updateIntroductById(userAdmin.getAccount().getId(),userAdmin.getAccount().getIntroduce());
                        StaffModel.getInstance().updateNumberOfPictureInFirebaseById(userAdmin.getAccount().getId(),userAdmin.getAccount().getNubmerOfImgInFirebase());
                        AccountModel.getInstance().updatePassword(userAdmin.getAccount().getId(),userAdmin.getAccount().getPassword());
                        AccountModel.getInstance().updatePhoneNumber(userAdmin.getAccount().getId(),userAdmin.getAccount().getPhoneNumber());
                        AccountModel.getInstance().updateFullName(userAdmin.getAccount().getId(),userAdmin.getAccount().getFullName());
                        AccountModel.getInstance().updateDisplayName(userAdmin.getAccount().getId(),userAdmin.getAccount().getDisplayName());
                        AddressModel.getInstance().updateAddressById(userAdmin.getAccount().getId(),informationAccountNVGHObject.getProvincial().getProvincialId(),informationAccountNVGHObject.getDistrict().getDistrictId(),informationAccountNVGHObject.getCommune().getCommuneId());

                        //  Tao thông báo cá nhân
                        PersonalNoticeModel.getInstance().addNewPersonalNoticeToDatabase(userAdmin.getAccount().getId(), "Bạn", "vừa thay đổi", "thông tin" ,"của mình", "");

                        //  Cho biết là thông báo
                        informationAccountNVGHObject.setNotify(true);
                        informationAccountNVGHObject.setTitle("Bạn đã lưu lại dữ liệu thành công");
                        informationAccountNVGHObject.setContent("Dữ liệu của bạn đã được cập nhật");

                    }

                    informationAccountNVGHObject.setReady(true);
                    userAdmin.getListOfFunction().put("informationAccountNVGHObject", informationAccountNVGHObject);
                    userAdmin.updateReady("informationAccountNVGHObject");
                    request.getSession().setAttribute("userAdmin", userAdmin);

                    // sedirect tới trang của mình thôi nào
                    response.sendRedirect("admin/home/thongTinTaiKhoanNVGH.jsp");
                }
            }
        }
    }
}
