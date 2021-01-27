<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21/12/2020
  Time: 7:13 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TVT Shop | Về chúng tôi</title>

    <!-- Font awesome -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css"
          integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- SmartMenus jQuery Bootstrap Addon CSS -->
    <link href="css/jquery.smartmenus.bootstrap.css" rel="stylesheet">
    <!-- Product view slider -->
    <link rel="stylesheet" type="text/css" href="css/jquery.simpleLens.css">
    <!-- slick slider -->
    <link rel="stylesheet" type="text/css" href="css/slick.css">
    <!-- price picker slider -->
    <link rel="stylesheet" type="text/css" href="css/nouislider.css">
    <!-- Theme color -->
    <link id="switcher" href="css/theme-color/default-theme.css" rel="stylesheet">
    <!-- Top Slider CSS -->
    <link href="css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">

    <!-- Main style sheet -->


    <link rel="stylesheet" href="css/about.css">
    <!-- <link rel="stylesheet" href="css/header.css"> -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/banner.css">
    <link rel="stylesheet" href="css/trangChu.css">
    <script src="js/trangChu.js"></script>
<%--    <script src="../js"></script>--%>

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
<%--<jsp:include page="../share/_LayoutLoadAndScroll.jsp"></jsp:include>--%>
<!-- END SCROLL TOP BUTTON -->

<!-- Start header section -->
<jsp:include page="../share/_LayoutHeader.jsp">
    <jsp:param name="linkMainPage" value="ChangeInfoLanguageController"/>
    <jsp:param name="levelPage" value=""/>
    <jsp:param name="activeselect" value="index.jsp"/>
</jsp:include>
<!-- / header section -->

<%request.setCharacterEncoding("utf-8");%>
<jsp:include page="../share/_LayoutBanner.jsp">
    <jsp:param name="titleVietnamese" value="Về chúng tôi"/>
    <jsp:param name="titleEnglish" value="Contact"/>
</jsp:include>
<!-- / catg header banner section -->

<!-- Cart view section -->
<section class="w3l-wecome-content-6">
    <!-- /content-6-section -->
    <div class="ab-content-6-mian py-5">
        <div class="container py-lg-5">
            <div class="welcome-grids row">
                <div class="col-lg-6 mb-lg-0 mb-5">
                    <h3 class="hny-title">
                        GIỚI THIỆU VỀ TVT<span> Shop</span></h3>
                    <p class="my-4">Ra mắt năm 2019, nền tảng thương mại TVT Shop được xây dựng nhằm
                        cung cấp cho người sử dùng những trải nghiệm dễ dàng, an toàn và nhanh chóng
                        khi mua sắm trực tuyến thông qua hệ thống hỗ trợ thanh toán và vận hành vững mạnh.</p>
                    <p class="mb-4">Chúng tôi có niềm tin mạnh mẽ rằng trải nghiệm mua sắm trực tuyến phải đơn giản,
                        dễ
                        dàng và
                        mang đến cảm xúc vui thích.
                        Niềm tin này truyền cảm hứng và thúc đẩy chúng tôi mỗi ngày tại TVT Shop.</p>
                    <div class="read">
                        <a href="../index.html" class="read-more btn">Shop Now</a>
                    </div>
                </div>
                <div class="col-lg-6 welcome-image">
                    <img src="../img/about/2.jpg" class="img-fluid" alt="">
                </div>

            </div>

        </div>
    </div>
