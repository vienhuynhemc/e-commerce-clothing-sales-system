<%@ page import="beans.loginAdmin.UserAdmin" %>
<%@ page import="beans.loginAdmin.AccountStaffAdmin" %>
<%@ page import="beans.nextPage.NextPageObject" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.nextPage.NextPageConfiguration" %>
<%@ page import="model.salary.SalaryModel" %>
<%@ page import="beans.BeansConfiguration" %>
<%@ page import="beans.quanLyDonHang.*" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/12/2020
  Time: 9:00 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVTSHOP ADMIN | Quản lý đơn hàng nhân viên giao hàng</title>
    <link rel="stylesheet" href="../../fonts/font-awesome-4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="../../css/indexAdmin.css">
    <script src="../../js/indexAdmin.js"></script>

    <link rel="stylesheet" href="../../css/quanLyDonHangAdmin.css">

</head>

<body>

<%
    //----------------------Kiểm tra thử đăng nhập hay chưa và có vai trò ở trang này hay không------------------------------------//
    if(request.getSession().getAttribute("userAdmin") == null) {

        //  Lưu vô session biến trang chờ đợi là trang này để có gì đăng nhập thành công chuyển tới trang này
        request.getSession().setAttribute("trackPage","admin.quanLyDonHangNVGH");

        //  Lưu trackpage xong thì sendredirect tới login
        response.sendRedirect("login.jsp");

    }else{

        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        AccountStaffAdmin accountStaffAdmin = userAdmin.getAccount();
        if(accountStaffAdmin.accept("admin.quanLyDonHangNVGH")){

            QuanLyDonHangObjectNVGH quanLyDonHangObject  = (QuanLyDonHangObjectNVGH) userAdmin.getListOfFunction().get("QuanLyDonHangObjectNVGH");
            if(quanLyDonHangObject == null || !quanLyDonHangObject.isReady()){
                response.sendRedirect("../../QuanLyDonHangControllerNVGH");
            }else {
%>

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
                <p onclick="submitAdd()" id="pFormYesNo">Có, chắc chắn <i class="fa fa-check"></i></p>
                <span onclick="hiddenFormYesNo()" id="buttonNoFormYesNo">Không, suy nghĩ thêm <i class="fa fa-close"></i></span>
            </div>
        </div>
    </div>
</div>

<form action="../../EmailNotificationAddController" method="post" style="display: none" id="fromSubmidAdd">
    <input type="text" name="titleSend" id="titleSend">
    <input type="text" name="dataSend" id="dataSend">
</form>

<%
    //  Nếu như có thông báo thì hiển thị
    if (quanLyDonHangObject.isNotify()) {

        //  Thông báo xong thì để lại trạng thái ban đầu
        quanLyDonHangObject.setNotify(false);

%>
<div id="notifiSuccess">
    <div class="notifiSuccessHidden" onclick="hiddenNotifiSuccess()"></div>
    <div>
        <p>
            <i class="fa fa-cogs"></i> TVT Shop
        </p>
        <div>
            <p><%=quanLyDonHangObject.getTitle()%></p>
            <p><%=quanLyDonHangObject.getConntent()%> <i class="fa fa-hand-grab-o"></i></p>
            <div>
                <span onclick="hiddenNotifiSuccess()">Trở về<i class="fa fa-close"></i></span>
            </div>
        </div>
    </div>
</div>
<%}%>

<jsp:include page="../share/_LayoutLeftNVGH.jsp">
    <jsp:param name="activeSelect" value="quanLyDonHang"/>
</jsp:include>
<div class="indexright">
    <jsp:include page="../share/_LayoutTop.jsp">
        <jsp:param name="level" value="Nhân viên giao hàng"/>
    </jsp:include>

    <!-- Code trang ở đây-->

    <div class="indexmain">
        <div>
            <form class="left" method="post" action="../../QuanLyDonHangControllerNVGH" id="mainForm" onsubmit="return false">
                <div class="leftheader">
                    <select name="selectSearchAndSort" id="selectSearchAndSort" onchange="changeFilter()">
                        <% String selectSearchAndSort = quanLyDonHangObject.getSelectSearchAndSort(); %>
                        <option value="ngay_tao"
                                <% if (selectSearchAndSort != null && selectSearchAndSort.equals("ngay_tao")) {%>
                                selected
                                <%}%>
                        >Ngày tạo</option>
                        <option value="ngay_giao_hang"
                                <% if (selectSearchAndSort != null && selectSearchAndSort.equals("ngay_giao_hang")) {%>
                                selected
                                <%}%>
                        >Ngày giao hàng</option>
                        <option value="tong_tien"
                                <% if (selectSearchAndSort != null && selectSearchAndSort.equals("tong_tien")) {%>
                                selected
                                <%}%>
                        >Tổng tiền</option>
                        <option value="3"
                                <% if (selectSearchAndSort != null && selectSearchAndSort.equals("3")) {%>
                                selected
                                <%}%>
                        >Hoàng thành</option>
                        <option value="0"
                                <% if (selectSearchAndSort != null && selectSearchAndSort.equals("0")) {%>
                                selected
                                <%}%>
                        >Chờ duyệt</option>
                        <option value="1"
                                <% if (selectSearchAndSort != null && selectSearchAndSort.equals("1")) {%>
                                selected
                                <%}%>
                        >Chờ đóng gói</option>
                        <option value="2"
                                <% if (selectSearchAndSort != null && selectSearchAndSort.equals("2")) {%>
                                selected
                                <%}%>
                        >Chờ vận chuyển</option>
                        <option value="4"
                                <% if (selectSearchAndSort != null && selectSearchAndSort.equals("4")) {%>
                                selected
                                <%}%>
                        >Bị hủy</option>
                    </select>
                    <div>
                        <% String sort = quanLyDonHangObject.getSort(); %>

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
                                <i class="fa fa-search" onclick="searchByClick()" ></i>
                                <input type="text" placeholder="Tìm kiếm" name="search" class="searchsubmit"
                                       value="<%=quanLyDonHangObject.getSearch()%>">
                                <i class="fa fa-refresh loadPage" onclick="loadPage()"></i>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="leftnextpage" id="leftnextpage">
                    <span onclick="prePage(<%=quanLyDonHangObject.getNowPage()%>)"><i
                            class="fa fa-caret-left"></i></span>
                    <ul>

                        <%
                            //  Lấy list next page đổ next page ra
                            List<NextPageObject> nextPages = quanLyDonHangObject.getNextPages();
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
                    <span onclick="nextPage(<%=quanLyDonHangObject.getNowPage()%>,<%=quanLyDonHangObject.getMaximumPage()%>)"><i
                            class="fa fa-caret-right"></i></span>
                    <input type="number" name="numberOfPage" id="numberOfPage" style="display: none"
                           value="<%=quanLyDonHangObject.getNowPage()%>">
                    <input type="number" name="maximunNumberOfPage" style="display: none" id="maximunNumberOfPage"
                           value="<%=quanLyDonHangObject.getMaximumPage()%>">
                </div>
                <div>
                    <div id="listleftitem">
                        <%
                            for(QuanLyDonHang quanLyDonHang : quanLyDonHangObject.getList_don_hang()){
                        %>
                        <div class="leftitem" onclick="changerightdonhang(this)">

                            <div>
                                <img src="<%=quanLyDonHang.getNguoi_dat().getLink_hinh()%>" alt="">
                            </div>

                            <div>
                                <p><%=quanLyDonHang.getNguoi_dat().getTen_kh()%></p>
                                <div
                                        <%if(quanLyDonHang.getTrang_thai_van_chuyen() == 0){%>
                                        class="choxuly"
                                        <%}else if(quanLyDonHang.getTrang_thai_van_chuyen() == 1 || quanLyDonHang.getTrang_thai_van_chuyen() == 2){%>
                                        class="vanchuyen"
                                        <%}else if(quanLyDonHang.getTrang_thai_van_chuyen() == 3){%>
                                        class="hoanthanh"
                                        <%}else if(quanLyDonHang.getTrang_thai_van_chuyen() == 4){%>
                                        class="khonghoanthanh"
                                        <%}%>
                                >
                                    <i class="fa fa-circle"></i>
                                    <p>
                                        <%if(quanLyDonHang.getTrang_thai_van_chuyen() == 0){%>
                                        Chờ xử lý
                                        <%}else if(quanLyDonHang.getTrang_thai_van_chuyen() == 1){%>
                                        Đóng gói
                                        <%}else if(quanLyDonHang.getTrang_thai_van_chuyen() == 2){%>
                                        Vận chuyển
                                        <%}else if(quanLyDonHang.getTrang_thai_van_chuyen() == 3){%>
                                        Hoàn thành
                                        <%}else if(quanLyDonHang.getTrang_thai_van_chuyen() == 4){%>
                                        Bị hủy
                                        <%}%>
                                    </p>
                                </div>
                            </div>

                            <div>
                                <p> <%=SalaryModel.getInstance().coverSalaryToString(quanLyDonHang.getTong_tien())%></p>
                                <p>#<%=quanLyDonHang.getMa_dh()%></p>
                            </div>

                            <div>
                                <h3>Đơn Đặt Hàng</h3>
                                <p>#<%=quanLyDonHang.getMa_dh()%></p>
                                <p><i class="fa fa-circle"></i> <%if(quanLyDonHang.getTrang_thai_van_chuyen() == 0){%>
                                    Chờ xử lý
                                    <%}else if(quanLyDonHang.getTrang_thai_van_chuyen() == 1){%>
                                    Đóng gói
                                    <%}else if(quanLyDonHang.getTrang_thai_van_chuyen() == 2){%>
                                    Vận chuyển
                                    <%}else if(quanLyDonHang.getTrang_thai_van_chuyen() == 3){%>
                                    Hoàn thành
                                    <%}else if(quanLyDonHang.getTrang_thai_van_chuyen() == 4){%>
                                    Không hoàn thành
                                    <%}%></p>
                                <div>
                                    <div class="dateright">
                                        <i class="fa fa-file-text"></i>
                                        <div>
                                            <p>Ngày đặt hàng</p>
                                            <p><%=quanLyDonHang.getNgay_dat().toStringDateTypeNumberStringNumber()%></p>
                                        </div>
                                    </div>
                                    <div class="dateright">
                                        <i class="fa fa-truck"></i>
                                        <div>
                                            <p>Ngày giao hàng</p>
                                            <p>
                                                <%if(quanLyDonHang.getNgay_gui() == null){%>
                                                Đơn hàng chưa được giao
                                                <%}else{%>
                                                <%=quanLyDonHang.getNgay_gui().toStringDateTypeNumberStringNumber()%>
                                                <%}%>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="table">

                                    <div class="tableheader">
                                        <p>Sản phẩm & mô tả</p>
                                        <p>Duyệt</p>
                                        <p>Đóng gói</p>
                                        <p>Vận chuyển</p>
                                        <p>Giá lẻ</p>
                                        <p>Tổng giá</p>
                                    </div>

                                    <div>
                                        <div>
                                            <%for(SanPhamDatHang sanPhamDatHang : quanLyDonHang.getList_sp()){%>
                                            <div class="tableitem">
                                                <div class="tableitemimg">
                                                    <div>
                                                        <img src="<%=sanPhamDatHang.getHinh_anh()%>" alt="">
                                                    </div>
                                                    <div>
                                                        <div>
                                                            <p><%=sanPhamDatHang.getSo_luong()%></p>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="tablenitemame">
                                                    <p><%=sanPhamDatHang.getTen_sp()%></p>
                                                    <p>Mã sản phẩm: <%=sanPhamDatHang.getMa_sp()%></p>
                                                </div>
                                                <div class="tableitemicon <%if(quanLyDonHang.getNguoi_duyet() == null){%>choxuly<%}else{%>hoanthanh<%}%>  ">
                                                    <div>
                                                        <i class="fa fa-clock-o"></i>
                                                    </div>
                                                    <div>
                                                        <i class="fa fa-check-circle"></i>
                                                    </div>
                                                    <div>
                                                        <i class="fa fa-close"></i>
                                                    </div>
                                                </div>
                                                <div class="tableitemicon <%if(quanLyDonHang.getNguoi_dong_goi() == null){%>choxuly<%}else{%>hoanthanh<%}%> ">
                                                    <div>
                                                        <i class="fa fa-clock-o"></i>
                                                    </div>
                                                    <div>
                                                        <i class="fa fa-check-circle"></i>
                                                    </div>
                                                    <div>
                                                        <i class="fa fa-close"></i>
                                                    </div>
                                                </div>
                                                <div class="tableitemicon <%if(quanLyDonHang.getNguoi_van_chuyen() == null){%>choxuly<%}else if(quanLyDonHang.getTrang_thai_van_chuyen()==4) {%>khonghoanthanh<%}else{%>hoanthanh<%}%> ">
                                                    <div>
                                                        <i class="fa fa-clock-o"></i>
                                                    </div>
                                                    <div>
                                                        <i class="fa fa-check-circle"></i>
                                                    </div>
                                                    <div>
                                                        <i class="fa fa-close"></i>
                                                    </div>
                                                </div>
                                                <p><%=SalaryModel.getInstance().coverSalaryToString(sanPhamDatHang.getGia_le())%></p>
                                                <p><%=SalaryModel.getInstance().coverSalaryToString(sanPhamDatHang.getTong_gia())%></p>
                                            </div>
                                            <%}%>
                                        </div>
                                    </div>

                                </div>

                                <div class="nguoimua">
                                    <h3>Người đặt</h3>
                                    <div>
                                        <img src="<%=quanLyDonHang.getNguoi_dat().getLink_hinh()%>" alt="">
                                    </div>
                                    <p><%=quanLyDonHang.getNguoi_dat().getTen_kh()%></p>
                                    <p><strong>Email: </strong><%=quanLyDonHang.getNguoi_dat().getEmail()%></p>
                                    <p><strong>Số điện thoại: </strong><%=quanLyDonHang.getNguoi_dat().getSo_dien_thoai()%></p>
                                    <p><strong>Địa chỉ: </strong><%=quanLyDonHang.getNguoi_dat().getDia_chi()%></p>
                                </div>

                                <div class="nguoimua">
                                    <h3>Người đóng gói</h3>
                                    <div>
                                        <img src="<%if(quanLyDonHang.getNguoi_dong_goi() == null){%> <%=BeansConfiguration.LINK_AVATAR_DEFAULT%> <%}else{%><%=quanLyDonHang.getNguoi_dong_goi().getLink_hinh()%> <%}%>" alt="">
                                    </div>
                                    <p><%if(quanLyDonHang.getNguoi_dong_goi() == null){%>???<%}else{%><%=quanLyDonHang.getNguoi_dong_goi().getTen_kh()%> <%}%></p>
                                    <p><strong>Email: </strong><%if(quanLyDonHang.getNguoi_dong_goi() == null){%>???<%}else{%><%=quanLyDonHang.getNguoi_dong_goi().getEmail()%> <%}%></p>
                                    <p><strong>Số điện thoại: </strong><%if(quanLyDonHang.getNguoi_dong_goi() == null){%>???<%}else{%> <%=quanLyDonHang.getNguoi_dong_goi().getSo_dien_thoai()%><%}%></p>
                                    <p><strong>Địa chỉ: </strong><%if(quanLyDonHang.getNguoi_dong_goi() == null){%>???<%}else{%><%=quanLyDonHang.getNguoi_dong_goi().getDia_chi()%><%}%></p>
                                </div>

                                <div class="nguoimua">
                                    <h3>Người giao hàng</h3>
                                    <div>
                                        <img src="<%if(quanLyDonHang.getNguoi_van_chuyen() == null){%><%=BeansConfiguration.LINK_AVATAR_DEFAULT%><%}else{%><%=quanLyDonHang.getNguoi_van_chuyen().getLink_hinh()%><%}%>" alt="">
                                    </div>
                                    <p><%if(quanLyDonHang.getNguoi_van_chuyen() == null){%>???<%}else{%><%=quanLyDonHang.getNguoi_van_chuyen().getTen_kh()%><%}%></p>
                                    <p><strong>Email: </strong><%if(quanLyDonHang.getNguoi_van_chuyen() == null){%>???<%}else{%> <%=quanLyDonHang.getNguoi_van_chuyen().getEmail()%> <%}%></p>
                                    <p><strong>Số điện thoại: </strong><%if(quanLyDonHang.getNguoi_van_chuyen() == null){%>???<%}else{%><%=quanLyDonHang.getNguoi_van_chuyen().getSo_dien_thoai()%><%}%></p>
                                    <p><strong>Địa chỉ: </strong><%if(quanLyDonHang.getNguoi_van_chuyen() == null){%>???<%}else{%><%=quanLyDonHang.getNguoi_van_chuyen().getDia_chi()%> <%}%></p>
                                </div>

                                <%if(quanLyDonHang.getTrang_thai_van_chuyen() == 2){%>
                                <div class="kiemduyet">
                                    <div>
                                        <select name="ma_nv">
                                            <option value="3">Hoàn thành</option>
                                            <option value="4">Không hoàn thành</option>
                                        </select>
                                        <button onclick="duyetHang3(this)">Duyệt</button>
                                        <input type="text" name="ma_dh" value="<%=quanLyDonHang.getMa_dh()%>" style="display: none">
                                    </div>
                                </div>
                                <%}%>
                            </div>


                        </div>
                        <%}%>
                    </div>
                </div>
                <!-- action -->
                <input type="text" name="action" style="display: none" id="action" value="">

                <!-- sort -->
                <% if (sort.equals("DESC")) {%>
                <input type="checkbox" style="display: none" name="sort" id="sort">
                <% } else {%>
                <input type="checkbox" style="display: none" name="sort" id="sort" checked>
                <%}%>
            </form>
            <div class="right" id="right">
            </div>
        </div>
    </div>

    <!-- Quan tâm nhiêu đây thôi-->
</div>

</body>

</html>
<script src="../../js/quanLyDonHangAdmin.js"></script>
<%     }

}else{

    //  Tài khoản không có vai trò ở trang này thì ta tới controller điều hướng trang chủ để nó đến trang chủ tương ứng
    response.sendRedirect("../../AdminIndexNavigation");

}
}

    //------------------------------------------------------------------------------------------------------------------------------//

%>

