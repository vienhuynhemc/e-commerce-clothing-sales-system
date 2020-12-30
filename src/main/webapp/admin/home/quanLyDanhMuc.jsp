<%@ page import="beans.category.Category" %>
<%@ page import="worksWithDatabase.category.CategoryWorksWithDatabase" %><%--<%@ page import="beans.category.Category" %>--%>
<%--<%@ page import="worksWithDatabase.category.CategoryWorksWithDatabase" %>--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%-- Created by IntelliJ IDEA. User: Administrator Date: 22/12/2020 Time: 9:00 CH To change this template use File |
    Settings | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        <html>

        <head>

            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>TVTSHOP ADMIN | Quản lý danh mục</title>
            <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">

            <link rel="stylesheet" href="css/indexAdmin.css">
            <script src="js/indexAdmin.js"></script>

            <link rel="stylesheet" href="css/quanLyDanhMucAdmin.css">


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
                                <li><a href="quanLyNVGH.html"> <i class="fa fa-truck"></i> Nhân viên giao hàng</a></li>
                                <li><a href="quanLyNVK.html"><i class="fa fa-cube"></i>Nhân viên kho</a></li>
                                <li><a href="quanLyKhachHang.html"><i class="fa fa-users"></i>Khách hàng</a>
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
                                <li><a href="lichSuNhapHang.html"><i class="fa fa-history"></i>Lịch sử nhập hàng</a>
                                </li>
                            </ul>
                            <input type="checkbox" style="display: none;">
                        </div>
                        <div class="indexleftselectitemlv2" onclick="indexleftselectitemlv2(this)">
                            <div class="indexleftselectitem">
                                <div>
                                    <i class="fa fa-wpforms"></i>
                                    <p>Quản lý sản phẩm</p>
                                </div>
                                <i class="fa fa-angle-right"></i>
                            </div>
                            <ul>
                                <li><a href="quanLySanPham.html"> <i class="fa fa-copy"></i>Sản phẩm</a></li>
                                <li class="activelv2"><a href="quanLyDanhMuc.html"><i
                                            class="fa fa-sticky-note-o"></i>Danh
                                        mục</a></li>
                                <li><a href="quanLyHangSanXuat.html"><i class="fa fa-viadeo-square"></i>Hãng sản
                                        xuất</a></li>
                            </ul>
                            <input type="checkbox" style="display: none;" checked>
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
                                <div class="leftheader">
                                    <form action="FilterCategoryController" method="post">

                                        <select name="sort" id="sort">
                                            <a href="CategoryController?type="><option value="1" selected>Ngày tạo</option></a>
                                            <option value="2" >Tên danh mục</option>
                                            <option value="3" >Mã danh mục</option>
                                            <option value="4" >Số lượng sản phẩm</option>


                                        </select>
                                    </form>
                                    <div>
                                        <div class="leftheadersort" onclick="changesort2(this)">
                                            <i class=" fa fa-sort-amount-desc"></i>
                                            <i class=" fa fa-sort-amount-asc"></i>
                                            <input type="checkbox" style="display: none;">
                                        </div>

                                            <div class="leftheadersearchs">
                                                <i class="fa fa-search" onclick="showsearch2(this)"></i>
                                                <div>
                                                     <i class="fa fa-search" onclick="hiddensearch2(this)"></i>
                                                    <input type="text" placeholder="Tìm kiếm">
<%--                                                     <input type="submit" value="Tìm kiếm">--%>
                                                </div>
                                            </div>
                                    </div>
                                </div>
                                <div class="leftnextpage">
                                    <p>Hiển thị <strong> 13 </strong> trên tổng 135 danh mục</p>
                                    <button><i class="fa fa-caret-left"></i></button>
                                    <ul>
<%--                                        <li>1</li>--%>
<%--                                        <li>2</li>--%>
<%--                                        <li>3</li>--%>
<%--                                        <li>4</li>--%>
<%--                                        <li>5</li>--%>
<%--                                        <li class="none">...</li>--%>
<%--                                        <li>9</li>--%>
                                        <%
                                          //  int numberOfPage = (int) request.getAttribute("numberOfPage");
