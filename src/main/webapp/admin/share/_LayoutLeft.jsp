<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 26/12/2020
  Time: 2:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
            <div class="indexleftselectitemlv2 dontactiveindexleftselectitemlv2"
                 onclick="indexleftselectitemlv2(this)">
                <div class="indexleftselectitem">
                    <div>
                        <i class="fa fa-user-o"></i>
                        <p>Quản lý tài khoản</p>
                    </div>
                    <i class="fa fa-angle-right"></i>
                </div>
                <ul>
                    <li><a href="LoadAccountNVVCController?page=1&type=RegisDate&search=&orderBy=DESC"> <i class="fa fa-truck"></i> Nhân viên giao hàng</a></li>
                    <li><a href="LoadAccountNVKController?page=1&type=RegisDate&search=&orderBy=DESC"><i class="fa fa-cube"></i>Nhân viên kho</a></li>
                    <li><a href="LoadAccountKHController?page=1&type=RegisDate&search=&orderBy=DESC"><i class="fa fa-users"></i>Khách hàng</a></li>
                    </li>
                </ul>
                <input type="checkbox" style="display: none;">
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
            <div
                    <%if ((request.getParameter("activeSelect") != null && request.getParameter("activeSelect").equals("quanLyDanhMuc")) ||
                            (request.getParameter("activeSelect") != null && request.getParameter("activeSelect").equals("quanLySanPham"))||
                            (request.getParameter("activeSelect") != null && request.getParameter("activeSelect").equals("quanLyHangSanXuat"))
                    ) {%>
                    class="indexleftselectitemlv2"
                    <%}else{%>
                    class="indexleftselectitemlv2 dontactiveindexleftselectitemlv2"
                    <%}%>

                    onclick="indexleftselectitemlv2(this)">
                <div class="indexleftselectitem">
                    <div>
                        <i class="fa fa-wpforms"></i>
                        <p>Quản lý sản phẩm</p>
                    </div>
                    <i class="fa fa-angle-right"></i>
                </div>
                <ul>
                    <li
                            <%if (request.getParameter("activeSelect") != null && request.getParameter("activeSelect").equals("quanLySanPham")) {%>
                            class="activelv2"
                            <%}%>
                    ><a href="../home/quanLySanPham.jsp"> <i class="fa fa-copy"></i>Sản phẩm</a></li>
                    <li
                            <%if (request.getParameter("activeSelect") != null && request.getParameter("activeSelect").equals("quanLyDanhMuc")) {%>
                            class="activelv2"
                            <%}%>
                    ><a href="quanLyDanhMuc.html"><i class="fa fa-sticky-note-o"></i>Danh
                        mục</a></li>
                    <li
                            <%if (request.getParameter("activeSelect") != null && request.getParameter("activeSelect").equals("quanLyHangSanXuat")) {%>
                            class="activelv2"
                            <%}%>
                    ><a href="../home/quanLyHangSanXuat.jsp"><i class="fa fa-viadeo-square"></i>Hãng
                        sản xuất</a></li>
                </ul>
                <%if ((request.getParameter("activeSelect") != null && request.getParameter("activeSelect").equals("quanLyDanhMuc")) ||
                        (request.getParameter("activeSelect") != null && request.getParameter("activeSelect").equals("quanLySanPham"))||
                        (request.getParameter("activeSelect") != null && request.getParameter("activeSelect").equals("quanLyHangSanXuat"))
                ) {%>
                <input type="checkbox" style="display: none;" checked>
                <%}else{%>
                <input type="checkbox" style="display: none;">
                <%}%>
            </div>
            <a href="../home/quanLyMaGiamGia.jsp" class="indexleftselectitem  ">
                <div <%if (request.getParameter("activeSelect") != null && request.getParameter("activeSelect").equals("quanLyMaGiamGia")) {%>
                        class="active"
                        <%}%>
                >
                    <i class="fa fa-balance-scale"></i>
                    <p>Mã giảm giá</p>
                </div>
            </a>
            <div
                    <%if ((request.getParameter("activeSelect") != null && request.getParameter("activeSelect").equals("guiEmailThongBao")) ||
                            (request.getParameter("activeSelect") != null && request.getParameter("activeSelect").equals("phanHoiLienHe"))
                    ) {%>
                    class="indexleftselectitemlv2"
                    <%}else{%>
                    class="indexleftselectitemlv2 dontactiveindexleftselectitemlv2"
                    <%}%>

                 onclick="indexleftselectitemlv2(this)">
                <div class="indexleftselectitem">
                    <div>
                        <i class="fa fa-envelope-o"></i>
                        <p>Liên hệ</p>
                    </div>
                    <i class="fa fa-angle-right"></i>
                </div>
                <ul>
                    <li
                            <%if (request.getParameter("activeSelect") != null && request.getParameter("activeSelect").equals("guiEmailThongBao")) {%>
                            class="activelv2"
                            <%}%>
                    ><a href="../home/guiEmailThongBao.jsp"> <i class="fa fa-bullhorn"></i>Thông báo</a></li>
                    <li
                            <%if (request.getParameter("activeSelect") != null && request.getParameter("activeSelect").equals("phanHoiLienHe")) {%>
                            class="activelv2"
                            <%}%>
                    ><a href="phanHoiLienHe.html"><i class="fa fa-reply-all"></i>Phản hồi</a></li>
                </ul>
                <%if ((request.getParameter("activeSelect") != null && request.getParameter("activeSelect").equals("guiEmailThongBao")) ||
                        (request.getParameter("activeSelect") != null && request.getParameter("activeSelect").equals("phanHoiLienHe"))
                ) {%>
                <input type="checkbox" style="display: none;" checked>
                <%}else{%>
                <input type="checkbox" style="display: none;">
                <%}%>
            </div>
            <a href="../home/thongTinTaiKhoanAdmin.jsp" class="indexleftselectitem  ">
                <div
                        <%if (request.getParameter("activeSelect") != null && request.getParameter("activeSelect").equals("thongTinTaiKhoanAdmin")) {%>
                        class="active"
                        <%}%>
                >
                    <i class="fa fa-user-circle-o"></i>
                    <p>Thông tin tài khoản</p>
                </div>
            </a>
            <a href="../../index.jsp" class="indexleftselectitem  ">
                <div>
                    <i class="fa fa-shopping-cart"></i>
                    <p>Trở về trang mua sắm</p>
                </div>
            </a>
            <a href="../../LogOutAdminController" class="indexleftselectitem  ">
                <div>
                    <i class="fa fa-power-off"></i>
                    <p>Đăng xuất</p>
                </div>
            </a>
        </div>
    </div>
</div>
