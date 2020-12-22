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
<div id="wpf-loader-two">
    <div class="wpf-loader-two-inner">
        <span style="color:#ff7315">Loading</span>
    </div>
</div>

<!-- SCROLL TOP BUTTON -->
<a class="scrollToTop movetop" href="#"><i class="fa fa-angle-double-up"></i></a>
<!-- END SCROLL TOP BUTTON -->

<!-- Start header section -->
<header id="aa-header">
    <!-- start header top  -->
    <div class="aa-header-top">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="aa-header-top-area">
                        <!-- start header top left -->
                        <div class="aa-header-top-left">
                            <!-- start language -->

                            <!-- / language -->
                            <span id="qc">Free ship với <span style="color:#ff7315; font-weight:bold">đơn</span>
                                    hàng từ <span style="color:#ff7315; font-weight:bold">499,000đ</span></span>
                            <!-- start currency -->
                            <!-- / currency -->
                            <!-- start cellphone -->

                            <!-- / cellphone -->
                        </div>
                        <!-- / header top left -->
                        <div class="aa-header-top-right">
                            <ul class="aa-head-top-nav-right">
                                <li class="iconRound"><a href="changeInforCustomer.html"><i class="fa fa-user"
                                                                                            aria-hidden="true"></i></a>
                                </li>
                                <li class="hidden-xs iconRound"><a href="wishlist.html"><i
                                        class="fa fa-heart"></i></a></li>
                                <li class="hidden-xs iconRoundLenght"><a href="cart.html">Giỏ hàng
                                    <span class="fa fa-shopping-cart"></span></a></li>
                                <li class="hidden-xs iconRoundLenght  activeeeicon"><a href="checkout.html">Thanh
                                    toán <span class="fa fa-credit-card"></span></a></li>
                                <!-- <li><a href="" data-toggle="modal" data-target="#login-modal">Login</a></li> -->
                                <li class="hidden-xs iconRoundLenghtt">
                                    <div class="aa-language">
                                        <div class="dropdown">
                                            <a class="btn dropdown-toggle" href="#" type="button" id="dropdownMenu1"
                                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                <img class="country" src="../img/vietnam.png" alt="english flag">Việt
                                                Nam
                                                <span class="caret"></span>
                                            </a>
                                            <ul class="dropdown-menu menucountry choiselanguage"
                                                aria-labelledby="dropdownMenu1">
                                                <li><a href="#"><img class="country" src="../img/vietnam.png"
                                                                     alt="">Việt Nam</a></li>
                                                <li><a href="#"><img class="country" src="../img/language.png"
                                                                     alt="">English</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </li>
                                <li class="hidden-xs iconRoundLenghtt iconPhone">
                                    <div class="cellphone hidden-xs">
                                        <p id="phone"><span class="fa fa-phone"></span>09-7112-209</p>
                                    </div>
                                </li>

                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- / header top  -->

    <!-- start header bottom  -->
    <div class="aa-header-bottom">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="aa-header-bottom-area">
                        <!-- logo  -->
                        <div class="aa-logo">
                            <!-- Text based logo -->
                            <a href="../index.html">
                                <span class="fa fa-shopping-cart"></span>
                                <p>TVT<strong style="color:#ff7315">S</strong>hop <span>Giá rẻ, nhanh chóng</span>
                                </p>
                            </a>
                            <!-- img based logo -->
                            <!-- <a href="index.html"><img src="../img/logo.jpg" alt="logo img"></a> -->
                        </div>
                        <!-- / logo  -->
                        <section id="menu">
                            <div class="container">
                                <div class="menu-area">
                                    <!-- Navbar -->
                                    <div class="navbar navbar-default" role="navigation">
                                        <div class="navbar-header">
                                            <button type="button" class="navbar-toggle" data-toggle="collapse"
                                                    data-target=".navbar-collapse">
                                                <span class="sr-only">Toggle navigation</span>
                                                <span class="icon-bar"></span>
                                                <span class="icon-bar"></span>
                                                <span class="icon-bar"></span>
                                            </button>
                                        </div>
                                        <div class="navbar-collapse collapse menuselect">
                                            <!-- Left nav -->
                                            <ul class="nav navbar-nav leftnav">
                                                <li><a href="../index.html">Trang chủ</a></li>
                                                <li><a href="product.html">Nam<span class="caret"></span></a>
                                                    <ul class="dropdown-menu">
                                                        <li><a href="product.html">Áo nam <span
                                                                class="caret"></span></a>
                                                            <ul class="dropdown-menu">
                                                                <li><a href="product.html">Áo khoác</a></li>
                                                                <li><a href="product.html">Áo thun</a></li>
                                                                <li><a href="product.html">Áo sơ mi</a></li>
                                                                <li><a href="product.html">Áo polo</a></li>
                                                            </ul>
                                                        </li>
                                                        <li><a href="product.html">Quần nam<span
                                                                class="caret"></span></a>
                                                            <ul class="dropdown-menu">
                                                                <li><a href="product.html">Quần ngắn</a></li>
                                                                <li><a href="product.html">Quần dài</a></li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </li>
                                                <li><a href="product2.html">Nữ<span class="caret"></span></a>
                                                    <ul class="dropdown-menu">
                                                        <li><a href="product.html">Áo nữ<span
                                                                class="caret"></span></a>
                                                            <ul class="dropdown-menu">
                                                                <li><a href="product.html">Áo khoác</a></li>
                                                                <li><a href="product.html">Áo thun</a></li>
                                                                <li><a href="product.html">Áo sơ mi</a></li>
                                                                <li><a href="product.html">Áo polo</a></li>
                                                            </ul>
                                                        </li>
                                                        <li><a href="product.html">Quần / Váy nữ<span
                                                                class="caret"></span></a>
                                                            <ul class="dropdown-menu">
                                                                <li><a href="product.html">Váy</a></li>
                                                                <li><a href="product.html">Đầm</a></li>
                                                                <li><a href="product.html">Quần ngắn</a></li>
                                                                <li><a href="product.html">Quần dài</a></li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </li>
                                                <li><a href="contact.html">Liên hệ</a></li>
                                                <li><a href="about_US.html">Về chúng tôi</a></li>
                                                <li><a href="../admin/home/login.html">ADMIN</a></li>
                                            </ul>
                                        </div>
                                        <!--/.nav-collapse -->
                                    </div>
                                </div>
                            </div>
                        </section>
                        <!-- cart box -->
                        <div class="aa-cartbox">
                            <a class="aa-cart-link" href="cart.html">
                                <span class="fa fa-cart-arrow-down"></span>
                                <span class="aa-cart-title">Giỏ hàng</span>
                                <span class="aa-cart-notify">2</span>
                            </a>
                            <div class="aa-cartbox-summary  xemnhanhgiohang">
                                <ul>
                                    <li>
                                        <a class="aa-cartbox-img" href="detailsProduct.html"><img
                                                src="../img/do/nu/12.jpg" alt="img"></a>
                                        <div class="aa-cartbox-info">
                                            <h4><a href="detailsProduct.html">Áo thun MST 1002</a></h4>
                                            <p>2 x 299,000 VND</p>
                                        </div>
                                        <a class="aa-remove-product" href="detailsProduct.html"><span
                                                class="fa fa-times"></span></a>
                                    </li>
                                    <li>
                                        <a class="aa-cartbox-img" href="detailsProduct.html"><img
                                                src="../img/do/nu/13.jpg" alt="img"></a>
                                        <div class="aa-cartbox-info">
                                            <h4><a href="detailsProduct.html">Áo thun kéo ASF 1209</a></h4>
                                            <p>3 x 129,000 VND</p>
                                        </div>
                                        <a class="aa-remove-product" href="#"><span class="fa fa-times"></span></a>
                                    </li>
                                    <li>
                                            <span class="aa-cartbox-total-title">
                                                Tổng tiền
                                            </span>
                                        <span class="aa-cartbox-total-price">
                                                985,000 VND
                                            </span>
                                    </li>
                                </ul>
                                <a class="aa-cartbox-checkout aa-primary-btn tinhtien" href="checkout.html">Thanh
                                    toán</a>
                            </div>
                        </div>
                        <!-- / cart box -->
                        <!-- search box -->
                        <div class="aa-search-box">
                            <form action="">
                                <input type="text" name="" id="" placeholder="Tìm kiếm ở đây">
                                <button type="submit"><span class="fa fa-search"></span></button>
                            </form>
                        </div>
                        <!-- / search box -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- / header bottom  -->
