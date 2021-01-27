package controllerAdmin.product;

import beans.loginAdmin.UserAdmin;
import beans.productAdmin.ProductAdminEditSingle;
import beans.productAdmin.ProductAdminObject;
import beans.productAdmin.ProductAdminSizeAdd;
import model.personalNotice.PersonalNoticeModel;
import model.productDetailInformation.ProductDetailInformationModel;
import model.productImage.ProductImageModel;
import model.size.SizeModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductEditSingleController", urlPatterns = "/ProductEditSingleController")
public class ProductEditSingleController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        ProductAdminObject productAdminObject = (ProductAdminObject) userAdmin.getListOfFunction().get("productAdminObject");
        ProductAdminEditSingle productAdminEditSingle = productAdminObject.getProductAdminEditSingle();
        //--------------------------------------------------------

        String action = request.getParameter("action");
        String data = request.getParameter("data");

        if (action.equals("addSize")) {

            ProductAdminSizeAdd productAdminSizeAdd = SizeModel.getInstance().getProductAdminSizeAddById(data);
            productAdminEditSingle.getList_size().add(productAdminSizeAdd);

        } else if (action.equals("removeSize")) {
            for (ProductAdminSizeAdd productAdminSizeAdd : productAdminEditSingle.getList_size()) {
                if(productAdminSizeAdd.getId().equals(data)){
                    productAdminEditSingle.getList_size().remove(productAdminSizeAdd);
                    break;
                }
            }
        }else if(action.equals("removeImg")){
            productAdminEditSingle.getList_hinh_anh_sp().remove(data);
        }else if(action.equals("addImage")){
            productAdminEditSingle.getList_hinh_anh_sp().add(data);
            productAdminEditSingle.setHinh_anh_trong_firebase(productAdminEditSingle.getHinh_anh_trong_firebase()+1);
        }


        if(action.equals("save")){

            productAdminObject.setNotify(true);
            productAdminObject.setTitle("");
            productAdminObject.setContent("Dữ liệu của bạn đã được thay đổi");

            //  Tạo thông báo cá nhân
            PersonalNoticeModel.getInstance().addNewPersonalNoticeToDatabase(userAdmin.getAccount().getId(), "Bạn", "vừa sửa một", "sản phẩm" ,"có thông tin là: ","Mã màu: #"+productAdminEditSingle.getMa_sp()+", Tên màu: "+productAdminEditSingle.getMa_mau());

            //  Cập nhật trong hinh_anh_sp
           ProductImageModel.getInstance().updateImgProductSingleEdit(productAdminEditSingle.getMa_sp(),productAdminEditSingle.getMa_mau(),productAdminEditSingle.getList_hinh_anh_sp());

            // Cập nhật trong trang chi tiết sản phẩm
           ProductDetailInformationModel.getInstance().updateEditSingle(productAdminEditSingle.getMa_sp(),productAdminEditSingle.getMa_mau(),productAdminEditSingle.getList_size(),productAdminEditSingle.getHinh_anh_trong_firebase());

            request.setAttribute("forward", "editSingle");
            request.setAttribute("more", "Cập nhật dữ liệu thành công sản phẩm : Mã sản phẩm: #" + productAdminEditSingle.getMa_sp()+", Tên màu: "+productAdminEditSingle.getTen_mau());
            request.setAttribute("more2", "Cơ sở dữ liệu đã được thay đổi");

            request.getRequestDispatcher("ProductController").forward(request, response);

        }else{

        //----------------------------------------------------------
        productAdminObject.setReady(true);
        productAdminObject.setProductAdminEditSingle(productAdminEditSingle);
        userAdmin.getListOfFunction().put("productAdminObject", productAdminObject);
        userAdmin.updateReady("productAdminObject");
        request.getSession().setAttribute("userAdmin", userAdmin);

        // sedirect tới trang của mình thôi nào
        response.sendRedirect("admin/home/quanLySanPham.jsp");}
    }
}
