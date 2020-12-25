<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/12/2020
  Time: 2:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../js/Truong/bootstrap/bootstrap.css">
    <script type="text/javascript" src="../js/Truong/jquery/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="../js/Truong/bootstrap/bootstrap.js"></script>
    <link rel="stylesheet" href="../css/detailsProduct.css">
    <link rel="stylesheet" href="../js/Truong/fonta/css/all.css">
    <script src="../js/detailsProduct.js"></script>
    <link rel="stylesheet" href="../css/style-starter.css">
    <title>TVTShop | Liên hệ</title>


    <!-- Font awesome -->
    <link href="../css/font-awesome.css" rel="stylesheet">
    <!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css"
          integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous"> -->
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
    <!-- <link id="switcher" href="css/theme-color/bridge-theme.css" rel="stylesheet"> -->
    <!-- Top Slider CSS -->
    <link href="../css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">

    <!-- Main style sheet -->
    <link href="../css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/banner.css">

    <!-- Google Font -->
    <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>

    <style>
        .row.top-map {
            padding-top: 90px;
            padding-bottom: 76px;
        }

        .form {
            margin-top: -14px;
            padding: 63px;
        }

        button.btn {
            color: white;
        }
    </style>


    <title>TVT Shop | Contact Page</title>
</head>

<body>

<!-- wpf loader Two -->
<jsp:include page="../WEB-INF/Share/_LayoutLoadAndScroll.jsp"></jsp:include>

<jsp:include page="../WEB-INF/Share/_LayoutHeader.jsp"></jsp:include>

<%request.setCharacterEncoding("utf-8");%>
<jsp:include page="../WEB-INF/Share/_LayoutBanner.jsp">
    <jsp:param name="title" value="Liên hệ"/>
</jsp:include>
<!-- / catg header banner section -->

<!-- contacts -->
<section class="w3l-contacts-8">
    <div class="contacts-9 section-gap py-5">
        <div class="container py-lg-5">
            <div class="row top-map">
                <div class="col-lg-6 partners">
                    <div class="cont-details">
                        <h5 class="hny-title mb-0">Liên lạc với <span>chúng tôi</span></h5>
                        <p class="mb-5">Chúng tôi sẵn sàng phục vụ khách hàng một cách chu đáo và tận tâm nhất. Hãy
                            xây dựng
                            shop ngày càng hoàn hiện hơn bằng các góp ý, nhận xét của các bạn.</p>
                        <p class="margin-top"><span class="texthny">Điện thoại</span> : </span> <a
                                href="tel:+(84) 255 999 8899">+(84)
                            255 999 8899</a></p>
                        <p><span class="texthny">Email : </span> <a href="mailto:tvtshop@gmail.com">
                            tvtshop@gmail.com</a></p>
                        <p class="margin-top"> Khu phố 6, phường Linh Trung, quận Thủ Đức, tp.HCM </p>
                    </div>
                    <div class="hours">
                        <h5 class="hny-title">Giờ <span>Làm Việc</span></h5>
                        <h6>Giờ kinh doanh:</h6>
                        <p> Thứ hai đến thứ 6 từ 7.00 am - 6.00 pm</p>
                        <p> Thứ bảy và chủ nhật từ 7.00 am - 5.00 pm</p>
                        <h6 class="margin-top">Hỗ trợ khách hàng:</h6>
                        <p> Thứ hai đến thứ sáu từ 8.00 am - 6.00 pm</p>
                        <p> Thứ 7 từ 10.00 am - 4.00 pm</p>
                        <p> Chủ nhật - Đóng cửa</p>
                    </div>
                </div>
                <div class="col-lg-6 map" id="map">
                    <iframe
                            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.2589225125566!2d106.78567241462343!3d10.867900692259482!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3175276398969f7b%3A0x9672b7efd0893fc4!2zxJDhuqFpIEjhu41jIE7DtG5nIEzDom0!5e0!3m2!1svi!2s!4v1604510012497!5m2!1svi!2s"
                            width="600" height="450" frameborder="0" style="border:0;" allowfullscreen=""
                            aria-hidden="false"
                            tabindex="0"></iframe>
                    <!-- <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.2589225125566!2d106.78567241462343!3d10.867900692259482!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3175276398969f7b%3A0x9672b7efd0893fc4!2zxJDhuqFpIEjhu41jIE7DtG5nIEzDom0!5e0!3m2!1svi!2s!4v1604508777906!5m2!1svi!2s" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe> -->
                </div>
            </div>
        </div>
    </div>
    <div class="map-content-9 form-bg-img">
        <div class="layer section-gap py-5">
            <div class="container py-lg-5">
                <div class="form">
                    <h3 class="hny-title two text-center">Điền thông tin vào form</h3>
                    <form action="https://sendmail.w3layouts.com/submitForm" class="mt-md-5 mt-4" method="post">
                        <div class="input-grids">
                            <input type="text" name="w3lName" id="w3lName" placeholder="Tên">
                            <input type="email" name="w3lSender" id="w3lSender" placeholder="Email" required=""/>
                            <!-- <input type="subject" name="w3lSubject" id="w3lSubject" placeholder="Subject" required=""> -->
                        </div>
                        <div class="input-textarea">
                <textarea name="w3lMessage" id="w3lMessage" placeholder="Viết nội dung vào đây..."
                          required=""></textarea>
                        </div>
                        <button type="submit" class="btn">Send</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- footer -->