</header>
<!-- / header section -->

<!-- catg header banner section -->
<section id="aa-catg-head-banner">

    <div class="aa-catg-head-banner-area">
        <div class="container">
            <div class="aa-catg-head-banner-content1">
                <h2>Thanh toán</h2>
                <ul class="breadcrumbb">
                    <li><a href="../index.html">Trang chủ</a> <i class="fa fa-angle-double-right"></i></li>
                    <li>Thanh toán</li>
                </ul>
            </div>
        </div>
    </div>
</section>
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

<div class="chatbox">
    <div class="iconchatbox" onclick="actionchatbox()">
        <i class="fa fa-connectdevelop"></i>
    </div>

    <div class="contentchatbox" id="contentchatbox">
        <div class="chatboxheader">
            <div>
                <i class="fa fa-times" onclick="actionchatbox()"></i>
            </div>
            <div>
                <h3><span style="color:#ff7315">TVT</span> Shop</h3>
                <p>Thuờng trả lời tin nhắn sau 1 giờ</p>
            </div>
        </div>

        <div class="midchatbox">
            <p class="timechat">12:00 PM</p>
            <p class="tvtchat">Xin chào!</p>
            <div class="iconTS"><span style="color:#ff7315">T</span>S</div>
            <p class="tvtchat">Tôi có thể giúp gì cho bạn ?</p>
            <p class="userchat">Xin chào!</p>
        </div>
        <div class="chatboxfooter">
            <p>Nhập tin nhắn ở đây...</p>
            <i class="fa fa-thumbs-o-up"></i>
        </div>

        <script>
            function actionchatbox() {
                let element = document.getElementById("contentchatbox");
                if (element.classList.contains("actionchatbox")) element.classList.remove("actionchatbox");
                else element.classList.add("actionchatbox");
            }
        </script>
    </div>
