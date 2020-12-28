<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/12/2020
  Time: 7:19 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVT SHOP | Yêu thích</title>

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
    <link rel="stylesheet" href="../css/wishlist2.css">


</head>

<body>

<!-- wpf loader Two -->
<jsp:include page="../share/_LayoutLoadAndScroll.jsp"></jsp:include>

<jsp:include page="../share/_LayoutHeader.jsp"></jsp:include>

<%request.setCharacterEncoding("utf-8");%>
<jsp:include page="../share/_LayoutBanner.jsp">
    <jsp:param name="title" value="Danh sách yêu thích"/>
</jsp:include>
<!-- / catg header banner section -->

<!-- main-->
<div class="mainlove">

    <div class="infor">
        <h3>TVT <span style="color:#ff7315">S</span>hop</h3>
        <p>Tổng: 14 phần tử</p>
        <p>Chế độ xem</p>
        <select name="" id="" class="view">
            <option value="">6 phần tử</option>
            <option value="">12 phần tử</option>
            <option value="">18 phần tử</option>
            <option value="">Tất cả phần tử</option>
        </select>
        <p>Sắp xếp theo</p>
        <select name="" id="" class="view">
            <option value="">Ngày thêm</option>
            <option value="">Giá</option>
            <option value="">Tên sản phẩm</option>
        </select>
        <div class="search">
            <input type="text" placeholder="&#xf002; Tìm kiếm" style="font-family:Arial, FontAwesome">
        </div>
    </div>

    <div class="header">
        <label for="cb" class="lbitem">
            <input type="checkbox" id="cb" class="checkbox">
        </label>
        <button>Nam</button>
        <button>Nữ</button>
        <button>Còn hàng</button>
        <button>Hết hàng</button>
        <div class="selectbutton">
            <button><i class="fa fa-list-alt"></i>Thêm tất cả vào giỏ hàng</button>
            <button><i class="fa fa-shopping-bag"></i>Thêm những lựa chọn vào giỏ hàng</button>
            <button><i class="fa fa-eraser"></i> Xóa những lựa chọn</button>
        </div>
    </div>

    <div class="titletable">
        <p>HÌNH ẢNH</p>
        <p>TÊN</p>
        <p>GIÁ</p>
        <p>NGÀY THÊM</p>
        <p>TRẠNG THÁI</p>
        <p>SỐ LƯỢNG</p>
        <div>
            <button><i class="fa fa-caret-left"></i></button>
            <ul>
                <li>1</li>
                <li>2</li>
                <li>3</li>
            </ul>
            <button><i class="fa fa-caret-right"></i></button>
        </div>
    </div>

    <div class="item">
        <label for="cb1" class="lbitem">
            <input type="checkbox" id="cb1" class="checkbox">
        </label>
        <a href="detailsProduct.html" class="imgsp"> <img src="../img/product/pro1.webp" alt=""> </a>
        <a href="detailsProduct.html" class="namesp">Áo Sweater Nam Stay Together MSW 1006</a>
        <p class="price">300,000 VND</p>
        <p class="ngaythem">13-11-2020</p>
        <p class="conhang">Còn hàng</p>
        <div class="soluong">
            <p>1</p>
            <button>
                <p>+</p>
            </button>
            <button>
                <p>-</p>
            </button>
        </div>
        <button class="addtocart"><i class="fa fa-shopping-cart"></i> Thêm vào giỏ hàng</button>
        <div class="remove">
            <i class="fa fa-close"></i>
        </div>
    </div>

    <div class="item">
        <label for="cb2" class="lbitem">
            <input type="checkbox" id="cb2" class="checkbox">
        </label>
        <a href="detailsProduct.html" class="imgsp"> <img src="../img/product/pro2.webp" alt=""> </a>
        <a href="detailsProduct.html" class="namesp">Áo Sweater Nam Stay Together Cánh Đồng MSW 1005</a>
        <p class="price">290,000 VND</p>
        <p class="ngaythem">13-11-2020</p>
        <p class="conhang">Còn hàng</p>
        <div class="soluong">
            <p>1</p>
            <button>
                <p>+</p>
            </button>
            <button>
                <p>-</p>
            </button>
        </div>
        <button class="addtocart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</button>
        <div class="remove">
            <i class="fa fa-close"></i>
        </div>
    </div>

    <div class="item">
        <label for="cb3" class="lbitem">
            <input type="checkbox" id="cb3" class="checkbox">
        </label>
        <a href="detailsProduct.html" class="imgsp"> <img src="../img/product/pro3.webp" alt=""> </a>
        <a href="detailsProduct.html" class="namesp">Áo Sweater Nam Basic MSW 1004</a>
        <p class="price">399,000 VND</p>
        <p class="ngaythem">13-11-2020</p>
        <p class="conhang">Còn hàng</p>
        <div class="soluong">
            <p>1</p>
            <button>
                <p>+</p>
            </button>
            <button>
                <p>-</p>
            </button>
        </div>
        <button class="addtocart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</button>
        <div class="remove">
            <i class="fa fa-close"></i>
        </div>
    </div>

    <div class="item">
        <label for="cb4" class="lbitem">
            <input type="checkbox" id="cb4" class="checkbox">
        </label>
        <a href="detailsProduct.html" class="imgsp"> <img src="../img/product/pro4.webp" alt=""> </a>
        <a href="detailsProduct.html" class="namesp">Áo Sweater Logo Sài Gòn MSW 1003</a>
        <p class="price">299,000 VND</p>
        <p class="ngaythem">13-11-2020</p>
        <p class="conhang">Còn hàng</p>
        <div class="soluong">
            <p>1</p>
            <button>
                <p>+</p>
            </button>
            <button>
                <p>-</p>
            </button>
        </div>
        <button class="addtocart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</button>
        <div class="remove">
            <i class="fa fa-close"></i>
        </div>
    </div>

    <div class="item">
        <label for="cb5" class="lbitem">
            <input type="checkbox" id="cb5" class="checkbox">
        </label>
        <a href="detailsProduct.html" class="imgsp"> <img src="../img/product/pro5.webp" alt=""> </a>
        <a href="detailsProduct.html" class="namesp">Áo Thun MTS 1011</a>
        <p class="price">399,000 VND</p>
        <p class="ngaythem">13-11-2020</p>
        <p class="conhang">Còn hàng</p>
        <div class="soluong">
            <p>1</p>
            <button>
                <p>+</p>
            </button>
            <button>
                <p>-</p>
            </button>
        </div>
        <button class="addtocart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</button>
        <div class="remove">
            <i class="fa fa-close"></i>
        </div>
    </div>

    <div class="item">
        <label for="cb6" class="lbitem">
            <input type="checkbox" id="cb6" class="checkbox">
        </label>
        <a href="detailsProduct.html" class="imgsp"> <img src="../img/product/pro6.webp" alt=""> </a>
        <a href="detailsProduct.html" class="namesp">Áo Thun MTS 1035</a>
        <p class="price">399,000 VND</p>
        <p class="ngaythem">13-11-2020</p>
        <p class="conhang">Còn hàng</p>
        <div class="soluong">
            <p>1</p>
            <button>
                <p>+</p>
            </button>
            <button>
                <p>-</p>
            </button>
        </div>
        <button class="addtocart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</button>
        <div class="remove">
            <i class="fa fa-close"></i>
        </div>
    </div>
</div>
<!--End main-->

<jsp:include page="../share/_LayoutChatBox.jsp"></jsp:include>

<!-- footer -->
<jsp:include page="../share/_LayoutFooter.jsp"></jsp:include>
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