</section>
<!-- / Cart view section -->
<section class="w3l-specification-6">
    <!-- /specification-6-->
    <div class="specification-6-mian py-5">
        <div class="container py-lg-5">
            <div class="row story-6-grids text-left">
                <div class="col-lg-5 story-gd">
                    <img src="../img/about/left2.jpg" class="img-fluid" alt="/">
                </div>
                <div class="col-lg-7 story-gd pl-lg-4">
                    <h3 class="hny-title">GIÁ TRỊ CỦA <span>CHÚNG TÔI</span></h3>
                    <p>Để định nghĩa chúng tôi là ai - thông qua lời nói hay cách ứng xử trong nhiều trường hợp khác
                        nhau -
                        thì thực chất, chúng tôi Gần gũi, Vui vẻ và Đồng lòng.
                        Đây là những đặc tính chính và nổi bật trong từng bước đường phát triển của TVT Shop..</p>

                    <div class="row story-info-content mt-md-5 mt-4">

                        <div class="col-md-6 story-info">
                            <h5><a href="#">01. Chúng tôi phục vụ</a></h5>
                            <p>Khách hàng luôn đúng. Cung cấp những giá trị vượt xa sự mong đợi của khách hàng.</p>


                        </div>
                        <div class="col-md-6 story-info">
                            <h5><a href="#">02. Chúng tôi chuyển đổi</a></h5>
                            <p>Dự đoán những thay đổi và lập kế hoạch trước. Chấp nhận những thay đổi không lường
                                trước
                                và chủ động
                                trong việc thực thi.</p>
                        </div>
                        <div class="col-md-6 story-info">
                            <h5><a href="#">03. Chúng tôi cam kết</a></h5>
                            <p>Đáng tin cậy, làm những gì đã nói.
                                Nâng cao các tiêu chuẩn; không đi đường tắt ngay cả khi không có ai đang quan sát.
                                Chủ động tìm cách phát triển tổ chức.</p>
                        </div>
                        <div class="col-md-6 story-info">
                            <h5><a href="#">04. Chúng tôi luôn phát triển</a></h5>
                            <p>Tự định hướng để phát triển, không cần ai thúc đẩy.
                                Luôn khẩn trương hoàn thành công việc.</p>
                        </div>
                    </div>

                </div>


            </div>
        </div>
    </div>
</section>
<!-- //specification-6-->

<section class="w3l-services-6">
    <!-- /content-6-section -->
    <div class="services-grids-6 py-5">
        <div class="container py-lg-5">
            <div class="row w3-icon-grid-gap1">
                <div class="col-md-6 w3-icon-grid1">
                    <a href="#link">
                        <span class="fa fa-codepen" aria-hidden="true"></span>
                        <h3>Hãy để giày dép của bạn nói chuyện</h3>
                        <div class="clearfix"></div>
                    </a>
                    <p>Chọn một đôi giày tốt không có nghĩa là bạn chắc chắn có hướng đi đúng hay chuyến đi an toàn.
                        Nhưng cố gắng lựa chọn đúng nhất ngay lúc này, khi bạn có quyền lựa chọn.</p>
                </div>
                <div class="col-md-6 w3-icon-grid1">
                    <a href="#link">
                        <span class="fa fa-mobile" aria-hidden="true"></span>
                        <h3>Bộ sưu tập của người nổi tiếng</h3>
                        <div class="clearfix"></div>
                    </a>
                    <p>"Tôi muốn tưởng tượng điều xảy ra nếu quá khứ tìm tới chúng ta",
                        Nicolas Ghesquière nói về ý tưởng bộ sưu tập mùa này.
                    </p>
                </div>
                <div class="col-md-6 w3-icon-grid1">
                    <a href="#link">
                        <span class="fa fa-hourglass" aria-hidden="true"></span>
                        <h3>Hiệu ứng</h3>
                        <div class="clearfix"></div>
                    </a>
                    <p>Cảm hứng ‘Animated Logo’: Logo hoạt ảnh đầy cuốn hút từ các thương hiệu nổi tiếng</p>
                </div>
                <div class="col-md-6 w3-icon-grid1">
                    <a href="#link">
                        <span class="fa fa-modx" aria-hidden="true"></span>
                        <h3>Bộ sưu tập giày thể thao phong phú</h3>
                        <div class="clearfix"></div>
                    </a>
                    <p>Phù hợp với tất cả các phong cách từ năng đông đến nhẹ nhàng , không kén trọn đồ nên sneaker
                        luôn
                        là lựa
                        chọn hàng đầu của các bạn gái. </p>
                </div>
                <div class="col-md-6 w3-icon-grid1">
                    <a href="#link">
                        <span class="fa fa-bar-chart" aria-hidden="true"></span>
                        <h3>Bộ sưu tập được thiết kế độc đáo</h3>
                        <div class="clearfix"></div>
                    </a>
                    <p>Trong nền văn hóa truyền thống, khi cuộc sống trở nên sung túc hơn thì con người thường chú
                        trọng
                        đến lễ
                        nghĩa, tâm linh. Những năm gần đây, các vật phẩm mang yếu tố may mắn, phong thủy của
                        VietinBank
                        Gold &
                        Jewellery phân phối rất được thị trường ưa chuộng.</p>
                </div>
                <div class="col-md-6 w3-icon-grid1">
                    <a href="#link">
                        <span class="fa fa-shopping-bag" aria-hidden="true"></span>
                        <h3>Giày dép chất lượng cao</h3>
                        <div class="clearfix"></div>
                    </a>
                    <p>Các nhà phân tích thị trường đã ước tính rằng thị trường giày dép sẽ đạt doanh thu gần 353 tỷ
                        đô
                        la vào
                        năm 2022. Trong đó, nổi bật lên là hãng giày Adidas, ASICS, Nike với các dịch vụ cực kỳ sáng
                        tạo.</p>
                </div>


            </div>
        </div>
    </div>
