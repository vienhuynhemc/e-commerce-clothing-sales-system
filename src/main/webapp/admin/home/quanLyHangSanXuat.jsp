<%@ page import="beans.manufacturer.Manufacturer" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.nextPage.NextPageObject" %>
<%@ page import="beans.nextPage.NextPageConfiguration" %>
<%@ page import="beans.manufacturer.ManufacturerObject" %>
<%@ page import="beans.loginAdmin.UserAdmin" %>
<%@ page import="beans.loginAdmin.AccountStaffAdmin" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 26/12/2020
  Time: 1:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVTSHOP ADMIN | Quản lý hãng sản xuất</title>
    <link rel="stylesheet" href="../../fonts/font-awesome-4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="../../css/indexAdmin.css">
    <script src="../../js/indexAdmin.js"></script>

    <link rel="stylesheet" href="../../css/quanLyHangSanXuatAdmin.css">


</head>

<body>


<%
    //----------------------Kiểm tra thử đăng nhập hay chưa và có vai trò ở trang này hay không------------------------------------//
    if(request.getSession().getAttribute("userAdmin") == null) {

        //  Lưu vô session biến trang chờ đợi là trang này để có gì đăng nhập thành công chuyển tới trang này
        request.getSession().setAttribute("trackPage","admin.quanLyHangSanXuat");

        //  Lưu trackpage xong thì sendredirect tới login
        response.sendRedirect("login.jsp");

    }else{

        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        AccountStaffAdmin accountStaffAdmin = userAdmin.getAccount();
        if(accountStaffAdmin.accept("admin.quanLyHangSanXuat")){

            ManufacturerObject manufacturerObject = (ManufacturerObject) userAdmin.getListOfFunction().get("manufacturerObject");
            if(manufacturerObject == null || !manufacturerObject.isReady()){
                response.sendRedirect("../../ManufacturerController");
            }else {
%>


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
    if (manufacturerObject.isNotify()) {

        //  Thông báo xong thì để lại trạng thái ban đầu
        manufacturerObject.setNotify(false);

%>
<div id="notifiSuccess">
    <div class="notifiSuccessHidden" onclick="hiddenNotifiSuccess()"></div>
    <div>
        <p>
            <i class="fa fa-cogs"></i> TVT Shop
        </p>
        <div>
            <p><%=manufacturerObject.getTitle()%></p>
            <p><%=manufacturerObject.getConntent()%> <i class="fa fa-hand-grab-o"></i></p>
            <div>
                <span onclick="hiddenNotifiSuccess()">Trở về<i class="fa fa-close"></i></span>
            </div>
        </div>
    </div>
</div>
<%}%>
<!------------------------------------------------------------------------------------------------------------------->

<jsp:include page="../share/_LayoutLeft.jsp">
<jsp:param name="activeSelect" value="quanLyHangSanXuat"/>
</jsp:include>

<div class="indexright">

    <jsp:include page="../share/_LayoutTop.jsp"/>

    <!-- Code trang ở đây-->

    <div class="indexmain">
        <div id="div2">
            <div>
                <form class="header" method="post" action="../../ManufacturerController" id="mainForm"
                      onsubmit="return false">
                    <div class="leftheader">
                        <select name="selectSearchAndSort" id="selectSearchAndSort" onchange="changeFilter()">

                            <% String selectSearchAndSort = manufacturerObject.getSelectSearchAndSort(); %>
                            <option value="dateCreated"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("dateCreated")) {%>
                                    selected
                                    <%}%>
                            >Ngày tạo
                            </option>
                            <option value="manufacturerName"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("manufacturerName")) {%>
                                    selected
                                    <%}%>
                            >Tên hãng
                            </option>
                            <option value="manufacturerId"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("manufacturerId")) {%>
                                    selected
                                    <%}%>
                            >Mã hãng
                            </option>
                            <option value="informationList"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("informationList")) {%>
                                    selected
                                    <%}%>
                            >Số lượng thông tin
                            </option>
                            <option value="numberOfProducts"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("numberOfProducts")) {%>
                                    selected
                                    <%}%>
                            >Số lượng sản phẩm
                            </option>
                        </select>
                        <div>

                            <% String sort = manufacturerObject.getSort(); %>

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
                                    <i class="fa fa-search"></i>
                                    <input type="text" placeholder="Tìm kiếm" name="search" class="searchsubmit"
                                           value="<%=manufacturerObject.getSearch()%>">
                                    <i class="fa fa-refresh loadPage" onclick="loadPage()"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="leftnextpage" id="leftnextpage">
                        <p>Hiển thị <strong><%= manufacturerObject.getNumberOfShow() %>
                        </strong> trên tổng <%=manufacturerObject.getMaximumManufacturer()%> hãng</p>
                        <span onclick="prePage(<%=manufacturerObject.getNowPage()%>)"><i
                                class="fa fa-caret-left"></i></span>
                        <ul>

                            <%
                                //  Lấy list next page đổ next page ra
                                List<NextPageObject> nextPages = manufacturerObject.getNextPages();
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
                        <span onclick="nextPage(<%=manufacturerObject.getNowPage()%>,<%=manufacturerObject.getMaximumPage()%>)"><i
                                class="fa fa-caret-right"></i></span>
                        <input type="number" name="numberOfPage" id="numberOfPage" style="display: none"
                               value="<%=manufacturerObject.getNowPage()%>">
                        <input type="number" name="maximunNumberOfPage" style="display: none" id="maximunNumberOfPage"
                               value="<%=manufacturerObject.getMaximumPage()%>">
                    </div>
                    <span onclick="themdanhmuc()"><i class="fa fa-plus"></i>Thêm hãng mới</span>
                    <span onclick="xoacacmuadachon()"><i class="fa fa-trash-o"></i>Xóa các mục đã chọn</span>

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
                        <p>Mã hãng</p>
                        <p>Tên hãng</p>
                        <p>Thông tin</p>
                        <p>Sản phẩm</p>
                        <p>Ngày tạo</p>
                    </div>

                    <%

                        //  Đổ dữ liệu list sản hãng sản xuất
                        List<Manufacturer> manufacturers = manufacturerObject.getManufacturers();

                        for (Manufacturer m : manufacturers) {

                    %>
                    <div class="item">
                        <label for="c1">
                            <input type="checkbox" name="" id="c1">
                            <input type="text" style="display: none" value="<%=m.getManufacturerId()%>">
                        </label>
                        <p>
                            #<%= m.getManufacturerId() %>
                        </p>
                        <p>
                            <%= m.getManufacturerName() %>
                        </p>

                        <p>
                            <%= m.getInformationList().size() %>
                        </p>

                        <p>
                            <%= m.getNumberOfProduct() %>
                        </p>

                        <p>
                            <%= m.getDateCreated().toStringDateTypeNumberStringNumber() %>
                        </p>

                        <div class="itemsubmit" onclick="showselect(this)">
                            <input type="text" style="display: none;">
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <div>
                                <button onclick="editdanhmuc(this)"><i class="fa fa-pencil"></i>Sửa</button>
                                <button onclick="removekhachhang(this)"><i class="fa fa-trash"></i>Xóa</button>
                                <input type="text" style="display: none" value="<%=m.getManufacturerId()%>">
                            </div>
                        </div>
                        <div>
                            <div class="div11">
                            </div>

                            <div class="div12">
                                <h3>Điền thông tin hãng sản xuất </h3>
                                <div class="linediv12"></div>
                                <div class="div12input">
                                    <label>* Tên hãng</label>
                                    <input type="text" placeholder="Nhập tên hãng sản xuất ở đây"
                                           value="<%=m.getManufacturerName()%>">
                                    <input type="text" style="display: none" value="<%=m.getManufacturerId()%>">
                                </div>
                                <div class="linediv12"></div>
                                <button onclick="themitemchitiet(this)"><i class="fa fa-plus"></i> Thêm chi tiết mới
                                </button>
                                <div class="listItemChiTiet">

                                    <%
                                        // Đổ list thông tin của từng hãng
                                        List<String> informationList = m.getInformationList();

                                        for (String s : informationList) {

                                    %>
                                    <div class="itemchitiet">
                                        *<input type="text" required placeholder="Nhập chi tiết ở đây" value="<%=s%>">
                                        <i
                                                onclick="removeitemchitiet(this)" class="fa fa-close"></i>
                                    </div>

                                    <%
                                            //  Kết thúc đổ list thông tin của từng hãng
                                        }

                                    %>

                                </div>
                                <div class="linediv12"></div>
                                <button onclick="capnhap()"><i class="fa fa-save"></i>Lưu</button>
                                <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản lý</button>
                            </div>
                            <div class="div13">
                            </div>
                        </div>
                    </div>
                    <%
                            // End đổ dữ liệu list hãng sản xuất
                        }

                    %>

                </div>
            </div>
        </div>

        <div id="div1">
            <div>
                <div class="div11">
                </div>

                <div class="div12">
                    <h3>Điền thông tin hãng sản xuất </h3>
                    <div class="linediv12"></div>
                    <div class="div12input">
                        <label>* Tên hãng</label>
                        <input type="text" placeholder="Nhập tên hãng sản xuất ở đây" id="">
                    </div>
                    <div class="linediv12"></div>
                    <button onclick="themitemchitiet2(this)"><i class="fa fa-plus"></i> Thêm chi tiết mới</button>
                    <div class="listItemChiTiet">
                    </div>
                    <div class="linediv12"></div>
                    <button onclick="themmoi()"><i class="fa fa-plus"></i>Thêm danh mục</button>
                    <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản lý</button>
                </div>
                <div class="div13">
                </div>
            </div>
        </div>

        <div id="div3">
        </div>
    </div>

    <!-- Quan tâm nhiêu đây thôi-->
</div>

</body>

</html>

<script src="../../js/quanLyHangSanXuatAdmin.js"></script>
<%     }

}else{

    //  Tài khoản không có vai trò ở trang này thì ta tới controller điều hướng trang chủ để nó đến trang chủ tương ứng
    response.sendRedirect("../../AdminIndexNavigation");

}
}

    //------------------------------------------------------------------------------------------------------------------------------//

%>