//                                            ArrayList<Category> list = (ArrayList<Category>) request.getAttribute("list");
                                        %>

                                        <%

                                            for(int i = 0; i< 3;i++){
                                        %>

                                        <a href="CategoryController?vi-tri=<%=(i+1)%>"><li><%= (i+1) %></li></a>

                                        <%}%>

                                    </ul>
                                    <button><i class="fa fa-caret-right"></i></button>
                                </div>
                                <button onclick="themdanhmuc()"><i class="fa fa-plus"></i>Thêm danh mục mới</button>
                                <button onclick="xoacacmuadachon()"><i class="fa fa-trash-o"></i>Xóa các mục đã
                                    chọn</button>
                            </div>
                            <div class="maindiv2" id="maindiv2">
                                <div class="maindiv2header">
                                    <button onclick="allselect()">+</button>
                                    <p>Mã danh mục</p>
                                    <p>Tên danh mục</p>
                                    <p>Số sản phẩm</p>
                                    <p>Ngày tạo</p>
                                </div>

<%--                                <%--%>
<%--                                    for(Category c : CategoryWorksWithDatabase.getCategoriesByIdASC()){%>--%>
                                <c:forEach items="${list}" var="c">
                                <div class="item">
                                    <label for="c1">
                                        <input type="checkbox" name="" id="c1">
                                    </label>
                                    <p>
<%--                                        #<%= c.id%>--%>
                                        #${c.id}
                                    </p>
                                    <p>
<%--                                            <%= c.name %>--%>
                                        ${c.name}
                                    </p>
                                    <p>
                                        24
                                    </p>
                                    <p>
                                         ${c.dateCreated}
<%--                                        <%= c.dateCreated %>--%>
                                    </p>

                                    <div class="itemsubmit" onclick="showselect(this)">
                                        <input type="text" style="display: none;">
                                        <i class="fa fa-circle"></i>
                                        <i class="fa fa-circle"></i>
                                        <i class="fa fa-circle"></i>
                                        <div>

                                           <button type="submit"><a href="admin/home/quanLyDanhMuc(Form_capnhat).jsp?id=${c.id}"> <i class="fa fa-pencil" style="margin-right: 10px"></i>Sửa</a> </button>

                                            <form action="RemoveCategoryController" method="post">

                                                <button type="submit" name="name_C" value=" ${c.id} "><i class="fa fa-trash"></i>Xóa</button>
                                            </form>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="div11"></div>

                                           <div class="div12">
                                               <h3>Điền thông tin danh mục</h3>
                                               <div class="linediv12"></div>
                                               <form action="" method="get">
                                               <div class="div12input">
                                                   <label >* Tên danh mục</label>
                                                   <input type="text" placeholder="Nhập tên danh mục ở đây" id="update"
                                                          value="">
                                               </div>
                                               <div class="linediv12"></div>
                                               <button type="submit"><i class="fa fa-save"></i>Lưu</button>
                                               <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản lý</button>
                                               </form>
                                           </div>

                                        <div class="div13">
                                        </div>
                                    </div>
                                </div>
                                </c:forEach>
<%--                                <% }%>--%>

                            </div>
                        </div>
                    </div>

                    <div id="div1">
                        <div>
                            <div class="div11">
                            </div>


                               <div class="div12">
                                   <h3>Điền thông tin danh mục</h3>
                                   <div class="linediv12"></div>
                                   <form action="AddCategoryController" method="post">
                                   <div class="div12input">
                                       <label >* Tên danh mục</label>
                                       <input type="text" placeholder="Nhập tên danh mục ở đây" name="name" value="">
                                   </div>
                                   <div class="linediv12"></div>
                                   <button type="submit"><i class="fa fa-plus"></i>Thêm danh mục</button>
                                   <button type="button" onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản lý</button>
                                   </form>
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

        <script src="js/quanLyDanhMucAdmin.js"></script>