<%--
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

<jsp:include page="../share/_LayoutLeft.jsp" />

<div class="indexright">

    <jsp:include page="../share/_LayoutTop.jsp"/>

    <!-- Code trang ở đây-->

    <div class="indexmain">
        <div id="div2">
            <div>
                <div class="header">
                    <div class="leftheader">
                        <select name="" id="">
                            <option value="" selected>Ngày tạo</option>
                            <option value="">Tên hãng</option>
                            <option value="">Mã hãng</option>
                            <option value="">Số lượng thông tin</option>
                            <option value="">Số lượng sản phẩm</option>
                        </select>
                        <div>
                            <div class="leftheadersort" onclick="changesort2(this)">
                                <i class=" fa fa-sort-amount-desc"></i>
                                <i class=" fa fa-sort-amount-asc"></i>
                                <input type="checkbox" style="display: none;">
                            </div>
                            <div class="leftheadersearch">
                                <i class="fa fa-search" onclick="showsearch2(this)"></i>
                                <div>
                                    <i class="fa fa-search" onclick="hiddensearch2(this)"></i>
                                    <input type="text" placeholder="Tìm kiếm">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="leftnextpage">
                        <p>Hiển thị <strong> 13 </strong> trên tổng 135 hãng</p>
                        <button><i class="fa fa-caret-left"></i></button>
                        <ul>
                            <li>1</li>
                            <li>2</li>
                            <li>3</li>
                            <li>4</li>
                            <li>5</li>
                            <li class="none">...</li>
                            <li>9</li>
                        </ul>
                        <button><i class="fa fa-caret-right"></i></button>
                    </div>
                    <button onclick="themdanhmuc()"><i class="fa fa-plus"></i>Thêm hãng mới</button>
                    <button onclick="xoacacmuadachon()"><i class="fa fa-trash-o"></i>Xóa các mục đã chọn</button>
                </div>
                <div class="maindiv2" id="maindiv2">
                    <div class="maindiv2header">
                        <button onclick="allselect()">+</button>
                        <p>Mã hãng</p>
                        <p>Tên hãng</p>
                        <p>Thông tin</p>
                        <p>Sản phẩm</p>
                        <p>Ngày tạo</p>
                    </div>

                    <div class="item">
                        <label for="c1">
                            <input type="checkbox" name="" id="c1">
                        </label>
                        <p>
                            #hsx_1
                        </p>
                        <p>
                            Seven AM - Sang trọng, quyến rũ với chất liệu ngoại nhập
                        </p>

                        <p>
                            3
                        </p>

                        <p>
                            42
                        </p>

                        <p>
                            25 Tháng Mười Một 2020
                        </p>

                        <div class="itemsubmit" onclick="showselect(this)">
                            <input type="text" style="display: none;">
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <div>
                                <button onclick="editdanhmuc(this)"><i class="fa fa-pencil"></i>Sửa</button>
                                <button onclick="removekhachhang(this)"><i class="fa fa-trash"></i>Xóa</button>
                            </div>
                        </div>
                        <div>
                            <div class="div11">
                            </div>

                            <div class="div12">
                                <h3>Điền thông tin hãng sản xuất </h3>
                                <div class="linediv12"></div>
                                <div class="div12input">
                                    <label for="">* Tên hãng</label>
                                    <input type="text" placeholder="Nhập tên hãng sản xuất ở đây">
                                </div>
                                <div class="linediv12"></div>
                                <button onclick="themitemchitiet(this)"><i class="fa fa-plus"></i> Thêm chi tiết mới
                                </button>
                                <div class="listItemChiTiet">
                                    <div class="itemchitiet">
                                        *<input type="text" required placeholder="Nhập chi tiết ở đây"> <i
                                            onclick="removeitemchitiet(this)" class="fa fa-close"></i>
                                    </div>
                                    <div class="itemchitiet">
                                        *<input type="text" required placeholder="Nhập chi tiết ở đây"> <i
                                            onclick="removeitemchitiet(this)" class="fa fa-close"></i>
                                    </div>
                                    <div class="itemchitiet">
                                        *<input type="text" required placeholder="Nhập chi tiết ở đây"> <i
                                            onclick="removeitemchitiet(this)" class="fa fa-close"></i>
                                    </div>
                                </div>
                                <div class="linediv12"></div>
                                <button><i class="fa fa-plus"></i>Thêm danh mục</button>
                                <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản lý</button>
                            </div>
                            <div class="div13">
                            </div>
                        </div>
                    </div>

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
                        <label for="">* Tên hãng</label>
                        <input type="text" placeholder="Nhập tên hãng sản xuất ở đây">
                    </div>
                    <div class="linediv12"></div>
                    <button onclick="themitemchitiet2(this)"><i class="fa fa-plus"></i> Thêm chi tiết mới</button>
                    <div class="listItemChiTiet">
                    </div>
                    <div class="linediv12"></div>
                    <button><i class="fa fa-plus"></i>Thêm danh mục</button>
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