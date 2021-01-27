<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="beans.account.AccountCustomer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.wishlist.Wishlist" %>
<%@ page import="worksWithDatabase.wishlist.LoadWishlistDAO" %>
<%@ page import="model.wishlist.LoadWishlistModel" %>
<%@ page import="beans.wishlist.WishlistToCart" %>
<%@ page import="beans.encode.ConvertPrice" %><%--
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
    <link rel="stylesheet" href="css/wishlist2.css">
    <link rel="stylesheet" href="css/hienthiform.css">
    <link rel="stylesheet" href="css/hienthiform2.css">

    <% AccountCustomer account = (AccountCustomer) session.getAttribute("user");
        ArrayList<Wishlist> list = (ArrayList<Wishlist>) request.getAttribute("list");

    %>


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
    <% int pageNow = Integer.parseInt(request.getParameter("page"));
        int numPage = (int)request.getAttribute("numPage");
        int sumProduct = (int)request.getAttribute("sumProduct");
    %>
    <div class="infor">
        <h3>TVT <span style="color:#ff7315">S</span>hop</h3>
        <p>Tổng: <%=list.size()%> phần tử</p>
        <p>Chế độ xem</p>
        <select name="numberPerPage" class="view">
            <option value="">6 phần tử</option>
            <option value="">12 phần tử</option>
            <option value="">18 phần tử</option>
            <option value="">Tất cả phần tử</option>
        </select>
        <p>Sắp xếp theo</p>
        <select name="type" id="" class="view">
            <option value="">Ngày thêm</option>
            <option value="">Giá</option>
            <option value="">Tên sản phẩm</option>
        </select>
        <div class="search">
            <input type="text" name="search"placeholder="&#xf002; Tìm kiếm" style="font-family:Arial, FontAwesome">
        </div>
    </div>

    <div class="header">
        <label for="cb" class="lbitem">
            <input type="checkbox" id="cb" class="checkbox">
        </label>
        <button ><a href="LoadWishlistController?&page=<%=Integer.parseInt(request.getParameter("page"))%>&search=<%= request.getParameter("search")%>&type=<%= request.getParameter("type")%>&sex=1&status=<%= request.getParameter("status")%>">Nam</a></button>
        <button ><a href="LoadWishlistController?&page=<%=Integer.parseInt(request.getParameter("page"))%>&search=<%= request.getParameter("search")%>&type=<%= request.getParameter("type")%>&sex=0&status=<%= request.getParameter("status")%>">Nữ</a></button>
        <button ><a href="LoadWishlistController?&page=<%=Integer.parseInt(request.getParameter("page"))%>&search=<%= request.getParameter("search")%>&type=<%= request.getParameter("type")%>&sex=<%= Integer.parseInt(request.getParameter("sex"))%>&status=1">Còn hàng</a></button>
        <button ><a href="LoadWishlistController?&page=<%=Integer.parseInt(request.getParameter("page"))%>&search=<%= request.getParameter("search")%>&type=<%= request.getParameter("type")%>&sex=<%=Integer.parseInt(request.getParameter("sex"))%>&status=0">Hết hàng</a></button>
        <div class="selectbutton">
            <button><i class="fa fa-list-alt"></i>Thêm tất cả vào giỏ hàng</button>
            <button><i class="fa fa-shopping-bag"></i>Thêm những lựa chọn vào giỏ hàng</button>
            <button><i class="fa fa-eraser"></i> Xóa những lựa chọn</button>
            <input type="hidden" name = "page" value="1">
        </div>
    </div>

    <div class="titletable">
        <p>HÌNH ẢNH</p>
        <p>TÊN</p>
        <p>GIÁ</p>
        <p>NGÀY THÊM</p>
        <p>TRẠNG THÁI</p>
        <p>SỐ LƯỢNG</p>
        <p style="font-weight: bold">SIZE</p>
