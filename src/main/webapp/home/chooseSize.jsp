<%@ page import="java.util.Map" %>
<%@ page import="model.language.ChooseSizeLanguageModel" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/12/2020
  Time: 2:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVTShop | Hướng dẫn chọn size</title>


    <!-- Font awesome -->
    <link href="../css/font-awesome.css" rel="stylesheet">

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
    <link rel="stylesheet" href="../css/trangChu.css">
    <link rel="stylesheet" href="../css/banner.css">

    <script src="../js/chooseSize.js"></script>

    <!-- Google Font -->
    <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/chooseSize.css">
</head>

<!--------------------------------Lấy list ngôn ngữ ra---------------------------------------->

<%
    //  Chuyển về UTF-8
    request.setCharacterEncoding("UTF-8");

    //  Lấy list ngôn ngữ ra
    Map<String, String> lang = (Map<String, String>) session.getAttribute("langList");

    // Riêng khi test, khi mở server thì nó vô thẳng trang này nên là lấy thủ công ra 1 tí
    if (lang == null) {
        lang = ChooseSizeLanguageModel.getInstance().getList("vietnamese");
    }

%>


<body>
<!-- wpf loader Two -->
<jsp:include page="../share/_LayoutLoadAndScroll.jsp"/>

<jsp:include page="../share/_LayoutHeader.jsp">
    <jsp:param name="linkMainPage" value="ChooseSizeLanguageController"/>
    <jsp:param name="levelPage" value="../"/>
</jsp:include>
<!-- / header section -->

<jsp:include page="../share/_LayoutBanner.jsp">
    <jsp:param name="titleVietnamese" value="Hướng dẫn chọn size"/>
    <jsp:param name="titleEnglish" value="Instructions to choose the size"/>
</jsp:include>
<!-- / catg header banner section -->

<div class="col-sm-12 divtitle">
    <h3 class="title titlemain"><span class="red"><%=lang.get("1")+" "%></span> <%=lang.get("2")%></h3>
    <p class="titilesub"><%=lang.get("3")%></p>

    <div class="selectdiv">
        <div class="men" id="men" onclick="man()"><%=lang.get("4")%></div>
        <div class="woman" id="woman" onclick="woman()"><%=lang.get("5")%></div>
    </div>

    <img id="size1" src="../img/size1.jpg" class="img_policy" alt="">
    <img id="size2" src="../img/size2.jpg" class="img_policy" alt="">
    <img id="size3" src="../img/size3.jpg" class="img_policy" alt="">
    <img id="size4" src="../img/size4.jpg" class="img_policy" alt="">
</div>


<!-- footer -->
<jsp:include page="../share/_LayoutChatBox.jsp"/>

<!-- footer -->
<jsp:include page="../share/_LayoutFooter.jsp">
    <jsp:param name="levelPage" value="../"/>
</jsp:include>
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
</body>

</html>