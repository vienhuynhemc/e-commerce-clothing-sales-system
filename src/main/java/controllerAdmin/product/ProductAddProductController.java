package controllerAdmin.product;

import beans.loginAdmin.UserAdmin;
import beans.productAdmin.*;
import model.category.CategoryModel;
import model.color.ColorModel;
import model.manufacturer.ManufacturerModel;
import model.size.SizeModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductAddProductController", urlPatterns = "/ProductAddProductController")
public class ProductAddProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        ProductAdminObject productAdminObject = (ProductAdminObject) userAdmin.getListOfFunction().get("productAdminObject");
        if (productAdminObject.getProductAdminAdd() == null) {
            productAdminObject.setProductAdminAdd(new ProductAdminAdd());
        }

        ProductAdminAdd productAdminAdd = productAdminObject.getProductAdminAdd();

        String ten_sp = request.getParameter("ten_sp");
        productAdminAdd.setTen_sp(ten_sp);
        String gia_sp = request.getParameter("gia_sp");
        productAdminAdd.setGia_sp(gia_sp);
        String gia_km = request.getParameter("gia_km");
        productAdminAdd.setGia_khuyen_mai(gia_km);
        String gia_nhap = request.getParameter("gia_nhap");
        productAdminAdd.setGia_nhap(gia_nhap);
        String loai_sp = request.getParameter("loai_sp");
        productAdminAdd.setLoai_sp(loai_sp);

        String hang_san_xuat = request.getParameter("hang_san_xuat");
        if (productAdminAdd.getHang_san_xuat() == null) {
            productAdminAdd.setHang_san_xuat(ManufacturerModel.getInstance().getProductAdminManufacturerByI(hang_san_xuat));
        } else {
            if (!productAdminAdd.getHang_san_xuat().getId().equals(hang_san_xuat)) {
                productAdminAdd.setHang_san_xuat(ManufacturerModel.getInstance().getProductAdminManufacturerByI(hang_san_xuat));
            }
        }
        String danh_muc = request.getParameter("danh_muc");
        if (productAdminAdd.getDanh_muc() == null) {
            productAdminAdd.setDanh_muc(CategoryModel.getInstance().getProductAdminCategoryById(danh_muc));
        } else {
            if (!productAdminAdd.getDanh_muc().getId().equals(danh_muc)) {
                productAdminAdd.setDanh_muc(CategoryModel.getInstance().getProductAdminCategoryById(danh_muc));
            }
        }

        int size_goi_thieu = Integer.parseInt(request.getParameter("size_gioi_thieu"));
        List<String> list_gioi_thieu = new ArrayList<String>();
        int count = 0;
        while(size_goi_thieu >0){
            size_goi_thieu --;
            count++;
            list_gioi_thieu.add(request.getParameter("gioi_thieu"+count));
        }
        productAdminAdd.setList_gioi_thieu(list_gioi_thieu);

        int size_cau_tao= Integer.parseInt(request.getParameter("size_cau_tao"));
        List<String> list_cau_tao = new ArrayList<String>();
        count = 0;
        while(size_cau_tao >0){
            size_cau_tao --;
            count++;
            list_cau_tao.add(request.getParameter("cau_tao"+count));
        }
        productAdminAdd.setList_cau_tao(list_cau_tao);

        int size_thong_tin = Integer.parseInt(request.getParameter("size_thong_tin"));
        List<String> list_thong_tin = new ArrayList<String>();
        count = 0;
        while(size_thong_tin >0){
            size_thong_tin --;
            count++;
            list_thong_tin.add(request.getParameter("thong_tin"+count));
        }
        productAdminAdd.setList_thong_tin(list_thong_tin);

        String gioi_tinh = request.getParameter("gioi_tinh");
        productAdminAdd.setGioi_tinh(gioi_tinh);

        String action = request.getParameter("action");
        if(action.equals("removeSize")){
            String ma_size = request.getParameter("id");
            productAdminAdd.removeOneSzeById(ma_size);
        }else if(action.equals("addSize")){
            if(productAdminAdd.getList_size() == null){
                productAdminAdd.setList_size(new ArrayList<ProductAdminSizeAdd>());
            }
            String id = request.getParameter("id");
            productAdminAdd.getList_size().add(SizeModel.getInstance().getProductAdminSizeAddById(id));
        }else if(action.equals("addColor")){
            String ma_mau = request.getParameter("id");
            if(productAdminAdd.getList_mau_kem_hinh_anh() == null){
                productAdminAdd.setList_mau_kem_hinh_anh(new ArrayList<ProductAdminColorAddProduct>());
            }
            ProductAdminColorAddProduct productAdminColorAddProduct = new ProductAdminColorAddProduct();
            productAdminColorAddProduct.setHinh_anh_trong_firebase(0);
            productAdminColorAddProduct.setList_hinh_anh_sp(new ArrayList<String>());
            ProductAdminColorAdd productAdminColorAdd = ColorModel.getInstance().getProductAdminColorAddById(ma_mau);
            productAdminColorAddProduct.setMa_mau(productAdminColorAdd.getMa_mau());
            productAdminColorAddProduct.setTen_mau(productAdminColorAdd.getTen_mau());
            productAdminColorAddProduct.setLink_hinh_anh(productAdminColorAdd.getHinh_anh_mau());
            productAdminAdd.getList_mau_kem_hinh_anh().add(productAdminColorAddProduct);
        }else if(action.equals("removeColor")){
            String ma_mau = request.getParameter("id");
            productAdminAdd.removeColor(ma_mau);
        }else if(action.equals("addImage")){
            String ma_mau = request.getParameter("id");
            String link_hinh =request.getParameter("id2");
            productAdminAdd.addImage(ma_mau,link_hinh);
        }else if(action.equals("removeImage")){
            String ma_mau = request.getParameter("id");
            String link_hinh =request.getParameter("id2");
            productAdminAdd.removeImage(ma_mau,link_hinh);
        }

        productAdminObject.setReady(true);
        productAdminObject.setProductAdminAdd(productAdminAdd);
        userAdmin.getListOfFunction().put("productAdminObject", productAdminObject);
        userAdmin.updateReady("productAdminObject");
        request.getSession().setAttribute("userAdmin", userAdmin);

        // sedirect tới trang của mình thôi nào
        response.sendRedirect("admin/home/quanLySanPham.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