<%--        load số trang--%>
        <div>
            <%if (pageNow > 1 && pageNow <= numPage){ %>
            <button><a href="LoadWishlistController?&page=<%=Integer.parseInt(request.getParameter("page")) - 1 %>&search=<%= request.getParameter("search")%>&type=<%= request.getParameter("type")%>&sex=<%=request.getParameter("sex")%>&status=<%= request.getParameter("status")%>"><i class="fa fa-caret-left"></i></a></button>
            <% } else {%>
            <button><i class="fa fa-caret-left"></i></button>
            <%}%>
            <ul>
                <% for(int i = 1; i <= numPage; i++){
                    if(i == pageNow){
                %>
                <li style="background-color: #FF9751"><a href=""><%=i%></a></li>
                <% } else {%>
                <li ><a href="LoadWishlistController?page=<%=i%>&search=<%= request.getParameter("search")%>&type=<%= request.getParameter("type")%>&sex=<%=request.getParameter("sex")%>&status=<%= request.getParameter("status")%>"><%=i%></a></li>
                <%}}%>
            </ul>
            <%if (pageNow >= 1 && pageNow < numPage){ %>
            <button><a href="LoadWishlistController?&page=<%=Integer.parseInt(request.getParameter("page")) + 1 %>&search=<%= request.getParameter("search")%>&type=<%= request.getParameter("type")%>&sex=<%=request.getParameter("sex")%>&status=<%= request.getParameter("status")%>"><i class="fa fa-caret-right"></i></a></button>
            <% } else {%>
            <button><i class="fa fa-caret-right"></i></button>
            <%}%>
        </div>
    </div>

<%--    <% ArrayList<WishlistToCart> ws = new ArrayList<WishlistToCart>();--%>
<%--    %>--%>
<%--    --%>
   <% if(list.size() == 0){%>
    <p style="
    width: 550px;
    height: 35px;
    background-color: white;
    margin: auto;
    margin-top: 40px;
    line-height: 35px;
    text-align: center;
    border-radius: 5px;
">Không tìm thấy sản phẩm nào trong danh sách yêu thích.</p>
   <% } else {%>
<%--    load danh sách wishlist--%>
    <%
        int count= 0;

        for(Wishlist w : list){

        count++;
    %>
    <div class="item">

        <label for="cb1" class="lbitem">
            <input type="checkbox" id="cb1" name="cb1" class="checkbox" value="">
            <input name ="idC" type="hidden">
        </label>
        <a href="detailsProduct.html" class="imgsp"> <img src="<%=w.getHinh_sp()%>>" alt=""> </a>
        <a href="detailsProduct.html" class="namesp"><%= w.getTen_sp()%> </a>
        <p id="gia_<%=count%>">


            <!--------- hiển thị giá khuyến mãi -------->
            <% if(w.getGia_km() != 0){ %>

            <%=ConvertPrice.convertPrice((int)w.getGia_km())%>

            <%}else {%>

            <%=ConvertPrice.convertPrice((int)w.getGia())%>

            <%}%>
            <!--------- hiển thị giá khuyến mãi -------->



        </p>
        <p class="ngaythem"><%=w.getNgay_them().getDay()%>/<%=w.getNgay_them().getMonth()%>/<%=w.getNgay_them().getYear()%></p>
        <% if(w.getTrang_thai() != 2){%>
        <p class="conhang">Còn hàng</p>
        <%} else{%>
        <p class="conhang" style="background-color: #d74410; color : white !important">Hết hàng</p>
        <%}%>
        <div class="soluong">


            <p id="so_luong_sp_<%=count%>"><%=w.getSo_luong()%></p>

            <button id="tang" value="<%=count%>" onclick="increase(this)">+

                <input type="hidden" value="<%=w.getMa_sp()%>" disabled>
                <input type="hidden" value="<%=w.getMa_mau()%>" disabled>
                <input type="hidden" value="<%=w.getMa_size()%>" disabled>

            </button>
<%--            <input type="text" value="1" class="sladdtocard">--%>
            <button id="giam" value="<%=count%>" onclick="increase(this)">-
                <input type="hidden" value="<%=w.getMa_sp()%>" disabled>
                <input type="hidden" value="<%=w.getMa_mau()%>" disabled>
                <input type="hidden" value="<%=w.getMa_size()%>" disabled>
            </button>
        </div>
        <p style="margin-left: 132px"><%=w.getSize()%></p>
<%--        AddCartController?ma_sp=<%=w.getId()%>&ma_mau=<%=w.getColor()%>&ma_size=<%=w.getSize()%>&so_luong=<%=w.getQuantity()%>--%>
        <a href="#">
            <button class="addtocart" onclick="addCart(this)">

                <input type="hidden" name="" id="laymau" value="<%=w.getMa_mau()%>">
                <input type="hidden" name="" id="laysize" value="<%=w.getMa_size()%>">
                <input type="hidden" name="" id="laymasp" value="<%=w.getMa_sp()%>">
                <input type="hidden" name="" id="laysoluong" value="<%=w.getSo_luong()%>">

            <i class="fa fa-shopping-cart"></i>
            Thêm vào giỏ hàng</button>
        </a>

        <div class="remove">
            <a href="RemoveWishlistController?ma_sp=<%=w.getMa_sp()%>&ma_mau=<%=w.getMa_sp()%>&size=<%=w.getSize()%>&page=<%= request.getParameter("page")%>&search=<%=request.getParameter("search")%>&type=<%=request.getParameter("type")%>&sex=<%=request.getParameter("sex")%>&status=<%=request.getParameter("status")%>"><i class="fa fa-close"></i></a>
        </div>
    </div>
    <%}}%>

