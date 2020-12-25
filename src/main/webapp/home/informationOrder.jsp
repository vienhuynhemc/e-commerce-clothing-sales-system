<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/12/2020
  Time: 3:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TVT Shop | Kiểm tra đơn hàng</title>

    <!-- Font awesome -->
    <link href="../css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css"
          integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
    <!-- Bootstrap -->
    <link href="../css/bootstrap.css" rel="stylesheet">
    <!-- SmartMenus jQuery Bootstrap Addon CSS -->
    <link href="../css/jquery.smartmenus.bootstrap.css" rel="stylesheet">
    <!-- Product view slider -->
    <link rel="stylesheet" type="text/css" href="../css/jquery.simpleLens.css">
    <!-- slick slider -->
    <link rel="stylesheet" type="text/css" href="../css/slick.css">
    <!-- price picker slider -->
    <link rel="stylesheet" type="text/css" href="../css/nouislider.css">
    <!-- Theme color -->
    <link id="switcher" href="../css/theme-color/default-theme.css" rel="stylesheet">
    <!-- Top Slider CSS -->
    <link href="../css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">

    <!-- Main style sheet -->


    <link rel="stylesheet" href="../css/about.css">
    <!-- <link rel="stylesheet" href="css/header.css"> -->
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/banner.css">
    <link rel="stylesheet" href="../css/trangChu.css">
    <link rel="stylesheet" href="../css/payment_policy.css">
    <script src="../js/trangChu.js"></script>
    <script src="../js"></script>

    <link rel="stylesheet" href="../css/checkorders.css">

    <!-- Google Font -->
    <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


</head>

<body>
<!-- wpf loader Two -->
<!-- wpf loader Two -->
<jsp:include page="../WEB-INF/Share/_LayoutLoadAndScroll.jsp"></jsp:include>

<jsp:include page="../WEB-INF/Share/_LayoutHeader.jsp"></jsp:include>

<%request.setCharacterEncoding("utf-8");%>
<jsp:include page="../WEB-INF/Share/_LayoutBanner.jsp">
    <jsp:param name="title" value="Thông tin đơn hàng"/>
</jsp:include>
<!-- / header section -->
<!-- / catg header banner section -->

<!-- Cart view section -->
<div class="col-sm-12 divtitle">
    <h3 class="title titlemain"><span class="red">Kiểm tra</span> đơn hàng</h3>
    <p class="titilesub">Bạn có thể xem chi tiết quá trình đơn hàng của mình di chuyển như thế nào</p>

    <div class="main">
        <div class="header">
            <div class="bar">
                <div class="item hiddenitem"><i class="fa fa-check"></i></div>
                <div class="item hiddenitem"><i class="fa fa-check"></i></div>
                <div class="item nowitem"><i class="fa fa-check"></i></div>
                <div class="item"><i class="fa fa-check"></i></div>
                <div class="item futureitem"><i class="fa fa-check"></i></div>
                <div class="colorbar"></div>
            </div>
            <div class="titlebar">
                <div class="itemtitlebar">
                    <p>Đặt hàng</p>
                    <p>21/11/2020</p>
                    <p>17:32</p>
                </div>
                <div class="itemtitlebar">
                    <p>Admin duyệt</p>
                    <p>22/11/2020</p>
                    <p>6:23</p>
                </div>
                <div class="itemtitlebar">
                    <p>Nhân viên kho đóng gói</p>
                    <p>22/11/2020</p>
                    <p>7:49</p>
                </div>
                <div class="itemtitlebar hiddentitlebar">
                    <p>Nhân viên giao hàng lấy hàng</p>
                    <p>22/11/2020</p>
                    <p>10:40</p>
                </div>
                <div class="itemtitlebar">
                    <p>Dự kiến hoàn thành</p>
                    <p>23/11/2020</p>
                    <p>12:00</p>
                </div>
            </div>
        </div>

        <p class="titleupdate">Cập nhập mới nhất</p>

        <div class="contentupdate">
            <div class="headerupdate">
                <p>Ngày</p>
                <p>Vị trí</p>
                <p>Sự kiện</p>
            </div>

            <div class="lineupdate"></div>

            <div class="itemupdate">
                <p>22/11/2020 - 7:49</p>
                <p>Kho hàng TVT Shop, Q.9, TP Hồ Chí Minh</p>
                <div>
                    <p>Nhân viên kho đóng gói</p>
                    <p>Nhân viên: Nguyễn Lưu Ly</p>
                    <p>Nội dung: đóng gói và lựa chọn người giao hàng</p>
                </div>
            </div>
            <div class="lineupdate"></div>

            <div class="itemupdate">
                <p>22/11/2020 - 6:32</p>
                <p>Kho hàng TVT Shop, Q.9, TP Hồ Chí Minh</p>
                <div>
                    <p>Admin duyệt</p>
                    <p>Admin: Huỳnh Văn Viên</p>
                    <p>Nội dung: duyệt đơn hàng cho nhân viên kho đóng gói</p>
                </div>
            </div>
            <div class="lineupdate"></div>

            <div class="itemupdate">
                <p>21/11/2020 - 17:32</p>
                <p></p>
                <div>
                    <p>Đặt hàng</p>
                </div>
            </div>
            <div class="lineupdate"></div>

            <div class="footerupdate">
                <a href="check_orders.html">Kiểm tra đơn hàng khác</a>
                <a href="changeInforCustomer.html">Trở về tài khoản</a>
            </div>

        </div>
    </div>
</div>


<!-- Subscribe section -->
<!-- footer -->
<!-- footer -->
<jsp:include page="../WEB-INF/Share/_layoutFooter.jsp"></jsp:include>
<!-- / footer -->
<!-- Login Modal -->
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4>Login or Register</h4>
                <form class="aa-login-form" action="">
                    <label for="">Username or Email address<span>*</span></label>
                    <input type="text" placeholder="Username or email">
                    <label for="">Password<span>*</span></label>
                    <input type="password" placeholder="Password">
                    <button class="aa-browse-btn" type="submit">Login</button>
                    <label for="rememberme" class="rememberme"><input type="checkbox" id="rememberme"> Remember me
                    </label>
                    <p class="aa-lost-password"><a href="#">Lost your password?</a></p>
                    <div class="aa-register-now">
                        Don't have an account?<a href="account.html">Register now!</a>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>


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

</body>

</html>