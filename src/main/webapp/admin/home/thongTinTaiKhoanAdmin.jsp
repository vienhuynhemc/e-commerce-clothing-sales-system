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
    <script src="../../js/Truong/jquery/jquery-3.5.1.min.js"></script>
    <script src="../../js/indexAdmin.js"></script>


    <link rel="stylesheet" href="../../css/thongTinTaiKhoanAdminAdmin.css">

    <!-- CKEDitor -->
    <script src="../../ckeditor/ckeditor.js"></script>


</head>

<body>


<jsp:include page="../share/_LayoutLeft.jsp">
    <jsp:param name="activeSelect" value="thongTinTiKhoanAdmin"/>
</jsp:include>

<div class="indexright">
    <jsp:include page="../share/_LayoutTop.jsp"/>
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
                        <div>
                         <p>Ng&acirc;y thơ trong s&aacute;ng như ch&uacute; m&egrave;o trong ảnh :v&nbsp;</p> <figure class="easyimage easyimage-full"><img alt="" src="https://firebasestorage.googleapis.com/v0/b/ecommerce-b6c08.appspot.com/o/hinh_anh_gioi_thieu%2Fnv_1%2FMS_3.jpg?alt=media&amp;token=1df7945a-df19-4a4b-9c44-2b350d0c598c" width="200" /> <figcaption></figcaption> </figure> <hr/> <p>V&agrave; best dasua 10tr th&ocirc;ng thạo :3&nbsp;</p> <figure class="easyimage easyimage-full"><img alt="" src="https://firebasestorage.googleapis.com/v0/b/ecommerce-b6c08.appspot.com/o/hinh_anh_gioi_thieu%2Fnv_1%2F1.png?alt=media&amp;token=1abc7f1f-eca5-4282-8281-a08e127f1dc1" width="1920" /> <figcaption></figcaption> </figure> <hr /> <p>Contact:&nbsp;<img alt="wink" height="23" src="http://localhost:8080/ltw_thayLong_group5_war_exploded/ckeditor/plugins/smiley/images/wink_smile.png" title="wink" width="23" /><a href="https://www.facebook.com/vientamthuong">www.facebook.com/vientamthuong<img alt="wink" height="23" src="http://localhost:8080/ltw_thayLong_group5_war_exploded/ckeditor/plugins/smiley/images/wink_smile.png" title="wink" width="23" /></a></p>
                        </div>
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
                        <input type="text" placeholder="Nhập số điện thoại ở đây" value="0971-122-209">
                    </div>
                    <div class="div12input">
                        <label for="">* Lương</label>
                        <input type="text" placeholder="Nhập lương ở đây" value="20,000,000">
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

                    <div class="div12input formckgioithieu">
                        <textarea name="gioiThieu" id="gioiThieu" placeholder="Nhập giới thiệu ở đây"></textarea>
                    </div>
                    <button onclick="getData()"><i class="fa fa-save"></i>Lưu</button>
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

<script src="../../js/thongTinTaiKhoanAdminAdmin.js"></script>