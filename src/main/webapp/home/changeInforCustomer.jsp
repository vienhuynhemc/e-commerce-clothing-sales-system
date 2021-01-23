<%@ page import="beans.account.AccountCustomer" %>
<%@ page import="beans.DateTime" %>
<%@ page import="beans.account.ErrorEditAccountCustomer" %>
<%@ page import="model.language.IndexLanguageModel" %>
<%@ page import="java.util.Map" %>
<%@ page import="model.language.ChangInfoCustomerLanguageModel" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21/12/2020
  Time: 8:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8");%>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVT SHOP | Tài khoản khách hàng</title>


    <script src="js/Truong/jquery/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/jquery.smartmenus.bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/jquery.simpleLens.css">
    <link rel="stylesheet" type="text/css" href="css/nouislider.css">
    <link id="switcher" href="css/theme-color/default-theme.css" rel="stylesheet">
    <link href="css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="css/trangChu.css">
    <script src="js"></script>

    <link rel="stylesheet" href="css/banner.css">
    <link rel="stylesheet" href="css/informationCustomer.css">
    <link rel="stylesheet" href="css/cart.css">
    <link rel="stylesheet" href="css/hienthiform2.css">

    <script src="js/informationCustomer.js"></script>



</head>




<%
    //  Chuyển về UTF-8
    request.setCharacterEncoding("UTF-8");

    //  Lấy list ngôn ngữ ra
    Map<String, String> lang = (Map<String, String>) session.getAttribute("langList");

    // Riêng khi test, khi mở server thì nó vô thẳng trang này nên là lấy thủ công ra 1 tí
    if (lang == null) {
        lang = ChangInfoCustomerLanguageModel.getInstance().getList("vietnamese");
    }

%>



<body>

<!-- wpf loader Two -->
<jsp:include page="../share/_LayoutLoadAndScroll.jsp"></jsp:include>
<!-- END SCROLL TOP BUTTON -->

<!-- Start header section -->
<jsp:include page="../share/_LayoutHeader.jsp">
    <jsp:param name="linkMainPage" value="ChangeInfoLanguageController"/>
    <jsp:param name="levelPage" value=""/>
    <jsp:param name="activeselect" value="index.jsp"/>
</jsp:include>
<!-- / header section -->

<!-- catg header banner section -->
<%request.setCharacterEncoding("utf-8");%>
<jsp:include page="../share/_LayoutBanner.jsp">
    <jsp:param name="titleVietnamese" value="Thay đổi thông tin"/>
    <jsp:param name="titleEnglish" value="Change information"/>
</jsp:include>
<!-- / catg header banner section -->

<!-- main-->

        <div class="mainAccount" id="contentaccount">
        <div class="contentAccount" id="loadinfocustomer">


            <!-------load thông tin khách hàng---->


        </div>
    </div>


<!---------2 form hiển thị thông báo ----------->
<div class="changepassword" id="changepassword">
        <div class="hiddenchangepassword" onclick="gobackpassword()"></div>
        <div class="mainchangepassword">
            <p class="changepasswordtitle"><i class="fa fa-cogs"></i>TVT Shop</p>
            <div class="changepassworddiv" id="changepassworddiv">
                <p>Đổi mật khẩu của bạn</p>
                <label for="matkhaucu">Mật khẩu cũ</label>
                <input name="oldPass" type="password" id="matkhaucu" placeholder="Nhập mật khẩu cũ">
                <label for="matkhaumoi">Mật khẩu mới</label>
                <input name="newPass" type="password" id="matkhaumoi" placeholder="Nhập mật khẩu mới">
                <label for="rematkhau">Xác nhận mật khẩu mới</label>
                <input name="rePass" type="password" id="rematkhau" placeholder="Xác nhận mật khẩu mới của bạn">
                <button type="button" onclick="changePass()">Thay đổi mật khẩu</button>
            </div>
        </div>
    </div>


<div id="addCartStatus2" style="display:none; z-index: 100000;position: relative">
    <div class="changepassword2" id="changepassword2">
        <div class="hiddenchangepassword2" onclick="gobackpassword1()"></div>
        <div class="mainchangepassword2">
            <p class="changepasswordtitle2"><i class="fa fa-cogs"></i>TVT Shop</p>
            <div class="changepasswordsuccess2" id="changepasswordsuccess2">
                <p id="changepassstatus">  </p>
                <button onclick="gobackpassword1()">Trở về
                </button>
            </div>
        </div>
    </div>
</div>

<!---------2 form hiển thị thông báo ----------->

<!-- sử lí hiện bảng thông báo ---->
<%--<%--%>
<%--    //lấy request loginStatus != null thì đăng nhập thất bại--%>

<%--    String status = (String) request.getAttribute("error");--%>

