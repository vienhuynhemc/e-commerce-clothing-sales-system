<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/12/2020
  Time: 9:10 CH
  To change this template use File | Settings | File Templates.
--%>
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

<div id="taomaumoi">
    <div onclick="taomauxong()"></div>
    <div class="divmau">
        <div>
            <input id="sm" type="file" style="display:none;" onchange="loadIMGMau(event)"/>
            <div>
                <img id="psm" src="img/den.webp" alt="">
            </div>
            <button onclick="document.getElementById('sm').click()">Chọn màu</button>
        </div>
        <div>
            <div class="div12inputlv2">
                <div>
                    <label for="">Tên màu</label>
                </div>
                <input type="text" placeholder="Nhập tên màu ở đây">
            </div>
            <button>Tạo màu</button>
            <button onclick="taomauxong()">Trở lại</button>
        </div>
    </div>
</div>

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
                    <li><a href="lichSuNhapHang.html"><i class="fa fa-history"></i>Lịch sử nhập hàng</a></li>
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
                    <li class="activelv2"><a href="quanLySanPham.html"> <i class="fa fa-copy"></i>Sản phẩm</a></li>
                    <li><a href="quanLyDanhMuc.html"><i class="fa fa-sticky-note-o"></i>Danh
                        mục</a></li>
                </ul>
                <input type="checkbox" style="display: none;" checked>
            </div>
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
                        <select name="" id="">
                            <option value="" selected>Ngày tạo</option>
                            <option value="">Tên danh mục</option>
                            <option value="">Tên sản phẩm</option>
                            <option value="">Số lượng còn lại</option>
                            <option value="">Giá</option>
                            <option value="">Số màu</option>
                            <option value="">Số size</option>
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
                        <p>Hiển thị <strong> 10 </strong> trên tổng 98 sản pẩm</p>
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
                    <button onclick="themsanphammoi()"><i class="fa fa-plus"></i>Thêm sản phẩm mới</button>
                    <button onclick="xoacacmuadachon()"><i class="fa fa-trash-o"></i>Xóa các mục đã chọn</button>
                </div>
                <div class="maindiv2" id="maindiv2">
                    <div class="maindiv2header">
                        <button onclick="allselect()">+</button>
                        <p>Tên sản phẩm</p>
                        <p>Tên danh mục</p>
                        <p>Size</p>
                        <p>Màu</p>
                        <p>Giá</p>
                        <p>Số lượng</p>
                        <p>Ngày tạo</p>
                    </div>

                    <div class="item">
                        <label for="c1">
                            <input type="checkbox" name="" id="c1">
                        </label>

                        <div class="itemhdd">
                            <img src="../../img/product/dp1.webp" alt="">
                        </div>

                        <p class="itemname">
                            Quần Jeans Nữ Tưa Lai Túi Lệch WJL 4011
                        </p>

                        <p class="itemtdm">
                            Quần jean
                        </p>

                        <div class="itemsize">
                            <div>
                                <p>S</p>
                            </div>
                            <div>
                                <p>M</p>
                            </div>
                        </div>

                        <div class="itemsize">
                            <div>
                                <img src="../../img/product/damxanh.webp" alt="">
                            </div>
                            <div>
                                <img src="../../img/product/xanhnhat.webp" alt="">
                            </div>
                        </div>

                        <p class="itemgia">
                            319,000 VND
                        </p>

                        <p class="itemsol">38</p>

                        <p class="itemngaytao">
                            20 Tháng Mưới 2020
                        </p>


                        <div class="itemsubmit" onclick="showselect(this)">
                            <input type="text" style="display: none;">
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <div>
                                <button onclick="editkhachhang(this)"><i class="fa fa-pencil"></i>Sửa</button>
                                <button onclick="removekhachhang(this)"><i class="fa fa-trash"></i>Xóa</button>
                            </div>
                        </div>

                        <div>
                            <div class="div11">
                                <h3>Thông tin sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Tên sản phẩm</label>
                                    </div>
                                    <input type="text" placeholder="Nhập tên sản phẩm ở đây"
                                           value="Quần Jeans Nữ Tưa Lai Túi Lệch WJL 4011">
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Hãng sản xuất</label>
                                        <div style="width: 10px;height: 25px;"></div>
                                    </div>
                                    <select name="" id="">
                                        <option value="">Chọn hãng sản xuất</option>
                                        <option value="" selected>Juno - Thương hiệu thời trang cao cấp</option>
                                        <option value="">An Phước – Tỉ mỉ trong từng đường kim mũi chỉ</option>
                                        <option value="">Việt Tiến - Thương hiệu của sự khẳng định</option>
                                        <option value="">NOVELTY - Vẻ đẹp của người Việt được tôn vinh</option>
                                        <option value="">BLUE EXCHANGE - Cuộc sống được làm đẹp</option>
                                        <option value="">May 10 - Thương hiệu của bảy thập kỉ</option>
                                        <option value="">PT2000 - Thời trang dành cho giới trẻ</option>
                                        <option value="">SEA Collection - Chuyên cung cấp các mặt hàng thời trang
                                            trẻ.
                                        </option>
                                        <option value="">Ninomaxx - Thương hiệu thời trang hàng đầu</option>
                                        <option value="">Nem Fashion</option>
                                        <option value="">ELISE</option>
                                        <option value="">Ivy Moda</option>
                                        <option value="">Chic-Land</option>
                                        <option value="">Owen</option>
                                        <option value="">Seven AM</option>
                                    </select>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Danh mục</label>
                                        <a href="quanLyDanhMuc.html">Thêm danh mục</a>
                                    </div>
                                    <select name="" id="">
                                        <option value="">Chọn danh mục</option>
                                        <option value="">Áo thun nữ</option>
                                        <option value="">Áo thun tay dài</option>
                                        <option value="">Áo phong</option>
                                        <option value="">Áo len</option>
                                        <option value="">Áo sơ mi</option>
                                        <option value="">Áo khoác</option>
                                        <option value="" selected>Quần jean</option>
                                        <option value="">Quần kaki</option>
                                        <option value="">Quần shorts</option>
                                        <option value="">Quần vải</option>
                                        <option value="">Đồ mặc nhà</option>
                                        <option value="">Quần áo thể thao</option>
                                        <option value="">Áo mặc trong</option>
                                    </select>
                                </div>
                                <div class="gioitinh">
                                    <h3>Giới tính</h3>
                                    <div>
                                        <button id="gioitinhnam" onclick="nam2(this)">Nam</button>
                                        <button class="activebutton" onclick="nu2(this)" id="gioitinhnu">Nữ</button>
                                    </div>
                                </div>
                                <div class="linediv12"></div>
                                <div class="div11submit">
                                    <button><i class="fa fa-save"></i>Lưu</button>
                                    <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản
                                        lý
                                    </button>
                                </div>
                            </div>

                            <div class="div12">
                                <h3>Chọn màu và hình cho sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
                                    </div>
                                    <select name="" id="valuemau">
                                        <option value="img/den.webp" selected>Đen</option>
                                        <option value="img/do.webp">Đỏ</option>
                                        <option value="img/docam.webp">Đỏ cam</option>
                                        <option value="img/hong.webp">Hồng</option>
                                        <option value="img/trang.webp">Trắng</option>
                                        <option value="img/vangdat.webp">Vàng đất</option>
                                        <option value="img/xam.webp">Xám</option>
                                        <option value="img/xanhdam.webp">Xanh đậm</option>
                                        <option value="img/xanhden.webp">Xanh đen</option>
                                        <option value="img/xanhngoc.webp">Xanh ngọc</option>
                                    </select>
                                </div>
                                <div class="buttondiv12">
                                    <button class="buttonthemmau" onclick="themmau2(this)"><i
                                            class="fa fa-plus"></i> Thêm
                                        màu
                                    </button>
                                    <button onclick="taomaumoi()">Tạo màu mới</button>
                                </div>
                                <div class="maudachon">
                                    <h3>Màu đã chọn</h3>
                                    <div class="listMau">
                                        <div class="listMauItem">
                                            <div class="listMauItemleft">
                                                <div>
                                                    <p>Đậm xanh</p>
                                                    <div>
                                                        <img src="../../img/product/damxanh.webp" alt="">
                                                    </div>
                                                </div>
                                                <div>
                                                    <div class="listHinh">
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp2.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp3.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                    </div>
                                                    <i class="fa fa-angle-left" onclick="movehinhleft2(this)"></i>
                                                    <i class="fa fa-angle-right" onclick="movehinhright2(this)"></i>
                                                    <input type="number" style="display: none;" value="0">
                                                </div>
                                            </div>
                                            <div class="removecolor">
                                                <button onclick="themhinh2(this)"><i class="fa fa-plus"></i></button>
                                                <button onclick="removecolor2(this)"><i
                                                        class="fa fa-trash"></i></button>
                                                <input type="file" style="display:none;"
                                                       onchange="loadIMG2(event,this)"/>
                                            </div>
                                        </div>
                                        <div class="listMauItem">
                                            <div class="listMauItemleft">
                                                <div>
                                                    <p>Đậm xanh</p>
                                                    <div>
                                                        <img src="../../img/product/xanhnhat.webp" alt="">
                                                    </div>
                                                </div>
                                                <div>
                                                    <div class="listHinh">
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp5.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp6.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp7.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp8.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                    </div>
                                                    <i class="fa fa-angle-left" onclick="movehinhleft2(this)"></i>
                                                    <i class="fa fa-angle-right" onclick="movehinhright2(this)"></i>
                                                    <input type="number" style="display: none;" value="0">
                                                </div>
                                            </div>
                                            <div class="removecolor">
                                                <button onclick="themhinh2(this)"><i class="fa fa-plus"></i></button>
                                                <button onclick="removecolor2(this)"><i
                                                        class="fa fa-trash"></i></button>
                                                <input type="file" style="display:none;"
                                                       onchange="loadIMG2(event,this)"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="div13">
                                <h3>Chọn size</h3>
                                <div class="linediv12"></div>
                                <div class="gioitinh">
                                    <h3>Lọại sản phẩm</h3>
                                    <div>
                                        <button onclick="ao2(this)">Áo</button>
                                        <button class="activebutton" onclick="quan2(this)">Quần</button>
                                    </div>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
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
                                <button onclick="themsize2(this)"><i class="fa fa-plus"></i> Thêm size</button>
                                <div class="sizedachon">
                                    <h3>Size đã chọn</h3>
                                    <div class="listSize">
                                        <div class="listSizeItem">
                                            <div>
                                                <i class="fa fa-circle"></i>
                                                <p>S</p>
                                            </div>
                                            <button onclick="removeSize2(this)"><i class="fa fa-trash"></i></button>
                                        </div>
                                        <div class="listSizeItem">
                                            <div>
                                                <i class="fa fa-circle"></i>
                                                <p>M</p>
                                            </div>
                                            <button onclick="removeSize2(this)"><i class="fa fa-trash"></i></button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>
                    <div class="item">
                        <label for="c1">
                            <input type="checkbox" name="" id="c1">
                        </label>

                        <div class="itemhdd">
                            <img src="../../img/product/dp1.webp" alt="">
                        </div>

                        <p class="itemname">
                            Quần Jeans Nữ Tưa Lai Túi Lệch WJL 4011
                        </p>

                        <p class="itemtdm">
                            Quần jean
                        </p>

                        <div class="itemsize">
                            <div>
                                <p>S</p>
                            </div>
                            <div>
                                <p>M</p>
                            </div>
                        </div>

                        <div class="itemsize">
                            <div>
                                <img src="../../img/product/damxanh.webp" alt="">
                            </div>
                            <div>
                                <img src="../../img/product/xanhnhat.webp" alt="">
                            </div>
                        </div>

                        <p class="itemgia">
                            319,000 VND
                        </p>

                        <p class="itemsol">38</p>

                        <p class="itemngaytao">
                            20 Tháng Mưới 2020
                        </p>


                        <div class="itemsubmit" onclick="showselect(this)">
                            <input type="text" style="display: none;">
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <div>
                                <button onclick="editkhachhang(this)"><i class="fa fa-pencil"></i>Sửa</button>
                                <button onclick="removekhachhang(this)"><i class="fa fa-trash"></i>Xóa</button>
                            </div>
                        </div>

                        <div>
                            <div class="div11">
                                <h3>Thông tin sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Tên sản phẩm</label>
                                    </div>
                                    <input type="text" placeholder="Nhập tên sản phẩm ở đây"
                                           value="Quần Jeans Nữ Tưa Lai Túi Lệch WJL 4011">
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Hãng sản xuất</label>
                                        <div style="width: 10px;height: 25px;"></div>
                                    </div>
                                    <select name="" id="">
                                        <option value="">Chọn hãng sản xuất</option>
                                        <option value="" selected>Juno - Thương hiệu thời trang cao cấp</option>
                                        <option value="">An Phước – Tỉ mỉ trong từng đường kim mũi chỉ</option>
                                        <option value="">Việt Tiến - Thương hiệu của sự khẳng định</option>
                                        <option value="">NOVELTY - Vẻ đẹp của người Việt được tôn vinh</option>
                                        <option value="">BLUE EXCHANGE - Cuộc sống được làm đẹp</option>
                                        <option value="">May 10 - Thương hiệu của bảy thập kỉ</option>
                                        <option value="">PT2000 - Thời trang dành cho giới trẻ</option>
                                        <option value="">SEA Collection - Chuyên cung cấp các mặt hàng thời trang
                                            trẻ.
                                        </option>
                                        <option value="">Ninomaxx - Thương hiệu thời trang hàng đầu</option>
                                        <option value="">Nem Fashion</option>
                                        <option value="">ELISE</option>
                                        <option value="">Ivy Moda</option>
                                        <option value="">Chic-Land</option>
                                        <option value="">Owen</option>
                                        <option value="">Seven AM</option>
                                    </select>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Danh mục</label>
                                        <a href="quanLyDanhMuc.html">Thêm danh mục</a>
                                    </div>
                                    <select name="" id="">
                                        <option value="">Chọn danh mục</option>
                                        <option value="">Áo thun nữ</option>
                                        <option value="">Áo thun tay dài</option>
                                        <option value="">Áo phong</option>
                                        <option value="">Áo len</option>
                                        <option value="">Áo sơ mi</option>
                                        <option value="">Áo khoác</option>
                                        <option value="" selected>Quần jean</option>
                                        <option value="">Quần kaki</option>
                                        <option value="">Quần shorts</option>
                                        <option value="">Quần vải</option>
                                        <option value="">Đồ mặc nhà</option>
                                        <option value="">Quần áo thể thao</option>
                                        <option value="">Áo mặc trong</option>
                                    </select>
                                </div>
                                <div class="gioitinh">
                                    <h3>Giới tính</h3>
                                    <div>
                                        <button id="gioitinhnam" onclick="nam2(this)">Nam</button>
                                        <button class="activebutton" onclick="nu2(this)" id="gioitinhnu">Nữ</button>
                                    </div>
                                </div>
                                <div class="linediv12"></div>
                                <div class="div11submit">
                                    <button><i class="fa fa-save"></i>Lưu</button>
                                    <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản
                                        lý
                                    </button>
                                </div>
                            </div>

                            <div class="div12">
                                <h3>Chọn màu và hình cho sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
                                    </div>
                                    <select name="" id="valuemau">
                                        <option value="img/den.webp" selected>Đen</option>
                                        <option value="img/do.webp">Đỏ</option>
                                        <option value="img/docam.webp">Đỏ cam</option>
                                        <option value="img/hong.webp">Hồng</option>
                                        <option value="img/trang.webp">Trắng</option>
                                        <option value="img/vangdat.webp">Vàng đất</option>
                                        <option value="img/xam.webp">Xám</option>
                                        <option value="img/xanhdam.webp">Xanh đậm</option>
                                        <option value="img/xanhden.webp">Xanh đen</option>
                                        <option value="img/xanhngoc.webp">Xanh ngọc</option>
                                    </select>
                                </div>
                                <div class="buttondiv12">
                                    <button class="buttonthemmau" onclick="themmau2(this)"><i
                                            class="fa fa-plus"></i> Thêm
                                        màu
                                    </button>
                                    <button onclick="taomaumoi()">Tạo màu mới</button>
                                </div>
                                <div class="maudachon">
                                    <h3>Màu đã chọn</h3>
                                    <div class="listMau">
                                        <div class="listMauItem">
                                            <div class="listMauItemleft">
                                                <div>
                                                    <p>Đậm xanh</p>
                                                    <div>
                                                        <img src="../../img/product/damxanh.webp" alt="">
                                                    </div>
                                                </div>
                                                <div>
                                                    <div class="listHinh">
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp2.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp3.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                    </div>
                                                    <i class="fa fa-angle-left" onclick="movehinhleft2(this)"></i>
                                                    <i class="fa fa-angle-right" onclick="movehinhright2(this)"></i>
                                                    <input type="number" style="display: none;" value="0">
                                                </div>
                                            </div>
                                            <div class="removecolor">
                                                <button onclick="themhinh2(this)"><i class="fa fa-plus"></i></button>
                                                <button onclick="removecolor2(this)"><i
                                                        class="fa fa-trash"></i></button>
                                                <input type="file" style="display:none;"
                                                       onchange="loadIMG2(event,this)"/>
                                            </div>
                                        </div>
                                        <div class="listMauItem">
                                            <div class="listMauItemleft">
                                                <div>
                                                    <p>Đậm xanh</p>
                                                    <div>
                                                        <img src="../../img/product/xanhnhat.webp" alt="">
                                                    </div>
                                                </div>
                                                <div>
                                                    <div class="listHinh">
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp5.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp6.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp7.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp8.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                    </div>
                                                    <i class="fa fa-angle-left" onclick="movehinhleft2(this)"></i>
                                                    <i class="fa fa-angle-right" onclick="movehinhright2(this)"></i>
                                                    <input type="number" style="display: none;" value="0">
                                                </div>
                                            </div>
                                            <div class="removecolor">
                                                <button onclick="themhinh2(this)"><i class="fa fa-plus"></i></button>
                                                <button onclick="removecolor2(this)"><i
                                                        class="fa fa-trash"></i></button>
                                                <input type="file" style="display:none;"
                                                       onchange="loadIMG2(event,this)"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="div13">
                                <h3>Chọn size</h3>
                                <div class="linediv12"></div>
                                <div class="gioitinh">
                                    <h3>Lọại sản phẩm</h3>
                                    <div>
                                        <button onclick="ao2(this)">Áo</button>
                                        <button class="activebutton" onclick="quan2(this)">Quần</button>
                                    </div>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
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
                                <button onclick="themsize2(this)"><i class="fa fa-plus"></i> Thêm size</button>
                                <div class="sizedachon">
                                    <h3>Size đã chọn</h3>
                                    <div class="listSize">
                                        <div class="listSizeItem">
                                            <div>
                                                <i class="fa fa-circle"></i>
                                                <p>S</p>
                                            </div>
                                            <button onclick="removeSize2(this)"><i class="fa fa-trash"></i></button>
                                        </div>
                                        <div class="listSizeItem">
                                            <div>
                                                <i class="fa fa-circle"></i>
                                                <p>M</p>
                                            </div>
                                            <button onclick="removeSize2(this)"><i class="fa fa-trash"></i></button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>
                    <div class="item">
                        <label for="c1">
                            <input type="checkbox" name="" id="c1">
                        </label>

                        <div class="itemhdd">
                            <img src="../../img/product/dp1.webp" alt="">
                        </div>

                        <p class="itemname">
                            Áo Thun Croptop Nữ WTS 2037
                        </p>

                        <p class="itemtdm">
                            Quần jean
                        </p>

                        <div class="itemsize">
                            <div>
                                <p>S</p>
                            </div>
                            <div>
                                <p>M</p>
                            </div>
                            <div class="otherdiv">
                                <div></div>
                                <p>+2</p>
                                <p>L</p>
                            </div>
                        </div>

                        <div class="itemsize">
                            <div>
                                <img src="img/den.webp" alt="">
                            </div>
                            <div>
                                <img src="img/docam.webp" alt="">
                            </div>
                            <div class="otherdiv">
                                <div></div>
                                <p>+4</p>
                                <img src="img/xanhden.webp" alt="">
                            </div>
                        </div>

                        <p class="itemgia">
                            239,000 VND
                        </p>

                        <p class="itemsol">158</p>

                        <p class="itemngaytao">
                            20 Tháng Mưới 2020
                        </p>


                        <div class="itemsubmit" onclick="showselect(this)">
                            <input type="text" style="display: none;">
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <div>
                                <button onclick="editkhachhang(this)"><i class="fa fa-pencil"></i>Sửa</button>
                                <button onclick="removekhachhang(this)"><i class="fa fa-trash"></i>Xóa</button>
                            </div>
                        </div>

                        <div>
                            <div class="div11">
                                <h3>Thông tin sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Tên sản phẩm</label>
                                    </div>
                                    <input type="text" placeholder="Nhập tên sản phẩm ở đây">
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Hãng sản xuất</label>
                                        <div style="width: 10px;height: 25px;"></div>
                                    </div>
                                    <select name="" id="">
                                        <option value="" selected>Chọn hãng sản xuất</option>
                                        <option value="">Juno - Thương hiệu thời trang cao cấp</option>
                                        <option value="">An Phước – Tỉ mỉ trong từng đường kim mũi chỉ</option>
                                        <option value="">Việt Tiến - Thương hiệu của sự khẳng định</option>
                                        <option value="">NOVELTY - Vẻ đẹp của người Việt được tôn vinh</option>
                                        <option value="">BLUE EXCHANGE - Cuộc sống được làm đẹp</option>
                                        <option value="">May 10 - Thương hiệu của bảy thập kỉ</option>
                                        <option value="">PT2000 - Thời trang dành cho giới trẻ</option>
                                        <option value="">SEA Collection - Chuyên cung cấp các mặt hàng thời trang
                                            trẻ.
                                        </option>
                                        <option value="">Ninomaxx - Thương hiệu thời trang hàng đầu</option>
                                        <option value="">Nem Fashion</option>
                                        <option value="">ELISE</option>
                                        <option value="">Ivy Moda</option>
                                        <option value="">Chic-Land</option>
                                        <option value="">Owen</option>
                                        <option value="">Seven AM</option>
                                    </select>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Danh mục</label>
                                        <a href="quanLyDanhMuc.html">Thêm danh mục</a>
                                    </div>
                                    <select name="" id="">
                                        <option value="" selected>Chọn danh mục</option>
                                        <option value="">Áo thun tay dài</option>
                                        <option value="">Áo phong</option>
                                        <option value="">Áo len</option>
                                        <option value="">Áo sơ mi</option>
                                        <option value="">Áo khoác</option>
                                        <option value="">Quần jean</option>
                                        <option value="">Quần kaki</option>
                                        <option value="">Quần shorts</option>
                                        <option value="">Quần vải</option>
                                        <option value="">Đồ mặc nhà</option>
                                        <option value="">Quần áo thể thao</option>
                                        <option value="">Áo mặc trong</option>
                                    </select>
                                </div>
                                <div class="gioitinh">
                                    <h3>Giới tính</h3>
                                    <div>
                                        <button class="activebutton" id="gioitinhnam"
                                                onclick="nam2(this)">Nam
                                        </button>
                                        <button onclick="nu2(this)" id="gioitinhnu">Nữ</button>
                                    </div>
                                </div>
                                <div class="linediv12"></div>
                                <div class="div11submit">
                                    <button><i class="fa fa-save"></i>Lưu</button>
                                    <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản
                                        lý
                                    </button>
                                </div>
                            </div>

                            <div class="div12">
                                <h3>Chọn màu và hình cho sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
                                    </div>
                                    <select name="" id="valuemau">
                                        <option value="img/den.webp" selected>Đen</option>
                                        <option value="img/do.webp">Đỏ</option>
                                        <option value="img/docam.webp">Đỏ cam</option>
                                        <option value="img/hong.webp">Hồng</option>
                                        <option value="img/trang.webp">Trắng</option>
                                        <option value="img/vangdat.webp">Vàng đất</option>
                                        <option value="img/xam.webp">Xám</option>
                                        <option value="img/xanhdam.webp">Xanh đậm</option>
                                        <option value="img/xanhden.webp">Xanh đen</option>
                                        <option value="img/xanhngoc.webp">Xanh ngọc</option>
                                    </select>
                                </div>
                                <div class="buttondiv12">
                                    <button class="buttonthemmau" onclick="themmau2(this)"><i
                                            class="fa fa-plus"></i> Thêm
                                        màu
                                    </button>
                                    <button onclick="taomaumoi()">Tạo màu mới</button>
                                </div>
                                <div class="maudachon">
                                    <h3>Màu đã chọn</h3>
                                    <div class="listMau">
                                        <div class="listMauItem">
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
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp2.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp3.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp2.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp3.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                    </div>
                                                    <i class="fa fa-angle-left" onclick="movehinhleft2(this)"></i>
                                                    <i class="fa fa-angle-right" onclick="movehinhright2(this)"></i>
                                                    <input type="number" style="display: none;" value="0">
                                                </div>
                                            </div>
                                            <div class="removecolor">
                                                <button onclick="themhinh2(this)"><i class="fa fa-plus"></i></button>
                                                <button onclick="removecolor2(this)"><i
                                                        class="fa fa-trash"></i></button>
                                                <input type="file" style="display:none;"
                                                       onchange="loadIMG2(event,this)"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="div13">
                                <h3>Chọn size</h3>
                                <div class="linediv12"></div>
                                <div class="gioitinh">
                                    <h3>Lọại sản phẩm</h3>
                                    <div>
                                        <button class="activebutton" onclick="ao2(this)">Áo</button>
                                        <button onclick="quan2(this)">Quần</button>
                                    </div>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
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
                                <button onclick="themsize2(this)"><i class="fa fa-plus"></i> Thêm size</button>
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
                    <div class="item">
                        <label for="c1">
                            <input type="checkbox" name="" id="c1">
                        </label>

                        <div class="itemhdd">
                            <img src="../../img/product/dp1.webp" alt="">
                        </div>

                        <p class="itemname">
                            Quần Jeans Nữ Tưa Lai Túi Lệch WJL 4011
                        </p>

                        <p class="itemtdm">
                            Quần jean
                        </p>

                        <div class="itemsize">
                            <div>
                                <p>S</p>
                            </div>
                            <div>
                                <p>M</p>
                            </div>
                        </div>

                        <div class="itemsize">
                            <div>
                                <img src="../../img/product/damxanh.webp" alt="">
                            </div>
                            <div>
                                <img src="../../img/product/xanhnhat.webp" alt="">
                            </div>
                        </div>

                        <p class="itemgia">
                            319,000 VND
                        </p>

                        <p class="itemsol">38</p>

                        <p class="itemngaytao">
                            20 Tháng Mưới 2020
                        </p>


                        <div class="itemsubmit" onclick="showselect(this)">
                            <input type="text" style="display: none;">
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <div>
                                <button onclick="editkhachhang(this)"><i class="fa fa-pencil"></i>Sửa</button>
                                <button onclick="removekhachhang(this)"><i class="fa fa-trash"></i>Xóa</button>
                            </div>
                        </div>

                        <div>
                            <div class="div11">
                                <h3>Thông tin sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Tên sản phẩm</label>
                                    </div>
                                    <input type="text" placeholder="Nhập tên sản phẩm ở đây"
                                           value="Quần Jeans Nữ Tưa Lai Túi Lệch WJL 4011">
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Hãng sản xuất</label>
                                        <div style="width: 10px;height: 25px;"></div>
                                    </div>
                                    <select name="" id="">
                                        <option value="">Chọn hãng sản xuất</option>
                                        <option value="" selected>Juno - Thương hiệu thời trang cao cấp</option>
                                        <option value="">An Phước – Tỉ mỉ trong từng đường kim mũi chỉ</option>
                                        <option value="">Việt Tiến - Thương hiệu của sự khẳng định</option>
                                        <option value="">NOVELTY - Vẻ đẹp của người Việt được tôn vinh</option>
                                        <option value="">BLUE EXCHANGE - Cuộc sống được làm đẹp</option>
                                        <option value="">May 10 - Thương hiệu của bảy thập kỉ</option>
                                        <option value="">PT2000 - Thời trang dành cho giới trẻ</option>
                                        <option value="">SEA Collection - Chuyên cung cấp các mặt hàng thời trang
                                            trẻ.
                                        </option>
                                        <option value="">Ninomaxx - Thương hiệu thời trang hàng đầu</option>
                                        <option value="">Nem Fashion</option>
                                        <option value="">ELISE</option>
                                        <option value="">Ivy Moda</option>
                                        <option value="">Chic-Land</option>
                                        <option value="">Owen</option>
                                        <option value="">Seven AM</option>
                                    </select>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Danh mục</label>
                                        <a href="quanLyDanhMuc.html">Thêm danh mục</a>
                                    </div>
                                    <select name="" id="">
                                        <option value="">Chọn danh mục</option>
                                        <option value="">Áo thun nữ</option>
                                        <option value="">Áo thun tay dài</option>
                                        <option value="">Áo phong</option>
                                        <option value="">Áo len</option>
                                        <option value="">Áo sơ mi</option>
                                        <option value="">Áo khoác</option>
                                        <option value="" selected>Quần jean</option>
                                        <option value="">Quần kaki</option>
                                        <option value="">Quần shorts</option>
                                        <option value="">Quần vải</option>
                                        <option value="">Đồ mặc nhà</option>
                                        <option value="">Quần áo thể thao</option>
                                        <option value="">Áo mặc trong</option>
                                    </select>
                                </div>
                                <div class="gioitinh">
                                    <h3>Giới tính</h3>
                                    <div>
                                        <button id="gioitinhnam" onclick="nam2(this)">Nam</button>
                                        <button class="activebutton" onclick="nu2(this)" id="gioitinhnu">Nữ</button>
                                    </div>
                                </div>
                                <div class="linediv12"></div>
                                <div class="div11submit">
                                    <button><i class="fa fa-save"></i>Lưu</button>
                                    <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản
                                        lý
                                    </button>
                                </div>
                            </div>

                            <div class="div12">
                                <h3>Chọn màu và hình cho sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
                                    </div>
                                    <select name="" id="valuemau">
                                        <option value="img/den.webp" selected>Đen</option>
                                        <option value="img/do.webp">Đỏ</option>
                                        <option value="img/docam.webp">Đỏ cam</option>
                                        <option value="img/hong.webp">Hồng</option>
                                        <option value="img/trang.webp">Trắng</option>
                                        <option value="img/vangdat.webp">Vàng đất</option>
                                        <option value="img/xam.webp">Xám</option>
                                        <option value="img/xanhdam.webp">Xanh đậm</option>
                                        <option value="img/xanhden.webp">Xanh đen</option>
                                        <option value="img/xanhngoc.webp">Xanh ngọc</option>
                                    </select>
                                </div>
                                <div class="buttondiv12">
                                    <button class="buttonthemmau" onclick="themmau2(this)"><i
                                            class="fa fa-plus"></i> Thêm
                                        màu
                                    </button>
                                    <button onclick="taomaumoi()">Tạo màu mới</button>
                                </div>
                                <div class="maudachon">
                                    <h3>Màu đã chọn</h3>
                                    <div class="listMau">
                                        <div class="listMauItem">
                                            <div class="listMauItemleft">
                                                <div>
                                                    <p>Đậm xanh</p>
                                                    <div>
                                                        <img src="../../img/product/damxanh.webp" alt="">
                                                    </div>
                                                </div>
                                                <div>
                                                    <div class="listHinh">
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp2.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp3.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                    </div>
                                                    <i class="fa fa-angle-left" onclick="movehinhleft2(this)"></i>
                                                    <i class="fa fa-angle-right" onclick="movehinhright2(this)"></i>
                                                    <input type="number" style="display: none;" value="0">
                                                </div>
                                            </div>
                                            <div class="removecolor">
                                                <button onclick="themhinh2(this)"><i class="fa fa-plus"></i></button>
                                                <button onclick="removecolor2(this)"><i
                                                        class="fa fa-trash"></i></button>
                                                <input type="file" style="display:none;"
                                                       onchange="loadIMG2(event,this)"/>
                                            </div>
                                        </div>
                                        <div class="listMauItem">
                                            <div class="listMauItemleft">
                                                <div>
                                                    <p>Đậm xanh</p>
                                                    <div>
                                                        <img src="../../img/product/xanhnhat.webp" alt="">
                                                    </div>
                                                </div>
                                                <div>
                                                    <div class="listHinh">
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp5.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp6.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp7.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp8.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                    </div>
                                                    <i class="fa fa-angle-left" onclick="movehinhleft2(this)"></i>
                                                    <i class="fa fa-angle-right" onclick="movehinhright2(this)"></i>
                                                    <input type="number" style="display: none;" value="0">
                                                </div>
                                            </div>
                                            <div class="removecolor">
                                                <button onclick="themhinh2(this)"><i class="fa fa-plus"></i></button>
                                                <button onclick="removecolor2(this)"><i
                                                        class="fa fa-trash"></i></button>
                                                <input type="file" style="display:none;"
                                                       onchange="loadIMG2(event,this)"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="div13">
                                <h3>Chọn size</h3>
                                <div class="linediv12"></div>
                                <div class="gioitinh">
                                    <h3>Lọại sản phẩm</h3>
                                    <div>
                                        <button onclick="ao2(this)">Áo</button>
                                        <button class="activebutton" onclick="quan2(this)">Quần</button>
                                    </div>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
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
                                <button onclick="themsize2(this)"><i class="fa fa-plus"></i> Thêm size</button>
                                <div class="sizedachon">
                                    <h3>Size đã chọn</h3>
                                    <div class="listSize">
                                        <div class="listSizeItem">
                                            <div>
                                                <i class="fa fa-circle"></i>
                                                <p>S</p>
                                            </div>
                                            <button onclick="removeSize2(this)"><i class="fa fa-trash"></i></button>
                                        </div>
                                        <div class="listSizeItem">
                                            <div>
                                                <i class="fa fa-circle"></i>
                                                <p>M</p>
                                            </div>
                                            <button onclick="removeSize2(this)"><i class="fa fa-trash"></i></button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>
                    <div class="item">
                        <label for="c1">
                            <input type="checkbox" name="" id="c1">
                        </label>

                        <div class="itemhdd">
                            <img src="../../img/product/dp1.webp" alt="">
                        </div>

                        <p class="itemname">
                            Áo Thun Croptop Nữ WTS 2037
                        </p>

                        <p class="itemtdm">
                            Quần jean
                        </p>

                        <div class="itemsize">
                            <div>
                                <p>S</p>
                            </div>
                            <div>
                                <p>M</p>
                            </div>
                            <div class="otherdiv">
                                <div></div>
                                <p>+2</p>
                                <p>L</p>
                            </div>
                        </div>

                        <div class="itemsize">
                            <div>
                                <img src="img/den.webp" alt="">
                            </div>
                            <div>
                                <img src="img/docam.webp" alt="">
                            </div>
                            <div class="otherdiv">
                                <div></div>
                                <p>+4</p>
                                <img src="img/xanhden.webp" alt="">
                            </div>
                        </div>

                        <p class="itemgia">
                            239,000 VND
                        </p>

                        <p class="itemsol">158</p>

                        <p class="itemngaytao">
                            20 Tháng Mưới 2020
                        </p>


                        <div class="itemsubmit" onclick="showselect(this)">
                            <input type="text" style="display: none;">
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <div>
                                <button onclick="editkhachhang(this)"><i class="fa fa-pencil"></i>Sửa</button>
                                <button onclick="removekhachhang(this)"><i class="fa fa-trash"></i>Xóa</button>
                            </div>
                        </div>

                        <div>
                            <div class="div11">
                                <h3>Thông tin sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Tên sản phẩm</label>
                                    </div>
                                    <input type="text" placeholder="Nhập tên sản phẩm ở đây">
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Hãng sản xuất</label>
                                        <div style="width: 10px;height: 25px;"></div>
                                    </div>
                                    <select name="" id="">
                                        <option value="" selected>Chọn hãng sản xuất</option>
                                        <option value="">Juno - Thương hiệu thời trang cao cấp</option>
                                        <option value="">An Phước – Tỉ mỉ trong từng đường kim mũi chỉ</option>
                                        <option value="">Việt Tiến - Thương hiệu của sự khẳng định</option>
                                        <option value="">NOVELTY - Vẻ đẹp của người Việt được tôn vinh</option>
                                        <option value="">BLUE EXCHANGE - Cuộc sống được làm đẹp</option>
                                        <option value="">May 10 - Thương hiệu của bảy thập kỉ</option>
                                        <option value="">PT2000 - Thời trang dành cho giới trẻ</option>
                                        <option value="">SEA Collection - Chuyên cung cấp các mặt hàng thời trang
                                            trẻ.
                                        </option>
                                        <option value="">Ninomaxx - Thương hiệu thời trang hàng đầu</option>
                                        <option value="">Nem Fashion</option>
                                        <option value="">ELISE</option>
                                        <option value="">Ivy Moda</option>
                                        <option value="">Chic-Land</option>
                                        <option value="">Owen</option>
                                        <option value="">Seven AM</option>
                                    </select>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Danh mục</label>
                                        <a href="quanLyDanhMuc.html">Thêm danh mục</a>
                                    </div>
                                    <select name="" id="">
                                        <option value="" selected>Chọn danh mục</option>
                                        <option value="">Áo thun tay dài</option>
                                        <option value="">Áo phong</option>
                                        <option value="">Áo len</option>
                                        <option value="">Áo sơ mi</option>
                                        <option value="">Áo khoác</option>
                                        <option value="">Quần jean</option>
                                        <option value="">Quần kaki</option>
                                        <option value="">Quần shorts</option>
                                        <option value="">Quần vải</option>
                                        <option value="">Đồ mặc nhà</option>
                                        <option value="">Quần áo thể thao</option>
                                        <option value="">Áo mặc trong</option>
                                    </select>
                                </div>
                                <div class="gioitinh">
                                    <h3>Giới tính</h3>
                                    <div>
                                        <button class="activebutton" id="gioitinhnam"
                                                onclick="nam2(this)">Nam
                                        </button>
                                        <button onclick="nu2(this)" id="gioitinhnu">Nữ</button>
                                    </div>
                                </div>
                                <div class="linediv12"></div>
                                <div class="div11submit">
                                    <button><i class="fa fa-save"></i>Lưu</button>
                                    <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản
                                        lý
                                    </button>
                                </div>
                            </div>

                            <div class="div12">
                                <h3>Chọn màu và hình cho sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
                                    </div>
                                    <select name="" id="valuemau">
                                        <option value="img/den.webp" selected>Đen</option>
                                        <option value="img/do.webp">Đỏ</option>
                                        <option value="img/docam.webp">Đỏ cam</option>
                                        <option value="img/hong.webp">Hồng</option>
                                        <option value="img/trang.webp">Trắng</option>
                                        <option value="img/vangdat.webp">Vàng đất</option>
                                        <option value="img/xam.webp">Xám</option>
                                        <option value="img/xanhdam.webp">Xanh đậm</option>
                                        <option value="img/xanhden.webp">Xanh đen</option>
                                        <option value="img/xanhngoc.webp">Xanh ngọc</option>
                                    </select>
                                </div>
                                <div class="buttondiv12">
                                    <button class="buttonthemmau" onclick="themmau2(this)"><i
                                            class="fa fa-plus"></i> Thêm
                                        màu
                                    </button>
                                    <button onclick="taomaumoi()">Tạo màu mới</button>
                                </div>
                                <div class="maudachon">
                                    <h3>Màu đã chọn</h3>
                                    <div class="listMau">
                                        <div class="listMauItem">
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
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp2.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp3.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp2.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp3.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                    </div>
                                                    <i class="fa fa-angle-left" onclick="movehinhleft2(this)"></i>
                                                    <i class="fa fa-angle-right" onclick="movehinhright2(this)"></i>
                                                    <input type="number" style="display: none;" value="0">
                                                </div>
                                            </div>
                                            <div class="removecolor">
                                                <button onclick="themhinh2(this)"><i class="fa fa-plus"></i></button>
                                                <button onclick="removecolor2(this)"><i
                                                        class="fa fa-trash"></i></button>
                                                <input type="file" style="display:none;"
                                                       onchange="loadIMG2(event,this)"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="div13">
                                <h3>Chọn size</h3>
                                <div class="linediv12"></div>
                                <div class="gioitinh">
                                    <h3>Lọại sản phẩm</h3>
                                    <div>
                                        <button class="activebutton" onclick="ao2(this)">Áo</button>
                                        <button onclick="quan2(this)">Quần</button>
                                    </div>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
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
                                <button onclick="themsize2(this)"><i class="fa fa-plus"></i> Thêm size</button>
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
                    <div class="item">
                        <label for="c1">
                            <input type="checkbox" name="" id="c1">
                        </label>

                        <div class="itemhdd">
                            <img src="../../img/product/dp1.webp" alt="">
                        </div>

                        <p class="itemname">
                            Quần Jeans Nữ Tưa Lai Túi Lệch WJL 4011
                        </p>

                        <p class="itemtdm">
                            Quần jean
                        </p>

                        <div class="itemsize">
                            <div>
                                <p>S</p>
                            </div>
                            <div>
                                <p>M</p>
                            </div>
                        </div>

                        <div class="itemsize">
                            <div>
                                <img src="../../img/product/damxanh.webp" alt="">
                            </div>
                            <div>
                                <img src="../../img/product/xanhnhat.webp" alt="">
                            </div>
                        </div>

                        <p class="itemgia">
                            319,000 VND
                        </p>

                        <p class="itemsol">38</p>

                        <p class="itemngaytao">
                            20 Tháng Mưới 2020
                        </p>


                        <div class="itemsubmit" onclick="showselect(this)">
                            <input type="text" style="display: none;">
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <div>
                                <button onclick="editkhachhang(this)"><i class="fa fa-pencil"></i>Sửa</button>
                                <button onclick="removekhachhang(this)"><i class="fa fa-trash"></i>Xóa</button>
                            </div>
                        </div>

                        <div>
                            <div class="div11">
                                <h3>Thông tin sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Tên sản phẩm</label>
                                    </div>
                                    <input type="text" placeholder="Nhập tên sản phẩm ở đây"
                                           value="Quần Jeans Nữ Tưa Lai Túi Lệch WJL 4011">
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Hãng sản xuất</label>
                                        <div style="width: 10px;height: 25px;"></div>
                                    </div>
                                    <select name="" id="">
                                        <option value="">Chọn hãng sản xuất</option>
                                        <option value="" selected>Juno - Thương hiệu thời trang cao cấp</option>
                                        <option value="">An Phước – Tỉ mỉ trong từng đường kim mũi chỉ</option>
                                        <option value="">Việt Tiến - Thương hiệu của sự khẳng định</option>
                                        <option value="">NOVELTY - Vẻ đẹp của người Việt được tôn vinh</option>
                                        <option value="">BLUE EXCHANGE - Cuộc sống được làm đẹp</option>
                                        <option value="">May 10 - Thương hiệu của bảy thập kỉ</option>
                                        <option value="">PT2000 - Thời trang dành cho giới trẻ</option>
                                        <option value="">SEA Collection - Chuyên cung cấp các mặt hàng thời trang
                                            trẻ.
                                        </option>
                                        <option value="">Ninomaxx - Thương hiệu thời trang hàng đầu</option>
                                        <option value="">Nem Fashion</option>
                                        <option value="">ELISE</option>
                                        <option value="">Ivy Moda</option>
                                        <option value="">Chic-Land</option>
                                        <option value="">Owen</option>
                                        <option value="">Seven AM</option>
                                    </select>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Danh mục</label>
                                        <a href="quanLyDanhMuc.html">Thêm danh mục</a>
                                    </div>
                                    <select name="" id="">
                                        <option value="">Chọn danh mục</option>
                                        <option value="">Áo thun nữ</option>
                                        <option value="">Áo thun tay dài</option>
                                        <option value="">Áo phong</option>
                                        <option value="">Áo len</option>
                                        <option value="">Áo sơ mi</option>
                                        <option value="">Áo khoác</option>
                                        <option value="" selected>Quần jean</option>
                                        <option value="">Quần kaki</option>
                                        <option value="">Quần shorts</option>
                                        <option value="">Quần vải</option>
                                        <option value="">Đồ mặc nhà</option>
                                        <option value="">Quần áo thể thao</option>
                                        <option value="">Áo mặc trong</option>
                                    </select>
                                </div>
                                <div class="gioitinh">
                                    <h3>Giới tính</h3>
                                    <div>
                                        <button id="gioitinhnam" onclick="nam2(this)">Nam</button>
                                        <button class="activebutton" onclick="nu2(this)" id="gioitinhnu">Nữ</button>
                                    </div>
                                </div>
                                <div class="linediv12"></div>
                                <div class="div11submit">
                                    <button><i class="fa fa-save"></i>Lưu</button>
                                    <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản
                                        lý
                                    </button>
                                </div>
                            </div>

                            <div class="div12">
                                <h3>Chọn màu và hình cho sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
                                    </div>
                                    <select name="" id="valuemau">
                                        <option value="img/den.webp" selected>Đen</option>
                                        <option value="img/do.webp">Đỏ</option>
                                        <option value="img/docam.webp">Đỏ cam</option>
                                        <option value="img/hong.webp">Hồng</option>
                                        <option value="img/trang.webp">Trắng</option>
                                        <option value="img/vangdat.webp">Vàng đất</option>
                                        <option value="img/xam.webp">Xám</option>
                                        <option value="img/xanhdam.webp">Xanh đậm</option>
                                        <option value="img/xanhden.webp">Xanh đen</option>
                                        <option value="img/xanhngoc.webp">Xanh ngọc</option>
                                    </select>
                                </div>
                                <div class="buttondiv12">
                                    <button class="buttonthemmau" onclick="themmau2(this)"><i
                                            class="fa fa-plus"></i> Thêm
                                        màu
                                    </button>
                                    <button onclick="taomaumoi()">Tạo màu mới</button>
                                </div>
                                <div class="maudachon">
                                    <h3>Màu đã chọn</h3>
                                    <div class="listMau">
                                        <div class="listMauItem">
                                            <div class="listMauItemleft">
                                                <div>
                                                    <p>Đậm xanh</p>
                                                    <div>
                                                        <img src="../../img/product/damxanh.webp" alt="">
                                                    </div>
                                                </div>
                                                <div>
                                                    <div class="listHinh">
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp2.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp3.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                    </div>
                                                    <i class="fa fa-angle-left" onclick="movehinhleft2(this)"></i>
                                                    <i class="fa fa-angle-right" onclick="movehinhright2(this)"></i>
                                                    <input type="number" style="display: none;" value="0">
                                                </div>
                                            </div>
                                            <div class="removecolor">
                                                <button onclick="themhinh2(this)"><i class="fa fa-plus"></i></button>
                                                <button onclick="removecolor2(this)"><i
                                                        class="fa fa-trash"></i></button>
                                                <input type="file" style="display:none;"
                                                       onchange="loadIMG2(event,this)"/>
                                            </div>
                                        </div>
                                        <div class="listMauItem">
                                            <div class="listMauItemleft">
                                                <div>
                                                    <p>Đậm xanh</p>
                                                    <div>
                                                        <img src="../../img/product/xanhnhat.webp" alt="">
                                                    </div>
                                                </div>
                                                <div>
                                                    <div class="listHinh">
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp5.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp6.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp7.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp8.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                    </div>
                                                    <i class="fa fa-angle-left" onclick="movehinhleft2(this)"></i>
                                                    <i class="fa fa-angle-right" onclick="movehinhright2(this)"></i>
                                                    <input type="number" style="display: none;" value="0">
                                                </div>
                                            </div>
                                            <div class="removecolor">
                                                <button onclick="themhinh2(this)"><i class="fa fa-plus"></i></button>
                                                <button onclick="removecolor2(this)"><i
                                                        class="fa fa-trash"></i></button>
                                                <input type="file" style="display:none;"
                                                       onchange="loadIMG2(event,this)"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="div13">
                                <h3>Chọn size</h3>
                                <div class="linediv12"></div>
                                <div class="gioitinh">
                                    <h3>Lọại sản phẩm</h3>
                                    <div>
                                        <button onclick="ao2(this)">Áo</button>
                                        <button class="activebutton" onclick="quan2(this)">Quần</button>
                                    </div>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
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
                                <button onclick="themsize2(this)"><i class="fa fa-plus"></i> Thêm size</button>
                                <div class="sizedachon">
                                    <h3>Size đã chọn</h3>
                                    <div class="listSize">
                                        <div class="listSizeItem">
                                            <div>
                                                <i class="fa fa-circle"></i>
                                                <p>S</p>
                                            </div>
                                            <button onclick="removeSize2(this)"><i class="fa fa-trash"></i></button>
                                        </div>
                                        <div class="listSizeItem">
                                            <div>
                                                <i class="fa fa-circle"></i>
                                                <p>M</p>
                                            </div>
                                            <button onclick="removeSize2(this)"><i class="fa fa-trash"></i></button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>
                    <div class="item">
                        <label for="c1">
                            <input type="checkbox" name="" id="c1">
                        </label>

                        <div class="itemhdd">
                            <img src="../../img/product/dp1.webp" alt="">
                        </div>

                        <p class="itemname">
                            Áo Thun Croptop Nữ WTS 2037
                        </p>

                        <p class="itemtdm">
                            Quần jean
                        </p>

                        <div class="itemsize">
                            <div>
                                <p>S</p>
                            </div>
                            <div>
                                <p>M</p>
                            </div>
                            <div class="otherdiv">
                                <div></div>
                                <p>+2</p>
                                <p>L</p>
                            </div>
                        </div>

                        <div class="itemsize">
                            <div>
                                <img src="img/den.webp" alt="">
                            </div>
                            <div>
                                <img src="img/docam.webp" alt="">
                            </div>
                            <div class="otherdiv">
                                <div></div>
                                <p>+4</p>
                                <img src="img/xanhden.webp" alt="">
                            </div>
                        </div>

                        <p class="itemgia">
                            239,000 VND
                        </p>

                        <p class="itemsol">158</p>

                        <p class="itemngaytao">
                            20 Tháng Mưới 2020
                        </p>


                        <div class="itemsubmit" onclick="showselect(this)">
                            <input type="text" style="display: none;">
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <div>
                                <button onclick="editkhachhang(this)"><i class="fa fa-pencil"></i>Sửa</button>
                                <button onclick="removekhachhang(this)"><i class="fa fa-trash"></i>Xóa</button>
                            </div>
                        </div>

                        <div>
                            <div class="div11">
                                <h3>Thông tin sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Tên sản phẩm</label>
                                    </div>
                                    <input type="text" placeholder="Nhập tên sản phẩm ở đây">
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Hãng sản xuất</label>
                                        <div style="width: 10px;height: 25px;"></div>
                                    </div>
                                    <select name="" id="">
                                        <option value="" selected>Chọn hãng sản xuất</option>
                                        <option value="">Juno - Thương hiệu thời trang cao cấp</option>
                                        <option value="">An Phước – Tỉ mỉ trong từng đường kim mũi chỉ</option>
                                        <option value="">Việt Tiến - Thương hiệu của sự khẳng định</option>
                                        <option value="">NOVELTY - Vẻ đẹp của người Việt được tôn vinh</option>
                                        <option value="">BLUE EXCHANGE - Cuộc sống được làm đẹp</option>
                                        <option value="">May 10 - Thương hiệu của bảy thập kỉ</option>
                                        <option value="">PT2000 - Thời trang dành cho giới trẻ</option>
                                        <option value="">SEA Collection - Chuyên cung cấp các mặt hàng thời trang
                                            trẻ.
                                        </option>
                                        <option value="">Ninomaxx - Thương hiệu thời trang hàng đầu</option>
                                        <option value="">Nem Fashion</option>
                                        <option value="">ELISE</option>
                                        <option value="">Ivy Moda</option>
                                        <option value="">Chic-Land</option>
                                        <option value="">Owen</option>
                                        <option value="">Seven AM</option>
                                    </select>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Danh mục</label>
                                        <a href="quanLyDanhMuc.html">Thêm danh mục</a>
                                    </div>
                                    <select name="" id="">
                                        <option value="" selected>Chọn danh mục</option>
                                        <option value="">Áo thun tay dài</option>
                                        <option value="">Áo phong</option>
                                        <option value="">Áo len</option>
                                        <option value="">Áo sơ mi</option>
                                        <option value="">Áo khoác</option>
                                        <option value="">Quần jean</option>
                                        <option value="">Quần kaki</option>
                                        <option value="">Quần shorts</option>
                                        <option value="">Quần vải</option>
                                        <option value="">Đồ mặc nhà</option>
                                        <option value="">Quần áo thể thao</option>
                                        <option value="">Áo mặc trong</option>
                                    </select>
                                </div>
                                <div class="gioitinh">
                                    <h3>Giới tính</h3>
                                    <div>
                                        <button class="activebutton" id="gioitinhnam"
                                                onclick="nam2(this)">Nam
                                        </button>
                                        <button onclick="nu2(this)" id="gioitinhnu">Nữ</button>
                                    </div>
                                </div>
                                <div class="linediv12"></div>
                                <div class="div11submit">
                                    <button><i class="fa fa-save"></i>Lưu</button>
                                    <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản
                                        lý
                                    </button>
                                </div>
                            </div>

                            <div class="div12">
                                <h3>Chọn màu và hình cho sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
                                    </div>
                                    <select name="" id="valuemau">
                                        <option value="img/den.webp" selected>Đen</option>
                                        <option value="img/do.webp">Đỏ</option>
                                        <option value="img/docam.webp">Đỏ cam</option>
                                        <option value="img/hong.webp">Hồng</option>
                                        <option value="img/trang.webp">Trắng</option>
                                        <option value="img/vangdat.webp">Vàng đất</option>
                                        <option value="img/xam.webp">Xám</option>
                                        <option value="img/xanhdam.webp">Xanh đậm</option>
                                        <option value="img/xanhden.webp">Xanh đen</option>
                                        <option value="img/xanhngoc.webp">Xanh ngọc</option>
                                    </select>
                                </div>
                                <div class="buttondiv12">
                                    <button class="buttonthemmau" onclick="themmau2(this)"><i
                                            class="fa fa-plus"></i> Thêm
                                        màu
                                    </button>
                                    <button onclick="taomaumoi()">Tạo màu mới</button>
                                </div>
                                <div class="maudachon">
                                    <h3>Màu đã chọn</h3>
                                    <div class="listMau">
                                        <div class="listMauItem">
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
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp2.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp3.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp2.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp3.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                    </div>
                                                    <i class="fa fa-angle-left" onclick="movehinhleft2(this)"></i>
                                                    <i class="fa fa-angle-right" onclick="movehinhright2(this)"></i>
                                                    <input type="number" style="display: none;" value="0">
                                                </div>
                                            </div>
                                            <div class="removecolor">
                                                <button onclick="themhinh2(this)"><i class="fa fa-plus"></i></button>
                                                <button onclick="removecolor2(this)"><i
                                                        class="fa fa-trash"></i></button>
                                                <input type="file" style="display:none;"
                                                       onchange="loadIMG2(event,this)"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="div13">
                                <h3>Chọn size</h3>
                                <div class="linediv12"></div>
                                <div class="gioitinh">
                                    <h3>Lọại sản phẩm</h3>
                                    <div>
                                        <button class="activebutton" onclick="ao2(this)">Áo</button>
                                        <button onclick="quan2(this)">Quần</button>
                                    </div>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
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
                                <button onclick="themsize2(this)"><i class="fa fa-plus"></i> Thêm size</button>
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
                    <div class="item">
                        <label for="c1">
                            <input type="checkbox" name="" id="c1">
                        </label>

                        <div class="itemhdd">
                            <img src="../../img/product/dp1.webp" alt="">
                        </div>

                        <p class="itemname">
                            Quần Jeans Nữ Tưa Lai Túi Lệch WJL 4011
                        </p>

                        <p class="itemtdm">
                            Quần jean
                        </p>

                        <div class="itemsize">
                            <div>
                                <p>S</p>
                            </div>
                            <div>
                                <p>M</p>
                            </div>
                        </div>

                        <div class="itemsize">
                            <div>
                                <img src="../../img/product/damxanh.webp" alt="">
                            </div>
                            <div>
                                <img src="../../img/product/xanhnhat.webp" alt="">
                            </div>
                        </div>

                        <p class="itemgia">
                            319,000 VND
                        </p>

                        <p class="itemsol">38</p>

                        <p class="itemngaytao">
                            20 Tháng Mưới 2020
                        </p>


                        <div class="itemsubmit" onclick="showselect(this)">
                            <input type="text" style="display: none;">
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <div>
                                <button onclick="editkhachhang(this)"><i class="fa fa-pencil"></i>Sửa</button>
                                <button onclick="removekhachhang(this)"><i class="fa fa-trash"></i>Xóa</button>
                            </div>
                        </div>

                        <div>
                            <div class="div11">
                                <h3>Thông tin sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Tên sản phẩm</label>
                                    </div>
                                    <input type="text" placeholder="Nhập tên sản phẩm ở đây"
                                           value="Quần Jeans Nữ Tưa Lai Túi Lệch WJL 4011">
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Hãng sản xuất</label>
                                        <div style="width: 10px;height: 25px;"></div>
                                    </div>
                                    <select name="" id="">
                                        <option value="">Chọn hãng sản xuất</option>
                                        <option value="" selected>Juno - Thương hiệu thời trang cao cấp</option>
                                        <option value="">An Phước – Tỉ mỉ trong từng đường kim mũi chỉ</option>
                                        <option value="">Việt Tiến - Thương hiệu của sự khẳng định</option>
                                        <option value="">NOVELTY - Vẻ đẹp của người Việt được tôn vinh</option>
                                        <option value="">BLUE EXCHANGE - Cuộc sống được làm đẹp</option>
                                        <option value="">May 10 - Thương hiệu của bảy thập kỉ</option>
                                        <option value="">PT2000 - Thời trang dành cho giới trẻ</option>
                                        <option value="">SEA Collection - Chuyên cung cấp các mặt hàng thời trang
                                            trẻ.
                                        </option>
                                        <option value="">Ninomaxx - Thương hiệu thời trang hàng đầu</option>
                                        <option value="">Nem Fashion</option>
                                        <option value="">ELISE</option>
                                        <option value="">Ivy Moda</option>
                                        <option value="">Chic-Land</option>
                                        <option value="">Owen</option>
                                        <option value="">Seven AM</option>
                                    </select>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Danh mục</label>
                                        <a href="quanLyDanhMuc.html">Thêm danh mục</a>
                                    </div>
                                    <select name="" id="">
                                        <option value="">Chọn danh mục</option>
                                        <option value="">Áo thun nữ</option>
                                        <option value="">Áo thun tay dài</option>
                                        <option value="">Áo phong</option>
                                        <option value="">Áo len</option>
                                        <option value="">Áo sơ mi</option>
                                        <option value="">Áo khoác</option>
                                        <option value="" selected>Quần jean</option>
                                        <option value="">Quần kaki</option>
                                        <option value="">Quần shorts</option>
                                        <option value="">Quần vải</option>
                                        <option value="">Đồ mặc nhà</option>
                                        <option value="">Quần áo thể thao</option>
                                        <option value="">Áo mặc trong</option>
                                    </select>
                                </div>
                                <div class="gioitinh">
                                    <h3>Giới tính</h3>
                                    <div>
                                        <button id="gioitinhnam" onclick="nam2(this)">Nam</button>
                                        <button class="activebutton" onclick="nu2(this)" id="gioitinhnu">Nữ</button>
                                    </div>
                                </div>
                                <div class="linediv12"></div>
                                <div class="div11submit">
                                    <button><i class="fa fa-save"></i>Lưu</button>
                                    <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản
                                        lý
                                    </button>
                                </div>
                            </div>

                            <div class="div12">
                                <h3>Chọn màu và hình cho sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
                                    </div>
                                    <select name="" id="valuemau">
                                        <option value="img/den.webp" selected>Đen</option>
                                        <option value="img/do.webp">Đỏ</option>
                                        <option value="img/docam.webp">Đỏ cam</option>
                                        <option value="img/hong.webp">Hồng</option>
                                        <option value="img/trang.webp">Trắng</option>
                                        <option value="img/vangdat.webp">Vàng đất</option>
                                        <option value="img/xam.webp">Xám</option>
                                        <option value="img/xanhdam.webp">Xanh đậm</option>
                                        <option value="img/xanhden.webp">Xanh đen</option>
                                        <option value="img/xanhngoc.webp">Xanh ngọc</option>
                                    </select>
                                </div>
                                <div class="buttondiv12">
                                    <button class="buttonthemmau" onclick="themmau2(this)"><i
                                            class="fa fa-plus"></i> Thêm
                                        màu
                                    </button>
                                    <button onclick="taomaumoi()">Tạo màu mới</button>
                                </div>
                                <div class="maudachon">
                                    <h3>Màu đã chọn</h3>
                                    <div class="listMau">
                                        <div class="listMauItem">
                                            <div class="listMauItemleft">
                                                <div>
                                                    <p>Đậm xanh</p>
                                                    <div>
                                                        <img src="../../img/product/damxanh.webp" alt="">
                                                    </div>
                                                </div>
                                                <div>
                                                    <div class="listHinh">
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp2.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp3.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                    </div>
                                                    <i class="fa fa-angle-left" onclick="movehinhleft2(this)"></i>
                                                    <i class="fa fa-angle-right" onclick="movehinhright2(this)"></i>
                                                    <input type="number" style="display: none;" value="0">
                                                </div>
                                            </div>
                                            <div class="removecolor">
                                                <button onclick="themhinh2(this)"><i class="fa fa-plus"></i></button>
                                                <button onclick="removecolor2(this)"><i
                                                        class="fa fa-trash"></i></button>
                                                <input type="file" style="display:none;"
                                                       onchange="loadIMG2(event,this)"/>
                                            </div>
                                        </div>
                                        <div class="listMauItem">
                                            <div class="listMauItemleft">
                                                <div>
                                                    <p>Đậm xanh</p>
                                                    <div>
                                                        <img src="../../img/product/xanhnhat.webp" alt="">
                                                    </div>
                                                </div>
                                                <div>
                                                    <div class="listHinh">
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp5.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp6.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp7.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp8.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                    </div>
                                                    <i class="fa fa-angle-left" onclick="movehinhleft2(this)"></i>
                                                    <i class="fa fa-angle-right" onclick="movehinhright2(this)"></i>
                                                    <input type="number" style="display: none;" value="0">
                                                </div>
                                            </div>
                                            <div class="removecolor">
                                                <button onclick="themhinh2(this)"><i class="fa fa-plus"></i></button>
                                                <button onclick="removecolor2(this)"><i
                                                        class="fa fa-trash"></i></button>
                                                <input type="file" style="display:none;"
                                                       onchange="loadIMG2(event,this)"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="div13">
                                <h3>Chọn size</h3>
                                <div class="linediv12"></div>
                                <div class="gioitinh">
                                    <h3>Lọại sản phẩm</h3>
                                    <div>
                                        <button onclick="ao2(this)">Áo</button>
                                        <button class="activebutton" onclick="quan2(this)">Quần</button>
                                    </div>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
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
                                <button onclick="themsize2(this)"><i class="fa fa-plus"></i> Thêm size</button>
                                <div class="sizedachon">
                                    <h3>Size đã chọn</h3>
                                    <div class="listSize">
                                        <div class="listSizeItem">
                                            <div>
                                                <i class="fa fa-circle"></i>
                                                <p>S</p>
                                            </div>
                                            <button onclick="removeSize2(this)"><i class="fa fa-trash"></i></button>
                                        </div>
                                        <div class="listSizeItem">
                                            <div>
                                                <i class="fa fa-circle"></i>
                                                <p>M</p>
                                            </div>
                                            <button onclick="removeSize2(this)"><i class="fa fa-trash"></i></button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>
                    <div class="item">
                        <label for="c1">
                            <input type="checkbox" name="" id="c1">
                        </label>

                        <div class="itemhdd">
                            <img src="../../img/product/dp1.webp" alt="">
                        </div>

                        <p class="itemname">
                            Áo Thun Croptop Nữ WTS 2037
                        </p>

                        <p class="itemtdm">
                            Quần jean
                        </p>

                        <div class="itemsize">
                            <div>
                                <p>S</p>
                            </div>
                            <div>
                                <p>M</p>
                            </div>
                            <div class="otherdiv">
                                <div></div>
                                <p>+2</p>
                                <p>L</p>
                            </div>
                        </div>

                        <div class="itemsize">
                            <div>
                                <img src="img/den.webp" alt="">
                            </div>
                            <div>
                                <img src="img/docam.webp" alt="">
                            </div>
                            <div class="otherdiv">
                                <div></div>
                                <p>+4</p>
                                <img src="img/xanhden.webp" alt="">
                            </div>
                        </div>

                        <p class="itemgia">
                            239,000 VND
                        </p>

                        <p class="itemsol">158</p>

                        <p class="itemngaytao">
                            20 Tháng Mưới 2020
                        </p>


                        <div class="itemsubmit" onclick="showselect(this)">
                            <input type="text" style="display: none;">
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <div>
                                <button onclick="editkhachhang(this)"><i class="fa fa-pencil"></i>Sửa</button>
                                <button onclick="removekhachhang(this)"><i class="fa fa-trash"></i>Xóa</button>
                            </div>
                        </div>

                        <div>
                            <div class="div11">
                                <h3>Thông tin sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Tên sản phẩm</label>
                                    </div>
                                    <input type="text" placeholder="Nhập tên sản phẩm ở đây">
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Hãng sản xuất</label>
                                        <div style="width: 10px;height: 25px;"></div>
                                    </div>
                                    <select name="" id="">
                                        <option value="" selected>Chọn hãng sản xuất</option>
                                        <option value="">Juno - Thương hiệu thời trang cao cấp</option>
                                        <option value="">An Phước – Tỉ mỉ trong từng đường kim mũi chỉ</option>
                                        <option value="">Việt Tiến - Thương hiệu của sự khẳng định</option>
                                        <option value="">NOVELTY - Vẻ đẹp của người Việt được tôn vinh</option>
                                        <option value="">BLUE EXCHANGE - Cuộc sống được làm đẹp</option>
                                        <option value="">May 10 - Thương hiệu của bảy thập kỉ</option>
                                        <option value="">PT2000 - Thời trang dành cho giới trẻ</option>
                                        <option value="">SEA Collection - Chuyên cung cấp các mặt hàng thời trang
                                            trẻ.
                                        </option>
                                        <option value="">Ninomaxx - Thương hiệu thời trang hàng đầu</option>
                                        <option value="">Nem Fashion</option>
                                        <option value="">ELISE</option>
                                        <option value="">Ivy Moda</option>
                                        <option value="">Chic-Land</option>
                                        <option value="">Owen</option>
                                        <option value="">Seven AM</option>
                                    </select>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Danh mục</label>
                                        <a href="quanLyDanhMuc.html">Thêm danh mục</a>
                                    </div>
                                    <select name="" id="">
                                        <option value="" selected>Chọn danh mục</option>
                                        <option value="">Áo thun tay dài</option>
                                        <option value="">Áo phong</option>
                                        <option value="">Áo len</option>
                                        <option value="">Áo sơ mi</option>
                                        <option value="">Áo khoác</option>
                                        <option value="">Quần jean</option>
                                        <option value="">Quần kaki</option>
                                        <option value="">Quần shorts</option>
                                        <option value="">Quần vải</option>
                                        <option value="">Đồ mặc nhà</option>
                                        <option value="">Quần áo thể thao</option>
                                        <option value="">Áo mặc trong</option>
                                    </select>
                                </div>
                                <div class="gioitinh">
                                    <h3>Giới tính</h3>
                                    <div>
                                        <button class="activebutton" id="gioitinhnam"
                                                onclick="nam2(this)">Nam
                                        </button>
                                        <button onclick="nu2(this)" id="gioitinhnu">Nữ</button>
                                    </div>
                                </div>
                                <div class="linediv12"></div>
                                <div class="div11submit">
                                    <button><i class="fa fa-save"></i>Lưu</button>
                                    <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản
                                        lý
                                    </button>
                                </div>
                            </div>

                            <div class="div12">
                                <h3>Chọn màu và hình cho sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
                                    </div>
                                    <select name="" id="valuemau">
                                        <option value="img/den.webp" selected>Đen</option>
                                        <option value="img/do.webp">Đỏ</option>
                                        <option value="img/docam.webp">Đỏ cam</option>
                                        <option value="img/hong.webp">Hồng</option>
                                        <option value="img/trang.webp">Trắng</option>
                                        <option value="img/vangdat.webp">Vàng đất</option>
                                        <option value="img/xam.webp">Xám</option>
                                        <option value="img/xanhdam.webp">Xanh đậm</option>
                                        <option value="img/xanhden.webp">Xanh đen</option>
                                        <option value="img/xanhngoc.webp">Xanh ngọc</option>
                                    </select>
                                </div>
                                <div class="buttondiv12">
                                    <button class="buttonthemmau" onclick="themmau2(this)"><i
                                            class="fa fa-plus"></i> Thêm
                                        màu
                                    </button>
                                    <button onclick="taomaumoi()">Tạo màu mới</button>
                                </div>
                                <div class="maudachon">
                                    <h3>Màu đã chọn</h3>
                                    <div class="listMau">
                                        <div class="listMauItem">
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
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp2.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp3.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp2.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp3.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                    </div>
                                                    <i class="fa fa-angle-left" onclick="movehinhleft2(this)"></i>
                                                    <i class="fa fa-angle-right" onclick="movehinhright2(this)"></i>
                                                    <input type="number" style="display: none;" value="0">
                                                </div>
                                            </div>
                                            <div class="removecolor">
                                                <button onclick="themhinh2(this)"><i class="fa fa-plus"></i></button>
                                                <button onclick="removecolor2(this)"><i
                                                        class="fa fa-trash"></i></button>
                                                <input type="file" style="display:none;"
                                                       onchange="loadIMG2(event,this)"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="div13">
                                <h3>Chọn size</h3>
                                <div class="linediv12"></div>
                                <div class="gioitinh">
                                    <h3>Lọại sản phẩm</h3>
                                    <div>
                                        <button class="activebutton" onclick="ao2(this)">Áo</button>
                                        <button onclick="quan2(this)">Quần</button>
                                    </div>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
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
                                <button onclick="themsize2(this)"><i class="fa fa-plus"></i> Thêm size</button>
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
                    <div class="item">
                        <label for="c1">
                            <input type="checkbox" name="" id="c1">
                        </label>

                        <div class="itemhdd">
                            <img src="../../img/product/dp1.webp" alt="">
                        </div>

                        <p class="itemname">
                            Quần Jeans Nữ Tưa Lai Túi Lệch WJL 4011
                        </p>

                        <p class="itemtdm">
                            Quần jean
                        </p>

                        <div class="itemsize">
                            <div>
                                <p>S</p>
                            </div>
                            <div>
                                <p>M</p>
                            </div>
                        </div>

                        <div class="itemsize">
                            <div>
                                <img src="../../img/product/damxanh.webp" alt="">
                            </div>
                            <div>
                                <img src="../../img/product/xanhnhat.webp" alt="">
                            </div>
                        </div>

                        <p class="itemgia">
                            319,000 VND
                        </p>

                        <p class="itemsol">38</p>

                        <p class="itemngaytao">
                            20 Tháng Mưới 2020
                        </p>


                        <div class="itemsubmit" onclick="showselect(this)">
                            <input type="text" style="display: none;">
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <div>
                                <button onclick="editkhachhang(this)"><i class="fa fa-pencil"></i>Sửa</button>
                                <button onclick="removekhachhang(this)"><i class="fa fa-trash"></i>Xóa</button>
                            </div>
                        </div>

                        <div>
                            <div class="div11">
                                <h3>Thông tin sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Tên sản phẩm</label>
                                    </div>
                                    <input type="text" placeholder="Nhập tên sản phẩm ở đây"
                                           value="Quần Jeans Nữ Tưa Lai Túi Lệch WJL 4011">
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Hãng sản xuất</label>
                                        <div style="width: 10px;height: 25px;"></div>
                                    </div>
                                    <select name="" id="">
                                        <option value="">Chọn hãng sản xuất</option>
                                        <option value="" selected>Juno - Thương hiệu thời trang cao cấp</option>
                                        <option value="">An Phước – Tỉ mỉ trong từng đường kim mũi chỉ</option>
                                        <option value="">Việt Tiến - Thương hiệu của sự khẳng định</option>
                                        <option value="">NOVELTY - Vẻ đẹp của người Việt được tôn vinh</option>
                                        <option value="">BLUE EXCHANGE - Cuộc sống được làm đẹp</option>
                                        <option value="">May 10 - Thương hiệu của bảy thập kỉ</option>
                                        <option value="">PT2000 - Thời trang dành cho giới trẻ</option>
                                        <option value="">SEA Collection - Chuyên cung cấp các mặt hàng thời trang
                                            trẻ.
                                        </option>
                                        <option value="">Ninomaxx - Thương hiệu thời trang hàng đầu</option>
                                        <option value="">Nem Fashion</option>
                                        <option value="">ELISE</option>
                                        <option value="">Ivy Moda</option>
                                        <option value="">Chic-Land</option>
                                        <option value="">Owen</option>
                                        <option value="">Seven AM</option>
                                    </select>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Danh mục</label>
                                        <a href="quanLyDanhMuc.html">Thêm danh mục</a>
                                    </div>
                                    <select name="" id="">
                                        <option value="">Chọn danh mục</option>
                                        <option value="">Áo thun nữ</option>
                                        <option value="">Áo thun tay dài</option>
                                        <option value="">Áo phong</option>
                                        <option value="">Áo len</option>
                                        <option value="">Áo sơ mi</option>
                                        <option value="">Áo khoác</option>
                                        <option value="" selected>Quần jean</option>
                                        <option value="">Quần kaki</option>
                                        <option value="">Quần shorts</option>
                                        <option value="">Quần vải</option>
                                        <option value="">Đồ mặc nhà</option>
                                        <option value="">Quần áo thể thao</option>
                                        <option value="">Áo mặc trong</option>
                                    </select>
                                </div>
                                <div class="gioitinh">
                                    <h3>Giới tính</h3>
                                    <div>
                                        <button id="gioitinhnam" onclick="nam2(this)">Nam</button>
                                        <button class="activebutton" onclick="nu2(this)" id="gioitinhnu">Nữ</button>
                                    </div>
                                </div>
                                <div class="linediv12"></div>
                                <div class="div11submit">
                                    <button><i class="fa fa-save"></i>Lưu</button>
                                    <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản
                                        lý
                                    </button>
                                </div>
                            </div>

                            <div class="div12">
                                <h3>Chọn màu và hình cho sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
                                    </div>
                                    <select name="" id="valuemau">
                                        <option value="img/den.webp" selected>Đen</option>
                                        <option value="img/do.webp">Đỏ</option>
                                        <option value="img/docam.webp">Đỏ cam</option>
                                        <option value="img/hong.webp">Hồng</option>
                                        <option value="img/trang.webp">Trắng</option>
                                        <option value="img/vangdat.webp">Vàng đất</option>
                                        <option value="img/xam.webp">Xám</option>
                                        <option value="img/xanhdam.webp">Xanh đậm</option>
                                        <option value="img/xanhden.webp">Xanh đen</option>
                                        <option value="img/xanhngoc.webp">Xanh ngọc</option>
                                    </select>
                                </div>
                                <div class="buttondiv12">
                                    <button class="buttonthemmau" onclick="themmau2(this)"><i
                                            class="fa fa-plus"></i> Thêm
                                        màu
                                    </button>
                                    <button onclick="taomaumoi()">Tạo màu mới</button>
                                </div>
                                <div class="maudachon">
                                    <h3>Màu đã chọn</h3>
                                    <div class="listMau">
                                        <div class="listMauItem">
                                            <div class="listMauItemleft">
                                                <div>
                                                    <p>Đậm xanh</p>
                                                    <div>
                                                        <img src="../../img/product/damxanh.webp" alt="">
                                                    </div>
                                                </div>
                                                <div>
                                                    <div class="listHinh">
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp2.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp3.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                    </div>
                                                    <i class="fa fa-angle-left" onclick="movehinhleft2(this)"></i>
                                                    <i class="fa fa-angle-right" onclick="movehinhright2(this)"></i>
                                                    <input type="number" style="display: none;" value="0">
                                                </div>
                                            </div>
                                            <div class="removecolor">
                                                <button onclick="themhinh2(this)"><i class="fa fa-plus"></i></button>
                                                <button onclick="removecolor2(this)"><i
                                                        class="fa fa-trash"></i></button>
                                                <input type="file" style="display:none;"
                                                       onchange="loadIMG2(event,this)"/>
                                            </div>
                                        </div>
                                        <div class="listMauItem">
                                            <div class="listMauItemleft">
                                                <div>
                                                    <p>Đậm xanh</p>
                                                    <div>
                                                        <img src="../../img/product/xanhnhat.webp" alt="">
                                                    </div>
                                                </div>
                                                <div>
                                                    <div class="listHinh">
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp5.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp6.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp7.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp8.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                    </div>
                                                    <i class="fa fa-angle-left" onclick="movehinhleft2(this)"></i>
                                                    <i class="fa fa-angle-right" onclick="movehinhright2(this)"></i>
                                                    <input type="number" style="display: none;" value="0">
                                                </div>
                                            </div>
                                            <div class="removecolor">
                                                <button onclick="themhinh2(this)"><i class="fa fa-plus"></i></button>
                                                <button onclick="removecolor2(this)"><i
                                                        class="fa fa-trash"></i></button>
                                                <input type="file" style="display:none;"
                                                       onchange="loadIMG2(event,this)"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="div13">
                                <h3>Chọn size</h3>
                                <div class="linediv12"></div>
                                <div class="gioitinh">
                                    <h3>Lọại sản phẩm</h3>
                                    <div>
                                        <button onclick="ao2(this)">Áo</button>
                                        <button class="activebutton" onclick="quan2(this)">Quần</button>
                                    </div>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
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
                                <button onclick="themsize2(this)"><i class="fa fa-plus"></i> Thêm size</button>
                                <div class="sizedachon">
                                    <h3>Size đã chọn</h3>
                                    <div class="listSize">
                                        <div class="listSizeItem">
                                            <div>
                                                <i class="fa fa-circle"></i>
                                                <p>S</p>
                                            </div>
                                            <button onclick="removeSize2(this)"><i class="fa fa-trash"></i></button>
                                        </div>
                                        <div class="listSizeItem">
                                            <div>
                                                <i class="fa fa-circle"></i>
                                                <p>M</p>
                                            </div>
                                            <button onclick="removeSize2(this)"><i class="fa fa-trash"></i></button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>
                    <div class="item">
                        <label for="c1">
                            <input type="checkbox" name="" id="c1">
                        </label>

                        <div class="itemhdd">
                            <img src="../../img/product/dp1.webp" alt="">
                        </div>

                        <p class="itemname">
                            Áo Thun Croptop Nữ WTS 2037
                        </p>

                        <p class="itemtdm">
                            Quần jean
                        </p>

                        <div class="itemsize">
                            <div>
                                <p>S</p>
                            </div>
                            <div>
                                <p>M</p>
                            </div>
                            <div class="otherdiv">
                                <div></div>
                                <p>+2</p>
                                <p>L</p>
                            </div>
                        </div>

                        <div class="itemsize">
                            <div>
                                <img src="img/den.webp" alt="">
                            </div>
                            <div>
                                <img src="img/docam.webp" alt="">
                            </div>
                            <div class="otherdiv">
                                <div></div>
                                <p>+4</p>
                                <img src="img/xanhden.webp" alt="">
                            </div>
                        </div>

                        <p class="itemgia">
                            239,000 VND
                        </p>

                        <p class="itemsol">158</p>

                        <p class="itemngaytao">
                            20 Tháng Mưới 2020
                        </p>


                        <div class="itemsubmit" onclick="showselect(this)">
                            <input type="text" style="display: none;">
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <div>
                                <button onclick="editkhachhang(this)"><i class="fa fa-pencil"></i>Sửa</button>
                                <button onclick="removekhachhang(this)"><i class="fa fa-trash"></i>Xóa</button>
                            </div>
                        </div>

                        <div>
                            <div class="div11">
                                <h3>Thông tin sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Tên sản phẩm</label>
                                    </div>
                                    <input type="text" placeholder="Nhập tên sản phẩm ở đây">
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Hãng sản xuất</label>
                                        <div style="width: 10px;height: 25px;"></div>
                                    </div>
                                    <select name="" id="">
                                        <option value="" selected>Chọn hãng sản xuất</option>
                                        <option value="">Juno - Thương hiệu thời trang cao cấp</option>
                                        <option value="">An Phước – Tỉ mỉ trong từng đường kim mũi chỉ</option>
                                        <option value="">Việt Tiến - Thương hiệu của sự khẳng định</option>
                                        <option value="">NOVELTY - Vẻ đẹp của người Việt được tôn vinh</option>
                                        <option value="">BLUE EXCHANGE - Cuộc sống được làm đẹp</option>
                                        <option value="">May 10 - Thương hiệu của bảy thập kỉ</option>
                                        <option value="">PT2000 - Thời trang dành cho giới trẻ</option>
                                        <option value="">SEA Collection - Chuyên cung cấp các mặt hàng thời trang
                                            trẻ.
                                        </option>
                                        <option value="">Ninomaxx - Thương hiệu thời trang hàng đầu</option>
                                        <option value="">Nem Fashion</option>
                                        <option value="">ELISE</option>
                                        <option value="">Ivy Moda</option>
                                        <option value="">Chic-Land</option>
                                        <option value="">Owen</option>
                                        <option value="">Seven AM</option>
                                    </select>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Danh mục</label>
                                        <a href="quanLyDanhMuc.html">Thêm danh mục</a>
                                    </div>
                                    <select name="" id="">
                                        <option value="" selected>Chọn danh mục</option>
                                        <option value="">Áo thun tay dài</option>
                                        <option value="">Áo phong</option>
                                        <option value="">Áo len</option>
                                        <option value="">Áo sơ mi</option>
                                        <option value="">Áo khoác</option>
                                        <option value="">Quần jean</option>
                                        <option value="">Quần kaki</option>
                                        <option value="">Quần shorts</option>
                                        <option value="">Quần vải</option>
                                        <option value="">Đồ mặc nhà</option>
                                        <option value="">Quần áo thể thao</option>
                                        <option value="">Áo mặc trong</option>
                                    </select>
                                </div>
                                <div class="gioitinh">
                                    <h3>Giới tính</h3>
                                    <div>
                                        <button class="activebutton" id="gioitinhnam"
                                                onclick="nam2(this)">Nam
                                        </button>
                                        <button onclick="nu2(this)" id="gioitinhnu">Nữ</button>
                                    </div>
                                </div>
                                <div class="linediv12"></div>
                                <div class="div11submit">
                                    <button><i class="fa fa-save"></i>Lưu</button>
                                    <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản
                                        lý
                                    </button>
                                </div>
                            </div>

                            <div class="div12">
                                <h3>Chọn màu và hình cho sản phẩm</h3>
                                <div class="linediv12"></div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
                                    </div>
                                    <select name="" id="valuemau">
                                        <option value="img/den.webp" selected>Đen</option>
                                        <option value="img/do.webp">Đỏ</option>
                                        <option value="img/docam.webp">Đỏ cam</option>
                                        <option value="img/hong.webp">Hồng</option>
                                        <option value="img/trang.webp">Trắng</option>
                                        <option value="img/vangdat.webp">Vàng đất</option>
                                        <option value="img/xam.webp">Xám</option>
                                        <option value="img/xanhdam.webp">Xanh đậm</option>
                                        <option value="img/xanhden.webp">Xanh đen</option>
                                        <option value="img/xanhngoc.webp">Xanh ngọc</option>
                                    </select>
                                </div>
                                <div class="buttondiv12">
                                    <button class="buttonthemmau" onclick="themmau2(this)"><i
                                            class="fa fa-plus"></i> Thêm
                                        màu
                                    </button>
                                    <button onclick="taomaumoi()">Tạo màu mới</button>
                                </div>
                                <div class="maudachon">
                                    <h3>Màu đã chọn</h3>
                                    <div class="listMau">
                                        <div class="listMauItem">
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
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp1.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp2.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp3.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp2.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp3.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                        <div class="listHinhitem">
                                                            <img src="../../img/product/dp4.webp" alt="">
                                                            <i class="fa fa-close"
                                                               onclick="removehinhitem2(this)"></i>
                                                        </div>
                                                    </div>
                                                    <i class="fa fa-angle-left" onclick="movehinhleft2(this)"></i>
                                                    <i class="fa fa-angle-right" onclick="movehinhright2(this)"></i>
                                                    <input type="number" style="display: none;" value="0">
                                                </div>
                                            </div>
                                            <div class="removecolor">
                                                <button onclick="themhinh2(this)"><i class="fa fa-plus"></i></button>
                                                <button onclick="removecolor2(this)"><i
                                                        class="fa fa-trash"></i></button>
                                                <input type="file" style="display:none;"
                                                       onchange="loadIMG2(event,this)"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="div13">
                                <h3>Chọn size</h3>
                                <div class="linediv12"></div>
                                <div class="gioitinh">
                                    <h3>Lọại sản phẩm</h3>
                                    <div>
                                        <button class="activebutton" onclick="ao2(this)">Áo</button>
                                        <button onclick="quan2(this)">Quần</button>
                                    </div>
                                </div>
                                <div class="div12inputlv2">
                                    <div>
                                        <label for="">Size</label>
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
                                <button onclick="themsize2(this)"><i class="fa fa-plus"></i> Thêm size</button>
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

                </div>
            </div>
        </div>

        <div id="div1">
            <div>
                <div class="div11">
                    <h3>Thông tin sản phẩm</h3>
                    <div class="linediv12"></div>
                    <div class="div12inputlv2">
                        <div>
                            <label for="">Tên sản phẩm</label>
                        </div>
                        <input type="text" placeholder="Nhập tên sản phẩm ở đây">
                    </div>
                    <div class="div12inputlv2">
                        <div>
                            <label for="">Hãng sản xuất</label>
                            <div style="width: 10px;height: 25px;"></div>
                        </div>
                        <select name="" id="">
                            <option value="" selected>Chọn hãng sản xuất</option>
                            <option value="">Juno - Thương hiệu thời trang cao cấp</option>
                            <option value="">An Phước – Tỉ mỉ trong từng đường kim mũi chỉ</option>
                            <option value="">Việt Tiến - Thương hiệu của sự khẳng định</option>
                            <option value="">NOVELTY - Vẻ đẹp của người Việt được tôn vinh</option>
                            <option value="">BLUE EXCHANGE - Cuộc sống được làm đẹp</option>
                            <option value="">May 10 - Thương hiệu của bảy thập kỉ</option>
                            <option value="">PT2000 - Thời trang dành cho giới trẻ</option>
                            <option value="">SEA Collection - Chuyên cung cấp các mặt hàng thời trang trẻ.</option>
                            <option value="">Ninomaxx - Thương hiệu thời trang hàng đầu</option>
                            <option value="">Nem Fashion</option>
                            <option value="">ELISE</option>
                            <option value="">Ivy Moda</option>
                            <option value="">Chic-Land</option>
                            <option value="">Owen</option>
                            <option value="">Seven AM</option>
                        </select>
                    </div>
                    <div class="div12inputlv2">
                        <div>
                            <label for="">Danh mục</label>
                            <a href="quanLyDanhMuc.html">Thêm danh mục</a>
                        </div>
                        <select name="" id="">
                            <option value="" selected>Chọn danh mục</option>
                            <option value="">Áo thun tay dài</option>
                            <option value="">Áo phong</option>
                            <option value="">Áo len</option>
                            <option value="">Áo sơ mi</option>
                            <option value="">Áo khoác</option>
                            <option value="">Quần jean</option>
                            <option value="">Quần kaki</option>
                            <option value="">Quần shorts</option>
                            <option value="">Quần vải</option>
                            <option value="">Đồ mặc nhà</option>
                            <option value="">Quần áo thể thao</option>
                            <option value="">Áo mặc trong</option>
                        </select>
                    </div>
                    <div class="gioitinh">
                        <h3>Giới tính</h3>
                        <div>
                            <button class="activebutton" id="gioitinhnam" onclick="nam()">Nam</button>
                            <button onclick="nu()" id="gioitinhnu">Nữ</button>
                        </div>
                    </div>
                    <div class="linediv12"></div>
                    <div class="div11submit">
                        <button><i class="fa fa-plus"></i>Thêm sản phẩm</button>
                        <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản lý</button>
                    </div>
                </div>

                <div class="div12">
                    <h3>Chọn màu và hình cho sản phẩm</h3>
                    <div class="linediv12"></div>
                    <div class="div12inputlv2">
                        <div>
                            <label for="">Size</label>
                        </div>
                        <select name="" id="valuemau">
                            <option value="img/den.webp" selected>Đen</option>
                            <option value="img/do.webp">Đỏ</option>
                            <option value="img/docam.webp">Đỏ cam</option>
                            <option value="img/hong.webp">Hồng</option>
                            <option value="img/trang.webp">Trắng</option>
                            <option value="img/vangdat.webp">Vàng đất</option>
                            <option value="img/xam.webp">Xám</option>
                            <option value="img/xanhdam.webp">Xanh đậm</option>
                            <option value="img/xanhden.webp">Xanh đen</option>
                            <option value="img/xanhngoc.webp">Xanh ngọc</option>
                        </select>
                    </div>
                    <div class="buttondiv12">
                        <button class="buttonthemmau" onclick="themmau(this)"><i class="fa fa-plus"></i> Thêm
                            màu
                        </button>
                        <button onclick="taomaumoi()">Tạo màu mới</button>
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
                </div>

                <div class="div13">
                    <h3>Chọn size</h3>
                    <div class="linediv12"></div>
                    <div class="gioitinh">
                        <h3>Lọại sản phẩm</h3>
                        <div>
                            <button class="activebutton" onclick="ao(this)">Áo</button>
                            <button onclick="quan(this)">Quần</button>
                        </div>
                    </div>
                    <div class="div12inputlv2">
                        <div>
                            <label for="">Size</label>
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
                    <button onclick="themsize(this)"><i class="fa fa-plus"></i> Thêm size</button>
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

        <div id="div3">
            <div>
                <div class="div11">
                    <h3>Thông tin sản phẩm</h3>
                    <div class="linediv12"></div>
                    <div class="div12inputlv2">
                        <div>
                            <label for="">Tên sản phẩm</label>
                        </div>
                        <input type="text" placeholder="Nhập tên sản phẩm ở đây">
                    </div>
                    <div class="div12inputlv2">
                        <div>
                            <label for="">Hãng sản xuất</label>
                            <div style="width: 10px;height: 25px;"></div>
                        </div>
                        <select name="" id="">
                            <option value="" selected>Chọn hãng sản xuất</option>
                            <option value="">Juno - Thương hiệu thời trang cao cấp</option>
                            <option value="">An Phước – Tỉ mỉ trong từng đường kim mũi chỉ</option>
                            <option value="">Việt Tiến - Thương hiệu của sự khẳng định</option>
                            <option value="">NOVELTY - Vẻ đẹp của người Việt được tôn vinh</option>
                            <option value="">BLUE EXCHANGE - Cuộc sống được làm đẹp</option>
                            <option value="">May 10 - Thương hiệu của bảy thập kỉ</option>
                            <option value="">PT2000 - Thời trang dành cho giới trẻ</option>
                            <option value="">SEA Collection - Chuyên cung cấp các mặt hàng thời trang trẻ.</option>
                            <option value="">Ninomaxx - Thương hiệu thời trang hàng đầu</option>
                            <option value="">Nem Fashion</option>
                            <option value="">ELISE</option>
                            <option value="">Ivy Moda</option>
                            <option value="">Chic-Land</option>
                            <option value="">Owen</option>
                            <option value="">Seven AM</option>
                        </select>
                    </div>
                    <div class="div12inputlv2">
                        <div>
                            <label for="">Danh mục</label>
                            <a href="quanLyDanhMuc.html">Thêm danh mục</a>
                        </div>
                        <select name="" id="">
                            <option value="" selected>Chọn danh mục</option>
                            <option value="">Áo thun tay dài</option>
                            <option value="">Áo phong</option>
                            <option value="">Áo len</option>
                            <option value="">Áo sơ mi</option>
                            <option value="">Áo khoác</option>
                            <option value="">Quần jean</option>
                            <option value="">Quần kaki</option>
                            <option value="">Quần shorts</option>
                            <option value="">Quần vải</option>
                            <option value="">Đồ mặc nhà</option>
                            <option value="">Quần áo thể thao</option>
                            <option value="">Áo mặc trong</option>
                        </select>
                    </div>
                    <div class="gioitinh">
                        <h3>Giới tính</h3>
                        <div>
                            <button class="activebutton" id="gioitinhnam" onclick="nam()">Nam</button>
                            <button onclick="nu()" id="gioitinhnu">Nữ</button>
                        </div>
                    </div>
                    <div class="linediv12"></div>
                    <div class="div11submit">
                        <button><i class="fa fa-plus"></i>Thêm sản phẩm</button>
                        <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản lý</button>
                    </div>
                </div>

                <div class="div12">
                    <h3>Chọn màu và hình cho sản phẩm</h3>
                    <div class="linediv12"></div>
                    <div class="div12inputlv2">
                        <div>
                            <label for="">Size</label>
                        </div>
                        <select name="" id="valuemau">
                            <option value="img/den.webp" selected>Đen</option>
                            <option value="img/do.webp">Đỏ</option>
                            <option value="img/docam.webp">Đỏ cam</option>
                            <option value="img/hong.webp">Hồng</option>
                            <option value="img/trang.webp">Trắng</option>
                            <option value="img/vangdat.webp">Vàng đất</option>
                            <option value="img/xam.webp">Xám</option>
                            <option value="img/xanhdam.webp">Xanh đậm</option>
                            <option value="img/xanhden.webp">Xanh đen</option>
                            <option value="img/xanhngoc.webp">Xanh ngọc</option>
                        </select>
                    </div>
                    <div class="buttondiv12">
                        <button class="buttonthemmau" onclick="themmau(this)"><i class="fa fa-plus"></i> Thêm
                            màu
                        </button>
                        <button onclick="taomaumoi()">Tạo màu mới</button>
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
                </div>

                <div class="div13">
                    <h3>Chọn size</h3>
                    <div class="linediv12"></div>
                    <div class="gioitinh">
                        <h3>Lọại sản phẩm</h3>
                        <div>
                            <button class="activebutton" onclick="ao(this)">Áo</button>
                            <button onclick="quan(this)">Quần</button>
                        </div>
                    </div>
                    <div class="div12inputlv2">
                        <div>
                            <label for="">Size</label>
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
                    <button onclick="themsize(this)"><i class="fa fa-plus"></i> Thêm size</button>
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
    </div>

    <!-- Quan tâm nhiêu đây thôi-->
</div>

</body>

</html>

<script src="../../js/quanLySanPhamAdmin.js"></script>