<jsp:include page="../WEB-INF/Share/_LayoutChatBox.jsp"></jsp:include>

<!-- footer -->
<jsp:include page="../WEB-INF/Share/_layoutFooter.jsp"></jsp:include>
<!-- / footer -->
<!-- / footer -->

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap.js"></script>
<!-- SmartMenus jQuery plugin -->
<script type="text/javascript" src="../js/jquery.smartmenus.js"></script>
<!-- SmartMenus jQuery Bootstrap Addon -->
<script type="text/javascript" src="../js/jquery.smartmenus.bootstrap.js"></script>
<!-- Product view slider -->
<script type="text/javascript" src="../js/jquery.simpleGallery.js"></script>
<script type="text/javascript" src="../js/jquery.simpleLens.js"></script>
<!-- slick slider -->
<script type="text/javascript" src="../js/slick.js"></script>
<!-- Price picker slider -->
<script type="text/javascript" src="../js/nouislider.js"></script>
<!-- Custom js -->
<script src="../js/custom.js"></script>
<script language="javascript">
    //chon anh
    var l1 = document.getElementById('l1');
    var l2 = document.getElementById('l2');
    var l3 = document.getElementById('l3');
    var l4 = document.getElementById('l4');

    var slide1 = document.getElementById('slide1');
    var slide2 = document.getElementById('slide2');
    var slide3 = document.getElementById('slide3');
    var slide4 = document.getElementById('slide4');
    l2.onclick = function () {

        slide2.style.border = "border: 3px solid #f60";

        slide1.style.border = "border: 3px solid #d6cfcf";

        slide3.style.border = "border: 3px solid #d6cfcf";

        slide4.style.border = "border: 3px solid #d6cfcf";

        console.log("dghdfghdfg");


    }
    //chon mau ao
    var c1 = document.getElementById('cl1');
    var c2 = document.getElementById('cl2');
    var lb1 = document.getElementsByClassName('img_color1')[0];
    var lb2 = document.getElementsByClassName('img_color2')[0];
    c1.onclick = function () {
        lb1.style.border = "3px solid #f60";
        lb2.style.border = "3px solid #d5cece";
        console.log(5);
    }
    c2.onclick = function () {
        lb2.style.border = "3px solid #f60";
        lb1.style.border = "3px solid #d5cece";
        console.log(4);
    }
    //chon kich thuoc
    var m = document.getElementById('m_size');
    var l = document.getElementById('l_size');
    var xl = document.getElementById('xl_size');
    var m_size = document.getElementsByClassName('m_size')[0];
    var l_size = document.getElementsByClassName('l_size')[0];
    var xl_size = document.getElementsByClassName('xl_size')[0];
    m.onclick = function () {
        m_size.style.border = "3px solid #f60";
        l_size.style.border = "3px solid #d5cece";
        xl_size.style.border = "3px solid #d5cece";
    }
    l.onclick = function () {
        l_size.style.border = "3px solid #f60";
        m_size.style.border = "3px solid #d5cece";
        xl_size.style.border = "3px solid #d5cece";
    }
    xl.onclick = function () {
        xl_size.style.border = "3px solid #f60";
        l_size.style.border = "3px solid #d5cece";
        m_size.style.border = "3px solid #d5cece";
    }


    // l1.onclick = function(){
    //     slide1.style.border = "border: 3px solid #f60";
    //     slide1.style.border = "border: 3px solid #d6cfcf";
    //     slide1.style.border = "border: 3px solid #d6cfcf";
    //     slide1.style.border = "border: 3px solid #d6cfcf";
    // }
    // l1.onclick = function(){
    //     slide1.style.border = "border: 3px solid #f60";
    //     slide1.style.border = "border: 3px solid #d6cfcf";
    //     slide1.style.border = "border: 3px solid #d6cfcf";
    //     slide1.style.border = "border: 3px solid #d6cfcf";
    // }
    // l1.onclick = function(){
    //     slide1.style.border = "border: 3px solid #f60";
    //     slide1.style.border = "border: 3px solid #d6cfcf";
    //     slide1.style.border = "border: 3px solid #d6cfcf";
    //     slide1.style.border = "border: 3px solid #d6cfcf";
    // }
    // l1.onclick = function(){
    //     slide1.style.border = "border: 3px solid #f60";
    //     slide1.style.border = "border: 3px solid #d6cfcf";
    //     slide1.style.border = "border: 3px solid #d6cfcf";
    //     slide1.style.border = "border: 3px solid #d6cfcf";
    // }
</script>
</body>

</html>