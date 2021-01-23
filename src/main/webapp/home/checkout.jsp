<%@ page import="beans.account.AccountCustomer" %><%--
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

    <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/jquery.smartmenus.bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/jquery.simpleLens.css">
    <link rel="stylesheet" type="text/css" href="css/nouislider.css">
    <link id="switcher" href="css/theme-color/default-theme.css" rel="stylesheet">
    <link href="css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="css/trangChu.css">
<%--    <script src="js"></script>--%>
    <link rel="stylesheet" href="css/banner.css">
    <link rel="stylesheet" href="css/checkout2.css">
    <link rel="stylesheet" href="css/hienthiform.css">


    <% AccountCustomer user = (AccountCustomer) session.getAttribute("user"); %>

</head>

<body>

<!-- wpf loader Two -->
<jsp:include page="../share/_LayoutLoadAndScroll.jsp"></jsp:include>

<jsp:include page="../share/_LayoutHeader.jsp">
    <jsp:param name="linkMainPage" value="CartLanguageController"/>
    <jsp:param name="levelPage" value=""/>
    <jsp:param name="activeselect" value="index.jsp"/>
</jsp:include>



<%request.setCharacterEncoding("utf-8");%>
<jsp:include page="../share/_LayoutBanner.jsp">
    <jsp:param name="titleVietnamese" value="Thanh toán"/>
    <jsp:param name="titleEnglish" value="Checkout"/>
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
                    <input type="text" value="<%=user.getFullName()%>" disabled>
                </div>

                <div class="emailsdt">
                    <div class="inputitem">
                        <p>Email</p>
                        <input type="text" value="<%=user.getEmail()%>" disabled>
                    </div>
                    <div class="inputitem">
                        <p>Số điện thoại</p>
                        <input type="text" value="<%=user.getPhone()%>" disabled>
                    </div>
                </div>

                <div class="inputitem">
                    <p>Địa chỉ</p>
                    <input type="text" id="ghichu_sp" placeholder="Thông tin nơi bạn nhận hàng">
                </div>

                <div class="qhx">

                    <div class="inputitem">
                        <p>Tỉnh / thành</p>
                        <select name="" id="loadtinhthanh" onchange="loadDistric()">
                            <option data-code="null" value="" selected=""> Chọn tỉnh / thành</option>

                        </select>
                    </div>

                    <div class="inputitem">
                        <p>Quận / huyện</p>
                        <select name="" id="loadquanhuyen" onchange="loadCommune()">
                            <option data-code="null" value="null" selected=""> Chọn quận / huyện</option>
                        </select>
                    </div>

                    <div class="inputitem">
                        <p>Phường / xã</p>
                        <select name="" id="loadphuongxa">
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
                    <label for="ptvc">Giao hàng tiết kiệm</label>
                </div>
            </div>
            <div class="linestatus"></div>

            <div class="phuongthucthanhtoan">
                <p class="title">Phương thức thanh toán</p>
                <div id="phuongthuctt">
                    <input type="radio" id="rd1" value="0" name="tt" checked>
                    <input type="radio" id="rd2" value="1" name="tt">
                    <input type="radio" id="rd3" value="1" name="tt">
                    <label for="rd1" class="lbtt1">
                        <div class="ptttdiv">
                            <img src="img/thanhtoan/tttructiep.png" alt="">
                            <p>Thanh toán khi giao hàng</p>
                            <div class="checkpttt">
                                <i class="fa fa-check"></i>
                            </div>
                        </div>
                    </label>
                    <label for="rd2" class="lbtt2">
                        <div class="ptttdiv">
                            <img src="img/thanhtoan/ttthe.png" alt="">
                            <p>Thanh toán online</p>
                            <div class="checkpttt">
                                <i class="fa fa-check"></i>
                            </div>
                        </div>
                    </label>
                    <label for="rd3" class="lbtt3">
                        <div class="ptttdiv">
                            <img src="img/thanhtoan/ttmomo.png" alt="">
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
                <a href="gio-hang" class="buttonpress">Trở về giỏ hàng</a>

                <div>
                    <a href="san-pham?type=nu">Trở về mua sắm</a>
                    <button type="button" class="buttonpress" onclick="pay()">Thanh toán</button>
                </div>
            </div>

        </div>

        <div class="right" id="loadcartpagecheckout">

            <!------ load trang bên phải của thanh toán  ------>



            <!------ load trang bên phải của thanh toán  ------>
        </div>
    </div>
</div>
<!--End main-->


<!-- form hiển thị thông báo nhập chưa đầy đủ thông tin-->

<div id="addCartStatus2" style="display:none; z-index: 100000;position: relative">
    <div class="changepassword" id="changepassword2">
        <div class="hiddenchangepassword" onclick="gobackpassword()"></div>
        <div class="mainchangepassword" style="height: 332px;">
            <p class="changepasswordtitle"><i class="fa fa-cogs"></i>TVT Shop</p>
            <div class="changepasswordsuccess" id="changepasswordsuccess2">
                <p> Vui lòng chọn đầy đủ thông tin để thực hiện chức năng thanh toán </p>
                <button onclick="gobackpassword()">Trở về
                </button>
            </div>
        </div>
    </div>
</div>



<div id="addCartStatus" style="display:none; z-index: 100000;position: relative">
    <div class="changepassword" id="changepassword">
        <div class="hiddenchangepassword" onclick="gobackpassword()"></div>
        <div class="mainchangepassword">
            <p class="changepasswordtitle"><i class="fa fa-cogs"></i>TVT Shop</p>
            <div class="changepasswordsuccess" id="changepasswordsuccess" style="margin-top: 55px;">


            </div>
        </div>
    </div>
