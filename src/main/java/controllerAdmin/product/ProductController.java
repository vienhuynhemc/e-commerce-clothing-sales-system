package controllerAdmin.product;

import beans.loginAdmin.UserAdmin;
import beans.nextPage.NextPageObject;
import beans.productAdmin.ProductAdmin;
import beans.productAdmin.ProductAdminObject;
import model.category.CategoryModel;
import model.color.ColorModel;
import model.manufacturer.ManufacturerModel;
import model.nextPage.NextPageModel;
import model.productAdmin.ProductAdminModel;
import model.size.SizeModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", urlPatterns = "/ProductController")
public class ProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        if (userAdmin == null) {
            request.getSession().setAttribute("trackPage", "admin.quanLySanPham");
            response.sendRedirect("admin/home/login.jsp");
        } else {

            ////////////////////////********* QUAN TRỌNG **********//////////////////////////////////

            //  Khi tới controller này nó sẽ cập nhập lại trạng thái là hàng này có còn là hàng mới nhập
            ProductAdminModel.getInstance().update();
            //..............................///////////////////////////..............................//

            //  Kiểm tra foward, xem trang khác có foward tới này không
            String foward = (String) request.getAttribute("forward");

            //  Nếu khác null thì xem thử nó là từ trang nào
            if (foward != null) {

                //  Lấy đối tượng ra
                ProductAdminObject productAdminObject = (ProductAdminObject) userAdmin.getListOfFunction().get("productAdminObject");

                //  Lấy lại list mã giảm giá để đổ dữ liệu
                List<ProductAdmin> productAdmins = ProductAdminModel.getInstance().getListProductByAll(productAdminObject.getSelectSearchAndSort(), productAdminObject.getSort(), productAdminObject.getSearch(), productAdminObject.getNowPage());
                productAdminObject.setProducts(productAdmins);

                //  Nếu là từ trang xóa thì làm như thế này
                if (foward.equals("remove")) {

                    //  Kiểm tra nếu như discountCodes.size == 0 thì có nghĩa trang này hết dữ liệu rồi, cập nhập lại nowPage -1
                    if (productAdmins.size() == 0) {
                        if (productAdminObject.getNowPage() > 1) {
                            productAdminObject.setNowPage(productAdminObject.getNowPage() - 1);
                             productAdmins = ProductAdminModel.getInstance().getListProductByAll(productAdminObject.getSelectSearchAndSort(), productAdminObject.getSort(), productAdminObject.getSearch(), productAdminObject.getNowPage());
                            productAdminObject.setProducts(productAdmins);
                        }
                    }

                    //  Cập nhập lại số lượng hiển thị
                    productAdminObject.setNumberOfShow(ProductAdminModel.getInstance().getNumberOfShow(productAdmins));

                    //  Cập nhập lại số sản phẩm tối đa
                    int maximumProduct = ProductAdminModel.getInstance().getNumberOfMaxProductFromAll(productAdminObject.getSelectSearchAndSort(), productAdminObject.getSearch());
                    productAdminObject.setMaximumProduct(maximumProduct);

                    //  Cập nhập lại số trang tối đa
                    int maximumPage =ProductAdminModel.getInstance().getMaximunNumberOfPage(maximumProduct);
                    productAdminObject.setMaximumPage(maximumPage);

                    //  Cập nhập lại list Next page
                    List<NextPageObject> nextPages = NextPageModel.getInstance().getListNextPageObjectAdmin(productAdminObject.getNowPage(), productAdminObject.getMaximumPage());
                    productAdminObject.setNextPages(nextPages);

                    //  Cập nhập lại là bị xóa
                    productAdminObject.setNotify(true);
                    productAdminObject.setTitle((String) request.getAttribute("more"));
                    productAdminObject.setContent((String) request.getAttribute("more2"));

                    //  Nếu là từ trang thêm thì làm như thế này
                } else if (foward.equals("addProduct")) {

                    //  Cập nhập lại số lượng hiển thị
                    productAdminObject.setNumberOfShow(ProductAdminModel.getInstance().getNumberOfShow(productAdmins));

                    //  Cập nhập lại số sản phẩm tối đa
                    int maximumProduct = ProductAdminModel.getInstance().getNumberOfMaxProductFromAll(productAdminObject.getSelectSearchAndSort(), productAdminObject.getSearch());
                    productAdminObject.setMaximumProduct(maximumProduct);

                    //  Cập nhập lại số trang tối đa
                    int maximumPage =ProductAdminModel.getInstance().getMaximunNumberOfPage(maximumProduct);
                    productAdminObject.setMaximumPage(maximumPage);

                    //  Cập nhập lại list Next page
                    List<NextPageObject> nextPages = NextPageModel.getInstance().getListNextPageObjectAdmin(productAdminObject.getNowPage(), productAdminObject.getMaximumPage());
                    productAdminObject.setNextPages(nextPages);

                    productAdminObject.setNotify(true);
                    productAdminObject.setTitle((String) request.getAttribute("more"));
                    productAdminObject.setContent((String) request.getAttribute("more2"));

                    //  Chuyển về trạng thái ban đầu, cho đối tượng thêm thành null
                    productAdminObject.setProductAdminAdd(null);
                    productAdminObject.setIs_them_moi(false);
                    productAdminObject.setIs_sua_da(false);
                    productAdminObject.setIs_sua_don(false);

                } else if (foward.equals("edit")) {


                } else if(foward.equals("addColor")){

                    //  Lấy lại danh sách các màu
                    productAdminObject.setDanh_sach_mau(ColorModel.getInstance().getAllColor());

                    productAdminObject.setNotify(true);
                    productAdminObject.setTitle((String) request.getAttribute("more"));
                    productAdminObject.setContent((String) request.getAttribute("more2"));
                }

                //  Gán lại cho sesstion
                productAdminObject.setReady(true);
                userAdmin.getListOfFunction().put("productAdminObject", productAdminObject);
                userAdmin.updateReady("productAdminObject");
                request.getSession().setAttribute("userAdmin", userAdmin);

                // sedirect tới trang của mình thôi nào
                response.sendRedirect("admin/home/quanLySanPham.jsp");
            } else {
                // set charset cho cả request và responne
                request.setCharacterEncoding("UTF-8");
                response.setContentType("text/html; charset=UTF-8");
                response.setCharacterEncoding("UTF-8");

                //----------Lấy những thông tin cần thiết của trang này------------------//

                //  Select sort and search
                String selectSearchAndSort = request.getParameter("selectSearchAndSort");

                //  sort DESC hay ASC, null == DESC on == ASC
                String sort = request.getParameter("sort");

                //  Nội dung ô tìm kiếm
                String search = request.getParameter("search");

                //  Số trang đi tới
                String numberOfPage = request.getParameter("numberOfPage");

                //  Số trang maximun
                String maximunNumberOfPage = request.getParameter("maximunNumberOfPage");

                //  action
                String action = request.getParameter("action");

                //  Kiểm tra thử select search and sort có dữ liệu hay chưa
                if (selectSearchAndSort == null) {

                    List<ProductAdmin> productAdmins = ProductAdminModel.getInstance().getListProductFirst();
                    int nowPage = 1;
                    int maximumProduct = ProductAdminModel.getInstance().getNumberOfMaxProductFirst();
                    int maximumOfPage = ProductAdminModel.getInstance().getMaximunNumberOfPage(maximumProduct);

                    //  Lấy list nextPage
                    List<NextPageObject> nextPages = NextPageModel.getInstance().getListNextPageObjectAdmin(nowPage, maximumOfPage);

                    ProductAdminObject productAdminObject = new ProductAdminObject();
                    productAdminObject.setProducts(productAdmins);
                    productAdminObject.setNowPage(nowPage);
                    productAdminObject.setMaximumProduct(maximumProduct);
                    productAdminObject.setMaximumPage(maximumOfPage);
                    productAdminObject.setNumberOfShow(ProductAdminModel.getInstance().getNumberOfShow(productAdmins));
                    productAdminObject.setNextPages(nextPages);
                    productAdminObject.setSort("DESC");
                    productAdminObject.setSearch("");
                    productAdminObject.setSelectSearchAndSort("sp.ngay_tao");
                    productAdminObject.setIs_sua_don(false);
                    productAdminObject.setIs_sua_da(false);
                    productAdminObject.setIs_them_moi(false);
                    productAdminObject.setMa_mau_tiep_theo(ColorModel.getInstance().getNextId());

                    productAdminObject.setReady(true);
                    userAdmin.getListOfFunction().put("productAdminObject", productAdminObject);
                    userAdmin.updateReady("productAdminObject");
                    request.getSession().setAttribute("userAdmin", userAdmin);

                    // sedirect tới trang của mình thôi nào
                    response.sendRedirect("admin/home/quanLySanPham.jsp");

                } else {
                    //  Action load là một thứ gì đó khác hoàn toàn nên ta phải làm như trường hợp xóa
                    if (action.equals("load")) {

                        ProductAdminObject productAdminObject = (ProductAdminObject) userAdmin.getListOfFunction().get("productAdminObject");
                        List<ProductAdmin> productAdmins = ProductAdminModel.getInstance().getListProductByAll(productAdminObject.getSelectSearchAndSort(), productAdminObject.getSort(), productAdminObject.getSearch(), productAdminObject.getNowPage());
                        productAdminObject.setProducts(productAdmins);

                        if (productAdmins.size() == 0) {
                            if (productAdminObject.getNowPage() > 0) {
                                productAdminObject.setNowPage(productAdminObject.getNowPage() - 1);
                                productAdmins = ProductAdminModel.getInstance().getListProductByAll(productAdminObject.getSelectSearchAndSort(), productAdminObject.getSort(), productAdminObject.getSearch(), productAdminObject.getNowPage());
                                productAdminObject.setProducts(productAdmins);
                            }
                        }

                        //  Cập nhập lại số lượng hiển thị
                        productAdminObject.setNumberOfShow(ProductAdminModel.getInstance().getNumberOfShow(productAdmins));

                        //  Cập nhập lại số sản phẩm tối đa
                        int maximumProduct = ProductAdminModel.getInstance().getNumberOfMaxProductFromAll(productAdminObject.getSelectSearchAndSort(), productAdminObject.getSearch());
                        productAdminObject.setMaximumProduct(maximumProduct);

                        //  Cập nhập lại số trang tối đa
                        int maximumPage =ProductAdminModel.getInstance().getMaximunNumberOfPage(maximumProduct);
                       productAdminObject.setMaximumPage(maximumPage);

                        //  Cập nhập lại list Next page
                        List<NextPageObject> nextPages = NextPageModel.getInstance().getListNextPageObjectAdmin(productAdminObject.getNowPage(), productAdminObject.getMaximumPage());
                        productAdminObject.setNextPages(nextPages);

                        productAdminObject.setMa_mau_tiep_theo(ColorModel.getInstance().getNextId());

                        //  Gán lại cho sesstion
                        productAdminObject.setReady(true);
                        userAdmin.getListOfFunction().put("productAdminObject", productAdminObject);
                        userAdmin.updateReady("productAdminObject");
                        request.getSession().setAttribute("userAdmin", userAdmin);

                        // sedirect tới trang của mình thôi nào
                        response.sendRedirect("admin/home/quanLySanPham.jsp");

                    }else if(action.equals("them_moi")){
                        ProductAdminObject productAdminObject = (ProductAdminObject) userAdmin.getListOfFunction().get("productAdminObject");

                        productAdminObject.setIs_them_moi(true);
                        productAdminObject.setIs_sua_da(false);
                        productAdminObject.setIs_sua_don(false);

                        // Thêm mới thì cập nhật 4 list lại prodcutAdminObject
                        productAdminObject.setDanh_sach_size(SizeModel.getInstance().getAllSize());
                        productAdminObject.setDanh_sach_mau(ColorModel.getInstance().getAllColor());
                        productAdminObject.setDanh_sach_hang_san_xuat(ManufacturerModel.getInstance().getAllManufacturer());
                        productAdminObject.setDanh_sach_danh_muc(CategoryModel.getInstance().getAllCategory());

                        //  Gán lại cho sesstion
                        productAdminObject.setReady(true);
                        userAdmin.getListOfFunction().put("productAdminObject", productAdminObject);
                        userAdmin.updateReady("productAdminObject");
                        request.getSession().setAttribute("userAdmin", userAdmin);

                        // sedirect tới trang của mình thôi nào
                        response.sendRedirect("admin/home/quanLySanPham.jsp");
                    }else if(action.equals("sua_don")){
                        ProductAdminObject productAdminObject = (ProductAdminObject) userAdmin.getListOfFunction().get("productAdminObject");

                        productAdminObject.setIs_them_moi(false);
                        productAdminObject.setIs_sua_da(false);
                        productAdminObject.setIs_sua_don(true);

                        //  Gán lại cho sesstion
                        productAdminObject.setReady(true);
                        userAdmin.getListOfFunction().put("productAdminObject", productAdminObject);
                        userAdmin.updateReady("productAdminObject");
                        request.getSession().setAttribute("userAdmin", userAdmin);

                        // sedirect tới trang của mình thôi nào
                        response.sendRedirect("admin/home/quanLySanPham.jsp");
                    }else if(action.equals("sua_da")){
                        ProductAdminObject productAdminObject = (ProductAdminObject) userAdmin.getListOfFunction().get("productAdminObject");

                        productAdminObject.setIs_them_moi(false);
                        productAdminObject.setIs_sua_da(true);
                        productAdminObject.setIs_sua_don(false);

                        //  Gán lại cho sesstion
                        productAdminObject.setReady(true);
                        userAdmin.getListOfFunction().put("productAdminObject", productAdminObject);
                        userAdmin.updateReady("productAdminObject");
                        request.getSession().setAttribute("userAdmin", userAdmin);

                        // sedirect tới trang của mình thôi nào
                        response.sendRedirect("admin/home/quanLySanPham.jsp");
                    }else if(action.equals("tro_ve")){
                        ProductAdminObject productAdminObject = (ProductAdminObject) userAdmin.getListOfFunction().get("productAdminObject");

                        productAdminObject.setIs_them_moi(false);
                        productAdminObject.setIs_sua_da(false);
                        productAdminObject.setIs_sua_don(false);

                        //  Gán lại cho sesstion
                        productAdminObject.setReady(true);
                        userAdmin.getListOfFunction().put("productAdminObject", productAdminObject);
                        userAdmin.updateReady("productAdminObject");
                        request.getSession().setAttribute("userAdmin", userAdmin);

                        // sedirect tới trang của mình thôi nào
                        response.sendRedirect("admin/home/quanLySanPham.jsp");
                    } else {
                        ProductAdminObject productAdminObject = (ProductAdminObject) userAdmin.getListOfFunction().get("productAdminObject");
                        switch (action) {

                            case "sort":

                                //  Lấy lại cách sắp xếp
                                if (sort != null) {
                                    productAdminObject.setSort("DESC");
                                } else {
                                    productAdminObject.setSort("ASC");
                                }

                                break;

                            case "changeFilter":

                                //  Lấy lại bộ lọc
                                productAdminObject.setSelectSearchAndSort(selectSearchAndSort);

                                //  Cập nhập lại maximun mã giảm giá
                                int maximunProduct= ProductAdminModel.getInstance().getNumberOfMaxProductFromAll(productAdminObject.getSelectSearchAndSort(), productAdminObject.getSearch());
                                productAdminObject.setMaximumProduct(maximunProduct);

                                //  Cập nhập lại số trang tối đa
                                int maximumPagee = ProductAdminModel.getInstance().getMaximunNumberOfPage(maximunProduct);
                                productAdminObject.setMaximumPage(maximumPagee);

                                //  Cập nhập lại list nextPage
                                List<NextPageObject> nextPagesss = NextPageModel.getInstance().getListNextPageObjectAdmin(1, maximumPagee);
                                productAdminObject.setNextPages(nextPagesss);

                                //  Cập nhập lại nowPage là 1
                                productAdminObject.setNowPage(1);

                                break;

                            case "nextPage":

                                //  Lấy lại nowPage
                                productAdminObject.setNowPage(Integer.parseInt(numberOfPage));

                                //  Cập nhập lại list nextPage
                                List<NextPageObject> nextPages = NextPageModel.getInstance().getListNextPageObjectAdmin(  productAdminObject.getNowPage(),   productAdminObject.getMaximumPage());
                                productAdminObject.setNextPages(nextPages);

                                break;

                            case "search":

                                //  Cập nhập now page là 1
                                productAdminObject.setNowPage(1);

                                //  Lấy lại search
                                productAdminObject.setSearch(search);

                                //  Cập nhập lại maximun mã giảm giá
                                int maximunProductt = ProductAdminModel.getInstance().getNumberOfMaxProductFromAll(productAdminObject.getSelectSearchAndSort(),productAdminObject.getSearch());
                                productAdminObject.setMaximumProduct(maximunProductt);

                                //  Cập nhập lại số trang tối đa
                                int maximumPage =ProductAdminModel.getInstance().getMaximunNumberOfPage(maximunProductt);
                                productAdminObject.setMaximumPage(maximumPage);

                                //  Cập nhập lại list nextPage
                                List<NextPageObject> nextPagess = NextPageModel.getInstance().getListNextPageObjectAdmin(1, maximumPage);
                                productAdminObject.setNextPages(nextPagess);

                                break;

                        }

                        //  Lấy lại hãng sản xuất
                        List<ProductAdmin> productAdmins = ProductAdminModel.getInstance().getListProductByAll(productAdminObject.getSelectSearchAndSort(), productAdminObject.getSort(), productAdminObject.getSearch(), productAdminObject.getNowPage());
                        productAdminObject.setProducts(productAdmins);

                        //  Cập nhập lại số sản phẩm hiện thị
                        productAdminObject.setNumberOfShow(ProductAdminModel.getInstance().getNumberOfShow(productAdmins));

                        //  Gán lại cho sesstion
                        productAdminObject.setReady(true);
                        userAdmin.getListOfFunction().put("productAdminObject", productAdminObject);
                        userAdmin.updateReady("productAdminObject");
                        request.getSession().setAttribute("userAdmin", userAdmin);

                        // sedirect tới trang của mình thôi nào
                        response.sendRedirect("admin/home/quanLySanPham.jsp");
                    }
                }
            }
        }
    }
}
