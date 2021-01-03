<%@ page import="beans.account.ErrorAddAccount" %>
<%@ page import="beans.account.ErrorEditAccount" %>
<%@ page import="beans.account.AccountEmployee" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/12/2020
  Time: 9:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVTSHOP ADMIN | Quản lý nhân viên kho</title>
    <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="css/indexAdmin.css">
    <script src="js/indexAdmin.js"></script>
    <script src="js/Truong/jquery/jquery-3.5.1.min.js" ></script>

    <link rel="stylesheet" href="css/quanLyNVKAdmin.css">

    <% ArrayList<AccountEmployee> list = (ArrayList<AccountEmployee>) request.getAttribute("listNVK");%>
    <% ArrayList<String> listRemove = new ArrayList<String>();%>
    <c:url var="xoa-nhan-vien" value="/RemoveAccountNVKController"/>

</head>

<body>


<div class="indexleft">
    <div class="indexleftlogo">
        <i class="fa fa-android"></i>
    </div>
    <div class="indexleftselect">
        <div>
            <a href="../index.html" class="indexleftselectitem  ">
                <div>
                    <i class="fa fa-linode"></i>
                    <p>Trang chủ</p>
                </div>
            </a>
            <a href="thuNhap.html" class="indexleftselectitem  ">
                <div>
                    <i class="fa fa-money"></i>
                    <p>Thu nhập</p>
                </div>
            </a>
            <div class="indexleftselectitemlv2" onclick="indexleftselectitemlv2(this)">
                <div class="indexleftselectitem">
                    <div>
                        <i class="fa fa-user-o"></i>
                        <p>Quản lý tài khoản</p>
                    </div>
                    <i class="fa fa-angle-right"></i>
                </div>
                <ul>
                    <li><a href="quanLyNVGH.jsp"> <i class="fa fa-truck"></i> Nhân viên giao hàng</a></li>
                    <li class="activelv2"><a href="quanLyNVK.jsp"><i class="fa fa-cube"></i>Nhân viên kho</a></li>
                    <li><a href="quanLyKhachHang.jsp"><i class="fa fa-users"></i>Khách hàng</a>
                    </li>
                </ul>
                <input type="checkbox" style="display: none;" checked>
            </div>
            <a href="quanLyBinhLuan.html" class="indexleftselectitem  ">
                <div>
                    <i class="fa fa-comment-o"></i>
                    <p>Quản lý đánh giá</p>
                </div>
            </a>
            <a href="quanLyDonHang.html" class="indexleftselectitem  ">
                <div>
                    <i class="fa fa-file-text-o"></i>
                    <p>Quản lý đơn hàng</p>
                </div>
            </a>
            <div class="indexleftselectitemlv2 dontactiveindexleftselectitemlv2"
                 onclick="indexleftselectitemlv2(this)">
                <div class="indexleftselectitem">
                    <div>
                        <i class="fa fa-object-group"></i>
                        <p>Nhập hàng</p>
                    </div>
                    <i class="fa fa-angle-right"></i>
                </div>
                <ul>
                    <li><a href="nhapHang.html"> <i class="fa fa-cart-arrow-down"></i>Nhập hàng</a></li>
                    <li><a href="lichSuNhapHang.html"><i class="fa fa-history"></i>Lịch sử nhập hàng</a></li>
                </ul>
                <input type="checkbox" style="display: none;">
            </div>
            <div class="indexleftselectitemlv2 dontactiveindexleftselectitemlv2"
                 onclick="indexleftselectitemlv2(this)">
                <div class="indexleftselectitem">
                    <div>
                        <i class="fa fa-wpforms"></i>
                        <p>Quản lý sản phẩm</p>
                    </div>
                    <i class="fa fa-angle-right"></i>
                </div>
                <ul>
                    <li><a href="quanLySanPham.html"> <i class="fa fa-copy"></i>Sản phẩm</a></li>
                    <li><a href="quanLyDanhMuc.html"><i class="fa fa-sticky-note-o"></i>Danh mục</a></li>
                    <li><a href="quanLyHangSanXuat.html"><i class="fa fa-viadeo-square"></i>Hãng sản xuất</a></li>
                </ul>
                <input type="checkbox" style="display: none;">
            </div>
            <a href="quanLyMaGiamGia.html" class="indexleftselectitem  ">
                <div>
                    <i class="fa fa-balance-scale"></i>
                    <p>Mã giảm giá</p>
                </div>
            </a>
            <div class="indexleftselectitemlv2 dontactiveindexleftselectitemlv2"
                 onclick="indexleftselectitemlv2(this)">
                <div class="indexleftselectitem">
                    <div>
                        <i class="fa fa-envelope-o"></i>
                        <p>Liên hệ</p>
                    </div>
                    <i class="fa fa-angle-right"></i>
                </div>
                <ul>
                    <li><a href="guiEmailThongBao.html"> <i class="fa fa-bullhorn"></i>Thông báo</a></li>
                    <li><a href="phanHoiLienHe.html"><i class="fa fa-reply-all"></i>Phản hồi</a></li>
                </ul>
                <input type="checkbox" style="display: none;">
            </div>
            <a href="thongTinTaiKhoanAdmin.html" class="indexleftselectitem  ">
                <div>
                    <i class="fa fa-user-circle-o"></i>
                    <p>Thông tin tài khoản</p>
                </div>
            </a>
            <a href="../../index.html" class="indexleftselectitem  ">
                <div>
                    <i class="fa fa-shopping-cart"></i>
                    <p>Trở về trang mua sắm</p>
                </div>
            </a>
            <a href="login.html" class="indexleftselectitem  ">
                <div>
                    <i class="fa fa-power-off"></i>
                    <p>Đăng xuất</p>
                </div>
            </a>
        </div>
    </div>
