package controllerAdmin.informationAccountAdmin;

import beans.address.Commune;
import beans.address.District;
import beans.address.Provincial;
import beans.informationAccountAdmin.InformationAccountAdminObject;
import beans.loginAdmin.UserAdmin;
import model.commune.CommuneModel;
import model.district.DistrictModel;
import model.informationAccountAdmin.InformationAccountAdminModel;
import model.provincial.ProvincialModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
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

                if(foward.equals("removeAvatar")){
                    informationAccountAdminObject.setTitle("Bạn đã xóa hình đại diện thành công");
                    informationAccountAdminObject.setContent("Dữ liệu của bạn đã được thay đổi");
                }else if(foward.equals("changeAvatar")){
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

                    informationAccountAdminObject.setReady(true);
                    userAdmin.getListOfFunction().put("informationAccountAdminObject", informationAccountAdminObject);
                    userAdmin.updateReady("informationAccountAdminObject");
                    request.getSession().setAttribute("userAdmin", userAdmin);

                    // sedirect tới trang của mình thôi nào
                    response.sendRedirect("admin/home/thongTinTaiKhoanAdmin.jsp");

                } else {

                    String action = request.getParameter("action");
                    System.out.println(action);
                    if(action == null){

                    }else{
                         if(action.equals("goToEdit")){
                             informationAccountAdminObject.setEdit(true);
                         }else if(action.equals("backEdit")){
                             informationAccountAdminObject.setEdit(false);
                         }else if(action.equals("loadProvincial")){

                             // Cap nhat lai tinh hien tai
                             String provincialId = request.getParameter("provincial");
                             Provincial provincial = ProvincialModel.getInstance().getProvincialById(provincialId);
                             informationAccountAdminObject.setProvincial(provincial);

                             // Cật nhật lại list huyện
                             List<District> districts = DistrictModel.getInstance().getDistrictByProvincialId(provincialId);
                             informationAccountAdminObject.setDistricts(districts);
                             informationAccountAdminObject.setDistrict(null);

                             // Cho list xã thành null
                             informationAccountAdminObject.setCommunes(null);
                             informationAccountAdminObject.setCommune(null);

                         }else if(action.equals("loadDistrict")){

                             // Cập nhật lại huyện hiện tại
                             String districtId = request.getParameter("district");
                             District district = DistrictModel.getInstance().getDistrictById(districtId);
                             informationAccountAdminObject.setDistrict(district);

                             // Cập nhât lại list xa
                             List<Commune> communes = CommuneModel.getInstance().getCommuneByDistrictId(districtId);
                             informationAccountAdminObject.setCommunes(communes);
                             informationAccountAdminObject.setCommune(null);

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
}
