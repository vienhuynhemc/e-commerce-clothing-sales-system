package controllerAdmin.informationAccountAdmin;

import beans.address.Commune;
import beans.address.District;
import beans.address.Provincial;
import beans.informationAccountAdmin.InformationAccountAdminObject;
import beans.loginAdmin.UserAdmin;
import model.account.AccountModel;
import model.commune.CommuneModel;
import model.district.DistrictModel;
import model.informationAccountAdmin.InformationAccountAdminModel;
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

@WebServlet(name = "InformationAccountAdminController", urlPatterns = "/InformationAccountAdminController")
public class InformationAccountAdminController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        if (userAdmin == null) {
            request.getSession().setAttribute("trackPage", "admin.thongTinTaiKhoanAdmin");
            response.sendRedirect("admin/home/login.jsp");
        } else {

            //  Kiểm tra foward, xem trang khác có foward tới này không
            String foward = (String) request.getAttribute("forward");

            //  Nếu khác null thì xem thử nó là từ trang nào
            if (foward != null) {

                //  Lấy đối tượng ra
                InformationAccountAdminObject informationAccountAdminObject = (InformationAccountAdminObject) userAdmin.getListOfFunction().get("informationAccountAdminObject");

                if (foward.equals("removeAvatar")) {
                    informationAccountAdminObject.setTitle("Bạn đã xóa hình đại diện thành công");
                    informationAccountAdminObject.setContent("Dữ liệu của bạn đã được thay đổi");
                } else if (foward.equals("changeAvatar")) {
                    informationAccountAdminObject.setTitle("Bạn đã thay đổi ảnh đại diện thành công");
                    informationAccountAdminObject.setContent("Dữ liệu của bạn đã được thay đổi");
                }

                //  Cập nhật là thông báo
                informationAccountAdminObject.setNotify(true);

                //  Cập nhật đang ở trang chỉnh sửa
                informationAccountAdminObject.setEdit(true);

                informationAccountAdminObject.setReady(true);
                userAdmin.getListOfFunction().put("informationAccountAdminObject", informationAccountAdminObject);
                userAdmin.updateReady("informationAccountAdminObject");
                request.getSession().setAttribute("userAdmin", userAdmin);

                // sedirect tới trang của mình thôi nào
                response.sendRedirect("admin/home/thongTinTaiKhoanAdmin.jsp");


            } else {

                //  Trước tiên kiểm tra xem thử nó bắt đầu hay đã có và đang gọi một action
                InformationAccountAdminObject informationAccountAdminObject = (InformationAccountAdminObject) userAdmin.getListOfFunction().get("informationAccountAdminObject");

                if (informationAccountAdminObject == null || !informationAccountAdminObject.isReady()) {


                    // set charset cho cả request và responne
                    request.setCharacterEncoding("UTF-8");
                    response.setContentType("text/html; charset=UTF-8");
                    response.setCharacterEncoding("UTF-8");

                    informationAccountAdminObject = new InformationAccountAdminObject();
                    //  Cập nhật số đơn hàng admin này đã duyệt
                    int orderApproval = InformationAccountAdminModel.getInstance().getOrderApprovalByIdAdmin(userAdmin.getAccount().getId());
                    informationAccountAdminObject.setOrderApproval(orderApproval);

                    //  Cập nhật số lựong nhập hàng
                    int numberOfImportProduct = InformationAccountAdminModel.getInstance().getNumberOfImportProductByIdAmin(userAdmin.getAccount().getId());
                    informationAccountAdminObject.setNumberOfImportProduct(numberOfImportProduct);

                    //  Cập nhập số lượgn hàng đã nhập
                    int sumImportProduct = InformationAccountAdminModel.getInstance().getSumImportProductByListId(userAdmin.getAccount().getId());
                    informationAccountAdminObject.setSumImportProduct(sumImportProduct);

                    //  Cập nhật list tỉnh thành để đổ dữ liệu ra
                    List<Provincial> provincials = ProvincialModel.getInstance().getListProvincial();
                    informationAccountAdminObject.setProvincials(provincials);

                    //  Cập nhật tỉnh huyện xã hiện tại là của ông userAdmin
                    informationAccountAdminObject.setProvincial(userAdmin.getAccount().getProvincial());
                    informationAccountAdminObject.setDistrict(userAdmin.getAccount().getDistrict());
                    informationAccountAdminObject.setCommune(userAdmin.getAccount().getCommune());

                    //  Cập nhật list huyện theo tỉnh của userAdmin
                    List<District> districts = DistrictModel.getInstance().getDistrictByProvincialId(userAdmin.getAccount().getProvincial().getProvincialId());
                    informationAccountAdminObject.setDistricts(districts);

                    //  Cập nhật list phường xã theo tỉnh hiện tại của userAdmin
                    List<Commune> communes = CommuneModel.getInstance().getCommuneByDistrictId(userAdmin.getAccount().getDistrict().getDistrictId());
                    informationAccountAdminObject.setCommunes(communes);

                    //  Cập nhật thông tin khasc
                    informationAccountAdminObject.setFullName(userAdmin.getAccount().getFullName());
                    informationAccountAdminObject.setDisplayName(userAdmin.getAccount().getDisplayName());
                    informationAccountAdminObject.setPhoneNumber(userAdmin.getAccount().getPhoneNumber());
                    informationAccountAdminObject.setPassword(userAdmin.getAccount().getPassword());
                    informationAccountAdminObject.setCheckPassword(userAdmin.getAccount().getPassword());
                    informationAccountAdminObject.setIntroduct(userAdmin.getAccount().getIntroduce());

                    informationAccountAdminObject.setReady(true);
                    userAdmin.getListOfFunction().put("informationAccountAdminObject", informationAccountAdminObject);
                    userAdmin.updateReady("informationAccountAdminObject");
                    request.getSession().setAttribute("userAdmin", userAdmin);

                    // sedirect tới trang của mình thôi nào
                    response.sendRedirect("admin/home/thongTinTaiKhoanAdmin.jsp");

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

                    informationAccountAdminObject.setFullName(fullName);
                    informationAccountAdminObject.setDisplayName(displayName);
                    informationAccountAdminObject.setPhoneNumber(phoneNumber);
                    informationAccountAdminObject.setPassword(password);
                    informationAccountAdminObject.setCheckPassword(checkPassword);
                    informationAccountAdminObject.setIntroduct(introduct);
                    if (district.equals("none")) {
                        informationAccountAdminObject.setDistrict(null);
                    } else {
                        District districtObject = DistrictModel.getInstance().getDistrictById(district);
                        informationAccountAdminObject.setDistrict(districtObject);
                    }
                    if (commune.equals("none")) {
                        informationAccountAdminObject.setCommune(null);
                    } else {
                        Commune communeObject = CommuneModel.getInstance().getCommuneById(commune);
                        informationAccountAdminObject.setCommune(communeObject);
                    }

                    String action = request.getParameter("action");
                    if (action.equals("goToEdit")) {
                        informationAccountAdminObject.setEdit(true);
                    } else if (action.equals("backEdit")) {
                        informationAccountAdminObject.setEdit(false);
                    } else if (action.equals("loadProvincial")) {

                        // Cap nhat lai tinh hien tai
                        String provincialId = request.getParameter("provincial");
                        informationAccountAdminObject.setProvincial(ProvincialModel.getInstance().getProvincialById(provincialId));

                        // Cật nhật lại list huyện
                        informationAccountAdminObject.setDistricts(DistrictModel.getInstance().getDistrictByProvincialId(provincialId));
                        informationAccountAdminObject.setDistrict(null);

                        // Cho list xã thành null
                        informationAccountAdminObject.setCommunes(null);
                        informationAccountAdminObject.setCommune(null);

                    } else if (action.equals("loadDistrict")) {

                        // Cập nhật lại huyện hiện tại
                        String districtId = request.getParameter("district");
                        informationAccountAdminObject.setDistrict(DistrictModel.getInstance().getDistrictById(districtId));

                        // Cập nhât lại list xa
                        informationAccountAdminObject.setCommunes(CommuneModel.getInstance().getCommuneByDistrictId(districtId));
                        informationAccountAdminObject.setCommune(null);

                    }else if(action.equals("save")){
                        int hinh_anh_trong_firebase = Integer.parseInt(request.getParameter("hinh_anh_trong_firebase"));

                        // Cập nhập lại cho userAdmin
                        userAdmin.getAccount().setNubmerOfImgInFirebase(hinh_anh_trong_firebase);
                        userAdmin.getAccount().setIntroduce(introduct);
                        userAdmin.getAccount().setPassword(password);
                        userAdmin.getAccount().setPhoneNumber(phoneNumber);
                        userAdmin.getAccount().setFullName(fullName);
                        userAdmin.getAccount().setDisplayName(displayName);

                        // Update trong csdl luôn
                        StaffModel.getInstance().updateIntroductById(userAdmin.getAccount().getId(),userAdmin.getAccount().getIntroduce());
                        StaffModel.getInstance().updateNumberOfPictureInFirebaseById(userAdmin.getAccount().getId(),userAdmin.getAccount().getNubmerOfImgInFirebase());
                        AccountModel.getInstance().updatePassword(userAdmin.getAccount().getId(),userAdmin.getAccount().getPassword());
                        AccountModel.getInstance().updatePhoneNumber(userAdmin.getAccount().getId(),userAdmin.getAccount().getPhoneNumber());
                        AccountModel.getInstance().updateFullName(userAdmin.getAccount().getId(),userAdmin.getAccount().getFullName());
                        AccountModel.getInstance().updateDisplayName(userAdmin.getAccount().getId(),userAdmin.getAccount().getDisplayName());

                        //  Tao thông báo cá nhân
                        PersonalNoticeModel.getInstance().addNewPersonalNoticeToDatabase(userAdmin.getAccount().getId(), "Bạn", "vừa thay đổi", "thông tin" ,"của mình", "");

                        //  Cho biết là thông báo
                        informationAccountAdminObject.setNotify(true);
                        informationAccountAdminObject.setTitle("Bạn đã lưu lại dữ liệu thành công");
                        informationAccountAdminObject.setContent("Dữ liệu của bạn đã được cập nhật");

                    }

                    informationAccountAdminObject.setReady(true);
                    userAdmin.getListOfFunction().put("informationAccountAdminObject", informationAccountAdminObject);
                    userAdmin.updateReady("informationAccountAdminObject");
                    request.getSession().setAttribute("userAdmin", userAdmin);

                    // sedirect tới trang của mình thôi nào
                    response.sendRedirect("admin/home/thongTinTaiKhoanAdmin.jsp");
                }
            }
        }
    }
}