</div>

<div class="indexright">
    <div class="indextop">
        <h3>TVT<span style="color: #2a2935;">S</span>hop</h3>
        <div class="indextopright">
            <div class="indextopsearch">
                <i class="fa fa-search"></i>
                <input type="text" placeholder="Tìm kiếm">
            </div>
            <div class="indextopbell  dontindextopbellinfor" onclick="indextopbellinfor(this)">
                <i class="fa fa-bell-o"></i>
                <div>
                    <i class="fa fa-circle"></i>
                </div>
                <div class="indextopbellinfor">
                    <i class="fa fa-caret-up"></i>
                    <div>
                        <h3>Thông báo</h3>
                        <div class="indextopbellinforcontent">
                            <div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar1.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong> Diệu Đặng</strong> vừa thanh toán một đơn hàng</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar2.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong>Hoàng Nguyễn</strong> đánh giá trên trang của bạn</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar3.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong>Sơn</strong> vừa thanh toán một đơn hàng</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar4.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong>Xinh Gái</strong> vừa thanh toán một đơn hàng</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar5.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong>Lê Nguyễn</strong> vừa đánh giá trên trang của bạn</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar6.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong>Hồng Nhan</strong> vừa thanh toán một đơn hàng</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar1.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong> Diệu Đặng</strong> vừa thanh toán một đơn hàng</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar2.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong>Hoàng Nguyễn</strong> đánh giá trên trang của bạn</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar3.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong>Sơn</strong> vừa thanh toán một đơn hàng</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar4.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong>Xinh Gái</strong> vừa thanh toán một đơn hàng</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar5.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong>Lê Nguyễn</strong> vừa đánh giá trên trang của bạn</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar6.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong>Hồng Nhan</strong> vừa thanh toán một đơn hàng</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <input type="checkbox" style="display: none;">
            </div>
            <a class="indextopaccount">
                <div>
                    <img src="../../img/product/avatar7.jpg" alt="">
                </div>
                <div>
                    <h3>Nguyễn Thị Hoa Hồng</h3>
                    <p>Admin</p>
                </div>
            </a>
        </div>
    </div>

    <div class="backgroundindexmain">
    </div>

    <!-- Code trang ở đây-->

    <div class="indexmain">
        <div id="div2">
            <div>
                <div class="header">


                    <!-- code sử lí tìm kiếm ở đây--------------->

                    <form action="LoadAccountNVKController" method="get">
                    <div class="leftheader">
                        <select name="type" >
                            <option value="RegisDate" selected>Ngày tạo</option>
                            <option value="FullName">Họ và tên</option>
                            <option value="UserName">Tài khoản</option>
                            <option value="Salary">Lương</option>
                        </select>
                        <div>
                            <div class="leftheadersort" onclick="changesort2(this)">
                                <i class=" fa fa-sort-amount-desc" onclick="setOrderBy()"></i>
                                <i class=" fa fa-sort-amount-asc" onclick="setOrderBy()"></i>
                                <input type="checkbox" style="display: none;">
                                <input type="hidden" id="checkSort" name="orderBy" value="${param.orderBy}">
                            </div>
                            <div class="leftheadersearch">

                                <button type="submit" class="timkiem" > <i class="fa fa-search" type="submit" ></i></button>
                                <input name="page" value="1" type="hidden">
                                <input type="text" name="search" class="search2" placeholder="Tìm kiếm" value="${param.search}">

                            </div>
                        </div>
                    </div>

                    </form>

                    <div class="leftnextpage">
                        <p>Hiển thị <strong> <%=list.size()%> </strong> trên tổng


                            <%= request.getAttribute("sumEployee") %>

                            nhân viên</p>

                        <a href="LoadAccountNVKController?page=<%= Integer.parseInt(request.getParameter("page"))  - 1%>&type=<%=request.getParameter("type")%>&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>" ><button><i class="fa fa-caret-left"></i></button></a>
                        <ul>

                            <%
                                int listpage = (int) request.getAttribute("numberPage");
                                int nowpage = Integer.parseInt(request.getParameter("page"));
                                for (int i = 1;i <= listpage;i++){
                                    if(i == nowpage){
                            %>
                            <li style="background-color: #4162fb; box-shadow: 0 3px 5px #90a3ff;" ><a href="LoadAccountNVKController?page=<%=i%>&type=<%=request.getParameter("type")%>&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>"> <%=i%> </a></li>

                            <%}else{%>
                            <li ><a href="LoadAccountNVKController?page=<%=i%>&type=<%=request.getParameter("type")%>&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>"> <%=i%> </a></li>
                            <%}}%>

                        </ul>
                        <a href="LoadAccountNVKController?page=<%=Integer.parseInt(request.getParameter("page"))  + 1%>&type=<%=request.getParameter("type")%>&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>">
                            <button><i class="fa fa-caret-right"></i></button>
                        </a>
                    </div>
                    <button onclick="themkhachhang()"><i class="fa fa-plus"></i>Thêm nhân viên mới</button>
                    <button type="button" id="btDelete"> <i class="fa fa-trash-o"></i>Xóa các mục đã chọn</button>
                </div>
                <div class="maindiv2" id="maindiv2">
                    <div class="maindiv2header">
                        <button onclick="allselect()">+</button>
                        <p>Họ và tên</p>
                        <p>Email</p>
                        <p>Số điện thoại</p>
                        <p>Tài khoản</p>
                        <p>Lương</p>
                        <p>Ngày tạo</p>
                    </div>

                    <!--------------------------- load danh sach nhan viên kho -------------------------------->

                    <%

                        for ( AccountEmployee nvk : list  ) {
                    %>

                    <div class="item">
                        <label for="<%=nvk.getIdUser()%>">
                            <input type="checkbox" name="nguoi-dung" id="checkRemove_<%=nvk.getIdUser()%>" value="<%=nvk.getIdUser()%>">
                        </label>
                        <div class="itemhdd">
                            <img src="<%=nvk.getAvatar()%>" alt="">
                        </div>
                        <p class="itemname">
                            <%=nvk.getFullName()%>
                        </p>

                        <p class="itememail">
                            <%=nvk.getEmail()%>
                        </p>

                        <p class="itemphone">
                            <%=nvk.getPhone()%>
                        </p>

                        <p class="itemtk">
                            <%=nvk.getUserName()%>
                        </p>

                        <div></div>
                        <p class="luong"> <%=nvk.getSalary()%> VND</p>

                        <p class="itemdate">
                            <%=nvk.getRegisDate().getDay()%> Tháng <%=nvk.getRegisDate().getMonth()%> <%=nvk.getRegisDate().getYear()%>
                        </p>

                        <div class="itemsubmit" onclick="showselect(this)">
                            <input type="text" style="display: none;">
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <div>
                                <button id="sua" onclick="editkhachhang(this)"><i class="fa fa-pencil"></i>Sửa</button>

                                <button onclick="removekhachhang(this)"><i class="fa fa-trash"></i>Xóa</button>
                            </div>
                        </div>


                        <div>
                            <div class="div11">
                                <h3>Hồ sơ của bạn</h3>
                                <input id="fileInput1" type="file" style="display:none;"
                                       onchange="loadIMG2(event,this)"/>
                                <div class="div11daidien" onclick="document.getElementById('fileInput1').click()">
                                    <div>
                                        <img src="../../img/user.jpg" alt="">
                                    </div>
                                </div>

                                <button onclick="document.getElementById('fileInput1').click()">Thay đổi
                                    ảnh đại diện
                                    mới
                                </button>
                                <button onclick="removeIMG2()">Xóa ảnh đại diện</button>

                            </div>

                            <form action="EditAccountNVKController?IDUser=<%=nvk.getIdUser()%>" method="post">
                                <div class="div12">
                                    <h3>Điền thông tin cá nhân</h3>
                                    <div class="linediv12"></div>
                                    <div class="div12input">
                                        <label for="">* Họ và tên</label>
                                        <input type="text" name="fullName" placeholder="Nhập họ và tên ở đây"
                                               value="<%=nvk.getFullName()%>">
                                    </div>
                                    <div class="div12input">
                                        <label for="">Tên hiển thị</label>
                                        <input type="text" name="displayName" placeholder="Nhập tên hiển thị ở đây"
                                               value="<%=nvk.getDisplayName()%>">
                                    </div>
                                    <div class="div12input">
                                        <label for="">* Email</label>
                                        <input type="text" name="" placeholder="Nhập email ở đây"
                                               value="<%=nvk.getEmail()%>" disabled>
                                    </div>
                                    <div class="div12input">
                                        <label for="">* Số điện thoại</label>
                                        <input type="text" name="" placeholder="Nhập số điện thoại ở đây" value="<%=nvk.getPhone()%>"
                                               disabled>
                                    </div>
                                    <div class="linediv12"></div>
                                    <div class="trangthai">
                                        <div class="div12inputlv2">
                                            <label for="">Tỉnh / Thành</label>
                                            <select name="tinh" >
                                                <option value="">Chọn tỉnh / thành</option>
                                                <option value="" selected>Hưng Yên</option>
                                            </select>
                                        </div>
                                        <div class="div12inputlv2">
                                            <label for="">Quận / huyện</label>
                                            <select name="huyen" id="">
                                                <option value="">Chọn quận / huyện</option>
                                                <option value="" selected>Quận Đại Nam</option>
                                            </select>
                                        </div>
                                        <div class="div12inputlv2">
                                            <label for="">Phường / xã</label>
                                            <select name="xa" id="">
                                                <option value="">Chọn phường / xã</option>
                                                <option value="" selected>Xã Góm Đỏ</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="linediv12"></div>
                                    <div class="div12input">
                                        <label for="">* Tài khoản</label>
                                        <input type="text" placeholder="Nhập tên tài khoản ở đây" value="<%=nvk.getUserName()%>"
                                               disabled>
                                    </div>
                                    <div class="div12input">
                                        <label for="">* Mật khẩu</label>
                                        <input name="passWord" type="password" placeholder="Nhập mật khẩu ở đây" value="">
                                    </div>
                                    <div class="div12input">
                                        <label for="">* Xác nhận</label>
                                        <input name="rePassWord" type="password" placeholder="Xác nhận mật khẩu ở đây" value="">
                                    </div>
                                </div>

                                <div class="div13">
                                    <div class="div12input">
                                        <label for="">* Lương</label>
                                        <input name="salary" type="text" placeholder="Nhập lương ở đây" value="<%=nvk.getSalary()%>">
                                    </div>
                                    <div class="linediv12"></div>
                                    <div class="div12input">
                                        <label for="">Giới thiệu</label>
                                        <input name="info" type="text" placeholder="Nhập số giới thiệu ở đây"
                                               value="<%=nvk.getInfo()%>">
                                    </div>
                                    <div class="linediv12"></div>
                                    <button  type="submit"><i class="fa fa-save"></i>Lưu</button>

                                    <button type="button" onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản
                                        lý
                                    </button>
                                </div>
                            </form>
                        </div>

                    </div>

                    <%}%>




                </div>
            </div>
        </div>


        <!-- Chess hiện bản thông báo cho update nhân viên kho --->

        <!---------------------------------------check---------------------------!>
        <%
            //lấy edit ra nếu khác null chứng tỏ có thằng edit
            if (request.getAttribute("edit") != null) {

                String edit = (String) request.getAttribute("edit");

                //truyển status vào để sử lí
                ErrorEditAccount erroreditAccount = new ErrorEditAccount(edit);

        %>
        <!--lúc request lại thì về lại cái form-->
        <script>
            editkhachhang(document.getElementById("sua"));
        </script>

        <%request.setCharacterEncoding("utf-8");%>
        <jsp:include page="../NotifyErrorAccount/AccountStatus.jsp">
            <jsp:param name="title" value="<%=erroreditAccount.getTitle()%>"/>
            <jsp:param name="content" value="<%=erroreditAccount.getContent()%>"/>
        </jsp:include>

        <%
            }
        %>



        <form action="them-tai-khoan-nhan-vien-kho" method="post">
            <div id="div1">
                <div>
                    <div class="div11">
                        <h3>Hồ sơ của bạn</h3>
                        <input id="fileInput12" type="file" style="display:none;" onchange="loadIMG(event,this)"/>
                        <div class="div11daidien" onclick="document.getElementById('fileInput12').click()">
                            <div>
                                <img src="../../img/user.jpg" alt="">
                            </div>
                        </div>

                        <button onclick="document.getElementById('fileInput12').click()">Thay đổi ảnh đại diện
                            mới
                        </button>
                        <button onclick="removeImg()">Xóa ảnh đại diện</button>

                    </div>

                    <div class="div12">
                        <h3>Điền thông tin cá nhân</h3>
                        <div class="linediv12"></div>
                        <div class="div12input">
                            <label for="">* Họ và tên</label>
                            <input name="full-name" value="${param["full-name"]}" type="text" placeholder="Nhập họ và tên ở đây">
                        </div>
                        <div class="div12input">
                            <label for="">Tên hiển thị</label>
                            <input name="display-name" value="${param["display-name"]}" type="text" placeholder="Nhập tên hiển thị ở đây">
                        </div>
                        <div class="div12input">
                            <label for="">* Email</label>
                            <input name="email" value="${param["email"]}" type="text" placeholder="Nhập email ở đây">
                        </div>
                        <div class="div12input">
                            <label for="">* Số điện thoại</label>
                            <input name="phone" value="${param["phone"]}" type="text" placeholder="Nhập số điện thoại ở đây">
                        </div>
                        <div class="linediv12"></div>
                        <div class="trangthai">
                            <div class="div12inputlv2">
                                <label for="">Tỉnh / Thành</label>
                                <select name="tinh" id="">
                                    <option value=""  >Chọn tỉnh / thành</option>
                                </select>
                            </div>
                            <div class="div12inputlv2">
                                <label for="">Quận / huyện</label>
                                <select name="huyen" id="">
                                    <option value="">Chọn quận / huyện</option>
                                </select>
                            </div>
                            <div class="div12inputlv2">
                                <label for="">Phường / xã</label>
                                <select name="xa" id="">
                                    <option value="">Chọn phường / xã</option>
                                </select>
                            </div>
                        </div>
                        <div class="linediv12"></div>
                        <div class="div12input">
                            <label for="">* Tài khoản</label>
                            <input name="userName" value="${param["userName"]}" type="text" placeholder="Nhập tên tài khoản ở đây">
                        </div>
                        <div class="div12input">
                            <label for="">* Mật khẩu</label>
                            <input name="passWord" type="password" placeholder="Nhập mật khẩu ở đây">
                        </div>
                        <div class="div12input">
                            <label for="">* Xác nhận</label>
                            <input name="rePassWord" type="text" placeholder="Xác nhận mật khẩu ở đây">
                        </div>
                    </div>

                    <div class="div13">
                        <div class="div12input">
                            <label for="">* Lương</label>
                            <input name="salary" type="number" value="${param["salary"]}" placeholder="Nhập lương ở đây">
                        </div>
                        <div class="linediv12"></div>
                        <div class="div12input">
                            <label for="">Giới thiệu</label>
                            <input name="gioi-thieu" type="number" value="${param["gioi-thieu"]}" placeholder="Nhập số giới thiệu ở đây">
                        </div>
                        <div class="linediv12"></div>
                        <button type="submit"><i class="fa fa-plus"></i>Thêm nhân viên</button>
                        <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản lý</button>
                    </div>
                </div>
            </div>
        </form>


        <!---------------------------------------check---------------------------!>
        <%
        //lấy status ra
            if (request.getAttribute("status") != null) {

                String status = (String) request.getAttribute("status");

                //truyển status vào để sử lí
                ErrorAddAccount errorAccount = new ErrorAddAccount(status);

        %>
        <!--lúc request lại thì về lại cái form-->
        <script>
            document.getElementById("div1").style.display = "flex";
            document.getElementById("div2").style.display = "none";
            document.getElementById("div3").style.display = "none";
        </script>

        <%request.setCharacterEncoding("utf-8");%>
        <jsp:include page="../NotifyErrorAccount/AccountStatus.jsp">
            <jsp:param name="title" value="<%=errorAccount.getTitle()%>"/>
            <jsp:param name="content" value="<%=errorAccount.getContent()%>"/>
        </jsp:include>

        <%
            }
        %>


        <div id="div3">
        </div>
    </div>

    <!-- Quan tâm nhiêu đây thôi-->
</div>
<script src="js/Truong/jquery/jquery-3.5.1.min.js" ></script>
</body>

</html>


<script>
    function setOrderBy(){
        if(document.getElementById("checkSort").value == "ASC"){
            document.getElementById("checkSort").value = "DESC";
        }else{
            document.getElementById("checkSort").value = "ASC";
        }
    }

    $('#btDelete').click(function (){
    var data = {};
    var dis = $('#maindiv2 input[type = checkbox]:checked').map(function (){
            return $(this).val();

    }).get();

    data = dis;

    deleteE(data);
    });

    function deleteE(data){
        $.ajax({
            url:'RemoveAccountNVKController',
           contentType:'application/json',
            type:'get',
            data: {
                list: JSON.stringify(data)
            },
            success: function (result){
            window.location.href = "LoadAccountNVKController?page=<%=request.getParameter("page")%>&type=<%=request.getParameter("type")%>&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>";
            },
            error: function (){
                window.location.href = "LoadAccountNVKController?page=<%=request.getParameter("page")%>&type=<%=request.getParameter("type")%>&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>";
            }
        });
    }



</script>

<script src="js/quanLyNVKAdmin.js"></script>