</div>




<!-- form hiển thị thông báo nhập chưa đầy đủ thông tin-->

<jsp:include page="../share/_LayoutChatBox.jsp"></jsp:include>

<!-- footer -->
<jsp:include page="../share/_LayoutFooter.jsp">
    <jsp:param name="levelPage" value=""/>
</jsp:include>
<!-- / footer -->

</body>

<script>

    $(document).ready(function (){
        loadCartCheckout();
        loadProvincial();
    })

    function loadProvincial(){
        $.ajax({
            url: 'LoadProvincialController',
            dataType:'json',
            type:'get',
            success: function (data) {

                for (let i = 0; i < data.length; i++) {
                    $("#loadtinhthanh").append("<option value=" + data[i].provincialId + ">" + data[i].provincialName + "</option>");
                }
            },
            error: function (e) {
                alert("loi load tinh");
            }
        });

    }
    function loadDistric(){

        var ma_tinh = $("#loadtinhthanh").val();

        var list = $("#loadquanhuyen").empty();

        $("#loadquanhuyen").append("<option value='' selected> Chọn quận / huyện </option>");

        var list = $("#loadphuongxa").empty();

        $("#loadphuongxa").append("<option value='' selected> Chọn phường / xã </option>");

        $.ajax({
            url: 'LoadDistricController',
            dataType:'json',
            type:'get',
            data:{
                ma_tinh:ma_tinh
            },
            success: function (data) {

                for (let i = 0; i < data.length; i++) {
                    $("#loadquanhuyen").append("<option value=" + data[i].districtId + ">" + data[i].districtName + "</option>");
                }
            },
            error: function (e) {
                alert("loi load huyen");
            }
        });
    }
    function loadCommune(){

        var ma_huyen = $("#loadquanhuyen").val();
        $("#loadphuongxa").removeAllChild;

        var list = $("#loadphuongxa").empty();

        $("#loadphuongxa").append("<option value='' selected> Chọn phường / xã </option>");

        $.ajax({
            url: 'LoadCommuneController',
            dataType:'json',
            type:'get',
            data:{
                ma_huyen:ma_huyen
            },
            success: function (data) {

                for (let i = 0; i < data.length; i++) {
                    $("#loadphuongxa").append("<option value=" + data[i].communeId + ">" + data[i].communeName + "</option>");
                }
            },
            error: function (e) {
                alert("loi load xa");
            }
        });
    }

    function loadCartCheckout(){
        $.ajax({
            url: 'LoadCartPageCheckoutController',
            dataType:'html',
            type:'get',
            success: function (data) {
                $('#loadcartpagecheckout').html(data);
            },
            error: function (e) {
                alert("loi load sp");
                console.log(e);
                // window.location.href = "index.jsp";
            }
        });
    }

    function promoPay() {

        var ma = $('#ma_gg').val();

        var tongtien = parseInt($("#tongtiensp").val());

        $.ajax({
            url:'PromoPayController',
            type:'get',
            dataType:'json',
            data:{
                total:tongtien,
                ma_nhap:ma
            },
            success:function (data){

                var convert = data.toLocaleString('vi-VN');

                $("#tongcong").text(convert + " VND");
                $('#tongtiensp2').prop("value",data);

            },
            error:function () {
                alert("that bai");
            }
        });



    }

    function pay(){

        var ma = $('#ma_gg').val();
        var ghi_chu = $('#ghichu_sp').val();
        var trang_thai =  $("#phuongthuctt input[type = radio]:checked").val();

        var ma_tinh = $("#loadtinhthanh").val();
        var ma_huyen = $("#loadquanhuyen").val();
        var ma_xa = $("#loadphuongxa").val();

        var tong_tien = $('#tongtiensp2').val();

        console.log(tong_tien);


        // console.log( ma);
        // console.log( ghi_chu);
        // console.log( trang_thai);
        // console.log( ma_tinh);
        // console.log( ma_huyen);
        // console.log( ma_xa);

        document.getElementById("addCartStatus2").style.display = "none";
        document.getElementById('changepassword2').style.transform = 'scaleY(0)';

        if (ma_tinh == "" || ma_huyen == "" || ma_xa ==  "" ){
            document.getElementById("addCartStatus2").style.display = "block";
            document.getElementById('changepassword2').style.transform = 'scaleY(1)';
        }else{

            document.getElementById("addCartStatus").style.display = "none";
            document.getElementById('changepassword').style.transform = 'scaleY(0)';
            $.ajax({
                url:'PayController',
                type:'get',
                dataType:'html',
                data:{
                    ma_gg:ma,
                    trang_thai:trang_thai,
                    ma_tinh:ma_tinh,
                    ma_huyen:ma_huyen,
                    ma_xa:ma_xa,
                    ghi_chu:ghi_chu,
                    tong_tien:tong_tien

                },
                success:function (data){
                    $('#changepasswordsuccess').html(data);

                    document.getElementById("addCartStatus").style.display = "block";
                    document.getElementById('changepassword').style.transform = 'scaleY(1)';

                },
                error:function () {
                    alert(" mua that bai");
                }
            });
        }
    }
    function gobackpassword() {
        document.getElementById('changepassword').style.transform = 'scaleY(0)';
        document.getElementById('changepassword2').style.transform = 'scaleY(0)';
    }

</script>



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