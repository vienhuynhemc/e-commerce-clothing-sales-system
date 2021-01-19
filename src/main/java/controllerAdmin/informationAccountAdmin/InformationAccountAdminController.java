package controllerAdmin.informationAccountAdmin;

import beans.informationAccountAdmin.InformationAccountAdminObject;
import beans.loginAdmin.UserAdmin;
import model.importProduct.ImportProductModel;
import model.importProductInformation.ImportProductInformationModel;
import model.informationAccountAdmin.InformationAccountAdminModel;

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
            if (foward != null){

            }else{
                // set charset cho cả request và responne
                request.setCharacterEncoding("UTF-8");
                response.setContentType("text/html; charset=UTF-8");
                response.setCharacterEncoding("UTF-8");

                InformationAccountAdminObject informationAccountAdminObject = new InformationAccountAdminObject();
                //  Cập nhật số đơn hàng admin này đã duyệt
                int orderApproval = InformationAccountAdminModel.getInstance().getOrderApprovalByIdAdmin(userAdmin.getAccount().getId());
                informationAccountAdminObject.setOrderApproval(orderApproval);

                //  Cập nhật số lựong nhập hàng
                int numberOfImportProduct = InformationAccountAdminModel.getInstance().getNumberOfImportProductByIdAmin(userAdmin.getAccount().getId());
                informationAccountAdminObject.setNumberOfImportProduct(numberOfImportProduct);

                //  Cập nhập số lượgn hàng đã nhập
                int sumImportProduct = InformationAccountAdminModel.getInstance().getSumImportProductByListId(userAdmin.getAccount().getId());
                informationAccountAdminObject.setSumImportProduct(sumImportProduct);

                informationAccountAdminObject.setReady(true);
                userAdmin.getListOfFunction().put("informationAccountAdminObject",informationAccountAdminObject);
                userAdmin.updateReady("informationAccountAdminObject");
                request.getSession().setAttribute("userAdmin",userAdmin);

                // sedirect tới trang của mình thôi nào
                response.sendRedirect("admin/home/thongTinTaiKhoanAdmin.jsp");
            }

        }
    }
}