<%--    if (status  != null) {--%>

<%--        //truyển status vào để sử lí--%>
<%--        ErrorEditAccountCustomer editError = new ErrorEditAccountCustomer(status);--%>
<%--%>--%>

<%--<script>--%>

<%--    document.getElementById("doimatkhau").onclick="doimatkhau()";--%>

<%--</script>--%>

<%--<%request.setCharacterEncoding("utf-8");%>--%>
<%--<jsp:include page="../notifyErrorLogin/AccountStatus.jsp">--%>
<%--    <jsp:param name="title" value="<%=editError.getTitle()%>"/>--%>
<%--    <jsp:param name="content" value="<%=editError.getContent()%>"/>--%>
<%--</jsp:include>--%>
<%--<%--%>
<%--    }--%>
<%--%>--%>


<!--cart-->
<div class="inforcart" id="inforcart">
    <div class="hiddencart" onclick="trovetaikhoan()"></div>
    <div class="informationinforcart">
        <section class="contentcart" id="contentcart">
            <div class="cart" id="loadDetailOrder" >

            </div>
        </section>
    </div>
</div>
<!--End main-->

<input type="hidden" name="" id="checkchange" value="0">

<jsp:include page="../share/_LayoutChatBox.jsp"></jsp:include>

<!-- footer -->
<jsp:include page="../share/_LayoutFooter.jsp"></jsp:include>
<!-- / footer -->

</body>

</html>


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


<!-- The core Firebase JS SDK is always required and must be listed first -->
<script src="https://www.gstatic.com/firebasejs/8.2.1/firebase-app.js"></script>
<script src="https://www.gstatic.com/firebasejs/8.2.1/firebase-storage.js"></script>
<script src="https://www.gstatic.com/firebasejs/8.2.1/firebase-database.js"></script>

<!-- TODO: Add SDKs for Firebase products that you want to use
https://firebase.google.com/docs/web/setup#available-libraries -->
<script src="https://www.gstatic.com/firebasejs/8.2.1/firebase-analytics.js"></script>

<script>

    $(document).ready(function (){
        loadInfo();
    })

    function loadInfo(){
        $.ajax({
            url:'LoadInfoCustomor',
            dataType:'html',
            type:'get',
            success:function (data){
                $("#loadinfocustomer").html(data);
            },
            error:function (){
                window.location.href = "dang-xuat";
            }
        });
    }

    function changePass(){
        var mat_khau_cu = $('#matkhaucu').val();

        var mat_khau_moi = $('#matkhaumoi').val();

        var nhap_lai = $('#rematkhau').val();

        document.getElementById("addCartStatus2").style.display = "none";
        document.getElementById('changepassword2').style.transform = 'scaleY(0)';

        if (mat_khau_cu == "" || mat_khau_moi == "" || nhap_lai == "" ){

            $("#changepassstatus").text("Vui lòng nhập đầy đủ thông tin để thay đổi mật khẩu");

            document.getElementById("addCartStatus2").style.display = "block";
            document.getElementById('changepassword2').style.transform = 'scaleY(1)';

        }else if (mat_khau_moi != nhap_lai) {
            $("#changepassstatus").text("Mật khẩu mới và xác nhận mật khẩu không trùng khớp");

            document.getElementById("addCartStatus2").style.display = "block";
            document.getElementById('changepassword2').style.transform = 'scaleY(1)';
        }else if(mat_khau_moi == nhap_lai && nhap_lai == mat_khau_cu){
            $("#changepassstatus").text("Mật khẩu mới phải khác với mật khẩu cũ");

            document.getElementById("addCartStatus2").style.display = "block";
            document.getElementById('changepassword2').style.transform = 'scaleY(1)';
        }else{
            $.ajax({
                url:'ChangePasswordController',
                dataType:'json',
                type:'post',
                data:{
                    mat_khau_cu:mat_khau_cu,
                    mat_khau_moi:mat_khau_moi
                },
                success:function (data){

                    if(data){
                        $("#changepassstatus").text("Thay đổi mật khẩu thành công!");
                        document.getElementById("addCartStatus2").style.display = "block";
                        document.getElementById('changepassword2').style.transform = 'scaleY(1)';
                        $('#checkchange').prop("value",1);
                    }else{
                        $("#changepassstatus").text("Mật khẩu cũ không đúng, vui lòng nhập lại!");
                        document.getElementById("addCartStatus2").style.display = "block";
                        document.getElementById('changepassword2').style.transform = 'scaleY(1)';
                    }
                },
                error:function (){
                    $("#changepassstatus").text("Lỗi thay đổi mật khẩu");
                    document.getElementById("addCartStatus2").style.display = "block";
                    document.getElementById('changepassword2').style.transform = 'scaleY(1)';
                }
            })
        }
    }
    function gobackpassword() {

            document.getElementById('changepassword').style.transform = 'scaleY(0)';

    }
    function gobackpassword1(){
        if($("#checkchange").val() == 1){
            window.location.href = "dang-xuat";
        }else{
        document.getElementById('changepassword2').style.transform = 'scaleY(0)';
        }
    }
</script>



