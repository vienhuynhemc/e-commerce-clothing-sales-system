<%@ page import="beans.loginAdmin.UserAdmin" %>
<%@ page import="beans.loginAdmin.AccountStaffAdmin" %>
<%@ page import="beans.productAdmin.ProductAdminObject" %>
<%@ page import="beans.nextPage.NextPageObject" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.nextPage.NextPageConfiguration" %>
<%@ page import="beans.productAdmin.ProductAdmin" %>
<%@ page import="beans.productAdmin.ProductAdminColor" %>
<%@ page import="beans.productAdmin.ProductAdminSize" %>
<%@ page import="model.informationAccountAdmin.InformationAccountAdminModel" %>
<%@ page import="model.salary.SalaryModel" %><%-- Created by IntelliJ IDEA. User: Administrator Date: 22/12/2020 Time: 9:10 CH To change this template use File |
    Settings | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVTSHOP ADMIN | Quản lý sản phẩm</title>
    <link rel="stylesheet" href="../../fonts/font-awesome-4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="../../css/indexAdmin.css">
    <script src="../../js/indexAdmin.js"></script>

    <link rel="stylesheet" href="../../css/quanLySanPhamAdmin.css">


</head>

<body>

<%
    //----------------------Kiểm tra thử đăng nhập hay chưa và có vai trò ở trang này hay không------------------------------------//
    if (request.getSession().getAttribute("userAdmin") == null) {

        //  Lưu vô session biến trang chờ đợi là trang này để có gì đăng nhập thành công chuyển tới trang này
        request.getSession().setAttribute("trackPage", "admin.quanLySanPham");

        //  Lưu trackpage xong thì sendredirect tới login
        response.sendRedirect("login.jsp");

    } else {

        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        AccountStaffAdmin accountStaffAdmin = userAdmin.getAccount();
        if (accountStaffAdmin.accept("admin.quanLySanPham")) {

            ProductAdminObject productAdminObject = (ProductAdminObject) userAdmin.getListOfFunction().get("productAdminObject");
            if (productAdminObject == null || !productAdminObject.isReady()) {
                response.sendRedirect("../../ProductController");
            } else {
%>

<!-------------------------------------------------------------------------------------------------------------------------------->
<!----------------------------------------------------- Form yes no ------------------------------------------------->
<div id="formYesNo">
    <div class="formYesNoHidden" onclick="hiddenFormYesNo()"></div>
    <div>
        <p>
            <i class="fa fa-cogs"></i> TVT Shop
        </p>
        <div>
            <p id="formYesNoTitle"></p>
            <p id="formYesNoTitle2"></p>
            <div>
                <a id="formYesNoLink">Có, chắc chắn <i class="fa fa-check"></i> </a>
                <span onclick="hiddenFormYesNo()">Không, suy nghĩ thêm <i class="fa fa-close"></i></span>
            </div>
        </div>
    </div>
</div>

<%
    //  Nếu như có thông báo thì hiển thị
    if (productAdminObject.isNotify()) {

        //  Thông báo xong thì để lại trạng thái ban đầu
        productAdminObject.setNotify(false);

%>
<div id="notifiSuccess">
    <div class="notifiSuccessHidden" onclick="hiddenNotifiSuccess()"></div>
    <div>
        <p>
            <i class="fa fa-cogs"></i> TVT Shop
        </p>
        <div>
            <p><%=productAdminObject.getTitle()%>
            </p>
            <p><%=productAdminObject.getContent()%> <i class="fa fa-hand-grab-o"></i></p>
            <div>
                <span onclick="hiddenNotifiSuccess()">Trở về<i class="fa fa-close"></i></span>
            </div>
        </div>
    </div>
</div>
<%}%>
<!------------------------------------------------------------------------------------------------------------------->

<div id="taomaumoi">
    <div onclick="taomauxong()"></div>
    <div class="divmau">
        <div>
            <input id="sm" type="file" style="display:none;" onchange="loadIMGMau(event)"/>
            <div>
                <img id="psm" src="../img/RYB.png" alt="">
            </div>
            <button onclick="document.getElementById('sm').click()">Chọn màu</button>
        </div>
        <div>
            <div class="div12inputlv2">
                <div>
                    <label>Tên màu</label>
                </div>
                <input type="text" placeholder="Nhập tên màu ở đây">
            </div>
            <button>Tạo màu</button>
            <button onclick="taomauxong()">Trở lại</button>
        </div>
    </div>
</div>

<jsp:include page="../share/_LayoutLeft.jsp">
    <jsp:param name="activeSelect" value="quanLySanPham"/>
</jsp:include>

<div class="indexright">
    <jsp:include page="../share/_LayoutTop.jsp">
        <jsp:param name="level" value="Admin"/>
    </jsp:include>

    <!-- Code trang ở đây-->

    <div class="indexmain">
        <div id="div2"
        <% if(productAdminObject.isIs_sua_da() || productAdminObject.isIs_sua_don() || productAdminObject.isIs_them_moi()){ %>
                style="display: none;"
        <%  } %>
        >
            <div>
                <form class="header" method="post" action="../../ProductController" id="mainForm"
                      onsubmit="return false">
                    <div class="leftheader">
                        <select name="selectSearchAndSort" id="selectSearchAndSort" onchange="changeFilter()">

                            <% String selectSearchAndSort = productAdminObject.getSelectSearchAndSort(); %>

                            <option value="sp.ngay_tao" selected
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("sp.ngay_tao")) {%>
                                    selected
                                    <%}%>
                            >Ngày tạo
                            </option>
                            <option value="ten_dm"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("ten_dm")) {%>
                                    selected
                                    <%}%>
                            >Tên danh mục
                            </option>
                            <option value="ten_sp"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("ten_sp")) {%>
                                    selected
                                    <%}%>
                            >Tên sản phẩm
                            </option>
                            <option value="so_luong_con_lai"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("so_luong_con_lai")) {%>
                                    selected
                                    <%}%>
                            >Số lượng còn lại
                            </option>
                            <option value="(SELECT s.gia_sp FROM gia_sp s WHERE s.ma_sp = t.ma_sp ORDER BY s.ngay_cap_nhat DESC LIMIT 0,1)"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("(SELECT s.gia_sp FROM gia_sp s WHERE s.ma_sp = t.ma_sp ORDER BY s.ngay_cap_nhat DESC LIMIT 0,1)")) {%>
                                    selected
                                    <%}%>
                            >Giá
                            </option>
                            <option value="ten_mau"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("ten_mau")) {%>
                                    selected
                                    <%}%>
                            >Màu
                            </option>
                            <option value="ten_size"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("ten_size")) {%>
                                    selected
                                    <%}%>
                            >Size
                            </option>
                            <option value="ma_sp"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("ma_sp")) {%>
                                    selected
                                    <%}%>
                            >Mã sản phẩm
                            </option>
                        </select>
                        <div>
                            <% String sort = productAdminObject.getSort(); %>

                            <% if (sort.equals("DESC")) {%>
                            <div class="leftheadersort" id="leftheadersort" onclick="changesort()">
                                <i class=" fa fa-sort-amount-desc"></i>
                            </div>
                            <%} else {%>
                            <div class="leftheadersort" id="leftheadersort" onclick="changesort()"
                                 style="margin-top:4px">
                                <i class=" fa fa-sort-amount-asc" style="margin-top: -10px"></i>
                            </div>
                            <%}%>

                            <div class="leftheadersearch">
                                <div>
                                    <i class="fa fa-search" onclick="searchByClick()"></i>
                                    <input type="text" placeholder="Tìm kiếm" name="search" class="searchsubmit"
                                           value="<%=productAdminObject.getSearch()%>">
                                    <i class="fa fa-refresh loadPage" onclick="loadPage()"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="leftnextpage" id="leftnextpage">
                        <p>Hiển thị <strong><%= productAdminObject.getNumberOfShow() %>
                        </strong> trên tổng <%=productAdminObject.getMaximumProduct()%> sản phẩm</p>
                        <span onclick="prePage(<%=productAdminObject.getNowPage()%>)"><i
                                class="fa fa-caret-left"></i></span>
                        <ul>

                            <%
                                //  Lấy list next page đổ next page ra
                                List<NextPageObject> nextPages = productAdminObject.getNextPages();
                                for (NextPageObject n : nextPages) {
                            %>
                            <li
                                    <% if (n.getType() == NextPageConfiguration.ACTIVE_LI) { %>
                                    class="activeli"
                                    <%} else if (n.getType() == NextPageConfiguration.NONE) {%>
                                    class="none"
                                    <%} else {%>
                                    onclick="pageNavigation(<%=n.getValue()%>)"
                                    <%}%>
                            >
                                <%if(n.getType() == NextPageConfiguration.NONE){%>
                                <p onclick="showselectgopage(this)"><%=n.getValue()%></p>
                                <%}else{%>
                                <%=n.getValue()%>
                                <%}%>
                                <div class="gopage">
                                    <input type="checkbox" style="display: none;">
                                    <input type="text">
                                    <i class="fa fa-angle-right" onclick="gopagefast(this)"></i>
                                </div>

                            </li>
                            <%
                                    //  Kết thúc đổ next page
                                }
                            %>
                        </ul>
                        <span onclick="nextPage(<%=productAdminObject.getNowPage()%>,<%=productAdminObject.getMaximumPage()%>)"><i
                                class="fa fa-caret-right"></i></span>
                        <input type="number" name="numberOfPage" id="numberOfPage" style="display: none"
                               value="<%=productAdminObject.getNowPage()%>">
                        <input type="number" name="maximunNumberOfPage" style="display: none" id="maximunNumberOfPage"
                               value="<%=productAdminObject.getMaximumPage()%>">
                    </div>
                    <span onclick="themsanphammoi()"><i class="fa fa-plus"></i>Thêm sản phẩm mới</span>
                    <span onclick="xoacacmuadachon()"><i class="fa fa-trash-o"></i>Xóa các mục đã
                        chọn
                    </span>

                    <!-- action -->
                    <input type="text" name="action" style="display: none" id="action" value="">

                    <!-- sort -->
                    <% if (sort.equals("DESC")) {%>
                    <input type="checkbox" style="display: none" name="sort" id="sort">
                    <% } else {%>
                    <input type="checkbox" style="display: none" name="sort" id="sort" checked>
                    <%}%>

                </form>
                <div class="maindiv2" id="maindiv2">
                    <div class="maindiv2header">
                        <button onclick="allselect()">+</button>
                        <p>Mã SP</p>
                        <p>Tên sản phẩm</p>
                        <p>Tên danh mục</p>
                        <p>Size</p>
                        <p>Màu</p>
                        <p>Giá</p>
                        <p>Số lượng</p>
                        <p>Ngày tạo</p>
                    </div>

                    <%
                        List<ProductAdmin> productAdmins = productAdminObject.getProducts();
                        for(ProductAdmin productAdmin : productAdmins){
                            for(ProductAdminColor productAdminColor : productAdmin.getDanh_sach_mau()){
                            for(ProductAdminSize productAdminSize : productAdminColor.getDanh_sach_size()){
                    %>

                    <div class="item">
                        <label for="c1">
                            <input type="checkbox" name="" id="c1">
                            <input type="text" value="<%=productAdmin.getMa_sp()%>" style="display: none">
                            <input type="text" value="<%=productAdminColor.getMa_mau()%>" style="display: none">
                            <input type="text" value="<%=productAdminSize.getId()%>" style="display: none">
                        </label>

                        <div class="itemhdd">
                            <img src="<%=productAdminColor.getLink_hinh_anh().get(0)%>" alt="">
                        </div>

                        <p class="itemname">
                            <span>#<%=productAdmin.getMa_sp()%></span>
                            <%=productAdmin.getTen_sp()%>
                        </p>

                        <p class="itemtdm">
                            <%=productAdmin.getDanh_muc().getName()%>
                        </p>

                        <div class="itemsize">
                            <div>
                                <p><%=productAdminSize.getName()%></p>
                            </div>
                        </div>

                        <div class="itemsize">
                            <div>
                                <img src="<%=productAdminColor.getHinh_anh_mau()%>" alt="">
                            </div>
                        </div>

                        <p class="itemgia">
                          <%=SalaryModel.getInstance().coverSalaryToString(productAdmin.getGia_sp())%>
                        </p>

                        <p class="itemsol"><%=productAdminSize.getSo_luong_con_lai()%></p>

                        <p class="itemngaytao">
                           <%=productAdmin.getNgay_tao().toStringDateTypeNumberStringNumber()%>
                        </p>


                        <div class="itemsubmit" onclick="showselect(this)">
                            <input type="text" style="display: none;">
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <div>
                                <button onclick="editkhachhang(this)"><i class="fa fa-pencil"></i>Sửa</button>
                                <button onclick="editkhachhangDa(this)"><i class="fa fa-plus"></i>Thêm</button>
                                <button onclick="removekhachhang(this)"><i class="fa fa-trash"></i>Xóa</button>
                                <input type="text" value="<%=productAdmin.getMa_sp()%>" style="display: none">
                                <input type="text" value="<%=productAdminColor.getMa_mau()%>" style="display: none">
                                <input type="text" value="<%=productAdminSize.getId()%>" style="display: none">
                                <input type="text" value="<%=productAdminColor.getTen_mau()%>" style="display: none">
                                <input type="text" value="<%=productAdminSize.getName()%>" style="display: none">
                            </div>
                        </div>

                    </div>

                    <%
                                }
                            }
                        }
                    %>

                </div>
            </div>
        </div>

        <div id="div1"
                <% if( productAdminObject.isIs_them_moi()){ %>

                <%  }else{ %>
             style="display: none;"
                <%}%>
        >
            <div>
                <div class="div11">
                    <h3>Thông tin sản phẩm</h3>
                    <div class="linediv12"></div>
                    <div class="div12inputlv2">
                        <div>
                            <label>Tên sản phẩm</label>
                        </div>
                        <input type="text" placeholder="Nhập tên sản phẩm ở đây">
                    </div>
                    <div class="div12inputlv2">
                        <div>
                            <label>Giá</label>
                        </div>
                        <input type="number" placeholder="Nhập giá sản phẩm ở đây">
                    </div>
                    <div class="div12inputlv2">
                        <div>
                            <label>Giá khuyến mãi</label>
                        </div>
                        <input type="text" placeholder="Nhập giá khuyến mãi sản phẩm ở đây">
                    </div>
                    <div class="div12inputlv2">
                        <div>
                            <label>Giá nhập</label>
                        </div>
                        <input type="text" placeholder="Nhập giá nhập sản phẩm ở đây">
                    </div>
                    <div class="div12inputlv2">
                        <div>
                            <label>Hãng sản xuất</label>
                            <div style="width: 10px;height: 25px;"></div>
                        </div>
                        <select name="">
                            <option value="" selected>Chọn hãng sản xuất</option>
                        </select>
                    </div>
                    <div class="div12inputlv2">
                        <div>
                            <label>Danh mục</label>
                            <span style="opacity: 0;margin-top: -10px;">Thêm danh mục</span>
                        </div>
                        <select name="">
                            <option value="" selected>Chọn danh mục</option>
                        </select>
                    </div>
                    <div class="gioitinh">
                        <h3>Giới tính</h3>
                        <div>
                            <span class="activebutton" id="gioitinhnam" onclick="nam()">Nam</span>
                            <span onclick="nu()" id="gioitinhnu">Nữ</span>
                        </div>
                    </div>
                    <div class="linediv12"></div>
                    <div class="div11submit">
                        <span><i class="fa fa-plus"></i>Thêm sản phẩm</span>
                        <span onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản lý</span>
                    </div>
                </div>

                <div class="div12">
                    <h3>Thêm thông tin cho sản phẩm</h3>
                    <div class="linediv12"></div>
                    <div class="div12inputlv2">
                        <div>
                            <label>Size</label>
                        </div>
                        <select name="">
                            <option value="img/den.webp" selected>Đen</option>
                        </select>
                    </div>
                    <div class="buttondiv12">
                            <span class="buttonthemmau" onclick="themmau(this)"><i class="fa fa-plus"></i>
                                Thêm
                                màu
                            </span>
                        <span onclick="taomaumoi()">Tạo màu mới</span>
                    </div>
                    <div class="maudachon">
                        <h3>Màu đã chọn</h3>
                        <div class="listMau">
                            <!-- <div class="listMauItem">
                            <div class="listMauItemleft">
                                <div>
                                    <p>Xanh đậm</p>
                                    <div>
                                        <img src="img/xanhdam.webp" alt="">
                                    </div>
                                </div>
                                <div>
                                    <div class="listHinh">
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp1.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp1.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp1.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp1.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp4.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp2.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp3.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp4.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp2.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp3.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp4.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                    </div>
                                    <i class="fa fa-angle-left" onclick="movehinhleft(this)"></i>
                                    <i class="fa fa-angle-right" onclick="movehinhright(this)"></i>
                                    <input type="number" style="display: none;" value="0">
                                </div>
                            </div>
                            <div class="removecolor">
                                <button onclick="themhinh(this)"><i class="fa fa-plus"></i></button>
                                <button onclick="removecolor(this)"><i class="fa fa-trash"></i></button>
                                <input type="file" style="display:none;" onchange="loadIMG(event,this)" />
                            </div>
                        </div> -->
                        </div>
                    </div>
                    <div class="linediv12"></div>
                    <div class="div12inputlv2">
                        <div>
                            <label style="margin-bottom: 10px;">Giới thiệu sản phẩm</label>
                        </div>
                        <span class="buttonthemmau" onclick="themGioiThieu()"> <i
                                class="fa fa-plus"></i>Thêm giới thiệu</span>
                        <div class="listGioiThieu" id="listGioiThieu">
                            <!-- <div class="itemGioiThieu">
                                <input type="text" placeholder="Nhập giới thiệu ở đây">
                                <i class="fa fa-remove" onclick="removeGioiThieu(this)"></i>
                            </div> -->
                        </div>
                    </div>
                    <div class="linediv12"></div>
                    <div class="div12inputlv2">
                        <div>
                            <label style="margin-bottom: 10px;">Cấu tạo sản phẩm</label>
                        </div>
                        <span class="buttonthemmau" onclick="themCauTao()"> <i
                                class="fa fa-plus"></i>Thêm cấu tạo</span>
                        <div class="listGioiThieu" id="listCauTao">
                            <!-- <div class="itemGioiThieu">
                                <input type="text" placeholder="Nhập cấu tạo ở đây">
                                <i class="fa fa-remove" onclick="removeCauTao(this)"></i>
                            </div> -->
                        </div>
                    </div>
                    <div class="linediv12"></div>
                    <div class="div12inputlv2">
                        <div>
                            <label style="margin-bottom: 10px;">Thông tin sản phẩm</label>
                        </div>
                        <span class="buttonthemmau" onclick="themThongTin()"> <i
                                class="fa fa-plus"></i>Thêm thông tin</span>
                        <div class="listGioiThieu" id="listThongTin">
                            <!-- <div class="itemGioiThieu">
                                <input type="text" placeholder="Nhập thông tin ở đây">
                                <i class="fa fa-remove" onclick="removeThongTin(this)"></i>
                            </div> -->
                        </div>
                    </div>
                </div>

                <div class="div13">
                    <h3>Chọn size</h3>
                    <div class="linediv12"></div>
                    <div class="div12inputlv2">
                        <div>
                            <label>Loại sản phẩm</label>
                        </div>
                        <select name="">
                            <option value="img/den.webp" selected>Áo</option>
                            <option value="">Quần</option>
                        </select>
                    </div>
                    <div class="div12inputlv2">
                        <div>
                            <label>Size</label>
                        </div>
                        <select name="">
                            <option value="S" selected>S</option>
                            <option value="M">M</option>
                            <option value="L">L</option>
                            <option value="XL">XL</option>
                            <option value="XXL">XXL</option>
                            <option value="XXXL">XXXL</option>
                        </select>
                    </div>
                    <span onclick="themsize(this)"><i class="fa fa-plus"></i> Thêm size</span>
                    <div class="sizedachon">
                        <h3>Size đã chọn</h3>
                        <div class="listSize">
                            <!-- <div class="listSizeItem">
                            <div>
                                <i class="fa fa-circle"></i>
                                <p>M</p>
                            </div>
                            <button onclick="removeSize(this)"><i class="fa fa-trash"></i></button>
                        </div> -->
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div id="div3"

                <% if(productAdminObject.isIs_sua_da() || productAdminObject.isIs_sua_don()){ %>
                <%  }else {%>
             style="display: none;"
                <%}%>

        >
            <div
                    <% if(productAdminObject.isIs_sua_da()){ %>
                    <%  }else {%>
                    style="display: none;"
                    <%}%>
            >
                <div class="div11">
                    <h3>Thông tin sản phẩm</h3>
                    <div class="linediv12"></div>
                    <div class="div12inputlv2">
                        <div>
                            <label>Tên sản phẩm</label>
                        </div>
                        <input type="text" placeholder="Nhập tên sản phẩm ở đây">
                    </div>
                    <div class="div12inputlv2">
                        <div>
                            <label>Giá</label>
                        </div>
                        <input type="number" placeholder="Nhập giá sản phẩm ở đây">
                    </div>
                    <div class="div12inputlv2">
                        <div>
                            <label>Giá khuyến mãi</label>
                        </div>
                        <input type="text" placeholder="Nhập giá khuyến mãi sản phẩm ở đây">
                    </div>
                    <div class="div12inputlv2">
                        <div>
                            <label>Giá nhập</label>
                        </div>
                        <input type="text" placeholder="Nhập giá nhập sản phẩm ở đây">
                    </div>
                    <div class="div12inputlv2">
                        <div>
                            <label>Hãng sản xuất</label>
                            <div style="width: 10px;height: 25px;"></div>
                        </div>
                        <select name="">
                            <option value="" selected>Chọn hãng sản xuất</option>
                        </select>
                    </div>
                    <div class="div12inputlv2">
                        <div>
                            <label>Danh mục</label>
                            <span style="opacity: 0;margin-top: -10px;">Thêm danh mục</span>
                        </div>
                        <select name="">
                            <option value="" selected>Chọn danh mục</option>
                        </select>
                    </div>
                    <div class="gioitinh">
                        <h3>Giới tính</h3>
                        <div>
                            <span class="activebutton" onclick="nam2()">Nam</span>
                            <span onclick="nu2()">Nữ</span>
                        </div>
                    </div>
                    <div class="linediv12"></div>
                    <div class="div11submit">
                        <span><i class="fa fa-save"></i>Lưu</span>
                        <span onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản lý</span>
                    </div>
                </div>

                <div class="div12">
                    <h3>Thêm thông tin cho sản phẩm</h3>
                    <div class="linediv12"></div>
                    <div class="div12inputlv2">
                        <div>
                            <label>Size</label>
                        </div>
                        <select name="" id="valuemau">
                            <option value="img/den.webp" selected>Đen</option>
                        </select>
                    </div>
                    <div class="buttondiv12">
                            <span class="buttonthemmau" onclick="themmau2(this)"><i class="fa fa-plus"></i>
                                Thêm
                                màu
                            </span>
                        <span onclick="taomaumoi()">Tạo màu mới</span>
                    </div>
                    <div class="maudachon">
                        <h3>Màu đã chọn</h3>
                        <div class="listMau">
                            <!-- <div class="listMauItem">
                            <div class="listMauItemleft">
                                <div>
                                    <p>Xanh đậm</p>
                                    <div>
                                        <img src="img/xanhdam.webp" alt="">
                                    </div>
                                </div>
                                <div>
                                    <div class="listHinh">
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp1.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp1.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp1.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp1.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp4.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp2.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp3.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp4.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp2.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp3.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                        <div class="listHinhitem">
                                            <img src="../../img/product/dp4.webp" alt="">
                                            <i class="fa fa-close" onclick="removehinhitem(this)"></i>
                                        </div>
                                    </div>
                                    <i class="fa fa-angle-left" onclick="movehinhleft(this)"></i>
                                    <i class="fa fa-angle-right" onclick="movehinhright(this)"></i>
                                    <input type="number" style="display: none;" value="0">
                                </div>
                            </div>
                            <div class="removecolor">
                                <button onclick="themhinh(this)"><i class="fa fa-plus"></i></button>
                                <button onclick="removecolor(this)"><i class="fa fa-trash"></i></button>
                                <input type="file" style="display:none;" onchange="loadIMG(event,this)" />
                            </div>
                        </div> -->
                        </div>
                    </div>
                    <div class="linediv12"></div>
                    <div class="div12inputlv2">
                        <div>
                            <label style="margin-bottom: 10px;">Giới thiệu sản phẩm</label>
                        </div>
                        <span class="buttonthemmau" onclick="themGioiThieu2()"> <i
                                class="fa fa-plus"></i>Thêm giới thiệu</span>
                        <div class="listGioiThieu">
                            <!-- <div class="itemGioiThieu">
                                <input type="text" placeholder="Nhập giới thiệu ở đây">
                                <i class="fa fa-remove" onclick="removeGioiThieu2(this)"></i>
                            </div> -->
                        </div>
                    </div>
                    <div class="linediv12"></div>
                    <div class="div12inputlv2">
                        <div>
                            <label style="margin-bottom: 10px;">Cấu tạo sản phẩm</label>
                        </div>
                        <span class="buttonthemmau" onclick="themCauTao2()"> <i
                                class="fa fa-plus"></i>Thêm cấu tạo</span>
                        <div class="listGioiThieu">
                            <!-- <div class="itemGioiThieu">
                                <input type="text" placeholder="Nhập cấu tạo ở đây">
                                <i class="fa fa-remove" onclick="removeCauTao2(this)"></i>
                            </div> -->
                        </div>
                    </div>
                    <div class="linediv12"></div>
                    <div class="div12inputlv2">
                        <div>
                            <label style="margin-bottom: 10px;">Thông tin sản phẩm</label>
                        </div>
                        <span class="buttonthemmau" onclick="themThongTin2()"> <i
                                class="fa fa-plus"></i>Thêm thông tin</span>
                        <div class="listGioiThieu">
                            <!-- <div class="itemGioiThieu">
                                <input type="text" placeholder="Nhập thông tin ở đây">
                                <i class="fa fa-remove" onclick="removeThongTin2(this)"></i>
                            </div> -->
                        </div>
                    </div>
                </div>

                <div class="div13">
                    <h3>Chọn size</h3>
                    <div class="linediv12"></div>
                    <div class="div12inputlv2">
                        <div>
                            <label>Loại sản phẩm</label>
                        </div>
                        <select name="">
                            <option value="img/den.webp" selected>Áo</option>
                            <option value="">Quần</option>
                        </select>
                    </div>
                    <div class="div12inputlv2">
                        <div>
                            <label>Size</label>
                        </div>
                        <select name="">
                            <option value="S" selected>S</option>
                            <option value="M">M</option>
                            <option value="L">L</option>
                            <option value="XL">XL</option>
                            <option value="XXL">XXL</option>
                            <option value="XXXL">XXXL</option>
                        </select>
                    </div>
                    <span onclick="themsize2(this)"><i class="fa fa-plus"></i> Thêm size</span>
                    <div class="sizedachon">
                        <h3>Size đã chọn</h3>
                        <div class="listSize">
                            <!-- <div class="listSizeItem">
                            <div>
                                <i class="fa fa-circle"></i>
                                <p>M</p>
                            </div>
                            <button onclick="removeSize(this)"><i class="fa fa-trash"></i></button>
                        </div> -->
                        </div>
                    </div>
                </div>

            </div>
            <div

                    <% if(productAdminObject.isIs_sua_don()){ %>

                    <%  }else {%>
                    style="display: none;"
                    <%}%>

            >
                <div class="changeImg">
                    <div class="changeImgTitle">
                        <h3>#sp_1</h3>
                        <h3>Size: M</h3>
                        <h3>Color: Vàng</h3>
                        <input type="file" id="themHinhMoi" style="display: none;" onchange="themHinhMoi(this)">
                        <span onclick="document.getElementById('themHinhMoi').click()"> <i class="fa fa-plus"></i> Thêm hình mới</span>
                        <span onclick="trove()"> <i class="fa fa-back"></i> Trở về</span>
                        <span> <i class="fa fa-save"></i> Lưu</span>
                    </div>
                    <div class="linediv12"></div>
                    <div>
                        <div class="div3size">
                            <div class="div12inputlv2">
                                <div>
                                    <label style="margin-top: 20px;">Size</label>
                                </div>
                                <select name="" id="valueSize">
                                    <option value="S" selected>S</option>
                                    <option value="M">M</option>
                                    <option value="L">L</option>
                                    <option value="XL">XL</option>
                                    <option value="XXL">XXL</option>
                                    <option value="XXXL">XXXL</option>
                                </select>
                            </div>
                            <span onclick="themsize3()"><i class="fa fa-plus"></i> Thêm size</span>
                            <div class="sizedachon">
                                <h3>Size đã chọn</h3>
                                <div class="listSize" id="listSizeDiv3">
                                    <!-- <div class="listSizeItem">
                                    <div>
                                        <i class="fa fa-circle"></i>
                                        <p>M</p>
                                    </div>
                                    <span onclick="removeSize(this)"><i class="fa fa-trash"></i></span>
                                </div> -->
                                </div>
                            </div>
                        </div>
                        <div id="listHinh">
                            <div class="hinhItem">
                                <img src="../../img/1.jpg" alt="">
                                <i class="fa fa-close" onclick="removeHinh(this)"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Quan tâm nhiêu đây thôi-->
</div>

</body>

</html>

<script src="../../js/quanLySanPhamAdmin.js"></script>
<!---------------------------------------------------------------------------------------------------------------------->

<% }

} else {

    //  Tài khoản không có vai trò ở trang này thì ta tới controller điều hướng trang chủ để nó đến trang chủ tương ứng
    response.sendRedirect("../../AdminIndexNavigation");

}
}

    //------------------------------------------------------------------------------------------------------------------------------//

%>
