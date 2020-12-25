<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/12/2020
  Time: 7:12 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TVT Shop | Hướng dẫn mua hàng</title>

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
    <link rel="stylesheet" href="../css/shopping-guide.css">
    <script src="../js/trangChu.js"></script>
    <script src="../js/shopgui.js"></script>
    <script src="../js/index.js"></script>

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
    <jsp:param name="title" value="Hướng dẫn mua hàng"/>
</jsp:include>

<!-- / catg header banner section -->

<!-- Cart view section -->
<main>
    <div class="container">
        <div class="row">
            <div class="col-sm-12 divtitle">
                <h3 class="title titlemain"><span class="red">Hướng Dẫn</span> Mua hàng</h3>
                <p class="titilesub">Mọi thú thật dễ dàng khi đến với chúng tôi <span style="color: red;"><i
                        class="fa fa-heart"></i></span></p>
            </div>
        </div>
        <div class="row guihuongdandiv">
            <div class="col-sm-12">
                <div class="huongdan">
                    <span class="c1">Cách 1</span>
                </div>
            </div>
            <div class="col-sm-12">
                <div class="c1_note">Gọi điện tới tổng đài <span class="bl">09-7112-290</span> từ <span
                        class="bl">8h00-17hh00</span> anh Huỳnh Nhật Trường sẵng sàng phụ vụ bạn
                </div>
            </div>
            <div class="col-sm-12">
                <div class="huongdan">
                    <span class="c1">Cách 2</span>
                </div>
            </div>
            <div class="col-sm-12">
                <div class="c1_note">Đặt hàng trên Website theo 5 bước nhẹ nhàng:</div>
            </div>
        </div>
        <div class="row" id="stepitem1">
            <div class="col-sm-12">
                <div class="boxstep">
                    <div class="boxstepmain">
                        <div class="step">
                            <div class="line1step w20"></div>
                            <div class="line2step w100"></div>
                            <div class="stepitem" onclick="stepitem1()">
                                <i class="fa fa-circle"></i>
                                <p class="contentstep c0">Chọn sản phẩm</p>
                            </div>
                            <div class="stepitem stepitemlow" onclick="stepitem2()">
                                <i class="fa fa-circle"></i>
                                <p class="contentstep c25 contentsteplow">Chọn màu sắc và size</p>
                            </div>
                            <div class="stepitem stepitemlow" onclick="stepitem3()">
                                <i class="fa fa-circle"></i>
                                <p class="contentstep c50 contentsteplow">Thêm vào giỏ hàng</p>
                            </div>
                            <div class="stepitem stepitemlow" onclick="stepitem4()">
                                <i class="fa fa-circle"></i>
                                <p class="contentstep c75 contentsteplow">Kiểm tra giỏ hàng</p>
                            </div>
                            <div class="stepitem stepitemlow" onclick="stepitem5()">
                                <i class="fa fa-circle"></i>
                                <p class="contentstep c100 contentsteplow">Thanh toán</p>
                            </div>
                        </div>
                    </div>
                    <div class="boxstepmainsub1">

                    </div>
                    <div class="boxstepmainsub2">

                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-sm-12divgui endrowgui" class="hd"><img class="hd" src="../img/b1.png" alt=""></div>
        </div>
        <div class="row" id="stepitem2">
            <div class="col-sm-12">
                <div class="boxstep">
                    <div class="boxstepmain">
                        <div class="step">
                            <div class="line1step w25"></div>
                            <div class="line2step w100"></div>
                            <div class="stepitem" onclick="stepitem1()">
                                <i class="fa fa-check"></i>
                                <p class="contentstep c0">Chọn sản phẩm</p>
                            </div>
                            <div class="stepitem" onclick="stepitem2()">
                                <i class="fa fa-circle"></i>
                                <p class="contentstep c25">Chọn màu sắc và size</p>
                            </div>
                            <div class="stepitem stepitemlow" onclick="stepitem3()">
                                <i class="fa fa-circle"></i>
                                <p class="contentstep c50 contentsteplow">Thêm vào giỏ hàng</p>
                            </div>
                            <div class="stepitem stepitemlow" onclick="stepitem4()">
                                <i class="fa fa-circle"></i>
                                <p class="contentstep c75 contentsteplow">Kiểm tra giỏ hàng</p>
                            </div>
                            <div class="stepitem stepitemlow" onclick="stepitem5()">
                                <i class="fa fa-circle"></i>
                                <p class="contentstep c100 contentsteplow">Thanh toán</p>
                            </div>
                        </div>
                    </div>
                    <div class="boxstepmainsub1">

                    </div>
                    <div class="boxstepmainsub2">

                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-sm-12divgui endrowgui"><img class="hd" src="../img/b2.png" alt=""></div>
        </div>
        <div class="row" id="stepitem3">
            <div class="col-sm-12">
                <div class="boxstep">
                    <div class="boxstepmain">
                        <div class="step">
                            <div class="line1step w50"></div>
                            <div class="line2step w100"></div>
                            <div class="stepitem" onclick="stepitem1()">
                                <i class="fa fa-check"></i>
                                <p class="contentstep c0">Chọn sản phẩm</p>
                            </div>
                            <div class="stepitem" onclick="stepitem2()">
                                <i class="fa fa-check"></i>
                                <p class="contentstep c25">Chọn màu sắc và size</p>
                            </div>
                            <div class="stepitem" onclick="stepitem3()">
                                <i class="fa fa-circle"></i>
                                <p class="contentstep c50">Thêm vào giỏ hàng</p>
                            </div>
                            <div class="stepitem stepitemlow" onclick="stepitem4()">
                                <i class="fa fa-circle"></i>
                                <p class="contentstep c75 contentsteplow">Kiểm tra giỏ hàng</p>
                            </div>
                            <div class="stepitem stepitemlow" onclick="stepitem5()">
                                <i class="fa fa-circle"></i>
                                <p class="contentstep c100 contentsteplow">Thanh toán</p>
                            </div>
                        </div>
                    </div>
                    <div class="boxstepmainsub1">

                    </div>
                    <div class="boxstepmainsub2">

                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-sm-12divgui endrowgui"><img class="hd" src="../img/b3.png" alt=""></div>
        </div>
        <div class="row" id="stepitem4">
            <div class="col-sm-12">
                <div class="boxstep">
                    <div class="boxstepmain">
                        <div class="step">
                            <div class="line1step w75"></div>
                            <div class="line2step w100"></div>
                            <div class="stepitem" onclick="stepitem1()">
                                <i class="fa fa-check"></i>
                                <p class="contentstep c0">Chọn sản phẩm</p>
                            </div>
                            <div class="stepitem" onclick="stepitem2()">
                                <i class="fa fa-check"></i>
                                <p class="contentstep c25">Chọn màu sắc và size</p>
                            </div>
                            <div class="stepitem" onclick="stepitem3()">
                                <i class="fa fa-check"></i>
                                <p class="contentstep c50">Thêm vào giỏ hàng</p>
                            </div>
                            <div class="stepitem" onclick="stepitem4()">
                                <i class="fa fa-circle"></i>
                                <p class="contentstep c75">Kiểm tra giỏ hàng</p>
                            </div>
                            <div class="stepitem stepitemlow" onclick="stepitem5()">
                                <i class="fa fa-circle"></i>
                                <p class="contentstep c100 contentsteplow">Thanh toán</p>
                            </div>
                        </div>
                    </div>
                    <div class="boxstepmainsub1">

                    </div>
                    <div class="boxstepmainsub2">

                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-sm-12divgui endrowgui"><img class="hd" src="../img/b4.png" alt=""></div>
        </div>
        <div class="row" id="stepitem5">
            <div class="col-sm-12 ">
                <div class="boxstep">
                    <div class="boxstepmain">
                        <div class="step">
                            <div class="line1step w100"></div>
                            <div class="line2step w100"></div>
                            <div class="stepitem" onclick="stepitem1()">
                                <i class="fa fa-check"></i>
                                <p class="contentstep c0">Chọn sản phẩm</p>
                            </div>
                            <div class="stepitem" onclick="stepitem2()">
                                <i class="fa fa-check"></i>
                                <p class="contentstep c25">Chọn màu sắc và size</p>
                            </div>
                            <div class="stepitem" onclick="stepitem3()">
                                <i class="fa fa-check"></i>
                                <p class="contentstep c50">Thêm vào giỏ hàng</p>
                            </div>
                            <div class="stepitem" onclick="stepitem4()">
                                <i class="fa fa-check"></i>
                                <p class="contentstep c75">Kiểm tra giỏ hàng</p>
                            </div>
                            <div class="stepitem" onclick="stepitem5()">
                                <i class="fa fa-circle"></i>
                                <p class="contentstep c100">Thanh toán</p>
                            </div>
                        </div>
                    </div>
                    <div class="boxstepmainsub1">

                    </div>
                    <div class="boxstepmainsub2">

                    </div>
                </div>
            </div>
            <div class="col-sm-12  endrowgui"><img class="hd" src="../img/b5.png" alt=""></div>
        </div>
    </div>
</main>


<!-- Subscribe section -->
<jsp:include page="../WEB-INF/Share/_LayoutChatBox.jsp"></jsp:include>

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