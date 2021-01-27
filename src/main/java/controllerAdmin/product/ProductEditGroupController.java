package controllerAdmin.product;

import beans.DateTime;
import beans.DateTimeConfiguration;
import beans.loginAdmin.UserAdmin;
import beans.productAdmin.*;
import model.category.CategoryModel;
import model.color.ColorModel;
import model.importPrice.ImportPriceModel;
import model.manufacturer.ManufacturerModel;
import model.personalNotice.PersonalNoticeModel;
import model.product.ProductModel;
import model.productDetailInformation.ProductDetailInformationModel;
import model.productImage.ProductImageModel;
import model.productInformation.ProductInformationModel;
import model.productIntroduction.ProductIntroductionModel;
import model.productPrice.ProductPriceModel;
import model.productStructure.ProductStructureModel;
import model.promotionalPrice.PromotionalPriceModel;
import model.size.SizeModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductEditGroupController", urlPatterns = "/ProductEditGroupController")
public class ProductEditGroupController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        ProductAdminObject productAdminObject = (ProductAdminObject) userAdmin.getListOfFunction().get("productAdminObject");
        ProductAdminAdd productAdminEditGroup = productAdminObject.getProductEditGroup();
        //--------------------------------------------------------

        String ten_sp = request.getParameter("ten_sp");
        productAdminEditGroup.setTen_sp(ten_sp);
        String gia_sp = request.getParameter("gia_sp");
        productAdminEditGroup.setGia_sp(gia_sp);
        String gia_km = request.getParameter("gia_km");
        productAdminEditGroup.setGia_khuyen_mai(gia_km);
        String gia_nhap = request.getParameter("gia_nhap");
        productAdminEditGroup.setGia_nhap(gia_nhap);

        String hang_san_xuat = request.getParameter("hang_san_xuat");
        if (productAdminEditGroup.getHang_san_xuat() == null) {
            productAdminEditGroup.setHang_san_xuat(ManufacturerModel.getInstance().getProductAdminManufacturerByI(hang_san_xuat));
        } else {
            if (!productAdminEditGroup.getHang_san_xuat().getId().equals(hang_san_xuat)) {
                productAdminEditGroup.setHang_san_xuat(ManufacturerModel.getInstance().getProductAdminManufacturerByI(hang_san_xuat));
            }
        }
        String danh_muc = request.getParameter("danh_muc");
        if (productAdminEditGroup.getDanh_muc() == null) {
            productAdminEditGroup.setDanh_muc(CategoryModel.getInstance().getProductAdminCategoryById(danh_muc));
        } else {
            if (!productAdminEditGroup.getDanh_muc().getId().equals(danh_muc)) {
                productAdminEditGroup.setDanh_muc(CategoryModel.getInstance().getProductAdminCategoryById(danh_muc));
            }
        }

        int size_goi_thieu = Integer.parseInt(request.getParameter("size_gioi_thieu"));
        List<String> list_gioi_thieu = new ArrayList<String>();
        int count = 0;
        while (size_goi_thieu > 0) {
            size_goi_thieu--;
            count++;
            list_gioi_thieu.add(request.getParameter("gioi_thieu" + count));
        }
        productAdminEditGroup.setList_gioi_thieu(list_gioi_thieu);

        int size_cau_tao = Integer.parseInt(request.getParameter("size_cau_tao"));
        List<String> list_cau_tao = new ArrayList<String>();
        count = 0;
        while (size_cau_tao > 0) {
            size_cau_tao--;
            count++;
            list_cau_tao.add(request.getParameter("cau_tao" + count));
        }
        productAdminEditGroup.setList_cau_tao(list_cau_tao);

        int size_thong_tin = Integer.parseInt(request.getParameter("size_thong_tin"));
        List<String> list_thong_tin = new ArrayList<String>();
        count = 0;
        while (size_thong_tin > 0) {
            size_thong_tin--;
            count++;
            list_thong_tin.add(request.getParameter("thong_tin" + count));
        }
        productAdminEditGroup.setList_thong_tin(list_thong_tin);
        String gioi_tinh = request.getParameter("gioi_tinh");
        productAdminEditGroup.setGioi_tinh(gioi_tinh);

        String action = request.getParameter("action");

        if (action.equals("removeSize")) {
            String ma_size = request.getParameter("id");
            productAdminEditGroup.removeOneSzeById(ma_size);
        } else if (action.equals("addSize")) {
            if (productAdminEditGroup.getList_size() == null) {
                productAdminEditGroup.setList_size(new ArrayList<ProductAdminSizeAdd>());
            }
            String id = request.getParameter("id");
            productAdminEditGroup.getList_size().add(SizeModel.getInstance().getProductAdminSizeAddById(id));
        } else if (action.equals("addColor")) {
            String ma_mau = request.getParameter("id");
            if (productAdminEditGroup.getList_mau_kem_hinh_anh() == null) {
                productAdminEditGroup.setList_mau_kem_hinh_anh(new ArrayList<ProductAdminColorAddProduct>());
            }
            ProductAdminColorAddProduct productAdminColorAddProduct = new ProductAdminColorAddProduct();
            productAdminColorAddProduct.setHinh_anh_trong_firebase(0);
            productAdminColorAddProduct.setList_hinh_anh_sp(new ArrayList<String>());
            ProductAdminColorAdd productAdminColorAdd = ColorModel.getInstance().getProductAdminColorAddById(ma_mau);
            productAdminColorAddProduct.setMa_mau(productAdminColorAdd.getMa_mau());
            productAdminColorAddProduct.setTen_mau(productAdminColorAdd.getTen_mau());
            productAdminColorAddProduct.setLink_hinh_anh(productAdminColorAdd.getHinh_anh_mau());
            ProductImageModel.getInstance().productAdminColorProductAdd(productAdminColorAddProduct,productAdminEditGroup.getMa_sp(),productAdminEditGroup.getList_size());
            productAdminEditGroup.getList_mau_kem_hinh_anh().add(productAdminColorAddProduct);
        } else if (action.equals("removeColor")) {
            String ma_mau = request.getParameter("id");
            productAdminEditGroup.removeColor(ma_mau);
        } else if (action.equals("addImage")) {
            String ma_mau = request.getParameter("id");
            String link_hinh = request.getParameter("id2");
            productAdminEditGroup.addImage(ma_mau, link_hinh);
        } else if (action.equals("removeImage")) {
            String ma_mau = request.getParameter("id");
            String link_hinh = request.getParameter("id2");
            productAdminEditGroup.removeImage(ma_mau, link_hinh);
        }

        if (action.equals("editProduct")) {
            String masp = productAdminEditGroup.getMa_sp();
            int gioitinh = (productAdminEditGroup.getGioi_tinh().equals("nam") ? 1 : 0);
            ProductModel.getInstance().editSpToDatabase(masp, productAdminEditGroup.getTen_sp(), productAdminEditGroup.getHang_san_xuat().getId(), productAdminEditGroup.getDanh_muc().getId(), gioitinh);
            ProductIntroductionModel.getInstance().editIntroductToDabase(masp,productAdminEditGroup.getList_gioi_thieu());
            ProductInformationModel.getInstance().editToDatabase(masp, productAdminEditGroup.getList_thong_tin());
            ProductStructureModel.getInstance().editToDatabase(masp, productAdminEditGroup.getList_cau_tao());
            ProductImageModel.getInstance().editToDatbase(masp, productAdminEditGroup.getList_mau_kem_hinh_anh());
            ProductDetailInformationModel.getInstance().editToDatabae(masp, productAdminEditGroup.getList_mau_kem_hinh_anh(), productAdminEditGroup.getList_size());
            ProductPriceModel.getInstance().addToDatabse(masp,Integer.parseInt(productAdminEditGroup.getGia_sp()),new DateTime(DateTimeConfiguration.NOW_DATE));
            ImportPriceModel.getInstance().addToDatabse(masp,Integer.parseInt(productAdminEditGroup.getGia_nhap()),new DateTime(DateTimeConfiguration.NOW_DATE));
            int giakm =0 ;
            try{
                giakm = Integer.parseInt(productAdminEditGroup.getGia_khuyen_mai());
            }catch (Exception e){

            }
            PromotionalPriceModel.getInstance().addToDatabse(masp,giakm,new DateTime(DateTimeConfiguration.NOW_DATE));

            request.setAttribute("forward", "editProductGroup");
            request.setAttribute("more", "Cập nhật thành công sản phẩm: Mã sản phẩm: #" + masp);
            request.setAttribute("more2", "Cơ sở dữ liệu đã được thay đổi");

            //  Tạo thông báo cá nhân
            PersonalNoticeModel.getInstance().addNewPersonalNoticeToDatabase(userAdmin.getAccount().getId(), "Bạn", "vừa cập nhật", "sản phẩm", "có thông tin là: ", "Mã sản phẩm: #" + masp);

            request.getRequestDispatcher("ProductController").forward(request, response);

        } else {
            productAdminObject.setReady(true);
            productAdminObject.setProductEditGroup(productAdminEditGroup);
            userAdmin.getListOfFunction().put("productAdminObject", productAdminObject);
            userAdmin.updateReady("productAdminObject");
            request.getSession().setAttribute("userAdmin", userAdmin);

            // sedirect tới trang của mình thôi nào
            response.sendRedirect("admin/home/quanLySanPham.jsp");
        }

    }
}
