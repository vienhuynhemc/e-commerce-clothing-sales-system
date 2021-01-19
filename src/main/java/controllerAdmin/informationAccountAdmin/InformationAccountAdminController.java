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

                }
            }

        }
    }
}
