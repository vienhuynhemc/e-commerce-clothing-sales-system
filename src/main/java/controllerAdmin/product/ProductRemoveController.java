package controllerAdmin.product;

import beans.loginAdmin.UserAdmin;
import model.discountCode.DiscountCodeModel;
import model.personalNotice.PersonalNoticeModel;
import model.productInformation.ProductInformationModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductRemoveController", urlPatterns = "/ProductRemoveController")
public class ProductRemoveController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        if(userAdmin == null){
            response.sendRedirect("admin/home/login.jsp");
        }else {
            // set charset cho cả request và responne
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            //  Lấy kiểu xóa
            String type = request.getParameter("type");

            //  Tùy theo cách xóa để ta lấy dữ liệu
            if (type.equals("single")) {

                String ma_sp = request.getParameter("ma_sp");
                String ma_mau = request.getParameter("ma_mau");
                String ma_size = request.getParameter("ma_size");
                String ten_mau = request.getParameter("ten_mau");
                String ten_size =request.getParameter("ten_size");

                //  Cho model cái mã để nó xóa mã mgg , thay đổi cột tồn tại từ 0 -> 1
                boolean check = ProductInformationModel.getInstance().removeInformationProduct(ma_sp,ma_mau,ma_size);

                //  Xóa xong thì set một biến cho request biết là xóa một đối tượng để nó cập nhập lại
                request.setAttribute("forward", "remove");

                //  Xóa thành công chức tỏ mã có tồn tại và đã xóa
                if (check) {
                    request.setAttribute("more", "Bạn đã xóa thành công #" +ma_sp+", Size: "+ten_size+", Màu: "+ten_mau);
                    request.setAttribute("more2", "Việc xóa đã thay đổi dữ liệu của bạn");
                    //  Tạo thông báo cá nhân
                    PersonalNoticeModel.getInstance().addNewPersonalNoticeToDatabase(userAdmin.getAccount().getId(), "Bạn", "vừa xóa", "một sản phẩm" ,"có thông tin là:","#" +ma_sp+", Size: "+ten_size+", Màu: "+ten_mau);

                } else {
                    request.setAttribute("more", "Sản phẩm với màu và size này không tòn tại");
                    request.setAttribute("more2", "Dữ liệu không có gì thay đổi");
                }

                //  Xong foward tới controller đỗ dữ liệu
                request.getRequestDispatcher("ProductController").forward(request, response);

            } else if (type.equals("group")) {

                String danh_sach_thong_tin = request.getParameter("danh_sach_thong_tin");
                String[] danh_sach = danh_sach_thong_tin.split(" ");

                int row =ProductInformationModel.getInstance().removeInformationProduct(danh_sach);

                //  Xóa xong thì set một biến cho request biết là xóa một đối tượng để nó cập nhập lại
                request.setAttribute("forward", "remove");

                //  Xem thử nó xóa được bao nhiêu dòng
                if (row == 0) {
                    request.setAttribute("more", "Không xóa được sản phẩm nào hết vì nó không tồn tại");
                    request.setAttribute("more2", "Dữ liệu không có gì thay đổi");
                } else {
                    PersonalNoticeModel.getInstance().addNewPersonalNoticeToDatabase(userAdmin.getAccount().getId(), "Bạn", "vừa xóa", row+" sản phẩm" ,"","");
                    request.setAttribute("more", "Bạn đã xóa thành công " + row + " sản phẩm");
                    request.setAttribute("more2", "Việc xóa đã thay đổi dữ liệu của bạn");
                }

                //  Xong foward tới controller đỗ dữ liệu
                request.getRequestDispatcher("ProductController").forward(request, response);

            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