</section>
<!-- //content-6-section -->

<!-- features-4 -->
<section class="features-4">
    <div class="features4-block py-5">
        <div class="container py-lg-5">
            <h6>Chúng tôi là tốt nhất</h6>
            <h3 class="hny-title text-center">Chúng tôi <span>cung cấp</span></h3>

            <div class="features4-grids text-center row mt-5">
                <div class="col-lg-3 col-md-6 features4-grid">
                    <div class="features4-grid-inn">
                        <span class="fa fa-bullhorn icon-fea4" aria-hidden="true"></span>
                        <h5><a href="#URL">Gọi cho chúng tôi bất cứ lúc nào</a></h5>
                        <p>Bất cứ lúc nào chúng tôi cũng luôn phục vụ bạn.</p>

                    </div>
                </div>
                <div class="col-lg-3 col-md-6 features4-grid sec-features4-grid">
                    <div class="features4-grid-inn">
                        <span class="fa fa-truck icon-fea4" aria-hidden="true"></span>
                        <h5><a href="#URL">Miễn phí vận chuyển</a></h5>
                        <p> Bạn phải sử dụng mã miễn phí vận chuyển TVT Shop vào trong đơn hàng của mình.</p>

                    </div>
                </div>
                <div class="col-lg-3 col-md-6 features4-grid">
                    <div class="features4-grid-inn">
                        <span class="fa fa-recycle icon-fea4" aria-hidden="true"></span>
                        <h5><a href="#URL">Trả hàng miễn phí</a></h5>
                        <p>Áp dụng chính sách TRẢ HÀNG VÀ HOÀN TIỀN khi đầy đủ điều kiện.</p>

                    </div>
                </div>
                <div class="col-lg-3 col-md-6 features4-grid">
                    <div class="features4-grid-inn">
                        <span class="fa fa-money icon-fea4" aria-hidden="true"></span>
                        <h5><a href="#URL">Thanh toán đảm bảo</a></h5>
                        <p>Đảm bảo thanh toán an toàn và tiện lợi nhất cho người dùng.</p>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- features-4 -->