</div>

<!-- footer -->
<footer id="aa-footer">
    <!-- footer bottom -->
    <div class="aa-footer-top">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="aa-footer-top-area">
                        <div class="row">
                            <div class="col-md-3 col-sm-6">
                                <div class="aa-footer-widget">
                                    <h3>CÔNG TY TNHH <span style="color:#ff7315;">TVT</span> SHOP</h3>
                                    <ul class="aa-footer-nav">
                                        <li><a href="#">Giới thiệu</a></li>
                                        <li><a href="#">Tuyển dụng</a></li>
                                        <li><a href="#">Tạp chí</a></li>
                                        <li><a href="#">Hợp tác</a></li>

                                    </ul>
                                    <img src="../img/logosalenoti.png" alt="" style=" width: 130px;margin-top: 20px;">
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6">
                                <div class="aa-footer-widget">
                                    <div class="aa-footer-widget">
                                        <h3>HỖ TRỢ KHÁCH HÀNG</h3>
                                        <ul class="aa-footer-nav">
                                            <li><a href="chooseSize.html">Hướng dẫn chọn size</a></li>
                                            <li><a href="shopping_guide.html">Hướng dẫn mua hàng</a></li>
                                            <li><a href="membership_policy.html">Chính sách thành viên</a></li>
                                            <li><a href="payment_policy.html">Chính sách đổi trả</a></li>
                                            <li><a href="guarantee.html">Chính sách bảo hành</a></li>
                                            <li><a href="check_orders.html">Tra cứu đơn hàng</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6">
                                <div class="aa-footer-widget">
                                    <div class="aa-footer-widget">
                                        <h3>ĐỐI TÁC VẬN CHUYỂN</h3>
                                        <ul class="aa-footer-nav giaohang">
                                            <li><img src="../img/giaohangnhanh.webp" alt=""></li>
                                            <li><img src="../img/giaohangtietkiem.webp" alt=""></li>
                                            <li><img src="../img/grap.webp" alt=""></li>

                                        </ul>
                                        <h3>PHƯƠNG THỨC THANH TOÁN</h3>
                                        <ul class="aa-footer-nav giaohang">
                                            <li><img src="../img/vnpay.webp" alt=""></li>
                                            <li><img src="../img/momo.webp" alt=""></li>
                                            <li><img src="../img/cash.webp" alt=""></li>

                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6">
                                <div class="aa-footer-widget">
                                    <div class="aa-footer-widget">
                                        <h3>Contact Us</h3>
                                        <address>
                                            <p> Đại học Nông Lâm</p>
                                            <p><span class="fa fa-phone"></span>+1 212-982-4589</p>
                                            <p><span class="fa fa-envelope"></span>tvtshop@gmail.com</p>
                                        </address>
                                        <div class="aa-footer-social">
                                            <a href="#"><i class="fa fa-facebook"></i></a>
                                            <a href="#"><i class="fa fa-twitter"></i></a>
                                            <a href="#"><i class="fa fa-google"></i></a>
                                            <a href="#"><i class="fa fa-youtube"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- footer-bottom -->
    <div class="aa-footer-bottom">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="aa-footer-bottom-area">
                        <a>© 2020 TVTShop. Powered by Haravan Enterprice</a>
                        <a href=""> Terms & Conditions</a>
                        <a href="">Safety and Security</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
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