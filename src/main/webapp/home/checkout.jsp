<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21/12/2020
  Time: 9:00 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVT SHOP | Thanh toán</title>

    <link rel="stylesheet" href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/jquery.smartmenus.bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/jquery.simpleLens.css">
    <link rel="stylesheet" type="text/css" href="../css/nouislider.css">
    <link id="switcher" href="../css/theme-color/default-theme.css" rel="stylesheet">
    <link href="../css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">
    <link href="../css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/trangChu.css">
    <script src="../js"></script>
    <link rel="stylesheet" href="../css/banner.css">
    <link rel="stylesheet" href="../css/checkout2.css">


</head>

<body>

<!-- wpf loader Two -->
<jsp:include page="../WEB-INF/Share/_LayoutLoadAndScroll.jsp"></jsp:include>

<jsp:include page="../WEB-INF/Share/_LayoutHeader.jsp"></jsp:include>

<%request.setCharacterEncoding("utf-8");%>
<jsp:include page="../WEB-INF/Share/_LayoutBanner.jsp">
    <jsp:param name="title" value="Thanh toán"/>
</jsp:include>
<!-- / catg header banner section -->

<!-- main-->
<div class="maincheckout">
    <div class="main">
        <div class="left">

            <div class="header">
                <h3><i class="fa fa-money"></i> TVT <span style="color:#ff7315">S</span>hop</h3>
                <div>
                    <i class="fa fa-info-circle"></i>
                    <p>Thông tin của bạn tuyệt đối bảo mật</p>
                </div>
            </div>
            <div class="linestatus"></div>

            <div class="thongtingiaohang">
                <p class="title">Thông tin giao hàng</p>
                <div class="inputitem">
                    <p>Họ và tên</p>
                    <input type="text" value="Gia Cát Lượng" disabled>
                </div>

                <div class="emailsdt">
                    <div class="inputitem">
                        <p>Email</p>
                        <input type="text" value="tuilaluong@gmail.com" disabled>
                    </div>
                    <div class="inputitem">
                        <p>Số điện thoại</p>
                        <input type="text" value="0971122298" disabled>
                    </div>
                </div>

                <div class="inputitem">
                    <p>Địa chỉ</p>
                    <input type="text" placeholder="Thông tin nơi bạn nhận hàng">
                </div>

                <div class="qhx">

                    <div class="inputitem">
                        <p>Tỉnh / thành</p>
                        <select name="" id="">
                            <option data-code="null" value="null" selected=""> Chọn tỉnh / thành</option>
                            <option data-code="HC" value="50">Hồ Chí Minh</option>
                            <option data-code="HI" value="1">Hà Nội</option>
                            <option data-code="DA" value="32">Đà Nẵng</option>
                            <option data-code="AG" value="57">An Giang</option>
                            <option data-code="BV" value="49">Bà Rịa - Vũng Tàu</option>
                            <option data-code="BG" value="15">Bắc Giang</option>
                            <option data-code="BK" value="4">Bắc Kạn</option>
                            <option data-code="BL" value="62">Bạc Liêu</option>
                            <option data-code="BN" value="18">Bắc Ninh</option>
                            <option data-code="BT" value="53">Bến Tre</option>
                            <option data-code="BD" value="35">Bình Định</option>
                            <option data-code="BI" value="47">Bình Dương</option>
                            <option data-code="BP" value="45">Bình Phước</option>
                            <option data-code="BU" value="39">Bình Thuận</option>
                            <option data-code="CM" value="63">Cà Mau</option>
                            <option data-code="CN" value="59">Cần Thơ</option>
                            <option data-code="CB" value="3">Cao Bằng</option>
                            <option data-code="DC" value="42">Đắk Lắk</option>
                            <option data-code="DO" value="43">Đắk Nông</option>
                            <option data-code="DB" value="7">Điện Biên</option>
                            <option data-code="DN" value="48">Đồng Nai</option>
                            <option data-code="DT" value="56">Đồng Tháp</option>
                            <option data-code="GL" value="41">Gia Lai</option>
                            <option data-code="HG" value="2">Hà Giang</option>
                            <option data-code="HM" value="23">Hà Nam</option>
                            <option data-code="HT" value="28">Hà Tĩnh</option>
                            <option data-code="HD" value="19">Hải Dương</option>
                            <option data-code="HP" value="20">Hải Phòng</option>
                            <option data-code="HU" value="60">Hậu Giang</option>
                            <option data-code="HO" value="11">Hòa Bình</option>
                            <option data-code="HY" value="21">Hưng Yên</option>
                            <option data-code="KH" value="37">Khánh Hòa</option>
                            <option data-code="KG" value="58">Kiên Giang</option>
                            <option data-code="KT" value="40">Kon Tum</option>
                            <option data-code="LI" value="8">Lai Châu</option>
                            <option data-code="LD" value="44">Lâm Đồng</option>
                            <option data-code="LS" value="13">Lạng Sơn</option>
                            <option data-code="LO" value="6">Lào Cai</option>
                            <option data-code="LA" value="51">Long An</option>
                            <option data-code="ND" value="24">Nam Định</option>
                            <option data-code="NA" value="27">Nghệ An</option>
                            <option data-code="NB" value="25">Ninh Bình</option>
                            <option data-code="PT" value="16">Phú Thọ</option>
                            <option data-code="PY" value="36">Phú Yên</option>
                            <option data-code="QB" value="29">Quảng Bình</option>
                            <option data-code="QM" value="33">Quảng Nam</option>
                            <option data-code="QG" value="34">Quảng Ngãi</option>
                            <option data-code="QN" value="14">Quảng Ninh</option>
                            <option data-code="QT" value="30">Quảng Trị</option>
                            <option data-code="ST" value="61">Sóc Trăng</option>
                            <option data-code="SL" value="9">Sơn La</option>
                            <option data-code="TN" value="46">Tây Ninh</option>
                            <option data-code="TB" value="22">Thái Bình</option>
                            <option data-code="TY" value="12">Thái Nguyên</option>
                            <option data-code="TH" value="26">Thanh Hóa</option>
                            <option data-code="TT" value="31">Thừa Thiên Huế</option>
                            <option data-code="TG" value="52">Tiền Giang</option>
                            <option data-code="TV" value="54">Trà Vinh</option>
                            <option data-code="TQ" value="5">Tuyên Quang</option>
                            <option data-code="VL" value="55">Vĩnh Long</option>
                            <option data-code="VT" value="17">Vĩnh Phúc</option>
                            <option data-code="YB" value="10">Yên Bái</option>
                        </select>
                    </div>

                    <div class="inputitem">
                        <p>Quận / huyện</p>
                        <select name="" id="">
                            <option data-code="null" value="null" selected=""> Chọn quận / huyện</option>
                        </select>
                    </div>

                    <div class="inputitem">
                        <p>Phường / xã</p>
                        <select name="" id="">
                            <option data-code="null" value="null" selected=""> Chọn phường / xã</option>
                        </select>
                    </div>

                </div>
            </div>
            <div class="linestatus"></div>

            <div class="phuongthucvanchuyen">
                <p class="title">Phương thức vận chuyển</p>

                <div class="inputitemselect">
                    <input type="radio" name="" id="ptvc" checked>
                    <label for="ptvc">Giao hàng miễn phí</label>
                </div>
            </div>
            <div class="linestatus"></div>

            <div class="phuongthucthanhtoan">
                <p class="title">Phương thức thanh toán</p>
                <div>
                    <input type="radio" id="rd1" name="tt" checked>
                    <input type="radio" id="rd2" name="tt">
                    <input type="radio" id="rd3" name="tt">
                    <label for="rd1" class="lbtt1">
                        <div class="ptttdiv">
                            <img src="../img/thanhtoan/tttructiep.png" alt="">
                            <p>Thanh toán khi giao hàng</p>
                            <div class="checkpttt">
                                <i class="fa fa-check"></i>
                            </div>
                        </div>
                    </label>
                    <label for="rd2" class="lbtt2">
                        <div class="ptttdiv">
                            <img src="../img/thanhtoan/ttthe.png" alt="">
                            <p>Thanh toán online</p>
                            <div class="checkpttt">
                                <i class="fa fa-check"></i>
                            </div>
                        </div>
                    </label>
                    <label for="rd3" class="lbtt3">
                        <div class="ptttdiv">
                            <img src="../img/thanhtoan/ttmomo.png" alt="">
                            <p>Thanh toán bằnng ví momo</p>
                            <div class="checkpttt">
                                <i class="fa fa-check"></i>
                            </div>
                        </div>
                    </label>
                </div>
            </div>
            <div class="linestatus"></div>

            <div class="divsubmit">
                <a href="cart.html" class="buttonpress">Trở về giỏ hàng</a>

                <div>
                    <a href="product.html">Trở về mua sắm</a>
                    <button class="buttonpress">Thanh toán</button>
                </div>
            </div>

        </div>

        <div class="right">

            <div class="danhsachsanpham">
                <div class="item">
                    <div class="img">
                        <img src="../img/product/pro10.webp" alt="">
                    </div>
                    <div class="sl">
                        <p>2</p>
                    </div>
                    <div class="infor">
                        <p>Áo Thun MTS 1011</p>
                        <p>Trắng / Nam / L</p>
                    </div>
                    <p class="price">798,000 VND</p>
                </div>
                <div class="item">
                    <div class="img">
                        <img src="../img/product/pro11.webp" alt="">
                    </div>
                    <div class="sl">
                        <p>3</p>
                    </div>
                    <div class="infor">
                        <p>Áo Thun MTS 1010</p>
                        <p>Đen / Nam / L</p>
                    </div>
                    <p class="price">597,000 VND</p>
                </div>
                <div class="item">
                    <div class="img">
                        <img src="../img/product/pro12.webp" alt="">
                    </div>
                    <div class="sl">
                        <p>1</p>
                    </div>
                    <div class="infor">
                        <p>Áo Thun Nam Raglan Tay Dài MTS 1008</p>
                        <p>Xanh / Nam / L</p>
                    </div>
                    <p class="price">399,000 VND</p>
                </div>
                <div class="item">
                    <div class="img">
                        <img src="../img/product/pro4.webp" alt="">
                    </div>
                    <div class="sl">
                        <p>4</p>
                    </div>
                    <div class="infor">
                        <p>Áo Sweater Logo Sài Gòn MSW 1003</p>
                        <p>Vàng / Nam / L</p>
                    </div>
                    <p class="price">1,196,000 VND</p>
                </div>
                <div class="item">
                    <div class="img">
                        <img src="../img/product/pro1.webp" alt="">
                    </div>
                    <div class="sl">
                        <p>3</p>
                    </div>
                    <div class="infor">
                        <p>Áo Sweater Nam Stay Together MSW 1006</p>
                        <p>Đỏ đô / Nam / L</p>
                    </div>
                    <p class="price">900,000 VND</p>
                </div>
                <div class="item">
                    <div class="img">
                        <img src="../img/product/pro9.webp" alt="">
                    </div>
                    <div class="sl">
                        <p>1</p>
                    </div>
                    <div class="infor">
                        <p>Áo Thun MTS 1012</p>
                        <p>Trắng / Nam / L</p>
                    </div>
                    <p class="price">399,000 VND</p>
                </div>
            </div>

            <div class="magiamgia">
                <div>
                    <input type="text" placeholder="Mã giảm giá">
                    <button>Sử dụng</button>
                </div>

                <p>Bạn có mã giảm giá? Vui lòng nhập tại đây</p>
            </div>

            <div class="tamtinh">
                <div>
                    <p>Tạm tính</p>
                    <p>4,359,000 VND</p>
                </div>
                <div>
                    <p>Phí vận chuyển</p>
                    <p>Miễn phí</p>
                </div>
                <div class="linestatus"></div>
                <div>
                    <p>Tổng cộng</p>
                    <p>4,359,000 VND</p>
                </div>
            </div>

            <div class="ghichu">
                <p>TVT Shop sẽ <span class="note">xác nhận</span> đơn hàng bằng <span class="note">email</span> hoặc
                    <span class="note">gọi điện</span>. Bạn vui lòng <span class="note">kiểm tra email</span> hoặc
                    <span class="note">nghe máy</span>
                    sau khi <span class="note">đặt hàng thành công</span>.</p>
            </div>


        </div>
    </div>
</div>
<!--End main-->

<jsp:include page="../WEB-INF/Share/_LayoutChatBox.jsp"></jsp:include>

<!-- footer -->
<jsp:include page="../WEB-INF/Share/_layoutFooter.jsp"></jsp:include>
<!-- / footer -->

</body>

</html>


<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap.js"></script>
<!-- SmartMenus jQuery plugin -->
<script type="text/javascript" src="../js/jquery.smartmenus.js"></script>
<!-- SmartMenus jQuery Bootstrap Addon -->
<script type="text/javascript" src="../js/jquery.smartmenus.bootstrap.js"></script>
<!-- To Slider JS -->
<script src="../js/sequence.js"></script>
<script src="../js/sequence-theme.modern-slide-in.js"></script>
<!-- Product view slider -->
<script type="text/javascript" src="../js/jquery.simpleGallery.js"></script>
<script type="text/javascript" src="../js/jquery.simpleLens.js"></script>
<!-- slick slider -->
<script type="text/javascript" src="../js/slick.js"></script>
<!-- Price picker slider -->
<script type="text/javascript" src="../js/nouislider.js"></script>
<!-- Custom js -->
<script src="../js/custom.js"></script>