<section class="w3l-team-main">
    <div class="team py-5">
        <div class="container py-lg-5">
            <h3 class="hny-title text-center">
                Nhóm <span>Chúng Tôi</span></h3>
            <div class="row team-row mt-5">
                <div class="col-lg-4 col-sm-6 mb-lg-0 mb-4 team-wrapper position-relative">
                    <a href="#"><img src="../img/imgDeveloper/vien.jpg" class="team_member img-fluid"
                                     alt="Team Member"></a>
                    <div class="team_info mt-3 position-absolute">
                        <h3><a href="#" class="team_name">Huỳnh Văn Viên</a></h3>
                        <span class="team_role">Admin &amp; Marketing</span>
                        <ul class="team-social mt-3">
                            <li><a href="#"><span class="fa fa-facebook icon_facebook"></span></a></li>
                            <li><a href="#"><span class="fa fa-twitter icon_twitter"></span></a></li>
                            <li><a href="#"><span class="fa fa-linkedin icon_linkedin"></span></a></li>
                            <li><a href="#"><span class="fa fa-google-plus icon_google-plus"></span></a></li>
                        </ul>
                    </div>
                </div>
                <!-- end team member -->

                <div class="col-lg-4 col-sm-6 mb-lg-0 mb-4 team-wrapper position-relative">
                    <a href="#"><img src="../img/imgDeveloper/thanh.jpg" class="team_member img-fluid thanh"
                                     alt="Team Member"></a>
                    <div class="team_info mt-3 position-absolute">
                        <h3><a href="#" class="team_name">Nguyễn Văn Thành</a></h3>
                        <span class="team_role">Developer</span>
                        <ul class="team-social mt-3">
                            <li><a href="#"><span class="fa fa-facebook icon_facebook"></span></a></li>
                            <li><a href="#"><span class="fa fa-twitter icon_twitter"></span></a></li>
                            <li><a href="#"><span class="fa fa-linkedin icon_linkedin"></span></a></li>
                            <li><a href="#"><span class="fa fa-google-plus icon_google-plus"></span></a></li>
                        </ul>
                    </div>
                </div>
                <!-- end team member -->
                <div class="col-lg-4 col-sm-6 team-wrapper position-relative">
                    <a href="#"><img src="../img/imgDeveloper/truong.jpg" class="team_member img-fluid"
                                     alt="Team Member"></a>
                    <div class="team_info mt-3 position-absolute">
                        <h3><a href="#" class="team_name">Nuỳnh Nhật Trường</a></h3>
                        <span class="team_role">Designer</span>
                        <ul class="team-social mt-3">
                            <li><a href="#"><span class="fa fa-facebook icon_facebook"></span></a></li>
                            <li><a href="#"><span class="fa fa-twitter icon_twitter"></span></a></li>
                            <li><a href="#"><span class="fa fa-linkedin icon_linkedin"></span></a></li>
                            <li><a href="#"><span class="fa fa-google-plus icon_google-plus"></span></a></li>
                        </ul>
                    </div>
                </div>
                <!-- end team member -->
            </div>
        </div>
    </div>
</section>


<jsp:include page="../share/_LayoutChatBox.jsp"></jsp:include>

<!-- footer -->
<jsp:include page="../share/_LayoutFooter.jsp"></jsp:include>
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
<script src="js/bootstrap.js"></script>
<!-- SmartMenus jQuery plugin -->
<script type="text/javascript" src="js/jquery.smartmenus.js"></script>
<!-- SmartMenus jQuery Bootstrap Addon -->
<script type="text/javascript" src="js/jquery.smartmenus.bootstrap.js"></script>
<!-- To Slider JS -->
<script src="js/sequence.js"></script>
<script src="js/sequence-theme.modern-slide-in.js"></script>
<!-- Product view slider -->
<script type="text/javascript" src="js/jquery.simpleGallery.js"></script>
<script type="text/javascript" src="js/jquery.simpleLens.js"></script>
<!-- slick slider -->
<script type="text/javascript" src="js/slick.js"></script>
<!-- Price picker slider -->
<script type="text/javascript" src="js/nouislider.js"></script>
<!-- Custom js -->
<script src="js/custom.js"></script>

</body>

</html>