</div>


<div id="addCartStatus2" style="display:none; z-index: 100000;position: relative">
    <div class="changepassword" id="changepassword2">
        <div class="hiddenchangepassword" onclick="gobackpassword()"></div>
        <div class="mainchangepassword">
            <p class="changepasswordtitle"><i class="fa fa-cogs"></i>TVT Shop</p>
            <div class="changepasswordsuccess" id="changepasswordsuccess2">
                <p> Vui lòng chọn đầy đủ thông tin để thêm sản phẩm vào giỏ hàng </p>
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
            <div class="changepasswordsuccess" id="changepasswordsuccess">


            </div>
        </div>
    </div>
</div>


<input type="hidden" name="" id="soluongsp" value="1">
<%--</script>--%>
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


<script>
    function increase(event) {

        var list = event.children;

        var ma_sp = $(list[0]).attr("value");
        var ma_mau =  $(list[1]).attr("value");
        var ma_size = $(list[2]).attr("value");
        console.log(ma_sp);
        console.log(ma_mau);
        console.log(ma_size);

        var active = $(event).attr("id");

        $.ajax({
            url:'ChangeWishlistController',
            type:'get',
            dataType:'json',
            data:{
                ma_sp:ma_sp,
                ma_mau:ma_mau,
                ma_size: ma_size,
                active: active
            },
            success:function (data){

                console.log(data);

                var c = $(event).val();
                <!-- sét lại số lượng và giá-->

                var sltrcthaydoi = parseInt($('#so_luong_sp_' + c).text()) ;

                console.log("soluongtrcthaydoi"+sltrcthaydoi);
                console.log(data.so_luong);


                var slsauthaydoi = data.so_luong;

                // var total = $('#getgia').val();

               // var tonggia = parseInt(total);
                var giamoi;

                if(slsauthaydoi > sltrcthaydoi){
                    // nếu số lượng trc thay đổi lơn hơn số lượng sau thay đổi thì + 1 cho tổng số lương thôi
                    //document.getElementById("so_luong_right").innerText = tongsl + 1;

                    //sét lại giá nếu có khuyến mãi thì sét theo giá khuyến mãi
                    if(data.gia_km > 0){
                       // giamoi  = tonggia + data.gia_km/data.so_luong;
                        document.getElementById("gia_"+c).innerText = data.gia_km.toLocaleString("vi-VN") + " VND";
                    }else{
                      //  giamoi  = tonggia + data.gia/data.so_luong;
                        document.getElementById("gia_"+c).innerText = data.gia.toLocaleString("vi-VN") + " VND";
                    }

                }else if(slsauthaydoi < sltrcthaydoi){
                    // nếu số lượng trc thay đổi nhỏ hơn số lượng sau thay đổi thì - 1 cho tổng số lương thôi
                    //document.getElementById("so_luong_right").innerText = tongsl - 1;
                    //sét lại giá nếu có khuyến mãi thì sét theo giá khuyến mãi
                    if(data.gia_km > 0){
                        //giamoi  = tonggia - data.gia_km/data.so_luong;
                        document.getElementById("gia_"+c).innerText = data.gia_km.toLocaleString("vi-VN") + " VND";
                    }else{
                       // giamoi  = tonggia - data.gia/data.so_luong;
                        document.getElementById("gia_"+c).innerText = data.gia.toLocaleString("vi-VN") + " VND";
                    }}
                // }else{
                //     giamoi = tonggia;
                // }

                // sét lại số lượng cho thằng sản phẩm đã
                document.getElementById("so_luong_sp_"+c).innerText = data.so_luong;

               // var convert = giamoi.toLocaleString('vi-VN');

               // document.getElementById("total_all_1").innerText = convert + " VND";
               // document.getElementById("total_all_2").innerText = convert+ " VND";
               // $('#getgia').prop("value",giamoi);
            },
            error:function () {
                alert("that bai");
            }
        });

    }

    function addCart(event){

        var list = event.children;
        console.log(list);

        var ma_sp = $(list[2]).val();
        var ma_size =  $(list[1]).val();
        var ma_mau = $(list[0]).val();
        var soluong = $(list[3]).val();

        console.log(ma_mau);
        console.log(ma_size);
        console.log(ma_sp);
        console.log(soluong);


        // console.log(ma_sp);
        // console.log(ma_size);
        // console.log(ma_mau);
        // console.log(soluong);
        // document.getElementById("addCartStatus2").style.display = "none";
        // document.getElementById('changepassword2').style.transform = 'scaleY(0)';

        // if(ma_sp == "" || ma_size == "" || ma_mau == ""){
        //
        //     document.getElementById("addCartStatus2").style.display = "block";
        //     document.getElementById('changepassword2').style.transform = 'scaleY(1)';
        //
        // }else{
            document.getElementById("addCartStatus").style.display = "none";
            document.getElementById('changepassword').style.transform = 'scaleY(0)';
            $.ajax({
                url:'AddCartController',
                type:'get',
                dataType:'html',
                data:{
                    ma_sp:ma_sp,
                    ma_mau:ma_mau,
                    ma_size:ma_size,
                    so_luong:soluong
                },
                success:function (data){
                    //console.log(data);
                    $('#changepasswordsuccess').html(data);

                    document.getElementById("addCartStatus").style.display = "block";
                    document.getElementById('changepassword').style.transform = 'scaleY(1)';

                },
                error:function () {
                    alert(" them sp that bai");
                    // window.location.href = 'index.jsp';
                }
            });

        // }
    }

    function plustocard() {
        var n = $(".sladdtocard").val();
        const nn = Number(n);
        $(".sladdtocard").prop("value",nn+1);
        $("#soluongsp").prop("value",nn+1);
    }

    function subtocard() {
        var n = $(".sladdtocard").val();
        const nn = Number(n);
        if (nn > 1) {
            $(".sladdtocard").prop("value",nn-1);
            $("#soluongsp").prop("value",nn-1);
        }
    }

    function gobackpassword() {
        document.getElementById('changepassword').style.transform = 'scaleY(0)';
        document.getElementById('changepassword2').style.transform = 'scaleY(0)';
    }

</script>
