package controllerAdmin.product;

import beans.loginAdmin.UserAdmin;
import model.color.ColorModel;
import model.personalNotice.PersonalNoticeModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

@WebServlet(name = "ProductAddColorController", urlPatterns = "/ProductAddColorController")
public class ProductAddColorController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // set charset cho cả request và responne
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");

        //  Lấy link hình ảnh
        String link_hinh_anh =request.getParameter("linkmauthem");

        //  Lấy mã màu tiếp theo
        String ma_mau = ColorModel.getInstance().getNextId();

        //  Lấy tên màu
        String ten_mau = request.getParameter("tenmauthem");

        //  Thêm vô csdl
        boolean check = ColorModel.getInstance().addToDatabase(ma_mau,ten_mau,link_hinh_anh);

        if(check){

            request.setAttribute("forward", "addColor");
            request.setAttribute("more", "Thêm thành công màu mới: Mã màu: #"+ma_mau+", Tên màu: "+ten_mau);
            request.setAttribute("more2", "Cơ sở dữ liệu đã được thay đổi");

            //  Tạo thông báo cá nhân
            PersonalNoticeModel.getInstance().addNewPersonalNoticeToDatabase(userAdmin.getAccount().getId(), "Bạn", "vừa thêm một", "màu" ,"mới có thông tin là: ","Mã màu: #"+ma_mau+", Tên màu: "+ten_mau);

        }else{
            request.setAttribute("forward", "addColor");
            request.setAttribute("more", "Thêm thất bại vì mã màu đã tồn tại");
            request.setAttribute("more2", "Cơ sở dữ liệu của bạn không có gì thay đổi");
        }

        request.getRequestDispatcher("ProductController").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
