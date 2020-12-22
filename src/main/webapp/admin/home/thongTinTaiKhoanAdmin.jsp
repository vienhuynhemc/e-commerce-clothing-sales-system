<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/12/2020
  Time: 9:11 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVTSHOP ADMIN | Tài khoản Admin</title>
    <link rel="stylesheet" href="../../fonts/font-awesome-4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="../../css/indexAdmin.css">
    <script src="../../js/indexAdmin.js"></script>

    <link rel="stylesheet" href="../../css/thongTinTaiKhoanAdminAdmin.css">
    <script src="../../js/thongTinTaiKhoanAdminAdmin.js"></script>

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
                    <li><a href="quanLyKhachHang.html"><i class="fa fa-users"></i>Khách hàng</a></li>
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
                </ul>
                <input type="checkbox" style="display: none;">
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
                <div class="active">
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
            <div class="div1">
                <div>
                    <div>
                        <p>Nguyễn Thị Hoa Hồng</p>
                        <p>Admin</p>
                    </div>
                </div>

                <div class="headeright">
                    <div>
                        <button id="motchutvetoi" class="activebutton" onclick="motchutvetoi()">Một chút về
                            tôi
                        </button>
                        <button id="thongtinchitiet" onclick="thongtinchitiet()">Thông tin chi tiết</button>
                    </div>
                    <div>
                        <button onclick="thaydoithongtin()"><i class="fa fa-cog"></i>Thay đổi thông tin</button>
                    </div>
                </div>
                <div class="hinhdaidien">
                    <div>
                        <img src="../../img/product/avatar7.jpg" alt="">
                    </div>
                </div>
            </div>
            <div class="adiv12">
                <div class="div121" id="div121">
                    <div>
                        <h3>Giới thiệu: </h3>
                        <p>Phải tôi đôi order thêm mấy món, hehe giỡn thôi.<br>Được đảm nhận công việc này tôi cảm
                            thấy
                            tôi là một người rất may mắn khi được giao đúng công việc mình yêu thích sau một thời
                            gian
                            dài đóng gói và vận chuyển :((</p>
                    </div>
                    <div>
                        <div>
                            <p>370</p>
                            <p>Thao tác đơn hàng</p>
                        </div>
                        <div>
                            <p>42</p>
                            <p>Số lần nhập hàng</p>
                        </div>
                        <div>
                            <p>4200</p>
                            <p>Số sản phẩm nhập</p>
                        </div>
                    </div>
                </div>
                <div class="div122" id="div122">
                    <div class="div122item">
                        <p>Họ và tên: </p>
                        <p>Nguyễn Thị Hồng</p>
                    </div>
                    <div class="div122item">
                        <p>Email: </p>
                        <p>nguyenthihoahong@gmail.com</p>
                    </div>
                    <div class="div122item">
                        <p>Số điện thoại: </p>
                        <p>0971-122-209</p>
                    </div>
                    <div class="div122item">
                        <p>Tên hiển thị: </p>
                        <p></p>
                    </div>
                    <div class="div122item">
                        <p>Tài khoản: </p>
                        <p>adminhong</p>
                    </div>
                    <div class="div122item">
                        <p>Mật khẩu: </p>
                        <p>Không hiển thị</p>
                    </div>
                    <div class="div122item">
                        <p>Địa chỉ: </p>
                        <p>Xã Đa Lộc - Huyển Đồng Xuân - Tỉnh Phú Yên</p>
                    </div>
                    <div class="div122item">
                        <p>Lương: </p>
                        <p>20,000,000 VND</p>
                    </div>
                </div>
            </div>

            <div class="adiv13">
                <div class="div31">
                    <h3>
                        <div class="iconheader"></div>
                        Lịch sử hành động của bạn
                        <div class="lineh3header"></div>
                    </h3>
                    <div>
                        <div>
                            <div class="div31item">
                                <div class="div31itemcolor1">
                                    <i class="fa fa-circle"></i>
                                    <div></div>
                                </div>
                                <div>
                                    <p>5 giây trước</p>
                                    <p><strong>Bạn</strong> vừa duyệt đơn hàng
                                        <strong>DH1003</strong> cho nhân viên kho <strong>Nguyễn Văn A</strong>
                                    </p>
                                </div>
                            </div>
                            <div class="div31item">
                                <div class="div31itemcolor2">
                                    <i class="fa fa-circle"></i>
                                    <div></div>
                                </div>
                                <div>
                                    <p>24 giây trước</p>
                                    <p><strong>Bạn</strong> vừa duyệt đơn hàng
                                        <strong>DH1002</strong> cho nhân viên kho <strong>Nguyễn Văn A</strong>
                                    </p>
                                </div>
                            </div>
                            <div class="div31item">
                                <div class="div31itemcolor3">
                                    <i class="fa fa-circle"></i>
                                    <div></div>
                                </div>
                                <div>
                                    <p>58 giây trước</p>
                                    <p><strong>Bạn</strong> vừa duyệt đơn hàng
                                        <strong>DH1001</strong> cho nhân viên kho <strong>Nguyễn Văn A</strong>
                                    </p>
                                </div>
                            </div>
                            <div class="div31item">
                                <div class="div31itemcolor4">
                                    <i class="fa fa-circle"></i>
                                    <div></div>
                                </div>
                                <div>
                                    <p>1 phút trước</p>
                                    <p><strong>Bạn</strong> vừa duyệt đơn hàng
                                        <strong>DH1000</strong> cho nhân viên kho <strong>Nguyễn Văn B</strong>
                                    </p>
                                </div>
                            </div>
                            <div class="div31item">
                                <div class="div31itemcolor1">
                                    <i class="fa fa-circle"></i>
                                    <div></div>
                                </div>
                                <div>
                                    <p>3 phút trước</p>
                                    <p><strong>Bạn</strong> vừa duyệt đơn hàng
                                        <strong>DH0999</strong> cho nhân viên kho <strong>Nguyễn Văn C</strong>
                                    </p>
                                </div>
                            </div>
                            <div class="div31item">
                                <div class="div31itemcolor2">
                                    <i class="fa fa-circle"></i>
                                    <div></div>
                                </div>
                                <div>
                                    <p>12 phút trước</p>
                                    <p><strong>Bạn</strong> vừa duyệt đơn hàng
                                        <strong>DH0998</strong> cho nhân viên kho <strong>Nguyễn Văn D</strong>
                                    </p>
                                </div>
                            </div>
                            <div class="div31item">
                                <div class="div31itemcolor3">
                                    <i class="fa fa-circle"></i>
                                    <div></div>
                                </div>
                                <div>
                                    <p>14 phút trước</p>
                                    <p><strong>Bạn</strong> vừa duyệt đơn hàng
                                        <strong>DH0997</strong> cho nhân viên kho <strong>Nguyễn Văn E</strong>
                                    </p>
                                </div>
                            </div>
                            <div class="div31item">
                                <div class="div31itemcolor4">
                                    <i class="fa fa-circle"></i>
                                    <div></div>
                                </div>
                                <div>
                                    <p>17 phút trước</p>
                                    <p><strong>Bạn</strong> vừa duyệt đơn hàng
                                        <strong>DH0996</strong> cho nhân viên kho <strong>Nguyễn Văn A</strong>
                                    </p>
                                </div>
                            </div>
                            <div class="div31item">
                                <div class="div31itemcolor1">
                                    <i class="fa fa-circle"></i>
                                    <div></div>
                                </div>
                                <div>
                                    <p>22 phút trước</p>
                                    <p><strong>Bạn</strong> vừa duyệt đơn hàng
                                        <strong>DH0995</strong> cho nhân viên kho <strong>Nguyễn Văn B</strong>
                                    </p>
                                </div>
                            </div>
                            <div class="div31item">
                                <div class="div31itemcolor2">
                                    <i class="fa fa-circle"></i>
                                    <div></div>
                                </div>
                                <div>
                                    <p>42 phút trước</p>
                                    <p><strong>Bạn</strong> vừa duyệt đơn hàng
                                        <strong>DH0994</strong> cho nhân viên kho <strong>Nguyễn Văn E</strong>
                                    </p>
                                </div>
                            </div>
                            <div class="div31item">
                                <div class="div31itemcolor3">
                                    <i class="fa fa-circle"></i>
                                    <div></div>
                                </div>
                                <div>
                                    <p>58 phút trước</p>
                                    <p><strong>Bạn</strong> vừa duyệt đơn hàng
                                        <strong>DH0993</strong> cho nhân viên kho <strong>Nguyễn Văn A</strong>
                                    </p>
                                </div>
                            </div>
                            <div class="div31item">
                                <div class="div31itemcolor4">
                                    <i class="fa fa-circle"></i>
                                    <div></div>
                                </div>
                                <div>
                                    <p>1 giờ trước</p>
                                    <p><strong>Bạn</strong> vừa duyệt đơn hàng
                                        <strong>DH0992</strong> cho nhân viên kho <strong>Nguyễn Văn D</strong>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="div3">
            <div>
                <div class="div11">
                    <h3>Hồ sơ của bạn</h3>
                    <input id="fileInput1" type="file" style="display:none;" onchange="loadIMG2(event,this)"/>
                    <div class="div11daidien" onclick="document.getElementById('fileInput1').click()">
                        <div>
                            <img src="../../img/product/avatar7.jpg" alt="">
                        </div>
                    </div>

                    <button onclick="document.getElementById('fileInput1').click()">Thay đổi
                        ảnh đại diện
                        mới
                    </button>
                    <button onclick="removeIMG2()">Xóa ảnh đại diện</button>

                </div>

                <div class="div12">
                    <h3>Điền thông tin cá nhân</h3>
                    <div class="linediv12"></div>
                    <div class="div12input">
                        <label for="">* Họ và tên</label>
                        <input type="text" placeholder="Nhập họ và tên ở đây" value="Nguyễn Thị Hoa Hồng">
                    </div>
                    <div class="div12input">
                        <label for="">Tên hiển thị</label>
                        <input type="text" placeholder="Nhập tên hiển thị ở đây" value="">
                    </div>
                    <div class="div12input">
                        <label for="">* Email</label>
                        <input type="text" placeholder="Nhập email ở đây" value="nguyenthihoahong@gmail.com"
                               disabled>
                    </div>
                    <div class="div12input">
                        <label for="">* Số điện thoại</label>
                        <input type="text" placeholder="Nhập số điện thoại ở đây" value="0971-122-209" disabled>
                    </div>
                    <div class="linediv12"></div>
                    <div class="trangthai">
                        <div class="div12inputlv2">
                            <label for="">Tỉnh / Thành</label>
                            <select name="" id="">
                                <option value="">Chọn tỉnh / thành</option>
                                <option value="" selected>Phú Yên</option>
                            </select>
                        </div>
                        <div class="div12inputlv2">
                            <label for="">Quận / huyện</label>
                            <select name="" id="">
                                <option value="">Chọn quận / huyện</option>
                                <option value="" selected>Huyện Đồng Xuân</option>
                            </select>
                        </div>
                        <div class="div12inputlv2">
                            <label for="">Phường / xã</label>
                            <select name="" id="">
                                <option value="">Chọn phường / xã</option>
                                <option value="" selected>Xã Đa Lộc</option>
                            </select>
                        </div>
                    </div>
                    <div class="linediv12"></div>
                    <div class="div12input">
                        <label for="">* Tài khoản</label>
                        <input type="text" placeholder="Nhập tên tài khoản ở đây" value="adminhong" disabled>
                    </div>
                    <div class="div12input">
                        <label for="">* Mật khẩu</label>
                        <input type="password" placeholder="Nhập mật khẩu ở đây" value="mothaiba@@">
                    </div>
                    <div class="div12input">
                        <label for="">* Xác nhận</label>
                        <input type="password" placeholder="Xác nhận mật khẩu ở đây" value="mothaiba@@">
                    </div>
                </div>

                <div class="div13">
                    <div class="div12input">
                        <label for="">* Lương</label>
                        <input type="text" placeholder="Nhập lương ở đây" value="20,000,000">
                    </div>
                    <div class="linediv12"></div>
                    <div class="div12input">
                        <label for="">Giới thiệu</label>
                        <input type="text" placeholder="Nhập số giới thiệu ở đây"
                               value="Phải tôi đôi order thêm mấy món, hehe giỡn thôi.
                                Được đảm nhận công việc này tôi cảm thấy tôi là một người rất may mắn khi được giao đúng công việc mình yêu thích sau một thời gian dài đóng gói và vận chuyển :((">
                    </div>
                    <div class="linediv12"></div>
                    <button><i class="fa fa-save"></i>Lưu</button>
                    <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản
                        lý
                    </button>
                </div>
            </div>
        </div>
    </div>

    <!-- Quan tâm nhiêu đây thôi-->
</div>

</body>

</html>